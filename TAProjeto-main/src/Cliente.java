import java.util.ArrayList;
import java.io.Serializable;

public class Cliente implements Serializable {

    private int nif;
    private String nome;
    private Morada morada;
    private int contacto;


    public Cliente(int nif, String nome, Morada morada, int contacto){
        this.nif = nif;
        this.contacto = contacto;
        this.nome = nome;
        this.morada = morada;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Morada getMorada() {
        return morada;
    }

    public void setMorada(Morada morada) {
        this.morada = morada;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String toString(){
        return "Nome: "+getNome()+" Nif: "+getNif()+" Contacto: "+getContacto()+" Morada: "+getMorada();
    }
}
