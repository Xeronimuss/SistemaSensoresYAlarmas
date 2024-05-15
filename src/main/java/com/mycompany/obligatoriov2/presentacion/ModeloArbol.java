/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriov2.presentacion;

import com.mycompany.obligatoriov2.dominio.Red;
import com.mycompany.obligatoriov2.dominio.Sensor;
import java.util.ArrayList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author luis octavio
 */
public class ModeloArbol implements TreeModel {
    
    private Red raiz;
    private ArrayList<TreeModelListener> listeners = new ArrayList();

   public ModeloArbol(Red raiz) {
        this.raiz = raiz;
    }
    
     
    @Override
    public Object getRoot() {
        return raiz;
    }

    @Override
    public Object getChild(Object parent, int index) {
        if(parent instanceof Red){
            Red red = (Red)parent;
            if(red.getDispositivos().size()>index){
                return red.getDispositivos().get(index);
            }
        }
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
         if(parent instanceof Red){
            Red red = (Red)parent;
            return red.getDispositivos().size();
         }
         return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        return node instanceof Sensor;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if(parent instanceof Red){
            Red red = (Red)parent;
            return red.getDispositivos().indexOf(child);
         }
        return -1;
    }

    @Override
	public void addTreeModelListener(TreeModelListener listener) {
		listeners.add(listener);
	}

    @Override
	public void removeTreeModelListener(TreeModelListener listener) {
		listeners.remove(listener);
	}
        
        private void notificar(){
		for(int x=0;x<listeners.size();x++){
			TreeModelListener l = (TreeModelListener)listeners.get(x);
			l.treeStructureChanged(new TreeModelEvent(this,new TreePath(raiz)));
		}
	}
        
        public void reload(){
            notificar();
        }
}
