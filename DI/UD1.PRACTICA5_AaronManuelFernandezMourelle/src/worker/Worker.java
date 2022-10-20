package worker;

public class Worker {
    
    private String id;
    private String name;
    private String surnameOne;
    private String surnameTwo;
    private String province;
    private String profession;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Worker(String id, String name, String surnameOne, String surnameTwo, String province, String profession) {
        this.id = id;
        this.name = name;
        this.surnameOne = surnameOne;
        this.surnameTwo = surnameTwo;
        this.province = province;
        this.profession = profession;
    }

    public Worker(String id, String name, String surnameOne, String surnameTwo) {
        this.id = id;
        this.name = name;
        this.surnameOne = surnameOne;
        this.surnameTwo = surnameTwo;
    }

    public Worker() {
    }

    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the surnameOne
     */
    public String getSurnameOne() {
        return surnameOne;
    }

    /**
     * @return the surnameTwo
     */
    public String getSurnameTwo() {
        return surnameTwo;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @return the profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param surnameOne the surnameOne to set
     */
    public void setSurnameOne(String surnameOne) {
        this.surnameOne = surnameOne;
    }

    /**
     * @param surnameTwo the surnameTwo to set
     */
    public void setSurnameTwo(String surnameTwo) {
        this.surnameTwo = surnameTwo;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Information methods">
    @Override
    public String toString() {
        return name + " " + surnameOne + " "+ surnameTwo;
    }

    public String toStringFormatted() {
        return """
               DATOS DO TRABALLADOR:
               DNI: %s
               NOME: %s
               APELIDO 1: %s
               APELIDO 2: %s
               PROVINCIA: %s
               PROFESION: %s
               """.formatted(id, name, surnameOne, surnameTwo, province, profession);
    }
    //</editor-fold>
    /**
     * TODO: Any remaining working methods.
     */
}
