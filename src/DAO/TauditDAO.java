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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Taudit_prod;
import model.clsConfig;

/**
 *
 * @author Lucas
 */
public class TauditDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    
    
    public void inserir(String prod,Double vlant,Double vldp){
        try {
            String sql="INSERT INTO TAUDIT_PROD (ID, IDPRODUTO, VALORANT, VALORNOVO, USUARIO, DATAOPERACAO)\n" +
                    "                 VALUES (gen_id(gen_taudit_prod_id,1),?,?,?,?,current_timestamp);";
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, prod);
            ps.setDouble(2, vlant);
            ps.setDouble(3, vldp);
            ps.setString(4, clsConfig.usuarioLogado);
            ps.executeUpdate();
            ps.close();
                    
            } catch (SQLException ex) {
            Logger.getLogger(TauditDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Taudit_prod> retornaRegistros(String id){
        List<Taudit_prod> lista= new ArrayList<>();
        try {
            String sql="select * from TAUDIT_PROD where idproduto=?";
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                Taudit_prod aud= new Taudit_prod();
                aud.setId(rs.getInt(1));
                aud.setIdproduto(rs.getString(2));
                aud.setValorant(rs.getDouble(3));
                aud.setValornovo(rs.getDouble(4));
                aud.setUsuario(rs.getString(5));
                aud.setDataoperacao(rs.getString(6));
                lista.add(aud);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TauditDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
