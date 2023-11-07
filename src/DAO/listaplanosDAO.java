/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Logs.gravarLog;
import model.clsConfig;
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
 * @author Lucas
 */
public class listaplanosDAO {
     public static List listaplanos(){
        List <String> listCest = new ArrayList<String>();
        try{
            String sqlpegacest="select desc_plano,id_plano from tplanos_clube;";
            PreparedStatement pscest = conexao.getPreparedStatement(sqlpegacest);
            ResultSet rscest = pscest.executeQuery();
            while(rscest.next()){
                listCest.add(rscest.getString(2)+"-"+rscest.getString(1));
            }}catch(SQLException errr){
                 JOptionPane.showMessageDialog(null, errr);
             }
        return listCest;
    }
     public static List listafinalizadora(){
          List <String> listfin = new ArrayList<String>();
        try{
            String sqlpegacest="select descricao from tfinalizadora where retaguarda='S';";
            PreparedStatement pscest = conexao.getPreparedStatement(sqlpegacest);
            ResultSet rscest = pscest.executeQuery();
            while(rscest.next()){
                listfin.add(rscest.getString(1));
            }}catch(SQLException errr){
                 JOptionPane.showMessageDialog(null, errr);
             }
        return listfin;
    }     
     public static ArrayList listaAtiradores(String dado){
         ArrayList <String> listatr= new ArrayList<String>();
         String sqlbusca=null;
         if (dado.equals("0")){
             if (clsConfig.localizaporcr.equals("S")){
                sqlbusca="select a.razao_social,a.cr\n" +
                                    "from tparceiros  a where a.excluido='N' and  a.cr<>''\n" +
                                    "order by a.razao_social";
             } else{
                  sqlbusca="select a.razao_social,a.idparceiro\n" +
                                    "from tparceiros  a where a.excluido='N'\n" +
                                    "order by a.razao_social";
             }
         }else {
             if (clsConfig.localizaporcr.equals("S")){
                 sqlbusca="select a.razao_social,a.cr\n" +
                                    "from tparceiros  a where a.cr='"+dado+"' and a.excluido='N' and  a.cr<>''\n" +
                                    "order by a.razao_social";
             }else{
                sqlbusca="select a.razao_social,a.idparceiro\n" +
                                    "from tparceiros  a where a.idparceiro='"+dado+"' and a.excluido='N'\n" +
                                    "order by a.razao_social";
             }
         }
         
           try {
                 
                 PreparedStatement psst= conexao.getPreparedStatement(sqlbusca);
                 ResultSet rsst = psst.executeQuery();
                 while (rsst.next()){
                     listatr.add(rsst.getString(1)+"-"+rsst.getString(2));
                 }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "erro para bscar dados dos atiradores \n\n"+ex.getMessage());
             gravarLog.main(ex.getMessage().toString());
             Logger.getLogger(listaplanosDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return listatr;     
     }
     public static Double retornaPrecoPorCategoria(String idpro,String idcat){
         Double valor=0.00;
         try {
             String sql="select * from tcat_precos tc where tc.idprod=? and tc.id_categoria=?";
             PreparedStatement ps = conexao.getPreparedStatement(sql);
             ps.setString(1, idpro);
             ps.setString(2, idcat);
             ResultSet rs = ps.executeQuery();
             if(rs.next()){
                 valor=rs.getDouble(3);
             }
             rs.close();
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Não Foi Possivel Localizar O Preço Da Categoria!!!");
             Logger.getLogger(listaplanosDAO.class.getName()).log(Level.SEVERE, null, ex);
             valor=0.00;
         }
         return  valor;
     }
}
    

