/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.tfechamento_cego;

/**
 *
 * @author Lucas
 */
public class clsFechamentoCaixa {
    public static Double vendabruta,vendaliquida,retiradas, suprimentos,cancelamentos,saldoinicial,saldofinal,outras=null;
    public static ArrayList<String> finalizadoras=new ArrayList<>();
    public static List<tfechamento_cego> finalizadorasFechaCego=new ArrayList<>();
    public static String databertura ,datafecha="",operador;
    public static String hraber,hrfecha="";
    public static List<clsSuprimentoSangria> suprimento= new ArrayList<>();
    public static List<clsSuprimentoSangria> sangria= new ArrayList<>();
    public static List<clsSuprimentoSangria> outrasOrigens= new ArrayList<>();

    public static List<tfechamento_cego> getFinalizadorasFechaCego() {
        return finalizadorasFechaCego;
    }

    public static void setFinalizadorasFechaCego(List<tfechamento_cego> finalizadorasFechaCego) {
        clsFechamentoCaixa.finalizadorasFechaCego = finalizadorasFechaCego;
    }

    
    public static Double getOutras() {
        return outras;
    }

    public static void setOutras(Double outras) {
        clsFechamentoCaixa.outras = outras;
    }

    
    
    public static List<clsSuprimentoSangria> getOutrasOrigens() {
        return outrasOrigens;
    }

    public static void setOutrasOrigens(List<clsSuprimentoSangria> outrasOrigens) {
        clsFechamentoCaixa.outrasOrigens = outrasOrigens;
    }

    
    
    public static String getOperador() {
        return operador;
    }

    public static void setOperador(String operador) {
        clsFechamentoCaixa.operador = operador;
    }

    
    
    public static String getDatabertura() {
        return databertura;
    }

    public static void setDatabertura(String databertura) {
        clsFechamentoCaixa.databertura = databertura;
    }

    public static String getDatafecha() {
        return datafecha;
    }

    public static void setDatafecha(String datafecha) {
        clsFechamentoCaixa.datafecha = datafecha;
    }

    

    public static String getHraber() {
        return hraber;
    }

    public static void setHraber(String hraber) {
        clsFechamentoCaixa.hraber = hraber;
    }

    public static String getHrfecha() {
        return hrfecha;
    }

    public static void setHrfecha(String hrfecha) {
        clsFechamentoCaixa.hrfecha = hrfecha;
    }
    
    

    public static Double getSaldofinal() {
        return saldofinal;
    }

    public static void setSaldofinal(Double saldofinal) {
        clsFechamentoCaixa.saldofinal = saldofinal;
    }

    
    
    public static Double getCancelamentos() {
        return cancelamentos;
    }

    public static void setCancelamentos(Double cancelamentos) {
        clsFechamentoCaixa.cancelamentos = cancelamentos;
    }

    public static Double getSaldoinicial() {
        return saldoinicial;
    }

    public static void setSaldoinicial(Double saldoinicial) {
        clsFechamentoCaixa.saldoinicial = saldoinicial;
    }

    
    
    public static List<clsSuprimentoSangria> getSuprimento() {
        return suprimento;
    }

    public static void setSuprimento(List<clsSuprimentoSangria> suprimento) {
        clsFechamentoCaixa.suprimento = suprimento;
    }

    public static List<clsSuprimentoSangria> getSangria() {
        return sangria;
    }

    public static void setSangria(List<clsSuprimentoSangria> sangria) {
        clsFechamentoCaixa.sangria = sangria;
    }

    
    
    public static Double getVendabruta() {
        return vendabruta;
    }

    public static void setVendabruta(Double vendabruta) {
        clsFechamentoCaixa.vendabruta = vendabruta;
    }

    public static Double getVendaliquida() {
        return vendaliquida;
    }

    public static void setVendaliquida(Double vendaliquida) {
        clsFechamentoCaixa.vendaliquida = vendaliquida;
    }

    public static Double getRetiradas() {
        return retiradas;
    }

    public static void setRetiradas(Double retiradas) {
        clsFechamentoCaixa.retiradas = retiradas;
    }

    public static Double getSuprimentos() {
        return suprimentos;
    }

    public static void setSuprimentos(Double suprimentos) {
        clsFechamentoCaixa.suprimentos = suprimentos;
    }

    public static ArrayList<String> getFinalizadoras() {
        return finalizadoras;
    }

    public static void setFinalizadoras(ArrayList<String> finalizadoras) {
        clsFechamentoCaixa.finalizadoras = finalizadoras;
    }

   

   

   
    
}
