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
import javax.swing.JOptionPane;
import model.Tcad_campanha;

/**
 *
 * @author Lucas
 */
public class CampanhaDAO {
    PreparedStatement ps;
    ResultSet rs;
    
    public  List<Tcad_campanha>  retornaListaCampanhas(){
        List<Tcad_campanha> lista= new ArrayList<>();
        try {
            String sql= "select * from tcad_campanha";
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Tcad_campanha camp= new Tcad_campanha();
                camp.setIdcampanha(rs.getInt(1));
                camp.setNome(rs.getString(2));
                camp.setSituacao(rs.getString(3));
                camp.setSeg(rs.getDouble(4));
                camp.setTer(rs.getDouble(5));
                camp.setQua(rs.getDouble(6));
                camp.setQui(rs.getDouble(7));
                camp.setSex(rs.getDouble(8));
                camp.setSab(rs.getDouble(9));
                camp.setDom(rs.getDouble(10));
                camp.setTipo(rs.getString(11));
                lista.add(camp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    
    
    }
    public Tcad_campanha retornaCampanha(int id){
        Tcad_campanha camp= new Tcad_campanha();   
        try {
            String sql= "select * from tcad_campanha where idcampanha="+id;
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                camp.setIdcampanha(rs.getInt(1));
                camp.setNome(rs.getString(2));
                camp.setSituacao(rs.getString(3));
                camp.setSeg(rs.getDouble(4));
                camp.setTer(rs.getDouble(5));
                camp.setQua(rs.getDouble(6));
                camp.setQui(rs.getDouble(7));
                camp.setSex(rs.getDouble(8));
                camp.setSab(rs.getDouble(9));
                camp.setDom(rs.getDouble(10));
                camp.setTipo(rs.getString(11));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return camp;
    }
    
    public void inserirCampanha(Tcad_campanha camp){
        try {
            String sql="UPDATE OR INSERT INTO  TCAD_CAMPANHA (IDCAMPANHA, NOME, SITUACAO, SEG, TER, QUA, QUI, SEX, SAB, DOM, TIPO)\n" +
                    "                   VALUES (?,?,?,?,?,?,?,?,?,?,?)  MATCHING (IDCAMPANHA);";
            ps=conexao.getPreparedStatement(sql);
            ps.setInt(1, camp.getIdcampanha());
            ps.setString(2, camp.getNome());
            ps.setString(3, camp.getSituacao());
            ps.setDouble(4, camp.getSeg());
            ps.setDouble(5, camp.getTer());
            ps.setDouble(6, camp.getQua());
            ps.setDouble(7, camp.getQui());
            ps.setDouble(8, camp.getSex());
            ps.setDouble(9, camp.getSab());
            ps.setDouble(10, camp.getDom());
            ps.setString(11, camp.getTipo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Gravado Com Sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CampanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
