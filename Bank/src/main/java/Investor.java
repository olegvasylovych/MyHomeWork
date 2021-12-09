public class Investor extends Human{
    private int haveMoney;

    public Investor(){
        this.name="";
        this.age=0;
        this.haveMoney=0;
    }

    public Investor(String name, int age, int haveMoney){
        this.name=name;
        this.age=age;
        this.haveMoney=haveMoney;
    }
}
