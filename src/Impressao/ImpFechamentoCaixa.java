
package Impressao;


import classes.clsFechamentoCaixa;
import classes.clsSuprimentoSangria;
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
import model.clsConfig;

/**
 *
 * @author Lucas
 */
public class ImpFechamentoCaixa {
    String titu;
    String pdv;
    public ImpFechamentoCaixa (String titulo,String pd) {
        titu=titulo;
        pdv=pd;
    PrinterJob pj = PrinterJob.getPrinterJob();
    PageFormat pf = pj.defaultPage();
    Paper paper = new Paper();
    double margin = 3; 
    double ini=10;
    paper.setImageableArea(margin, margin, paper.getWidth() - margin , paper.getHeight() - margin * 2);
    pf.setPaper(paper);
    pj.setPrintable(new MyPrintable(), pf);
    
      try {
          //pj.setPrintService(new clsRetornaImpressora().retornaimpressora(clsConfig.nomeImpressoraCupom));
          pj.print();
      } catch (PrinterException e) {
        System.out.println(e);
      
    }
     // clsFechamentoCaixa.finalizadoras.clear();
  }
    
 class MyPrintable implements Printable {
  public int print(Graphics g, PageFormat pf, int pageIndex) {
    if (pageIndex != 0)
      return NO_SUCH_PAGE;
    Graphics2D g2 = (Graphics2D) g;
    int indicecoluna=242;
    String obs=null;
    g2.setFont(new Font("SansSerif", Font.BOLD, 12));
    g2.setPaint(Color.black);
    g2.drawString(""+titu, 45, 50);
    g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
    g2.drawString("Pdv: "+pdv, 45, 62);
    g2.drawString("Operador: "+clsFechamentoCaixa.getOperador(), 85, 62);
    g2.setFont(new Font("SansSerif", Font.PLAIN, 12));
    g2.drawString("-------------------------------------------------------------", 1, 75);
    g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
    g2.drawString("Data Abertura: "+clsaux.convertDataExib(clsFechamentoCaixa.getDatabertura())+" "+clsFechamentoCaixa.hraber,10, 82);
    g2.drawString("Data Fechamento: "+clsaux.convertDataExib(clsFechamentoCaixa.getDatafecha())+" "+clsFechamentoCaixa.hrfecha,10, 95);
    g2.setFont(new Font("SansSerif", Font.PLAIN, 12));
    g2.drawString("-------------------------------------------------------------", 1, 103);
    g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
    g2.drawString("Saldo Inicial:" , 10, 113);
    g2.drawString(""+clsaux.formato(clsFechamentoCaixa.getSaldoinicial()) , 160, 113);
    g2.drawString("Venda Bruta:" , 10, 128);
    g2.drawString(""+clsaux.formato(clsFechamentoCaixa.getVendabruta()) , 160, 128);
    g2.drawString("Cancelamentos:" ,10 , 143);
    g2.drawString(""+clsaux.formato(clsFechamentoCaixa.getCancelamentos()) ,160 , 143);
    g2.drawString("Venda Liquida: ", 10, 158);
    g2.drawString(""+clsaux.formato(clsFechamentoCaixa.getVendaliquida()), 160, 158);
    g2.drawString("Valor de Retiradas: ", 10, 173);
    g2.drawString(""+clsaux.formato(clsFechamentoCaixa.getRetiradas()), 160, 173);
    g2.drawString("Valor de Suprimentos: ", 10, 188);
    g2.drawString(""+clsaux.formato(clsFechamentoCaixa.getSuprimentos()), 160, 188);
    g2.drawString("Valor Outras Org.: ", 10, 203);
    g2.drawString(""+clsaux.formato(clsFechamentoCaixa.getOutras()), 160, 203);
    g2.setFont(new Font("SansSerif", Font.BOLD, 10));
    g2.drawString("SALDO:" ,10, 218);
    g2.drawString(""+clsaux.formato(clsFechamentoCaixa.getSaldofinal()) ,160, 218);
    g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
    g2.drawString("-------------------------------------------------------------", 1, 225);
    g2.drawString("Finalizadoras Apurada Sistema", 10, 230);
    int vlfin =clsFechamentoCaixa.finalizadoras.size();
    for (int i=0; i<vlfin;i++){
        g2.drawString(""+clsaux.retornaId(clsFechamentoCaixa.finalizadoras.get(i)), 10, indicecoluna);
        g2.drawString(""+clsaux.formataReais(clsaux.capturaValores(clsaux.retornaAposId(clsFechamentoCaixa.finalizadoras.get(i)))), 160, indicecoluna);
        indicecoluna=indicecoluna+12;
    }
    if(clsFechamentoCaixa.finalizadorasFechaCego.size()>0){
        g2.drawString("-------------------------------------------------------------", 1, indicecoluna-5);
        g2.drawString("Finalizadoras Inf Fechamento Cego", 10, indicecoluna);
        indicecoluna=indicecoluna+12;
        int vlfinCego =clsFechamentoCaixa.finalizadorasFechaCego.size();
        for (int i=0; i<vlfinCego;i++){
            obs=clsFechamentoCaixa.finalizadorasFechaCego.get(0).getObs();
            g2.drawString(""+clsaux.retornaId(clsFechamentoCaixa.finalizadorasFechaCego.get(i).getNomefinalizadora()), 10, indicecoluna);
            g2.drawString(""+clsaux.formataReais(clsFechamentoCaixa.finalizadorasFechaCego.get(i).getValor()), 160, indicecoluna);
            indicecoluna=indicecoluna+12;
        }
        }
    g2.drawString("-------------------------------------------------------------", 1, indicecoluna-5);
    
    if(clsFechamentoCaixa.getSuprimento().size()>0){
            g2.drawString("SUPRIMENTOS", 40, indicecoluna+3);
            indicecoluna=indicecoluna+12;
         for(clsSuprimentoSangria supri : clsFechamentoCaixa.getSuprimento()){
                g2.setFont(new Font("SansSerifw", Font.PLAIN, 10));
                g2.drawString(supri.getMotivo()+"", 10, indicecoluna);
                g2.drawString(""+clsaux.formataReais(supri.getValor()), 160, indicecoluna);
                g2.setFont(new Font("SansSerif", Font.PLAIN, 8));
                indicecoluna=indicecoluna+12;
    }
    }
     g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
     if(clsFechamentoCaixa.getSangria().size()>0){
         g2.drawString("-------------------------------------------------------------", 1, indicecoluna-4);
            g2.drawString("RETIRADAS", 10, indicecoluna+2);
            indicecoluna=indicecoluna+12;
         for(clsSuprimentoSangria supri : clsFechamentoCaixa.getSangria()){
              g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
                g2.drawString(supri.getMotivo()+"", 10, indicecoluna);
                g2.drawString(""+clsaux.formataReais(supri.getValor()), 160, indicecoluna);
                g2.setFont(new Font("SansSerif", Font.PLAIN, 7));
                indicecoluna=indicecoluna+12;
    }
         
   }
     if(clsFechamentoCaixa.outrasOrigens.size()>0){
            g2.drawString("-------------------------------------------------------------", 1, indicecoluna-4);
            g2.drawString("Outras Origens", 10, indicecoluna+2);
            indicecoluna=indicecoluna+12;
         for(clsSuprimentoSangria supri : clsFechamentoCaixa.getOutrasOrigens()){
              g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
                g2.drawString(supri.getMotivo()+"", 10, indicecoluna);
                g2.drawString(""+clsaux.formataReais(supri.getValor()), 160, indicecoluna);
                g2.setFont(new Font("SansSerif", Font.PLAIN, 7));
                indicecoluna=indicecoluna+12;
    }
         
         }
        if(obs!=null){
             g2.drawString("Observação", 10, indicecoluna);
             g2.drawString(""+clsFechamentoCaixa.finalizadorasFechaCego.get(0).getObs(), 10, indicecoluna+10);
         
     }
    return PAGE_EXISTS;
 }
   
 }

} 
  
