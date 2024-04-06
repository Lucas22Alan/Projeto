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
import model.clsPagamentos;

/**
 *
 * @author Lucas
 */
public class PagamentosAdmDAO {
    
    public List<clsPagamentos> retornaPagamentos(String mvto){
        List<clsPagamentos>  lista= new ArrayList<>();
        try {
            String sql="select * from tpagamentos_adm where id_mov= ? and estado='2'";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, mvto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                clsPagamentos pg = new clsPagamentos();
                pg.setIdfinalizadora(rs.getString("id_finalizadora"));
                pg.setValor(rs.getString("valor_recebido"));
                pg.setDataemissao(rs.getString("data"));
                pg.setDatavencimento(rs.getString("vencimento"));
                pg.setParcela(rs.getString("sequencia_finalizadora"));
                lista.add(pg);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PagamentosAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
