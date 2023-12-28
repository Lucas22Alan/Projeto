/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impressao;

import DAO.lancDocumentDAO;
import Logs.gravarLog;
import conexoes.conexao;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.clsDadosEmpresa;
import model.clsLancDocCabecalho;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lucas
 */
public class ClaBaseImpressaoGerencial {
    
     public void imprimeCupomVenda(String idmvto) {
         clsLancDocCabecalho mvto = new clsLancDocCabecalho();
       // lancDocumentDAO dao= new lancDocumentDAO();
         mvto.setIdmovimento(idmvto);
         mvto= lancDocumentDAO.buscaCabecalhoDoc(mvto);
        try {
           
            String caminho="c:/esfhera/pdv/nfce/jasper/cupom.jasper";
            HashMap parametros= new HashMap();
            parametros.put("mvto", mvto.getIdmovimento());
            parametros.put("Logo", "c:/esfhera/pdv/imagens/logoCliente.png");
            parametros.put("cnpjEmit", clsDadosEmpresa.getCnpj());
            parametros.put("emitRazao", clsDadosEmpresa.getRazao());
            parametros.put("emitEndereco", clsDadosEmpresa.getRua());
            parametros.put("emitEnderecoNro", clsDadosEmpresa.getNumero());
            parametros.put("emitEnderecoUf", clsDadosEmpresa.getEstado());
            parametros.put("emitEndBairro", clsDadosEmpresa.getBairro());
            parametros.put("emitEnderecoCep", clsDadosEmpresa.getCep());
            parametros.put("emitFone", clsDadosEmpresa.getFone());
            parametros.put("emitIe", clsDadosEmpresa.getIncricao_estadual());
            parametros.put("emitEndrecoCidade", clsDadosEmpresa.getCidade());
            parametros.put("qntItens", String.valueOf("0"));
            parametros.put("vTotal", mvto.getTotalprod());
            parametros.put("vDesc", mvto.getDesconto());
            parametros.put("vAcres", mvto.getOutrasdesp());
            parametros.put("vPagar", mvto.getTotal());
            parametros.put("inf", "PDV: "+mvto.getNumpdv()+"   Data Emissao: "+mvto.getEmissao()+"   Mvto: "+mvto.getIdmovimento());
            parametros.put("rodapecupom", "Reimpressão Cupom Adm");
            if(mvto.getIdparceiro()!=null){
                parametros.put("parceiro", "Cliente: "+mvto.getIdparceiro());
            }
            
            parametros.put("REPORT_CONNECTION", conexao.getConexaoRelatorio());
            
            JasperPrint print= JasperFillManager.fillReport(caminho, parametros, new JREmptyDataSource());
            
            JasperViewer jv = new JasperViewer(print, true);
                         
                        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização", true);
                        viewer.setSize(1024,720);
                        viewer.setLocationRelativeTo(null);
                        viewer.getContentPane().add(jv.getContentPane());
                        viewer.setVisible(true);
            
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            gravarLog.main(ex.getMessage());
            Logger.getLogger(ClaBaseImpressaoGerencial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    
    
    }
    
    
}
