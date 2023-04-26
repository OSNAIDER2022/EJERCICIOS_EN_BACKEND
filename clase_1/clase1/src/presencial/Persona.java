package presencial;

public class Persona {
    //ATRIBUTOS
    private String nombre;
    private Integer edad;
    //CONTRUCTOR
    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    //METODOS
    public boolean esMayorDeEdad(){
        return edad >= 18;
    }
    public boolean checkEdad(){
        boolean respuesta=false;
        if(edad >= 0 && edad <= 120){
            respuesta = true;
        }
        return respuesta;
    }
    public boolean checkNombre4Letras(){
        return nombre.length() > 4;
    }
    public boolean checkLetrasAtoZ(){
        boolean respuesta = false;
        //pasamos el String a un array de char
        char[] arrayDeNombre = nombre.toCharArray();
        for (char letra :  arrayDeNombre) {
            if (!Character.isLetter(letra)){
                return respuesta;
            }
        }
        respuesta = true;
        return respuesta;
    }
}
