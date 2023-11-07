
package DAO;

import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class pesqestadoDAO {    
    public static List pegaestado(){
        List <String> listaestado = new ArrayList<String>();
        try {
        String sqlestado="select estado from tcidades group by estado";
        PreparedStatement psestado = conexao.getPreparedStatement(sqlestado);
        ResultSet rsestado= psestado.executeQuery();
            while(rsestado.next()){
                listaestado.add(rsestado.getString("estado"));
            }psestado.close();
         rsestado.close();
        }
        catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "erro ao pegar lista de estados"+ex.getMessage());
        }return listaestado;
    }
    
    public static List pegacidade(String codigoestado){
        List <String> listacidades = new ArrayList<String>();
        try {
        String sqlcidade="select nome_cidade from tcidades where estado='"+codigoestado+"'";
        PreparedStatement pscidade = conexao.getPreparedStatement(sqlcidade);
        ResultSet rscidade= pscidade.executeQuery();
            while(rscidade.next()){
                listacidades.add(rscidade.getString("nome_cidade"));
            }pscidade.close();
         rscidade.close();
        }
        catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "erro ao pegar lista de estados"+ex.getMessage());
        }return listacidades;
    
    }
    public static List pegacidadeSemEstado(){
        List <String> listacidades = new ArrayList<String>();
        try {
        String sqlcidade="select nome_cidade from tcidades;";
        PreparedStatement pscidade = conexao.getPreparedStatement(sqlcidade);
        ResultSet rscidade= pscidade.executeQuery();
            while(rscidade.next()){
                listacidades.add(rscidade.getString("nome_cidade"));
            }pscidade.close();
         rscidade.close();
        }
        catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "erro ao pegar lista de estados"+ex.getMessage());
        }return listacidades;
    
    }
}
