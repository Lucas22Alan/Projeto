package Impressoes;
import classes.clsaux;
import contrato.lancamentoTiro;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JOptionPane;



public class RelacaoDeProdutos implements Drawable{
    private final List<ProdutoImpresso> itens;
    
    public RelacaoDeProdutos(List<ProdutoImpresso> itens){
            this.itens=itens;
    }

    @Override
    public void draw(int x, int y, Graphics g) {
       String subtotal,totalvenda, troco, vlrfina, tipfina,desconto=null;
       subtotal= lancamentoTiro.valorvenda;
       desconto=clsaux.formato(lancamentoTiro.desco);
       totalvenda=clsaux.formato(Double.parseDouble(subtotal.replaceAll(",", "."))-lancamentoTiro.desco);
       troco= "0,00";
       vlrfina = "0,00";
       tipfina = "";
      // g.drawString("DAV", 60, 10);
       int x2=x;
       int y2 = y+50;
       for (ProdutoImpresso i : itens){
           i.draw(x, y2, g);
           y2 +=16;
       }
       g.drawString("-----------------------------------------------------------------------------------------------", 0, y2);
       g.setFont(new Font ("Arial", Font.PLAIN, 9));
       g.drawString("SUB TOTAL R$", x2, y2+10);
       g.drawString("DESCONTO", x2, y2+20);
       g.drawString("TOTAL", x2, y2+30);
       g.drawString("-------------------------------------------------------------------------------", 0, y2+40);
       g.drawString(subtotal, 180, y2+10);
       g.drawString(desconto, 180, y2+20);
       g.drawString(totalvenda, 180, y2+30);
       //g.drawString(troco, 180, y2+30);
    }
    public String formato (Double f){
            return  String.format("%.2f", f);
    }
}
