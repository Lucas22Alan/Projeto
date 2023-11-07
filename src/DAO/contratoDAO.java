/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Logs.gravarLog;
import classes.clsaux;
import classes.infContrato;
import conexoes.conexao;
import contrato.FormCadContrato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class contratoDAO {
        public String  inserirContra(String idparc, infContrato in){
            String idcontrato=null;
            try{
            String sql="insert into tcontrato (id_contrato, id_parceiro, data, hora, estado,valor,dia_vencimento,"
                    + "quantidade_messes_filiacao,primeira_parcela, inicio_filiacao, fim_filiacao,valor_plano,tipo_plano)values\n" +
                        "(gen_id(gen_tcontrato_id,1),?,current_date,current_time,2,?,?,?,?,?,?,?,?)";
            PreparedStatement ps= conexao.getPreparedStatement(sql);
            ps.setInt(1, Integer.parseInt(idparc));
            ps.setString(2, in.getValor());
            ps.setString(3, in.getDia_venciento());
            ps.setString(4, in.getQuantidade_messes());
            ps.setDate(5, clsaux.retornaData(in.getVenc_pri_parce()));
            ps.setDate(6, clsaux.retornaData(in.getData_filiacao()));
            ps.setDate(7, clsaux.retornaData(in.getData_fim_vigencia()));
            ps.setString(8, in.getValor_plano());
            ps.setString(9, in.getPlano());
            ps.executeUpdate();
            ps.close();
            String sqlpega="select gen_id(gen_tcontrato_id,0) from rdb$database";
            PreparedStatement pss= conexao.getPreparedStatementResult(sqlpega);
            ResultSet rss= pss.executeQuery();
            rss.first();
            idcontrato=rss.getString(1);
            JOptionPane.showMessageDialog(null, "Contrato Gravado com Sucesso :) ");
            
        }catch(SQLException er){
            JOptionPane.showMessageDialog(null,"Erro ao inserir contrato :( \n" +er.getMessage());
             Logger.getLogger(contratoDAO.class.getName()).log(Level.SEVERE, null, er);
        }
        return idcontrato;
        }
        public void atualizarCr(String idparceiro,String cr){
            try {
                 String sqlatu="update tparceiros set cr=? where idparceiro=?";
                 PreparedStatement psat= conexao.getPreparedStatement(sqlatu);
                 psat.setString(1, cr);
                 psat.setString(2, idparceiro);
                 psat.executeUpdate();
                 psat.close();
                 JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!!!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro para inserir CR \n\n"+ex.getMessage());
                 gravarLog.main(ex.getMessage().toString());
                Logger.getLogger(contratoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
}
