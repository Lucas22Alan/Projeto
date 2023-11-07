/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.clsBalanca;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mk Solucoes
 */
public class balancaDAO {
    public static clsBalanca retornaBalanca(clsBalanca bal){
        try {
            String sql="select * from tcad_balanca where id_balanca=?";
            PreparedStatement ps=conexao.getPreparedStatementResult(sql);
            ps.setString(1, bal.getCod());
            ResultSet rs = ps.executeQuery();
            rs.first();
            bal.setCaminho(rs.getString("diretorio"));
            bal.setNome(rs.getString("descricao"));
            bal.setTipo(rs.getString("tipo"));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(balancaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados \n" +ex.getMessage());
        }
        
    return bal;
    
    }
    
}
