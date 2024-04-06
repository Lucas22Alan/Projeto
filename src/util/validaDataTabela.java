/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Mk Solucoes
 */
public class validaDataTabela {
    
    
     
     public static DefaultCellEditor validaDataDiaMesAno(){
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          DefaultCellEditor cellEditor= new DefaultCellEditor(new JTextField()){
              @Override
              public boolean stopCellEditing(){
                  String valor=(String)super.getCellEditorValue();
                  try{
                      dateFormat.parse(valor);
                      return super.stopCellEditing();
                  }catch(ParseException e){
                      JOptionPane.showMessageDialog(null, "Data inválida.\nData Aceita dia/mês/ano!!!");
                        return false;
                  }
              }
          };
          return cellEditor;
     }
     
      public static DefaultCellEditor validaHora(){
          SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
          DefaultCellEditor cellEditor= new DefaultCellEditor(new JTextField()){
              @Override
              public boolean stopCellEditing(){
                  String valor=(String)super.getCellEditorValue();
                  try{
                      dateFormat.parse(valor);
                      return super.stopCellEditing();
                  }catch(ParseException e){
                      JOptionPane.showMessageDialog(null, "Hora inválida!!!");
                        return false;
                  }
              }
          };
          return cellEditor;
     }
     
 
     
 
     public static void adicionaBotao(JTable table, int column) {
        //this.table = table;
          
    }

     
    
}
