/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriov2.presentacion;

import com.mycompany.obligatoriov2.dominio.DispositivoSeguridad;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;



/**
 *
 * @author luis octavio
 */
public class ArbolCellRenderer extends DefaultTreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
       super.getTreeCellRendererComponent(tree, value, leaf, expanded, leaf, row, hasFocus);
       if(((DispositivoSeguridad)value).enAlarma()){
        this.setForeground(Color.red);
       }else{
           this.setForeground(Color.black);
       }
       return this;
    }
}