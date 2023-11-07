/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.nfeDAO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.naming.directory.DirContext;
import javax.swing.JOptionPane;
import model.clsConfig;
import model.clsDadosEmpresa;

/**
 *
 * @author Mk Solucoes
 */
public class ClsGeraXmlContabilidade {
    
    public void gerarXml(Date ini,Date fim){
       
       try{
        copiarNfce(ini, fim);
        copiarNfe(ini, fim);
        
        
            String nomeArquivoZip= clsConfig.configuracaogeral.getCaminhoxml()+"contador\\xmlContabilidade.rar";
            this.compactaArquivosPasta(clsConfig.configuracaogeral.getCaminhoxml()+"contador\\temp", nomeArquivoZip);
            this.limparPasta(clsConfig.configuracaogeral.getCaminhoxml()+"contador\\temp");
            int yn= JOptionPane.showConfirmDialog(null, "Arquivo Gerado Com Sucesso!!!\n Deseja Enviar Email Para Contador? ", "Geração de Remessa XML...", JOptionPane.YES_NO_OPTION);
            if (yn== JOptionPane.YES_OPTION){
             ClsEnvioEmail.enviarEmailComAnexo(nomeArquivoZip,clsDadosEmpresa.getEmailconador(),"");
            }
       }catch(Exception ep ){
           Logger.getLogger(ClsGeraXmlContabilidade.class.getName()).log(Level.SEVERE, null, ep);
           Logs.gravarLog.main(ep.getMessage());
       }
        
     }
    
    
    public void compactaArquivosPasta(String camEntrada, String camSaida){
        
        try {
            Path pat=Paths.get(camSaida);
            
            Files.deleteIfExists(pat);
            
            pat=Files.createFile(pat);
            
            try(ZipOutputStream zss= new ZipOutputStream(Files.newOutputStream(pat))){
                Path patt= Paths.get(camEntrada);
                
                Files.walk(patt).filter(path-> !Files.isDirectory(path))
                        .forEach(path->{
                    try {
                        ZipEntry zipp= new ZipEntry(patt.relativize(path).toString());
                        zss.putNextEntry(zipp);
                        Files.copy(path, zss);
                        zss.closeEntry();
                    } catch (IOException ex) {
                        Logger.getLogger(ClsGeraXmlContabilidade.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            
                        
                  });
           }
        } catch (IOException ex) {
            Logger.getLogger(ClsGeraXmlContabilidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
    public void limparPasta(String pasta){
        File fil= new File(pasta);
        File[] dadosPasta= fil.listFiles();
        
        for(File arq: dadosPasta){
            arq.delete();
        }
    }
    private void copiarNfce(Date ini,Date fim){
         List<String> lista=nfeDAO.listaChavesNfePorData(ini, fim, "65");
        
        String caminhoOrigem=clsConfig.configuracaogeral.getCaminhoxml()+"nfce\\xml\\";
        String caminhoFim=clsConfig.configuracaogeral.getCaminhoxml()+"contador\\temp\\";
        
        File origem=null;
        File camfim=null;
        
        for(String arq : lista){
            try {
                origem=new File(caminhoOrigem+arq+".xml");
                camfim =new File(caminhoFim+arq+".xml");
                Files.copy(origem.toPath(), camfim.toPath());
            } catch (IOException ex) {
                Logger.getLogger(ClsGeraXmlContabilidade.class.getName()).log(Level.SEVERE, null, ex);
                Logs.gravarLog.gravaSemMensagem(ex.getMessage());
            }
           
        }
    
    }
    private void copiarNfe(Date ini,Date fim){
         List<String> lista=nfeDAO.listaChavesNfePorData(ini, fim, "55");
        
        String caminhoOrigem=clsConfig.configuracaogeral.getCaminhoxml()+"nfe\\xml\\";
        String caminhoFim=clsConfig.configuracaogeral.getCaminhoxml()+"contador\\temp\\";
        
        File origem=null;
         File camfim=null;
        
        for(String arq : lista){
            try {
                origem=new File(caminhoOrigem+arq+".xml");
                camfim =new File(caminhoFim+arq+".xml");
                Files.copy(origem.toPath(), camfim.toPath());
            } catch (IOException ex) {
                Logger.getLogger(ClsGeraXmlContabilidade.class.getName()).log(Level.SEVERE, null, ex);
                //Logs.gravarLog.main(ex.getMessage());
            }
           
        }
    
    }
    
}
