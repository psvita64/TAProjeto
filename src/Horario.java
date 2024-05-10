import java.util.ArrayList;

public class Horario {
    private Data data;
    private ArrayList<Horas> horas;

    public Horario(Data data,float hora) {
        this.data = data;
        int indice = 1;
        horas = new ArrayList<Horas>();
        for (double i = 8; i < 18; i=i+0.5) {
            if(i == 12){
                i = 14;
            }
            horas.set(indice, new Horas((float)i,true));
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
