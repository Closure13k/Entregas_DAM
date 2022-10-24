/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package worker;

public class Worker {

    private String name;
    private String surname;
    private WorkerLevel level;
    private Location location;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Worker(String name, String surname, WorkerLevel level, Location location) {
        this.name = name;
        this.surname = surname;
        this.level = level;
        this.location = location;
    }

    public Worker(String name, String surname, WorkerLevel level) {
        this.name = name;
        this.surname = surname;
        this.level = level;
    }

    public Worker() {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters, Setters & toString">
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Information methods">
    @Override
    public String toString() {
        return translateLevel() + ": " + name + " " + surname;
    }

    public String translateLevel() {
        return switch (this.level) {
            case BOSS ->
                "JEFE";
            case FIRST_OFFICER ->
                "PRIMER OFICIAL";
            case SECOND_OFFICER ->
                "SEGUNDO OFICIAL";
        };
    }
//</editor-fold>

    public static class WorkerException extends Exception {

        public WorkerException(String message) {
            super(message);
        }
    }

}
