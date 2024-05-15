/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.obligatoriov2.presentacion.controladores;

import com.mycompany.obligatoriov2.dominio.EnumTipoSensor;
import com.mycompany.obligatoriov2.dominio.EventoAlarma;
import com.mycompany.obligatoriov2.dominio.Red;
import com.mycompany.obligatoriov2.dominio.Sensor;
import java.util.ArrayList;

/**
 *
 * @author luis octavio
 */
public interface IVentana {

    void actualizarListadoDispositivos(Red raiz);

    void setController(MiVentanaController controller);

    void mostrarMensajeError(String mensaje);

    void mostrarMensajeExito(String mensaje);

    int mostrarMensajeConfirmacion(String mensaje);

    //Para actualizar en seccion agregar un sensor.
    void cargarCboxRedes(ArrayList<Red> redes);

    //Para actualizar en seccion agregar red.
    void cargarCboxRedes2(ArrayList<Red> redes);

    void mostrarMensajeAlarmaActivada(EventoAlarma ev);

    void cargarCboxSensoresEnAsignarValor(ArrayList<Sensor> sensores);

    void cargarCboxSensoresEnAsignarAlarma(ArrayList<Sensor> sensores);

    void cargarCboxEliminarSensor(ArrayList<Sensor> sensores);

    void cargarCboxEliminarRed(ArrayList<Red> redes);

    void cargarAlarmaEnLista(EventoAlarma ev);

    void cargarCboxModificarSensor(ArrayList<Sensor> sensores);

    void cargarCboxModificarRed(ArrayList<Red> redes);

    Sensor obtenerSensorAEliminar();

    Sensor obtenerSensorModificarNombre();

    String obtenerNuevoNombreSensor();

    Red obtenerRedModificarNombre();

    String obtenerNuevoNombreRed();

    Red obtenerRedAEliminar();

    String getNombreNuevaRed();

    String getNombreNuevoSensor();

    String obtenerLatitudSensor();

    String obtenerLongitudSensor();

    Sensor obtenerSensorAsignarValor();

    Sensor obtenerSensorAsignarAlarma();

    Double obtenerValorAsignadoSensor();

    Double obtenerValorLimiteParaAlarma();

    Red obtenerRedSeleccionadaParaSensor();

    Red obtenerRedSeleccionadaParaRed();

    EnumTipoSensor obtenerTipoSensorSeleccionado();
}
