/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.clsItemOs;
import model.clsOrdem;
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
import model.Tparametros_tabela;

/**
 *
 * @author lucas
 */
public class orderServicoDAO {
    public static String buscaId(){
        String id="";
        try {
            String sql="select (gen_id(gen_tordem_servico_id,1)) from rdb$database";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            id=rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public List<clsOrdem> buscarRegistrosPorData(String ini,String fim){
        List<clsOrdem> lista= new ArrayList<>();
        try {
            String sql="select tp.marca,\n" +
                        "        tp.modelo,\n" +
                        "        tp.serie,\n" +
                        "        tp.problema,\n" +
                        "        tp.obs,\n" +
                        "        tp.total_servicos,\n" +
                        "        tp.total_produtos,\n" +
                        "        tp.desconto,\n" +
                        "        tp.data_entrada,\n" +
                        "        tp.data_saida,\n" +
                        "        tp.tipo_os,\n" +
                        "        tp.situacao_os,\n" +
                        "        tp.id_parceiro,\n" +
                        "        tp.total,tp.obs_geral\n" +
                        " from tordem_servico tp\n" +
                        " where tp.data_entrada between ? and ?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setDate(1, clsaux.retornaData(ini));
            ps.setDate(2, clsaux.retornaData(fim));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clsOrdem cs = new clsOrdem();
                cs.setMarca(rs.getString(1));
                cs.setModelo(rs.getString(2));
                cs.setSerie(rs.getString(3));
                cs.setProblema(rs.getString(4));
                cs.setObs(rs.getString(5));
                cs.setVlservico(rs.getString(6));
                cs.setVlprod(rs.getString(7));
                cs.setDesc(rs.getString(8));
                cs.setDataent(rs.getString(9));
                cs.setDatasai(rs.getString(10));
                cs.setTipo(rs.getString(11));
                cs.setSituacao(rs.getString(12));
                cs.setIdparc(rs.getString(13));
                cs.setTotal(rs.getString(14));
                cs.setObsgeral(rs.getString(15));
                lista.add(cs);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
        return lista;
    
    }
    
    public void inserirCabecalho(clsOrdem dm){
        try {
            String sql="insert into tordem_servico (id_ordem,id_parceiro,tipo_os,situacao_os,data_entrada,hora_entrada,\n" +
                    "marca,modelo,serie,problema,obs,subtotal,desconto,total_produtos,total_servicos,total,obs_geral,placa)values(\n" +
                    "?,?,?,?,?,current_time,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, dm.getIdmovto());
            ps.setString(2, dm.getIdparc());
            ps.setString(3, dm.getTipo());
            ps.setString(4, dm.getSituacao());
            ps.setDate(5, clsaux.retornaData(dm.getDataent()));
            ps.setString(6, dm.getMarca());
            ps.setString(7, dm.getModelo());
            ps.setString(8, dm.getSerie());
            ps.setString(9, dm.getProblema());
            ps.setString(10, dm.getObs());
            ps.setString(11, dm.getTotal());
            ps.setString(12, dm.getDesc());
            ps.setString(13, dm.getVlprod());
            ps.setString(14, dm.getVlservico());
            ps.setString(15, dm.getTotal());
            ps.setString(16, dm.getObsgeral());
            ps.setString(17, dm.getPlaca());
            int ret=ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro ao inserir dados\n" +ex.getMessage());
        }
            JOptionPane.showMessageDialog(null, "Gravado com sucesso!!!");
        
    }
    public void atualizaCabecalho(clsOrdem dm){
        try {
            String sql="update tordem_servico os set os.tipo_os=?, os.situacao_os=?, os.data_entrada=?,os.data_saida=?,\n" +
                    "os.marca=?,os.modelo=?, os.serie=?, os.problema=?,os.obs=?, os.subtotal=?, os.desconto=?,\n" +
                    "os.total_produtos=?, os.total_servicos=?,os.total=?,obs_geral=?,placa=?,id_parceiro=? where os.id_ordem=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1,dm.getTipo());
            ps.setString(2, dm.getSituacao());
            ps.setDate(3, clsaux.retornaData(dm.getDataent()));
            ps.setDate(4, clsaux.retornaData(dm.getDatasai()));
            ps.setString(5, dm.getMarca());
            ps.setString(6, dm.getModelo());
            ps.setString(7, dm.getSerie());
            ps.setString(8, dm.getProblema());
            ps.setString(9, dm.getObs());
            ps.setString(10, dm.getTotal());
            ps.setString(11, dm.getDesc());
            ps.setString(12, dm.getVlprod());
            ps.setString(13, dm.getVlservico());
            ps.setString(14, dm.getTotal());
            ps.setString(15, dm.getObsgeral());
            ps.setString(16, dm.getPlaca());
            ps.setString(17, dm.getIdparc());
            ps.setString(18, dm.getIdmovto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro ao inserir dados\n" +ex.getMessage());
        }
    }
    public void inserirItem(clsItemOs si){
        try {
            String sql="insert into tos_item(id_os,id_item,cod_item,qnt,vl_unit,total,desconto,tipo_item,estado,funcionario,obs_item,unid)\n" +
                    "values(?,?,?,?,?,?,?,?,2,?,?,?);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, si.getIdos());
            ps.setString(2, si.getIditem());
            ps.setString(3, si.getCodigo());
            ps.setString(4, si.getQnt());
            ps.setString(5, si.getValorunit());
            ps.setString(6, si.getValortotal());
            ps.setString(7, si.getDesconto());
            ps.setString(8, si.getTipoitem());
            ps.setString(9, si.getFuncionario());
            ps.setString(10, si.getObs());
            ps.setString(11, si.getUnid());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void alterarItem(clsItemOs si){
        try {
            String sql="update tos_item ti set ti.cod_item=?,ti.qnt=?,ti.vl_unit=?,ti.total=?,\n" +
                    "ti.desconto=?,ti.funcionario=?,ti.obs_item=?,ti.unid=? where ti.id_os=? and ti.id_item=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, si.getCodigo());
            ps.setString(2, si.getQnt());
            ps.setString(3, si.getValorunit());
            ps.setString(4, si.getValortotal());
            ps.setString(5, si.getDesconto());
            ps.setString(6, si.getFuncionario());
            ps.setString(7, si.getObs());
            ps.setString(8, si.getUnid());
            ps.setString(9, si.getIdos());
            ps.setString(10, si.getIditem());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Item item\n"+ex.getMessage());
        }
        
    }
    public void inserirFinalizadora(String idos,String idfinalizadora, String valor,String parc){
        try {
            String sql="insert into tos_pagamento(id, id_os,id_finalizadora,valor,parcela) values\n" +
                    "(gen_id(gen_tos_pagamento_id,1),?,?,'"+valor+"',?);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idos);
            ps.setString(2, idfinalizadora);
            ps.setString(3, parc);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados da finalizadora...\n"+ ex.getMessage());
        }
        
    }
    public void alteraEstadoFinalizado(String idos,String desc,String tot){
        try {
            String sql="update tordem_servico set situacao_os=2, desconto=?, data_saida=current_date, hora_saida= current_time,\n"
                    + "total=? where id_ordem=?;";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, desc);
            ps.setString(3, idos);
            ps.setString(2, tot);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void buscaDadosParaAlterar(clsOrdem cs){
        try {
            String sql="select tp.marca,\n" +
                        "        tp.modelo,\n" +
                        "        tp.serie,\n" +
                        "        tp.problema,\n" +
                        "        tp.obs,\n" +
                        "        tp.total_servicos,\n" +
                        "        tp.total_produtos,\n" +
                        "        tp.desconto,\n" +
                        "        tp.data_entrada,\n" +
                        "        tp.data_saida,\n" +
                        "        tp.tipo_os,\n" +
                        "        tp.situacao_os,\n" +
                        "        tp.id_parceiro,\n" +
                        "        tp.total,tp.obs_geral,tp.placa\n" +
                        " from tordem_servico tp\n" +
                        " where tp.id_ordem=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, cs.getIdmovto());
            ResultSet rs = ps.executeQuery();
            rs.next();
            cs.setMarca(rs.getString(1));
            cs.setModelo(rs.getString(2));
            cs.setSerie(rs.getString(3));
            cs.setProblema(rs.getString(4));
            cs.setObs(rs.getString(5));
            cs.setVlservico(rs.getString(6));
            cs.setVlprod(rs.getString(7));
            cs.setDesc(rs.getString(8));
            cs.setDataent(rs.getString(9));
            cs.setDatasai(rs.getString(10));
            cs.setTipo(rs.getString(11));
            cs.setSituacao(rs.getString(12));
            cs.setIdparc(rs.getString(13));
            cs.setTotal(rs.getString(14));
            cs.setObsgeral(rs.getString(15));
            cs.setPlaca(rs.getString(16));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Registro Não Encontrado!!!");
        }
        
        
        
    }
    public void buscaDadosItemAlterar(clsItemOs cl){
        try {
            String sql="select ti.id_item,ti.cod_item,ti.qnt,ti.vl_unit,ti.total,ti.desconto,\n" +
                    "    ti.obs_item,ti.unid,ti.funcionario,tp.nomelongo\n" +
                    " from tos_item ti join tbarras tb on ti.cod_item=tb.codigo_barras\n"
                    + "join tprodutos tp on tb.id_produto=tp.id  where ti.id_os=? and ti.id_item=?";
            PreparedStatement ps =conexao.getPreparedStatementResult(sql);
            ps.setString(1, cl.getIdos());
            ps.setString(2, cl.getIditem());
            ResultSet rs=ps.executeQuery();
            rs.first();
            cl.setCodigo(rs.getString(2));
            cl.setQnt(rs.getString(3));
            cl.setValorunit(rs.getString(4));
            cl.setValortotal(rs.getString(5));
            cl.setDesconto(rs.getString(6));
            cl.setObs(rs.getString(7));
            cl.setUnid(rs.getString(8));
            cl.setFuncionario(rs.getString(9));
            cl.setDesc(rs.getString(10));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Buscar dados do item\n"+ex.getMessage());
        }
        
    }
    
    public List<clsItemOs> retornaListaItensOs(String idos){
        List<clsItemOs> lista= new ArrayList<>();
        try {
            String sql="select ti.id_item,ti.cod_item,ti.qnt,ti.vl_unit,ti.total,ti.desconto,\n" +
                    "    ti.obs_item,ti.unid,ti.funcionario,tp.nomelongo\n" +
                    " from tos_item ti join tbarras tb on ti.cod_item=tb.codigo_barras\n"
                    + "join tprodutos tp on tb.id_produto=tp.id  where ti.id_os=? ";
            PreparedStatement ps =conexao.getPreparedStatement(sql);
            ps.setString(1, idos);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               clsItemOs cl= new clsItemOs();
                cl.setCodigo(rs.getString(2));
                cl.setQnt(rs.getString(3));
                cl.setValorunit(rs.getString(4));
                cl.setValortotal(rs.getString(5));
                cl.setDesconto(rs.getString(6));
                cl.setObs(rs.getString(7));
                cl.setUnid(rs.getString(8));
                cl.setFuncionario(rs.getString(9));
                cl.setDesc(rs.getString(10));
                lista.add(cl);
           }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Buscar dados do item\n"+ex.getMessage());
        }
        return lista;
    }
    public void cancelaItem(String idordem,String idite){
        try {
            String sql="update tos_item set estado='3' where id_os=? and id_item=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idordem);
            ps.setString(2, idite);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    public void inserirFinalizadoraVendaFinalizada(String mvtoOrigem,String mvtoDestino){
        try {
            String sql="select * from tos_pagamento where id_os=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, mvtoOrigem );
            ResultSet rs = ps.executeQuery();
            lancamentoTiroDAO tdao= new lancamentoTiroDAO();
            while(rs.next()){
                tdao.insereFinalidoraVenda(rs.getString("id_finalizadora"), rs.getString("valor"),
                        mvtoDestino, rs.getString("parcela"), 0.00,clsaux.retornaData(clsaux.preencheData()));
            
            }
         } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
  
      
  } 
    public clsOrdem consultaDadosPorPlaca(clsOrdem cl){
        try {
            String sql="select first 1 tp.marca,\n" +
                            "        tp.modelo,\n" +
                            "        tp.serie,\n" +
                            "        tp.problema,\n" +
                            "        tp.obs,\n" +
                            "        tp.total_servicos,\n" +
                            "        tp.total_produtos,\n" +
                            "        tp.desconto,\n" +
                            "        tp.data_entrada,\n" +
                            "        tp.data_saida,\n" +
                            "        tp.tipo_os,\n" +
                            "        tp.situacao_os,\n" +
                            "        tp.id_parceiro,\n" +
                            "        tp.total,tp.obs_geral,tp.id_ordem\n" +
                            " from tordem_servico tp\n" +
                            " where tp.placa=? order by 9 desc";
            PreparedStatement ps=conexao.getPreparedStatementResult(sql);
            ps.setString(1, cl.getPlaca());
            ResultSet rs = ps.executeQuery();
            rs.first();
            cl.setMarca(rs.getString(1));
                cl.setModelo(rs.getString(2));
                cl.setSerie(rs.getString(3));
                cl.setProblema(rs.getString(4));
                cl.setObs(rs.getString(5));
                cl.setTipo(rs.getString(11));
                cl.setIdparc(rs.getString(13));
                
                
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
        
     }
    
    
    public List<clsOrdem> retornaListaOsParceiro(String idparceiro){
        List<clsOrdem> lista = new ArrayList<>();
        try {
            String sql="select tp.marca,\n" +
                            "        tp.modelo,\n" +
                            "        tp.serie,\n" +
                            "        tp.problema,\n" +
                            "        tp.obs,\n" +
                            "        tp.total_servicos,\n" +
                            "        tp.total_produtos,\n" +
                            "        tp.desconto,\n" +
                            "        tp.data_entrada,\n" +
                            "        tp.data_saida,\n" +
                            "        tp.tipo_os,\n" +
                            "        tp.situacao_os,\n" +
                            "        tp.id_parceiro,\n" +
                            "        tp.total,tp.obs_geral,tp.id_ordem,tc.descricao,tp.placa \n" +
                            " from tordem_servico tp\n" +
                            " join testado_operacoes tc on tp.situacao_os=tc.id where tp.id_parceiro=? order by 16 desc";
            PreparedStatement ps=conexao.getPreparedStatement(sql);
            ps.setString(1, idparceiro);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clsOrdem cl= new clsOrdem();
                cl.setMarca(rs.getString(1));
                cl.setModelo(rs.getString(2));
                cl.setSerie(rs.getString(3));
                cl.setProblema(rs.getString(4));
                cl.setObs(rs.getString(5));
                cl.setTipo(rs.getString(11));
                cl.setIdparc(rs.getString(13));
                cl.setTotal(rs.getString(14));
                cl.setObsgeral(rs.getString(15));
                cl.setIdmovto(rs.getString(16));
                cl.setDataent(rs.getString(9));
                cl.setDatasai(rs.getString(10));
                cl.setSituacao(rs.getString(17));
                cl.setPlaca(rs.getString(18));
                lista.add(cl);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
     }
    public void cancelarRegistro(String id){
        try {
            String sql="update tordem_servico os set os.situacao_os='3' where os.id_ordem=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    }

    public List<Tparametros_tabela> retornaParametros(){
        List<Tparametros_tabela> lista= new ArrayList<>();
        try {
            String sql="select * from tparametros_tabela where tabela='os'";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Tparametros_tabela par= new Tparametros_tabela();
                par.setCampo(rs.getString(1));
                par.setDescricao(rs.getString(2));
                lista.add(par);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
