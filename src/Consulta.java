public class Consulta extends Intervencao{

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
}
