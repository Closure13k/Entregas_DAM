/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RandomAccessFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author AaronFM
 */
public class Examples {

    private static final String RUTA = "C:\\Users\\AaronFM\\Desktop\\ACCESO_A_DATOS\\nuevo.dat";

    public static void main(String[] args) {
        escritura();
        lectura();
    }

    public static void lectura() {
        File ficheiro = new File(RUTA);
        try ( RandomAccessFile fich = new RandomAccessFile(ficheiro, "r");) {
            int id, dep, pos;
            double sal;
            char apelido[] = new char[10];
            int desprazamento = Integer.BYTES * 2 + Character.BYTES * 10 + Double.BYTES; //Calculamos o que ocupa cada rexistro do ficheiro
            //para siturarnos ao principio
            
            for (pos = 0; pos < fich.length(); pos += desprazamento) { //recoremos o ficheiro
                fich.seek(pos);  //posicionamos o punteiro en pos
                id = fich.readInt(); //lemos id de empregado;
                //percorremos un a un os caracteres do apelido
                for (int i = 0; i < apelido.length; i++) {
                    apelido[i] = fich.readChar();  //imos gardando os caracteres lidos no array apelido
                }
                String apellido = new String(apelido);
                dep = fich.readInt();
                sal = fich.readDouble();
                if (id > 0) //A posición ten un empregado dado de alta e visualizamos os datos
                {
                    System.out.printf("ID: %d, Apelido: %s, Departamento: %d, Salario: %.2f %n",
                            id, apellido.trim(), dep, sal);
                }
                if (fich.getFilePointer() == fich.length()) {
                    break;//se chegamos ao final saímos do for
                }
            }   //fin for 

        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro non atopado");
        } catch (IOException e) {
            System.out.println("Erro E/S");
        }
    }

    public static void escritura(String[] args) {
        File ficheiro = new File(RUTA);
        try ( RandomAccessFile fich = new RandomAccessFile(ficheiro, "rw");) {

            //recollemos os datos dos argumentos da main
            if (args.length != 4) {
                System.out.println("Erro no paso de parámetros: id,apelido, departamento, salario");
            } else {
                int id = Integer.valueOf(args[0]);
                String apelido = args[1];
                int dep = Integer.valueOf(args[2]);
                double sal = Double.valueOf(args[3]);

                int desprazamento = Integer.BYTES * 2 + Character.BYTES * 10 + Double.BYTES; //Calculamos o que ocupa cada rexistro do ficheiro
                int pos = desprazamento * (id - 1);
                fich.seek(pos);
                StringBuffer buffer = null;//para almacenar apelido
                fich.writeInt(id);  //uso de i+1 para identificar ao empregado
                //para almacenar apelido con 10 caracteres
                buffer = new StringBuffer(apelido);
                buffer.setLength(10);   //10 caracteres para o apelido
                fich.writeChars(buffer.toString());

                fich.writeInt(dep);
                fich.writeDouble(sal);

            }

        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro non atopado");
        } catch (IOException e) {
            System.out.println("Erro E/S");
        }
    }

    public static void escritura() {
        File ficheiro = new File(RUTA);
        try ( RandomAccessFile fich = new RandomAccessFile(ficheiro, "rw");) {

            //arays de datos
            String apelido[] = {"FERNANDEZ", "LOPEZ"};
            int departamento[] = {10, 20};
            double salario[] = {1000.50, 2000};

            StringBuffer buffer = null;//para almacenar apelido

            int n = apelido.length; //número de empregados

            for (int i = 0; i < n; i++) {
                fich.writeInt(i + 1);  //uso de i+1 para identificar ao empregado
                //para almacenar apelido con 10 caracteres
                buffer = new StringBuffer(apelido[i]);
                buffer.setLength(10);   //10 caracteres para o apelido
                fich.writeChars(buffer.toString());

                fich.writeInt(departamento[i]);
                fich.writeDouble(salario[i]);

            }

        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro non atopado");
        } catch (IOException e) {
            System.out.println("Erro E/S");
        }
    }
}
