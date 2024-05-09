import java.io.Serializable;

public class Consulta extends Intervencao implements Serializable{

    private float duracao;

    public Consulta(Veterenario veterenario,Animal animal, float preco, boolean deslocacao){
        super(veterenario, animal,preco,deslocacao);
        duracao = 0.5F;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public String toString(){
        return "Consulta: " + getVeterenario().getNome() + " " + getAnimal().getNome() + " " + getPreco() + " " + isDeslocacao() + " " + getDuracao();
    }

}
