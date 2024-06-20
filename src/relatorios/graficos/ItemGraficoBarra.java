/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios.graficos;

import classes.clsaux;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Lucas
 */
public class ItemGraficoBarra  extends JPanel{
    
    private String itemName;
    private double percentage;
    private double totalSales;
    

    public ItemGraficoBarra(String itemName, int percentage, double totalSales,int dim, String quantidade) {
        this.itemName = itemName;
        this.percentage = percentage;
        this.totalSales = totalSales;

        setPreferredSize(new Dimension(dim, 40)); // Defina o tamanho preferido do painel
        setBackground(Color.white);
        
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //GridBagConstraints gbc = new GridBagConstraints();
       // gbc.fill = GridBagConstraints.HORIZONTAL;
       // gbc.weightx = 1.0;

        JLabel nameLabel = new JLabel(itemName+ quantidade);
        JLabel quan= new JLabel(quantidade);
        //gbc.gridx = 0;
        //gbc.gridy = 0;
      
         
         add(nameLabel);
         

        JProgressBar progressBar = new JProgressBar(0, 100); // Barra de progresso com 0 a 100
        progressBar.setStringPainted(true);
        progressBar.setAlignmentX(LEFT_ALIGNMENT);
        progressBar.setValue(percentage); // Defina o valor da barra de progresso
        progressBar.setString("R$: "+clsaux.formataReais(totalSales)+" -- "+percentage+" %    ");
        progressBar.setFont( new Font("Arial", Font.BOLD, 12));
        
        
        /* progressBar.setUI(new BasicProgressBarUI() {
            protected void paintString(Graphics g, int x, int y, int width, int height, int amountFull, Insets b) {
                if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
                    // Ajusta o alinhamento do texto para a direita
                    x = x + width - progressBar.getFontMetrics(progressBar.getFont()).stringWidth(progressBar.getString());
                }
                // Desenha o texto na nova posição
                g.drawString(progressBar.getString(), x, y + (height + progressBar.getFontMetrics(progressBar.getFont()).getHeight()) / 2);
            }
        });*/
        
      //  gbc.gridx = 1;
       // gbc.gridy = 0;
     //   gbc.anchor = GridBagConstraints.CENTER;
        add(progressBar);

        ///JLabel totalLabel = new JLabel("Total: " + totalSales);
       // add(totalLabel, BorderLayout.EAST);
    }

    

  
  

    
    
    
}
