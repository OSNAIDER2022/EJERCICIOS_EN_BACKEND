package validador;

public class Factura {
    //ATRIBUTOS
    private String tipo;
    private String concepto;
    private Integer valor;
    private String registradoPor;

    //CONSTRUCTOR
    public Factura(String tipo, String concepto, Integer valor, String registradoPor) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.valor = valor;
        this.registradoPor = registradoPor;
    }

    //GETTERS AND SETTERS


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(String registradoPor) {
        this.registradoPor = registradoPor;
    }
}
