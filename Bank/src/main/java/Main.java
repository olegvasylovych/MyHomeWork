import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        Bank privatBank=new Bank("PrivatBank","45729587239",123);
        Client client = new Client("Vlad",22,17000);
        ArrayList<Cashier> listOfCashiers=new ArrayList<Cashier>();
        String[] cashiersNames = {"Vlad","Oksana","Oleg","Kolya","Dima","Yana"};
        for(int i=0; i<5;i++){
            listOfCashiers.add(new Cashier(cashiersNames[RandomUtils.nextInt(0,cashiersNames.length)]));// використання RandomUtils
        }

        client.takeACredit(250000,3,listOfCashiers.get(0).getName(),privatBank.getBankName());

        Card cardGold = new Card(Cards.GOLD_CARD.getTitle(),new GregorianCalendar(2024,2,23),
                "1234567890123456","888");
        LOGGER.info(cardGold.toString());

        Client emptyNameClient = new Client();
        LOGGER.info(emptyNameClient.getName());

    }
}
