
package DAO;

import classes.clsaux;
import model.CadDocMovConta;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class MovimentoContaDAO {
    public void inserir(CadDocMovConta cadmv){
        try {
            String sqlinserereg="insert into tmov_conta (id_movimentacao,id_conta,descricao_movimentacao,entrada,observacao,\n" +
                            "tipo_mov,subtipo_mov,tip_finalizadora,data,saida,hora,id_movto,parcela,id_parceiro,estado) values (gen_id(gen_tmov_conta_id,1),\n" +
                            "?,?,?,?,?,?,?,?,?, current_time,?,?,?,'2')";
            PreparedStatement psins= conexao.getPreparedStatement(sqlinserereg);
            psins.setInt(1, Integer.parseInt(cadmv.getIdconta()));
            psins.setString(2, cadmv.getDesc_mov());
            psins.setString(3, cadmv.getEntrada());
            psins.setString(4, cadmv.getObservacao());
            psins.setInt(5, Integer.parseInt(cadmv.getTipo_mov()));
            psins.setInt(6, Integer.parseInt(cadmv.getSubtipo_mov()));
            psins.setInt(7, Integer.parseInt(cadmv.getIdfinalizadora()));
            java.util.Date dt =cadmv.getData_lancamento();
            java.sql.Date dts = new java.sql.Date(dt.getTime());
            psins.setDate(8, dts);
            psins.setString(9, cadmv.getSaida());
            psins.setString(10, cadmv.getIdmov());
            psins.setString(11, cadmv.getParcela());
            psins.setString(12, cadmv.getIdparceiro());
            psins.executeUpdate();
            psins.close();
            //JOptionPane.showMessageDialog(null, "Registro Gravado com sucesso :)");
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir registro"+ex.getMessage());
        }
        
    } 
    public void inserirAlterar(CadDocMovConta cadmv){
    try {
            String sqlinserereg="update or insert into tmov_conta (id_movimentacao,id_conta,descricao_movimentacao,entrada,observacao,\n" +
                            "tipo_mov,subtipo_mov,tip_finalizadora,data,saida,hora,id_movto,parcela,id_parceiro,estado) values (gen_id(gen_tmov_conta_id,1),\n" +
                            "?,?,?,?,?,?,?,?,?, current_time,?,?,?,'2') matching(id_movto)";
            PreparedStatement psins= conexao.getPreparedStatement(sqlinserereg);
            psins.setInt(1, Integer.parseInt(cadmv.getIdconta()));
            psins.setString(2, cadmv.getDesc_mov());
            psins.setString(3, cadmv.getEntrada());
            psins.setString(4, cadmv.getObservacao());
            psins.setInt(5, Integer.parseInt(cadmv.getTipo_mov()));
            psins.setInt(6, Integer.parseInt(cadmv.getSubtipo_mov()));
            psins.setInt(7, Integer.parseInt(cadmv.getIdfinalizadora()));
            java.util.Date dt =cadmv.getData_lancamento();
            java.sql.Date dts = new java.sql.Date(dt.getTime());
            psins.setDate(8, dts);
            psins.setString(9, cadmv.getSaida());
            psins.setString(10, cadmv.getIdmov());
            psins.setString(11, cadmv.getParcela());
            psins.setString(12, cadmv.getIdparceiro());
            psins.executeUpdate();
            psins.close();
            JOptionPane.showMessageDialog(null, "Registro Gravado com sucesso :)");
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir registro"+ex.getMessage());
        }
    
    
    }
    
    
    public void alterar(CadDocMovConta cadmv){
        try {
            String sql="update tmov_conta tm set tm.id_conta=?, tm.entrada=?,\n" +
                    "tm.saida=?, tm.observacao=?, tm.tipo_mov=?, tm.subtipo_mov=?, tm.tip_finalizadora=?,\n" +
                    "tm.data=?, tm.data_alterado=current_date, tm.hora_alterado= current_time, tm.id_parceiro=?\n" +
                    "where tm.id_movimentacao=?";
            PreparedStatement ps= conexao.getPreparedStatement(sql);
            ps.setString(1, cadmv.getIdconta());
            ps.setString(2, cadmv.getEntrada());
            ps.setString(3, cadmv.getSaida());
            ps.setString(4, cadmv.getObservacao());
            ps.setString(5, cadmv.getTipo_mov());
            ps.setString(6, cadmv.getSubtipo_mov());
            ps.setString(7, cadmv.getIdfinalizadora());
            ps.setDate(8, (Date) cadmv.getData_lancamento());
            ps.setString(9, cadmv.getIdparceiro());
            ps.setString(10, cadmv.getIddocumento());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir registro"+ex.getMessage());
        }
            
    
    }
    public void deletar(String idmovto,String tipo){
        /*tipo de movimento 1 deleta pelo crud fluxo de caixa
          tipo de movimento 2 deleta pelo id do movimento fornecido pelo cadastro de documentos fiscais  
        */
        try {
            String sql=null;
            if (tipo=="1"){
                sql="update tmov_conta set estado='3' where id_movimentacao='"+idmovto+"'";
            }else if(tipo=="2"){
                sql="update tmov_conta set estado='3' where id_movto='"+idmovto+"'";
            }
            PreparedStatement psdel= conexao.getPreparedStatement(sql);
            psdel.executeUpdate();
            psdel.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir movimento :( \n " +ex.getMessage());
        }
        
    }
    public void inserirPorRecebimentoTitulo(int idconta,String tipo, String subtip, String valor,String finalizadora,String direcao,String idparce,String texto,String jr,String mt,String obs,
            String dtpag,String vendedor){
       try {
        String sql="insert into tmov_conta (id_movimentacao,id_conta,descricao_movimentacao,entrada,observacao,\n" +
                            "tipo_mov,subtipo_mov,tip_finalizadora,data,saida,hora,id_parceiro,estado,juros,multa,vendedor) values (gen_id(gen_tmov_conta_id,1),\n" +
                            "?,?,?,?,?,?,?,?,?,current_time,?,2,?,?,?);";
        PreparedStatement ps = conexao.getPreparedStatement(sql);
        ps.setInt(1, idconta);
        ps.setString(2, texto);
        if(direcao=="E"){
            ps.setString(3, valor);
            ps.setString(9, "0.00");
        }if (direcao=="S"){
            ps.setString(3, "0.00");
            ps.setString(9, valor);
        }
        ps.setString(4, obs);
        ps.setString(5, tipo);
        ps.setString(6, subtip);
        ps.setString(7, finalizadora);
        ps.setDate(8, clsaux.retornaData(dtpag));
        ps.setString(10, idparce);
        ps.setString(11, jr);
        ps.setString(12, mt);
        ps.setString(13, vendedor);
        ps.executeUpdate();
        ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados financeiro \n" +ex.getMessage());
        }
        
    }
    public static List listaconta(){
        List <String> listacont = new ArrayList<String>();
        try {
            String sqlpegaconta="select id_conta,nome_conta from tconta where tipo='0'";
            PreparedStatement pspc = conexao.getPreparedStatement(sqlpegaconta);
            ResultSet rspc= pspc.executeQuery();
            while (rspc.next()){
                listacont.add(rspc.getString(1)+"- "+rspc.getString(2));
            }
            rspc.close();
            pspc.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listacont;
        
    }
    public static List listatipo(){
        List <String> listatip = new ArrayList<String>();
        try {
                String sqlpegatipo="SELECT id_tipo,descricao_movimento FROM ttipo_movimento WHERE CATEGORIA='T'";
                PreparedStatement pstp= conexao.getPreparedStatement(sqlpegatipo);
                ResultSet rstp= pstp.executeQuery();
                while(rstp.next()){
                    listatip.add(rstp.getString(1)+"- "+ rstp.getString(2));
                }
                rstp.close();
                pstp.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listatip;
    }
    public static List listasubgrup(String id){
        List <String> listasgrp= new ArrayList<String>();
        try {
            String sql="SELECT id_tipo,descricao_movimento FROM ttipo_movimento WHERE CATEGORIA='S'\n" +
                    "and tip_referente='"+id+"'";
            PreparedStatement pssg= conexao.getPreparedStatement(sql);
            ResultSet rssg = pssg.executeQuery();
            while(rssg.next()){
                listasgrp.add(rssg.getString(1)+"- "+rssg.getString(2));
            }
            rssg.close();
            pssg.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listasgrp;
    }
    public static List listapagamento(){
         List <String> listapag = new ArrayList<String>();
        try {
                String sqlpegafin="select id_finalizdora,descricao from tfinalizadora";
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
    public static String listaparceiro(String idpar){
        String sqlbuscaparceiro="select razao_social from tparceiros where idparceiro='"+idpar+"'";
        String retorno=null;
        try {
            PreparedStatement pspar= conexao.getPreparedStatementResult(sqlbuscaparceiro);
            ResultSet rspar;
            rspar = pspar.executeQuery();
            rspar.first();
            retorno = rspar.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
        
    }
    public static List listasubtipotodos(){
        List <String> listasgrp= new ArrayList<String>();
        try {
            String sql="SELECT id_tipo,descricao_movimento FROM ttipo_movimento";
            PreparedStatement pssg= conexao.getPreparedStatement(sql);
            ResultSet rssg = pssg.executeQuery();
            while(rssg.next()){
                listasgrp.add(rssg.getString(1)+"- "+rssg.getString(2));
            }
            rssg.close();
            pssg.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listasgrp;
    }
    
}
