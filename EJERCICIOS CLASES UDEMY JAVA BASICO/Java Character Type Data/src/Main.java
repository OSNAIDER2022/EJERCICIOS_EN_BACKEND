public class Main {
    public static void main(String[] args) {
        /*Los tipos de caracteres char pueden ser generados de tres formas:*/
        //caracteres de tipo común:
        char myChar;
        myChar = 'B';
        System.out.println("El caracter B de tipo común es: " + myChar);

        //caracteres usando códigos ASCII:
        myChar = 70;
        System.out.println("El caracter 70 de tipo ASCII, es: " + myChar);

        //de tipo unicode hexadecimal:
        myChar = '\u0041';
        System.out.println("El caracter de tipo Hexadecimal '\\u0041' es: " + myChar);
    }
}