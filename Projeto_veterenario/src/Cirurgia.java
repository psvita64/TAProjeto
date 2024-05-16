import java.io.Serializable;

public class Cirurgia extends Intervencao implements Serializable{

    private int duracao;

    public Cirurgia(Veterinario veterinario,Animal animal, float preco, boolean deslocacao,int duracao){
        super(veterinario, animal,preco,deslocacao);
        duracao = 2;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String toString(){
        return "Cirurgia: " + getVeterinario().getNome() + " " + getAnimal().getNome() + " " + getPreco() + " " + isDeslocacao() + " " + getDuracao();
    }
}
