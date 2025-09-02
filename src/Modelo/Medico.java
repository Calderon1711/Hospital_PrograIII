package Modelo;

public class Medico extends Personal{
    private String especialidad;

    public Medico(){
    }

    public Medico(String especialidad) {
        this.especialidad = especialidad;
    }

    public Medico(String nombre, String id, String clave, String especialidad) {
        super(nombre, id, clave);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "especialidad='" + especialidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

    @Override
    public String getTipo() {
        return "Medico";
    }
}
