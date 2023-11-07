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
import model.CadContasRecPagar;

/**
 *
 * @author Mk Solucoes
 */
public class AvisosDAO {
    
    public List<String> retornaListaAniversarianteMes(){
          List<String> retorno=new ArrayList<>();
          String mes=clsaux.retornaMes().trim();
        switch (mes){
            case "Janeiro" : mes="01";
            break;
            case "janeiro" : mes="01";
            break;
            case "Fevereiro": mes ="02";
            break;
            case "fevereiro": mes ="02";
            break;
            case "Março": mes ="03";
            break;
            case "março": mes ="03";
            break;
            case "Abril": mes ="04";
            break;
             case "abril": mes ="04";
            break;
            case "Maio": mes= "05";
            break;
            case "maio": mes= "05";
            break;
            case "Junho": mes= "06";
            break;
             case "junho": mes= "06";
            break;
            case "Julho": mes= "07";
            break;
            case "julho": mes= "07";
            break;
            case "Agosto": mes ="08";
            break;
            case "agosto": mes ="08";
            break;
            case "Setembro": mes= "09";
            break;
            case "setembro": mes= "09";
            break;
            case "Outubro": mes= "10";
            break;
            case "outubro": mes= "10";
            break;
            case "Novembro": mes= "11";
            break;
            case "novembro": mes= "11";
            break;
            case "Dezembro": mes= "12";
            break;
            case "dezembro": mes= "12";
            break;
        }
        try {
           String sql= sql="select extract(DAY from data_nascimento) as dia,razao_social,fone,celular from tparceiros\n" +
                    "where extract(month from data_nascimento)=?";
            PreparedStatement pst= conexao.getPreparedStatement(sql);
            pst.setString(1, mes);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                retorno.add(rs.getString(1)+"-"+rs.getString(2));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(AvisosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    public List<CadContasRecPagar> retornaListaTitulosVencendoDia(String tipo){
       List<CadContasRecPagar> lista = new ArrayList<>();
        try {
            String sql="select tc.id,tp.razao_social,tc.valor_total,tc.data_vencimento from tcontas_a_receber_pagar tc\n" +
                    "left join tparceiros tp on tc.id_parceiro=tp.idparceiro\n" +
                    " where tc.data_vencimento=current_date and (tc.estado='4' or tc.estado='11') and tc.pagar_receber='"+tipo+"'";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CadContasRecPagar cad= new CadContasRecPagar();
                cad.setIdtitulo(rs.getString(1));
                cad.setRazaoparceiro(rs.getString(2));
                cad.setValortotal(rs.getString(3));
                cad.setVencimento(rs.getDate(4));
                lista.add(cad);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AvisosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return lista;
    }
}
