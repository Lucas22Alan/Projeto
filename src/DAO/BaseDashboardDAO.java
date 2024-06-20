/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.ClsValoresDashboard;
import classes.ClsValoresDashboardItem;
import classes.clsaux;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class BaseDashboardDAO {
 
    PreparedStatement ps;
    ResultSet rs;
    
    
    public ClsValoresDashboard retornaFaturamentoDelivery(String dtini,String dtfinal){
        ClsValoresDashboard valores= new ClsValoresDashboard();
        try {
            String sql="select td.total,td.retirada,td.origem from tdelivery td where td.estado_sistema='2' and td.total>0 and td.data_pedido between '"+clsaux.retornaDataHora(dtini)+"'"
                    + " and '"+clsaux.retornaDataHora(dtfinal)+"'";
            ps=conexao.getPreparedStatement(sql);
            System.out.println(dtini);
            System.out.println(dtfinal);
              System.out.println(sql);
            rs=ps.executeQuery();
            Double vlTotal=0.00,vlSistema=0.00,vlMeumenu=0.00,vlEntrega=0.00,vlBalcao=0.00;
            while(rs.next()){
                vlTotal=vlTotal+rs.getDouble(1);
                if(rs.getString(2).equals("Entregar")){
                    vlEntrega=vlEntrega+rs.getDouble(1);
                }else{
                    vlBalcao=vlBalcao+rs.getDouble(1);
                }
                if(rs.getString(3).equals("Sistema")){
                    vlSistema=vlSistema+rs.getDouble(1);
                }else{
                    vlMeumenu= vlMeumenu+rs.getDouble(1);
                }
            }
            valores.setFaturamentoBalcao(vlBalcao);
            valores.setFaturamentoEntrega(vlEntrega);
            valores.setFaturamentoMeuMenu(vlMeumenu);
            valores.setFaturamentoSistema(vlSistema);
            valores.setFaturamentoTotal(vlTotal);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valores;
    }
    public List<ClsValoresDashboardItem> retornaValoresItens(String dtini,String dtfinal,int tipo){
        List<ClsValoresDashboardItem> lista= new ArrayList<>();
        String sql="";
        try {
            if(tipo==0){
                sql="select ti.codi_barra as CODIGO_BARRAS, tp.descricao as NOMELONGO,sum(ti.quantidade) AS QUANTIDADE,sum(ti.total) AS TOTAL from titens ti\n" +
"                        join tmovimento tm on ti.id_mov=tm.id_mov\n" +
"                        join tcad_tam_pizza tp on ti.codi_barra= tp.barrasorig\n" +
"                        join tdelivery tv on tv.id= tm.mvto_origem\n" +
"                        where tv.data_pedido between '"+clsaux.retornaDataHora(dtini)+"'and '"+clsaux.retornaDataHora(dtfinal)+"' \n" +
"                        and tm.estado=2 and ti.estado=2 and tm.id_tipo=1 and tv.estado_sistema=2\n" +
"                        group by 1,2 order by 3 desc";
            }else if(tipo==1){
                sql="select ti.barrassabor as CODIGO_BARRAS, ti.descricao_sabor as NOMELONGO,count(ti.idmvto) AS QUANTIDADE,sum(ti.valor) AS TOTAL from titens_sabores_pizza ti\n" +
                    "join tmovimento tm on ti.idmvto=tm.id_mov\n" +
                    "join tdelivery tv on tv.id= tm.mvto_origem"
                        + " where tv.data_pedido between '"+clsaux.retornaDataHora(dtini)+"'and '"+clsaux.retornaDataHora(dtfinal)+"'\n" +
                    "and tm.estado=2 and  ti.idmvto<>''\n" +
                    "group by 1,2 order by 3 desc";
                          
             }else if(tipo==2){
                sql="select ti.barras_orig as CODIGO_BARRAS, ti.descricao_adicional as NOMELONGO,sum(ti.qnt_adc) AS QUANTIDADE,sum(ti.valor) AS TOTAL from titens_adicionais ti\n" +
                    "join tmovimento tm on ti.id_mvto=tm.id_mov\n" +
                    " join tdelivery tv on tv.id= tm.mvto_origem\n" +
"                    where tv.data_pedido between  '"+clsaux.retornaDataHora(dtini)+"'and '"+clsaux.retornaDataHora(dtfinal)+"'\n" +
                    "and tm.estado=2 and  ti.id_mvto<>''\n" +
                    "group by 1,2 order by 3 desc";
             }
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            Double total=0.00;
            while(rs.next()){
                ClsValoresDashboardItem item= new ClsValoresDashboardItem();
                total=total+rs.getDouble(4);
                item.setValortotal(rs.getDouble(4));
                item.setNome(rs.getString(2));
                item.setQuantidade(rs.getDouble(3));
                lista.add(item);
            }
            
            for(int i=0; i<lista.size(); i++){
                Double percentual= (lista.get(i).getValortotal()*100) / total;
                lista.get(i).setPercentual( percentual.intValue() );
            }
            rs.close();
            ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(BaseDashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
    }
   
     public List<ClsValoresDashboardItem> retornaValoresBairro(String dtini,String dtfinal){
        List<ClsValoresDashboardItem> lista= new ArrayList<>();
        String sql="select td.bairro,sum(td.taxa_entrega),count(td.ckeck) from tdelivery td where td.estado_sistema='2'\n" +
                    "and td.bairro is not null AND td.data_pedido between  '"+clsaux.retornaDataHora(dtini)+"'and '"+clsaux.retornaDataHora(dtfinal)+"'  group by 1 order by 3 desc" ;
        try {
           
            ps=conexao.getPreparedStatement(sql);
            rs=ps.executeQuery();
            Double total=0.00;
            while(rs.next()){
                ClsValoresDashboardItem item= new ClsValoresDashboardItem();
                total=total+rs.getDouble(2);
                item.setValortotal(rs.getDouble(2));
                item.setNome(rs.getString(1));
                item.setQuantidade(rs.getDouble(3));
                lista.add(item);
            }
            
            for(int i=0; i<lista.size(); i++){
                Double percentual= (lista.get(i).getValortotal()*100) / total;
                lista.get(i).setPercentual( percentual.intValue() );
            }
            rs.close();
            ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(BaseDashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
    }
   
    
}
