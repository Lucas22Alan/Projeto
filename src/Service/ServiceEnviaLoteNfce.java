/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interface.util.MensagenListener;
import fiscal.clsEnviaNfce;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class ServiceEnviaLoteNfce {
    
    
    
    public void enviarTodasNfce(List<String> mvtos, MensagenListener mensage){
        for(int i=0; i<mvtos.size();i++){
            int atual=i;
            atual=atual+1;
            try {
                new clsEnviaNfce(Long.parseLong(mvtos.get(i)));
                mensage.onMessage(""+atual);
               
            } catch (Exception ex) {
                Logger.getLogger(ServiceEnviaLoteNfce.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        mensage.onOperacaoComplete();
    }
}
