import java.io.Serializable;

public class Vacinacao extends Intervencao implements Serializable {

    private int duracao;

    public Vacinacao(Veterinario veterinario,Animal animal, float preco, boolean deslocacao,int duracao){
        super(veterinario, animal,preco,deslocacao);
        duracao = 30;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String toString(){
        return "Vacinacao: " + getVeterinario().getNome() + " " + getAnimal().getNome() + " " + getPreco() + " " + isDeslocacao() + " " + getDuracao();
    }
}
