
package contrato;

import classes.clsaux;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ImpFichaConsumo {
    public ArrayList text;   
    public ImpFichaConsumo (ArrayList texto) {
    text=texto;
    PrinterJob pj = PrinterJob.getPrinterJob();
    PageFormat pf = pj.defaultPage();
    Paper paper = new Paper();
    double margin = 36; 
    double ini=10;
    paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight()
        - margin * 2);
    pf.setPaper(paper);
    pj.setPrintable(new MyPrintable(), pf);
    
      try {
        pj.print();
        text.clear();
      } catch (PrinterException e) {
        System.out.println(e);
      
    }
  }
    
 class MyPrintable implements Printable {
  public int print(Graphics g, PageFormat pf, int pageIndex) {
    if (pageIndex != 0)
      return NO_SUCH_PAGE;
    Graphics2D g2 = (Graphics2D) g;
    g2.setFont(new Font("Arial Narrow", Font.BOLD, 12));
    g2.setPaint(Color.black);
    g2.drawString("ZZOPER  CLUB", 75, 50);
    g2.setFont(new Font("Arial Narrow", Font.PLAIN, 10));
    g2.drawString("Ficha de Consumo ", 78, 65);
     g2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
    g2.drawString("-------------------------------------------------------------", 1, 75);
    g2.setFont(new Font("Arial Narrow", Font.PLAIN, 10));
    g2.drawString("Id Reserva: "+(String) text.get(0), 40, 82);
    g2.setFont(new Font("Arial Narrow", Font.PLAIN, 10));
    g2.drawString("Data: "+(String) clsaux.preencheData(), 130, 82);
    g2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
    g2.drawString("-------------------------------------------------------------", 1, 90);
    g2.setFont(new Font("Arial Narrow", Font.PLAIN, 10));
    g2.drawString("Item", 40, 98);
    g2.drawString("Qtde", 175, 98);
    g2.setFont(new Font("Arial Narrow", Font.BOLD, 14));
    g2.drawString(" "+(String) text.get(4), 175, 115);
    g2.drawString(" "+(String) text.get(3), 37, 115);
    g2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
    g2.drawString("-------------------------------------------------------------", 1, 130);
    return PAGE_EXISTS;
  }
 }
}   
