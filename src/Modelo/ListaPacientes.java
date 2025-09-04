package Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ListaPacientes {
    private final ObservableList<Paciente>pacientes;

    public ListaPacientes(List<Paciente>pacientes){
        this.pacientes=FXCollections.observableArrayList();
        setPacientes(pacientes);
    }

    public ListaPacientes(){
        this.pacientes=FXCollections.observableArrayList();
    }

    public ObservableList<Paciente>getPacientes(){
        return pacientes;
    }

    public void setPacientes(List<Paciente>nuevos){
        this.pacientes.setAll(nuevos==null?List.of():nuevos);
    }
    private static String normId(String id){
        return id==null?"":id.trim();
    }
    public boolean insertarPaciente(Paciente paciente, Boolean respuestaListPersonal){
        try{
            if(paciente==null){
                throw new IllegalArgumentException("El paciente no puede ser nulo");
            }
            String id=normId(paciente.getId());
            if(id.isEmpty()){
                throw new IllegalArgumentException("El id no puede ser vacio");
            }

            if(Boolean.TRUE.equals(respuestaListPersonal)){
                throw new IllegalArgumentException("Existe una persona con ese ID en la lista personal");
            }
            if(existeAlguienconEseID(id)){
                throw new IllegalArgumentException("Existe una persona con ese ID");
            }
            paciente.setId(id);
            pacientes.add(paciente);
            return true;
        }catch (IllegalArgumentException e){
            System.err.println("Error al insertar paciente: "+e.getMessage());
            return false;
        }
    }
    public boolean insertarPaciente(Paciente paciente){
        return insertarPaciente(paciente, false);
    }

    public boolean eliminar(String idPaciente){
        String id = normId(idPaciente);
        if(id.isEmpty()||!existeAlguienconEseID(id)){
            return false;
        }
        return pacientes.removeIf(p->Objects.equals(normId(p.getId()),id));
    }

    public boolean existeAlguienconEseID(String idPaciente){
        String id=normId(idPaciente);
        if(id.isEmpty())return false;
        for(Paciente p: pacientes){
            if (Objects.equals(normId(p.getId()),id)){
                return true;
            }
        }
        return false;
    }

    public Paciente getPaciente(String idPaciente){
        String id = normId(idPaciente);
        if(id.isEmpty()) return null;
        for(Paciente p: pacientes){
            if (Objects.equals(normId(p.getId()),id)){
                return p;

            }
        }
        return null;
    }

    public String mostrarTodoLosPacientes() {
        if (pacientes.isEmpty()) {
            return "No hay pacientes registrados en el sistema";
        }

        List<String> partes = new ArrayList<>();
        partes.add("Lista de todos los pacientes===\n");
        partes.add("Total pacientes: " + pacientes.size() + "\n\n");

        for (int i = 0; i < pacientes.size(); i++) {
            Paciente paciente = pacientes.get(i);
            partes.add("Paciente #" + (i + 1) + ":\n");
            partes.add(paciente.toString() + "\n");
            partes.add("---------------------------\n");
        }

        return String.join("", partes);
    }


}
