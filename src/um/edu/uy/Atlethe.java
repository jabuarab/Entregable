package um.edu.uy;

public class Atlethe {
    int age;
    long id;
    String name;
    SexType sex;
    float weigth;
    float heigth;
    Team team;
    NationalOlympicCommitte noc;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Atlethe() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public float getWeigth() {
        return weigth;
    }

    public void setWeigth(float weigth) {
        this.weigth = weigth;
    }

    public float getHeigth() {
        return heigth;
    }

    public void setHeigth(float heigth) {
        this.heigth = heigth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public NationalOlympicCommitte getNoc() {
        return noc;
    }

    public void setNoc(NationalOlympicCommitte noc) {
        this.noc = noc;
    }

}
