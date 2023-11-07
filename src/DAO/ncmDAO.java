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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Mk Solucoes
 */
public class ncmDAO {
    
    public void inserirNcmPorImportacao(String cod,String descricao, String impNacional,String impImportado,String impEstadual,String impMunicipal,
            String inicio,String fim){
        try {
            String sql="UPDATE OR INSERT INTO TNCM (COD_NCM, DESCRICAO, UNIDADE, FCP, CEST, INIC_VIGENCIA, FIM_VIGENCIA, FEDERALNACIONAL, FEDERALIMPORTADO, ESTADUAL, MUNICIPAL)\n" +
                    "                    VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
                    "                  MATCHING (COD_NCM);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            if(cod.length()<8){
                cod=StringUtils.leftPad(cod, 8,"0");
            }
            ps.setString(1, cod);
            ps.setString(2, descricao);
            ps.setString(3, "");
            ps.setString(4, "");
            ps.setString(5, "");
            ps.setDate(6, clsaux.retornaData(inicio));
            ps.setDate(7, clsaux.retornaData(fim));
            ps.setString(8, impNacional);
            ps.setString(9, impImportado);
            ps.setString(10, impEstadual);
            ps.setString(11, impMunicipal);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.gravaSemMensagem(ex.getMessage());
            Logger.getLogger(ncmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }

    public static  String retornaNcmValido(String cod){
        String ret="Ncm Invalido";
        try {
            String sql="select * from tncm tn where tn.cod_ncm=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ret=rs.getString(2);
            }
        } catch (SQLException ex) {
            ret="Ncm Invalido";
            Logs.gravarLog.gravaSemMensagem(ex.getMessage());
            Logger.getLogger(ncmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

}
