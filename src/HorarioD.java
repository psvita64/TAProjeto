import java.util.ArrayList;

public class HorarioD {
    private ArrayList<Horario> horario;
    private int dia;

    private int mes;

    public HorarioD(int dia, int mes){
        this.dia = dia;
        this.mes = mes;
        horario = new ArrayList<Horario>(20);
    }

    public ArrayList<Horario> getHorario() {
        return horario;
    }

    public void setHorario(ArrayList<Horario> horario) {
        this.horario = horario;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}
