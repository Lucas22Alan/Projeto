/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.CondicionalDAO;
import DAO.MovimentoContaDAO;
import DAO.lancDocumentDAO;
import DAO.orcamentoDAO;
import DAO.orderServicoDAO;
import model.clsLancDocCabecalho;

/**
 *
 * @author Mk Solucoes
 */
public class ClsCancelamentos {
    
    public void cancelarMovimentacaoReferente(String movimento){// processo responsavel por cancelar toda a movimentacao de uma nfe, apos o cancelamento da nf
        // cancelar tmovimento
        // cancelar titulo a receber ou pagar
        // cancelar origem movimento(orcamento,pedido de venda, ordem de servico)
        
        lancDocumentDAO ld= new lancDocumentDAO();
        clsLancDocCabecalho mov= new clsLancDocCabecalho();
        mov.setIdmovimento(movimento);
        mov=lancDocumentDAO.buscaCabecalhoDoc(mov);
        ld.deletar(mov.getIdmovimento());
        MovimentoContaDAO mv = new MovimentoContaDAO();
        mv.deletar(movimento, "2");
        System.out.println("tipo do movimento: "+mov.getMvtoOrigem()+"    id do movimento "+ mov.getOrigem());
        if(mov.getMvtoOrigem()!=null){
        
            if(mov.getMvtoOrigem().equals("2")){// cancelar reg condicional
                this.cancelaCondicionalPeloMovimento(mov.getOrigem());
            }else if (mov.getMvtoOrigem().equals("3")){// cancelar reg orcamento
                this.cancelaOrcamentoPeloMovimento(mov.getOrigem());
            }else if (mov.getMvtoOrigem().equals("4")){//cancelar reg ordem servico
                this.cancelaOrdemServicoPeloMovimento(mov.getOrigem());
            }
        }
     }
    
    public void cancelaOrcamentoPeloMovimento(String mvto){
        orcamentoDAO orAO= new orcamentoDAO();
        orAO.cancelarRegistro(mvto);
    }
    public void cancelaCondicionalPeloMovimento(String mvto){
        CondicionalDAO dao= new CondicionalDAO();
        dao.cancelaCondicional(mvto);
    }
    public void cancelaOrdemServicoPeloMovimento(String mvto){
        orderServicoDAO dao = new orderServicoDAO();
        dao.cancelarRegistro(mvto);
    }
    
    
    
}
