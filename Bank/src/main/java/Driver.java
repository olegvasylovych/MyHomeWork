import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class Driver extends Human implements IDriving {
    private Car car;
    private int drivingExperience;
    private static final Logger LOGGER = Logger.getLogger(Driver.class);

    public Driver(){
        name="";
        age=0;
        car = new Car();
        drivingExperience=0;
    }

    public Driver(String name, int age, int drivingExperience){
        this.name=name;
        this.age=age;
        this.drivingExperience=drivingExperience;
    }

    public void setCar() throws Exception {
        car.setModel();
    }

    public void setDrivingExperience(int drivingExperience){
        this.drivingExperience=drivingExperience;
    }

    public Car getCar(){
        return car;
    }

    public int getDrivingExperience(){
        return drivingExperience;
    }

    @Override
    public void drivingCar() {
        LOGGER.info(this.name+" is driving the "+this.car);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "car='" + car + '\'' +
                ", drivingExperience=" + drivingExperience +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return drivingExperience == driver.drivingExperience &&
                Objects.equals(car, driver.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), car, drivingExperience);
    }
}
