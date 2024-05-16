import java.util.ArrayList;

public class Recibo {


    String nomeVeterinário;
    String nomeCliente;
    int nifCliente;
    int idAnimal;
    float precoTotal;
    ArrayList<Intervencao> listaIntervencoes = new ArrayList<Intervencao>();


    public Recibo(Veterinario veterinario, Cliente cliente, Animal animal, ArrayList<Intervencao> listaIntervencoes){

        this.nomeVeterinário = veterinario.getNome();
        this.nomeCliente = cliente.getNome();
        this.nifCliente = cliente.getNif();
        this.idAnimal = animal.getId();
        this.precoTotal = 0;
        for (Intervencao i : listaIntervencoes){
            this.listaIntervencoes.add(i);
            this.precoTotal += i.getPreco();
        }

    }

    public String getNomeVeterinário() {
        return nomeVeterinário;
    }

    public void setNomeVeterinário(String nomeVeterinário) {
        this.nomeVeterinário = nomeVeterinário;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(int nifCliente) {
        this.nifCliente = nifCliente;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public ArrayList<Intervencao> getListaIntervencoes() {
        return listaIntervencoes;
    }

    public void setListaIntervencoes(ArrayList<Intervencao> listaIntervencoes) {
        this.listaIntervencoes = listaIntervencoes;
    }

    public void listarInter(){
        for (Intervencao i : listaIntervencoes){
            System.out.println(i.toString());
        }
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String toString(){
        String interventions = "";
        for (Intervencao i : listaIntervencoes){
            interventions += i.toString() + "\n";
        }
        return "Recibo: \n " +
                "Veterinário: " + getNomeVeterinário() + "\n " +
                "Cliente: " + getNomeCliente() + "\n " +
                "NIF: " + getNifCliente() + "\n " +
                "ID Animal: " + getIdAnimal() + "\n " +
                "Intervenções: " + interventions + "\n " +
                "Preço Total (sem iva): " + getPrecoTotal() + "\n " +
                "Preço Total (com iva): " + (getPrecoTotal()+(getPrecoTotal()*0.2));


    }
}
