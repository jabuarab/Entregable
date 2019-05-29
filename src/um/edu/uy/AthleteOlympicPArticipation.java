package um.edu.uy;

public class AthleteOlympicPArticipation {
    MedalType medalType;
    Atlethe atleta;
    OlympicGame juegoOlimpico;

    public Atlethe getAtleta() {
        return atleta;
    }

    public void setAtleta(Atlethe atleta) {
        this.atleta = atleta;
    }

    public OlympicGame getJuegoOlimpico() {
        return juegoOlimpico;
    }

    public void setJuegoOlimpico(OlympicGame juegoOlimpico) {
        this.juegoOlimpico = juegoOlimpico;
    }

    public AthleteOlympicPArticipation() {
    }

    public MedalType getMedalType() {
        return medalType;
    }

    public void setMedalType(MedalType medalType) {
        this.medalType = medalType;
    }
}
