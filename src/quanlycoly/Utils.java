/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycoly;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author ufo
 */
public class Utils {
    
    
    public static String convertToDate(String str){
        String result = "";
        String [] listStr = str.split("-");
        result = listStr[2]+"-"+listStr[1]+"-"+listStr[0];
        return result;
        
    }
    
    public static void setCenterScreen(JFrame frame){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - (int)frame.getSize().getWidth()/2, dim.height/2 - (int)frame.getSize().getHeight()/2);
    }
    
}
