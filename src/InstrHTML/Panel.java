/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstrHTML;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author miguel
 */

/**
 *
 * @author miguel
 */
public class Panel{
    LinkedList<Panel> listaComponentes = new LinkedList<>();
    int height, width, x, y;
    String color;
    
    public Panel(LinkedList<Panel> listaComponentes, int height, int width, String color, int x, int y){
        this.listaComponentes = listaComponentes;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public void ejecutar(JPanel entorno){
        /** Crear nuevo Panel***/
        JPanel nuevo = new JPanel();
        nuevo.setLayout(null);
        nuevo.setBounds(this.x, this.y, this.width, this.height);
        LibreriaColor l = new LibreriaColor();
        nuevo.setBackground(l.traducirColor(this.color));
        nuevo.repaint();
        
        /** Agregar al entorno Padre **/
        entorno.add(nuevo);        
        entorno.repaint();
        
        for(Panel p: listaComponentes) {
            p.ejecutar(nuevo);
        }
    }
}