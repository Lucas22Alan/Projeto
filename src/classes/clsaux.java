
package classes;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import titulos.FormContasPagarReceber;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;


public class clsaux {
    public static Double capturaValores(String dados) {
    	 Double retorno=0.00;
    	 String inter=null;
    	// Double retornocerto=0.00;
    	try {
    		retorno= Double.parseDouble(dados.replaceAll(",", "."));
    		inter=String.format("%.3f", retorno);
    		retorno=Double.parseDouble(inter.replaceAll(",", "."));
		}catch(Exception ep) {
			retorno=0.00;
			System.out.println(ep.getMessage());
			
		}
    	return retorno;
    }
    public static String formataReais(Double f){
        String valorformatado= new DecimalFormat("#,##0.00").format(f);
        return valorformatado;
    }
    public static String capturaValor(String dados) {
    	String inter=null;
    	try {
            inter= dados.replaceAll(",", ".");
	}catch(Exception ep) {
            inter="0.00";
	}
    	return inter;
    }
    public static java.sql.Date retornaData(String dataoriginal){
        java.sql.Date datafinal = null;
        try {
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            Date dat=null;
            dat=format.parse(dataoriginal);
            java.util.Date dataori=dat;
            datafinal= new java.sql.Date(dataori.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FormContasPagarReceber.class.getName()).log(Level.SEVERE, null, ex);
            datafinal=null;
        }  catch ( NullPointerException nu){
            datafinal=null;
        }
        return datafinal;
    }
    
    public static Timestamp retornaDataHora(String dataori){
        Timestamp timestamp = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            java.util.Date parsedDate = dateFormat.parse(dataori);
            timestamp = new Timestamp(parsedDate.getTime());
           
        } catch (ParseException ex) {
            Logger.getLogger(clsaux.class.getName()).log(Level.SEVERE, null, ex);
            timestamp=null;
        }catch ( NullPointerException nu){
            timestamp=null;
        }
         return timestamp;
    }
    public static String convertDataExib(String dat){
        Date dt= new Date();
        String dtf=null;
        try {
            SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");            
             dt= form.parse(dat);
             form.applyPattern("dd/MM/yyyy");
             dtf=form.format(dt);
        } catch (ParseException ex) {
            Logger.getLogger(clsaux.class.getName()).log(Level.SEVERE, null, ex);
        } catch ( NullPointerException nu){
            dtf="00/00/0000";
        }
        return dtf;
    }
    
    
    public static String convertDataExib(Date dat){
        Date dt= new Date();
        String dtf=null;
        try {
            SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd");            
             dt= form.parse(dat.toString());
             form.applyPattern("dd/MM/yyyy");
             dtf=form.format(dt);
        } catch (ParseException ex) {
            Logger.getLogger(clsaux.class.getName()).log(Level.SEVERE, null, ex);
        } catch ( NullPointerException nu){
            dtf="00/00/0000";
        }
        return dtf;
    }
    
    
    
    public static String convertDataHoraExib(String dat){
        Date dt= new Date();
        String dtf=null;
        try {
             SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");            
             dt= form.parse(dat);
             form.applyPattern("dd/MM/yyyy HH:mm");
             dtf=form.format(dt);
        } catch (ParseException ex) {
            Logger.getLogger(clsaux.class.getName()).log(Level.SEVERE, null, ex);
        } catch ( NullPointerException nu){
            dtf=null;
        }
        return dtf;
    }
    public static String retornaId(String valororiginal){
        String valorcerto=null;
        try{
        String [] valorseparar = valororiginal.split("-");
        valorcerto= valorseparar[0];
        } catch (NullPointerException nu){
            valorcerto="0";
        }
        return valorcerto;
    }
    public static String retornaId(Object valororiginal){
        String valorcerto=null;
        try{
            String [] valorseparar = valororiginal.toString().split("-");
            valorcerto= valorseparar[0];
        } catch (NullPointerException nu){
            valorcerto="0";
        }
        return valorcerto;
    }
    public static String retornaAposId(String valorori){
        String [] valorseparar = valorori.split("-");
        String valorcerto= valorseparar[1];
        return valorcerto;
    }
    public static String formato (Double f){
        String  retorno=null;
        try{
            retorno= String.format("%.2f", f);
        }catch(NullPointerException nu){
            retorno="0,00";
        }
        return retorno;
    }
    
    public static String formatoNfe (Double f){
        String  retorno="0.00";
        try{
            retorno= String.format("%.2f", f).replace(",", ".");
        }catch(NullPointerException nu){
            retorno="0.00";
        }
        return retorno;
    }
     public static String formatoNfe3 (Double f){
        String  retorno="0.000";
        try{
            retorno= String.format("%.3f", f).replace(",", ".");
        }catch(NullPointerException nu){
            retorno="0.000";
        }
        return retorno;
    }
     public static String formato3(Double f){
        String  retorno=null;
        try{
            retorno= String.format("%.3f", f);
        }catch(NullPointerException nu){
            retorno="0,00";
        }
        return retorno;
    }
    public static String formato4 (Double f){
        String  retorno=null;
        try{
            retorno= String.format("%.4f", f);
        }catch(NullPointerException nu){
            retorno="0,00";
        }
        return retorno;
    }
    public static String preencheData(){
            Calendar cd= Calendar.getInstance();
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            String retornodata=ft.format(cd.getTime());
            return retornodata;
    }
     public static String retorDataHoraBarra(){
            Calendar cd= Calendar.getInstance();
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String retornodata=ft.format(cd.getTime());
            return retornodata;
    }
     
    public static String retorDataHora(){
            Calendar cd= Calendar.getInstance();
            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
            String retornodata=ft.format(cd.getTime());
            return retornodata;
    }
     public static String retornaHoraAtual(){
            Calendar cd= Calendar.getInstance();
            String hora=String.format("%02d", cd.get(Calendar.HOUR_OF_DAY));
            String minutos=String.format("%02d", cd.get(Calendar.MINUTE));
            String segundos=String.format("%02d", cd.get(Calendar.SECOND));
            String retornodata=hora+":"+minutos+":"+segundos;
            return retornodata;
    }
        
    public static String retornaMes(){
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        Date dt=null;
        try {
            dt = ft.parse(clsaux.preencheData());
        } catch (ParseException ex) {
            Logger.getLogger(clsaux.class.getName()).log(Level.SEVERE, null, ex);
        }
        DateFormat ft2 = new SimpleDateFormat("MMMMM",new Locale("pt","BR"));
        String datfinal=ft2.format(dt);
        return datfinal;
    }
    public static String retornaAno(){
        Calendar cd = Calendar.getInstance();
        int ano = cd.get(Calendar.YEAR);
        String anofinal= String.valueOf(ano);
        return anofinal;
    }
    public static String retornaDia(){
        Calendar cl = Calendar.getInstance();
        int dia = cl.get(Calendar.DATE);
        String diafinal=String.valueOf(dia);
        return diafinal;
    }
    public static String retornaUltimoDiaMes(){
        String data="";
        Calendar cd=Calendar.getInstance();
        cd.set(Calendar.DAY_OF_MONTH, cd.getActualMaximum( Calendar.DAY_OF_MONTH));
        
        data= new SimpleDateFormat("dd/MM/yyyy").format(cd.getTime());
        return data;
    
    }
     public static String retornaPrimeiroDiaMes(){
        String data="";
        Calendar cd=Calendar.getInstance();
        cd.set(Calendar.DAY_OF_MONTH, cd.getActualMinimum(Calendar.DAY_OF_MONTH));
        
        data= new SimpleDateFormat("dd/MM/yyyy").format(cd.getTime());
        return data;
    
    }
    public static String calcularDataVencimento(int dia){
       String ret="";
        try{
            Calendar cl = Calendar.getInstance();
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            cl.add(Calendar.DAY_OF_YEAR, dia);
            ret=ft.format(cl.getTime());
       }catch(Exception ep){
           ret=clsaux.preencheData();
       }
        
        return ret;
      
    }
    public static String calcularData(int dia,Date dataoriginal){
       Calendar cl = Calendar.getInstance();
       cl.setTime(dataoriginal);
       SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
       cl.add(Calendar.DAY_OF_YEAR, dia);
       return ft.format(cl.getTime());
    }
    public static Calendar retornaDataCalendar(Date dat){
        Calendar cal= Calendar.getInstance();
        cal.setTime(dat);
        return cal;   
    
    }
    public static Boolean verificaNulo(String campo){
        Boolean ret=false;
        if(campo.equals("")||campo.trim().equals("")||campo.isEmpty()){
            ret=true;
        }
     return ret;
    }
    public static String trataCampoNulo(Object ob){
        String ret="0";
        try{
            ret=ob.toString();
        } catch (NullPointerException nu){
            ret="0";
        }
        return ret;
    }
     public static String trataCampoNuloConfig(Object ob){
        String ret="N";
        try{
            ret=ob.toString();
        } catch (NullPointerException nu){
            ret="N";
        }
        return ret;
    }

     public static String retornaDataUTC(String value) {
		Date dt=null;
		String formatado=null;
		SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		try {
			dt= ft.parse(value);
			ft.applyPattern("dd/MM/yyyy");
			formatado=ft.format(dt);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formatado;
	}
      public static String retornaDataRemoveHr(String value) {
		Date dt=null;
		String formatado=null;
		SimpleDateFormat ft= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			dt= ft.parse(value);
			ft.applyPattern("dd/MM/yyyy");
			formatado=ft.format(dt);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formatado;
	}

      public static String retornaDataSemHora(String value) {
		Date dt=null;
		String formatado=null;
		SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			dt= ft.parse(value);
			ft.applyPattern("dd/MM/yyyy");
			formatado=ft.format(dt);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formatado;
	}
     
      public static void carregaComboBox(JComboBox campo,String dado){
      try{
        for (int i=0; i<campo.getItemCount(); i++){
            if (dado.trim().equals(clsaux.retornaId(campo.getItemAt(i).toString()).trim())){
                campo.setSelectedIndex(i);
            }
        }
          }catch(Exception e){
              Logs.gravarLog.gravaSemMensagem(e.getMessage());
              campo.setSelectedIndex(0);
          }
    }
      
      public static int calcularDiferencaDatas(String ini, String fim){
          int dias=0;  
          try {
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date data1 = sdf.parse(ini);
                Date data2 =sdf.parse(fim);
                
                long seg=(data2.getTime()-data1.getTime());
                dias = (int) (seg/86400000L);
                
            } catch (ParseException ex ) {
                Logger.getLogger(clsaux.class.getName()).log(Level.SEVERE, null, ex);
            }
            return dias;
      }
      
      public static String remMascaraNumeros(String cpf){
          String ret="";
          ret=cpf.replaceAll("[^0-9]", "");
          return ret;
      }
      
      public static String adcMascaraCpf(String cpf){
        
         StringBuilder ret = new StringBuilder(cpf);
         try{
            ret.insert(3, ".");
            ret.insert(7, ".");
            ret.insert(11, "-");
         }catch(Exception ee){
             
         }
            return ret.toString();
      
      }
      public static String adcMascaraCnpj(String cnpj){
           StringBuilder ret = new StringBuilder(cnpj);
            ret.insert(2, ".");
            ret.insert(6, ".");
            ret.insert(10, "/");
            ret.insert(15, "-");

        
          return ret.toString();
      }
}
