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
import model.Tcad_armas;

/**
 *
 * @author Lucas
 */
public class TarmasDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void incluirAtualizar(Tcad_armas arma ){
        try {
            String sql="UPDATE OR INSERT INTO TCAD_ARMAS (IDPARCEIRO, CPF, ESPECIE, MARCA, MODELO, CALIBRE, SIGMA, SERIE)\n" +
                    "                          VALUES (?,?,?,?,?,?,?,?)\n" +
                    "                        MATCHING (SERIE);";
            ps=conexao.getPreparedStatement(sql);
            ps.setInt(1, arma.getIdparceiro());
            ps.setString(2, arma.getCpf());
            ps.setString(3, arma.getEspecie());
            ps.setString(4, arma.getMarca());
            ps.setString(5, arma.getModelo());
            ps.setString(6, arma.getCalibre());
            ps.setString(7, arma.getSigma());
            ps.setString(8, arma.getRegistro());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarmasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void removeArma(String idparceiro,String registro){
        try {
            String sql="delete from TCAD_ARMAS where IDPARCEIRO=? and serie=?";
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, idparceiro);
            ps.setString(2, registro);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarmasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Tcad_armas>  retornaListaArmas(String cpf){
        List<Tcad_armas> lista= new ArrayList<>();
        try {
            String sql="select * from tcad_armas where cpf=?";
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, cpf);
            rs=ps.executeQuery();
            while(rs.next()){
                Tcad_armas cad= new Tcad_armas();
                cad.setCalibre(rs.getString("calibre"));
                cad.setCpf(rs.getString("cpf"));
                cad.setEspecie(rs.getString("especie"));
                cad.setIdparceiro(rs.getInt("idparceiro"));
                cad.setMarca(rs.getString("marca"));
                cad.setModelo(rs.getString("modelo"));
                cad.setRegistro(rs.getString("serie"));
                cad.setSigma(rs.getString("sigma"));
                lista.add(cad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TarmasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
