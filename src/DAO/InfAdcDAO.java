/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Cst;
import model.Unidades;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class InfAdcDAO {
    public  InfAdcDAO(){
    
    }
    
   public void Inserir(Unidades unid){
        try{
            String sqlinsereunidade="insert into tunidade(id, nome, unidade, fator)values (gen_id(gen_tunidade_id,1),?,?,?)";
            PreparedStatement psinsunidade=conexao.getPreparedStatement(sqlinsereunidade);
            psinsunidade.setString(1, unid.GetNome());
            psinsunidade.setString(2, unid.GetUnidade());
            psinsunidade.setString(3, unid.GetFator());
            psinsunidade.executeUpdate();
            psinsunidade.close();
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso!!!");
        
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, "erro na gravacao do cadastro de unidade\n"
                + err.getMessage());
        }
    }
   public void alterar(Unidades unid){
        try{
            String sqlinsereunidade="update tunidade tn set tn.nome=?,tn.unidade=?,tn.fator=? where tn.id=?";
            PreparedStatement psinsunidade=conexao.getPreparedStatement(sqlinsereunidade);
            psinsunidade.setString(1, unid.GetNome());
            psinsunidade.setString(2, unid.GetUnidade());
            psinsunidade.setString(3, unid.GetFator());
            psinsunidade.setString(4, unid.getId());
            psinsunidade.executeUpdate();
            psinsunidade.close();
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso!!!");
        
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, "erro na gravacao do cadastro de unidade\n"
                + err.getMessage());
        }
    }
   public void excluir(String id){
        try{
            String sqlinsereunidade="delete from tunidade tn where tn.id=?";
            PreparedStatement psinsunidade=conexao.getPreparedStatement(sqlinsereunidade);
            psinsunidade.setString(1, id);
            psinsunidade.executeUpdate();
            psinsunidade.close();
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso!!!");
        
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, "erro na gravacao do cadastro de unidade\n"
                + err.getMessage());
        }
    }
   public void InserirCst (Cst cst){
       try{
        String sqlinserecst="insert into tcad_cst (id_cst, descricao, regime) values (?,?,?)";
        PreparedStatement pscst=conexao.getPreparedStatement(sqlinserecst);
        pscst.setString(1, cst.GetCst());
        pscst.setString(2, cst.GetDescricao());
        pscst.setString(3, cst.GetRegime());
        pscst.executeUpdate();
        pscst.close();
        JOptionPane.showMessageDialog(null, "Registro Gravado com sucesso!!!");
   }catch (SQLException er){
        JOptionPane.showMessageDialog(null, "erro na gravacao do cadastro de situacao tributaria\n"
                + er.getMessage());

   }
   }
}
   
   

