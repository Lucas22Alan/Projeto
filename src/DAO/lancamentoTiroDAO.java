
package DAO;

import Logs.gravarLog;
import model.clsLancamentoTiro;
import classes.clsaux;
import conexoes.conexao;
import java.sql.Date;

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
 * @author Lucas
 */
public class lancamentoTiroDAO {
    public static List listaPro(){
        List <String> listaprod= new ArrayList();
        try {
                String sqlpegaprodutos="select nomelongo from tprodutos tp\n" +
                                        "join tprecos tc on tp.id=tc.id\n"
                        + "              join tbarras tb on tp.id=tb.id_produto\n  " +
                                        "where id_grupo<>''\n" +
                                        "and id_grupo=(select id_grupo from tgrupos where nome='Produtos') and tp.excluido='N' order by 1 asc";
                PreparedStatement pspro= conexao.getPreparedStatement(sqlpegaprodutos);
                ResultSet rspro= pspro.executeQuery();
                while(rspro.next()){
                    listaprod.add(rspro.getString(1));
                }
                rspro.close();
                pspro.close();
                } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            gravarLog.main(ex.getMessage().toString());
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR DADOS \n\n"+ex.getMessage());
        }
        return listaprod;
    }
    public static List listaarma(){
          List <String> listaarma= new ArrayList();
        try {
                String sqlpegaprodutos="select nomelongo from tprodutos tp\n" +
                                        "join tprecos tc on tp.id=tc.id\n"
                        + "             join tbarras tb on tp.id=tb.id_produto\n" +
                                        "where id_grupo<>''\n" +
                                        "and id_grupo=(select id_grupo from tgrupos where nome='Equipamentos') and tp.excluido='N' order by 1 asc";
                PreparedStatement pspro= conexao.getPreparedStatement(sqlpegaprodutos);
                ResultSet rspro= pspro.executeQuery();
                while(rspro.next()){
                    listaarma.add(rspro.getString(1));
                }
                rspro.close();
                pspro.close();
                } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "ERRO AO INSERIR DADOS \n\n"+ex.getMessage());
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            gravarLog.main(ex.getMessage().toString());
        }
        return listaarma;

    }
    public String inserirMovto(String cli, String total,String datain){
        String sqlin="insert into tpre_venda (id_prevenda, idcliente,total,data_lancamento, hr_lancamento,estado,data_informada)\n" +
                     "values (gen_id(gen_tpre_venda_id,1),?,?, current_date,current_time,'1',?);";
        String sqlbuscaid="select gen_id(gen_tpre_venda_id,0) from rdb$database;";
        String retorno=null;
        try {
                PreparedStatement psin= conexao.getPreparedStatement(sqlin);
                psin.setString(1, cli);
                psin.setString(2, total);
                psin.setDate(3, clsaux.retornaData(datain));
                psin.executeUpdate();
                psin.close();
                PreparedStatement psbc = conexao.getPreparedStatementResult(sqlbuscaid);
                ResultSet rsbc= psbc.executeQuery();
                rsbc.first();
                retorno = rsbc.getString(1);
                rsbc.close();
                psbc.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR DADOS \n\n"+ex.getMessage());
        }
        return retorno;
    }
    public void atualizarMovto (String idmvt, String total,String datain){
        String sq="update tpre_venda set total=?,data_alterado=current_date, hr_alterado=current_time, data_informada=? where id_prevenda=?;";
        PreparedStatement ps = conexao.getPreparedStatement(sq);
        try {
            ps.setString(1, total);
            ps.setDate(2, clsaux.retornaData(datain));
            ps.setString(3, idmvt);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR DADOS \n\n"+ex.getMessage());
        }
        
    }
    public void inserirItensmovto(clsLancamentoTiro cl){
        String sqlin="insert into titens_prevenda (id_prevenda, id_produto, qnt, vl_total,data_lancado, hr_lancado, tipo_item,id_item,valor_unitario,barras,estado,acrescimo,desconto,unid)\n" +
                     "values (?,(select id_produto from tbarras where codigo_barras=?),?,?,current_date, current_time,?,?,?,?,2,0,0,?);";
         try {
                PreparedStatement psit= conexao.getPreparedStatement(sqlin);
                psit.setString(1, cl.getIdmovto());
                psit.setString(2, cl.getBarras());
                psit.setString(3, cl.getQnt());
                psit.setString(4, cl.getVltotal());
                psit.setString(5, cl.getTipoitem());
                psit.setString(6, cl.getNum_item());
                psit.setString(7, cl.getVlunitario());
                psit.setString(8, cl.getBarras());
                psit.setString(9, cl.getUnid());
                psit.executeUpdate();
                psit.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR DADOS \n\n"+ex.getMessage());
        }
    }
    public String inserirMovtoFinalizado(String total, String descont, String cliente,String idresev,String dat,String sub){
        String sql="insert into tmovimento (id_mov, id_tipo, id_modelo,data, hora, sub_total, total,desconto,id_parceiro,\n" +
                    "estado,dat_finalizacao, hora_finalizacao,numero_documento,base_icms,valor_icms,base_st,valor_st,valor_itens,outras_desp,acrescimo,serie) values (gen_id(gen_tmovimento_id,1),'5','00',current_date,\n" +
                    "current_time,?,?,?,?,'2',?,current_time,?,0,0,0,0,?,0,0,0);";
        String buscaid="select gen_id(gen_tmovimento_id,0) from rdb$database;";
        String atualiza="update tpre_venda set estado=2 where id_prevenda="+idresev;
        String retornoid=null;
       try {
             PreparedStatement ps = conexao.getPreparedStatement(sql);
             ps.setString(1, sub);
             ps.setString(2, total);
             ps.setString(3, descont);
             ps.setString(4, cliente);
             ps.setString(6, idresev);
             ps.setDate(5, clsaux.retornaData(dat));
             ps.setString(7, sub);
             ps.executeUpdate();
             ps.close();
             PreparedStatement psb= conexao.getPreparedStatementResult(buscaid);
             ResultSet rs = psb.executeQuery();
             rs.first();
             retornoid= rs.getString(1);
             rs.close();
             psb.close();
             PreparedStatement psa = conexao.getPreparedStatement(atualiza);
             psa.executeUpdate();
             psa.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR DADOS \n\n"+ex.getMessage());
        }
        return retornoid;       
    }
    public void inserirItensVenda(clsLancamentoTiro cl){
            String sq="insert into titens (id, id_mov,num_item,id_prod,quantidade,prec_venda,total,estado,desconto,acrescimo,cust_unitario,cust_total,codi_barra,codigo_baixa,fator)\n" +
                        "values (gen_id(gen_titens_id,1),?,?,(select id_produto from tbarras where codigo_barras=?),?,?,?,?,0,0,(select tp.preco_custo from tprecos tp join tbarras tb on tp.id=tb.id_produto where tb.codigo_barras=?),"
                    + "(select preco_custo*"+cl.getQnt()+" from tprecos tp join tbarras tb on tp.id=tb.id_produto where tb.codigo_barras=?),?,(select baixa_barra from tbarras where codigo_barras=?),(select fator from tbarras where codigo_barras=?));";
            try {
            PreparedStatement ps = conexao.getPreparedStatement(sq);
            System.out.println(sq);
            ps.setString(1, cl.getIdmovto());
            ps.setString(2, cl.getNum_item());
            ps.setString(3, cl.getBarras());
            ps.setString(4, cl.getQnt());
            ps.setString(5, cl.getVlunitario());
            ps.setString(6, cl.getVltotal());
            ps.setString(7, cl.getTipoitem());
            ps.setString(8, cl.getBarras());
            ps.setString(9, cl.getBarras());
            ps.setString(10, cl.getBarras());
            ps.setString(11, cl.getBarras());
            ps.setString(12, cl.getBarras());
            ps.executeUpdate();
            ps.close();
            //JOptionPane.showMessageDialog(null, sq);
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir item.");
            JOptionPane.showMessageDialog(null, sq);
        }
    }
    public void insereFinalidoraVenda(String idfi,String vl,String idmovt,String parc, Double troc,Date venc){
          try {
               String slq="update or insert into tpagamentos_adm (id_mov, id_finalizadora,valor_recebido,data,sequencia_finalizadora, valor_troco,estado,vencimento) values\n" +
                    "(?,?,?,current_date,?,?,2,?) matching (id_mov,sequencia_finalizadora);";
                 PreparedStatement pss= conexao.getPreparedStatement(slq);
                pss.setString(1, idmovt);
                pss.setString(2, idfi);
                pss.setString(3, vl);
                pss.setString(4, parc);
                pss.setDouble(5, troc);
                pss.setDate(6, venc);
                pss.executeUpdate();
                pss.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          
    }
    public void insereFinanceiroVenda(String valor,String finalizadr,String mv,String dat,String parceiro){
        try {
            String sql="insert into tmov_conta(id_movimentacao,id_conta,descricao_movimentacao,entrada,observacao,\n" +
                        "tipo_mov,subtipo_mov,tip_finalizadora,data,hora,id_movto,id_parceiro) values (gen_id(gen_tmov_conta_id,1),'1',\n" +
                        "?,?,?,?,?,?,?,current_time,?,?);";
            PreparedStatement psf= conexao.getPreparedStatement(sql);
            psf.setString(1, "ENTRADA REF. VENDA ADMINISTRATIVO");
            psf.setString(2, valor);
            psf.setString(3, "REFERENTE A VENDA REALIZADA NO ADM ID MOVIMENTO "+mv);
            psf.setString(4, "1");
            psf.setString(5, "13");
            psf.setString(6, finalizadr);
            psf.setDate(7, clsaux.retornaData(dat));
            psf.setString(8, mv);
            psf.setString(9, parceiro);
            psf.executeUpdate();
            psf.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR FINANCEIRO!!!");
        }
    }
    public void insereVisitante(String cpf,String nome, String idsocio){
        String sqlv="insert into tmovimento_visitante (id, id_socio_referent,nome_visitante,cpf_visi, data_visita,hora_visita)\n" +
                    "values(gen_id(gen_tmovimento_visitante_id,1),?,?,?,current_date,current_time);";
        PreparedStatement ps = conexao.getPreparedStatement(sqlv);
        try {
            ps.setString(1, idsocio);
            ps.setString(2, nome);
            ps.setString(3, cpf);
            ps.executeUpdate();
            ps.close();
            //JOptionPane.showMessageDialog(null, "inserido com sucesso...");
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro para inserir visitante...\n" +ex.getMessage());
        }
        
    }
    public void insereCreditoDireto(String parceiro, String valor){
        try {
            String sql="insert into tcredito_parceiro (id, id_parceiro,valor_original,valor_consumido,valor_restante,estado,data_lancamento,hr_lancamento, observacao)\n" +
                    "values(gen_id(tcredito_parceiro_id,1),?,?,?,?,1,current_date,current_time,?)";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, parceiro);
            ps.setString(2, valor);
            ps.setString(3, "0.00");
            ps.setString(4, valor);
            ps.setString(5, "Credito referente a valor de troco de venda.");
            ps.executeUpdate();
            ps.close();
            String sqlid="select gen_id(tcredito_parceiro_id,0) as id from rdb$database";
            PreparedStatement psid= conexao.getPreparedStatementResult(sqlid);
            ResultSet rsid= psid.executeQuery();
            rsid.first();
            String id= rsid.getString(1);
            rsid.close();
            psid.close();
            String sql2="insert into tmov_crdi_parc (id_mov,id_credito,valor,data, hr,parceiro)\n" +
"           values(gen_id(tmov_crdi_parc_id,1),?,?,current_date,current_time,?)";
            PreparedStatement ps2= conexao.getPreparedStatement(sql2);
            ps2.setString(1, id);
            ps2.setString(2, valor);
            ps2.setString(3, parceiro);
            ps2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insereCreditoCadastro(String parceiro, String valor,String obs,String data, String hora){
        try {
            String sql="insert into tcredito_parceiro (id, id_parceiro,valor_original,valor_consumido,valor_restante,estado,data_lancamento,hr_lancamento, observacao)\n" +
                    "values(gen_id(tcredito_parceiro_id,1),?,?,?,?,1,?,?,?)";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, parceiro);
            ps.setString(2, valor);
            ps.setString(3, "0.00");
            ps.setString(4, valor);
            ps.setDate(5, clsaux.retornaData(data));
            ps.setString(6, hora);
            ps.setString(7, obs);
            ps.executeUpdate();
            ps.close();
            String sqlid="select gen_id(tcredito_parceiro_id,0) as id from rdb$database";
            PreparedStatement psid= conexao.getPreparedStatementResult(sqlid);
            ResultSet rsid= psid.executeQuery();
            rsid.first();
            String id= rsid.getString(1);
            rsid.close();
            psid.close();
            String sql2="insert into tmov_crdi_parc (id_mov,id_credito,valor,data, hr,parceiro,estado,tipo)\n" +
            "values(gen_id(tmov_crdi_parc_id,1),?,?,?,?,?,'3','recarga')";
            PreparedStatement ps2= conexao.getPreparedStatement(sql2);
            ps2.setString(1, id);
            ps2.setString(2, valor);
            ps2.setString(5, parceiro);
            ps2.setDate(3, clsaux.retornaData(data));
            ps2.setString(4, hora);
            ps2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Gravado com Sucesso...");
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void insereHistoricoBaixaCredito(String parceiro,String valor,String movt,String idcred,String idtitulo){
        try {
            String sql2="insert into tmov_crdi_parc (id_mov,valor,data, hr,parceiro,id_movimento,estado,id_credito,id_titulo,tipo)\n" +
                    "values(gen_id(tmov_crdi_parc_id,1),?,current_date,current_time,?,?,3,?,?,'baixa')";
            PreparedStatement ps2= conexao.getPreparedStatement(sql2);
            ps2.setString(1, valor);
            ps2.setString(2, parceiro);
            ps2.setString(3, movt);
            ps2.setString(4, idcred);
            ps2.setString(5, idtitulo);
            ps2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Double retornaCreditoDisponivel(String idparceiro){
        Double valortotal=0.00;
        try {
            String sql="select sum(tc.valor_restante) from tcredito_parceiro tc\n" +
                        "where tc.id_parceiro=? and tc.estado=1";
            PreparedStatement ps= conexao.getPreparedStatementResult(sql);
            ps.setString(1, idparceiro);
            ResultSet rs = ps.executeQuery();
            rs.first();
            valortotal = rs.getDouble(1);
            rs.close();
            ps.close();
            } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO BUSCAR DADOS DO SALDO\n"+ex.getMessage());
        }
        return valortotal;
    }
    public void baixaValorCredito(String idcredito,Double valor){
        try {
            String sql="update tcredito_parceiro tc set tc.valor_restante=tc.valor_restante-?,\n" +
                    "tc.valor_consumido=tc.valor_consumido + ? where tc.id=?";
            
            PreparedStatement ps= conexao.getPreparedStatement(sql);
            ps.setDouble(1, valor);
            ps.setDouble(2, valor);
            ps.setString(3, idcredito);
            ps.executeUpdate();
            System.out.println(sql);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    }
    public void rateioValorBaixarPorUsoCredito(String idcliente, Double valorgeral,String idmovto,String titulo){
        Double valorrestante=0.00;
        Double saldo=0.00;
        String id=null;
        try {
            String sql="select tc.id,tc.valor_restante from tcredito_parceiro tc\n" +
                    "where id_parceiro=? and tc.valor_restante>0";
            PreparedStatement ps= conexao.getPreparedStatementResult(sql);
            ps.setString(1, idcliente);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                valorrestante=rs.getDouble(2);
                id=rs.getString(1);
                if(valorgeral>0){
                    if (valorgeral>valorrestante){
                        //roda quando o valor a ser baixado é maior qua o valor restante do credito
                        valorgeral=valorgeral-valorrestante;
                        this.baixaValorCredito(id, valorrestante);
                        this.insereHistoricoBaixaCredito(idcliente, valorrestante.toString(), idmovto,id,titulo);
                    } else if (valorgeral<=valorrestante){
                        this.baixaValorCredito(id, valorgeral);
                        this.insereHistoricoBaixaCredito(idcliente, valorgeral.toString(), idmovto,id,titulo);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    public void cancelamentoItem(String mvto, String indice,String tipo){
        try {
            String sql="update titens_prevenda ti set ti.estado='3' where ti.id_prevenda='"+mvto+"' and id_item='"+indice+"' and ti.tipo_item='"+tipo+"'";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            
            System.out.println(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     public void deletarItem(String mvto, String indice,String tipo){
        try {
            String sql="delete from titens_prevenda ti where ti.id_prevenda='"+mvto+"' and id_item='"+indice+"' and ti.tipo_item='"+tipo+"'";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lancamentoTiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
}
