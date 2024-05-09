public abstract class Intervencao{

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


}
