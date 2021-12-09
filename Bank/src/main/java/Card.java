import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public final class Card {
    protected String cardType;
    protected Calendar expirationDate;
    protected String cardNumber, cvv;
    private static final Logger LOGGER = Logger.getLogger(Card.class);

    public Card(){
        this.cardType="";
        this.expirationDate=new GregorianCalendar(1970,0,0);
        this.cardNumber="";
        this.cvv="";
    }

    public Card(String cardType, GregorianCalendar expirationDate, String cardNumber,
                String cvv) throws Exception {
        this.cardType=cardType;
        this.expirationDate=expirationDate;
        if(cardNumber.length()==16) {
            this.cardNumber = cardNumber;
        } else {
            throw new Exception("You entered wrong card number!!!");
        }
        if(cvv.length()==3) {
            this.cvv = cvv;
        } else {
            throw new Exception("You entered wrong cvv number!!!");
        }
    }

    public void setAllFields(String cardNumber, String cvv, GregorianCalendar expirationDate) throws Exception{
        LOGGER.info("Available card type:");
        Stream.of(Cards.values()).map(cards -> cards.ordinal()+1+
                ": "+cards.getTitle()+";").forEach(LOGGER::info);//використання Stream
        LOGGER.info("Enter number");
        Scanner scanner = new Scanner(System.in);
        int enteredNumber = scanner.nextInt();
        switch (enteredNumber){
            case 1:
                this.cardType=String.valueOf(Cards.GOLD_CARD.getTitle());
                break;
            case 2:
                this.cardType=String.valueOf(Cards.DEBIT_CARD.getTitle());
                break;
            case 3:
                this.cardType=String.valueOf(Cards.CREDIT_CARD.getTitle());
                break;
            default:
                throw new Exception("WRONG NUMBER. Only 1,2,3!!!");
        }

        if(cardNumber.length()==16) {
            this.cardNumber = cardNumber;
        } else {
            throw new Exception("You entered wrong card number!!!");
        }

        if(cvv.length()==3) {
            this.cvv = cvv;
        } else {
            throw new Exception("You entered wrong cvv number!!!");
        }

        this.expirationDate=expirationDate;
    }

    public void setCardType() throws Exception {
        LOGGER.info("Available card:");
        Stream.of(Cards.values()).map(cards -> cards.ordinal()+1+
                ": "+cards.getTitle()+";").forEach(LOGGER::info);
        LOGGER.info("Enter number");
        Scanner scanner = new Scanner(System.in);
        int enteredNumber = scanner.nextInt();
        switch (enteredNumber){
            case 1:
                this.cardType=String.valueOf(Cards.GOLD_CARD.getTitle());
                break;
            case 2:
                this.cardType=String.valueOf(Cards.DEBIT_CARD.getTitle());
                break;
            case 3:
                this.cardType=String.valueOf(Cards.CREDIT_CARD.getTitle());
                break;
            default:
                throw new Exception("WRONG NUMBER. Only 1,2,3!!!");
        }
    }

    public void setExpirationDate(GregorianCalendar expirationDate){
        this.expirationDate=expirationDate;
    }

    public void setCardNumber(String cardNumber) throws Exception {
        if(cardNumber.length()==16) {
            this.cardNumber = cardNumber;
        } else {
            throw new Exception("You entered wrong card number!!!");
        }
    }

    public void setCvv(String cvv) throws Exception{
        if(cvv.length()==3) {
            this.cvv = cvv;
        } else {
            throw new Exception("You entered wrong cvv number!!!");
        }
    }

    public String getCardType(){
        return this.cardType.toString();
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public String getCvv(){
        return cvv;
    }

    public Calendar getExpirationDate(){
        return expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardType, card.cardType) &&
                Objects.equals(expirationDate, card.expirationDate) &&
                Objects.equals(cardNumber, card.cardNumber) &&
                Objects.equals(cvv, card.cvv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, expirationDate, cardNumber, cvv);
    }

    @Override
    public String toString() {
        return "Card info:\n" +
                "cardType=" + cardType + ".\n" +
                "expirationDate=" + expirationDate.getTime() +".\n"+
                "cardNumber=" + cardNumber + ".\n" +
                "cvv=" + cvv + ".\n";
    }
}
