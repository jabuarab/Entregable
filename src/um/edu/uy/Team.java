package um.edu.uy;

public class Team {
   private String  Nombre;

    public Team() {
    }

    public Team(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
