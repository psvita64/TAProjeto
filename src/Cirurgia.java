import java.io.Serializable;

public class Cirurgia extends Intervencao implements Serializable{

    private int duracao;

    public Cirurgia(Veterenario veterenario,Animal animal, float preco, boolean deslocacao,int duracao){
        super(veterenario, animal,preco,deslocacao);
        duracao = 2;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String toString(){
        return "Cirurgia: " + getVeterenario().getNome() + " " + getAnimal().getNome() + " " + getPreco() + " " + isDeslocacao() + " " + getDuracao();
    }
}
