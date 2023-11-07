/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import Logs.gravarLog;
import classes.clsFechamentoCaixa;
import classes.clsFinalizadora;
import classes.clsSuprimentoSangria;
import conexoes.conexao;
import model.clsConfig;
import model.tfechamento_cego;

/**
 *
 * @author Lucas Rodrigues
 */
public class baseCaixaDAO {
    public Double consultaValorVenda(String pdv, String idcaixa){
       Double vendas=0.00;
        try {
            String sql="select sum(tm.total)from tmovimento tm where tm.id_caixa=? and tm.estado=2 and tm.numero_pdv=? and id_tipo=1";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idcaixa);
            ps.setString(2, pdv);
            ResultSet rs = ps.executeQuery();
            rs.first();
            vendas=rs.getDouble(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }
    public Double consultaValorSangria( String idcaixa){
        Double sangria=0.00;
        try {
            String sql="select sum (tm.valor_saida)from tmov_caixa tm where tm.id_caixa=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idcaixa);
            ResultSet rs = ps.executeQuery();
            rs.first();
            sangria=rs.getDouble(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sangria;
    }
    public Double consultaValorReforco( String idcaixa){
      Double refor=0.00;
        try {
            String sql="select sum (tm.valor_entrada)from tmov_caixa tm where tm.id_caixa=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idcaixa);
            ResultSet rs = ps.executeQuery();
            rs.first();
            refor=rs.getDouble(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return refor;
    }
    
    
    public void retirada(String caixa, Double valor, String obs){
        try {
                String sql="insert into tmov_caixa (id_movcx,id_caixa,id_finalizadora,valor_saida,entrada_saida,motivo,data_lancamento)"
                + "values (gen_id(gen_tmov_caixa_id,1),?,?,?,?,'"+obs+"',current_timestamp);";
                PreparedStatement ps = conexao.getPreparedStatement(sql);
                ps.setString(1, caixa);
                ps.setString(2, "1");
                ps.setDouble(3, valor);
                ps.setString(4, "S");
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Retirada concluida com sucesso!!!");
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro para inserir movimento \n"+ex);
        }
    }
    public void suprimento(String caixa, Double valor, String obs,String finalizadora,String tipo,String pdv){
        try {
                String inicial="S";
                //System.out.println(consultaValorVenda(clsConfig.numeropdv, caixa);
                if(consultaValorVenda(pdv, caixa)>0) inicial="N";
                String sql="insert into tmov_caixa (id_movcx,id_caixa,id_finalizadora,valor_entrada,entrada_saida,motivo,data_lancamento,inicial,tipo,valor_saida)"
                + "values (gen_id(gen_tmov_caixa_id,1),?,?,?,?,'"+obs+"',current_timestamp,?,?,'0.00');";
                PreparedStatement ps = conexao.getPreparedStatement(sql);
                ps.setString(1, caixa);
                ps.setString(2, finalizadora);
                ps.setDouble(3, valor);
                ps.setString(4, "E");
                ps.setString(5, inicial);
                ps.setString(6, tipo);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Suprimento concluida com sucesso!!!");
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro para inserir movimento \n"+ex);
        }
    }
    public List<clsFinalizadora> consVendas(String idcaixa){
        List <clsFinalizadora> cl= new ArrayList<>();
             
        try {
            String sql="select tp.id_finalizadora,tf.descricao, sum(tp.valor-tp.troco) from tpagamentos_pdv tp\n" +
                    "left join tfinalizadora tf on tp.id_finalizadora=tf.id_finalizdora\n" +
                    "left join tmovimento tm on tp.id_movimento=tm.id_mov"
                    + " where tp.estado=2 and tp.id_caixa=? and tm.estado='2'\n" +
                    "group by 1,2";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idcaixa);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
               clsFinalizadora cf= new clsFinalizadora();
               cf.setId(rs.getString(1));
               cf.setNome(rs.getString(2));
               cf.setValor(rs.getDouble(3));
               cl.add(cf);
            }
            System.out.println(cl.toArray());
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }
    public List<clsSuprimentoSangria> consSuprimento(String idcaixa,String tp){
        List <clsSuprimentoSangria> cl= new ArrayList<>();
             
        try {
            if(tp.equals("0")){
                String sql="select tp.id_finalizadora,tf.descricao, tp.valor_entrada,tp.motivo,tp.data_lancamento from tmov_caixa tp\n" +
    "                    left join tfinalizadora tf on tp.id_finalizadora=tf.id_finalizdora\n" +
    "                    where  tp.id_caixa=?\n" +
    "                    and tp.valor_entrada>0 and tp.inicial='N' and tp.tipo='0'";
                PreparedStatement ps = conexao.getPreparedStatement(sql);
                ps.setString(1, idcaixa);
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                   clsSuprimentoSangria cf= new clsSuprimentoSangria();
                   cf.setIdfinalizadora(rs.getString(1));
                   cf.setDescricao(rs.getString(2));
                   cf.setValor(rs.getDouble(3));
                   cf.setMotivo(rs.getString(4));
                   cf.setData(rs.getString(5));
                   cl.add(cf);
                }

            rs.close();
            ps.close();
            }else{
                 String sql="select tp.id_finalizadora,tf.descricao, sum(tp.valor_entrada) from tmov_caixa tp\n" +
"                    left join tfinalizadora tf on tp.id_finalizadora=tf.id_finalizdora\n" +
"                    where  tp.id_caixa=?\n" +
"                    and tp.valor_entrada>0 and tp.inicial='N'\n" +
"                    group by 1,2";
                PreparedStatement ps = conexao.getPreparedStatement(sql);
                ps.setString(1, idcaixa);
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                   clsSuprimentoSangria cf= new clsSuprimentoSangria();
                   cf.setIdfinalizadora(rs.getString(1));
                   cf.setDescricao(rs.getString(2));
                   cf.setValor(rs.getDouble(3));
                   cl.add(cf);
                }

            rs.close();
            ps.close();
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }
    public List<clsSuprimentoSangria> consSuprimentoOutrasOrigens(String idcaixa){
        List <clsSuprimentoSangria> cl= new ArrayList<>();
             
        try {
            String sql="select tp.id_finalizadora,tf.descricao, tp.valor_entrada,tp.motivo from tmov_caixa tp\n" +
"                    left join tfinalizadora tf on tp.id_finalizadora=tf.id_finalizdora\n" +
"                    where  tp.id_caixa=?\n" +
"                    and tp.valor_entrada>0 and tp.inicial='N' and tipo>0";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idcaixa);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
               clsSuprimentoSangria cf= new clsSuprimentoSangria();
               cf.setIdfinalizadora(rs.getString(1));
               cf.setDescricao(rs.getString(2));
               cf.setValor(rs.getDouble(3));
               cf.setMotivo(rs.getString(4));
               cl.add(cf);
            }
            System.out.println(cl.toArray());
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }
     public void consultaDadosAbertura(String id){
        try {
            String sql="select tp.data_abertura,tp.hr_abertura,tp.data_fechamento,tp.hr_fechamento,tp.operador_nome from tcaixa_pdv tp\n" +
                    "where tp.id_caixa=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, id);
            ResultSet rs= ps.executeQuery();
            rs.first();
            clsFechamentoCaixa.setDatabertura(rs.getString(1));
            clsFechamentoCaixa.setHraber(rs.getString(2));
            if(rs.getString(3)!=null){
                clsFechamentoCaixa.setDatafecha(rs.getString(3));
            }else{
                clsFechamentoCaixa.setDatafecha("");
            }
            if(rs.getString(4)!=null){
                clsFechamentoCaixa.setHrfecha(rs.getString(4));
            }else{
                clsFechamentoCaixa.setHrfecha("");
            }
            clsFechamentoCaixa.setOperador(rs.getString(5));
            
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<clsSuprimentoSangria> consSangria(String idcaixa){
        List <clsSuprimentoSangria> cl= new ArrayList<>();
             
        try {
            String sql="select tp.id_finalizadora,tf.descricao, tp.valor_saida,tp.motivo,tp.data_lancamento  from tmov_caixa tp\n" +
                        "left join tfinalizadora tf on tp.id_finalizadora=tf.id_finalizdora\n" +
                        "where  tp.id_caixa=?\n" +
                        "and tp.valor_saida>0";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idcaixa);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                clsSuprimentoSangria cf= new clsSuprimentoSangria();
               cf.setIdfinalizadora(rs.getString(1));
               cf.setDescricao(rs.getString(2));
               cf.setValor(rs.getDouble(3));
               cf.setMotivo(rs.getString(4));
               cf.setData(rs.getString(5));
               cl.add(cf);
            }
            System.out.println(cl.toArray());
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }
    public double retornaSaldoInicial(String idcaixa){
        Double valor=0.00;
        try {
            String sql="select tm.valor_entrada from tmov_caixa tm\n" +
                    "where tm.id_caixa=? and tm.inicial='S'";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idcaixa);
            ResultSet rs = ps.executeQuery();
           if(rs.next()){
               valor=rs.getDouble(1);
           }else{
               valor=0.00;
           }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            valor=0.00;
        }
        return valor;
    }
    public Double retornaValorVendaCancelada(String idcaixa){
            Double valor=0.00;
        try {
            String sql="select sum(tm.total)\n" +
                        "from tmovimento tm where tm.id_caixa=? and tm.estado=3";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, idcaixa);
            ResultSet rs = ps.executeQuery();
            rs.first();
            valor=rs.getDouble(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            valor=0.00;
        }
        return valor;
    
    }
    
    public void inserirValorFechamento(tfechamento_cego fecha){
        try {
            String sql="INSERT INTO TFECHAMENTO_CEGO (IDCAIXA, IDFINALIZADORA, NOMEFINALIZADORA, VALORINFORMADO, DATA, HORA)\n" +
                    "                      VALUES (?, ?, ?, ?, current_date, current_time);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, fecha.getIdcaixa());
            ps.setString(2, fecha.getIdfinalizadora());
            ps.setString(3, fecha.getNomefinalizadora());
            ps.setDouble(4, fecha.getValor());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            gravarLog.main(ex.getMessage());
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<tfechamento_cego> buscaRegistrosFechamento(String idcaixa){
        List<tfechamento_cego> lista = new ArrayList<>();
        try {
            String sql="select tc.idcaixa,tc.idfinalizadora,tc.nomefinalizadora ,sum(tc.valorinformado) from tfechamento_cego tc\n" +
                        "where tc.idcaixa=?\n" +
                        "group by 1,2,3";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idcaixa);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tfechamento_cego fecha= new tfechamento_cego();
                fecha.setIdcaixa(rs.getString(1));
                fecha.setIdfinalizadora(rs.getString(2));
                fecha.setNomefinalizadora(rs.getString(3));
                fecha.setValor(rs.getDouble(4));
                lista.add(fecha);
                
            }
           } catch (SQLException ex) {
            Logger.getLogger(baseCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
