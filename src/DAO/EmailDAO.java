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
import model.Tconfig_email;

/**
 *
 * @author Mk Solucoes
 */
public class EmailDAO {
    
    public void inserirAtualizar(Tconfig_email mail){
        try {
            String sql="UPDATE OR INSERT INTO TCONFIG_EMAILL (EMAIL, SENHA, PORTA, SMTP, TLS, AUTH,id)\n" +
                    "                              VALUES (?,?,?,?,?,?,1)\n" +
                    "                            MATCHING (id);";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, mail.getEmail());
            ps.setString(2, mail.getSenha());
            ps.setString(3, mail.getPorta());
            ps.setString(4, mail.getSmtp());
            ps.setString(5, mail.getTls());
            ps.setString(6, mail.getAut());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    public static Tconfig_email buscar(Tconfig_email mail){
        try {
            String sql="select * from tconfig_emaill where id=1";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            mail.setAut(rs.getString("auth"));
            mail.setEmail(rs.getString("email"));
            mail.setPorta(rs.getString("porta"));
            mail.setSenha(rs.getString("senha"));
            mail.setSmtp(rs.getString("smtp"));
            mail.setTls(rs.getString("tls"));
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
            
        return mail;
    
    }
    
    
}
