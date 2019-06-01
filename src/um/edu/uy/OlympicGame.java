package um.edu.uy;

import java.util.ArrayList;

public class OlympicGame {

    String name;

    int year;

    SeasonType season;

    City ciudad;

    ArrayList<Event> =new ArrayList<>;

    public OlympicGame() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public SeasonType getSeason() {
        return season;
    }

    public void setSeason(SeasonType season) {
        this.season = season;
    }

    public City getCiudad() {
        return ciudad;
    }

    public void setCiudad(City ciudad) {
        this.ciudad = ciudad;
    }
}
