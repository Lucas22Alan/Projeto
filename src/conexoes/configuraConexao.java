/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import Logs.gravarLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class configuraConexao {
         public static void careg() {
             Properties pro;
             try {
                 pro = getProp();
                 String ip,banco,porta,caminho="";
                 ip=pro.getProperty("ip");
                 banco=pro.getProperty("banco");
                 caminho=pro.getProperty("relatorio");
                 conexao.ip=ip;
                 conexao.endereco=banco;
                 conexao.cam=caminho;
             } catch (IOException ex) {
                 Logger.getLogger(configuraConexao.class.getName()).log(Level.SEVERE, null, ex);
                 gravarLog.main(ex.getMessage().toString());
                 JOptionPane.showMessageDialog(null, "erro para buscar dados da conexao \n\n"  +ex.getMessage());
             }
            
         }
    
    
     public static Properties getProp()throws IOException{
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./configAdm.ini");
        prop.load(file);
        return prop;
    
}
}
