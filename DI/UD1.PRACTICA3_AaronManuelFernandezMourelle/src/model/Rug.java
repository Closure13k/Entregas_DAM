package model;

public class Rug {

    private String name;
    private String color;
    private double width;
    private double height;

    public Rug() {
    }

    public Rug(String name, String color, double width, double height) {
        this.name = name;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    /**
     * En este caso controlo desde RugValidator.
     *
     * @param name
     * @param color
     * @param width
     * @param height
     */
    public Rug(String name, String color, String width, String height) {
        this.name = name;
        this.color = color;
        this.width = Double.valueOf(width);
        this.height = Double.valueOf(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "MODELO: " + name + " - Cor: " + color;
    }

    public String fullInfoToString() {
        return "MODELO: " + name + "\nCOLOR: " + color + "\nAncho: " + width + "\nAlto: " + height;
    }
}
