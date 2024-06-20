package util;
import DAO.TcadCalibreDAO;
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
import model.TcadCalibre;





public class criaBotaoTabelaCalibres extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
JTable table;
JButton renderButton;
JButton editButton;
String text;   
TcadCalibre calibre;


public criaBotaoTabelaCalibres(JTable table, int column,String descricao)
    {
        super();
        this.table = table;
        this.text=descricao;
        
        renderButton = new JButton("render");

        editButton = new JButton("butto");
        editButton.setFocusPainted( false );
        editButton.addActionListener( this );

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer( this );
        columnModel.getColumn(column).setCellEditor( this );
    }

@Override
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

@Override
    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column)
    {
        //text = "teste";
        editButton.setText(text);
        return editButton;
    }

@Override
    public Object getCellEditorValue()
    {
        return text;
    }

@Override
    public void actionPerformed(ActionEvent e)
    {
        fireEditingStopped();
        calibre= new TcadCalibre();
        calibre.setId(clsaux.trataCampoNulo(table.getValueAt(table.getSelectedRow(), 0)));
        calibre.setNome(clsaux.trataCampoNulo(table.getValueAt(table.getSelectedRow(), 1)));
        System.out.println(calibre.toString());
        new TcadCalibreDAO().inserirCalibre(calibre);
    }
}