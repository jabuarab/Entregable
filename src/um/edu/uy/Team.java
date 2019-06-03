package um.edu.uy;

public class Team {

    private String nombre;

    private Athlete[] atletas;

    public Team(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
