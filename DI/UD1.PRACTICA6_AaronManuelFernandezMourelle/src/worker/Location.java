package worker;

public class Location {
    private String name;

    public Location(String name) throws LocationException {
        if(name.isBlank()){
            throw new LocationException("El campo de texto está vacío.");
        }
        this.name = name;
    }

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LOCALIDAD: "+ name;
    }

    public static class LocationException extends Exception {

        public LocationException(String message){
            super(message);
        }
    }
     
}
