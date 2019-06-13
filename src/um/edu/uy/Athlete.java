package um.edu.uy;

public class Athlete {

    private long id;
    private String name;
    private SexType sex;
    private int age;
    private float heigth;
    private float weigth;
    private Team team;
    private NationalOlympicCommitte noc;
    int[] medallas={0,0,0,0};


    public Athlete(long id, String name, SexType sex, int age, float heigth, float weigth, Team team, NationalOlympicCommitte noc) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.heigth = heigth;
        this.weigth = weigth;
        this.team = team;
        this.noc = noc;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public int[] getMedallas() {
        return medallas;
    }

    public void setMedallas(int[] medallas) {
        this.medallas = medallas;
    }


}
