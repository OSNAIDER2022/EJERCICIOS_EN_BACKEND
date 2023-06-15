package validador;

public class CompruebaFactura{
    private Validador cadena;

    //CONSTRUCTOR
    public CompruebaFactura() {
        // en este espacio se define quien inicia y en que orden seguirán:
        //declaramos los objetos:
        cadena = new ValidadorEgreso();
        Validador Prestamo = new ValidadorPrestamo();
        Validador Inversion = new ValidadorInversion();
        Validador Ingreso = new ValidadorIngreso();
        // Definimos el orden:
        cadena.setSiguienteValidador(Prestamo);
        Prestamo.setSiguienteValidador(Inversion);
        Inversion.setSiguienteValidador(Ingreso);
    }
    //METODO PARA ENVIAR LA VALIDACION DE LA FACTURA
    public String compruebaFactura(Factura factura){
        return cadena.revisarFactura(factura);
    }

    //GETTERS AND SETTERS
    public Validador getCadena() {
        return cadena;
    }
    public void setCadena(Validador cadena) {
        this.cadena = cadena;
    }
}
