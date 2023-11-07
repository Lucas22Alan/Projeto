
package DAO;

import model.Cst;
import model.clsPisCofins;
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
 * @author lucas
 */
public class listaInfAdcDAO {
    public static List pegaUnid(){
        List <String> listunid = new ArrayList <String>();
        try{
            String sqlpegaunid="select unidade from tunidade";
            PreparedStatement psunid= conexao.getPreparedStatement(sqlpegaunid);
            ResultSet rsunid = psunid.executeQuery();
            while(rsunid.next()){
                listunid.add(rsunid.getString("unidade"));
            }
        
        }catch (SQLException err){
        JOptionPane.showMessageDialog(null, "erro ao executar o comando para obter unidades"+err.getMessage());
        }
        return listunid;
    }
    public static List retornaBalanca(){
        List <String> listad = new ArrayList <String>();
        try{
            String sqlpegaunid="select id_balanca,descricao from tcad_balanca order by 1 asc";
            PreparedStatement ps= conexao.getPreparedStatement(sqlpegaunid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listad.add(rs.getString(1)+"-"+rs.getString(2));
            }
        
        }catch (SQLException err){
        JOptionPane.showMessageDialog(null, "erro ao executar o comando para obter unidades"+err.getMessage());
        }
        return listad;
    }
    public static List listaCest( String ncm){
        List <String> listCest = new ArrayList<String>();
        try{
            String sqlpegacest="select cest from tncm where cod_ncm like'%"+ncm+"%'";
            PreparedStatement pscest = conexao.getPreparedStatement(sqlpegacest);
            ResultSet rscest = pscest.executeQuery();
            while(rscest.next()){
                listCest.add(rscest.getString("cest"));
            }}catch(SQLException errr){
                 JOptionPane.showMessageDialog(null, errr);
             }
        return listCest;
    }
    public static List listaAliq(){
        List <String> listAliq = new ArrayList<String>();
        try{
            String sqlpegaaliq="select aliquota from taliquotas";
            PreparedStatement psaliq = conexao.getPreparedStatement(sqlpegaaliq);
            ResultSet rsaliq = psaliq.executeQuery();
            while(rsaliq.next()){
                listAliq.add(rsaliq.getString(1));
            }}catch(SQLException errr){
                 JOptionPane.showMessageDialog(null, errr);
             }
        return listAliq;
    }
    public static List listaPis(String direcao){
        List <String> listPis = new ArrayList<String>();
        try{
            String sqlpegapis="select identificacao from tpis_cofins where direcao='"+direcao+"'";
            PreparedStatement pspis = conexao.getPreparedStatement(sqlpegapis);
            ResultSet rspis = pspis.executeQuery();
            while(rspis.next()){
                listPis.add(rspis.getString(1));
            }}catch(SQLException errr){
                 JOptionPane.showMessageDialog(null, errr);
             }
        return listPis;
    }
    public static String pegaidfinalizadora(String nome){
          String sql="select id_finalizdora from tfinalizadora where descricao='"+nome+"';";
          PreparedStatement psf= conexao.getPreparedStatementResult(sql);
          String retorno=null;
        try {
            ResultSet rs = psf.executeQuery();
            rs.first();
            retorno= rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(listaInfAdcDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
      }
    public static List retornaCategorias(){
        List <String> listPis = new ArrayList<String>();
        try{
            String sqlpegapis="select * from tplanos_clube;";
            PreparedStatement pspis = conexao.getPreparedStatement(sqlpegapis);
            ResultSet rspis = pspis.executeQuery();
            while(rspis.next()){
                listPis.add(rspis.getString(1)+" -"+rspis.getString(2));
            }}catch(SQLException errr){
                 JOptionPane.showMessageDialog(null, errr);
             }
        return listPis;
      }
    public static clsPisCofins retornaPis(String cst){
        clsPisCofins pis= new clsPisCofins();
        try {
            String sql="select * from tpis_cofins where pis_cofins=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, cst);
            ResultSet rs = ps.executeQuery();
            rs.first();
            pis.setCst(rs.getString(1));
            pis.setDescricao(rs.getString(2));
            pis.setAliq_pis(rs.getString(3));
            pis.setAliq_cofins(rs.getString(4));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
             Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(listaInfAdcDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pis; 
    }
    public static Cst retornaCst(String cod){
        Cst cst= new Cst();
        try {
            String sql="select * from tcad_cst where id_cst=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();
            rs.first();
            cst.SetCst(rs.getString(1));
            cst.SetDescricao(rs.getString(2));
            cst.SetRegime(rs.getString(3));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
             Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(listaInfAdcDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cst; 
    }


}
