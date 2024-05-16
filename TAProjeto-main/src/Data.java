//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Data {
    private int dia;
    private int mes;

    public Data(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Data data = (Data)obj;
            return this.dia == data.dia && this.mes == data.mes;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("%02d/%02d", this.dia, this.mes);
    }
}
