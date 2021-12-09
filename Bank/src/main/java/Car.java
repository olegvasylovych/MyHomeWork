import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class Car {
    protected String model;
    protected int protectionLevel;
    protected float volume;

    private static final Logger LOGGER = Logger.getLogger(Client.class);

    public Car(){
        this.model="";
        this.protectionLevel=0;
        this.volume=0;
    }

    public Car(String model, int protectionLevel, float volume){
        this.model=model;
        this.protectionLevel=protectionLevel;
        this.volume=volume;
    }

    public void setModel() throws Exception {
        LOGGER.info("Available cars:");
        Stream.of(CollertorCars.values()).map(collectorCars -> collectorCars.ordinal()+1+
                ": "+collectorCars.getTitle()+";").forEach(LOGGER::info);
        LOGGER.info("Enter number");
        Scanner scanner = new Scanner(System.in);
        int enteredNumber = scanner.nextInt();
        switch (enteredNumber){
            case 1:
                this.model=String.valueOf(CollertorCars.CRAFTER.getTitle());
                break;
            case 2:
                this.model=String.valueOf(CollertorCars.SPRINTER.getTitle());
                break;
            case 3:
                this.model=String.valueOf(CollertorCars.TRANSPORTER.getTitle());
                break;
            default:
                throw new Exception("WRONG NUMBER. Only 1,2,3!!!");
        }
    }

    public void setProtectionLevel(int protectionLevel){
        this.protectionLevel=protectionLevel;
    }

    public void setVolume(float volume){
        this.volume=volume;
    }

    public String getModel(){
        return model;
    }

    public int getProtectionLevel(){
        return protectionLevel;
    }

    public float getVolume(){
        return volume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return protectionLevel == car.protectionLevel &&
                Float.compare(car.volume, volume) == 0 &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, protectionLevel, volume);
    }
}
