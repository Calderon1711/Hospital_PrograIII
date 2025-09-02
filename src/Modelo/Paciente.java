package Modelo;
import java.time.LocalDate;
import java.time.Period;

public class Paciente {
    private String id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private int telefono;

    public Paciente(String id, String nombre, LocalDate fechaNacimiento, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }
    public Paciente(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fecha) {
        this.fechaNacimiento = fecha;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad(){
        if(fechaNacimiento==null)return 0;
        return Period.between(fechaNacimiento,LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", fecha=" + getFechaNacimiento() +
                ", telefono=" + getTelefono() +
                '}';
    }
}
