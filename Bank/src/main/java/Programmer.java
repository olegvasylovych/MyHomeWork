import org.apache.log4j.Logger;

import java.util.Objects;

public class Programmer extends Human implements IProgramming {
    protected String programmingLanguage, grade;
    private static final Logger LOGGER = Logger.getLogger(Programmer.class);

    public Programmer(){
        this.name="";
        this.age=0;
        this.programmingLanguage="";
        this.grade="";
    }

    public Programmer(String name, int age, String programmingLanguage, String grade){
        this.name=name;
        this.age=age;
        this.programmingLanguage=programmingLanguage;
        this.grade=grade;
    }

    public void setProgrammingLanguage(String programmingLanguage){
        this.programmingLanguage=programmingLanguage;
    }

    public void setGrade(String grade){
        this.grade=grade;
    }

    public String getProgrammingLanguage(){
        return programmingLanguage;
    }

    public String getGrade(){
        return grade;
    }

    @Override
    public void programmingNewApplication() {
        LOGGER.info(this.name+" is creating a new application.");
    }

    @Override
    public void programmingUpdate() {
        LOGGER.info(this.name+" is programming a new update.");
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "programmingLanguage='" + programmingLanguage + '\'' +
                ", grade='" + grade + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programmer that = (Programmer) o;
        return Objects.equals(programmingLanguage, that.programmingLanguage) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), programmingLanguage, grade);
    }
}
