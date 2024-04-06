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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ttipo_movimento;

/**
 *
 * @author Lucas
 */
public class tabelasDAO {
    public void inserirGrupo(String nomegrupo,String exibe,String tipo,String card){
        try {
            String sql="insert into tgrupos (id_grupo, nome,exibe_pdv,enviacardapio) values (gen_id(gen_tgrupos_id,1),?,?,'"+card+"');";
            if (tipo.equals("SG")) sql="insert into tsubgrupo (idsubgrupo, nome,exibepdv) values (gen_id(gen_tSUBGRUPO_id,1),?,?);";
            if (tipo.equals("S")) sql="insert into TSETORES (idsetor, nome,exibepdv) values (gen_id(gen_tsetores_id,1),?,?);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, nomegrupo);
            ps.setString(2, exibe);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(tabelasDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir item... \n "+ex.getMessage());
        }
        
    
    }
    public void alterarGrupo(String id, String nome,String pdv,String card){
        try {
            String sql="update tgrupos set nome=?,exibe_pdv=?,enviacardapio=? where id_grupo=?;";
            PreparedStatement psu= conexao.getPreparedStatement(sql);
            psu.setString(1, nome);
            psu.setString(2, pdv);
            psu.setString(3, card);
            psu.setString(4, id);
            psu.executeUpdate();
            psu.close();
        } catch (SQLException ex) {
            Logger.getLogger(tabelasDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir item... \n "+ex.getMessage());
        }
        
    }
    public void inserirHistorico(String nomehist){
        try {
                String sql="insert into thistorico (id,Historico) values (gen_id(gen_thistorico_id,1),?);";
                PreparedStatement ps = conexao.getPreparedStatement(sql);
                ps.setString(1, nomehist);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(tabelasDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao inserir historico... \n "+ex.getMessage());
            }
    
    
    }
    public void alterarHistorico(String id, String nome){
         try {
            String sql="update thistorico set historico=? where id=?;";
            PreparedStatement psu= conexao.getPreparedStatement(sql);
            psu.setString(1, nome);
            psu.setString(2, id);
            psu.executeUpdate();
            psu.close();
        } catch (SQLException ex) {
            Logger.getLogger(tabelasDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Historico... \n "+ex.getMessage());
        }
    }
    public void escluirRegistro(String id , String tipo){
        try {
            String sql="delete from tgrupos where id_grupo=?";
            if (tipo.equals("SG"))sql="delete from tsubgrupo where idsubgrupo=?";
            if (tipo.equals("S"))sql="delete from tsetores where idsetor=?";
            if(tipo.equals("CO")) sql="delete from tconta where id_conta=?";
            if(tipo.equals("TS")) sql="delete from ttipo_movimento where id_tipo=?";
            if(tipo.equals("HI")) sql="delete from thistorico where id=?";
            if(tipo.equals("BA")) sql="delete from tcad_bairro where id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeLargeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!!!");
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Para Gravar!!!\n"+ex.getMessage());
            Logger.getLogger(tabelasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    }
    public ttipo_movimento retornaTipoFinanceiro(String id){
       ttipo_movimento tipo= new ttipo_movimento();
        try {
            String sql="select * from ttipo_movimento where id_tipo=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            tipo.setId_tipo(rs.getString(1));
            tipo.setDescricao(rs.getString(2));
            tipo.setCategoria(rs.getString(3));
            tipo.setTipo_referente(rs.getString(4));
            tipo.setDirecao(rs.getString(5));
            tipo.setDre(rs.getString(6));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(tabelasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipo;
        
    }
}
