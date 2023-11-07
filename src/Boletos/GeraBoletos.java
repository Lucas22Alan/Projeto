/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boletos;

import DAO.BoletoDAO;
import br.com.caelum.stella.boleto.*;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bancos;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import classes.ClsDadosBoleto;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import model.clsConfig;
import model.clsDadosEmpresa;
import model.clsEmpresa;

/**
 *
 * @author Mk Solucoes
 */
public class GeraBoletos {
    
    
    public void geraBoleto(String idtitulo) throws IOException{
        
        BoletoDAO bdao= new BoletoDAO();
        ClsDadosBoleto dado= bdao.buscaDadosBoleto(idtitulo);
        Datas dat= Datas.novasDatas().comDocumento(dado.getDatDocumento()).comProcessamento(dado.getDatProcessamento()).comVencimento(dado.getDatVencimento());
        Endereco endBeneficiario=Endereco.novoEndereco().comLogradouro(clsDadosEmpresa.getRua()+", "+clsDadosEmpresa.getNumero()).
                comBairro(clsDadosEmpresa.getBairro()).comCep(clsDadosEmpresa.getCep()).comCidade(clsDadosEmpresa.getCidade()).comUf(clsDadosEmpresa.getEstado());
        
        //emissor do boleto
        Beneficiario beneficiario= Beneficiario.novoBeneficiario().comNomeBeneficiario(clsDadosEmpresa.getRazao()).comAgencia(dado.getAgencia()).comDigitoAgencia(dado.getDigagencia())
                .comCodigoBeneficiario(dado.getCodigo()).comDigitoCodigoBeneficiario(dado.getDigcodigo()).comNumeroConvenio(dado.getConvenio()).comCarteira(dado.getCarteira())
                .comEndereco(endBeneficiario)
                .comNossoNumero(dado.getNumeroboleto());
        
        Endereco endPagador=Endereco.novoEndereco().comLogradouro(dado.getPagRua()).comBairro(dado.getPagBairro()).comCep(dado.getPagCep()).comCidade(dado.getPagCidade()).comUf(dado.getPagUf());
        
        Pagador pagador= Pagador.novoPagador().comNome(dado.getPagNome()).comDocumento(dado.getPagDoc()).comEndereco(endPagador);
        
        Banco banco = new Bradesco();
        
        
        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(dat)
                .comBeneficiario(beneficiario)
                .comPagador(pagador)
                .comValorBoleto(dado.getValor())
                .comNumeroDoDocumento(dado.getNumeroboleto())
                .comInstrucoes(dado.getInstucoes())
                .comLocaisDePagamento(dado.getLocais());
        
        GeradorDeBoleto gera= new GeradorDeBoleto(boleto);
        String arquivo="c:\\esfhera\\adm\\boletos\\pdf\\"+dado.getNumeroboleto()+".pdf";
        OutputStream outputStream = new FileOutputStream(new File(arquivo));
        gera.geraPDF(outputStream);
        outputStream.close();
        
        Desktop.getDesktop().open(new File(arquivo));
    
    }
    
    public void geraRemessaBoletoEnviaBanco(){
        BoletoDAO bdao= new BoletoDAO();
        List<Boleto> boletos= new ArrayList<>();
        List<ClsDadosBoleto> dados= bdao.buscaListaBoletosRemessa();
        
        for(ClsDadosBoleto bole:dados){
           Boleto boleto= Boleto.novoBoleto()
                   .comDatas(Datas.novasDatas().comDocumento(bole.getDatDocumento()).comProcessamento(bole.getDatProcessamento()).comVencimento(bole.getDatVencimento()))
                   .comBeneficiario(Beneficiario.novoBeneficiario().comNomeBeneficiario(clsDadosEmpresa.getRazao()).comAgencia(bole.getAgencia())
                           .comDigitoAgencia(bole.getDigagencia()).comCarteira(bole.getCarteira()).comCodigoBeneficiario(bole.getCodigo()).comDigitoCodigoBeneficiario(bole.getDigcodigo()))
                   .comPagador(Pagador.novoPagador().comNome(bole.getPagNome()).comDocumento(bole.getPagDoc()))
                   .comValorBoleto(bole.getValor())
                   .comNumeroDoDocumento(bole.getNumeroboleto())
                   .comInstrucoes(bole.getInstucoes())
                   .comLocaisDePagamento(bole.getLocais())
                   ;
           boletos.add(boleto);
        }
    
        BancoDoBrasil banco= new BancoDoBrasil();
        
      
    
    
    }
}
