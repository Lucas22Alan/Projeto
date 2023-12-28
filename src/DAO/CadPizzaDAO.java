/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tcad_tam_pizza;
import model.Tdados_tamanho;

/**
 *
 * @author Mk Solucoes
 */
public class CadPizzaDAO {
        PreparedStatement ps;
        ResultSet rs;
    
    public boolean inserirTamanho(Tcad_tam_pizza cad){
        boolean ret=true;
        try {
            String sql="UPDATE OR INSERT INTO TCAD_TAM_PIZZA (IDTAMANHO, DESCRICAO, PRECO, BARRASORIG, DESCORIG, QNTPEDACOS, QNTSABORES)\n" +
"                              VALUES (?,?,?,?,?,?,?)\n" +
"                            MATCHING (IDTAMANHO);";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, cad.getIdtamanho());
            ps.setString(2, cad.getDescricao());
            ps.setDouble(3, cad.getPreco());
            ps.setString(4, cad.getBarrasorig());
            ps.setString(5, cad.getDescorig());
            ps.setString(6, cad.getQntpedaco());
            ps.setString(7, cad.getQntsabor());
            ps.executeUpdate();
            ps.close();
            sql="update tprodutos tp set tp.tem_pizza='S' where tp.id=(\n" +
                        "select tb.id_produto from tbarras tb where tb.codigo_barras=? )";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, cad.getBarrasorig());
                ps.executeUpdate();
                ps.close();
        } catch (SQLException ex) {
            ret=false;
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public List<Tcad_tam_pizza> retornaListaTamanho(){
          List<Tcad_tam_pizza> lista= new ArrayList<>();
            try {
                String sql="select * from TCAD_TAM_PIZZA";
                ps=conexao.getPreparedStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    Tcad_tam_pizza cad= new Tcad_tam_pizza();
                    cad.setBarrasorig(rs.getString(4));
                    cad.setDescorig(rs.getString(5));
                    cad.setDescricao(rs.getString(2));
                    cad.setIdtamanho(rs.getString(1));
                    cad.setPreco(rs.getDouble(3));
                    cad.setQntpedaco(rs.getString(6));
                    cad.setQntsabor(rs.getString(7));
                    lista.add(cad);
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
        
    }
    
    public Tcad_tam_pizza retornaCadTamanho(String id){
          Tcad_tam_pizza cad= new Tcad_tam_pizza();
            try {
                String sql="select * from TCAD_TAM_PIZZA where idtamanho="+id;
                ps=conexao.getPreparedStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()){
                    cad.setBarrasorig(rs.getString(4));
                    cad.setDescorig(rs.getString(5));
                    cad.setDescricao(rs.getString(2));
                    cad.setIdtamanho(rs.getString(1));
                    cad.setPreco(rs.getDouble(3));
                    cad.setQntpedaco(rs.getString(6));
                    cad.setQntsabor(rs.getString(7)) ;
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return cad;
        
    }
    
    public List<Tdados_tamanho> retornaItensTamanho(String idadc){
        List<Tdados_tamanho> lista= new ArrayList<>();
        try {
                String sql="select td.idtamanho,td.barrassabor,tp.id,tp.nomelongo,tp.unid_venda,td.preco,\n" +
                        "tg.nome,ts.nome,td.idcampanha,tc.nome from tdados_tamanho td\n" +
                        "left join tbarras tb on tb.codigo_barras=td.barrassabor\n" +
                        "left join tprodutos tp on tb.id_produto=tp.id\n" +
                        "left join tgrupos tg on tp.id_grupo=tg.id_grupo\n" +
                        "left join tsubgrupo ts on tp.id_subgrupo=ts.idsubgrupo\n" +
                        "left join tcad_campanha tc on td.idcampanha= tc.idcampanha where td.idtamanho=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, idadc);
                rs=ps.executeQuery();
                while(rs.next()){
                    Tdados_tamanho it= new Tdados_tamanho();
                    it.setIdtamanho(rs.getString(1));
                    it.setCodbarras(rs.getString(2));
                    it.setIdproduto(rs.getString(3));
                    it.setDescricao(rs.getString(4));
                    it.setUnidade(rs.getString(5));
                    it.setVenda(rs.getDouble(6));
                    it.setGrupo(rs.getString(7));
                    it.setSubgrupo(rs.getString(8));
                    it.setIdcampanha(rs.getInt(9));
                    it.setNomecampanha(rs.getString(10));
                    lista.add(it);
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
        
    }
    public void inserirItensRefTamanho(String adc,String barra,Double valor){
            try {
               
                String sql="UPDATE OR INSERT INTO tdados_tamanho (idtamanho, barrassabor,preco)\n" +
                        "                                     VALUES (?, ?,?)\n" +
                        "                                   MATCHING (idtamanho, barrassabor);";
                ps= conexao.getPreparedStatement(sql);
                ps.setString(1, adc);
                ps.setString(2, barra);
                ps.setDouble(3, valor);
                ps.executeUpdate();
                ps.close();
                sql="update tprodutos tp set tp.tem_pizza='S' where tp.id=(\n" +
                        "select tb.id_produto from tbarras tb where tb.codigo_barras=? )";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, barra);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void InserirItensPorGrupo(String id, String tipo,String idadc,Double valor){
            
        try {
                String sql="select tb.codigo_barras from tprodutos tp\n" +
                        "join tbarras tb on tb.id_produto=tp.id\n" +
                        "where tp.id_grupo=? and tp.excluido='N' and tp.ativo='S'";
                if(tipo.equals("S")){
                    sql="select tb.codigo_barras from tprodutos tp\n" +
                        "join tbarras tb on tb.id_produto=tp.id\n" +
                        "where tp.id_subgrupo=? and tp.excluido='N' and tp.ativo='S'";
                }
                PreparedStatement ps = conexao.getPreparedStatementResult(sql);
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    
                    this.inserirItensRefTamanho(idadc, rs.getString(1),valor);
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logs.gravarLog.main(ex.getMessage());
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void removeItemTamanho(String idadc,String barras){
            try {
                String sql="delete from tdados_tamanho td where td.idtamanho=? and td.barrassabor=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, idadc);
                ps.setString(2, barras);
                ps.executeUpdate();
                ps.close();
                sql="update tprodutos tp set tp.tem_pizza='N' where id=(\n" +
                    "select tb.id_produto from tbarras tb where tb.codigo_barras=?) and\n" +
                    "(select count(td.barrassabor) from tdados_tamanho td where td.barrassabor=?)=0";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, barras);
                ps.setString(2, barras);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    public void removeCadastroTamanho(String idadc){
            try {
                String sql="delete from TCAD_TAM_PIZZA where idtamanho=? ";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, idadc);
                ps.executeUpdate();
                ps.close();
                sql="delete from tdados_tamanho td where td.idtamanho=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, idadc);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    public void ajustaPrecoSabor(String barras,String tamanho,Double vl){
            try {
                String sql="update tdados_tamanho tm set tm.preco=? where tm.idtamanho=? and tm.barrassabor=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setDouble(1, vl);
                ps.setString(2, tamanho);
                ps.setString(3, barras);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
    }

     public void insereCampanha(String barras,String tamanho,int idcampanha){
            try {
                String sql="update tdados_tamanho tm set tm.idcampanha=? where tm.idtamanho=? and tm.barrassabor=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setInt(1, idcampanha);
                ps.setString(2, tamanho);
                ps.setString(3, barras);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
    }
    public void ajustaValorTamanho(String id,Double vl){
            try {
                String sql="update tcad_tam_pizza tp set tp.preco=? where tp.idtamanho=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(2, id);
                ps.setDouble(1, vl);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CadPizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
   
}
