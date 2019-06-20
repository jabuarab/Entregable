package um.edu.uy;

import java.util.ArrayList;

public class Team {

    private String nombre;

    private ArrayList<Athlete> atletas;

    public Team(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Athlete> getAtletas() {
        return atletas;
    }

    public void setAtletas(ArrayList<Athlete> atletas) {
        this.atletas = atletas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
