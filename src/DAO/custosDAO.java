/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.clsConfig;

/**
 *
 * @author lucas
 */
public class custosDAO {
    public static void atualizaCustoAtual(String preco, String idprod){
        try {
            String sql="update tprecos set custo_atual=?,preco_custo=? where id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, preco);
            ps.setString(2, preco);
            ps.setString(3, idprod);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(custosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    };
    public static  Boolean verificarUltimoLancamentoItem(String mvtoAtual,String codbarras){
        Boolean ret=false;
        try {
            String sql="select first 1 ti.id_mov,tm.data from titens ti\n" +
                        "left join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                        "where ti.codi_barra=? and  tm.id_tipo=3  order by tm.data desc";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, codbarras);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Long mov=rs.getLong(1);
                if(Long.parseLong(mvtoAtual)>=mov){
                    ret=true;
                }
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            
            Logger.getLogger(custosDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return ret;
    
    }
    
    public static void atualizaCustoCstNcmNfEntrada(String ncm,String cst,String prec,String id){
     try {
           String sql="update tprecos tc  set tc.prec_venda_ant=tc.preco_venda, tc.cst_ant=tc.sit_tributaria,tc.ncm_ant=tc.ncm,\n" +
            "tc.alteracao=current_timestamp, tc.us_alteracao=?,tc.origem_alteracao=?,\n" +
            "tc.preco_venda=?,tc.ncm=?,tc.sit_tributaria=? where id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, clsConfig.usuarioLogado);
            ps.setString(2, "Cadastro Nfe Compra");
            ps.setString(3, prec);
            ps.setString(4, ncm);
            ps.setString(5, cst);
            ps.setString(6, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(custosDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    }
    public static void atualizaDescricaoNFeCompra(String descr,String id){
     try {
           String sql="update tprodutos tp set tp.nomelongo=?,nomecurto=? where id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            if(descr.length()>59)descr=descr.substring(0, 59);
            ps.setString(1, descr);
            ps.setString(2, descr);
            ps.setString(3, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(custosDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    }
    public  void atualizaReferenciaNfeCompra(String descr,String id){
     try {
           String sql="update tbarras tp set tp.referencia=? where id_produto=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            if(descr.length()>19)descr=descr.substring(0, 19);
            ps.setString(1, descr);
            ps.setString(2, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(custosDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    }
}
