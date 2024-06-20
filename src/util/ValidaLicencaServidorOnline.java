/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import DAO.empresaDAO;
import classes.ClsRetornoLicenca;
import com.google.gson.Gson;
import com.mksolucoes.validarlicenca.ClsConsulta;
import com.mksolucoes.validarlicenca.ConsultaModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import model.clsConfig;

/**
 *
 * @author Mk Solucoes
 */
public class ValidaLicencaServidorOnline {
    empresaDAO dao = new empresaDAO();
    
    public void consultarLicencaValidaCnpj(String cnpj) throws MalformedURLException, IOException{
        cnpj=cnpj+dao.verificaNfcePendente();
        URL url= new URL(clsConfig.configuracaogeral.getUrllicenca()+"/api/validaLicenca/"+cnpj);
        
        HttpURLConnection conect=(HttpURLConnection) url.openConnection();
        conect.setRequestMethod("GET");
        System.out.println("vai validar licenca...");
        
        System.out.println(conect.getResponseCode());
        if(conect.getResponseCode()!=200){
                //vai adicionar 1 a tentativas de consulta, se chegar a 5 ele vai solicitar senha para desbloqueio
            dao.increntaTentativa(empresaDAO.verificaTetativas()+1);
            Logs.gravarLog.gravaSemMensagem(conect.getResponseCode()+" mensagem "+conect.getResponseMessage()+" retorno aws -- url consultada: "+url);
        }else{
            
            BufferedReader bf= new BufferedReader(new InputStreamReader(conect.getInputStream()));
            
            StringBuilder sb= new StringBuilder();
            
            String retorno=null;
            
            while((retorno=bf.readLine())!=null){
                sb.append(retorno);
            }
            
            bf.close();
            conect.disconnect();
            Gson gson= new Gson();
            ClsRetornoLicenca licenca= new ClsRetornoLicenca();
            licenca= gson.fromJson(sb.toString(), ClsRetornoLicenca.class);
            if(licenca==null){
                JOptionPane.showMessageDialog(null,"Sistema Não Cadastrado Para esse CNPJ!!!");
            }else{
            
                if(licenca.getEstado().equals("1")){// estados da licenca, 1- normal, 2-Inativo,3- bloqueado
                    dao.atualizaVencimentoSistema(Integer.parseInt(licenca.getDiasliberar()));
                    dao.increntaTentativa(0);
                }else if(licenca.getEstado().equals("2")){
                    JOptionPane.showMessageDialog(null,"Sistema Inativo Para Esse CNPJ!!!");
                    System.exit(0);
                }else if (licenca.getEstado().equals("3")){
                    JOptionPane.showMessageDialog(null,"Seu Sistema Está Bloqueado\nEntre em Contato Com o Suporte!!! ");
                    System.exit(0);
                }
                }
            
        }
    }
 
    public void conultarLicencaFirebase(String cnpj) throws Exception{
       
            ClsConsulta con= new ClsConsulta();
            ConsultaModel retorno = con.consultaDadosFirebase(cnpj);
            System.out.println(retorno);
            if(retorno==null){
                 dao.increntaTentativa(empresaDAO.verificaTetativas()+1);
                Logs.gravarLog.gravaSemMensagem("sem retorno firebase");
                JOptionPane.showMessageDialog(null,"Falha Para Validar Licença");
                
            }else{
                
                    if(retorno.getSituacao()==1){// estados da licenca, 1- normal, 2-Inativo,3- bloqueado
                        dao.atualizaVencimentoSistema(retorno.getDiasliberar());
                        dao.increntaTentativa(0);
                    }else if(retorno.getSituacao()==2){
                        JOptionPane.showMessageDialog(null,"Sistema Inativo Para Esse CNPJ!!!");
                        System.exit(0);
                    }else if (retorno.getSituacao()==3){
                        JOptionPane.showMessageDialog(null,"Seu Sistema Está Bloqueado\nEntre em Contato Com o Suporte!!! ");
                        System.exit(0);
                    }else if (retorno.getSituacao()==0){
                        JOptionPane.showMessageDialog(null,"Sistema Não Cadastrado Para Esse CNPJ !");
                        System.exit(0);
                    }
                    }
             
    }
    
    
}
