/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.ContasReceberDAO;
import DAO.MovimentoContaDAO;
import model.CadContasRecPagar;
import model.CadDocMovConta;
import model.clsConfig;
import model.clsDadosPagamentoAdm;
import model.tparametros_financeiro;


/**
 *
 * @author Mk Solucoes
 */
public class ClsInformaFinanceiro {
    
    
    //id do tipo vem como parametro para saber a origem do registro e para onde enviar o mesmo abaixo tabela com as ids
    // 1-conferencia de caixa, 2-movimentacao referente a taxa de cartao e outras taxas, 3- compra de mercadoria
    // 4- ref. ordem servico, 5-  ref. pedido de venda ou orcamento, 6 condicionais , 7- locacao de equipamentos
    
    
     public void trataTipoFinanceiro(clsDadosPagamentoAdm tipo){
        String idfinalizadora=tipo.getIdfinalizadora();
        if(idfinalizadora.equals("1")||idfinalizadora.equals("2")||idfinalizadora.equals("3")||idfinalizadora.equals("9")){
            this.gravaMovtoPagVista(tipo);
        }else if (idfinalizadora.equals("4")||idfinalizadora.equals("5")||idfinalizadora.equals("6")){
            this.gravaPagamentoPrazo(tipo);
       }        
    }
    
    
     private void gravaMovtoPagVista(clsDadosPagamentoAdm pagamento){
        MovimentoContaDAO mc= new MovimentoContaDAO();
        CadDocMovConta cadmc= new CadDocMovConta();
        cadmc.setIdconta("1");
        cadmc.setIdparceiro(pagamento.getParceiro());
        cadmc.setN_doc("");
        cadmc.setData_lancamento(clsaux.retornaData(clsaux.preencheData()));
        if(pagamento.getDirecao().equals("E")){
            cadmc.setEntrada(clsaux.capturaValor(clsaux.formato(pagamento.getVltotal())));
            cadmc.setSaida("0.00");
        }else{
            cadmc.setSaida(clsaux.capturaValor(clsaux.formato(pagamento.getVltotal())));
            cadmc.setEntrada("0.00");
        }
        
        switch(pagamento.getIdtipo()){
            case "1":    cadmc.setTipo_mov(clsConfig.financeiro.getTpConfCaixa());
                         cadmc.setSubtipo_mov(clsConfig.financeiro.getSbConfCaixa());
                         cadmc.setIdmov(pagamento.getMvto());
            break; 
            case "2": cadmc.setTipo_mov(clsConfig.financeiro.getTpTaxaFinanceira());
                         cadmc.setSubtipo_mov(clsConfig.financeiro.getSbTaxaFinanceira());
                         cadmc.setIdmov(pagamento.getMvto());
            break; 
             case "3": cadmc.setTipo_mov(clsConfig.financeiro.getTpEntrada());
                         cadmc.setSubtipo_mov(clsConfig.financeiro.getSbEntrada());
                         cadmc.setIdmov(pagamento.getMvto());
            break; 
             case "4": cadmc.setTipo_mov(clsConfig.financeiro.getTpPedido());
                         cadmc.setSubtipo_mov(clsConfig.financeiro.getSbPediso());
                         cadmc.setIdmov(pagamento.getIdos());
            break; 
             case "5": cadmc.setTipo_mov(clsConfig.financeiro.getTpPedido());
                         cadmc.setSubtipo_mov(clsConfig.financeiro.getSbPediso());
                         cadmc.setIdmov(pagamento.getIdpedido());
            break; 
             case "6": cadmc.setTipo_mov(clsConfig.financeiro.getTpCondi());
                         cadmc.setSubtipo_mov(clsConfig.financeiro.getSbCondi());
                         cadmc.setIdmov(pagamento.getIdcondicional());
            break; 
            case "7": cadmc.setTipo_mov(clsConfig.financeiro.getTpPedido());
                         cadmc.setSubtipo_mov(clsConfig.financeiro.getSbPediso());
                         cadmc.setIdmov(pagamento.getMvto());
            break;
            
            
        }
        cadmc.setData_venc("");
        cadmc.setIdfinalizadora(pagamento.getIdfinalizadora());
        cadmc.setObservacao("Rec. Ref. "+pagamento.getTipo()+": "+pagamento.getOrigem());
        cadmc.setDesc_mov("movimentacao automatica referente a "+pagamento.getTipo()+": "+pagamento.getOrigem());
        mc.inserir(cadmc);
    }
      
   
    
    private void gravaPagamentoPrazo(clsDadosPagamentoAdm pagamento){
        CadContasRecPagar cd = new CadContasRecPagar();
        ContasReceberDAO cr = new ContasReceberDAO();
        cd.setIdmovto(pagamento.getMvto());
        cd.setParceiro(pagamento.getParceiro());
        cd.setValor(clsaux.capturaValor(clsaux.formato(pagamento.getVltotal())));
        cd.setNumero(pagamento.getMvto());
        cd.setEmisao(clsaux.retornaData(clsaux.preencheData()));
        cd.setVencimento(clsaux.retornaData(pagamento.getDataVencimento()));
        cd.setEstadotitulo("4");
        cd.setTipo_titulo(pagamento.getIdfinalizadora());
        cd.setConta("1");
        cd.setHistorico("10");
        cd.setTipo("2");
        cd.setIdcontrato("0");
        cd.setBanco("1");
        cd.setVendedor("0");
        cd.setParcela("1");
        cd.setJuros("0.00");
        cd.setDesconto("0.00");
        cd.setSaldo(clsaux.capturaValor(clsaux.formato(pagamento.getVltotal())));
        cd.setTipofinanceiro(clsConfig.financeiro.getTpPedido());
        cd.setSubtipofinanceiro(clsConfig.financeiro.getSbPediso());
        cr.inserir(cd);
    }
    
}
