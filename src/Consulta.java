import java.io.Serializable;

public class Consulta extends Intervencao implements Serializable{

    private float duracao;

    public Consulta(Veterinario veterinario,Animal animal, float preco, boolean deslocacao,Data data){
        super(veterinario, animal,preco,deslocacao,data);
        duracao = 0.5F;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public String toString(){
        return "Consulta: " + getVeterinario().getNome() + " " + getAnimal().getNome() + " " + getPreco() + " " + isDeslocacao() + " " + getDuracao()+ " "+ getData();
    }

}
