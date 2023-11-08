/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Logs.gravarLog;
import model.clsLancDocCabecalho;
import model.clsLancDocument;
import classes.clsaux;
import conexoes.conexao;
import grafic.interfac.LancamentoDocumentos;
import grafic.interfac.frmLancamentoNfe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.tnf_infimportacao;

/**
 *
 * @author Lucas
 */
public class lancDocumentDAO {
    public static String insereRegistroBranco(String tipo){
        String sql="insert into tmovimento(id_mov,id_tipo,data,hora,estado)\n" +
                    "values (gen_id(gen_tmovimento_id,1),?,current_date,current_time,1);";
        String sqlid="select gen_id(gen_tmovimento_id,0) from rdb$database;";
        String idmov=null;
        PreparedStatement ps = conexao.getPreparedStatementResult(sql);
        try {
            ps.setString(1, tipo);
            ps.executeUpdate();
            ps.close();
            PreparedStatement psid= conexao.getPreparedStatementResult(sqlid);
            ResultSet rs = psid.executeQuery();
            rs.first();
            idmov=rs.getString(1);
            rs.close();
            psid.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados inicial do documento \n" +ex.getMessage());
        }
        return idmov;
    }
    public void atualizaRegistroMovto(clsLancDocCabecalho ldc){
        try {
            String sql="update or insert into tmovimento  (numero_documento,serie,data,dat_finalizacao,hora_finalizacao,\n" +
"                                                              id_parceiro,base_icms,valor_icms,base_st,valor_st,acrescimo,desconto,\n" +
"                                                              valor_itens,total,estado,sub_total,id_tipo,chave_acesso,valor_pis,valor_cofins,\n" +
"                                                              id_modelo,mvto_origem,importado_origem,id_mov,valor_ipi,cfop) values(?,?,?,?,current_time,?,?,?,?,?,?,?,?,?,2,\n" +
"                                                              ?,?,?,?,?,?,?,?,?,?,?) matching(id_mov);";
            
            PreparedStatement psin = conexao.getPreparedStatement(sql);
            psin.setString(1, ldc.getDocument());
            psin.setString(2, ldc.getSerie());
            psin.setDate(3, ldc.getEmissao());
            psin.setDate(4, ldc.getLancamento());
            psin.setString(5, ldc.getIdparceiro());
            psin.setString(6, ldc.getBaseicms());
            psin.setString(7, ldc.getValoricms());
            psin.setString(8, ldc.getBasest());
            psin.setString(9, ldc.getValorst());
            psin.setString(10, ldc.getOutrasdesp());
            psin.setString(11, ldc.getDesconto());
            psin.setString(12, ldc.getTotalprod());
            psin.setString(14, ldc.getTotalprod());
            psin.setString(13, ldc.getTotal());
            psin.setString(15, ldc.getTipomovimento());
            psin.setString(16, ldc.getChaveacesso());
            psin.setString(17, ldc.getValor_pis());
            psin.setString(18, ldc.getValor_cofins());
            psin.setString(19, ldc.getModelo());
            psin.setString(20, ldc.getOrigem());
            psin.setString(21, ldc.getMvtoOrigem());
            psin.setString(22, ldc.getIdmovimento());
            psin.setString(23, ldc.getValoripi());
            psin.setString(24, ldc.getCfop());
            psin.executeUpdate();
            psin.close();
            LancamentoDocumentos.numeitem=0;
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso...");
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados do documento\n"+ex.getMessage());
        }
    }
    public void insereItensReferenteMovto(clsLancDocument ld){
        try {
            String sqlinsert="update or insert into  titens (id,id_mov,id_prod,quantidade,prec_venda,total,desconto,acrescimo,estado,num_item,unidade,codi_barra,codigo_baixa,fator,"
                    + "     cfop,cst,base_icms,aliq_icms,valor_icms,base_st,valor_st,modbc,red_bc,pis_cofins,base_pis,valor_pis,valor_cofins,aliq_pis,aliq_cofins,cst_ipi,base_ipi,aliq_ipi,valor_ipi,"
                    + "     desc_fornecedor,cod_fornecedor,ncm,origem_prod,sub_total,cust_unitario,imp,cust_total,vl_frete,vl_seguro,vl_outras,barra_comercial,qnt_comercial)\n" +
                    "values (gen_id(gen_titens_id,1),?,?,?,?,?,?,?,2,?,?,?,(select baixa_barra from tbarras where codigo_barras=?),?,"
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) matching (id_mov, num_item) ;";
            PreparedStatement psi=conexao.getPreparedStatement(sqlinsert);
            psi.setString(1, ld.getIdmovto());
            psi.setString(2, ld.getIdproduto());
            psi.setString(3, clsaux.capturaValor(ld.getQuantidade()));
            psi.setString(4, clsaux.capturaValor(ld.getPrecovenda()));
            psi.setString(5, clsaux.capturaValor(ld.getTotal()));
            psi.setString(6, clsaux.trataCampoNulo(ld.getDesconto()));
            psi.setString(7, clsaux.trataCampoNulo(ld.getAcrescimo()));
            psi.setString(8, ld.getNumeroitem());
            psi.setString(9, ld.getUnidade());
            psi.setString(10,ld.getBarras());
            psi.setString(11,ld.getBarras());
            psi.setString(12, clsaux.capturaValor(ld.getFator()));
            psi.setString(13,ld.getCfop());
            psi.setString(14,ld.getCst());
            psi.setString(15, clsaux.trataCampoNulo(ld.getBase_icms()));
            psi.setString(16, clsaux.trataCampoNulo(ld.getAliq_icms()));
            psi.setString(17, clsaux.trataCampoNulo(ld.getValor_icms()));
            psi.setString(18, clsaux.trataCampoNulo(ld.getBase_st()));
            psi.setString(19, clsaux.trataCampoNulo(ld.getValor_st()));
            psi.setString(20, ld.getModbc());
            psi.setString(21, clsaux.trataCampoNulo(ld.getRed_bc()));
            psi.setString(22, ld.getPis_cofins());
            psi.setString(23, clsaux.trataCampoNulo(ld.getBase_pis()));
            psi.setString(24, clsaux.trataCampoNulo(ld.getValor_pis()));
            psi.setString(25, clsaux.trataCampoNulo(ld.getValor_cofins()));
            psi.setString(26, clsaux.trataCampoNulo(ld.getAliq_pis()));
            psi.setString(27, clsaux.trataCampoNulo(ld.getAliq_cofins()));
            psi.setString(28, ld.getCstipi());
            psi.setString(29, clsaux.trataCampoNulo(ld.getBase_ipi()));
            psi.setString(30,clsaux.trataCampoNulo( ld.getAliq_ipi()));
            psi.setString(31,clsaux.trataCampoNulo( ld.getValor_ipi()));
            psi.setString(32,clsaux.trataCampoNulo( ld.getDescricaofornecedor()));
            psi.setString(33,clsaux.trataCampoNulo( ld.getCodfornecedor()));
            psi.setString(34,clsaux.trataCampoNulo( ld.getNcm()));
            psi.setString(35,clsaux.trataCampoNulo( ld.getOrigem_produto()));
            psi.setString(36, clsaux.trataCampoNulo(ld.getSubtotal()));
            System.out.println(ld.getCusto());
            psi.setString(37, clsaux.trataCampoNulo(clsaux.capturaValor(ld.getCusto())));
            psi.setString(38, ld.getImportadoNfe());
            Double totalcusto=clsaux.capturaValores(ld.getCusto())*clsaux.capturaValores(ld.getQuantidade());
            psi.setString(39,  clsaux.capturaValor(clsaux.formato(totalcusto)));
            psi.setString(40, clsaux.trataCampoNulo(ld.getValor_frete()));
            psi.setString(41, clsaux.trataCampoNulo(ld.getValor_seguro()));
            psi.setString(42, clsaux.trataCampoNulo(ld.getValor_outras()));
            psi.setString(43, ld.getEanComer());
            psi.setString(44, ld.getQntComercial());
            psi.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void atualizaItensMovto(clsLancDocument ld){
        try {
            String sql="update  titens set quantidade=?,prec_venda=?,total=?,desconto=?,acrescimo=?,unidade=?,codi_barra=?,id_prod=?,\n" +
                    "codigo_baixa=(select baixa_barra from tbarras where codigo_barras=?),fator=(select fator from tbarras where codigo_barras=?) "
                    + "where id_mov="+ld.getIdmovto()+" and num_item="+ld.getNumeroitem()+" ";
            PreparedStatement ps=conexao.getPreparedStatement(sql);
            ps.setString(1, ld.getQuantidade());
            ps.setString(2, ld.getPrecovenda());
            ps.setString(3, ld.getTotal());
            ps.setString(4, ld.getDesconto());
            ps.setString(5, ld.getAcrescimo());
            ps.setString(6, ld.getUnidade());
            ps.setString(9, ld.getBarras());
            ps.setString(10, ld.getBarras());
            ps.setString(7, ld.getBarras());
            ps.setString(8, ld.getIdproduto());
            System.out.println(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro para atualizar registro do item\n "+ ex.getMessage());
        }
    }
    public static void excluirItem(String iditem, String idmovito){
        try {
            String sqlexc="update titens set estado=3 where id_mov=? and num_item=?";
            PreparedStatement ps = conexao.getPreparedStatement(sqlexc);
            ps.setString(1, idmovito);
            ps.setString(2, iditem);
            ps.executeUpdate();
            ps.close();
            //JOptionPane.showMessageDialog(null, "Excluido!!!");
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao escluir item\n "+ex.getMessage());
        }
    }
    public static clsLancDocCabecalho buscaCabecalhoDoc(clsLancDocCabecalho cld){
        try {
            String sql="select tm.id_mov,\n" +
"                           tm.numero_documento,\n" +
"                           tm.serie,\n" +
"                           tm.data,\n" +
"                           tm.dat_finalizacao,\n" +
"                           tm.id_parceiro,\n" +
"                           tm.base_icms,\n" +
"                           tm.valor_icms,\n" +
"                           tm.base_st,\n" +
"                           tm.valor_st,\n" +
"                           tm.acrescimo,\n" +
"                           tm.desconto,\n" +
"                           tm.sub_total,\n" +
"                           tm.total,\n" +
"                         tm.id_tipo,\n" +
"                         td.descricao,"
                    + "   tm.valor_pis,"
                    + "   tm.valor_cofins,"
                    + "   tm.chave_acesso,tm.id_modelo,tm.hora,tm.mvto_origem,tm.importado_origem,tm.valor_ipi,tm.cfop  \n" +
"                    from tmovimento tm\n" +
"                    join ttipo_documentos td on tm.id_tipo=td.id \n" +
                    "where tm.id_mov=?";
            PreparedStatement psd= conexao.getPreparedStatementResult(sql);
            psd.setString(1, cld.getIdmovimento());
            ResultSet rsd= psd.executeQuery();
            rsd.first();
            cld.setIdmovimento(rsd.getString(1));
            cld.setDocument(rsd.getString(2));
            cld.setSerie(rsd.getString(3));
            cld.setEmissao(rsd.getDate(4));
            cld.setLancamento(rsd.getDate(5));
            cld.setIdparceiro(rsd.getString(6));
            cld.setBaseicms(rsd.getString(7));
            cld.setValoricms(rsd.getString(8));
            cld.setBasest(rsd.getString(9));
            cld.setValorst(rsd.getString(10));
            cld.setOutrasdesp(rsd.getString(11));
            cld.setDesconto(rsd.getString(12));
            cld.setTotalprod(rsd.getString(13));
            cld.setTotal(rsd.getString(14));
            cld.setTipomovimento(rsd.getString(15)+"- "+rsd.getString(16));
            cld.setValor_pis(rsd.getString(17));
            cld.setValor_cofins(rsd.getString(18));
            cld.setChaveacesso(rsd.getString(19));
            cld.setModelo(rsd.getString(20));
            cld.setHorafinalizado(rsd.getTime(21));
            cld.setMvtoOrigem(rsd.getString(23));
            cld.setOrigem(rsd.getString(22));
            cld.setValoripi(rsd.getString(24));
            cld.setCfop(rsd.getString(25));
            rsd.close();
            psd.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Documento Não Localizado!!!");
        }
        return cld;
    }
    public static List<clsLancDocument> buscaItens(String idmovimento){
        List<clsLancDocument> listaitens= new ArrayList();
        try {
            String sqlitem="select  ti.num_item,\n" +
                    "        ti.id_prod,\n" +
                    "        ti.quantidade,\n" +
                    "        ti.prec_venda,\n" +
                    "        ti.total,\n" +
                    "        ti.desconto,\n" +
                    "        ti.acrescimo,\n" +
                    "        tp.nomelongo, \n"
                    + "      ti.unidade,   \n"
                    + "      ti.codi_barra,"
                    + "ti.cfop,"
                    + "ti.cst,"
                    + "ti.base_icms,"
                    + "ti.aliq_icms,"
                    + "ti.valor_icms,"
                    + "ti.base_st,"
                    + "ti.valor_st,"
                    + "ti.modbc,"
                    + "ti.red_bc,"
                    + "ti.pis_cofins,"
                    + "ti.base_pis,"
                    + "ti.valor_pis,"
                    + "ti.valor_cofins,"
                    + "ti.aliq_pis,"
                    + "ti.aliq_cofins,"
                    + "ti.cst_ipi,"
                    + "ti.base_ipi,"
                    + "ti.aliq_ipi,"
                    + "ti.valor_ipi,"
                    + "ti.desc_fornecedor,"
                    + "ti.cod_fornecedor,ti.ncm,ti.origem_prod,ti.imp,ti.sub_total,ti.fator,vl_frete,vl_seguro,vl_outras,ti.barra_comercial,ti.qnt_comercial    \n  " +
                    "from titens ti\n" +
                    "left join tprodutos tp on ti.id_prod=tp.id\n" +
                    "where ti.id_mov=? and ti.estado=2 order by 1 asc";
            PreparedStatement psi= conexao.getPreparedStatementResult(sqlitem);
            psi.setString(1, idmovimento);
            ResultSet rsi= psi.executeQuery();
            while(rsi.next()){
                clsLancDocument item= new clsLancDocument();
                item.setNumeroitem(rsi.getString(1));
                item.setIdproduto(rsi.getString(2));
                item.setQuantidade(rsi.getString(3));
                item.setPrecovenda(rsi.getString(4));
                item.setTotal(rsi.getString(5));
                item.setDesconto(rsi.getString(6));
                item.setAcrescimo(rsi.getString(7));
                item.setUnidade(rsi.getString(9));
                item.setBarras(rsi.getString(10));
                item.setCfop(rsi.getString(11));
                item.setCst(rsi.getString(12));
                item.setBase_icms(rsi.getString(13));
                item.setAliq_icms(rsi.getString(14));
                item.setValor_icms(rsi.getString(15));
                item.setBase_st(rsi.getString(16));
                item.setValor_st(rsi.getString(17));
                item.setModbc(rsi.getString(18));
                item.setRed_bc(rsi.getString(19));
                item.setPis_cofins(rsi.getString(20));
                item.setBase_pis(rsi.getString(21));
                item.setValor_pis(rsi.getString(22));
                item.setValor_cofins(rsi.getString(23));
                item.setAliq_pis(rsi.getString(24));
                item.setAliq_cofins(rsi.getString(25));
                item.setCstipi(rsi.getString(26));
                item.setBase_ipi(rsi.getString(27));
                item.setAliq_ipi(rsi.getString(28));
                item.setValor_ipi(rsi.getString(29));
                item.setDescricaofornecedor(rsi.getString(30));
                item.setCodfornecedor(rsi.getString(31));
                item.setNcm(rsi.getString(32));
                item.setOrigem_produto(rsi.getString(33));
                item.setImportadoNfe(rsi.getString(34));
                item.setSubtotal(rsi.getString(35));
                item.setFator(rsi.getString(36));
                item.setValor_frete(rsi.getString(37));
                item.setValor_seguro(rsi.getString(38));
                item.setValor_outras(rsi.getString(39));
                item.setEanComer(rsi.getString(40));
                item.setQntComercial(rsi.getString(41));
                listaitens.add(item);
            }
           
            rsi.close();
            psi.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao buscar dados dos produtos\n\n" +ex.getMessage());
        }
        return listaitens;
            
    }
    public void deletar(String id){
        try {
            String sql="update tmovimento set estado=3 where id_mov=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
            String sql2="update tmov_crdi_parc set estado=3 where id_movimento=?";
            PreparedStatement ps2= conexao.getPreparedStatement(sql2);
            ps2.setString(1, id);
            ps2.executeUpdate();
            ps2.close();
            String sql3="update tcontas_a_receber_pagar set estado=3 where id_movimento=?";
            PreparedStatement ps3 = conexao.getPreparedStatement(sql3);
            ps3.setString(1, id);
            ps3.executeUpdate();
            ps3.close();
            String sql4="update tcredito_parceiro tc set tc.valor_restante= tc.valor_restante+(select sum(tp.valor_recebido)\n" +
                        "from tpagamentos_adm tp where tp.id_mov=? and tp.id_finalizadora=8),\n" +
                        "tc.valor_consumido= tc.valor_consumido-(select sum(tp.valor_recebido)\n" +
                        "from tpagamentos_adm tp where tp.id_mov=? and tp.id_finalizadora=8) where tc.id=\n" +
                        "(select tr.id_credito from tmov_crdi_parc tr where tr.id_movimento=?)";
            PreparedStatement ps4= conexao.getPreparedStatement(sql4);
            ps4.setString(1, id);
            ps4.setString(2, id);
            ps4.setString(3, id);
            ps4.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao excluir \n\n" +ex.getMessage());
        }
    }
    public void realizaRateioDescontoItens(String idmov, Double valordesc){
        try {
            String sqlContagemItens="select count(id) as total_itens from titens where id_mov=? and estado=2";
            PreparedStatement ps = conexao.getPreparedStatement(sqlContagemItens);
            ps.setString(1, idmov);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int numItem= rs.getInt(1);
            rs.close();
            ps.close();
            Double valorLiq= valordesc/numItem;
            String sqlValorRateio="update titens ti set ti.desconto=?, ti.total=(ti.quantidade*ti.prec_venda-?)\n" +
                                  "where ti.id_mov=? and ti.estado=2;";
            PreparedStatement pss = conexao.getPreparedStatement(sqlValorRateio);
            pss.setDouble(1, valorLiq);
            pss.setDouble(2, valorLiq);
            pss.setString(3, idmov);
            pss.executeUpdate();
            pss.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao Realizar Rateio do Desconto"+ex.getMessage());
        }
}
    public void excluiFinalizadora(String idmov, String idfinalizadora, String sequencia){
        try {
            String sql="update tpagamentos_adm tm set tm.estado=3 where tm.id_mov="+idmov+" and tm.id_finalizadora="+idfinalizadora+"\n" +
                    "and tm.sequencia_finalizadora="+sequencia+"";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            //ps.setString(1, idmov);
            //ps.setString(2, idfinalizadora);
            //ps.setString(3, sequencia);
            System.out.println(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao Cancelar pagamento"+ex.getMessage());
        }
        
    
    }
    public static boolean verificaRegistroLancado(String parceiro,String documento,String serie){
       boolean retorno=false;
        try {
            String sql="select count (tm.id_mov) from tmovimento tm where tm.id_parceiro=? and tm.numero_documento=? and tm.serie=? and tm.estado<>'3'";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, parceiro);
            ps.setString(2, documento);
            ps.setString(3, serie);
            ResultSet rs = ps.executeQuery();
            rs.first();
            if(rs.getString(1).equals("0")){
                 retorno=false;
            }else{
                retorno=true;// retorna verdadeiro se localizar documento lancadado
            }
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao buscar dados do cabecalho do documento\n\n"+ex.getMessage());
             gravarLog.main(ex.getMessage());
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    public List<clsLancDocCabecalho> buscarListaMovimentosData(String dataini,String datafim,String modelo){
         List<clsLancDocCabecalho> lista= new ArrayList<>();
        try {
           
            String sql="select tm.id_mov,\n" +
"                           tm.numero_documento,\n" +
"                           tm.serie,\n" +
"                           tm.data,\n" +
"                           tm.dat_finalizacao,\n" +
"                           tm.id_parceiro,\n" +
"                           tm.base_icms,\n" +
"                           tm.valor_icms,\n" +
"                           tm.base_st,\n" +
"                           tm.valor_st,\n" +
"                           tm.acrescimo,\n" +
"                           tm.desconto,\n" +
"                           tm.sub_total,\n" +
"                           tm.total,\n" +
"                         tm.id_tipo,\n" +
"                         td.descricao,"
                    + "   tm.valor_pis,"
                    + "   tm.valor_cofins,"
                    + "     tm.chave_acesso,tm.id_modelo,tm.hora  \n" +
"                    from tmovimento tm\n" +
"                    join ttipo_documentos td on tm.id_tipo=td.id \n" +
                    "where tm.dat_finalizacao between ? and ? and (tm.id_modelo=? or tm.id_modelo='99')  and tm.estado='2' and tm.id_tipo='1'";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setDate(1, clsaux.retornaData(dataini));
            ps.setDate(2, clsaux.retornaData(datafim));
            ps.setString(3, modelo);
            ResultSet rsd = ps.executeQuery();
            while (rsd.next()){
                clsLancDocCabecalho cld= new clsLancDocCabecalho();
                cld.setIdmovimento(rsd.getString(1));
                cld.setDocument(rsd.getString(2));
                cld.setSerie(rsd.getString(3));
                cld.setEmissao(rsd.getDate(4));
                cld.setLancamento(rsd.getDate(5));
                cld.setIdparceiro(rsd.getString(6));
                cld.setBaseicms(rsd.getString(7));
                cld.setValoricms(rsd.getString(8));
                cld.setBasest(rsd.getString(9));
                cld.setValorst(rsd.getString(10));
                cld.setOutrasdesp(rsd.getString(11));
                cld.setDesconto(rsd.getString(12));
                cld.setTotalprod(rsd.getString(13));
                cld.setTotal(rsd.getString(14));
                cld.setTipomovimento(rsd.getString(15)+"- "+rsd.getString(16));
                cld.setValor_pis(rsd.getString(17));
                cld.setValor_cofins(rsd.getString(18));
                cld.setChaveacesso(rsd.getString(19));
                cld.setModelo(rsd.getString(20));
                cld.setHorafinalizado(rsd.getTime(21));
                lista.add(cld);
            }
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
    
    //gera um registro de venda a partir de lancamento como pedido,orcamento,condicional e ordem de servico
    public String  gerarVendaApartirLancamento(String tipoLancamento,String idLancamento,String modelo,String tipo,String parceiro,String ori,String desconto){
        
            String idMovimentoGerado= insereRegistroBranco(tipo); // crio linha tmovimento e retorno a id desse movimento
            try {
            String sql="select tc.id,tm.codibarra, tp.nomecurto,\n" +
                    "    tm.qnt,tm.unitario,tm.acrescimo,tm.desconto,tm.total,\n" +
                    "    tm.unidade,tm.id_item,tc.ncm,tc.sit_tributaria,tc.cfop,\n" +
                    "    tc.aliq_icms,tpc.aliq_pis,tpc.aliq_cofins,tc.pis_saida,tc.preco_custo,tb.fator\n" +
                    " from torcamento_itens tm\n" +
                    " left join tbarras tb on tm.codibarra=tb.codigo_barras\n" +
                    " left join tprecos tc on tb.id_produto=tc.id\n" +
                    " left join tprodutos tp on tc.id=tp.id\n" +
                    " left join tpis_cofins tpc on tc.pis_saida=tpc.identificacao\n" +
                    " where tm.id_orcamento=? and tm.estado='2'";
            if(tipoLancamento.equals("OS")){
             sql="select tc.id,tm.cod_item as codibarra,  tp.nomecurto,\n" +
"                        tm.qnt,tm.vl_unit as unitario,tm.acrescimo,tm.desconto,tm.total,\n" +
"                        tm.unid as unidade,tm.id_item,tc.ncm,tc.sit_tributaria,tc.cfop,\n" +
"                        tc.aliq_icms,tpc.aliq_pis,tpc.aliq_cofins,tc.pis_saida,tc.preco_custo,tb.fator\n" +
"                     from tos_item tm\n" +
"                     left join tbarras tb on tm.cod_item =tb.codigo_barras\n" +
"                     left join tprecos tc on tb.id_produto=tc.id\n" +
"                     left join tprodutos tp on tc.id=tp.id\n" +
"                     left join tpis_cofins tpc on tc.pis_saida=tpc.identificacao\n" +
"                     where tm.id_os=? and tm.estado='2' and tp.tipo_produto='0'";
            }else if(tipoLancamento.equals("Condicional")){
                sql="select tc.id,tm.barras as codibarra,  tp.nomecurto,\n" +
"                        tm.qnt,tm.valor_unitario as unitario,tm.acrescimo,tm.desconto,tm.vl_total as total,\n" +
"                        tm.unid as unidade,tm.id_item,tc.ncm,tc.sit_tributaria,tc.cfop,\n" +
"                        tc.aliq_icms,tpc.aliq_pis,tpc.aliq_cofins,tc.pis_saida,tc.preco_custo,tb.fator\n" +
"                     from titens_prevenda tm\n" +
"                     left join tbarras tb on tm.barras =tb.codigo_barras\n" +
"                     left join tprecos tc on tb.id_produto=tc.id\n" +
"                     left join tprodutos tp on tc.id=tp.id\n" +
"                     left join tpis_cofins tpc on tc.pis_saida=tpc.identificacao\n" +
"                     where tm.id_prevenda=? and tm.estado='2'";
            }
            
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idLancamento);
            ResultSet rs = ps.executeQuery();
            clsLancDocument item= new clsLancDocument();
            clsLancDocCabecalho cd= new clsLancDocCabecalho();
            Double desc=0.00,acre=0.00,subTotal=0.00,pis=0.00,cofins=0.00;
            while(rs.next()){
                item.setIdmovto(idMovimentoGerado);
                item.setIdproduto(rs.getString("id"));
                item.setBarras(rs.getString("codibarra"));
                item.setDescricaofornecedor(rs.getString("nomecurto"));
                item.setQuantidade(rs.getString("qnt"));
                item.setPrecovenda(rs.getString("unitario"));
                item.setAcrescimo(rs.getString("acrescimo"));
                item.setDesconto(rs.getString("desconto"));
                item.setTotal(rs.getString("total"));
                item.setUnidade(rs.getString("unidade"));
                item.setNumeroitem(rs.getString("id_item"));
                item.setFator(rs.getString("fator"));
                item.setValor_outras("0.00");
                item.setValor_frete("0.00");
                item.setValor_seguro("0.00");
                item.setNcm(rs.getString("ncm"));
                item.setCst(rs.getString("sit_tributaria"));
                item.setRed_bc("0.00");
                item.setBase_icms("0.00");
                item.setValor_icms("0.00");
                item.setAliq_icms("0.00");
                item.setBase_st("0.00");
                item.setValor_st("0.00");
                item.setPis_cofins(rs.getString("pis_saida"));
                item.setBase_pis(rs.getString("total"));
                item.setAliq_pis(rs.getString("aliq_pis"));
                item.setAliq_cofins(rs.getString("aliq_cofins"));
                item.setValor_pis(clsaux.capturaValor(clsaux.formato(rs.getDouble("total")*rs.getDouble("aliq_pis")/100)));
                item.setValor_cofins(clsaux.capturaValor(clsaux.formato(rs.getDouble("total")*rs.getDouble("aliq_cofins")/100)));
                item.setCstipi("0");
                item.setBase_ipi("0.00");
                item.setAliq_ipi("0.00");
                item.setValor_ipi("0.00");
                item.setCfop(rs.getString("cfop"));
                item.setCusto(rs.getString("preco_custo"));
                desc=desc+rs.getDouble("desconto");
                acre=acre+rs.getDouble("acrescimo");
                subTotal=subTotal+(rs.getDouble("unitario")*rs.getDouble("qnt"));
                pis=pis+rs.getDouble("total")*rs.getDouble("aliq_pis")/100;
                cofins=cofins+rs.getDouble("total")*rs.getDouble("aliq_cofins")/100;
                insereItensReferenteMovto(item);
              }
            desc=desc+clsaux.capturaValores(desconto);
            cd.setIdmovimento(idMovimentoGerado);
            cd.setDocument(idLancamento);
            cd.setSerie("0");
            cd.setModelo(modelo);
            cd.setEmissao(clsaux.retornaData(clsaux.preencheData()));
            cd.setLancamento(clsaux.retornaData(clsaux.preencheData()));
            cd.setIdparceiro(parceiro);
            cd.setBaseicms("0.00");
            cd.setValoricms("0.00");
            cd.setBasest("0.00");
            cd.setValorst("0.00");
            cd.setOutrasdesp(clsaux.capturaValor(clsaux.formato(acre)));
            cd.setDesconto(clsaux.capturaValor(clsaux.formato(desc)));
            cd.setTotalprod(clsaux.capturaValor(clsaux.formato(subTotal)));
            cd.setTotal(clsaux.capturaValor(clsaux.formato(subTotal-desc+acre)));
            cd.setChaveacesso("");
            cd.setTipomovimento("2");
            cd.setValor_pis(clsaux.capturaValor(clsaux.formato(pis)));
            cd.setValor_cofins(clsaux.capturaValor(clsaux.formato(cofins)));
            cd.setOrigem(idLancamento);
            cd.setMvtoOrigem(ori);
            atualizaRegistroMovto(cd);
            if(clsaux.capturaValores(desconto)>0){
                nfeDAO.realizaRateioDescontoItens(idMovimentoGerado, desc,subTotal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados do documento\n"+ex.getMessage());
        }
            return idMovimentoGerado;
    }
    // gera uma lista com os itens para importacao na nfe
    public List<clsLancDocument> retornaListaProdutos(String tipoLancamento,String idLancamento,String mvto) throws SQLException{
        List<clsLancDocument> lista= new ArrayList<>();
          String sql="select tc.id,tm.codibarra, tp.nomecurto,\n" +
                    "    tm.qnt,tm.unitario,tm.acrescimo,tm.desconto,tm.total,\n" +
                    "    tm.unidade,tm.id_item,tc.ncm,tc.sit_tributaria,tc.cfop,\n" +
                    "    tc.aliq_icms,tpc.aliq_pis,tpc.aliq_cofins,tc.pis_saida,tc.preco_custo\n" +
                    " from torcamento_itens tm\n" +
                    " left join tbarras tb on tm.codibarra=tb.codigo_barras\n" +
                    " left join tprecos tc on tb.id_produto=tc.id\n" +
                    " left join tprodutos tp on tc.id=tp.id\n" +
                    " left join tpis_cofins tpc on tc.pis_saida=tpc.identificacao\n" +
                    " where tm.id_orcamento=? and tm.estado='2'";
            if(tipoLancamento.equals("OS")){
             sql="select tc.id,tm.cod_item as codibarra,  tp.nomecurto,\n" +
"                        tm.qnt,tm.vl_unit as unitario,tm.acrescimo,tm.desconto,tm.total,\n" +
"                        tm.unid as unidade,tm.id_item,tc.ncm,tc.sit_tributaria,tc.cfop,\n" +
"                        tc.aliq_icms,tpc.aliq_pis,tpc.aliq_cofins,tc.pis_saida,tc.preco_custo\n" +
"                     from tos_item tm\n" +
"                     left join tbarras tb on tm.cod_item =tb.codigo_barras\n" +
"                     left join tprecos tc on tb.id_produto=tc.id\n" +
"                     left join tprodutos tp on tc.id=tp.id\n" +
"                     left join tpis_cofins tpc on tc.pis_saida=tpc.identificacao\n" +
"                     where tm.id_os=? and tm.estado='2'";
            }else if(tipoLancamento.equals("Condicional")){
                sql="select tc.id,tm.barras as codibarra,  tp.nomecurto,\n" +
"                        tm.qnt,tm.valor_unitario as unitario,tm.acrescimo,tm.desconto,tm.vl_total as total,\n" +
"                        tm.unid as unidade,tm.id_item,tc.ncm,tc.sit_tributaria,tc.cfop,\n" +
"                        tc.aliq_icms,tpc.aliq_pis,tpc.aliq_cofins,tc.pis_saida,tc.preco_custo\n" +
"                     from titens_prevenda tm\n" +
"                     left join tbarras tb on tm.barras =tb.codigo_barras\n" +
"                     left join tprecos tc on tb.id_produto=tc.id\n" +
"                     left join tprodutos tp on tc.id=tp.id\n" +
"                     left join tpis_cofins tpc on tc.pis_saida=tpc.identificacao\n" +
"                     where tm.id_prevenda=? and tm.estado='2'";
            }else if(tipoLancamento.equals("Nfce")){
                sql="select tc.id,tm.codi_barra as codibarra,  tp.nomecurto,\n" +
"                        tm.quantidade as qnt ,tm.prec_venda as unitario,tm.acrescimo,tm.desconto,tm.total as total,\n" +
"                        tm.unidade as unidade,tm.num_item,tc.ncm,tc.sit_tributaria,tc.cfop,\n" +
"                        tc.aliq_icms,tpc.aliq_pis,tpc.aliq_cofins,tc.pis_saida,tc.preco_custo\n" +
"                     from titens tm\n" +
"                     left join tbarras tb on tm.codi_barra =tb.codigo_barras\n" +
"                     left join tprecos tc on tb.id_produto=tc.id\n" +
"                     left join tprodutos tp on tc.id=tp.id\n" +
"                     left join tpis_cofins tpc on tc.pis_saida=tpc.identificacao\n" +
"                     where tm.id_mov=? and tm.estado='2'";
            }
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idLancamento);
            ResultSet rs = ps.executeQuery();
             while(rs.next()){
                clsLancDocument item= new clsLancDocument();
                item.setIdmovto(mvto);
                item.setNumeroitem(String.valueOf(frmLancamentoNfe.numeitem));
                item.setIdproduto(rs.getString("id"));
                item.setBarras(rs.getString("codibarra"));
                item.setDescricaofornecedor(rs.getString("nomecurto"));
                item.setQuantidade(rs.getString("qnt"));
                item.setPrecovenda(rs.getString("unitario"));
                item.setAcrescimo(rs.getString("acrescimo"));
                item.setDesconto(rs.getString("desconto"));
                item.setTotal(rs.getString("total"));
                item.setUnidade(rs.getString("unidade"));
                item.setValor_outras("0.00");
                item.setValor_frete("0.00");
                item.setValor_seguro("0.00");
                item.setNcm(rs.getString("ncm"));
                item.setCst(rs.getString("sit_tributaria"));
                item.setRed_bc("0.00");
                item.setBase_icms("0.00");
                item.setValor_icms("0.00");
                item.setAliq_icms("0.00");
                item.setBase_st("0.00");
                item.setValor_st("0.00");
                item.setPis_cofins(rs.getString("pis_saida"));
                item.setBase_pis(rs.getString("total"));
                item.setAliq_pis(rs.getString("aliq_pis"));
                item.setAliq_cofins(rs.getString("aliq_cofins"));
                item.setValor_pis(clsaux.capturaValor(clsaux.formato(rs.getDouble("total")*rs.getDouble("aliq_pis")/100)));
                item.setValor_cofins(clsaux.capturaValor(clsaux.formato(rs.getDouble("total")*rs.getDouble("aliq_cofins")/100)));
                item.setCstipi("0");
                item.setBase_ipi("0.00");
                item.setAliq_ipi("0.00");
                item.setValor_ipi("0.00");
                if(tipoLancamento.equals("Nfce")){
                    item.setCfop("5929");
                }else{
                    item.setCfop(rs.getString("cfop"));
                }
                item.setCusto(rs.getString("preco_custo"));
                lista.add(item);
                frmLancamentoNfe.numeitem++;
              }
             rs.close();
             ps.close();
             return lista;
    
    }
   
    public void insereRegistrosImportados(tnf_infimportacao inf){
        
        String sql="UPDATE OR INSERT INTO TNF_INFIMPORTACAO (IDMOVTO, IDORIGEM, TIPO, PERCENTUAL)\n" +
"                                 VALUES (?, ?, ?, ?)\n" +
"                               MATCHING (IDMOVTO, IDORIGEM, TIPO);";
         try {
            PreparedStatement ps = conexao.getPreparedStatement(sql);
           
                ps.setString(1, inf.getIdmvto());
                ps.setString(2, inf.getIdorigem());
                ps.setString(3, inf.getTipo());
                ps.setDouble(4, inf.getPercentual());
                ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(lancDocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }

}