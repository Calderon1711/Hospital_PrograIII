package Modelo;

public class Farmaceuta extends Personal{
    public Farmaceuta() {
    }

    public Farmaceuta(String nombre, String id, String clave) {
        super(nombre, id, clave);
    }

    @Override
    public String toString() {
        return "Farmaceuta{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

    @Override
    public String getTipo() {
        return "Farmaceuta";
    }
}
