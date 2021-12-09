import org.apache.log4j.Logger;

public class Lawyer extends Human implements ISingningContract{
    protected int experience;
    private static final Logger LOGGER = Logger.getLogger(Lawyer.class);

    public Lawyer(){
        name="";
        age=0;
        experience=0;
    }

    public Lawyer(String name, int age, int experience){
        this.name=name;
        this.age=age;
        this.experience=experience;
    }

    public void setExperience(int experience){
        this.experience=experience;
    }

    public int getExperience(){
        return experience;
    }

    @Override
    public void signingContractWithClient(String clientName) {
        LOGGER.info(this.name+" is signing a contract with "+clientName);
    }
}
