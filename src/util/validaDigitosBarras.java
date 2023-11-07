/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigInteger;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mk Solucoes
 */
public class validaDigitosBarras {
    
     public static String preencheCodigo(String temp){
         Long codtemp;
        try{
            if(temp.length()<14){
                 codtemp=Long.parseLong(temp);
                 temp=String.format("%014d", codtemp);
            }
         }catch(Exception ep ){
            Logger.getLogger(validaDigitosBarras.class.getName()).log(Level.SEVERE, null, ep);
            //JOptionPane.showMessageDialog(null, "Erro ao completar codigo!!!");
            temp="00000000000000";
        }
        return temp;    
    }
    
}
