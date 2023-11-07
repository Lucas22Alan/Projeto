/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import javax.swing.table.TableRowSorter;

/**
 *
 * @author Lucas
 */
public class criaFiltroListaSuspensa extends AbstractCellEditor implements TableCellEditor {
  private JComboBox<String> comboBox;
    private JTable table;
    private int ind;

    public criaFiltroListaSuspensa(List<String> groups, JTable table,int inde) {
        this.table = table;
        this.ind=inde;
        comboBox = new JComboBox<>(groups.toArray(new String[0]));
        comboBox.setEditable(false);
        

        // Adiciona um ouvinte de alteração ao JComboBox para realizar o filtro
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedGroup = (String) comboBox.getSelectedItem();
                TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) table.getRowSorter();
                if (selectedGroup != null && !selectedGroup.isEmpty()) {
                    // Cria um filtro para mostrar apenas as linhas com o grupo selecionado
                    RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter(selectedGroup, ind); // 1 é o índice da coluna "Grupo"
                    rowSorter.setRowFilter(filter);
                } else {
                    // Remove o filtro se nada for selecionado
                    rowSorter.setRowFilter(null);
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        comboBox.setSelectedItem(value);
        return comboBox;
    }

    @Override
    public Object getCellEditorValue() {
        return comboBox.getSelectedItem();
    }
    
    
   
    
}
