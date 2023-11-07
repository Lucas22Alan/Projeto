
package DAO;

import model.CadContasRecPagar;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ContasReceberDAO {
    public void inserir(CadContasRecPagar cp){
        try {
                 String sql="insert into tcontas_a_receber_pagar (id, id_movimento, id_parceiro,data,valor, numero_documento,\n" +
                    "data_emissao,data_vencimento,estado,tipo_titulo,id_conta,id_historico,pagar_receber,id_contrato,id_banco,id_vendedor,"
                         + "parcela,juros,desconto,valor_total,observacao,id_tipo_financeiro,id_subtipo_financeiro,nosso_numero,numero_parcelas)\n" +
                    "values (gen_id(GEN_TCONTAS_A_RECEBER_PAGAR_ID,1),?,?,current_date,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                 PreparedStatement psins= conexao.getPreparedStatement(sql);
                 psins.setString(1, cp.getIdmovto());
                 psins.setString(2, cp.getParceiro());
                 psins.setString(3, cp.getValor());
                 psins.setString(4, cp.getNumero());
                 psins.setDate(5, cp.getEmisao());
                 psins.setDate(6, cp.getVencimento());
                 psins.setString(7, cp.getEstadotitulo());
                 psins.setString(8, cp.getTipo_titulo());
                 psins.setString(9, cp.getConta());
                 psins.setString(10, cp.getHistorico());
                 psins.setString(11, cp.getTipo());
                 psins.setString(12, cp.getIdcontrato());
                 psins.setString(13, cp.getBanco());
                 psins.setString(14, cp.getVendedor());
                 psins.setString(15, cp.getParcela());
                 psins.setString(16, cp.getJuros());
                 psins.setString(17, cp.getDesconto());
                 psins.setString(18, cp.getSaldo());
                 psins.setString(19, cp.getObservacao());
                 psins.setString(20, cp.getTipofinanceiro());
                 psins.setString(21, cp.getSubtipofinanceiro());
                 psins.setString(22, cp.getNumboleto());
                 psins.setString(23, cp.getQntParcelas());
                 psins.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro para inserir contas a pagar/receber :( \n"+ex.getMessage());
        }
    }
    public void excluir(String titulo){
        String sql="delete from tcontas_a_receber_pagar where id=?;";
        PreparedStatement ps = conexao.getPreparedStatement(sql);
        try {
            ps.setString(1, titulo);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!!!");
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void alterar(CadContasRecPagar cp){
        String sql="update tcontas_a_receber_pagar  tc set\n" +
                    " tc.id_parceiro=?,\n" +
                    " tc.data_alterado=current_date,\n" +
                    " tc.pagar_receber=?,\n" +
                    " tc.data_emissao=?,\n" +
                    " tc.data_vencimento=?,\n" +
                    " tc.estado=?,\n" +
                    " tc.tipo_titulo=?,\n" +
                    " tc.id_conta=?,\n" +
                    " tc.id_historico=?,\n" +
                    " tc.valor=?,\n" +
                    " tc.id_banco=?,\n" +
                    " tc.id_vendedor=?,\n" +
                    " tc.juros=?,\n" +
                    " tc.desconto=?,\n" +
                    " tc.valor_total=?,\n" +
                    " tc.observacao=?,tc.id_tipo_financeiro=?,id_subtipo_financeiro=?,tc.numero_documento=? where tc.id=?;";
        try {
                PreparedStatement pd = conexao.getPreparedStatement(sql);
                pd.setString(1,cp.getParceiro());
                pd.setString(2, cp.getTipo());
                pd.setDate(3, cp.getEmisao());
                pd.setDate(4, cp.getVencimento());
                pd.setString(5, cp.getEstadotitulo());
                pd.setString(6, cp.getTipo_titulo());
                pd.setString(7, cp.getConta());
                pd.setString(8, cp.getHistorico());
                pd.setString(9, cp.getValor());
                pd.setString(10, cp.getBanco());
                pd.setString(11, cp.getVendedor());
                pd.setString(12, cp.getJuros());
                pd.setString(13, cp.getDesconto());
                pd.setString(14, cp.getSaldo());
                pd.setString(15, cp.getObservacao());
                pd.setString(16, cp.getTipofinanceiro());
                pd.setString(17, cp.getSubtipofinanceiro());
                pd.setString(18, cp.getNumero());
                pd.setString(19, cp.getIdmovto());
                pd.executeUpdate();
                pd.close();
                JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!!!");
                
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro ao atualizar registros \n" +ex.getMessage());
        }
        
    
    }
    public void pesquisaRegistroAlterar(CadContasRecPagar cc, String idperceiro){
         try {
                String sqlpesquisa="select tc.id_parceiro,\n" +
                                    "       tc.estado,\n" +
                                    "       tc.data_emissao,\n" +
                                    "       tc.data_vencimento,\n" +
                                    "       tc.tipo_titulo,\n" +
                                    "       tc.id_conta,\n" +
                                    "       tc.id_historico,\n" +
                                    "       tc.valor,\n" +
                                    "       tc.pagar_receber,\n" +
                                    "       th.historico,\n" +
                                    "       tt.nome_conta,\n" +
                                    "       tp.descricao,\n" +
                                    "       tf.descricao,\n"
                                  + "       tc.id, \n"
                        + "                 tc.desconto, \n "
                        + "                 tc.juros, \n"
                        + "                 tc.valor_total,tc.observacao,tc.id_tipo_financeiro,tc.id_subtipo_financeiro, \n" 
                        +"                  tn.descricao_movimento, tm.descricao_movimento,tc.numero_documento,tc.NUMERO_PARCELAS, tc.parcela \n    "+
                                    "        from\n" +
                                    "     tcontas_a_receber_pagar tc\n" +
                                    "     join thistorico th  on tc.id_historico=th.id\n" +
                                    "     join tconta tt on tc.id_conta=tt.id_conta\n" +
                                    "     join ttiptitulos tp on tc.tipo_titulo=tp.id\n" +
                                    "     join ttipfinanceiro tf on tc.pagar_receber=tf.id\n" +
                                    "     join ttipo_movimento tn on tn.id_tipo=tc.id_tipo_financeiro\n"
                        + "               join ttipo_movimento tm on tm.id_tipo=tc.id_subtipo_financeiro where tc.id=?";
                PreparedStatement ps= conexao.getPreparedStatementResult(sqlpesquisa);
                ps.setString(1, idperceiro);
                ResultSet rs = ps.executeQuery();
                rs.first();
                cc.setParceiro(rs.getString(1));
                cc.setEstadotitulo(rs.getString(2));
                cc.setEmisao(rs.getDate(3));
                cc.setVencimento(rs.getDate(4));
                cc.setTipo_titulo(rs.getString(5)+"- "+ rs.getString(12));
                cc.setConta(rs.getString(6)+"- "+rs.getString(11));
                cc.setHistorico(rs.getString(7)+"- "+rs.getString(10));
                cc.setValor(rs.getString(8));
                cc.setTipo(rs.getString(9));
                cc.setIdmovto(rs.getString(14));
                cc.setDesconto(rs.getString(15));
                cc.setJuros(rs.getString(16));
                cc.setSaldo(rs.getString(17));
                cc.setObservacao(rs.getString(18));
                cc.setTipofinanceiro(rs.getString(19)+"- "+rs.getString(21));
                cc.setSubtipofinanceiro(rs.getString(20)+"- "+rs.getString(22));
                cc.setNumero(rs.getString(23));
                cc.setQntParcelas(rs.getString("NUMERO_PARCELAS"));
                cc.setParcela(rs.getString("parcela"));
                rs.close();
                ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Para Buscar Dados!!!\n"+ex.getMessage());
        }
    
    }
    public void baixarTitulo(String idmovi,String vlpag){
        try {
                String sql ="update tcontas_a_receber_pagar tc set tc.valor_pago=?, tc.data_pagamento=current_date,\n" +
                    "tc.estado='6' where tc.id='"+idmovi+"'";
                PreparedStatement ps = conexao.getPreparedStatement(sql);
                ps.setString(1, vlpag);
                ps.executeUpdate();
                ps.close();
                
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao atualizar registro dos titulos a baixar:( \n" +ex.getMessage());
        }
        
    }
    public static List tipoTitulo(){
         List <String> listapag = new ArrayList<String>();
        try {
                String sqlpegafin="select * from ttiptitulos";
                PreparedStatement psfin= conexao.getPreparedStatement(sqlpegafin);
                ResultSet rsfin= psfin.executeQuery();
                while(rsfin.next()){
                    listapag.add(rsfin.getString(1)+"- "+ rsfin.getString(2));
                }
                rsfin.close();
                psfin.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listapag;
    }
    public static List banco(){
         List <String> listapag = new ArrayList<String>();
        try {
                String sqlpegafin="select * from tbanco";
                PreparedStatement psfin= conexao.getPreparedStatement(sqlpegafin);
                ResultSet rsfin= psfin.executeQuery();
                while(rsfin.next()){
                    listapag.add(rsfin.getString(1)+"- "+ rsfin.getString(2));
                }
                rsfin.close();
                psfin.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listapag;
    }
    public static List vendedor(){
         List <String> listapag = new ArrayList<String>();
        try {
                String sqlpegafin="select id, nome from tfuncionarios";
                PreparedStatement psfin= conexao.getPreparedStatement(sqlpegafin);
                ResultSet rsfin= psfin.executeQuery();
                while(rsfin.next()){
                    listapag.add(rsfin.getString(1)+"- "+ rsfin.getString(2));
                }
                rsfin.close();
                psfin.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listapag;
    }
    public static List conta(){
         List <String> listapag = new ArrayList<String>();
        try {
                String sqlpegafin="select id_conta,nome_conta from tconta where tipo='0'";
                PreparedStatement psfin= conexao.getPreparedStatement(sqlpegafin);
                ResultSet rsfin= psfin.executeQuery();
                while(rsfin.next()){
                    listapag.add(rsfin.getString(1)+"- "+ rsfin.getString(2));
                }
                rsfin.close();
                psfin.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listapag;
    }
    public static List historico(){
         List <String> listapag = new ArrayList<String>();
        try {
                String sqlpegafin="select * from thistorico";
                PreparedStatement psfin= conexao.getPreparedStatement(sqlpegafin);
                ResultSet rsfin= psfin.executeQuery();
                while(rsfin.next()){
                    listapag.add(rsfin.getString(1)+"- "+ rsfin.getString(2));
                }
                rsfin.close();
                psfin.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listapag;
    }
    public static List estadoTitulo(){
         List <String> listaesttitu = new ArrayList<String>();
        try {
                String sqlpegafin="select * from testado_operacoes where id >3";
                PreparedStatement psfin= conexao.getPreparedStatement(sqlpegafin);
                ResultSet rsfin= psfin.executeQuery();
                while(rsfin.next()){
                    listaesttitu.add(rsfin.getString(1)+"- "+ rsfin.getString(2));
                }
                rsfin.close();
                psfin.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaesttitu;
    }
    public static List estadoTituloParaDoc(){
         List <String> listaesttitu = new ArrayList<String>();
        try {
                String sqlpegafin="select * from testado_operacoes where id <=3";
                PreparedStatement psfin= conexao.getPreparedStatement(sqlpegafin);
                ResultSet rsfin= psfin.executeQuery();
                while(rsfin.next()){
                    listaesttitu.add(rsfin.getString(1)+"- "+ rsfin.getString(2));
                }
                rsfin.close();
                psfin.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaesttitu;
    }
    public void insereAltera(CadContasRecPagar cp){
        try {
                 String sql=" update or insert into tcontas_a_receber_pagar (id, id_movimento, id_parceiro,data,valor, numero_documento,\n" +
                    "data_emissao,data_vencimento,estado,tipo_titulo,id_conta,id_historico,pagar_receber,id_contrato,id_banco,id_vendedor,"
                         + "parcela,juros,desconto,valor_total,id_tipo_financeiro,id_subtipo_financeiro,numero_parcelas)\n" +
                    "values (gen_id(GEN_TCONTAS_A_RECEBER_PAGAR_ID,1),?,?,current_date,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) matching(id_movimento,parcela);";
                 PreparedStatement psins= conexao.getPreparedStatement(sql);
                 psins.setString(1, cp.getIdmovto());
                 psins.setString(2, cp.getParceiro());
                 psins.setString(3, cp.getValor());
                 psins.setString(4, cp.getNumero());
                 psins.setDate(5, cp.getEmisao());
                 psins.setDate(6, cp.getVencimento());
                 psins.setString(7, cp.getEstadotitulo());
                 psins.setString(8, cp.getTipo_titulo());
                 psins.setString(9, cp.getConta());
                 psins.setString(10, cp.getHistorico());
                 psins.setString(11, cp.getTipo());
                 psins.setString(12, cp.getIdcontrato());
                 psins.setString(13, cp.getBanco());
                 psins.setString(14, cp.getVendedor());
                 psins.setString(15, cp.getParcela());
                 psins.setString(16, cp.getJuros());
                 psins.setString(17, cp.getDesconto());
                 psins.setString(18, cp.getSaldo());
                 psins.setString(19, cp.getTipofinanceiro());
                 psins.setString(20, cp.getSubtipofinanceiro());
                 psins.setString(21, cp.getParcela());
                 psins.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro para inserir contas a pagar/receber :( \n"+ex.getMessage());
        }
    }
    public int retornaUltimoBoleto(String tipotitulo){
       int ret=0;
        try {
            String sql="select tc.ultimo_boleto from tconfig_boleto tc\n" +
                    "join ttiptitulos  tp on tc.idconfig=tp.config_boleto\n" +
                    "where tp.id=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, tipotitulo);
            ResultSet rs= ps.executeQuery();
            rs.first();
            ret=rs.getInt(1);
            rs.close();
            ps.close();
            String sql1="update tconfig_boleto tc set tc.ultimo_boleto=?\n" +
                "where tc.idconfig=(select tp.config_boleto from\n" +
                "ttiptitulos tp where tp.id=?)";
            PreparedStatement ps1 = conexao.getPreparedStatement(sql1);
            int novo=ret;
            novo++;
            ps1.setInt(1, novo);
            ps1.setString(2, tipotitulo);
            ps1.executeUpdate();
            ps1.close();
            
        } catch (Exception ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

     public Boolean verificaConfigBoleto(String tipotitulo){
       Boolean ret=false;
         try {
            String sql="select tc.ultimo_boleto from tconfig_boleto tc\n" +
                    "join ttiptitulos  tp on tc.idconfig=tp.config_boleto\n" +
                    "where tp.id=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, tipotitulo);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                ret=true;
            }else{
                ret=false;
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  ret;
     }

}
