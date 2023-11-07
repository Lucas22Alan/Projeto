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
import model.Tfatura_locacao;
import model.Titens_locacao;
import model.Tlocacao;
import model.Torigem_fatura;
import model.tlocacao_pagamento;

/**
 *
 * @author Mk Solucoes
 */
public class LocacaoDAO {
    PreparedStatement ps;
    ResultSet rs;
   
    
    public String retornaId(){
        String retorno="0";
        try {
            String sql="select GEN_ID(gen_tlocacao_id, 1) FROM RDB$DATABASE;";
            PreparedStatement ps =conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            retorno=rs.getString(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public void gravarLocacao(Tlocacao loc){
        try {
            String sql="UPDATE OR INSERT INTO TLOCACAO (ID, PARCEIRO, DATA, DATA_PREVISTA_RETIRADA, DATA_PREVISTA_DEVOLUCAO, DATA_RETIROU, DATA_DEVOLUCAO, TOTAL, ESTADO, OBS, LOCAL, BAIRRO, CIDADE, RESPONSAVEL, FONE, SUBTOTAL, DESCONTO, ACRESCIMO)\n" +
                    "                        VALUES (?, ?, current_date,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)\n" +
                    "                      MATCHING (ID);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, loc.getId());
            ps.setString(2, loc.getParceiro());
            ps.setDate(3, clsaux.retornaData(loc.getDataPreRetirada()));
            ps.setDate(4, clsaux.retornaData(loc.getDataPreDev()));
            ps.setTimestamp(5, clsaux.retornaDataHora(loc.getDataReti()));
            ps.setDate(6, clsaux.retornaData(loc.getDataDev()));
            ps.setDouble(7, loc.getTotal());
            ps.setString(8, loc.getEstado());
            ps.setString(9, loc.getObs());
            ps.setString(10, loc.getLocal());
            ps.setString(11, loc.getBairro());
            ps.setString(12, loc.getCidade());
            ps.setString(13, loc.getResponsavel());
            ps.setString(14, loc.getFone());
            ps.setDouble(15, loc.getSubtotal());
            ps.setDouble(16, loc.getDesc());
            ps.setDouble(17, loc.getAcres());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    }
    public void inserirItemLocacao(Titens_locacao item){
        try {
            String sql="UPDATE OR INSERT INTO TITENS_LOCACAO (IDLOCACAO, IDITEM, CODIGOITEM, QNT_UNITARIA, QNT_DIAS, QNT_HRS, VALOR, TOTAL, DATA_RETIRADA, DATA_DEVOLUCAO, DATA_LANCAMENTO, ESTADO, NUMERO_SERIE,obs,tipolocacao,descricao,valor_pago,qnt_pecas)\n" +
                    "                              VALUES (?,?,?,?,?,?,?,?,?,?,current_time,?,?,?,?,?,?,?)\n" +
                    "                            MATCHING (IDLOCACAO, IDITEM);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, item.getIdlocacao());
            ps.setString(2, item.getIditem());
            ps.setString(3, item.getCodigoitem());
            ps.setDouble(4, item.getQntunitaria());
            ps.setDouble(5, item.getQntdias());
            ps.setDouble(6, item.getQnthr());
            ps.setDouble(7, item.getValor());
            ps.setDouble(8, item.getTotal());
            ps.setTimestamp(9, clsaux.retornaDataHora(item.getRetirada()));
            ps.setTimestamp(10, clsaux.retornaDataHora(item.getDevolucao()));
            ps.setString(11, clsaux.retornaId(item.getEstado()));
            ps.setString(12, item.getNumeroserie());
            ps.setString(13, item.getObs());
            ps.setString(14, item.getTipo());
            ps.setString(15, item.getDescricao());
            ps.setDouble(16, item.getPago());
            ps.setDouble(17, item.getQntpecas());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removerItemLocacao(Titens_locacao item){
        try {
            String sql="update  titens_locacao tl  set tl.estado='3' where tl.idlocacao=? and tl.iditem=? and tl.codigoitem=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, item.getIdlocacao());
            ps.setString(2, item.getIditem());
            ps.setString(3, item.getCodigoitem());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public List<Titens_locacao> retornaItensLocacao(String id){
        List<Titens_locacao>  lista = new ArrayList<>();
        try {
            String sql="select tl.*,tp.descricao as descri from titens_locacao tl  left join testado_operacoes tp on tl.estado=tp.id where  tl.idlocacao=? and tl.estado<>'3' order by iditem asc";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Titens_locacao item=new Titens_locacao();
                item.setCodigoitem(rs.getString(3));
                item.setDescricao(rs.getString(16));
                item.setDevolucao(clsaux.convertDataHoraExib(rs.getString(10)));
                item.setEstado(rs.getString(12)+"- "+rs.getString("descri"));
                item.setIditem(rs.getString(2));
                item.setIdlocacao(rs.getString(1));
                item.setLancamento(rs.getString(11));
                item.setNumeroserie(rs.getString(13));
                item.setObs(rs.getString(14));
                item.setQntdias(rs.getDouble(5));
                item.setQnthr(rs.getDouble(6));
                item.setQntunitaria(rs.getDouble(4));
                item.setRetirada(clsaux.convertDataHoraExib(rs.getString(9)));
                item.setTipo(rs.getString(15));
                item.setTotal(rs.getDouble(8));
                item.setValor(rs.getDouble(7));
                item.setPago(rs.getDouble(17));
                item.setQntpecas(rs.getDouble(18));
                lista.add(item);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public Tlocacao retornaLocacao(String id){
        Tlocacao loc= new Tlocacao();
        try {
            String sql="select * from tlocacao tl where tl.id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                loc.setAcres(rs.getDouble(18));
                loc.setBairro(rs.getString(12));
                loc.setCidade(rs.getString(13));
                loc.setDataDev(clsaux.convertDataExib(rs.getString(7)));
                loc.setDataPreDev(clsaux.convertDataExib(rs.getString(5)));
                loc.setDataPreRetirada(clsaux.convertDataExib(rs.getString(4)));
                loc.setDataReti(clsaux.convertDataHoraExib(rs.getString(6)));
                loc.setDesc(rs.getDouble(17));
                loc.setEstado(rs.getString(9));
                loc.setFone(rs.getString(15));
                loc.setId(rs.getString(1));
                loc.setLocal(rs.getString(11));
                loc.setObs(rs.getString(10));
                loc.setParceiro(rs.getString(2));
                loc.setResponsavel(rs.getString(14));
                loc.setSubtotal(rs.getDouble(16));
                loc.setTotal(rs.getDouble(8));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loc;  
    
    
    }
     public List<Tlocacao> retornaLocacoes(String estado){
        List<Tlocacao> locacoesPendentes= new ArrayList<>();
        try {
            String sql="select * from tlocacao tl where tl.estado=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Tlocacao loc= new Tlocacao();
                loc.setAcres(rs.getDouble(18));
                loc.setBairro(rs.getString(12));
                loc.setCidade(rs.getString(13));
                loc.setDataDev(clsaux.convertDataExib(rs.getString(7)));
                loc.setDataPreDev(clsaux.convertDataExib(rs.getString(5)));
                loc.setDataPreRetirada(clsaux.convertDataExib(rs.getString(4)));
                loc.setDataReti(clsaux.convertDataHoraExib(rs.getString(6)));
                loc.setDesc(rs.getDouble(17));
                loc.setEstado(rs.getString(9));
                loc.setFone(rs.getString(15));
                loc.setId(rs.getString(1));
                loc.setLocal(rs.getString(11));
                loc.setObs(rs.getString(10));
                loc.setParceiro(rs.getString(2));
                loc.setResponsavel(rs.getString(14));
                loc.setSubtotal(rs.getDouble(16));
                loc.setTotal(rs.getDouble(8));
                locacoesPendentes.add(loc);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locacoesPendentes;  
    
    
    }
    
    
    public void gravaFinalizadora(tlocacao_pagamento pag){
        try {
            String sql="INSERT INTO TLOCACAO_PAGAMENTO (IDLOCACAO, IDFINALIZADORA, NOMEFINALIZADORA, VALOR, TROCO, TIPO, REFERENCIA, DATA, ESTADO,idfatura)\n" +
                    "                        VALUES (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, pag.getIdlocacao());
            ps.setString(2, pag.getIdfinalizadora());
            ps.setString(3, pag.getNomefinalizadora());
            ps.setDouble(4, pag.getValor());
            ps.setDouble(5, pag.getTroco());
            ps.setString(6, pag.getTipo());
            ps.setString(7, pag.getReferencia());
            ps.setTimestamp(8, clsaux.retornaDataHora(pag.getDatainf()));
            ps.setString(9, pag.getEstado());
            ps.setString(10, pag.getIdfatura() );
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<tlocacao_pagamento> retornaPagamentos(String idlocacao){
        List<tlocacao_pagamento> lista= new ArrayList<>();
        try {
            String sql="select * from tlocacao_pagamento where idlocacao=? and estado='2'";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idlocacao);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tlocacao_pagamento pag= new tlocacao_pagamento();
                pag.setIdfinalizadora(rs.getString(2));
                pag.setIdlocacao(rs.getString(1));
                pag.setEstado(rs.getString(9));
                pag.setReferencia(rs.getString(7));
                pag.setTipo(rs.getString(6));
                pag.setTroco(rs.getDouble(5));
                pag.setValor(rs.getDouble(4));
                pag.setDatainf(rs.getString(8));
                lista.add(pag);
                
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    
    }
    
     public List<Tfatura_locacao> retornaFaturas(String idlocacao){
        List<Tfatura_locacao> lista= new ArrayList<>();
        try {
            String sql="select tp.* from tfatura_locacao tp\n" +
                        "join tlink_fatura tc on tc.idfatura=tp.id\n" +
                        "where tc.idlocacao=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idlocacao);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Tfatura_locacao pag= new Tfatura_locacao();
                pag.setIdfatura(rs.getString("id"));
                pag.setPago(rs.getString("pago"));
                pag.setDatagerado(clsaux.convertDataHoraExib(rs.getString("datagerado")));
                pag.setTotal(rs.getDouble("total"));
                lista.add(pag);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    
    }
    public void cancelarLocacao(String id){
        try {
            String sql="update tlocacao tl set tl.estado='3' where tl.id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    }
    public String verificaUltimaFatura(String idlocacao,String iditem){
        String retorno=null;
        try {
            String sql="select first 1 tr.datafim from torigem_fatura tr where tr.idlocacao=? and tr.iditem=? order by tr.datafim desc";
            
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, idlocacao);
            ps.setString(2, iditem);
            rs=ps.executeQuery();
            if(rs.next()){
                retorno=clsaux.convertDataHoraExib(rs.getString(1));
            }else{
                retorno=null;
            }
        } catch (SQLException ex) {
            retorno=null;
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public void InserirOrigemFatura(Torigem_fatura fat){
        try {
            String sql="INSERT INTO TORIGEM_FATURA (IDLOCACAO, BARRAS_ITEM, IDITEM, DATAINICIO, DATAFIM, IDFATURA, PERIODO, TIPOCOBRANCA, VALOR, TOTAL)\n" +
                    "                    VALUES (?,?,?,?,?,?,?,?,?,?);";
            ps= conexao.getPreparedStatement(sql);
            ps.setString(1, fat.getItem().getIdlocacao());
            ps.setString(2, fat.getItem().getCodigoitem());
            ps.setString(3, fat.getItem().getIditem());
            ps.setTimestamp(4, clsaux.retornaDataHora(fat.getDatainicio()));
            ps.setTimestamp(5, clsaux.retornaDataHora(fat.getDatafim()));
            ps.setString(6, fat.getIdfatura());
            ps.setDouble(7, fat.getPeriodo());
            ps.setString(8, fat.getTipo());
            ps.setDouble(9, fat.getValor());
            ps.setDouble(10, fat.getTotal());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void atualizaValorItensFatura(Torigem_fatura fat){
        try {
            String sql="update torigem_fatura tf set tf.periodo=?, tf.valor=?,tf.total=?\n" +
                    "where tf.idlocacao=? and tf.iditem=? and tf.idfatura=?";
            ps = conexao.getPreparedStatement(sql);
            ps.setDouble(1, fat.getPeriodo());
            ps.setDouble(2, fat.getValor());
            ps.setDouble(3, fat.getTotal());
            ps.setString(4, fat.getItem().getIdlocacao());
            ps.setString(5, fat.getItem().getIditem());
            ps.setString(6, fat.getIdfatura());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void atualizaValorFatura(String id, Double valor,String pagamento){
        try {
            String sql="update tfatura_locacao tf set tf.total=?,pago=? where tf.id=?";
            ps = conexao.getPreparedStatement(sql);
            ps.setDouble(1, valor);
            ps.setString(2, pagamento);
            ps.setString(3, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void InsereFatura(Tfatura_locacao fat){
        try {
            String sql="INSERT INTO TFATURA_LOCACAO (IDLOCACAO, DATAGERADO, TOTAL, PAGO,id)\n" +
                    "                     VALUES (?,current_timestamp,?,?,?);";
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, fat.getIdlocacao());
            ps.setDouble(2, fat.getTotal());
            ps.setString(3, fat.getPago());
            ps.setString(4, fat.getIdfatura());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void insereLinkFaturaLocacao(String idfatura,String idlocacao){
        try {
            String sql="UPDATE OR INSERT INTO TLINK_FATURA (IDFATURA, IDLOCACAO)\n" +
                    "                            VALUES (?, ?)\n" +
                    "                          MATCHING (IDFATURA, IDLOCACAO);";
            ps=conexao.getPreparedStatement(sql);
            ps.setString(1, idfatura);
            ps.setString(2, idlocacao);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Double retornaValorFaturadoLocacao(String idlocacao){
       Double tot=0.00;
        try {
            String sql="select sum(total) from torigem_fatura where idlocacao='"+idlocacao+"'";
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                tot=rs.getDouble(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tot; 
    }
    public List<Torigem_fatura> retornaDadosItensFatura(String idfatura){
        List<Torigem_fatura> lista= new ArrayList<>();
        try {
            String sql="  select  tp.barras_item as codigo,\n" +
                    "                                    ti.descricao as nomelongo,\n" +
                    "                                    tp.valor as vl_unit,\n" +
                    "                                    ti.data_retirada as locacao,\n" +
                    "                                    tp.periodo as qnt,\n" +
                    "                                    tp.total as total,tp.tipocobranca  as tipo, ti.qnt_pecas as pecas,\n" +
                    "                                    tp.datainicio as dataretirada, tp.datafim as datadev,\n" +
                    "                                    tp.idlocacao,\n" +
                    "                                    tp.iditem\n" +
                    "                             from torigem_fatura tp\n" +
                    "                             join titens_locacao ti on ti.idlocacao=tp.idlocacao and ti.iditem=tp.iditem\n" +
                    "                             where tp.idfatura='"+idfatura+"'";
            ps = conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Torigem_fatura fat= new Torigem_fatura();
                Titens_locacao item= new Titens_locacao();
                item.setCodigoitem(rs.getString(1));
                item.setDescricao(rs.getString(2));
                item.setRetirada(rs.getString(4));
                item.setQntpecas(rs.getDouble(8));
                item.setIdlocacao(rs.getString(11));
                item.setIditem(rs.getString(12));
                fat.setDatafim(rs.getString(10));
                fat.setDatainicio(rs.getString(9));
                fat.setIdfatura(idfatura);
                fat.setPeriodo(rs.getDouble(5));
                fat.setTipo(rs.getString(7));
                fat.setTotal(rs.getDouble(6));
                fat.setValor(rs.getDouble(3));
                fat.setItem(item);
                lista.add(fat);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
    }
}
