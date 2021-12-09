import java.util.Calendar;
import java.util.Objects;

public class Cashier extends Human {
    private int experience;

    public Cashier(){
        experience=0;
    }

    public Cashier(int experience){
        this.experience=experience;
    }

    public Cashier(String name){
        this.name=name;
    }

    public void setExperience(int experience){
        this.experience=experience;
    }

    public int getExperience(){
        return experience;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "experience=" + experience +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cashier cashier = (Cashier) o;
        return experience == cashier.experience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experience);
    }
}
