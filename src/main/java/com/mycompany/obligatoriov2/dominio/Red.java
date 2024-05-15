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
public class Red extends DispositivoSeguridad {

    private String nombre;
    private ArrayList<DispositivoSeguridad> dispositivos = new ArrayList<>();
    private ArrayList<Alarma> alarmas;

    public Red(int codigo, String nombre) {
        this.setCodigo(codigo);
        this.nombre = nombre;
    }

    public boolean agregarDispositivo(DispositivoSeguridad disp) {
        if (!contieneDispositivo(disp)) {
            dispositivos.add(disp);
            return true;
        }
        return false;
    }

    public boolean eliminarDispositivo(DispositivoSeguridad disp) {
        dispositivos.remove(disp);
        return true;
    }

    @Override
    public boolean contieneDispositivo(DispositivoSeguridad disp) {
        for (DispositivoSeguridad d : dispositivos) {
            if (d.equals(disp) || d.contieneDispositivo(disp)) {
                return true;
            }
        }
        return false;
    }

    public boolean tieneSensores() {
        for (DispositivoSeguridad dispositivo : dispositivos) {
            if (dispositivo instanceof Sensor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean enAlarma() {
        for (DispositivoSeguridad disp : dispositivos) {
            if (disp.enAlarma()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<DispositivoSeguridad> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(ArrayList<DispositivoSeguridad> dispositivos) {
        this.dispositivos = dispositivos;
    }

    @Override
    public String toString() {
        return "Red: " + nombre + " ID: " + super.getCodigo();
    }

}
