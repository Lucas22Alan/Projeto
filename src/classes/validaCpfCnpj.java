
package classes;


import grafic.interfac.Cadclientes;
import javax.swing.JOptionPane;

public class validaCpfCnpj {
   
   private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
   private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

   private static int calcularDigito(String str, int[] peso) {
      int soma = 0;
      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
         digito = Integer.parseInt(str.substring(indice,indice+1));
         soma += digito*peso[peso.length-str.length()+indice];
      }
      soma = 11 - soma % 11;
      return soma > 9 ? 0 : soma;
   }

   public static void isValidCPF(String cpf) {
      if ((cpf==null) || (cpf.length()!=11)) {JOptionPane.showMessageDialog(null, "preencha o campo cpf corretamente!!!");
      Cadclientes.txtCpfCnpj.requestFocus();}
      else{
      Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
      Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
      if(cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString())== false){
        JOptionPane.showMessageDialog(null, "Digito verificador incorreto!!!");
        Cadclientes.txtCpfCnpj.requestFocus();
      }
      }
      
   }

   public static void isValidCNPJ(String cnpj) {
      if ((cnpj==null)||(cnpj.length()!=14)) {JOptionPane.showMessageDialog(null, "preencha o campo cnpj corretamente!!!");
      Cadclientes.txtCpfCnpj.requestFocus();}
      else {
      Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
      Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
      if(cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString())==false){
         JOptionPane.showMessageDialog(null, "Digito verificador incorreto!!!");
         Cadclientes.txtCpfCnpj.requestFocus();
      }
      }
   }

   public static void main(String[] args) {
     
   }
}
    

