public class Main {
    public static void main(String[] args) {
        //Los Arrays pueden crearse declarando su tipo[] arrayName:
        //Almacenarse sus valores directamente:
        int[] intArray = {1,2,3,4,5};

        //Se puede establecer previamente el tamaño del Array:
        //para este ejemplo, el array tendrá un máximo de 03 elementos
        float[] floatArray = new float[3];

        //Para ingresar valores en un array debemos seguir la estructura:
        // arrayName[posicionArray] = valor
        floatArray[0] = 1.2F;
        floatArray[1] = 3.5F;
        floatArray[2] = 9.3F;

        System.out.println("El array para intArray es: ");
        for (int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i] + " ");
        }

        System.out.println("El array para floatArray es: ");
        for (int i = 0; i < floatArray.length; i++){
            System.out.println(floatArray[i] + " ");
        }

    }
}