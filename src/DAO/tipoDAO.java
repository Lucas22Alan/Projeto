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
 * @author lucas
 */
public class tipoDAO {
    public void inserirTipo(String desc, String cat, String dir,String id,String dre){
        try {
            String sql="insert into ttipo_movimento (id_tipo, descricao_movimento, categoria, direcao,composicao_dre)\n" +
                    "values (gen_id(gen_ttipo_movimento_id,1),?,?,?,?);";
            if (id.equals("0"));
            else{
                sql="UPDATE OR INSERT INTO TTIPO_MOVIMENTO (ID_TIPO, DESCRICAO_MOVIMENTO, CATEGORIA, DIRECAO,composicao_dre)\n" +
"                               VALUES ("+id+", ?, ?, ?,?)\n" +
"                             MATCHING (ID_TIPO);";
            }
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, desc);
            ps.setString(2, cat);
            ps.setString(3, dir);
            ps.setString(4, dre);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso...");
        } catch (SQLException ex) {
            Logger.getLogger(tipoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    public void inserirSubTipo(String desc, String cat, String dir, String tpref,String id,String dre){
        try {
            String slq="insert into ttipo_movimento (id_tipo, descricao_movimento, categoria, tip_referente, direcao,composicao_dre)\n" +
                    "values (gen_id(gen_ttipo_movimento_id,1),?,?,?,?,?);";
              if (id.equals("0"));
            else{
                slq="UPDATE OR INSERT INTO TTIPO_MOVIMENTO (ID_TIPO, DESCRICAO_MOVIMENTO, CATEGORIA, TIP_REFERENTE, DIRECAO, COMPOSICAO_DRE)\n" +
"                               VALUES ("+id+", ?, ?, ?, ?, ?)\n" +
"                             MATCHING (ID_TIPO);";
            }
            PreparedStatement ps = conexao.getPreparedStatement(slq);
            ps.setString(1, desc);
            ps.setString(2, cat);
            ps.setString(3, tpref);
            ps.setString(4, dir);
            ps.setString(5, dre);
            ps.executeLargeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso...");
        } catch (SQLException ex) {
            Logger.getLogger(tipoDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
