import java.io.Serializable;
import java.util.Date;

public abstract class Intervencao implements Serializable{

    private Veterinario veterinario;
    private Animal animal;
    private float preco;
    private boolean deslocacao;
    private Data data;

    public Intervencao(Veterinario veterenario,Animal animal, float preco, boolean deslocacao, Data data){
        this.animal = animal;
        this.veterinario = veterenario;
        this.preco = preco;
        this.deslocacao = deslocacao;
        this.data = data;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterenario(Veterinario veterenario) {
        this.veterinario = veterenario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isDeslocacao() {
        return deslocacao;
    }

    public void setDeslocacao(boolean deslocacao) {
        this.deslocacao = deslocacao;
    }

    public abstract float getDuracao();

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String toString(){
        return "Intervencao: \n" +
                "Vet: " + getVeterinario().getNome() + "\n" +
                "Animal: " + getAnimal().getNome() + "\n" +
                "Preço: " + getPreco() + "\n" +
                "Tem deslocação? " + isDeslocacao() + "\n" +
                "Duração: " + getDuracao() + "\n" +
                "Data e Hora: " + getData().getDia() + "/" + getData().getMes() + "\n";
    }


}
