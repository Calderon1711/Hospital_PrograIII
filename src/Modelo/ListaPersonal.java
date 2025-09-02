package Modelo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ListaPersonal {

    private ObservableList<Personal> ListaPersonal;

    //constructor sin para
    public ListaPersonal(){
        this.ListaPersonal = FXCollections.observableArrayList();
    }

    //constructor con para
    public ListaPersonal(List<Personal> ListaPersonal){
        this.ListaPersonal = FXCollections.observableArrayList(ListaPersonal);
    }

    public ObservableList<Personal> getListaPersonal() {
        return ListaPersonal;
    }

    public void setListaPersonal(ObservableList<Personal> listaPersonal) {
        this.ListaPersonal= FXCollections.observableArrayList(listaPersonal);
    }


    //Agregar personal
    public boolean InsertarPersonal(Personal per){
        try{
            if(per == null){
                throw new IllegalArgumentException("El personal no puede ser nula");
            }
            if(existePersonalConEseId(per.getId())){
                throw new IllegalArgumentException("El personal ya existe en el sistema");
            }
            ListaPersonal.add(per);
            return true;

        }catch(IllegalArgumentException e){
            System.err.println("Error al ingresar al personal: " + e.getMessage());
            return false;
        }
    }

    //Eliminar personal
    public boolean borrarPersonalporId(String id){
        if(!existePersonalConEseId(id)){
            return false;
        }

        for(Personal per: ListaPersonal){
            if(per.getId().equals(id)){
                ListaPersonal.remove(per);
                return true;

            }
        }
        return false;
    }

    //Verificar si esta el personal
    public boolean existePersonalConEseId(String id) {
        for (Personal per : ListaPersonal) {
            if (per.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Personal  getPersonalPorId(String id){
        for(Personal per: ListaPersonal){
            if(per.getId().equals(id)){
                return per;
            }
        }
        return null;
    }
}