/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.clsConfig;
import classes.clsaux;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mk Solucoes
 */
public class permissaoUsuarioDAO {
    
    public static Boolean validado=false;
    public static boolean verificaPermissaoUsuConectado(String idpermissao){
         boolean retorno=false;
        try {
            String sql="select count(tp.id_permissao)  from tpermissao_gp_usuario tp\n" +
                    "join tgrupo_usuario tg on tp.id_gp_usuario=tg.id_gp_usuario\n" +
                    "join tusuarios tr on tr.grupo_usuario=tg.id_gp_usuario\n" +
                    "where tp.id_permissao=? and tr.idusuario=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idpermissao);
            ps.setString(2, clsaux.retornaId(clsConfig.usuarioLogado));
            ResultSet rs = ps.executeQuery();
            rs.first();
            if (rs.getInt(1)==0){
                
            }else{
                retorno=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(permissaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return retorno;
   }
    public static int verificaPermissaoUsuInformado(String id,String senha,String permissao){
        int retorno=0;
        try {
            String sql="select count(tp.id_permissao)  from tpermissao_gp_usuario tp\n" +
                    "join tgrupo_usuario tg on tp.id_gp_usuario=tg.id_gp_usuario\n" +
                    "join tusuarios tr on tr.grupo_usuario=tg.id_gp_usuario\n" +
                    "where tp.id_permissao=? and tr.idusuario=? and tr.senha=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, permissao);
            ps.setString(2, id);
            ps.setString(3, senha);
            ResultSet rs = ps.executeQuery();
            rs.first();
            retorno=rs.getInt(1);
            rs.close();
            ps.close();
    
    } catch (SQLException ex) {
            Logger.getLogger(permissaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return retorno;
    }
    
}
