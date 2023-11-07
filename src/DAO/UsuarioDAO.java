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
import model.Tusuarios;

/**
 *
 * @author Mk Solucoes
 */
public class UsuarioDAO {
    
    
    
    public List<String> retornaGrupoUsuario(){
         List<String> lista= new ArrayList<>();
        try {
            String sql="select * from tgrupo_usuario";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lista.add(rs.getString(1)+"- "+rs.getString(2));    
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public String retornaIdProximoUsuario(){
        String ret="0";
        try {
            String sql="select gen_id(\"GEN_TUSUARIOS _ID\",1) from RDB$DATABASE";
            PreparedStatement ps= conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            ret=rs.getString(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    public void removerUsuario(String id){
        try {
            String sql="update tusuarios set excluido='S' where idusuario=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
        
    
    }
    public void inserirAlterar(Tusuarios use){
        try {
            String sql="UPDATE OR INSERT INTO TUSUARIOS (IDUSUARIO, NOME_USUARIO, SENHA, GRUPO_USUARIO,excluido)\n" +
                    "                         VALUES (?,?,?,?,'N')\n" +
                    "                       MATCHING (IDUSUARIO);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, use.getIdusuario());
            ps.setString(2, use.getNome());
            ps.setString(3, use.getSenha());
            ps.setString(4, use.getGrupo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    }
    
    public List<Tusuarios> retornaListaUsuarios(){
        List<Tusuarios> lista= new ArrayList<>();
        try {
            String sql="select ts.*,tg.descricao from tusuarios ts\n" +        
                    "left join tgrupo_usuario tg on ts.grupo_usuario=tg.id_gp_usuario where excluido='N'";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Tusuarios usu= new Tusuarios();
                usu.setIdusuario(rs.getString(1));
                usu.setNome(rs.getString(2));
                usu.setSenha(rs.getString(3));
                usu.setGrupo(rs.getString(4)+"- "+rs.getString(6));
                lista.add(usu);
            } 
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return lista;
    }
}
