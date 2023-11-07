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
import model.Tcad_bairro;

/**
 *
 * @author Mk Solucoes
 */
public class BairroDAO {
    PreparedStatement ps;
    ResultSet rs;
    
    
    public void inserirAtualiza(Tcad_bairro bairro){
        try {
            String sql="UPDATE OR INSERT INTO TCAD_BAIRRO (ID, NOME, TAXA_ENTREGA)\n" +
                    "                           VALUES (?,?,?)\n" +
                    "                         MATCHING (ID);";
            ps= conexao.getPreparedStatement(sql);
            ps.setString(1, bairro.getId());
            ps.setString(2, bairro.getNome());
            ps.setDouble(3, bairro.getTaxaEntrega());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Tcad_bairro retornaBairro(Tcad_bairro id){
        try {
            String sql="select * from tcad_bairro where id=?";
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, id.getId());
            rs=ps.executeQuery();
            if(rs.next()){
                id.setNome(rs.getString("nome"));
                id.setTaxaEntrega(rs.getDouble("taxa_entrega"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
        
    }
}
