package validador;
//Con este validador creamos la lógica de como deben responder los validadores ante una factura
public abstract class Validador {
    private Validador siguienteValidador;

    //GETTERS AND SETTERS
    public Validador getSiguienteValidador() {
        return siguienteValidador;
    }

    public void setSiguienteValidador(Validador siguienteValidador) {
        this.siguienteValidador = siguienteValidador;
    }
    //METODO ABSTRACTO
    public abstract String revisarFactura(Factura factura);
}
