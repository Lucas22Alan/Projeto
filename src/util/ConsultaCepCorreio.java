/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import classes.clsConsultaCepCorreio;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mk Solucoes
 */
public class ConsultaCepCorreio {
    
    public static clsConsultaCepCorreio consultarCep(String cep){
        System.out.println(cep);
      clsConsultaCepCorreio cepCorreio=new clsConsultaCepCorreio();
        try {
            URL url= new URL("https://viacep.com.br/ws/"+cep+"/json/");
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            if(con.getResponseCode()!=200){
                JOptionPane.showMessageDialog(null, "Houve Erro Para Comunicar Com WS Dos Correios!!!");
                throw  new RuntimeException("Erro Para Consultar Cep");
            
            }
            
            BufferedReader bf= new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF8"));
            
            StringBuilder sb= new StringBuilder();
            
            String retorno=null;
            
            while((retorno=bf.readLine())!=null){
                sb.append(retorno);
            }
            System.out.println(sb.toString());
            bf.close();
            con.disconnect();
            Gson gson= new Gson();
            cepCorreio=gson.fromJson(sb.toString(), clsConsultaCepCorreio.class);
                    
            
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Houve Erro Para Comunicar Com WS Dos Correios!!!\n"+ex.getMessage());
            Logger.getLogger(ConsultaCepCorreio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Houve Erro Para Comunicar Com WS Dos Correios!!!\n"+ex.getMessage());
            Logger.getLogger(ConsultaCepCorreio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cepCorreio;
        
    }
    
}
