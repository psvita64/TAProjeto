public class Horario {
    private float Hora;
    private boolean Disponibilidade;

    public Horario(float Hora, boolean Disponibilidade,int dia){
        this.Hora = Hora;
        this.Disponibilidade = Disponibilidade;
    }

    public float getHora() {
        return Hora;
    }

    public void setHora(int hora) {
        Hora = hora;
    }

    public boolean isDisponibilidade() {
        return Disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        Disponibilidade = disponibilidade;
    }
}
