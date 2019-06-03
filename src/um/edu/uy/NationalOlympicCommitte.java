package um.edu.uy;

public class NationalOlympicCommitte {

    private String name;

    private String region;

    private String notes;

    public NationalOlympicCommitte(String name, String region, String notes) {
        this.name = name;
        this.region = region;
        this.notes = notes;
    }

    public NationalOlympicCommitte(String region, String notes) {
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


}
