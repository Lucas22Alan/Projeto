/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Logs.gravarLog;
import conexoes.conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TcadCalibre;
import model.TcadCalibreTiro;
import model.Thabitualidade;

/**
 *
 * @author Lucas
 */
public class TcadCalibreDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    
    
    public void inserirCalibre(TcadCalibre cal){
        try {
            String sql="UPDATE OR INSERT INTO TCAD_CALIBRE (ID, NOME)\n" +
                    "                            VALUES (?, ?)\n" +
                    "                          MATCHING (ID);";
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, cal.getId());
            ps.setString(2, cal.getNome());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            gravarLog.main(ex.getMessage());
            Logger.getLogger(TcadCalibreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public boolean inserirTipoCalibre(TcadCalibreTiro cal){
       boolean ret=false;
         try {
            String sql="UPDATE OR INSERT INTO TCAD_CALIBRE_TIPO (IDTIPO, NOME, ID)\n" +
                    "                                 VALUES (?,?,?)\n" +
                    "                               MATCHING (ID);";
            ps= conexao.getPreparedStatement(sql);
            ps.setString(1, cal.getIdtipo());
            ps.setString(2, cal.getNome());
            ps.setString(3, cal.getId());
            ps.executeUpdate();
            ret=true;
        } catch (SQLException ex) {
             gravarLog.main(ex.getMessage());
            Logger.getLogger(TcadCalibreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    public List<TcadCalibre> buscaCalibres(){
         List<TcadCalibre> lista= new ArrayList<>();
        try {
            String sql="select * from TCAD_CALIBRE";
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                TcadCalibre cal= new TcadCalibre();
                cal.setId(rs.getString(1));
                cal.setNome(rs.getString(2));
                lista.add(cal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TcadCalibreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lista;
     }
    public List<TcadCalibreTiro> buscaTipos(String tipo){
         List<TcadCalibreTiro> lista= new ArrayList<>();
        try {
            String sql="select * from tcad_calibre_tipo where idtipo=?";
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, tipo);
            rs=ps.executeQuery();
            while(rs.next()){
                TcadCalibreTiro cal= new TcadCalibreTiro();
                cal.setId(rs.getString(3));
                cal.setIdtipo(rs.getString(1));
                cal.setNome(rs.getString(2));
                lista.add(cal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TcadCalibreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lista;
     }
    
     
    public List<String> retornaListaCalibres(){
         List<String> retorno= new ArrayList<>();
        try {
            String sql="select nome from tcad_calibre";
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                retorno.add(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TcadCalibreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
     }
    public List<String> retornaListaTipos(){
         List<String> retorno= new ArrayList<>();
        try {
            String sql="select nome from tcad_calibre_tipo";
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                retorno.add(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TcadCalibreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
     }
    public List<String> retornaListaEventos(){
         List<String> retorno= new ArrayList<>();
        try {
            String sql="select descricao from TCAD_PROVAS";
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                retorno.add(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TcadCalibreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
     }
    public List<Thabitualidade> buscarHabitualidade(Date dataini,Date datafim,String tipoevento,String calibre,String idparceiro){
        List<Thabitualidade> lista= new ArrayList<>();
        try {
            String sql="select * from thabitualidade tp where tp.data between '"+dataini+"' and '"+datafim+"' and tp.tipo='"+tipoevento+"' and tp.id_parceiro=?";
            if(!calibre.equals("0")){
                sql="select tp.* from thabitualidade tp\n" +
                        "join thab_itens ti on tp.id=ti.idhab\n" +
                        "where tp.data between '"+dataini+"' and '"+datafim+"' and tp.tipo='"+tipoevento+"' \n" +
                        "and ti.calibre in (\n" +
                        "select tc.nome from tcad_calibre_tipo tc\n" +
                        "join tcad_calibre tb on tc.idtipo=tb.id\n" +
                        "where tb.nome='"+calibre+"') and tp.id_parceiro=? ";
            }
            System.out.println(sql);
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, idparceiro);
            rs=ps.executeQuery();
            while(rs.next()){
                Thabitualidade hab= new Thabitualidade();
                hab.setControle(rs.getString("controle"));
                hab.setCpf(rs.getString("cpf"));
                hab.setData(rs.getDate("data"));
                hab.setId(rs.getString("id"));
                hab.setIdparceiro(rs.getString("id_parceiro"));
                hab.setTipo(rs.getString("tipo"));
                lista.add(hab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TcadCalibreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
    }



}
