public class Cirurgia extends Intervencao{

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
}
