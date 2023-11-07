/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JTable;
import javax.swing.KeyStroke;

/**
 *
 * @author Mk Solucoes
 */
public class ValidaAtalhoTable {
    public void atalhosTable(JTable ao_table){
        InputMap im = ao_table.getInputMap(ao_table.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);   
    
        KeyStroke lo_key_enter = KeyStroke.getKeyStroke("ENTER");   

        im.put(lo_key_enter, im.get(KeyStroke.getKeyStroke(KeyEvent.VK_GREATER, 0)));  

            Action enterAction=	new AbstractAction() {	
                public void actionPerformed(ActionEvent evt)
                {
                        // Requisita o foco para a outra celula.
                }; 
            };
         ao_table.getActionMap().put(im.get(lo_key_enter), enterAction);
    
    }
    
}
