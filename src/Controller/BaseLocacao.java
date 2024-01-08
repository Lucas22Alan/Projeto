/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BaseGeralDAO;
import DAO.LocacaoDAO;
import DAO.produtoDAO;
import classes.clsaux;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Tcat_precos;
import model.Tfatura_locacao;
import model.Titens_locacao;
import model.Tlocacao;
import model.Torigem_fatura;

/**
 *
 * @author Mk Solucoes
 */
public class BaseLocacao {
    LocacaoDAO dao = new LocacaoDAO();
    
    public Boolean geraFatura(List<String> locacao, String datafim){
        // recebe uma lista de locacao, ai pega os itens referente a todas as locacoes, depois gera a fatura com o periodo,
        // no periodo pega a ultima data de geracao de fatura, se nao foi gerado nenhuma ele pega a data de retirada do item
        // calculando com o tipo de locacao
        boolean ret=false;
        List<Titens_locacao> itens= new ArrayList<>();
        
        for(String loc:locacao){
            for(Titens_locacao item: dao.retornaItensLocacao(loc)){
                if(clsaux.retornaId(item.getEstado()).equals("19")){
                    itens.add(item);
                }
            }
        }
        
        if(itens.size()>0){
            verificaUltimaFaturaItem(itens,datafim);
            JOptionPane.showMessageDialog(null, "Fatura Gerada Com Sucesso!!!");
        }else{
            JOptionPane.showMessageDialog(null, "Atenção Sem Itens Para Gerar Fatura!!!");
           
        }
         ret=true;
        return ret;
    }
    public Boolean geraFaturaDadosOri(String locacao){
        // recebe uma lista de locacao, ai pega os itens referente a todas as locacoes, depois gera a fatura com o periodo,
        // no periodo pega a ultima data de geracao de fatura, se nao foi gerado nenhuma ele pega a data de retirada do item
        // calculando com o tipo de locacao
        boolean ret=false;
        List<Titens_locacao> itens= new ArrayList<>();
        
        for(Titens_locacao item: dao.retornaItensLocacao(locacao)){
               itens.add(item);
                
            }
        if(itens.size()>0){
            Double total=0.00;
            String idFatura=new BaseGeralDAO().gerarIds("GEN_TFATURA_LOCACAO_ID");
              for(Titens_locacao item:itens){
                if(item.getDevolucao()==null){
                    item.setDevolucao(item.getRetirada());
                }
                total=total+item.getTotal();
                // insere registros da fatura
                Torigem_fatura fat= new Torigem_fatura();
                fat.setItem(item);
                fat.setIdfatura(idFatura);
                fat.setDatafim(item.getDevolucao());
                fat.setDatainicio(item.getRetirada());
                fat.setTipo(item.getTipo());
                fat.setPeriodo(item.getQntunitaria());
                fat.setValor(item.getValor());
                fat.setTotal(item.getTotal());
                dao.InserirOrigemFatura(fat);
                dao.insereLinkFaturaLocacao(idFatura, item.getIdlocacao());
              }
                Tfatura_locacao fat= new Tfatura_locacao();
                fat.setIdfatura(idFatura);
                fat.setPago("N");
                fat.setTotal(total);
                dao.InsereFatura(fat);
           JOptionPane.showMessageDialog(null, "Fatura Gerada Com Sucesso !");
        }else{
            JOptionPane.showMessageDialog(null, "Atenção Sem Itens Para Gerar Fatura!!!");
           
        }
         ret=true;
        return ret;
    }
    public void verificaUltimaFaturaItem(List<Titens_locacao> itens,String dtfinal){
        // aqui verifica todos os itens do array, se ja tem fatura se nao tiver vai gerar a partir da data de retirada
        String dataFatura=null;
        Double total=0.00;
        String idFatura=new BaseGeralDAO().gerarIds("GEN_TFATURA_LOCACAO_ID");
        for(Titens_locacao item:itens){
            dataFatura=dao.verificaUltimaFatura(item.getIdlocacao(), item.getIditem());
            if(dataFatura==null){
                dataFatura=item.getRetirada();
            }
            total=total+realizaCalculoPeriodo(item, dataFatura, dtfinal,idFatura);
        }
        Tfatura_locacao fat= new Tfatura_locacao();
        fat.setIdfatura(idFatura);
        fat.setPago("N");
        fat.setTotal(total);
        dao.InsereFatura(fat);
    }
    
    private Double realizaCalculoPeriodo(Titens_locacao item,String inicio,String fim,String idfat){
        int periodo=clsaux.calcularDiferencaDatas(inicio, fim);
        Double periodogerado=0.00;
        Double valor=item.getValor();
        Double total=0.00;
        String cobranca=item.getTipo();
        List<Tcat_precos> categorias= new produtoDAO().RetornaPrecoCategoriaPorProduto(item.getCodigoitem());
        Tcat_precos cate = null;
        
        if(periodo>5 &&periodo <15){
             cate= localizaCategoria(categorias, "Semanal", cate);
             
             periodogerado=Double.parseDouble(String.valueOf(periodo))/7;
        }else if (periodo>14 && periodo<29){
            cate= localizaCategoria(categorias, "Quinzenal", cate);
           
            periodogerado=Double.parseDouble(String.valueOf(periodo))/15;
        }else if(periodo>28){
            cate= localizaCategoria(categorias, "Mensal", cate);
            
          //  periodogerado=Double.parseDouble(String.valueOf(periodo))/30;
          periodogerado=1.00;
        }else if(periodo<6){
            cate= localizaCategoria(categorias, "Diaria", cate);
            
            periodogerado=Double.parseDouble(String.valueOf(periodo));
        }
        
        if(cate==null){
                cate= new Tcat_precos();
                cate.setPreco(valor);
                cate.setIdcategoria(clsaux.retornaId(item.getTipo()));
                cate.setCategoria(clsaux.retornaAposId(item.getTipo()));
                periodogerado=item.getQntdias();
        }
            Torigem_fatura fat= new Torigem_fatura();
            fat.setItem(item);
            fat.setIdfatura(idfat);
            fat.setDatafim(fim);
            fat.setDatainicio(inicio);
            fat.setTipo(cate.getIdcategoria()+"-"+cate.getCategoria());
            fat.setPeriodo(periodogerado);
            fat.setValor(cate.getPreco());
            fat.setTotal((cate.getPreco()*item.getQntpecas())*periodogerado);
            dao.InserirOrigemFatura(fat);
            total=fat.getTotal();
            dao.insereLinkFaturaLocacao(idfat, item.getIdlocacao());
        
        return total;
    }
    
    private Tcat_precos localizaCategoria(List<Tcat_precos> catego,String tipoperiodo,Tcat_precos cate){
        for(Tcat_precos cat : catego){
            if(cat.getCategoria().equals(tipoperiodo)){
                cate=cat;
            }
        }
        return cate;
    }
    
    public void calculaValoresLocacoes(){
        List<Tlocacao> locacoesPendentes= new ArrayList<>();
        locacoesPendentes= dao.retornaLocacoes("19");//pego todas as locacoes pendentes
        for(Tlocacao locac:locacoesPendentes){
            calculaTotalLocacao(locac);
            
        }
        
    }
    
    private void calculaTotalLocacao(Tlocacao loc){
        Double total=0.00;
        List<Titens_locacao> itens= dao.retornaItensLocacao(loc.getId());
        for(Titens_locacao it:itens){
            if(it.getDevolucao()==null){
                it.setTotal(retornaValorBruto(it, clsaux.retornaDataRemoveHr(it.getRetirada()), clsaux.preencheData()));
            }else{
                it.setTotal(retornaValorBruto(it, clsaux.retornaDataRemoveHr(it.getRetirada()), clsaux.retornaDataRemoveHr(it.getDevolucao())));
            }
            if(clsaux.retornaId(it.getEstado()).equals("19")){
                 dao.inserirItemLocacao(it);
            }
            total=total+it.getTotal();
           
        }
        loc.setSubtotal(total);
        loc.setFaturado(dao.retornaValorFaturadoLocacao(loc.getId()));
        loc.setTotal(total-loc.getFaturado());
        dao.gravarLocacao(loc);
    }
    
    private double retornaValorBruto(Titens_locacao item,String inicio,String fim){
        int periodo=clsaux.calcularDiferencaDatas(inicio, fim);
        Double periodogerado=0.00;
        Double valor=item.getValor();
        Double total=0.00;
        String cobranca=item.getTipo();
        List<Tcat_precos> categorias= new produtoDAO().RetornaPrecoCategoriaPorProduto(item.getCodigoitem());
        Tcat_precos cate = null;
        
        if(periodo>5 &&periodo <15){
             cate= localizaCategoria(categorias, "Semanal", cate);
             
             periodogerado=Double.parseDouble(String.valueOf(periodo))/7;
        }else if (periodo>14 && periodo<29){
            cate= localizaCategoria(categorias, "Quinzenal", cate);
           
            periodogerado=Double.parseDouble(String.valueOf(periodo))/15;
        }else if(periodo>28){
            cate= localizaCategoria(categorias, "Mensal", cate);
            
            //periodogerado=Double.parseDouble(String.valueOf(periodo))/30;
            periodogerado=1.00;
        }else if(periodo<6){
            cate= localizaCategoria(categorias, "Diaria", cate);
            
            periodogerado=Double.parseDouble(String.valueOf(periodo));
        }
        
        if(cate==null);
        else{
            total=periodo*cate.getPreco();
            total=total*item.getQntpecas();
            
        }
        return total;
    }
    
    
}
