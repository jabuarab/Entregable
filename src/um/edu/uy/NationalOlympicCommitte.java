package um.edu.uy;

public class NationalOlympicCommitte {

    private int id;

    private String name;

    private String region;

    private String notes;

    public NationalOlympicCommitte(int id, String name, String region, String notes) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.notes = notes;
    }

    public NationalOlympicCommitte(String name, String region, String notes) {
        this.name = name;
        this.region = region;
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }
}
