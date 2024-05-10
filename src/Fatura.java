import java.io.Serializable;

public class Fatura implements Serializable {
    private Veterinario veterinario;
    private Animal animal;
    private Intervencao intervencao;
    private double precoIVA;

    public Fatura(Veterinario veterinario,Animal animal,Intervencao intervencao,double precoIVA){
        this.veterinario = veterinario;
        this.animal = animal;
        this.intervencao = intervencao;
        this.precoIVA = intervencao.getPreco() *1.2;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Intervencao getIntervencao() {
        return intervencao;
    }

    public double getPrecoIVA() {
        return precoIVA;
    }

    public void setPrecoIVA(double precoIVA) {
        this.precoIVA = precoIVA;
    }

    public String toString(){
        return "Veterinário: "+ getVeterinario().getNome() +"\nCliente: "+ getAnimal().getCliente().getNome() +"\nNIF do cliente: "+ getAnimal().getCliente().getNif() +"\nID Animal: "+ getAnimal().getId() +"\nIntervenção: "+getIntervencao() +"\nCusto S/IVA: "+ getIntervencao().getPreco() +"\nCusto C/IVA: "+getPrecoIVA() ;
    }
}
