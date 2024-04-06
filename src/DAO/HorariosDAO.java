/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.clsaux;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Thorarios;

/**
 *
 * @author Lucas
 */
public class HorariosDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    
    
    public List<Thorarios> retornaHorarios(){
        List<Thorarios> hrs= new ArrayList<>();
        try {
            String sql="select * from thorarios";
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Thorarios hr= new Thorarios();
                hr.setIdconf(rs.getInt(1));
                hr.setDia(rs.getString(2));
                hr.setAbertura(rs.getString(3));
                hr.setFecha(rs.getString(4));
                hrs.add(hr);
            }   
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(HorariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hrs;
    }
    
    public void gravarRegistro(Thorarios hr){
        try {
            String sql="UPDATE OR INSERT INTO THORARIOS (IDCONF, DIA, ABERTURA, FECHA)\n" +
                    "                         VALUES (?,?,?,? )\n" +
                    "                       MATCHING (DIA);";
            
            ps=conexao.getPreparedStatement(sql);
            ps.setInt(1, hr.getIdconf());
            ps.setString(2, hr.getDia());
            ps.setString(3, hr.getAbertura());
            ps.setString(4, hr.getFecha());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(HorariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
