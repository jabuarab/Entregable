package um.edu.uy;

import java.util.ArrayList;

public class OlympicGame {

    private String name;

    private int year;

    private SeasonType season;

    private City ciudad;

    private ArrayList<Event> eventos =new ArrayList<>();

    public OlympicGame(String name, int year, SeasonType season, City ciudad) {
        this.name = name;
        this.year = year;
        this.season = season;
        this.ciudad = ciudad;
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

    public ArrayList<Event> getEventos() { return eventos; }

    public void setEventos(ArrayList<Event> eventos) { this.eventos = eventos; }

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
