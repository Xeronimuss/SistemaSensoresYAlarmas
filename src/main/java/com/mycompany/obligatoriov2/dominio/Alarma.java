/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriov2.dominio;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author luis octavio
 */
public class Alarma {

    private static int codigo = 1;
    private String nombre;
    private double valorLimite;
    private ArrayList<DispositivoSeguridad> dispositivos;
    private Sensor sensor;

    public Alarma(Sensor sensor, double valorLimite) {
        this.codigo = codigo++;
        this.sensor = sensor;
        this.nombre = "Alarma Id: " + codigo;
        this.valorLimite = valorLimite;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public ArrayList<DispositivoSeguridad> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(ArrayList<DispositivoSeguridad> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public boolean verificarSuperaUmbral(Sensor s) {
        if (s.getValorActual() > this.getValorLimite()) {
            EventoAlarma ev = new EventoAlarma(this, s, this.getValorLimite());
            ev.setFechaHora(new Date());
            AlarmaService.getInstance().notificarAlarmaActivada(ev);
            s.setEnAlarma(true);
            return true;
        } else {
            return false;
        }
    }
}
