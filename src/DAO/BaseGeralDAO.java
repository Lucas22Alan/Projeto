/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Logs.gravarLog;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mk Solucoes
 */
public class BaseGeralDAO {
    public String gerarIds(String generador){
        String ret="0";
        try {
            String sql="select gen_id("+generador+",1) from rdb$database;";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ret=rs.getString(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            gravarLog.main("Falha Ao Solicitar Id :"+ex.getMessage());
            Logger.getLogger(BaseGeralDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
        
    }
    
    public void correcaoCustoVendaZero(){
        try {
            String sql="update titens ti set ti.cust_unitario=(select tc.custo_atual from  tprecos tc\n" +
                    "where tc.id= ti.id_prod), ti.cust_total=ti.cust_unitario*ti.quantidade\n" +
                    "where ti.cust_unitario=0 and ti.id_mov in (\n" +
                    "select tm.id_mov from tmovimento tm where (tm.id_tipo=1 or tm.id_tipo=2 or tm.id_tipo=5))";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseGeralDAO.class.getName()).log(Level.SEVERE, null, ex);
              gravarLog.main(ex.toString());
        }
        
    }
    public void correcaoCustoCadastroUltimaCompra(){
        try {
            String sql="update tprecos tc set tc.custo_atual=(\n" +
                    "select first 1 ti.total/ti.quantidade from titens ti\n" +
                    "join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                    "where tm.id_tipo=3 and tm.estado=2 and ti.estado=2\n" +
                    " and ti.id_prod=tc.id order by ti.id_mov desc )\n" +
                    " where tc.custo_atual=0";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseGeralDAO.class.getName()).log(Level.SEVERE, null, ex);
            gravarLog.main(ex.toString());
        }
        
    }
}
