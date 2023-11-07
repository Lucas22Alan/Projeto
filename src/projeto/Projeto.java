package projeto;

import com.formdev.flatlaf.FlatIntelliJLaf;
import conexoes.conexao;
import conexoes.configuraConexao;
import grafic.interfac.formLogarsistema;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Projeto {

   /* classe inicial de todo o projeto a partir dela será chamado o form para validacao de usuario e senha para logar no sistema
    */
  public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> {
                new formLogarsistema().setVisible(true);
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(formLogarsistema.class.getName()).log(Level.SEVERE, null, ex);
        }

        configuraConexao.careg();
        conexao co = new conexao();

        co.getConexao();

    }
    
}
