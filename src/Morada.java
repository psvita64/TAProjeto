import java.io.Serializable;

public class Morada implements Serializable{

    private String rua;
    private int numero;
    private int codigo_postal;
    private String localidade;

    public Morada(String rua, int numero, int codigo_postal, String localidade){
        this.rua = rua;
        this.numero = numero;
        this.codigo_postal = codigo_postal;
        this.localidade = localidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String toString(){
        return "Rua: "+getRua()+" Numero: "+getNumero()+" Codigo Postal: "+getCodigo_postal()+" Localidade: "+getLocalidade();
    }
}
