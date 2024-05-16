import java.io.Serializable;

public class Cirurgia extends Intervencao implements Serializable{

    private int duracao;

    public Cirurgia(Veterinario veterinario,Animal animal, float preco, boolean deslocacao,Data data){
        super(veterinario, animal,preco,deslocacao,data);
        duracao = 2;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String toString(){
        return "Vacinação: \n" +
                "Vet: " + getVeterinario().getNome() + "\n" +
                "Animal: " + getAnimal().getNome() + "\n" +
                "Preço: " + getPreco() + "\n" +
                "Tem deslocação? " + isDeslocacao() + "\n" +
                "Duração: " + getDuracao() + "\n" +
                "Data: " + getData().toString() + "\n ";
    }
}
