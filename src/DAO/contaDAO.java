/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.clsConta;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class contaDAO {
    public void inserir(clsConta clct){
        try {
            String sql="insert into tconta(id_conta,nome_conta, observacao, limite,saldo,tipo) values("
                    + "gen_id(gen_tconta_id,1),?,?,?,?,0);";
            PreparedStatement pd = conexao.getPreparedStatement(sql);
            pd.setString(1, clct.getContanome());
            pd.setString(2, clct.getObs());
            pd.setString(3, clct.getLimite());
            pd.setString(4, clct.getSaldo());
            pd.executeUpdate();
            pd.close();
            JOptionPane.showMessageDialog(null, "Gravado com sucesso ...");
        } catch (SQLException ex) {
            Logger.getLogger(contaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    public void alterar(clsConta clt){
        try {
            String sql="update tconta set nome_conta=?, observacao=?, limite=?, saldo=? where id_conta=?;";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, clt.getContanome());
            ps.setString(2, clt.getObs());
            ps.setString(3, clt.getLimite());
            ps.setString(4, clt.getSaldo());
            ps.setString(5, clt.getId());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso...");
        } catch (SQLException ex) {
            Logger.getLogger(contaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    public void excluir(String id){
        try {
            String sql="delete from tconta where id_conta=?;";
            PreparedStatement ps=conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro excluido...");
        } catch (SQLException ex) {
            Logger.getLogger(contaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
