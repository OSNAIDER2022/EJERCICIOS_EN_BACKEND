package proxy;

public class SitioB implements SitioInterface{
    @Override
    public String ingresarAlSitio(Usuario usuario) {
        System.out.println("validando el ingreso en el SITIO B de " + usuario.getNombre());
        return "Se ha permitido el ingreso del usuario: " + usuario.getNombre() + " al SITIO B";
    }
}
