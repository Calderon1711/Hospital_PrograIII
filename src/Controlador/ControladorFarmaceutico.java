package Controlador;

import Modelo.*;
import Vista.FarmaceuticoVista;
import javax.swing.*;
import java.util.List;


public class ControladorFarmaceutico {
    private FarmaceuticoVista vista;
    private ListaRecetas listaRecetas;

    public ControladorFarmaceutico(FarmaceuticoVista vista,ListaRecetas listaRecetas) {
        this.vista = vista;
        this.listaRecetas = listaRecetas;

        this.vista.onBuscar(this::buscarRecetas);
        this.vista.onLimpiar(this::limpiarBusqueda);
        this.vista.onRefrescar(this::refrescarTabla);
        this.vista.onProceso(this::iniciarProceso);
        this.vista.onLista(this::marcarLista);
        this.vista.onEntregar(this::entregarReceta);

        refrescarTabla();

    }
    private void iniciarProceso(){
        FarmaceuticoVista.RecetaRow row=vista.getRecetaSeleccionada();
        if(row==null){
            vista.setMensaje("Seleccione una receta primero.");
            return;
        }
        if("CONFECCIONADA".equals(row.estado)){
           // row.estado = "PROCESO";
            vista.setMensaje("Receta #"+ row.id +" en proceso");
            refrescarTabla();
        }else{
            JOptionPane.showMessageDialog(vista,"Solo recetan en estado CONFECCIONADA pueden iniciar el proceso");
        }
    }

    private void marcarLista(){
        FarmaceuticoVista.RecetaRow row=vista.getRecetaSeleccionada();
        if(row==null){
            vista.setMensaje("Seleccione una receta primero.");
            return;
        }
        if("LISTA".equals(row.estado)){
            //row.estado = "ENTREGADA";
            vista.setMensaje("Receta #"+ row.id +" entregada");
            refrescarTabla();
        }else{
            JOptionPane.showMessageDialog(vista,"Solo recetan en estado LISTA pueden ser entregadas");
        }

    }

    private void limpiarBusqueda(){
        String texto=vista.getTextoBuscar();
        String filtro=vista.getTipoFiltro();

        if (texto.isEmpty()){
            JOptionPane.showMessageDialog(vista,"Ingrese un texto para buscar.");
            return;
        }
    }
    
    private void buscarRecetas(){

    }
    private void entregarReceta(){

    }
    private void refrescarTabla() {

    }
}
