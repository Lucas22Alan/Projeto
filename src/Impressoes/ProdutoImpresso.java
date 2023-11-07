package Impressoes;
import model.clsConfig;
import model.clsDadosEmpresa;
import java.awt.Font;
import java.awt.Graphics;



public class ProdutoImpresso implements Drawable{
    private final String itemf;
    private final String codigo;
    private final String descricao;
    private final String vlrqntf;
    private final String quantidade;
    private final String totalf;
    
    public ProdutoImpresso(String item, String cod, String desc,String vlrqnt ,String qnt, String total){
        this.itemf=item; 
        this.codigo= cod;
        this.descricao= desc;
        this.vlrqntf=vlrqnt;
        this.quantidade=qnt;
        this.totalf=total;
    
    }

 
    @Override
    public void draw(int x, int y, Graphics g) {
        g.setFont(new Font ("Arial", Font.PLAIN, 9));
        int l=clsConfig.linhasCupomTiro;
        g.drawString(clsDadosEmpresa.getRazao(), l+40, 10);
        g.drawString(clsDadosEmpresa.getFantasia(), l+5, 20);
        g.drawString(clsDadosEmpresa.getCnpj(), l+30, 30);
        g.drawString("Cnpj:", l+5, 30);
        g.drawString("IE:", l+110, 30);
        g.drawString(clsDadosEmpresa.getIncricao_estadual(), l+120, 30);
        g.drawString(clsDadosEmpresa.getRua(), l+5, 40);
        g.drawString(clsDadosEmpresa.getBairro(), l+140, 40);
        g.drawString(clsDadosEmpresa.getNumero(), l+110, 40);
        g.drawString("Fone:", l+5, 50);
        g.drawString(clsDadosEmpresa.getFone(), l+30, 50);
        g.drawString(clsDadosEmpresa.getCidade()+"-"+clsDadosEmpresa.getEstado(), l+110, 50);
        g.drawString("----------------------------------------------------------------------------", 0, 65);
        g.drawString("Codigo     Descricao         Qtde x Vlr Unit      Total", l+0, 70);
        g.drawString("-----------------------------------------------------------------------------", 0, 73);
        g.setFont(new Font ("Arial", Font.PLAIN, 7));
        g.drawString(codigo,l+2 , y);
        g.drawString(descricao, l+60, y);
        g.drawString(vlrqntf, l+140, y+8);
        g.drawString(quantidade, l+110, y+8);
        g.drawString("X", l+132, y+8);
        g.drawString(totalf, l+180, y+8);
    }
    
}
