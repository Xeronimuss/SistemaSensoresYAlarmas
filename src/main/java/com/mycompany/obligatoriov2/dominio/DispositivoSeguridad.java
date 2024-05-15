/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriov2.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis octavio
 */
public abstract class DispositivoSeguridad {

    private int codigo;
    private String nombre;
    private double valorActual;
    private boolean estaEnAlarma;
//Por cuestiones de tiempo, la alarmá saltará cuando el valorActual sea mayor a valorLimite.
    private double valorLimite;
    private List<ObserverAlarma> observers = new ArrayList<>();

    public abstract boolean contieneDispositivo(DispositivoSeguridad disp);

    public abstract boolean enAlarma();

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

    public double getValorActual() {
        return valorActual;
    }

    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }
}
