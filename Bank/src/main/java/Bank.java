import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import org.apache.log4j.Logger;

public final class Bank {
    private String capital, bankName;
    protected int clientsCount;
    protected ArrayList<String> storagesAddress;
    private static final Logger LOGGER = Logger.getLogger(Bank.class);

    public Bank(){
        bankName = " ";
        capital = "";
        clientsCount = 0;
    }

    public Bank(String bankName, String capital, int clientsCount){
        this.bankName=bankName;
        this.capital=capital;
        this.clientsCount=clientsCount;
    }

    public void setBankName(String bankName){
        this.bankName=bankName;
    }

    public void setCapital(String capital){
        this.capital=capital;
    }

    public void setClientsCount(int clientsCount){
        this.clientsCount=clientsCount;
    }

    public String getBankName(){
        return bankName;
    }

    public String getCapital(){
        return capital;
    }

    public int getClientsCount(){
        return clientsCount;
    }

    public void setStoragesAddress(){
        LOGGER.info("Enter storage's address:");
        while (true){
            Scanner scanner = new Scanner(System.in);
            String address = scanner.nextLine();
            this.storagesAddress.add(address);
            LOGGER.info("Do you want add new storage?(yes/no)");
            String answer = scanner.nextLine();
            if(answer.equals("no")){
                break;
            }
        }
    }

    public ArrayList<String> getStoragesAddress(){
        return storagesAddress;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", capital=" + capital +
                ", clientsCount=" + clientsCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return capital == bank.capital &&
                clientsCount == bank.clientsCount &&
                Objects.equals(bankName, bank.bankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, capital, clientsCount);
    }
}
