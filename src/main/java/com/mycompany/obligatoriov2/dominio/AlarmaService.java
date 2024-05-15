/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriov2.dominio;

import java.util.ArrayList;

/**
 *
 * @author luis octavio
 */
public class AlarmaService {

    private ArrayList<Alarma> alarmas = new ArrayList<Alarma>();
    private static AlarmaService instancia = null;
    //Alarma service tendra una coleccion de observadores
    private static ArrayList<ObserverAlarma> observadores = new ArrayList<ObserverAlarma>();

    private AlarmaService() {

    }

    public Alarma obtenerAlarmaPorIdSensor(int id) {
        for (Alarma a : alarmas) {
            if (a.getSensor().getCodigo() == id) {
                return a;
            }
        }
        return null;
    }

    public static AlarmaService getInstance() {
        if (instancia == null) {
            instancia = new AlarmaService();
        }
        return instancia;
    }

    public static void agregarObservador(ObserverAlarma observador) {
        observadores.add(observador);
    }

    public static void eliminarObservador(ObserverAlarma observador) {
        observadores.remove(observador);
    }

    public void agregarAlarma(Alarma alarma) {
        alarmas.add(alarma);
    }

    public void eliminarAlarma(Alarma alarma) {
        alarmas.remove(alarma);
    }

    public ArrayList<Alarma> obtenerAlarmas() {
        return alarmas;
    }

    public void notify(EventoAlarma evento) {
        for (ObserverAlarma observer : observadores) {
            observer.update(evento);
        }
    }

    public void notificarAlarmaActivada(EventoAlarma ev) {
        this.notify(ev);
    }
}
