/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.AtualizaDAO;
import Logs.gravarLog;
import conexoes.conexao;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
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
    public static final String versaoCompilada="1.086";
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
            copiaVersaoServidor();
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
    private static void copiaVersaoServidor(){
        try {
            String caminhoexec= "\\\\"+conexao.ip+"\\c\\esfhera\\adm\\projeto.jar";
            String destinoexec="c:\\esfhera\\adm\\temp.jar";
           
            File origem=new File(caminhoexec);
            File camfim=new File(destinoexec);;
            Files.copy(origem.toPath(), camfim.toPath());
            Runtime.getRuntime().exec("cmd.exe /c start c:\\esfhera\\adm\\att.bat");
            
        } catch (Exception ex) {
            Logger.getLogger(ClsVerificaVersao.class.getName()).log(Level.SEVERE, null, ex);
            gravarLog.main("Falha ao executar atualização automatica! \n"+ex.getMessage());
        }
    }
}
