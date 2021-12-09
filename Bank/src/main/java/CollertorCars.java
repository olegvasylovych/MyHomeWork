public enum CollertorCars {

    CRAFTER("Volkswagen Crafter"),
    SPRINTER("Mercedes-Benz Sprinter"),
    TRANSPORTER("Volkswagen Transporter");


    private String title;

    CollertorCars(){
        this.title="";
    }
    CollertorCars(String title) {
        this.title = title;
    }

    public String getTitle(){
        return  title;
    }

    @Override
    public String toString() {
        return title;
    }
}
