import java.io.Serializable;
public abstract class Intervencao implements Serializable{

    private Veterenario veterenario;

    private Animal animal;
    private float preco;
    private boolean deslocacao;

    public Intervencao(Veterenario veterenario,Animal animal, float preco, boolean deslocacao){
        this.animal = animal;
        this.veterenario = veterenario;
        this.preco = preco;
        this.deslocacao = deslocacao;
    }

    public Veterenario getVeterenario() {
        return veterenario;
    }

    public void setVeterenario(Veterenario veterenario) {
        this.veterenario = veterenario;
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
        return "Intervencao: " + getVeterenario().getNome() + " " + getAnimal().getNome() + " " + getPreco() + " " + isDeslocacao() + " " + getDuracao();
    }


}
