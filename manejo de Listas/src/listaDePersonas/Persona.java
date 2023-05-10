package listaDePersonas;

public class Persona {
    //ATRIBUTOS
    private String nombre;
    private Integer edad;

    //CONSTRUCTOR
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
    public boolean checkMayorDeEdad(){
        return edad>=18;
    }
    public boolean checkRangoDeEdad(){
        boolean respuesta = false;
        if(edad>=0 && edad < 120){
            respuesta = true;
            return respuesta;
        }
        return respuesta;
    }
    public boolean nombreCuatroCaracteres(){
        return nombre.length()>=4;
    }
    public boolean checkSoloLetras(){
        boolean respuesta = false;
        char[] arrayDelNombre = nombre.toCharArray();
        for (char letra : arrayDelNombre) {
            if(!Character.isLetter(letra)){
                return respuesta;
            }
        }
            respuesta = true;
            return respuesta;
    }
}
