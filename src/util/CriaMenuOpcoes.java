/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

/**
 *
 * @author Mk Solucoes
 */
public class CriaMenuOpcoes {
    
    
     public static void listaCliqDireitoMouse(JTable tabela, JPopupMenu menu ){
        tabela.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
                   
            }else if((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0){
                menu.show(tabela, e.getX(), e.getY());
              }
            }
            
});
    
    
    }
}
