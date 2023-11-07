/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.clsOrcamento;
import model.clsOrcamentoItem;
import model.clsPagamentos;
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

/**
 *
 * @author Mk Solucoes
 */
public class orcamentoDAO {
    public String inserirRegistro(clsOrcamento orc){
        String sql="insert into torcamento  (id_orcamento,data_lancamento,hora_lancamento) values\n" +
"       (gen_id(gen_torcamento_id,1), current_date,current_time)";
         String sqlbuscaid="select gen_id(gen_torcamento_id,0) from rdb$database;";
        String retorno=null;
        try {
                PreparedStatement psin= conexao.getPreparedStatement(sql);
                psin.executeUpdate();
                psin.close();
                PreparedStatement psbc = conexao.getPreparedStatementResult(sqlbuscaid);
                ResultSet rsbc= psbc.executeQuery();
                rsbc.first();
                retorno = rsbc.getString(1);
                orc.setId(retorno);
                rsbc.close();
                psbc.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR DADOS \n\n"+ex.getMessage());
        }
        return retorno;
    
    }
    public void inserirItem(clsOrcamentoItem item){
        try {
            String sql="UPDATE OR INSERT INTO TORCAMENTO_ITENS (ID_ORCAMENTO, ID_ITEM, CODIBARRA, QNT, UNITARIO, TOTAL, DESCONTO, ACRESCIMO, ESTADO, VENDEDOR,"
                    + " OBSERVACAO, SUBTOTAL, DATA_LAN, DATA_CANC, UNIDADE,descricao)\n" +
                    "                                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)\n" +
                    "                              MATCHING (ID_ORCAMENTO, ID_ITEM);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, item.getIdorcamento());
            ps.setString(2, item.getIditem());
            ps.setString(3, item.getCodibarra());
            ps.setDouble(4, item.getQnt());
            ps.setDouble(5, item.getUnitario());
            ps.setDouble(6, item.getTotal());
            ps.setDouble(7, item.getDesc());
            ps.setDouble(8, item.getAcres());
            ps.setString(9, item.getEstado());
            ps.setString(10, item.getVendedor());
            ps.setString(11, item.getObs());
            ps.setDouble(12, item.getSubtotal());
            ps.setDate(13, clsaux.retornaData(item.getDatalanc()));
            ps.setDate(14, clsaux.retornaData(item.getDatacanc()));
            ps.setString(15, item.getUnidade());
            ps.setString(16, item.getDescricao());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro para atualizar cabecalho!!!"+ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
        }
    
    
    
    }
    public void atualizaRegistro(clsOrcamento orc){
        try {
            String sql="UPDATE OR INSERT INTO TORCAMENTO (ID_ORCAMENTO, ID_PARCEIRO, PARCEIRO_NOME, PARCEIRO_CPF, PARCEIRO_TELEFONE, SUBTOTAL, ACRESCIMO, DESCONTO, TOTAL, ESTADO, VENDEDOR,tipo,obs)\n" +
                    "                          VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?  )\n" +
                    "                        MATCHING (ID_ORCAMENTO);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, orc.getId());
            ps.setString(2, orc.getParceiro());
            ps.setString(3, orc.getParceiro_nome());
            ps.setString(4, orc.getParceiro_cpf());
            ps.setString(5, orc.getParceiro_telefone());
            ps.setDouble(6, orc.getSubtotal());
            ps.setDouble(7, orc.getAcrescimo());
            ps.setDouble(8, orc.getDesconto());
            ps.setDouble(9, orc.getTotal());
            ps.setString(10, orc.getEstado());
            ps.setString(11, orc.getVendedor());
            ps.setString(12, orc.getTipo());
            ps.setString(13, orc.getObs());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro para atualizar cabecalho!!!"+ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
        }
    
    }
    public clsOrcamento buscarCabecalho(clsOrcamento orc){
        try {
            String sql="select * from torcamento tm where tm.id_orcamento=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, orc.getId());
            ResultSet rs = ps.executeQuery();
            rs.first();
            orc.setParceiro(rs.getString("id_parceiro"));
            orc.setParceiro_nome(rs.getString("parceiro_nome"));
            orc.setParceiro_cpf(rs.getString("parceiro_cpf"));
            orc.setParceiro_telefone(rs.getString("parceiro_telefone"));
            orc.setSubtotal(rs.getDouble("subtotal"));
            orc.setAcrescimo(rs.getDouble("acrescimo"));
            orc.setDesconto(rs.getDouble("desconto"));
            orc.setTotal(rs.getDouble("total"));
            orc.setEstado(rs.getString("estado"));
            orc.setSituacao(rs.getString("situacao"));
            orc.setData_lancamento(rs.getDate("data_lancamento"));
            orc.setVendedor(rs.getString("vendedor"));
            orc.setTipo(rs.getString("tipo"));
            orc.setObs(rs.getString("obs"));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Orcamento Não Encontrado!!!");
        }
    return orc;   
    }
    public List<clsOrcamentoItem> buscaItens(String idorcamento){
        List <clsOrcamentoItem> lista = new ArrayList();
        try {
            
            String sql="select * from torcamento_itens where id_orcamento=? and estado='2' order by id_item asc";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idorcamento);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clsOrcamentoItem item= new clsOrcamentoItem();
                item.setIdorcamento(rs.getString("id_orcamento"));
                item.setIditem(rs.getString("id_item"));
                item.setAcres(rs.getDouble("acrescimo"));
                item.setCodibarra(rs.getString("codibarra"));
                item.setDatacanc(rs.getString("data_canc"));
                item.setDatalanc(rs.getString("data_lan"));
                item.setDesc(rs.getDouble("desconto"));
                item.setDescricao(rs.getString("descricao"));
                item.setEstado(rs.getString("estado"));
                item.setObs(rs.getString("observacao"));
                item.setQnt(rs.getDouble("qnt"));
                item.setSubtotal(rs.getDouble("subtotal"));
                item.setTotal(rs.getDouble("total"));
                item.setUnidade(rs.getString("unidade"));
                item.setUnitario(rs.getDouble("unitario"));
                item.setVendedor(rs.getString("vendedor"));
                lista.add(item);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro Para Buscar Dados!!!\n"+ex.getMessage());
            
        }
        return lista;
    
    }
    public void inserirFinalizadora(String idos,String idfinalizadora, String valor,String parcela,String dat){
        try {
            String sql="uPDATE OR INSERT INTO torcamento_pagamento(id, id_pedido,id_finalizadora,valor,parcela,data) values\n" +
                    "(gen_id(GEN_TORCAMENTO_PAGAMENTO_ID,1),?,?,'"+valor+"',?,?)  MATCHING (ID_PEDIDO, PARCELA) ;";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idos);
            ps.setString(2, idfinalizadora);
            ps.setString(3, parcela);
            ps.setDate(4, clsaux.retornaData(dat));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados da finalizadora...\n"+ ex.getMessage());
        }
        
    }
    public void inserirFinalizadoraVendaFinalizada(String mvtoOrigem,String mvtoDestino){
        try {
            String sql="select * from torcamento_pagamento where id_pedido=?";
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

    public static void removeFinalizadora(String id,String parcela){
        try {
            String sql= "delete from torcamento_pagamento where id_pedido=? and parcela=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.setString(2, parcela);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problema Para Remover Finalizadora da Base!!!\n"+ex.getMessage());
        }
    
    
    }
    public static List<clsPagamentos> retornaListaPagamentoPedidoOrcamento(String id){
        List <clsPagamentos> lista = new ArrayList<>();
        try {
            
            String sql="select tm.*,tf.descricao from torcamento_pagamento   tm\n" +
                        "left join tfinalizadora tf on tm.id_finalizadora=tf.id_finalizdora\n" +
                        "where tm.id_pedido=?";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1,id );
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clsPagamentos pg = new clsPagamentos();
                pg.setIdfinalizadora(rs.getString("id_finalizadora")+"-"+rs.getString("descricao"));
                pg.setMvto(rs.getString("id_pedido"));
                pg.setValor(rs.getString("valor"));
                pg.setParcela(rs.getString("parcela"));
                pg.setDataemissao(rs.getString("data"));
             lista.add(pg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
        return lista;
    }
    public List<clsOrcamento> retornaListaOrcamentos(String dtini, String dtfim){
        List<clsOrcamento> lista= new ArrayList<>();
        try {
            
            String sql="select * from torcamento tm where tm.data_lancamento between ? and ? and tm.estado='2'";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setDate(1, clsaux.retornaData(dtini));
            ps.setDate(2, clsaux.retornaData(dtfim));
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                clsOrcamento orc = new clsOrcamento();
                orc.setParceiro(rs.getString("id_parceiro"));
                orc.setParceiro_nome(rs.getString("parceiro_nome"));
                orc.setParceiro_cpf(rs.getString("parceiro_cpf"));
                orc.setParceiro_telefone(rs.getString("parceiro_telefone"));
                orc.setSubtotal(rs.getDouble("subtotal"));
                orc.setAcrescimo(rs.getDouble("acrescimo"));
                orc.setDesconto(rs.getDouble("desconto"));
                orc.setTotal(rs.getDouble("total"));
                orc.setEstado(rs.getString("estado"));
                orc.setSituacao(rs.getString("situacao"));
                orc.setData_lancamento(rs.getDate("data_lancamento"));
                orc.setVendedor(rs.getString("vendedor"));
                orc.setTipo(rs.getString("tipo"));
                orc.setObs(rs.getString("obs"));
                lista.add(orc);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
        return lista;
    
    }

    public void cancelarRegistro(String registro){
        try {
            String sql="update torcamento set estado=3 where id_orcamento=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1,registro );
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    
    }
    public static String verificaExistenciaNfeReferenteRegistro(String mvto,String idorigem){
        String retorno="0";
        try {
            String sql="select tm.id_mov from tmovimento tm\n" +
                    "join tnota_fiscal tn on tm.id_mov=tn.id_movimento\n" +
                    "where tm.mvto_origem=? and tm.importado_origem=? and tm.estado='2'";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, mvto);
            ps.setString(2, idorigem);
            ResultSet rs = ps.executeQuery();
            rs.first();
            if(rs.next()){
                retorno=rs.getString(1);
            }else{
                retorno="0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno="0";
        }
        return retorno;
    }
      public static String retornaIdMovimento(String mvto,String idorigem){
        String retorno="0";
        try {
            String sql="select tm.id_mov from tmovimento tm\n" +
                        "where tm.mvto_origem=? and tm.importado_origem=? and tm.estado='2'";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, mvto);
            ps.setString(2, idorigem);
            ResultSet rs = ps.executeQuery();
            rs.first();
            if(clsaux.verificaNulo(rs.getString(1))==true){
                retorno="0";
            }else{
                retorno=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(orcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno="0";
        }
        return retorno;
    }
}
