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
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class listaGrupDAO {
    public static List listagrupo(){
        List <String> listagrup= new ArrayList<String>();
        try{
           
        String Sqlpegagrupo="select * from tgrupos order by 1";
        PreparedStatement psgrup= conexao.getPreparedStatement(Sqlpegagrupo);
        ResultSet rsgrup = psgrup.executeQuery();
        while(rsgrup.next()){
            listagrup.add(rsgrup.getString(1)+" -"+rsgrup.getString(2));
        }
        }catch (SQLException er){
            JOptionPane.showMessageDialog(null, "Erro ao buscar grupos "+er);
        }
        return listagrup;
    }
     public static List listaSubGrupo(){
        List <String> listagrup= new ArrayList<String>();
        try{
           
        String Sqlpegagrupo="select * from tsubgrupo order by 1";
        PreparedStatement psgrup= conexao.getPreparedStatement(Sqlpegagrupo);
        ResultSet rsgrup = psgrup.executeQuery();
        while(rsgrup.next()){
            listagrup.add(rsgrup.getString(1)+" -"+rsgrup.getString(2));
        }
        }catch (SQLException er){
            JOptionPane.showMessageDialog(null, "Erro ao buscar grupos "+er);
        }
        return listagrup;
    }
      public static List listaSetores(){
        List <String> listagrup= new ArrayList<String>();
        try{
           
        String Sqlpegagrupo="select * from tsetores order by 1";
        PreparedStatement psgrup= conexao.getPreparedStatement(Sqlpegagrupo);
        ResultSet rsgrup = psgrup.executeQuery();
        while(rsgrup.next()){
            listagrup.add(rsgrup.getString(1)+" -"+rsgrup.getString(2));
        }
        }catch (SQLException er){
            JOptionPane.showMessageDialog(null, "Erro ao buscar grupos "+er);
        }
        return listagrup;
    }
    public static List listaTipo(){
        List <String> listagrup= new ArrayList<String>();
        try{
           
        String Sqlpegagrupo="select * from ttipo_produtos order by 1";
        PreparedStatement psgrup= conexao.getPreparedStatement(Sqlpegagrupo);
        ResultSet rsgrup = psgrup.executeQuery();
        while(rsgrup.next()){
            listagrup.add(rsgrup.getString(1)+" -"+rsgrup.getString(2));
        }
        }catch (SQLException er){
            JOptionPane.showMessageDialog(null, "Erro ao buscar grupos "+er);
        }
        return listagrup;
    }
}
