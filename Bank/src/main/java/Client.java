import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class Client extends Human implements ITakeACredit{
    protected Card card;
    protected int salaryPerMonth;
    private static final Logger LOGGER = Logger.getLogger(Client.class);

    public Client(){
        name="";
        age=0;
        card=new Card();
        salaryPerMonth=0;
    }

    public Client(String name, int age, int salaryPerMonth){
        this.name=name;
        this.age=age;
        this.salaryPerMonth=salaryPerMonth;
    }

    public String getName(){
        boolean isEmpty = StringUtils.isEmpty(this.name);//використання StringUtils
        if(isEmpty){
            LOGGER.debug("Name is empty!");
        }
        return name;
    }
    public void setCard(String cardNumber, String cvv, GregorianCalendar expirationDate) throws Exception {
        this.card.setAllFields(cardNumber, cvv, expirationDate);
    }

    public void setSalaryPerMonth(int salaryPerMonth){
        this.salaryPerMonth=salaryPerMonth;
    }

    @Override
    public String toString() {
        return "Client{" +
                "card='" + card + '\'' +
                ", salaryPerMonth=" + salaryPerMonth +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return salaryPerMonth == client.salaryPerMonth &&
                Objects.equals(card, client.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), card, salaryPerMonth);
    }

    @Override
    public void takeACredit(int loanAmount, int time, String cashierName, String bankName) {
        IRequiredSalaryForCredit calculateRequired = new IRequiredSalaryForCredit() { //Лямбда фукнція
            @Override
            public int calculateRequiredSalary(int loanAmount, int years) {
                int required = (loanAmount/(years*2))/2;
                return required;
            }
        };
        int requiredSalaryForCredit=calculateRequired.calculateRequiredSalary(loanAmount,time);
        boolean creditPermit=false;
        if(this.salaryPerMonth<requiredSalaryForCredit){
            creditPermit=false;
        } else {
            creditPermit=true;
        }

        Predicate<Integer> youngerThan18 = x -> x < 18;//функціональні інтерфейси.Predicate<T>

        if(youngerThan18.test(this.age)){
            creditPermit=false;
        }

        LOGGER.info("Name is "+this.name+".\n"+
                "Credit amount is "+loanAmount+".\n"+
                "Term- "+time+" years.\n"+
                "Required salary per month is "+requiredSalaryForCredit+".\n"+
                "Client's salary per month is "+this.salaryPerMonth+".\n"+
                "Credit approved: "+creditPermit+".\n"+
                "Cashier name is "+cashierName+".\n"+
                "Bank name is "+bankName+".\n");
    }
}
