public class Main {
    /*Las palabras reservadas FINAL y PROTECTED on usadas para establecer constantes
    * y proteger su uso de forma jerarquica a lo largo del código.
    * Las mismas ostentan algunas particularidades tales como:*/

    static class claseA{
        //atributos de ejemplo:
        final String palabraFinal;
        protected String palabraProtegida;

        //constructor para su uso, inicializándolo sólo una vez:
        public claseA(String palabraFinal, String palabraProtegida) {
            this.palabraFinal = palabraFinal;
            this.palabraProtegida = palabraProtegida;
        }

        //usamos el constructor:
        public claseA(){
            this("keyword FINAL", "keyword PROTECTED");
        }

        //Las palabras finales no pueden ser sobre-escritas
        final public void mensaje1(){
            System.out.println("Esto es un ejemplo de: " + palabraFinal);
        }
        public void mensaje2(){
            System.out.println("Esto es un ejemplo de: " + palabraProtegida);
        }
    }

    static final class claseB extends claseA{
        protected String palabraProtegidaHija;
        public void setPalabraProtegidaHija(String x){
            palabraProtegidaHija = x;
        }
        //Los métodos protegidos pueden sobreescribirse, mientras que los finales no:
        @Override
        public void mensaje2(){
            System.out.println("Esto es un ejemplo de: " + palabraProtegidaHija);
        }
    }

    public static void main(String[] args) {
    claseA A = new claseA("palabra final","palabra protegida");
    A.mensaje1();
    A.mensaje2();

    claseB B = new claseB();
    B.setPalabraProtegidaHija("palabra protegida Hija");
    B.mensaje2();
    }
}