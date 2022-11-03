package FileInputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EJ4_11_ReadWriteCars {

    private static record Car(String marca, String modelo, Double precio) implements Serializable {

        @Override
        public String toString() {
            return "Marca: " + marca + " - Modelo: " + modelo + " Precio: " + precio + "€";
        }
    }

    public static void main(String[] args) {
        File fileToWrite = new File("C:\\Users\\AaronFM\\Desktop\\ACCESO_A_DATOS\\Coches.dat");
        List<Car> cars = List.of(
                new Car("Marca1", "1", 2.11),
                new Car("Marca3", "1", 1.99),
                new Car("Marca2", "1", 1.99),
                new Car("Marca13", "1", 3.11)
        );

        writeCarsToFile(cars, fileToWrite);

        readCarsFromFile(fileToWrite)
                .ifPresentOrElse((newCarList) -> {
                    /**
                     * Dos maneras con prácticas diferentes: Ordenado de forma
                     * permanente:
                     */
                    System.err.println("Utilizando .sort y sout normal: Ordeno de forma definitiva.");
                    newCarList.sort((car1, car2) -> car1.precio().compareTo(car2.precio()));
                    newCarList.forEach(System.out::println);
                    /**
                     * Ordenado solo para su visualización: Incluyo llamada a
                     * método de clase en vez de lambda para especificar. Tras
                     * especificar el .comparing() se puede utilizar el
                     * .reversed() Resultando en lo siguiente:
                     * Coleccion.stream()
                     * .sorted(Comparator.comparing(Clase::Getter/Propiedad)
                     * .reversed().operacionesPosteriores()...
                     */
                    System.err.println("Utilizando stream y sorted: Ordeno para su impresión, no de forma definitiva.");
                    newCarList.stream()
                            .sorted(Comparator.comparing(Car::precio)
                                    .thenComparing(Car::marca)
                                    .reversed())
                            .forEach(System.out::println);
                },
                        () -> System.out.println("Hubo un problema al recuperar los coches o no hay datos."));

    }

    private static Optional<List<Car>> readCarsFromFile(File fileToWrite) {
        List<Car> carList = null;
        try ( ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fileToWrite))) {
            carList = new ArrayList<>();
            Object objectToRead;
            /**
             * Available no es fiable. Utilizamos bucle infinito (for(;;) o
             * while(true))
             */
            for (;;) {
                objectToRead = objIn.readObject();
                if (objectToRead instanceof Car car) {
                    carList.add(car);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            if (ex.getClass().getTypeName().contains("EOF")) {
                System.err.println('[' + ex.getClass().getTypeName() + "]: End of file.");
            }
        }
        return Optional.ofNullable(carList);
    }

    private static void writeCarsToFile(List<Car> cars, File fileToWrite) {
        try ( ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(fileToWrite))) {
            for (Car car : cars) {
                objOut.writeObject(car);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());

        }
    }
}
