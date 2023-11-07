package util;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ValidaValorTabela extends DefaultCellEditor {
    private final DecimalFormat decimalFormat;

    public ValidaValorTabela() {
        super(new JTextField());
        decimalFormat = new DecimalFormat("#,##0.00");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(symbols);
    }

    @Override
    public boolean stopCellEditing() {
        try {
            String valor = (String) super.getCellEditorValue();
            // Remove quaisquer caracteres que não sejam números ou pontos
           valor = valor.replace(',', '.');

            // Transforma o valor em double usando o DecimalFormat
            double valorDouble = decimalFormat.parse(valor).doubleValue();

            // Verifica se o valor é maior ou igual a zero
            if (valorDouble >= 0) {
                // Formata o valor novamente para garantir que seja exibido corretamente na célula
                String valorFormatado = decimalFormat.format(valorDouble);
                ((JTextField) getComponent()).setText(valorFormatado);
                return super.stopCellEditing();
            } else {
                JOptionPane.showMessageDialog(null, "Valor Informado Inválido!!!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor Informado Inválido!!!");
            return false;
        }
    }

    @Override
    public Object getCellEditorValue() {
        String valor = ((JTextField) getComponent()).getText();
        // Remove quaisquer caracteres que não sejam números ou pontos
        valor = valor.replaceAll("[^\\d.]", "");
        try {
            // Transforma o valor em double usando o DecimalFormat
            double valorDouble = decimalFormat.parse(valor).doubleValue();
            // Formata o valor novamente para garantir que seja exibido corretamente na célula
            return decimalFormat.format(valorDouble);
        } catch (Exception e) {
            return "0.00"; // Retorna 0.00 em caso de valor inválido
        }
    }
}

