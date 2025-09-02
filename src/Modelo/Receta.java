package Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Receta {
    private Personal personal; //una receta tiene un unico medico
    private Paciente paciente; //y una receta tiene unico paciente
    private LocalDate fechaPrescripcion;
    private LocalDate fechaRetiro;
    private int estado;// 1: Procesada - 2: Confeccionada - 3: Lista - 4: Entregada
    private ObservableList<DetalleMedicamento> detalleMedicamentos;
    private String id;


    //constructor con medico y paciente por parametro
    public Receta(Personal personal, Paciente paciente, LocalDate fechaPrescripcion, LocalDate fechaRetiro, int estado, String id) {
        this.personal = personal;
        this.paciente = paciente;
        this.fechaPrescripcion = fechaPrescripcion;
        this.fechaRetiro = fechaRetiro;
        this.estado = estado;
        this.id = id;
        this.detalleMedicamentos = FXCollections.observableArrayList();
    }

    //constructor sin medico y sin paciente los crea nuevos
    public Receta(String id, LocalDate fechaPrescripcion, LocalDate fechaRetiro, int estado) {
        this.id = id;
        this.fechaPrescripcion = fechaPrescripcion;
        this.fechaRetiro = fechaRetiro;
        this.estado = estado;
        personal = new Medico();
        paciente = new Paciente();
        detalleMedicamentos = FXCollections.observableArrayList();
    }

    //constructor con cedulas
    public Receta(String id, String idPaciente, String idMedico, LocalDate fechaPrescripcion, LocalDate fechaRetiro, int estado) {
        this.id = id;
        this.fechaPrescripcion = fechaPrescripcion;
        this.fechaRetiro = fechaRetiro;
        this.estado = estado;
        personal = new Medico(); //Acá se referenciaría con el hotel el medico con el idMedico.
        paciente = new Paciente(); //Acá se referenciaría con el hotel el medico con el idPaciente.
        detalleMedicamentos = FXCollections.observableArrayList();
    }

    public Receta() {
        //Inicializar referencias.
        personal = new Medico();
        paciente = new Paciente();
        detalleMedicamentos = FXCollections.observableArrayList();
    }


    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaPrescripcion() {
        return fechaPrescripcion;
    }

    public void setFechaPrescripcion(LocalDate fechaPrescripcion) {
        this.fechaPrescripcion = fechaPrescripcion;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ObservableList<DetalleMedicamento> getDetalleMedicamentos() {
        return detalleMedicamentos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDetalleMedicamentos(List<DetalleMedicamento> detalleMedicamentos) {
        this.detalleMedicamentos = FXCollections.observableArrayList(detalleMedicamentos);
    }
// insertar detalle de medicamento

    public boolean insertarDetalleMedicamento(DetalleMedicamento detalleMedicamento) {
        String codigoMedicamento = detalleMedicamento.getMedicamento().getCodigo();
        for (int i = 0; i < detalleMedicamentos.size(); i++) {
            DetalleMedicamento detalles = detalleMedicamentos.get(i);
            if (detalles.getMedicamento().getCodigo().equals(codigoMedicamento)) {
                return false;
            }
        }
        detalleMedicamentos.add(detalleMedicamento);
        return true; //Lo añade si NO hay otro detalle con el mismo medicamento. Se puede hacer con detalle, pero pensando en borrarlo luego, menor evitarlo.
    }


        //eliminar detalle de medicvamento
        public boolean eliminarDetalleMedicamento(String codigoMedicamento) {
            //recorro todo los detalles
            for (DetalleMedicamento detalles :  detalleMedicamentos) {
                // Si encuentra uno con el mismo código que me dieron
                if (detalles.getMedicamento().getCodigo().equals(codigoMedicamento)) {
                    //lo elimino de la lista
                    detalleMedicamentos.remove(detalles);
                    return true;
                }
            }
            return false;
        }

        //modificar cantidad
        public boolean modificarCantidad(String codigoMedicamento, int cantidad) {
            for (DetalleMedicamento detalles :  detalleMedicamentos) {
                if (detalles.getMedicamento().getCodigo().equals(codigoMedicamento)) {
                    detalles.setCantidad(cantidad);
                    return true;
                }
            }
            return false;
        }

        //modificarDuracion
        public boolean modificarDuracion(String codigoMedicamento, int duracion) {
            for (DetalleMedicamento detalles :  detalleMedicamentos) {
                if (detalles.getMedicamento().getCodigo().equals(codigoMedicamento)) {
                    detalles.setDuracion(duracion);
                    return true;
                }
            }
            return false;
        }

        //modificarIndicacion
        public boolean modificarIndicacion(String codigoMedicamento, String indicacion) {
            for (DetalleMedicamento detalles :  detalleMedicamentos) {
                if (detalles.getMedicamento().getCodigo().equals(codigoMedicamento)) {
                    detalles.setIndicacion(indicacion);
                    return true;
                }
            }
            return false;
        }
//obtener detalleMedicamento
    DetalleMedicamento getDetalleMedicamento(String codigoMedicamento) {
        for (DetalleMedicamento detalles :  detalleMedicamentos) {
            if (detalles.getMedicamento().getCodigo().equals(codigoMedicamento)) {
                return detalles;
            }
        }
        return null;
    }
//toString de mostrar todos los detalles
    public String mostrarTodosLosDetalles() {
        StringBuilder sb = new StringBuilder();
        for (DetalleMedicamento detalle : detalleMedicamentos) {
            sb.append(detalle.toString()).append("\n");
        }
        return sb.toString();
    }
//Solo mostarr el Detalle
    public String mostrarDetalle(String codigoMedicamento) {
        StringBuilder sb = new StringBuilder();
        for (DetalleMedicamento detalle : detalleMedicamentos) {
            if (detalle.getMedicamento().getCodigo().equals(codigoMedicamento)) {
                sb.append(detalle.toString()).append("\n");
            }
        }
        return sb.toString();
    }
//verificar si no esta vacia
    public Boolean hayMedicamentosEnLaReceta () {
        return !detalleMedicamentos.isEmpty();
    }

    //obtener estado
    public String obtenerNombreEstado(int estado) {
        switch (estado) {
            case 1: return "Procesada";
            case 2: return "Confeccionada";
            case 3: return "Lista";
            case 4: return "Entregada";
            default: return "Desconocido";
        }
    }

    @Override
    public String toString() {
        String estadoStr = obtenerNombreEstado(1);
        return "Receta {" + '\n' +
                "id='" + id + '\n' +
                ", personal=" + personal.toString() + '\n' +
                ", paciente=" + paciente.toString() + '\n' +
                ", fechaPrescripcion=" + fechaPrescripcion + '\n' +
                ", fechaRetiro=" + fechaRetiro + '\n' +
                ", estado=" + estadoStr + '\n' +
                ", detalleMedicamentos=" + this.mostrarTodosLosDetalles() + '\n' +
                '}';
    }

}
