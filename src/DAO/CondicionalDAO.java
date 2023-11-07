/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.clsaux;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.clsOrcamento;

/**
 *
 * @author Mk Solucoes
 */
public class CondicionalDAO {
    
     public static void gravarRegistro(String parceiro,Double valortotal,String vendedor,String mvto,List<String> com){
        try {
            String sql="update tpre_venda tv set tv.idcliente=?,total=?,tipo='C', funcionario=?,tv.estado='16',comandas_agrupadas=? where tv.id_prevenda=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, parceiro);
            ps.setDouble(2, valortotal);
            ps.setString(3, vendedor);
            ps.setString(4, com.toString());
            ps.setString(5, mvto);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CondicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Gravar registro\n" +ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Registro Gravado com sucesso");
    }
     
     public static void atualizaBaixaConferencia(List<String> lista,String sit){
        try {
            String sql="update tpre_venda tv set tv.estado=? where tv.id_prevenda=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            for(String lis: lista){
                ps.setString(1, sit);
                ps.setString(2,lis );
                ps.executeUpdate();
                ps.clearParameters();
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CondicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Gravar registro\n" +ex.getMessage());
        }
        
    }
     
     public clsOrcamento buscaCabecalho(clsOrcamento cl){
        try {
            String sqlcabecalho="select tv.id_prevenda,\n" +
                    "        tv.data_lancamento,\n" +
                    "        tv.data_entregue,\n" +
                    "        tv.estado,\n" +
                    "        tv.funcionario ,\n" +
                    "        tp.cnpj,\n"
                    + "      tp.razao_social,   \n" +
                    "        tf.nome,\n" +
                    "        tr.descricao, \n"
                    + "      tv.total,tv.idcliente \n" +
                    "from tpre_venda tv\n" +
                    "left join tfuncionarios tf on tv.funcionario=tf.id\n" +
                    "left join tparceiros tp on tp.idparceiro= tv.idcliente\n" +
                    "join testado_operacoes tr on tv.estado=tr.id where tv.id_prevenda=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sqlcabecalho);
            ps.setString(1, cl.getId());
            ResultSet rs = ps.executeQuery();
            rs.first();
            cl.setParceiro(rs.getString(11));
            cl.setEstado(rs.getString(4));
            cl.setData_lancamento(clsaux.retornaData(clsaux.convertDataExib(rs.getString(2))));
            cl.setSubtotal(rs.getDouble(10));
            cl.setTotal(rs.getDouble(10));
            cl.setVendedor(rs.getString(5));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CondicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Registro Não Encontrado!!!");
        }
        return cl;
    }
     
     public List<clsOrcamento> retornaListaCondicionais(String ini,String fim,String tipo){
         List<clsOrcamento> lista= new ArrayList<>();
          try {
              if(tipo.equals("1")){tipo="1 or tv.estado=16";}
              String sql="select  tv.id_prevenda,\n" +
                    "        tv.data_lancamento,\n" +
                    "        tv.data_entregue,\n" +
                    "        tv.estado,\n" +
                    "        tv.funcionario ,\n" +
                    "        tp.cnpj,\n"
                    + "      tp.razao_social,   \n" +
                    "        \n" +
                    "        tr.descricao, \n"
                    + "      tv.total,tv.idcliente \n" +
                      "from tpre_venda tv\n" +
                      "join tparceiros tp on tp.idparceiro=tv.idcliente\n" +
                      "join testado_operacoes tr on tr.id=tv.estado\n" +
                      "where tv.data_lancamento between ? and ? and tv.estado="+tipo;
              
              PreparedStatement ps = conexao.getPreparedStatement(sql);
              ps.setDate(1, clsaux.retornaData(ini));
              ps.setDate(2, clsaux.retornaData(fim));
              ResultSet rs = ps.executeQuery();
              while(rs.next()){
                    clsOrcamento cl = new clsOrcamento();
                    cl.setId(rs.getString(1));
                    cl.setParceiro(rs.getString(10));
                    cl.setParceiro_nome(rs.getString(7));
                    cl.setEstado(rs.getString(4));
                    cl.setData_lancamento(clsaux.retornaData(clsaux.convertDataExib(rs.getString(2))));
                    cl.setSubtotal(rs.getDouble(9));
                    cl.setTotal(rs.getDouble(9));
                    cl.setVendedor(rs.getString(5));
                    lista.add(cl);
            }
              rs.close();
              ps.close();
              
          } catch (SQLException ex) {
              Logger.getLogger(CondicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
              Logs.gravarLog.main(ex.getMessage());
          }
          return lista;
     }

     public void cancelaCondicional(String registro){
         try {
             String sql="update tpre_venda set estado=3 where id_prevenda=?";
             PreparedStatement ps = conexao.getPreparedStatement(sql);
             ps.setString(1,registro );
             ps.executeUpdate();
             ps.close();
         } catch (SQLException ex) {
             Logger.getLogger(CondicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
             Logs.gravarLog.gravaSemMensagem(ex.getMessage());
         }
     }
}
