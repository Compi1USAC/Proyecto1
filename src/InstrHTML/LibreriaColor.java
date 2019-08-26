/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstrHTML;

import java.awt.Color;

/**
 *
 * @author miguel
 */
public class LibreriaColor {
    public Color traducirColor(String nombreColor){
        switch(nombreColor.toLowerCase()){
            case "red":
               return Color.RED;
            case "blue":
               return Color.BLUE;
            case "yellow":
               return Color.YELLOW;   
            default:
               return Color.darkGray;
        }
    }
}
