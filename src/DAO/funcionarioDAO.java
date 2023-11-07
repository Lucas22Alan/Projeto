/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mk Solucoes
 */
public class funcionarioDAO {
    
    public void inserir(String nome,String vendedor){
        try {
            String sql="INSERT INTO TFUNCIONARIOS (ID, NOME, FUNCAO, SALARIO, COMISSAO, VENDEDOR)\n" +
                    "                   VALUES (gen_id(GEN_TFUNCIONARIOS_ID,1), ?, ?, ?, ?, ?);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, "");
            ps.setString(3, "0.00");
            ps.setString(4, "0");
            ps.setString(5, vendedor);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir!!!\n"+ex.getMessage());
            Logger.getLogger(funcionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void atualizar(String nome,String vendedor,String id){
        try {
            String sql="update tfuncionarios set nome=? ,vendedor=? where id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, nome);
            ps.setString(3, id);
            ps.setString(2, vendedor);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir!!!\n"+ex.getMessage());
            Logger.getLogger(funcionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void excluir(String id){
        try {
            String sql="delete from tfuncionarios where id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(funcionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
