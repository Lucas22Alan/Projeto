/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.clsMovimentoEstoque;
import classes.clsaux;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mk Solucoes
 */
public class MovimentacaoEstoqueDAO {
    
    public List<clsMovimentoEstoque> retornaMovimentoPorData(String cod,String ini,String fim) throws SQLException{
        List<clsMovimentoEstoque> lista= new ArrayList<>();
        String sql=" select ti.codigo_baixa,\n" +
"        ti.quantidade,\n" +
"        tm.id_tipo,\n" +
"        tm.dat_finalizacao,\n" +
"        tm.hora_finalizacao,\n" +
"        tp.custo_atual,\n" +
"        tp.preco_custo,\n" +
"        ti.prec_venda ,\n" +
"        ti.fator,\n" +
"        tm.id_mov,\n" +
"        tc.razao_social,\n" +
"        ti.total,\n" +
"        tm.numero_documento,\n" +
"        tm.serie,\n" +
"        tm.id_modelo,\n" +
"        td.direcao, td.descricao\n" +
"        from titens ti\n" +
"        join tmovimento tm on ti.id_mov=tm.id_mov\n" +
"        join tprecos tp on ti.id_prod=tp.id\n" +
"        left join tparceiros tc on tm.id_parceiro=tc.idparceiro\n" +
"        left join ttipo_documentos   td on tm.id_tipo=td.id \n" +
"        where ti.codigo_baixa= ? and tm.dat_finalizacao between ? and ? and tm.estado=2 and ti.estado=2 and (ti.imp<>'S'  or ti.imp is null)\n" +
"        order by 4 asc, 5 asc";
    
        PreparedStatement ps = conexoes.conexao.getPreparedStatement(sql);
        ps.setString(1, cod);
        ps.setDate(2, clsaux.retornaData(ini));
        ps.setDate(3, clsaux.retornaData(fim));
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            clsMovimentoEstoque cm= new clsMovimentoEstoque();
            cm.setCodigo(rs.getString(1));
            cm.setData(rs.getString(4));
            cm.setDocumento(rs.getString(13));
            cm.setEstado("Finalizado");
            cm.setHora(rs.getString(5));
            cm.setModelo(rs.getString(15));
            cm.setMovto(rs.getString(10));
            cm.setParceiro(rs.getString(11));
            cm.setQnd(rs.getDouble(2));
            cm.setSerie(rs.getString(14));
            cm.setValortotal(rs.getDouble(12));
            cm.setDirecao(rs.getString(16));
            cm.setDescMov(rs.getString(17));
            lista.add(cm);
        
        }
        rs.close();
        ps.close();
        return lista;
    
    }
    
}
