/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriov2.dominio;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Luis
 */
public class EventoAlarma {

    private Date fechaHora;
    private UUID id;
    private Sensor sensor;
    private Alarma alarma;
    private String detalle;

    public EventoAlarma(Alarma a, Sensor s, double umbral) {
        this.setAlarma(a);
        this.setSensor(s);
        this.setId(UUID.randomUUID());
        this.setFechaHora(LocalDateTime.now());
        this.setDetalle("Alarma registrada en el sensor " + s.getCodigo());

    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = Date.from(fechaHora.atZone(ZoneId.systemDefault()).toInstant());
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    @Override
    public String toString(){
        return "Sensor: " + sensor.getCodigo() + " Fecha: " + fechaHora + " Detalle: " + detalle;
    }

}
