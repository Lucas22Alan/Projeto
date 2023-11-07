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
import model.Tcad_adicional;
import model.Tdados_adicional_item;

/**
 *
 * @author Mk Solucoes
 */
public class AdicionalDAO {
        PreparedStatement ps;
        ResultSet rs;
    
    public boolean inserirAdicional(Tcad_adicional cad){
        boolean ret=true;
        try {
            String sql="UPDATE OR INSERT INTO TCAD_ADICIONAL (ID, DESCRICAO, QNTUSAR, PREC_VENDA, COD_BASE, CUSTO_BASE, ESTADO,descricao_base,tipo)\n" +
                    "                              VALUES (?,?,?,?,?,?,?,?,?)\n" +
                    "                            MATCHING (ID);";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, cad.getId());
            ps.setString(2, cad.getDescricao());
            ps.setDouble(3, cad.getQntusar());
            ps.setDouble(4, cad.getPrec_venda());
            ps.setString(5, cad.getCod_base());
            ps.setDouble(6, cad.getCusto_base());
            ps.setString(7, cad.getEstado());
            ps.setString(8, cad.getDescricao_base());
            ps.setString(9, cad.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ret=false;
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(AdicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public List<Tcad_adicional> retornaListaAdicional(){
          List<Tcad_adicional> lista= new ArrayList<>();
            try {
                String sql="select * from tcad_adicional where estado='2'";
                ps=conexao.getPreparedStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    Tcad_adicional cad= new Tcad_adicional();
                    cad.setCod_base(rs.getString(5));
                    cad.setCusto_base(rs.getDouble(6));
                    cad.setDescricao(rs.getString(2));
                    cad.setEstado(rs.getString(7));
                    cad.setId(rs.getString(1));
                    cad.setPrec_venda(rs.getDouble(4));
                    cad.setQntusar(rs.getDouble(3));
                    cad.setDescricao_base(rs.getString(8));
                    lista.add(cad);
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
        
    }
    
    public Tcad_adicional retornaCadAdicional(String id){
          Tcad_adicional cad= new Tcad_adicional();
            try {
                String sql="select * from tcad_adicional where id="+id;
                ps=conexao.getPreparedStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()){
                    cad.setCod_base(rs.getString(5));
                    cad.setCusto_base(rs.getDouble(6));
                    cad.setDescricao(rs.getString(2));
                    cad.setEstado(rs.getString(7));
                    cad.setId(rs.getString(1));
                    cad.setPrec_venda(rs.getDouble(4));
                    cad.setQntusar(rs.getDouble(3));
                    cad.setDescricao_base(rs.getString(8));
                    cad.setTipo(rs.getString(9));
                    
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return cad;
        
    }
    
    public List<Tdados_adicional_item> retornaItensPorAdicinal(String idadc){
        List<Tdados_adicional_item> lista= new ArrayList<>();
        try {
                String sql="select td.idadicional,td.codbarras,tp.id,tp.nomelongo,tp.unid_venda,tc.preco_venda,\n" +
                        "tg.nome,ts.nome from tdados_adicional_item td\n" +
                        "left join tbarras tb on tb.codigo_barras=td.codbarras\n" +
                        "left join tprodutos tp on tb.id_produto=tp.id\n" +
                        "left join tprecos tc on tp.id=tc.id\n" +
                        "left join tgrupos tg on tp.id_grupo=tg.id_grupo\n" +
                        "left join tsubgrupo ts on tp.id_subgrupo=ts.idsubgrupo\n" +
                        "where td.idadicional=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, idadc);
                rs=ps.executeQuery();
                while(rs.next()){
                    Tdados_adicional_item it= new Tdados_adicional_item();
                    it.setIdadiconal(rs.getString(1));
                    it.setCodbarras(rs.getString(2));
                    it.setIdproduto(rs.getString(3));
                    it.setDescricao(rs.getString(4));
                    it.setUnidade(rs.getString(5));
                    it.setVenda(rs.getDouble(6));
                    it.setGrupo(rs.getString(7));
                    it.setSubgrupo(rs.getString(8));
                    lista.add(it);
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
        
    }
    public void inserirItensRefAdicional(String adc,String barra){
            try {
               
                String sql="UPDATE OR INSERT INTO TDADOS_ADICIONAL_ITEM (IDADICIONAL, CODBARRAS)\n" +
                        "                                     VALUES (?, ?)\n" +
                        "                                   MATCHING (IDADICIONAL, CODBARRAS);";
                ps= conexao.getPreparedStatement(sql);
                ps.setString(1, adc);
                ps.setString(2, barra);
                ps.executeUpdate();
                ps.close();
                sql="update tprodutos tp set tp.tem_adicional='S' where tp.id=(\n" +
                        "select tb.id_produto from tbarras tb where tb.codigo_barras=? )";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, barra);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void InserirItensPorGrupo(String id, String tipo,String idadc){
            
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
                    
                    this.inserirItensRefAdicional(idadc, rs.getString(1));
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logs.gravarLog.main(ex.getMessage());
                Logger.getLogger(AdicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void removeItemAdicional(String idadc,String barras){
            try {
                String sql="delete from tdados_adicional_item td where td.idadicional=? and td.codbarras=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, idadc);
                ps.setString(2, barras);
                ps.executeUpdate();
                ps.close();
                sql="update tprodutos tp set tp.tem_adicional='N' where id=(\n" +
                    "select tb.id_produto from tbarras tb where tb.codigo_barras=?) and\n" +
                    "(select count(td.codbarras) from tdados_adicional_item td where td.codbarras=?)=0";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, barras);
                ps.setString(2, barras);
                ps.executeUpdate();
                ps.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(AdicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    public void removeCadastroAdicional(String idadc){
            try {
                String sql="update tcad_adicional set estado='3' where id=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, idadc);
                ps.executeUpdate();
                ps.close();
                sql="delete from tdados_adicional_item td where td.idadicional=?";
                ps=conexao.getPreparedStatement(sql);
                ps.setString(1, idadc);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdicionalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
}
