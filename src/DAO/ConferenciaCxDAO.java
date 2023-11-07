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
import javax.swing.JOptionPane;
import model.clsPagamentos;

/**
 *
 * @author Lucas
 */
public class ConferenciaCxDAO {
    public static void insValorConferido(String valor, String caixa){
        try {
        String sqlinsvalor="insert into tmov_conta(id_movimentacao, id_conta, descricao_movimentacao,entrada,"
                + "tipo_mov,subtipo_mov,data,hora,tip_finalizadora,observacao,id_parceiro,estado) values (gen_id(gen_tmov_conta_id,1),?,?,?,?,?,current_date, current_time,?,?,0,2);";
        PreparedStatement psinsvalor= conexao.getPreparedStatement(sqlinsvalor);
        psinsvalor.setString(1, "1");
        psinsvalor.setString(2, "MOVIMENTACAO REFERENTE A ENTRADA DE CONFERENCIA DE CAIXA");
        psinsvalor.setString(3, valor);
        psinsvalor.setString(4, "1");
        psinsvalor.setString(5, "2");
        psinsvalor.setString(6, "1");
        psinsvalor.setString(7, "Valores referente a conferencia de caixa "+caixa);
        psinsvalor.executeUpdate();
        psinsvalor.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConferenciaCxDAO.class.getName()).log(Level.SEVERE, null, ex);

            
        }
    }
    public static void insConferecia(String idc, String vlap, String vldg, String vlcg,String idfin){
    /*função para gravar no banco a conferencia do caixa*/
    try {
        String sqlisn="insert into tconferencia_cx (id_caixa,valor_apurado,valor_digitado,valor_conferido,\n" +
                            "data_conferencia, hr_conferencia,estado, id_finalizadora) values (?,?,?,?,current_date,current_time,'conferido',?)\n" ;
        String sqlAtualizasttsCx="update tcaixa_pdv set conferido='Sim' where id_caixa='"+idc+"';";
        PreparedStatement psconf= conexao.getPreparedStatement(sqlisn);
        psconf.setString(1, idc);
        psconf.setString(2, vlap);
        psconf.setString(3, vldg);
        psconf.setString(4, vlcg);
        psconf.setString(5, idfin);
        psconf.executeUpdate();
        psconf.close();
        PreparedStatement psatcx=conexao.getPreparedStatement(sqlAtualizasttsCx);
        psatcx.executeUpdate();
        psatcx.close();
        
    }catch (SQLException er){
        Logger.getLogger(ConferenciaCxDAO.class.getName()).log(Level.SEVERE, null, er);
        JOptionPane.showMessageDialog(null,"Erro ao inserir dados da conferencia"+er.getMessage());
    }
    }
    public static List<clsPagamentos> retornaDadosGerarTitulos(String idfinalizadora,String idcaixa){
         List<clsPagamentos> lista=new ArrayList<>();
        try {
            String sql="select tp.id_pag,\n" +
                    "        tp.id_movimento,\n" +
                    "        tp.valor,tp.condicao ,\n" +
                    "        tp.id_finalizadora ,tf.descricao,tp.troco \n" +
                    " from tpagamentos_pdv  tp\n" +
                    " left join tfinalizadora tf on tp.id_finalizadora=tf.id_finalizdora \n"
                    + " where tp.id_finalizadora=? and tp.id_caixa=? and tp.estado='2'";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idfinalizadora);
            ps.setString(2, idcaixa);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                clsPagamentos pg= new clsPagamentos();
                pg.setMvto(rs.getString(2));
                pg.setValor(rs.getString(3));
                pg.setCondicao(rs.getString(4));
                pg.setIdfinalizadora(rs.getString(5));
                pg.setIdLancamento(rs.getString(1));
                pg.setDescricao(rs.getString(6));
                pg.setTroco(rs.getString(7));
                lista.add(pg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConferenciaCxDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
    }

    public void corrigeDadosFinalizadoraVenda(String id,String finalizadora){
        try {
            String sql="update tpagamentos_pdv tp set tp.id_fin_old=tp.id_finalizadora, tp.id_finalizadora=? where tp.id_pag=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, finalizadora);
            ps.setString(2, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConferenciaCxDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
        
    }
}
