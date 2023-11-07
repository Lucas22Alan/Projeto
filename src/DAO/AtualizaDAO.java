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
 * @author Mk Solucoes
 */
public class AtualizaDAO {
    public static String verificaVersao(){
        String versao="";
        try {
            String sql="select versao_sis from tconfig";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            versao=rs.getString(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AtualizaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return versao;  
    }
    
    public static Boolean executaComando(String sql){
        Boolean ret=false;
        try {
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.executeUpdate();
            ps.close();
            ret=true;
        } catch (SQLException ex) {
            Logs.gravarLog.main(sql+"\n"+ex.getMessage());
            Logger.getLogger(AtualizaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
}
