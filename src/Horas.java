public class Horas {
    private Float Hora;
    private boolean Disponibilidade;

    public Horas(Float Hora, boolean Disponibilidade) {
        this.Hora = Hora;
        this.Disponibilidade = Disponibilidade;
    }

    public Float getHora() {
        return Hora;
    }

    public void setHora(Float Hora) {
        this.Hora = Hora;
    }

    public boolean isDisponibilidade() {
        return Disponibilidade;
    }

    public void setDisponibilidade(boolean Disponibilidade) {
        this.Disponibilidade = Disponibilidade;
    }
}
