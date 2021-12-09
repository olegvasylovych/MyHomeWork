public enum Cards {
    GOLD_CARD("Gold card"),
    CREDIT_CARD("Credit card"),
    DEBIT_CARD("Debit card");


    private String title;

    Cards(){
        this.title="";
    }
    Cards(String title) {
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
