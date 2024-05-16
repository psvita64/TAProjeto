//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Veterinario implements Serializable {
    private int nif;
    private String nome;
    private int id_OrdemVet;
    private int contacto;
    private ArrayList<Intervencao> listaInterV;
    private ArrayList<Horario> ListaHorario;

    public Veterinario(int nif, String nome, int id_OrdemVet, int contacto) {
        this.nif = nif;
        this.nome = nome;
        this.id_OrdemVet = id_OrdemVet;
        this.contacto = contacto;
        this.listaInterV = new ArrayList();
        this.ListaHorario = new ArrayList();
    }

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public ArrayList<Horario> getHorario() {
        return this.ListaHorario;
    }

    public void setHorario(ArrayList<Horario> listaHorario) {
        this.ListaHorario = this.ListaHorario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_OrdemVet() {
        return this.id_OrdemVet;
    }

    public void setId_OrdemVet(int id_OrdemVet) {
        this.id_OrdemVet = id_OrdemVet;
    }

    public int getContacto() {
        return this.contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public ArrayList<Intervencao> getListaInter() {
        return this.listaInterV;
    }

    public void setListaInter(ArrayList<Intervencao> listaInter) {
        this.listaInterV = listaInter;
    }

    public String toString() {
        int var10000 = this.getId_OrdemVet();
        return "Veterenario (Id: " + var10000 + "): \n Nome: " + this.getNome() + "\n Nif: " + this.getNif() + "\n Contacto:  " + this.getContacto();
    }

    public boolean isHorarioLivre(Data data, float hora) {
        Iterator var3 = this.ListaHorario.iterator();

        Horario horario;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            horario = (Horario)var3.next();
        } while(!horario.getData().equals(data));

        return horario.isHoraLivre(hora, data);
    }
}
