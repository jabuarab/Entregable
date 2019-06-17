package um.edu.uy;

import java.util.ArrayList;

public class Team {

    private String nombre;

    ArrayList<Athlete> atletas;

    public ArrayList<Athlete> getAtletas() {
        return atletas;
    }

    public void setAtletas(ArrayList<Athlete> atletas) {
        this.atletas = atletas;
    }

    public Team(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    int[] medallas ={0,0,0,0};
}
