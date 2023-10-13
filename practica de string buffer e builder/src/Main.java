public class Main {
    public static void main(String[] args) {

        /*Esta es una practica simulada en donde lo que se busca es la reutilizacion y escalamiento de una query
         * utiizando StringBuffer o StringBuilder*/

        StringBuffer mysql_insert = new StringBuffer();
        StringBuffer mysql_search_all = new StringBuffer();
        StringBuffer mysql_delete = new StringBuffer();
        StringBuffer mysql_search_by_id = new StringBuffer();
        StringBuffer mysql_update = new StringBuffer();
        StringBuffer mysql_search_by_email = new StringBuffer();
        StringBuffer mysql_show_roll_profile = new StringBuffer();
        StringBuffer mysql_inser_general = new StringBuffer();
        StringBuffer mysql_search_all_general = new StringBuffer();
        StringBuffer mysql_search_general_by_id = new StringBuffer();
        StringBuffer mysql_delete_general_by_id = new StringBuffer();
        StringBuffer mysql_update_general = new StringBuffer();

        //simulacion del atributo del objeto que funcionará como condicional del Switch para devolver la query requerida.
        Integer test = 5;

        mysql_insert.append("insert into ").append("USUARIO").append("(NOMBRE_COMPLETO, EMAIL, PASSWORD, CELULAR, IDENTIFICACION, FOTO, ROLL_ID)").append(" values").append("(?,?,?,?,?,?,?)");
        switch (test){
            case 2:
                mysql_insert.replace(12,19,"CLIENTES");
                break;
            case 3:
                mysql_insert.replace(12,19,"PROVEEDORES");
                break;
            default:
                mysql_insert.replace(12,19,"COLABORADORES");
        }

        //==============================================================================================================
        mysql_search_all.append("select * from ").append("USUARIO");
        switch (test){

            case 2:
                mysql_search_all.replace(14,21,"CLIENTES");
                break;
            case 3:
                mysql_search_all.replace(14,21,"PROVEEDORES");
                break;
            default:
                mysql_search_all.replace(14,21,"COLABORADORES");
        }
        //==============================================================================================================
        mysql_delete.append("delete from ").append("USUARIO").append(" where id = ?");
        switch (test){
            case 2:
                mysql_delete.replace(12,19,"CLIENTES");
                break;
            case 3:
                mysql_delete.replace(12,19,"PROVEEDORES");
                break;
            default:
                mysql_delete.replace(12,19,"COLABORADORES");
        }
        //==============================================================================================================
        mysql_search_by_id.append("select * from ").append("USUARIO").append(" where id = ?");
        switch (test){
            case 2:
                mysql_search_by_id.replace(14,21,"CLIENTES");
                break;
            case 3:
                mysql_search_by_id.replace(14,21,"PROVEEDORES");
                break;
            default:
                mysql_search_by_id.replace(14,21,"COLABORADORES");
        }
        //==============================================================================================================
        mysql_update.append("update ").append("USUARIO").append(" set NOMBRE_COMPLETO = ?, set EMAIL = ?, set PASSWORD = ?, set CELULAR = ?, set IDENTIFICACION = ?, set FOTO = ?, set ROLL_ID = ?").append(" where ID = ?");
        switch (test){
            case 2:
                mysql_update.replace(7,14,"CLIENTES");
                break;
            case 3:
                mysql_update.replace(7,14,"PROVEEDORES");
                break;
            default:
                mysql_update.replace(7,14,"COLABORADORES");
        }
        //==============================================================================================================
        mysql_search_by_email.append("select * from ").append("USUARIO").append(" where EMAIL = ?");
        switch (test){
            case 2:
                mysql_search_by_email.replace(14,21,"CLIENTES");
                break;
            case 3:
                mysql_search_by_email.replace(14,21,"PROVEEDORES");
                break;
            default:
                mysql_search_by_email.replace(14,21,"COLABORADORES");
        }
        //==============================================================================================================
        mysql_show_roll_profile.append("select ROLLES.PERFIL from ").append("USUARIO").append(" left join ROLLES on ").append("USUARIO").append(".ROLL_ID = ROLLES.ID WHERE ").append("USUARIO").append(".NOMBRE_COMPLETO = ?");
        switch (test){
            case 2:
                mysql_show_roll_profile.replace(26,33,"CLIENTES").replace(55,62,"CLIENTES").replace(90,97,"CLIENTES");
            break;
            case 3:
                mysql_show_roll_profile.replace(26,33,"PROVEEDORES").replace(58,65,"PROVEEDORES").replace(96,103,"PROVEEDORES");
                break;
            default:
                mysql_show_roll_profile.replace(26,33,"COLABORADORES").replace(60,67,"COLABORADORES").replace(100,107,"COLABORADORES");
        }
        //==============================================================================================================
        mysql_inser_general.append("insert into ").append("GENERAL").append("(valor)").append(" values(?)");
        switch (test){
            case 2:
                mysql_inser_general.replace(12,19,"ROLLES").replace(19,24,"PERFIL");
            break;
            case 3:
                mysql_inser_general.replace(12,19,"ESTADOS_DE_SERVICIOS").replace(33,38,"NOMBRE_ESTADO");
                break;
            case 4:
                mysql_inser_general.replace(12,19,"ESTADOS_DE_PRODUCTOS").replace(33,38,"ESTADO");
                break;
            case 5:
                mysql_inser_general.replace(12,19,"TIEMPOS_GARANTIAS").replace(30,35,"TIEMPO");
                break;
            default:
        }
        //==============================================================================================================
        mysql_search_all_general.append("select * from ").append("GENERAL");
        switch (test){
            case 2:
                mysql_search_all_general.replace(14,21,"ROLLES");
                break;
            case 3:
                mysql_search_all_general.replace(14,21,"ESTADOS_DE_SERVICIOS");
                break;
            case 4:
                mysql_search_all_general.replace(14,21,"ESTADOS_DE_PRODUCTOS");
                break;
            case 5:
                mysql_search_all_general.replace(14,21,"TIEMPOS_GARANTIAS");
                break;
            default:
        }
        //==============================================================================================================
        mysql_search_general_by_id.append("select * from ").append("GENERAL").append(" where id = ?");
        switch (test){
            case 2:
                mysql_search_general_by_id.replace(14,21,"ROLLES");
                break;
            case 3:
                mysql_search_general_by_id.replace(14,21,"ESTADOS_DE_SERVICIOS");
                break;
            case 4:
                mysql_search_general_by_id.replace(14,21,"ESTADOS_DE_PRODUCTOS");
                break;
            case 5:
                mysql_search_general_by_id.replace(14,21,"TIEMPOS_GARANTIAS");
                break;
            default:
        }
        //==============================================================================================================
        mysql_delete_general_by_id.append("delete from ").append("GENERAL").append(" where id = ?");
        switch (test){
            case 2:
                mysql_delete_general_by_id.replace(12,19,"ROLLES");
                break;
            case 3:
                mysql_delete_general_by_id.replace(12,19,"ESTADOS_DE_SERVICIOS");
                break;
            case 4:
                mysql_delete_general_by_id.replace(12,19,"ESTADOS_DE_PRODUCTOS");
                break;
            case 5:
                mysql_delete_general_by_id.replace(12,19,"TIEMPOS_GARANTIAS");
                break;
            default:
        }
        //==============================================================================================================
        mysql_update_general.append("update ").append("GENERAL").append(" set VALOR = ?").append(" where ID = ?");
        switch (test){
            case 2:
                mysql_update_general.replace(7,14,"ROLLES").replace(18,23,"PERFIL");
                break;
            case 3:
                mysql_update_general.replace(7,14,"ESTADOS_DE_SERVICIOS").replace(32,37,"NOMBRE_ESTADO");
                break;
            case 4:
                mysql_update_general.replace(7,14,"ESTADOS_DE_PRODUCTOS").replace(32,37,"ESTADO");
                break;
            case 5:
                mysql_update_general.replace(7,14,"TIEMPOS_GARANTIAS").replace(29,34,"TIEMPO");
        }
        //==============================================================================================================
        System.out.println( mysql_insert );
        System.out.println( mysql_search_all );
        System.out.println( mysql_delete );
        System.out.println( mysql_search_by_id );
        System.out.println( mysql_update );
        System.out.println( mysql_search_by_email );
        System.out.println( mysql_show_roll_profile );
        System.out.println(mysql_inser_general);
        System.out.println(mysql_search_all_general);
        System.out.println(mysql_search_general_by_id);
        System.out.println(mysql_delete_general_by_id);
        System.out.println(mysql_update_general);
    }
}


