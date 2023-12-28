package util;
import DAO.CadPizzaDAO;
import classes.clsaux;
import grafic.interfac.formConfereValorCaixa;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;





public class CriaBtnTamanhoPizza extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
JTable table;
JButton renderButton;
JButton editButton;
String text;   
String tipo;


public CriaBtnTamanhoPizza(JTable table, int column,String descricao,String tp)
    {
        super();
        this.table = table;
        this.text=descricao;
        tipo=tp;
       
        
        renderButton = new JButton("render");

        editButton = new JButton("butto");
        editButton.setFocusPainted( false );
        editButton.addActionListener( this );

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer( this );
        columnModel.getColumn(column).setCellEditor( this );
    }

    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (hasFocus)
        {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }
        else if (isSelected)
        {
            renderButton.setForeground(table.getSelectionForeground());
             renderButton.setBackground(table.getSelectionBackground());
        }
        else
        {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText( text);
        return renderButton;
    }

    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column)
    {
        //text = "teste";
        editButton.setText(text);
        return editButton;
    }

    public Object getCellEditorValue()
    {
        return text;
    }

    public void actionPerformed(ActionEvent e)
    {
     JButton clickedButton = (JButton) e.getSource();
        if (clickedButton == renderButton || clickedButton == editButton) {
           if(tipo.equals("T")){
               new CadPizzaDAO().ajustaValorTamanho(table.getValueAt(table.getSelectedRow(), 0).toString(),
                       clsaux.capturaValores(table.getValueAt(table.getSelectedRow(), 2).toString()));
               
        }else if (tipo.equals("S")){
               new CadPizzaDAO().ajustaPrecoSabor(table.getValueAt(table.getSelectedRow(), 1).toString(),
                       table.getValueAt(table.getSelectedRow(), 9).toString(),
                       clsaux.capturaValores(table.getValueAt(table.getSelectedRow(), 4).toString()));

            }

            fireEditingStopped();
        }
    }
}