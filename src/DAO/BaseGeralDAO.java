/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Logs.gravarLog;
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
public class BaseGeralDAO {
    
    public String gerarIds(String generador){
        String ret="0";
        try {
            String sql="select gen_id("+generador+",1) from rdb$database;";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ret=rs.getString(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            gravarLog.main("Falha Ao Solicitar Id :"+ex.getMessage());
            Logger.getLogger(BaseGeralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
        
    }
}
