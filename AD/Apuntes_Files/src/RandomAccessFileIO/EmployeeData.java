package RandomAccessFileIO;

import java.io.File;

public class EmployeeData {

    public static final int SURNAME_SIZE = 10;
    public static final int SURNAME_BYTES = Character.BYTES * SURNAME_SIZE;
    public static final int DATA_SIZE = Integer.BYTES * 2 + SURNAME_BYTES + Double.BYTES;
    public static final String PATH = "C:\\Users\\AaronFM\\Desktop\\ACCESO_A_DATOS\\nuevo.dat";

    String surname;
    int dept;
    double salary;

    public EmployeeData(char[] surname, int dept, double salary) {
        this.surname = new String(surname);
        this.dept = dept;
        this.salary = salary;
    }

    public EmployeeData(String surname, int dept, double salary) {
        this.surname = surname;
        this.dept = dept;
        this.salary = salary;
    }

    public EmployeeData() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.surname + " dept: " + this.dept + " sal: " + this.salary;
    }

    public static File getData() {
        return new File(PATH);
    }
   
    /**
     * Suponiendo que se comienza en cero, devuelve el número de bytes que deberá de saltarse el puntero para alcanzar el atributo buscado.
     * @param id
     * @param property
     * @return
     * @throws RandomAccessFileIO.EmployeeData.EmployeeDataException 
     */
    public static int getSizeToReach(int id, String property) throws EmployeeDataException {
        int position;
        switch (property.toLowerCase()) {
            case "salary" -> {
                position = ((id - 1) * EmployeeData.DATA_SIZE) + (DATA_SIZE - Double.BYTES);
            }
            case "surname" -> {
                position = ((id - 1) * EmployeeData.DATA_SIZE) + Integer.BYTES;
            }
            case "dept" -> {
                position = ((id - 1) * EmployeeData.DATA_SIZE) + (DATA_SIZE - (Double.BYTES + Integer.BYTES));
            }
            default -> {
                position = 0;
            }
        }
        if (position == 0) {
            throw new EmployeeDataException("Invalid property.");
        }
        return position;
    }
    /**
     * Devuelve la posición que se espera del puntero en base al ID del empleado.
     * @param id
     * @return
     * @throws RandomAccessFileIO.EmployeeData.EmployeeDataException 
     */
    public static int getByID(int id) throws EmployeeDataException{
        if(id <= 0){
            throw new EmployeeDataException("ID must be positive and greater than 0.");
        }
        return (id-1) * DATA_SIZE;
    }

    public static class EmployeeDataException extends Exception {

        public EmployeeDataException(String message) {
            super(message);
        }

    }
}
