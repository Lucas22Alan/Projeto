/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.clsEmpresa;
import classes.clsaux;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class empresaDAO {
    public void insereAltera(clsEmpresa ce){
        try {
            String sql="UPDATE OR INSERT INTO TCAD_EMPRESA (ID_EMPRESA, CNPJ, IE, RAZAO_SOCIAL, FANTASIA, RUA, BAIRRO, NUMERO, COMPLEMENTO, EMAIL, FONE, CELULAR, CEP, UF, CIDADE,regime_tributacao)\n" +
                    "                            VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)\n" +
                    "                          MATCHING (ID_EMPRESA);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, ce.getId());
            ps.setString(2, ce.getCnpj());
            ps.setString(3, ce.getIe());
            ps.setString(4, ce.getRazao());
            ps.setString(5, ce.getFantasia());
            ps.setString(6, ce.getRua());
            ps.setString(7, ce.getBairro());
            ps.setString(8, ce.getNumero());
            ps.setString(9, ce.getComplemento());
            ps.setString(10, ce.getMail());
            ps.setString(11, ce.getFone());
            ps.setString(12, ce.getFone());
            ps.setString(13, ce.getCep());
            ps.setString(14, ce.getEstado());
            ps.setString(15, ce.getCidade());
            ps.setString(16, ce.getRegime());
            ps.executeUpdate();
            ps.close();
            } catch (SQLException ex) {
            Logger.getLogger(empresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    public void getDadosEmpresa(clsEmpresa cl){
        try {
            String slq="select * from tcad_empresa;";
            PreparedStatement ps = conexao.getPreparedStatementResult(slq);
            ResultSet rs = ps.executeQuery();
            rs.first();
            cl.setId(rs.getString(1));
            cl.setCnpj(rs.getString(2));
            cl.setIe(rs.getString(3));
            cl.setRazao(rs.getString(4));
            cl.setFantasia(rs.getString(5));
            cl.setRua(rs.getString(6));
            cl.setBairro(rs.getString(7));
            cl.setNumero(rs.getString(8));
            cl.setComplemento(rs.getString(9));
            cl.setMail(rs.getString(10));
            cl.setFone(rs.getString(12));
            cl.setCep(rs.getString(15));
            cl.setEstado(rs.getString(16));
            cl.setCidade(rs.getString(17));
            cl.setRegime(rs.getString("regime_tributacao"));
            rs.close();
            ps.close();
            } catch (SQLException ex) {
            Logger.getLogger(empresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void atualizaVencimentoSistema(int dias){
        try {
            String sql="update tconfig tc set tc.validade=?,tc.tentativas_val=0,ultima_consulta=current_date";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setDate(1, clsaux.retornaData(clsaux.calcularDataVencimento(dias)));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(empresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Para Atualizar Validade!!!\n"+ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
        }
    
    
    }
    public static int verificaTetativas(){
        int ret=0;
        try {
            String sql="select tentativas_val from tconfig";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            ret=rs.getInt(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(empresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Para Atualizar Validade!!!\n"+ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
        }
        return ret;
    }
    public static void increntaTentativa(int ten){
        try {
            String sql="update tconfig tc set tc.tentativas_val=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setInt(1, ten);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(empresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Para Atualizar Validade!!!\n"+ex.getMessage());
            Logs.gravarLog.main(ex.getMessage());
        }
    
    }
    public int verificaNfcePendente(){
        int ret=0;
        try {
            String sql="select count(tn.id_movimento) from tnota_fiscal tn\n" +
                    "where tn.cstat<100 or tn.cstat>150";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            if(rs.getInt(1)>0){
                ret=1;
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(empresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    
    
    }



}
