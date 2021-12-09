import org.apache.log4j.Logger;

import java.util.Objects;

public class Guardian extends Human implements IGuard {
    private String rank, weapon;
    private static final Logger LOGGER = Logger.getLogger(Guardian.class);

    public Guardian(){
        name="";
        age=0;
        rank="";
        weapon="";
    }

    public Guardian(String name,int age, String rank, String weapon){
        this.name=name;
        this.age=age;
        this.rank=rank;
        this.weapon=weapon;
    }

    public void setRank(String rank){
        this.rank=rank;
    }

    public  void setWeapon(String weapon){
        this.weapon=weapon;
    }

    public String getRank(){
        return rank;
    }

    public String getWeapon(){
        return weapon;
    }

    @Override
    public void shootingInRobber(String weapon) {
        LOGGER.info(this.name + " is shooting in the robber with a " + weapon);
    }

    @Override
    public void waitForReinforcements() {
        LOGGER.info(this.name + " is waiting for reinforcements");
    }

    @Override
    public String toString() {
        return "Guardian{" +
                "rank='" + rank + '\'' +
                ", weapon='" + weapon + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Guardian guardian = (Guardian) o;
        return Objects.equals(rank, guardian.rank) &&
                Objects.equals(weapon, guardian.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rank, weapon);
    }
}
