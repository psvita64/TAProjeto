//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Horas {
    private Float Hora;
    private boolean Disponibilidade;

    public Horas(Float Hora, boolean Disponibilidade) {
        this.Hora = Hora;
        this.Disponibilidade = Disponibilidade;
    }

    public boolean isLivre() {
        return this.Disponibilidade;
    }

    public Float getHora() {
        return this.Hora;
    }

    public void setHora(Float Hora) {
        this.Hora = Hora;
    }

    public boolean isDisponibilidade() {
        return this.Disponibilidade;
    }

    public void setDisponibilidade(boolean Disponibilidade) {
        this.Disponibilidade = Disponibilidade;
    }

    public String toString() {
        String var10000 = String.format("%.2f", this.Hora);
        return var10000 + (this.Disponibilidade ? " (Livre)" : " (Ocupado)");
    }
}
