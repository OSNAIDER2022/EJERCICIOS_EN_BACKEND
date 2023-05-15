package proxy;

public class SitioProxy implements SitioInterface{
    //SE ESTABLECE LAS RELACIONES DE LOS SITIOS CON EL PROXY
    private SitioA destinoA;
    private SitioB destinoB;
    private SitioC destinoC;

    //CREAMOS CONSTRUCTORES PARA LOS MISMOS
    public SitioProxy(){
        destinoA = new SitioA();
        destinoB = new SitioB();
        destinoC = new SitioC();
    }

    //SE DECLARA EL FILTRADO
    @Override
    public String ingresarAlSitio(Usuario usuario) {
        if (usuario.getRole().equals("admin")){
            destinoA.ingresarAlSitio(usuario);
            destinoB.ingresarAlSitio(usuario);
            destinoC.ingresarAlSitio(usuario);
            return "El usuario puede acceder a todos los sitios";

        } if (usuario.getRole().equals("colaborador")){
            destinoA.ingresarAlSitio(usuario);
            destinoB.ingresarAlSitio(usuario);
            return "el usuario no tiene permisos para ingresar al SITIO C";

        } if(usuario.getRole().equals("cliente")){
            destinoA.ingresarAlSitio(usuario);
            return "el usuario no tiene permisos para ingresar a los SITIOS B y C";

        } else{
            return "el usuario no cuenta con permisos para acceder a alguno de los sitios";

        }
    }
}
