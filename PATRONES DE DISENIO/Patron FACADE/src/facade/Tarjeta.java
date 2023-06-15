package facade;

public class Tarjeta {
    //ATRIBUTOS
    private String numero;
    private String banco;

    //CONSTRUCTOR
    public Tarjeta(String numero, String banco) {
        this.numero = numero;
        this.banco = banco;
    }

    //GETTERS AND SETTERS
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
