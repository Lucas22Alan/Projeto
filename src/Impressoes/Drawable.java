
package Impressoes;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;


public interface Drawable {
    public void draw (int x, int y, Graphics g);
    
    
    public default void imprimir (String titulo, int x, int y){
        Frame f = new Frame("frame temporario");
        PrintJob pj =Toolkit.getDefaultToolkit().getPrintJob(f, "teste", null);
        Graphics g = null;
        try {
            if (pj!= null ){
                
                g=pj.getGraphics();
                draw(x,y,g);
                
            }
        }finally {
           
                    if (g!= null) g.dispose();
                    if (pj!= null) pj.end();
                    f.dispose();
                    }
                
       }
}
