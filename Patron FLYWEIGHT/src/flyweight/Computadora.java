package flyweight;

public class Computadora {
    private Integer memoriaRam;
    private Integer almacenamiento;
    private String codigo;
    private static Integer contador = 0;

    //CONSTRUCTOR
    public Computadora(Integer memoriaRam, Integer almacenamiento) {
        this.memoriaRam = memoriaRam;
        this.almacenamiento = almacenamiento;
        codigo = "Memoria RAM: "+ memoriaRam +" - Almacenamiento en GB" + almacenamiento;
        contador++;
        System.out.println("Se ha creado : " + contador + " Computadores.");
    }

    //GETTERS AND SETTERS

    public Integer getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Integer memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public Integer getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(Integer almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //con este método, mostrmos los valores de los PC's creados por consola:

    @Override
    public String toString() {
        return "Computadora{" +
                "memoriaRam=" + memoriaRam +
                ", almacenamiento=" + almacenamiento +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
