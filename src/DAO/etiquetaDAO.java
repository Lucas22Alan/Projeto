/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Logs.gravarLog;
import model.clsEtiqueta;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mk Solucoes
 */
public class etiquetaDAO {
    public static clsEtiqueta retornaEtiqueta(clsEtiqueta etiqueta){
        try {
            String sql= "select * from tcad_etiqueta where id_etiqueta=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, etiqueta.getId());
            ResultSet rs = ps.executeQuery();
            rs.first();
            etiqueta.setId(rs.getString(1));
            etiqueta.setNome(rs.getString(2));
            etiqueta.setImpdesc(rs.getString(3));
            etiqueta.setImppreco(rs.getString(4));
            etiqueta.setImprodape(rs.getString(5));
            etiqueta.setImpprecopromocao(rs.getString(6));
            etiqueta.setImpbarra(rs.getString(7));
            etiqueta.setImpcabecalho(rs.getString(8));
            etiqueta.setImpperc(rs.getString(9));
            etiqueta.setNomefxml(rs.getString(10));
            etiqueta.setImpdireto(rs.getString(11));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(etiquetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return etiqueta;    
    }
    
    public Boolean gravaEtiqueta(clsEtiqueta etiqueta){
        Boolean res=false;
        try {
            String sql="UPDATE OR INSERT INTO TCAD_ETIQUETA (ID_ETIQUETA, NOME, IMP_DESC, IMP_PREC, IMP_RODAPE, IMP_PRECOFERTA, IMP_BARRAS, IMP_CABECALHO, IMP_QNTPERC,"
                    + " NOME_FXML, IMPRIMIR_DIRETO, COLUNAS)\n" +
                    "                             VALUES (?,?,?,?,?,?,?,?,?,?,?,?)\n" +
                    "                           MATCHING (ID_ETIQUETA);";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, etiqueta.getId());
            ps.setString(2, etiqueta.getNome());
            ps.setString(3, etiqueta.getImpdesc());
            ps.setString(4,etiqueta.getImppreco());
            ps.setString(5,etiqueta.getImprodape());
            ps.setString(6, etiqueta.getImpprecopromocao());
            ps.setString(7,etiqueta.getImpbarra());
            ps.setString(8,etiqueta.getImpcabecalho());
            ps.setString(9, "N");
            ps.setString(10, etiqueta.getNomefxml());
            ps.setString(11, "N");
            ps.setString(12, "1");
            ps.executeUpdate();
            ps.close();
            res=true;
        } catch (SQLException ex) {
            Logger.getLogger(etiquetaDAO.class.getName()).log(Level.SEVERE, null, ex);
            gravarLog.main(ex.getMessage());
        }
        return res;
    
    }
    public String geraIdEtiqueta(){
        String ret="0";
        try {
            String sql="select first 1 tc.id_etiqueta from tcad_etiqueta tc order by 1 desc";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            ret=String.valueOf(rs.getInt(1)+1);
        } catch (SQLException ex) {
            Logger.getLogger(etiquetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    public static List listaEtiquetas(){
        List <String> listatip = new ArrayList<String>();
        try {
                String sqlpegatipo="select  tc.id_etiqueta,tc.nome from tcad_etiqueta tc order by 1 asc";
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
    public void limpaMarcados(String barra){
        try {
            String sql="update tprodutos set imprime_etiqueta='N' where id=(select id_produto from tbarras where codigo_barras=?)";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, barra);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(etiquetaDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
    }

}
