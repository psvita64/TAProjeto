//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;

public class Horario {
    private Data data;
    private ArrayList<Horas> horas;

    public Horario(Data data) {
        this.data = data;
        int indice = 1;
        this.horas = new ArrayList();

        for(double i = 8.0; i < 19.0; i += 0.5) {
            if (i == 12.0) {
                i = 14.0;
            }

            this.horas.add(new Horas((float)i, true));
        }

    }

    public ArrayList<Horas> getHorasLivres() {
        ArrayList<Horas> horasLivres = new ArrayList();
        Iterator var2 = this.horas.iterator();

        while(var2.hasNext()) {
            Horas h = (Horas)var2.next();
            if (h.isLivre()) {
                horasLivres.add(h);
            }
        }

        return horasLivres;
    }

    public boolean isHoraLivre(float hora, Data data) {
        if (!this.data.equals(data)) {
            return false;
        } else {
            Iterator var3 = this.horas.iterator();

            Horas h;
            do {
                if (!var3.hasNext()) {
                    return false;
                }

                h = (Horas)var3.next();
            } while(h.getHora() != hora);

            return h.isLivre();
        }
    }

    public void marcarHoraComoOcupada(float hora) {
        Iterator var2 = this.horas.iterator();

        Horas h;
        do {
            if (!var2.hasNext()) {
                return;
            }

            h = (Horas)var2.next();
        } while(h.getHora() != hora);

        h.setDisponibilidade(false);
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ArrayList<Horas> getHoras() {
        return this.horas;
    }

    public void setHoras(ArrayList<Horas> horas) {
        this.horas = horas;
    }
}
