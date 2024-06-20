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


/**
 *
 * @author Lucas
 */
public class baseSincronizacaoDAO {
    PreparedStatement ps;
    ResultSet rs;
    
    
    public void criaInfSinc(int tipo,String mvto){
        try {
            String sql="INSERT INTO TSINC_MEUMENU (idsinc, tipo, DATACRIADO, DOCUMENTO, SIT)\n" +
                    "                   VALUES (gen_id(gen_tsinc_meumenu_id,1),?,current_timestamp,?,0);";
            ps= conexao.getPreparedStatement(sql);
            ps.setInt(1, tipo);
            ps.setString(2, mvto);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseSincronizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeInfArma(int tipo,String mvto){
        try {
            String sql="delete from tsinc_meumenu tc where tc.documento=? and tc.tipo=? and tc.sit=0";
            ps= conexao.getPreparedStatement(sql);
            ps.setInt(2, tipo);
            ps.setString(1, mvto);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseSincronizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        
}
