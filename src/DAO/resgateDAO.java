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
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class resgateDAO {
    public void inserir(String idmvto,String parc,String pts){
        try {
            String sql="insert into tresgate_pontos (id, id_movimento,id_parceiro,data,hora,qnt_pontos,estado)\n" +
                    "values(gen_id(gen_tresgate_pontos_id,1),?,?,current_date,current_time,?,2)";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idmvto);
            ps.setString(2, parc);
            ps.setString(3, pts);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(resgateDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro para inserir dados..\n"+ex.getMessage());
        }
        
    }
    public static int buscaPtsResgatados(String parceiro){
        int ret=0;
        try {
            String sql="select sum(qnt_pontos) as total\n" +
                    "from tresgate_pontos\n" +
                    "where estado='2' and id_parceiro=?";
            PreparedStatement ps= conexao.getPreparedStatementResult(sql);
            ps.setString(1, parceiro);
            ResultSet rs = ps.executeQuery();
            rs.first();
            ret=rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(resgateDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro para buscar dados de pontos..\n"+ex.getMessage());
        }
        return ret;
    } 
        
}
