public class Personal {
    protected String Id;
    protected String Nombre;
    protected String Clave;

    public Personal() {
    }

    public Personal(String id, String clave, String nombre) {
        Id = id;
        Clave = clave;
        Nombre = nombre;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "Id='" + Id + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Clave='" + Clave + '\'' +
                '}';
    }
}
