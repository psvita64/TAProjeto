public class Vacinacao extends Intervencao{

    private int duracao;

    public Vacinacao(Veterenario veterenario,Animal animal, float preco, boolean deslocacao,int duracao){
        super(veterenario, animal,preco,deslocacao);
        duracao = 30;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
