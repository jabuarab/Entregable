package um.edu.uy;

public class AthleteOlympicParticipation {

    private MedalType medalType;

    private Athlete atleta;

    private OlympicGame juegoOlimpico;

    private Event evento;

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public AthleteOlympicParticipation(MedalType medalType, Athlete atleta, OlympicGame juegoOlimpico) {
        this.medalType = medalType;
        this.atleta = atleta;
        this.juegoOlimpico = juegoOlimpico;
    }

    public Athlete getAtleta() {
        return atleta;
    }

    public void setAtleta(Athlete atleta) {
        this.atleta = atleta;
    }

    public OlympicGame getJuegoOlimpico() {
        return juegoOlimpico;
    }

    public void setJuegoOlimpico(OlympicGame juegoOlimpico) {
        this.juegoOlimpico = juegoOlimpico;
    }

    public MedalType getMedalType() {
        return medalType;
    }


    public void setMedalType(MedalType medalType) {
        this.medalType = medalType;
    }
}
