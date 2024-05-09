import java.util.ArrayList;
import java.io.Serializable;


public class Animal implements Serializable{

    private int id;
    private String nome;
    private String especie;
    private String genero;
    private float peso;

    private ArrayList<Intervencao> listaInterA;

    private Cliente cliente;


    public Animal(int id, String nome, String especie, String genero, float peso, Cliente cliente){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.genero = genero;
        this.peso = peso;
        this.cliente= cliente;
        this.
        listaInterA = new ArrayList<Intervencao>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public ArrayList<Intervencao> getIntervencoes(){
        return listaInterA;
    }

    public void setListaInterA(ArrayList<Intervencao> listaInterA){
        this.listaInterA = listaInterA;
    }

    public String toString(){
        return "Animal: " + getId() + " " + getNome() + " " + getEspecie() + " " + getGenero() + " " + getPeso() + " " + getCliente().getNome();
    }
}
