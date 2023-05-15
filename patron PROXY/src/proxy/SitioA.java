package proxy;

public class SitioA implements SitioInterface{
    @Override
    public String ingresarAlSitio(Usuario usuario) {
        System.out.println("validando el ingreso en el SITIO A de " + usuario.getNombre());
        return "Se ha permitido el ingreso del usuario: " + usuario.getNombre() + " al SITIO A";
    }
}
