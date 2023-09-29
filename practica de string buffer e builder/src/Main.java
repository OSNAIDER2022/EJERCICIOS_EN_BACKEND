public class Main {
    public static void main(String[] args) {

        /*Esta es una practica simulada en donde lo que se busca es la reutilizacion y escalamiento de una query
         * utiizando StringBuffer o StringBuilder*/

        StringBuffer mysql_insert = new StringBuffer();

        //simulacion del atributo del objeto que funcionará como condicional del Switch para devolver la query requerida.
        Integer test = 5;

        mysql_insert
                .append("insert into ").append("USUARIO")
                .append("(NOMBRE_COMPLETO, EMAIL, PASSWORD, CELULAR, IDENTIFICACION, FOTO, ROLL_ID)")
                .append(" values").append("(?,?,?,?,?,?,?)");


        switch (test){
            case 1:
                mysql_insert.replace(12,19,"COLABORADOR");
                break;
            case 2:
                mysql_insert.replace(12,19,"CLIENTE");
                break;
            case 3:
                mysql_insert.replace(12,19,"PROVEEDOR");
                break;
            default:
        }

        System.out.println(
                mysql_insert
        );
    }
}