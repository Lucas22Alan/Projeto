/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.AtualizaDAO;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mk Solucoes
 */
public class ClsVerificaVersao {
    public static final String versaoCompilada="1.055";
    public static String versaosis="";
    
    public static Boolean verificaAtualizaVersao(){
        Boolean retorno=false;
        versaosis= AtualizaDAO.verificaVersao();
        if(versaoCompilada.equals(versaosis)){
            retorno=true;
        }else{
            try {
                retorno=carregaScriptAtualizacao();
            } catch (IOException ex) {
                Logs.gravarLog.main(ex.getMessage());
                Logger.getLogger(ClsVerificaVersao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }
    
    
    private static Boolean carregaScriptAtualizacao() throws IOException{
        Boolean ret=true;
        String diretorio="c:\\esfhera\\adm\\banco\\atualizacao\\";
        int vercomp= Integer.parseInt(versaoCompilada.replaceAll("\\.", ""));
        int versis=Integer.parseInt(versaosis.replaceAll("\\.", ""));
        if(vercomp<versis){
            JOptionPane.showMessageDialog(null, "Atenção Sistema Desatualizado!!!");
            System.exit(0);
        }
        for(int i=versis+1; i<=vercomp; i++){
            List<String> comandos=retornaComandos(diretorio+""+i+".sql");
            for(String sql:comandos){
                if(AtualizaDAO.executaComando(sql)==true){}
            else{
                ret=false;
                break;
            }
            }
            
        }
        return ret;
    }
    
    private static List<String> retornaComandos(String caminho){
        
        List<String> comando = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            StringBuilder sqlBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line.trim());
                if (line.trim().endsWith(";")) {
                   
                    comando.add(sqlBuilder.toString());
                    sqlBuilder.setLength(0);
                }
            }
        } catch (IOException e) {
            Logs.gravarLog.gravaSemMensagem(e.getMessage());
            e.printStackTrace();
        }
        return comando;
    }
}
