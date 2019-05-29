package um.edu.uy;

public class NationalOlympicCommitte {

    String name;
    String  region;
    String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public NationalOlympicCommitte(String name, String region) {
        this.name = name;
        this.region = region;
    }

    public NationalOlympicCommitte() {
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
