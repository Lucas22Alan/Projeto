/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logs;

import classes.clsaux;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class gravarLog {
    
    private static final String LOG_FILE = "logs/error"+clsaux.retorDataHora()+".log";
    private static final String LOG_FILESEM = "logs/errorSemMensagem"+clsaux.retorDataHora()+".log";
    public static void main (String args){
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write("Data: "+clsaux.retorDataHora()+" Erro: "+args);
            writer.newLine();
            writer.write("----------------------------------------------------------------");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void gravaSemMensagem(String arg){
          try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILESEM, true))) {
            writer.write("Data: "+clsaux.retorDataHora()+" Erro: "+arg);
            writer.newLine();
            writer.write("----------------------------------------------------------------");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    
    }
    
}
