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
import model.tconfig_integracao;

/**
 *
 * @author Lucas
 */
public class IntegracaoDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void insereAtualiza(tconfig_integracao conf){
        try {
            String sql="UPDATE OR INSERT INTO TCONFIG_INTEGRACAO (IDCONFIG, INT_CARDAPIOONLINE, CODLOJACARDON, LANCAAUTCARDON, FEEDBACKCARDON, PDVINTEGRADO, IDLOJA,tempopreparo)\n" +
                    "                                  VALUES (?,?,?,?,?,?,?,?)\n" +
                    "                                MATCHING (IDCONFIG);";
            ps=conexao.getPreparedStatement(sql);
            ps.setInt(1, conf.getId());
            ps.setString(2, conf.getIntegra());
            ps.setString(3, conf.getCodloja());
            ps.setString(4, conf.getLancautomatico());
            ps.setString(5, conf.getFeedback());
            ps.setString(6, conf.getPdvIntegrado());
            ps.setString(7, conf.getIdloja());
            ps.setString(8, conf.getTempo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IntegracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public tconfig_integracao buscaConf(){
        tconfig_integracao conf= new tconfig_integracao();
        try {
            String sql="select * from TCONFIG_INTEGRACAO where idconfig=1";
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                conf.setId(rs.getInt(1));
                conf.setIntegra(rs.getString(2));
                conf.setCodloja(rs.getString(3));
                conf.setLancautomatico(rs.getString(4));
                conf.setFeedback(rs.getString(5));
                conf.setPdvIntegrado(rs.getString(6));
                conf.setIdloja(rs.getString(7));
                conf.setTempo(rs.getString("tempopreparo"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(IntegracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return conf;
    }
    
}
