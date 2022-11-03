/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileModification.CarFiles;

import java.io.Serializable;

public class Car implements Serializable {

    private String brand;
    private String model;
    private Float price;

    public Car(String brand, String model, String price) throws CarDataException {
        if (brand.isBlank() | model.isBlank() | price.isBlank()) {
            throw new CarDataException("Los campos no pueden estar vacíos.");
        }
        try {
            this.brand = brand;
            this.model = model;
            this.price = Float.parseFloat(price);
        } catch (NumberFormatException nfex) {
            throw new CarDataException("El precio debe de seguir el formato '0.00'");
        }
    }

    public Car(String brand, String model, Float price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Float getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "b: " + brand + ", md: " + model + ", p: " + price + '€';
    }

}
