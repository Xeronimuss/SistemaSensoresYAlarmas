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
public class Sensor extends DispositivoSeguridad {

    private int codigo;
    private String nombre;
    private String latitud;
    private String longitud;
    private EnumEstadoSensor estado;
    private double valorActual;
    private EnumTipoSensor tipo;
    public boolean enAlarma;
    private ArrayList<Alarma> alarmas = new ArrayList<Alarma>();

    public Sensor(int codigo, String nombre, String latitud, String longitud, EnumTipoSensor tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tipo = tipo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public EnumEstadoSensor getEstado() {
        return estado;
    }

    public void setEstado(EnumEstadoSensor estado) {
        this.estado = estado;
    }

    public double getValorActual() {
        return valorActual;
    }

    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }

    public EnumTipoSensor getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoSensor tipo) {
        this.tipo = tipo;
    }

    public void setEnAlarma(boolean estaEnAlarma) {
        this.enAlarma = estaEnAlarma;
    }

    public int avisarObservadores(AlarmaService as) {
        return 0;
    }

    @Override
    public boolean enAlarma() {
        return enAlarma;
    }

    @Override
    public boolean contieneDispositivo(DispositivoSeguridad d) {
        return false;
    }

    @Override
    public String toString() {
        return "Sensor: " + codigo + " En alarma: " + enAlarma + " Nombre: " + nombre + " Valor: " + valorActual + " Tipo: " + tipo;
    }
}
