/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author lucas
 */
public class clsConfig {
   public static String imprimeConsumo=null;
   public static String enviaapi=null;
   public static String usacreditocliente=null;
   public static String rateiadescontoitens=null;
   public static Date datainiciocontrolefinanceiro=null; 
   public static String localizaporcr=null;
   public static String precCatLanTiro=null; 
   public static int linhasCupomTiro=0; 
   public static String versao=null;
   public static Date validadeSistema=null;
   public static String usuarioLogado=null;
   public static clsConfigGeral configuracaogeral= new clsConfigGeral();
   public static tparametros_financeiro financeiro= new tparametros_financeiro();
}
