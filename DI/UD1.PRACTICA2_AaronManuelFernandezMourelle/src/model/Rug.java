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

    public Rug(String name, String color, String width, String height) throws RugException {
        if (name.isBlank()) {
            throw new RugException("El nombre no puede estar vacío.");
        }
        this.name = name;
        if (color.isBlank()) {
            throw new RugException("El color no puede estar vacío.");
        }
        this.color = color;
        try {
            this.width = Double.parseDouble(width);
            this.height = Double.parseDouble(height);

        } catch (NumberFormatException nfex) {
            throw new RugException("Los campos ancho y alto han de ser números decimales (separados por '.').");
        }
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
