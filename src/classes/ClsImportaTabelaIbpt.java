/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.ncmDAO;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Mk Solucoes
 */
public class ClsImportaTabelaIbpt {
    
    public void importarTabela() throws IOException, BiffException{
        String caminho="c:/esfhera/adm/importacao/ibpt.xls";
        
        Workbook book= Workbook.getWorkbook(new File(caminho));
        
        Sheet sheet= book.getSheet(0);
        int tamanhoarquivo=sheet.getRows();
        ncmDAO dao = new ncmDAO();
        for (int i=0; i<tamanhoarquivo;i++){
             Cell codncm=sheet.getCell(0, i);
             Cell descricao=sheet.getCell(3,i);
             Cell impFereralNacional=sheet.getCell(4,i);
             Cell impFederealImpotado=sheet.getCell(5,i);
             Cell impEstadual=sheet.getCell(6,i);
             Cell impMunicipal=sheet.getCell(7,i);
             Cell inicioVigencia=sheet.getCell(8,i);
             Cell fimVigencia=sheet.getCell(9,i);
             
             dao.inserirNcmPorImportacao(codncm.getContents(), 
                     descricao.getContents(),
                     impFereralNacional.getContents(),
                     impFederealImpotado.getContents(),
                     impEstadual.getContents(),
                     impMunicipal.getContents(),
                     inicioVigencia.getContents(),
                     fimVigencia.getContents());
        
        }
        JOptionPane.showMessageDialog(null, "Importação Finalizada\nLinhas Processadas "+tamanhoarquivo);
    
    
    }
}
