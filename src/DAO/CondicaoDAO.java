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
import model.Tcondicoes_venda;

/**
 *
 * @author Mk Solucoes
 */
public class CondicaoDAO {
    
    
    public void inserirAtualizaCondicao(Tcondicoes_venda cond){
        try {
            String sql="UPDATE OR INSERT INTO TCONDICOES_VENDA (ID_CONDI, DESCRICAO, QNT_PACELAS, DADOS,id_finalizadora,taxa_adm,parceiro,gera_contas_receber)\n" +
                    "                                VALUES (?,?,?,?,?,?,?,?)\n" +
                    "                              MATCHING (ID_CONDI);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, cond.getId());
            ps.setString(2, cond.getDescricao());
            ps.setString(3, cond.getParcelas());
            ps.setString(4, cond.getDados());
            ps.setString(5, cond.getFinalizadora());
            ps.setDouble(6, cond.getTaxa());
            ps.setString(7, cond.getParceiro());
            ps.setString(8, cond.getGera_receber());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(CondicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<Tcondicoes_venda> buscaDados(){
        List<Tcondicoes_venda> lista= new ArrayList<>();
        try {
            String sql="select * from tcondicoes_venda";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Tcondicoes_venda cond= new Tcondicoes_venda();
                cond.setId(rs.getString(1));
                cond.setDescricao(rs.getString(2));
                cond.setParcelas(rs.getString(3));
                cond.setDados(rs.getString(4));
                cond.setFinalizadora(rs.getString("id_finalizadora"));
                cond.setTaxa(rs.getDouble("taxa_adm"));
                cond.setParceiro(rs.getString("parceiro"));
                cond.setGera_receber(rs.getString("GERA_CONTAS_RECEBER"));
                lista.add(cond);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CondicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public String geraId(){
        String id="0";
        try {
            String sql="select gen_id(gen_tcondicoes_venda_id,1) from RDB$DATABASE ";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                id=rs.getString(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CondicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public void excluir(String id){
        try {
            String sql="delete from tcondicoes_venda where id_condi=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CondicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
