import java.io.Serializable;
public abstract class Intervencao implements Serializable{

    private Veterinario veterinario;

    private Animal animal;
    private float preco;
    private boolean deslocacao;

    public Intervencao(Veterinario veterenario,Animal animal, float preco, boolean deslocacao){
        this.animal = animal;
        this.veterinario = veterenario;
        this.preco = preco;
        this.deslocacao = deslocacao;
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

    public String toString(){
        return "Intervencao: " + getVeterinario().getNome() + " " + getAnimal().getNome() + " " + getPreco() + " " + isDeslocacao() + " " + getDuracao();
    }


}
