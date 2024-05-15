/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriov2.dominio;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class DispositivoSeguridadService {

    private Red raiz;

    public static DispositivoSeguridadService instancia = null;

    private ArrayList<DispositivoSeguridad> dispositivos = new ArrayList<>();

    private ArrayList<Alarma> alarmas = new ArrayList<>();

    public static DispositivoSeguridadService getInstance() {
        if (instancia == null) {
            instancia = new DispositivoSeguridadService();
        }
        return instancia;
    }

    private DispositivoSeguridadService() {
        raiz = new Red(1, "Security Network");
        this.guardarDispositivo(raiz);
    }

    public DispositivoSeguridad getRaiz() {
        return raiz;
    }

    public DispositivoSeguridad obtenerDispositivoSeguridadPorCodigo(int codigo) {
        for (DispositivoSeguridad disp : dispositivos) {
            if (disp.getCodigo() == codigo) {
                return disp;
            }
        }
        return null;
    }

    public void agregarAlarma(Alarma a) {
        alarmas.add(a);
    }

    public void agregarDispositivo(DispositivoSeguridad d, Red contenedora) {
        if (contenedora != null) {
            contenedora.agregarDispositivo(d);
        } else {
            raiz.agregarDispositivo(d);
        }
    }

    public boolean guardarDispositivo(DispositivoSeguridad d) {
        dispositivos.add(d);
        return true;
    }

    public void eliminarDispositivoDeRaiz(DispositivoSeguridad d) {
        raiz.eliminarDispositivo(d);
    }

    public boolean eliminarDispositivo(DispositivoSeguridad disp) {
        dispositivos.remove(disp);
        return true;
    }

    public void eliminarDispositivoDeRed(Red r, DispositivoSeguridad disp) {
        r.eliminarDispositivo(disp);
    }

    public ArrayList<DispositivoSeguridad> getDispositivos() {
        return dispositivos;
    }

    public boolean modificarNombreSensor(Sensor s, String nuevoNombre) {
        s.setNombre(nuevoNombre);
        return true;
    }

    public boolean modificarNombreRed(Red r, String nuevoNombre) {
        r.setNombre(nuevoNombre);
        return true;
    }

    public ArrayList<Red> getDispositivosRedes() {
        ArrayList<Red> redes = new ArrayList<Red>();
        for (DispositivoSeguridad r : dispositivos) {
            if (r instanceof Red) {
                redes.add((Red) r);
            }
        }
        return redes;
    }

    public ArrayList<Red> getDispositivosRedesParaEliminar() {
        ArrayList<Red> redes = new ArrayList<Red>();
        for (DispositivoSeguridad r : dispositivos) {
            if (r instanceof Red && r != raiz) {
                redes.add((Red) r);
            }
        }
        return redes;
    }

    public ArrayList<Sensor> getDispositivosSensores() {
        ArrayList<Sensor> sensores = new ArrayList<Sensor>();
        for (DispositivoSeguridad s : dispositivos) {
            if (s instanceof Sensor) {
                sensores.add((Sensor) s);
            }
        }
        return sensores;
    }

    public boolean asignarValorSensor(Sensor s, Double valor) {
        if (!valor.isNaN() && valor != null) {
            s.setValorActual(valor);
            return true;
        } else {
            return false;
        }
    }
}
