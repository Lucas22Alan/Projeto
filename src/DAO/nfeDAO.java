/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.clsaux;
import model.clsNfTransporte;
import model.clsNfe;
import conexoes.conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.clsConfig;

/**
 *
 * @author Mk Solucoes
 */
public class nfeDAO {
    
    public static String gerarNumeroNfe(){
       String numero="0";
        try {
            String sqlid="select gen_id(gen_tnotafiscal_numero,1) from rdb$database;";
            PreparedStatement ps = conexao.getPreparedStatementResult(sqlid);
            ResultSet rs = ps.executeQuery();
            rs.first();
            numero=rs.getString(1);
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados\n" +ex.getMessage());
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return numero; 
    }

    public static void atualizaChaveMovimento(Long idmovimento, String chave) {
        try {
            String sql="update tmovimento set chave_acesso=? where id_mov=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, chave);
            ps.setString(2, idmovimento.toString());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados \n" +ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public static void inserirMovimentoNfe(clsNfe nfe){
        try {
            String sql="UPDATE OR INSERT INTO TNOTA_FISCAL (ID_MOVIMENTO, CSTAT, DATA_AUTORIZACAO, DATA_CANCELAMENTO, RECIBO, PROTOCOLO_AUTORIZACAO, PROTOCOLO_CANCELAMENTO, "
                    + "FINALIDADE, IND_DEST, PRESENCA_COMPRADOR, CONSUMIDOR_FINAL, IND_INSCRICAO,observacao,motivo_sefaz)\n" +
                    "                            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)\n" +
                    "                          MATCHING (ID_MOVIMENTO);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, nfe.getId_movimento());
            ps.setString(2, nfe.getCstat());
            ps.setDate(3, nfe.getDataaut());
            ps.setDate(4, nfe.getDatacanc());
            ps.setString(5, nfe.getRecibo());
            ps.setString(6, nfe.getProtocoloaut());
            ps.setString(7, nfe.getProtocolocanc());
            ps.setString(8, nfe.getFinalidade());
            ps.setString(9, nfe.getInddest());
            ps.setString(10, nfe.getPrescomp());
            ps.setString(11, nfe.getConsfinal());
            ps.setString(12, nfe.getIndie());
            ps.setString(13, nfe.getObservacaoNf());
            ps.setString(14, nfe.getMotivo());
            ps.executeUpdate();
            ps.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro ao inserir dados \n" +ex.getMessage());
               Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void gerarNfePartirVenda(clsNfe nfe){
        try {
            String sql="update tmovimento tm set tm.id_modelo='55',tm.mvto_origem=tm.numero_documento, tm.numero_documento=?,tm.serie=?\n" +
                    "where tm.id_mov=?";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, nfeDAO.gerarNumeroNfe());
            ps.setString(2, clsConfig.configuracaogeral.getSerienfe());
            ps.setString(3, nfe.getId_movimento());
            ps.executeUpdate();
            ps.close();
            nfeDAO.inserirMovimentoNfe(nfe);
        } catch (SQLException ex) {
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    
    }
    public static clsNfe retornaDadosMovNf(Long idmovimento) {
         clsNfe nf= new clsNfe();
        try {
            String sql="select * from tnota_fiscal tn where id_movimento=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idmovimento.toString());
            ResultSet rs = ps.executeQuery();
            rs.first();
            nf.setId_movimento(rs.getString("id_movimento"));
            nf.setCstat(rs.getString("cstat"));
            nf.setDataaut(rs.getDate("data_autorizacao"));
            nf.setDatacanc(rs.getDate("data_cancelamento"));
            nf.setFinalidade(rs.getString("finalidade"));
            nf.setInddest(rs.getString("ind_dest"));
            nf.setIndie(rs.getString("ind_inscricao"));
            nf.setConsfinal(rs.getString("consumidor_final"));
            nf.setPrescomp(rs.getString("presenca_comprador"));
            nf.setProtocoloaut(rs.getString("protocolo_autorizacao"));
            nf.setProtocolocanc(rs.getString("protocolo_cancelamento"));
            nf.setRecibo(rs.getString("recibo"));
            nf.setIdentificado(rs.getString("nfce_identificada"));
            nf.setCfp(rs.getString("cpf_cnpj_nfce"));
            nf.setRazao_social(rs.getString("razao_nfce"));
            nf.setRua(rs.getString("nfce_rua"));
            nf.setBairro(rs.getString("nfce_bairro"));
            nf.setNumero(rs.getString("nfce_numero"));
            nf.setCidade(rs.getString("nfce_cidade"));
            nf.setUf(rs.getString("nfce_uf"));
            nf.setCep(rs.getString("nfce_cep"));
            nf.setCodmun(rs.getString("nfce_cod_mun"));
            nf.setTipoemissao(rs.getString("tipo_emissao"));
            nf.setObservacaoNf(rs.getString("observacao"));
            nf.setMotivo(rs.getString("motivo_sefaz"));
           rs.close();
           ps.close();
            } catch (SQLException ex) {
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nf;
    }

    public static void gravarReciboNfe(String idmovimento, String recibo) {
        try {
            String sql="update tnota_fiscal set recibo=? where id_movimento=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, recibo);
            ps.setString(2, idmovimento.toString());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados \n" +ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void inserirAtualizaTransporteNf(clsNfTransporte nf){
        try {
            String sql="UPDATE OR INSERT INTO TNF_TRANSPORTADORA (ID_MOVIMENTO, ID_TRANSPORTADORA, CNPJ, RAZAO, UF, CIDADE, MODALIDADE_FRETE, PESO_LIQ, PESO_BRUTO, VOLUMES, ESPECIE, NUMEROS)\n" +
                    "                                  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
                    "                                MATCHING (ID_MOVIMENTO);";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, nf.getIdmovimento());
            ps.setString(2, nf.getIdtranspprtadora());
            ps.setString(3, nf.getCnpj());
            ps.setString(4, nf.getRazao());
            ps.setString(5, nf.getUf());
            ps.setString(6, nf.getCidade());
            ps.setString(7, nf.getModfrete());
            ps.setString(8, nf.getPesoliq());
            ps.setString(9, nf.getPesobruto());
            ps.setString(10, nf.getVolumes());
            ps.setString(11, nf.getEspecie());
            ps.setString(12, nf.getNumero());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao inserir dados da transportadora!!!\n" +ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static clsNfTransporte retornaDadosTransporte(clsNfTransporte mov){
        try {
            String sql="select * from tnf_transportadora where id_movimento=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, mov.getIdmovimento());
            System.out.println(mov.getIdmovimento());
            ResultSet rs = ps.executeQuery();
            rs.first();
            mov.setIdtranspprtadora(rs.getString(2));
            mov.setCnpj(rs.getString(3));
            mov.setRazao(rs.getString(4));
            mov.setUf(rs.getString(5));
            mov.setCidade(rs.getString(6));
            mov.setModfrete(rs.getString(7));
            mov.setPesoliq(rs.getString(8));
            mov.setPesobruto(rs.getString(9));
            mov.setVolumes(rs.getString(10));
            mov.setEspecie(rs.getString(11));
            mov.setNumero(rs.getString(12));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar dados da transportadora!!!\n" +ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mov;    
    }
    
    public static void gravaInfReferencia(String mvto,String chave){
        try {
            String sql="UPDATE OR INSERT INTO TNF_REFERENCIA (ID_MOVIMENTO, CHAVE_ACESSO)\n" +
                    "                              VALUES (?, ?)\n" +
                    "                            MATCHING (ID_MOVIMENTO, CHAVE_ACESSO);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1,mvto);
            ps.setString(2, chave);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados Referencia!!!\n" +ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void RemoveInfReferencia(String mvto,String chave){
        try {
            String sql="delete from tnf_referencia where id_movimento=? and chave_acesso=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1,mvto);
            ps.setString(2, chave);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados Referencia!!!\n" +ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<String> retornaInfReferencia(String mvto){
        List<String> retorno= new ArrayList();
        try {
            
            String sql="select chave_acesso from tnf_referencia where id_movimento=?";
            PreparedStatement ps= conexao.getPreparedStatement(sql);
            ps.setString(1, mvto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                retorno.add(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados Referencia!!!\n" +ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno; 
            
    }
    public static List<String> listaChavesNfePorData(Date dataini,Date datafim,String modelo){
       List<String> lista= new ArrayList();
        try {
            String sql="select tm.chave_acesso from tmovimento tm\n" +
                    "left join  tnota_fiscal tn on tm.id_mov=tn.id_movimento\n" +
                    "where (tn.cstat=100 or tn.cstat=150) and tm.dat_finalizacao between ? and ? "
                    + " and tm.id_modelo=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setDate(1, dataini);
            ps.setDate(2, datafim);
            ps.setString(3, modelo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                 lista.add(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    
    }

    public static void realizaRateioDescontoItens(String idmov, Double valordesconto,Double totalger){
        try {
            Double perc=valordesconto*100/totalger;
            Double vlite=0.00;
            String sqlContagemItens="select ti.id_mov,ti.num_item,ti.id,ti.total from titens ti\n" +
                                    "where ti.id_mov=? and ti.estado=2";
            PreparedStatement ps = conexao.getPreparedStatementResult(sqlContagemItens);
            ps.setString(1, idmov);
            ResultSet rs = ps.executeQuery();
            String sqlValorRateio="update titens ti set ti.desconto=?, ti.total=(ti.quantidade*ti.prec_venda-?)\n" +
                                  "where ti.id_mov=? and ti.id=?;";
            PreparedStatement pss = conexao.getPreparedStatement(sqlValorRateio);
            while(rs.next()){
                vlite=rs.getDouble(4)*perc/100.0;
                if(valordesconto>=vlite){
                 pss.setDouble(1, vlite);
                 pss.setDouble(2, vlite);
                 valordesconto=clsaux.capturaValores(clsaux.formato(valordesconto-vlite));
                
            }else{
                pss.setDouble(1, valordesconto);
                pss.setDouble(2, valordesconto);
            }
                pss.setString(3, idmov);
                pss.setString(4, rs.getString(3));
                pss.executeUpdate();
            
            }
            pss.close();
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
        
        
    }
}
