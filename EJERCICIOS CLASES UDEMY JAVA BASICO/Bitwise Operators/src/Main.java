public class Main {
    public static void main(String[] args) {
        //BITWISE OPERATORS:
        //Los Operadores por bits pueden ser:

        byte a = 15; //en binario es: 0000 1111
        byte b = 85; //en binario es: 0101 0101
        byte res; //01011111

        //adiciona un bit y cambia su propiedad positiva o negativa
        res = (byte) ~a;
        System.out.println("El resultado de 'a' en byte es: " + res);

        //operador AND realiza una comparacion entre ambos numeros binarios, priorizando el 0, lo cual
        // supondría lo siguiente:
        //0 & 0 = 0
        //0 & 1 = 0
        //1 & 0 = 0
        //1 & 1 = 1

        res = (byte) (a & b);
        System.out.println("El resultado de 'a' AND 'b' en byte es: " + res);

        //operador OR realiza una comparacion entre ambos numeros binarios, priorizando el |1, lo cual
        // supondría lo siguiente:
        //0 & 0 = 0
        //0 & 1 = 1
        //1 & 0 = 1
        //1 & 1 = 1

        res = (byte) (a | b);
        System.out.println("El resultado de 'a' OR 'b' en byte es: " + res);

        //operador XOR realiza una comparacion entre ambos numeros binarios, no priorizando, lo cual
        // supondría lo siguiente:
        //0 & 0 = 0
        //0 & 1 = 1
        //1 & 0 = 1
        //1 & 1 = 0

        res = (byte) (a ^ b);
        System.out.println("El resultado de 'a' XOR 'b' en byte es: " + res);

        //operador >> y << corre n cantidad de bits hacia la derecha o izquierda según lo que
        // indiquemos:

        //dos bits hacia la derecha:
        //'a' actual = 0000 1111
        //'a' despues de correr 02 bits a la derecha = 0000 0011
        res = (byte) (a >> 2);
        System.out.println("El resultado de correr dos bits de 'a' hacia la derecha es: " + res);

        //tres bits hacia la izquierda:
        //tres bits hacia la izquierda:
        //'a' actual = 0000 1111
        //'a' despues de correr 03 bits a la izquierda = 0111 1000
        res = (byte) (a << 3);
        System.out.println("El resultado de correr dos bits de 'a' hacia la izquierda es: " + res);

    }
}