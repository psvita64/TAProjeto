import java.util.ArrayList;
import java.io.Serializable;

public class Veterinario implements Serializable{

    private int nif;
    private String nome;
    private int id_OrdemVet;
    private int contacto;

    private ArrayList<Intervencao> listaInterV;

    private ArrayList<Horario> ListaHorario;

    public Veterinario(int nif, String nome, int id_OrdemVet, int contacto){
        this.nif = nif;
        this.nome = nome;
        this.id_OrdemVet = id_OrdemVet;
        this.contacto = contacto;
        listaInterV = new ArrayList<Intervencao>();
        ListaHorario = new ArrayList<Horario>();
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public ArrayList<Horario> getHorario(){ return ListaHorario;};

    public void setHorario(ArrayList<Horario> listaHorario) {this.ListaHorario = ListaHorario;};

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_OrdemVet() {
        return id_OrdemVet;
    }

    public void setId_OrdemVet(int id_OrdemVet) {
        this.id_OrdemVet = id_OrdemVet;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public ArrayList<Intervencao> getListaInter() {
        return listaInterV;
    }

    public void setListaInter(ArrayList<Intervencao> listaInter) {
        this.listaInterV = listaInter;
    }

    public String toString(){
        return "Veterenario: " + getNif() + " " + getNome() + " " + getId_OrdemVet() + " " + getContacto();
    }
}
