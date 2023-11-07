/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.clsFinalizadora;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class listaDAO {
    public static List listatipo(String direcao){
        List <String> listatip = new ArrayList<String>();
        try {
                String sqlpegatipo="SELECT id_tipo,descricao_movimento FROM ttipo_movimento WHERE CATEGORIA='T'"
                        + " and direcao='"+direcao+"' ;";
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
    public static List listasubgrupGeral(){
        List <String> listasgrp= new ArrayList<String>();
        try {
            String sql="SELECT id_tipo,descricao_movimento FROM ttipo_movimento WHERE CATEGORIA='S'";
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
                String sqlpegafin="select id_finalizdora,descricao from tfinalizadora where retaguarda='S'";
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
     public static Double retornaTaxaFinalizadora(String id){
         Double taxa=0.00;
         try {
                String sqlpegafin="select taxa_adm from tfinalizadora where id_finalizdora='"+id+"'";
                PreparedStatement psfin= conexao.getPreparedStatement(sqlpegafin);
                ResultSet rsfin= psfin.executeQuery();
               if(rsfin.next()){
                    taxa=rsfin.getDouble(1);
                }
                rsfin.close();
                psfin.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return taxa;
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
    public static List listaTipoDocumento(){
         List <String> listatipdoc = new ArrayList<String>();
        try {
                String sqlpegatipo="select * from ttipo_documentos;";
                PreparedStatement pstp= conexao.getPreparedStatement(sqlpegatipo);
                ResultSet rstp= pstp.executeQuery();
                while(rstp.next()){
                    listatipdoc.add(rstp.getString(1)+"- "+ rstp.getString(2));
                }
                rstp.close();
                pstp.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listatipdoc;
    }
    public static List listaTipoDocumentoDirecao(String tipo){
         List <String> listatipdoc = new ArrayList<String>();
        try {
                String sqlpegatipo="select * from ttipo_documentos where direcao=?;";
                PreparedStatement pstp= conexao.getPreparedStatement(sqlpegatipo);
                pstp.setString(1, tipo);
                ResultSet rstp= pstp.executeQuery();
                while(rstp.next()){
                    listatipdoc.add(rstp.getString(1)+"- "+ rstp.getString(2));
                }
                rstp.close();
                pstp.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listatipdoc;
    }
   
    public static List listaCondicaoVenda(){
        List <String> listacondi = new ArrayList<String>();
        try {
                String sqlpegatipo="select id_condi,descricao from tcondicoes_venda;";
                PreparedStatement pstp= conexao.getPreparedStatement(sqlpegatipo);
                ResultSet rstp= pstp.executeQuery();
                while(rstp.next()){
                    listacondi.add(rstp.getString(1)+"- "+ rstp.getString(2));
                }
                rstp.close();
                pstp.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listacondi;
    
    }
    public static String[] listaPrazoCondicao(String idcondi){
        String [] prazo=null;
        try {
            String sql="select dados from tcondicoes_venda where id_condi=?;";
            PreparedStatement ps =conexao.getPreparedStatementResult(sql);
            ps.setString(1, idcondi);
            ResultSet rs = ps.executeQuery();
            rs.first();
            String resultado=rs.getString(1);
            prazo= resultado.split("-");
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(listaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException nu){
            JOptionPane.showMessageDialog(null, "Erro para buscar dados da parcela...\n" +nu.getMessage());
        }
        return prazo;
    }
    public static ArrayList listaProdutos(String tipo){
        ArrayList <String>ret= new ArrayList();
        try {
            String sql=null;
            if (tipo.equals("S")){
                sql="select tb.codigo_barras, tp.nomecurto from tprodutos tp\n" +
                        "join tbarras tb on tp.id=tb.id_produto\n" +
                        "where tp.tipo_produto='9'";
            } else if (tipo.equals("P")){
                sql="select tb.codigo_barras, tp.nomecurto from tprodutos tp\n" +
                        "join tbarras tb on tp.id=tb.id_produto\n" +
                        "where tp.tipo_produto='0'";
            } else {
                sql="select tb.codigo_barras, tp.nomecurto from tprodutos tp\n" +
                        "join tbarras tb on tp.id=tb.id_produto\n";
            }
            PreparedStatement ps =conexao.getPreparedStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                ret.add(rs.getString(2)+"- "+rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(listaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ret;
    }
    
}
