/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriov2.presentacion.controladores;

import com.mycompany.obligatoriov2.dominio.Alarma;
import com.mycompany.obligatoriov2.dominio.AlarmaService;
import com.mycompany.obligatoriov2.dominio.DispositivoSeguridadService;
import com.mycompany.obligatoriov2.dominio.EventoAlarma;
import com.mycompany.obligatoriov2.dominio.ObserverAlarma;
import com.mycompany.obligatoriov2.dominio.Red;
import com.mycompany.obligatoriov2.dominio.Sensor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luis octavio
 */
public class MiVentanaController implements ObserverAlarma {

    private static int siguienteCodigoDispositivo = 2;

    private IVentana vista;

    public MiVentanaController(IVentana vista) {
        this.vista = vista;
        vista.setController(this);
        AlarmaService.agregarObservador(this);
        vista.actualizarListadoDispositivos((Red) DispositivoSeguridadService.getInstance().getRaiz());

    }

    //Este es el cbox de redes para agregar sensor.
    public void cargarCboxRedes1(ArrayList<Red> redes) {
        vista.cargarCboxRedes(redes);
    }

    //Este es el cbox de redes para agregar sensor.
    public void cargarCboxRedes2(ArrayList<Red> redes) {
        vista.cargarCboxRedes2(redes);
    }

    public void eliminarRed() {
        Red red = vista.obtenerRedAEliminar();
        if (red.tieneSensores()) {
            vista.mostrarMensajeError("No se puede eliminar la red porque contiene sensores.");
            return;
        }
        int result = vista.mostrarMensajeConfirmacion("Seguro desea eliminar el " + vista.obtenerRedAEliminar() + " ?");
        if (result == JOptionPane.OK_OPTION) {
            DispositivoSeguridadService.getInstance().eliminarDispositivo(red);
            DispositivoSeguridadService.getInstance().eliminarDispositivoDeRaiz(red);
            vista.actualizarListadoDispositivos((Red) DispositivoSeguridadService.getInstance().getRaiz());
            vista.cargarCboxRedes2(DispositivoSeguridadService.getInstance().getDispositivosRedes());
            vista.cargarCboxRedes(DispositivoSeguridadService.getInstance().getDispositivosRedes());
            vista.cargarCboxEliminarRed(DispositivoSeguridadService.getInstance().getDispositivosRedes());
        }
    }

    public void eliminarSensor() {
        Sensor s = vista.obtenerSensorAEliminar();
        int result = vista.mostrarMensajeConfirmacion("Seguro desea eliminar el sensor " + vista.obtenerSensorAEliminar() + " ?");
        if (result == JOptionPane.OK_OPTION) {
            DispositivoSeguridadService.getInstance().eliminarDispositivo(s);
            DispositivoSeguridadService.getInstance().eliminarDispositivoDeRaiz(s);
            vista.cargarCboxSensoresEnAsignarValor(DispositivoSeguridadService.getInstance().getDispositivosSensores());
            vista.cargarCboxSensoresEnAsignarAlarma(DispositivoSeguridadService.getInstance().getDispositivosSensores());
            vista.cargarCboxEliminarSensor(DispositivoSeguridadService.getInstance().getDispositivosSensores());
            vista.actualizarListadoDispositivos((Red) DispositivoSeguridadService.getInstance().getRaiz());
            System.out.println("Se ha eliminado un sensor");
        }
    }

    public void agregarRed() {
        try {
            String nombre = vista.getNombreNuevaRed();
            Red r = new Red(siguienteCodigoDispositivo++, nombre);
            DispositivoSeguridadService.getInstance().agregarDispositivo(r, vista.obtenerRedSeleccionadaParaRed());
            DispositivoSeguridadService.getInstance().guardarDispositivo(r);
            vista.mostrarMensajeExito("Red " + nombre + " agregada correctamente");
            vista.actualizarListadoDispositivos((Red) DispositivoSeguridadService.getInstance().getRaiz());
            vista.cargarCboxRedes2(DispositivoSeguridadService.getInstance().getDispositivosRedes());
            vista.cargarCboxRedes(DispositivoSeguridadService.getInstance().getDispositivosRedes());
            vista.cargarCboxModificarRed(DispositivoSeguridadService.getInstance().getDispositivosRedes());
            vista.cargarCboxEliminarRed(DispositivoSeguridadService.getInstance().getDispositivosRedes());
        } catch (Exception ex) {
            vista.mostrarMensajeError("Error, intente nuevamente mas tarde por favor.");
        }
    }

    public void modificarNombreSensor() {
        try {
            Sensor s = vista.obtenerSensorModificarNombre();
            boolean res = DispositivoSeguridadService.getInstance().modificarNombreSensor(s, vista.obtenerNuevoNombreSensor());
            if (res == true) {
                vista.mostrarMensajeExito("Nombre modificado correctamente");
                vista.actualizarListadoDispositivos((Red) DispositivoSeguridadService.getInstance().getRaiz());
                vista.cargarCboxRedes2(DispositivoSeguridadService.getInstance().getDispositivosRedes());
                vista.cargarCboxRedes(DispositivoSeguridadService.getInstance().getDispositivosRedes());
                vista.cargarCboxEliminarRed(DispositivoSeguridadService.getInstance().getDispositivosRedes());
            }
        } catch (Exception ex) {
            vista.mostrarMensajeError("Error al modificar sensor");
        }
    }

    public void modificarNombreRed() {
        try {
            Red r = vista.obtenerRedModificarNombre();
            boolean res = DispositivoSeguridadService.getInstance().modificarNombreRed(r, vista.obtenerNuevoNombreRed());
            if (res == true) {
                vista.mostrarMensajeExito("Nombre modificado correctamente");
                vista.actualizarListadoDispositivos((Red) DispositivoSeguridadService.getInstance().getRaiz());
                vista.cargarCboxRedes2(DispositivoSeguridadService.getInstance().getDispositivosRedes());
                vista.cargarCboxRedes(DispositivoSeguridadService.getInstance().getDispositivosRedes());
                vista.cargarCboxEliminarRed(DispositivoSeguridadService.getInstance().getDispositivosRedes());
            }
        } catch (Exception ex) {
            vista.mostrarMensajeError("Error al modificar red");
        }
    }

    public void agregarSensor() {
        try {
            String nombre = vista.getNombreNuevoSensor();
            Sensor s = new Sensor(siguienteCodigoDispositivo++, nombre, vista.obtenerLatitudSensor(), vista.obtenerLongitudSensor(), vista.obtenerTipoSensorSeleccionado());
            s.setEnAlarma(false);
            s.setValorActual(0);
            DispositivoSeguridadService.getInstance().agregarDispositivo(s, vista.obtenerRedSeleccionadaParaSensor());
            DispositivoSeguridadService.getInstance().guardarDispositivo(s);
            vista.actualizarListadoDispositivos((Red) DispositivoSeguridadService.getInstance().getRaiz());
            vista.cargarCboxRedes(DispositivoSeguridadService.getInstance().getDispositivosRedes());
            vista.cargarCboxSensoresEnAsignarValor(DispositivoSeguridadService.getInstance().getDispositivosSensores());
            vista.cargarCboxSensoresEnAsignarAlarma(DispositivoSeguridadService.getInstance().getDispositivosSensores());
            vista.cargarCboxEliminarSensor(DispositivoSeguridadService.getInstance().getDispositivosSensores());
            vista.cargarCboxModificarSensor(DispositivoSeguridadService.getInstance().getDispositivosSensores());
            vista.mostrarMensajeExito("Sensor " + nombre + " agregado correctamente");
        } catch (Exception ex) {
            vista.mostrarMensajeError("Error, recuerda que el nombre debe contener algun caracter.");
        }
    }

    public void asignarValorSensor() {
        try {
            DispositivoSeguridadService.getInstance().asignarValorSensor(vista.obtenerSensorAsignarValor(), vista.obtenerValorAsignadoSensor());
            vista.mostrarMensajeExito("Sensor actualizado " + vista.obtenerSensorAsignarValor());
            //verificar si el sensor ya tiene una alarma y si salta cuando se cambie su valor
            Alarma aux = AlarmaService.getInstance().obtenerAlarmaPorIdSensor(vista.obtenerSensorAsignarValor().getCodigo());
            if (aux != null) {
                aux.verificarSuperaUmbral(vista.obtenerSensorAsignarValor());
            }
            vista.cargarCboxSensoresEnAsignarValor(DispositivoSeguridadService.getInstance().getDispositivosSensores());
        } catch (Exception ex) {
            vista.mostrarMensajeError("El valor debe ser numérico.");
        }
    }

    public void asignarAlarma() {
        try {
            Alarma a = new Alarma(vista.obtenerSensorAsignarAlarma(), vista.obtenerValorLimiteParaAlarma());
            a.setSensor(vista.obtenerSensorAsignarAlarma());
            AlarmaService.getInstance().agregarAlarma(a);
            vista.mostrarMensajeExito("Alarma agregada correctamente.");
            a.verificarSuperaUmbral(vista.obtenerSensorAsignarAlarma());
            System.out.println(AlarmaService.getInstance().obtenerAlarmas().size());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            vista.mostrarMensajeError("Hubo un problema, intente nuevamente por favor.");
        }
    }

    public void mostrarMensajeAlarmaActivada(EventoAlarma ev) {
        vista.cargarAlarmaEnLista(ev);
        vista.mostrarMensajeAlarmaActivada(ev);
    }

    @Override
    public void update(EventoAlarma evento) {
        mostrarMensajeAlarmaActivada(evento);
    }
}
