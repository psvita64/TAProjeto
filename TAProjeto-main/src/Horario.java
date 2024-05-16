import java.util.ArrayList;

public class Horario {
    private Data data;
    private ArrayList<Horas> horas;

    public Horario(Data data) {
        this.data = data;
        int indice = 1;
        horas = new ArrayList<Horas>();
        for (double i = 8; i < 19; i=i+0.5) {
            if(i == 12){
                i = 14;
            }
            horas.add(new Horas((float)i,true));
        }

    }

    public ArrayList<Horas> getHorasLivres(){
        ArrayList<Horas> horasLivres = new ArrayList<Horas>();
        for(Horas h : horas){
            if(h.isLivre()){
                horasLivres.add(h);
            }
        }
        return horasLivres;
    }

    public boolean isHoraLivre(float hora, Data data) {
        if (!this.data.equals(data)) {
            return false; // A data não coincide
        }
        for (Horas h : horas) {
            if (h.getHora() == hora) {
                return h.isLivre();
            }
        }
        return false; // Caso a hora não seja encontrada
    }

    public void marcarHoraComoOcupada(float hora) {
        for (Horas h : horas) {
            if (h.getHora() == hora) {
                h.setDisponibilidade(false);
                return;
            }
        }
    }


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ArrayList<Horas> getHoras() {
        return horas;
    }

    public void setHoras(ArrayList<Horas> horas) {
        this.horas = horas;
    }


}
