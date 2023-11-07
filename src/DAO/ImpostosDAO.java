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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.clsPisCofins;

/**
 *
 * @author Mk Solucoes
 */
public class ImpostosDAO {
    public List<String> listaSituacaoTributaria(){
        List<String> lista= new ArrayList<>();
        try {
            String sql="select * from tcad_cst";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                String ret=rs.getString(1)+"-"+rs.getString(2);
                lista.add(ret);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.gravaSemMensagem(ex.getMessage());
            Logger.getLogger(ImpostosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        }
     public List<clsPisCofins> listaPisCofins(){
        List<clsPisCofins> lista= new ArrayList<>();
        try {
            String sql="select * from tpis_cofins";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                clsPisCofins ret=new clsPisCofins();
                ret.setCst(rs.getString("pis_cofins"));
                ret.setDescricao(rs.getString("descricao"));
                ret.setAliq_cofins(rs.getString("aliq_cofins"));
                ret.setAliq_pis(rs.getString("aliq_pis"));
                ret.setIdentificacao(rs.getString("identificacao"));    
                lista.add(ret);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.gravaSemMensagem(ex.getMessage());
            Logger.getLogger(ImpostosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        }
      public List<String> listaIpi(){
        List<String> lista= new ArrayList<>();
        try {
            String sql="select * from tcad_ipi";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                String ret=rs.getString("identificacao")+"-"+rs.getString("descricao");
                lista.add(ret);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.gravaSemMensagem(ex.getMessage());
            Logger.getLogger(ImpostosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        }
    
}
