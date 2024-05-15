/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.obligatoriov2;

import com.mycompany.obligatoriov2.presentacion.FrmArbol;
import com.mycompany.obligatoriov2.presentacion.controladores.MiVentanaController;

/**
 *
 * @author luis octavio
 */
public class ObligatorioV2 {

    public static void main(String[] args) {
        FrmArbol frm = new FrmArbol();
        MiVentanaController controller = new MiVentanaController(frm);
        frm.setVisible(true);
    }
}
