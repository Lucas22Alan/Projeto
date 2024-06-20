/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.ClsDadosDevolucaoItem;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class BaseDevolucaoDAO {
    
    PreparedStatement ps ;
    ResultSet rs;
    
    
    public List<ClsDadosDevolucaoItem> retornaListaMovimentoRefItem(String barras){
       List<ClsDadosDevolucaoItem> lista= new ArrayList<>();
        try {
            String sql="select tm.data,tm.numero_documento,tm.serie,tm.chave_acesso,ti.quantidade,ti.prec_venda from titens ti\n" +
                    "join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                    " where ti.codi_barra=? and tm.id_tipo=3 and tm.estado=2";
            
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, barras);
            rs=ps.executeQuery();
            while (rs.next()){
                 ClsDadosDevolucaoItem it= new ClsDadosDevolucaoItem();
                 it.setData(rs.getString(1));
                 it.setDocumento(rs.getString(2));
                 it.setSerie(rs.getString(3));
                 it.setChaveAcesso(rs.getString(4));
                 it.setQuantidade(rs.getString(5));
                 it.setPreco(rs.getString(6));
                 lista.add(it);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDevolucaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
