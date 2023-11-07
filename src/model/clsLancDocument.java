/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas
 */
public class clsLancDocument {
    String idproduto,quantidade,precovenda,total,desconto,acrescimo,numeroitem,unidade,barras,idmovto,importadoNfe,eanComer,qntComercial=null;
    String codfornecedor,descricaofornecedor,tiporeg,origem_produto,ncm,cest,cbenef=null;
    String cfop,cst,modbc,pis_cofins,cstipi=null;
    String base_icms,aliq_icms,valor_icms,base_st,valor_st,red_bc,
            base_pis,valor_pis,valor_cofins,aliq_pis,aliq_cofins,base_ipi,aliq_ipi,valor_ipi,valor_outras,valor_seguro,valor_frete,
            base_stretido,valor_stretido,subtotal,custo,fator="0.00";

    public String getQntComercial() {
        return qntComercial;
    }

    public void setQntComercial(String qntComercial) {
        this.qntComercial = qntComercial;
    }

    
     
    public String getEanComer() {
        return eanComer;
    }

    public void setEanComer(String eanComer) {
        this.eanComer = eanComer;
    }

    

    
    
    public String getFator() {
        return fator;
    }

    public void setFator(String fator) {
        this.fator = fator;
    }

    
    
    public String getImportadoNfe() {
        return importadoNfe;
    }

    public void setImportadoNfe(String importadoNfe) {
        this.importadoNfe = importadoNfe;
    }

    
    
    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    
    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    
    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public String getCbenef() {
        return cbenef;
    }

    public void setCbenef(String cbenef) {
        this.cbenef = cbenef;
    }

    
    
    
    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    
    
     public String getOrigem_produto() {
        return origem_produto;
    }

    public void setOrigem_produto(String origem_produto) {
        this.origem_produto = origem_produto;
    }
    public String getBase_stretido() {
        return base_stretido;
    }

    public void setBase_stretido(String base_stretido) {
        this.base_stretido = base_stretido;
    }

    public String getValor_stretido() {
        return valor_stretido;
    }

    public void setValor_stretido(String valor_stretido) {
        this.valor_stretido = valor_stretido;
    }

   

    
    
    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getModbc() {
        return modbc;
    }

    public void setModbc(String modbc) {
        this.modbc = modbc;
    }

    public String getPis_cofins() {
        return pis_cofins;
    }

    public void setPis_cofins(String pis_cofins) {
        this.pis_cofins = pis_cofins;
    }

    public String getCstipi() {
        return cstipi;
    }

    public void setCstipi(String cstipi) {
        this.cstipi = cstipi;
    }

    public String getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(String idproduto) {
        this.idproduto = idproduto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(String precovenda) {
        this.precovenda = precovenda;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(String acrescimo) {
        this.acrescimo = acrescimo;
    }

    public String getNumeroitem() {
        return numeroitem;
    }

    public void setNumeroitem(String numeroitem) {
        this.numeroitem = numeroitem;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getBarras() {
        return barras;
    }

    public void setBarras(String barras) {
        this.barras = barras;
    }

    public String getIdmovto() {
        return idmovto;
    }

    public void setIdmovto(String idmovto) {
        this.idmovto = idmovto;
    }

    public String getCodfornecedor() {
        return codfornecedor;
    }

    public void setCodfornecedor(String codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    public String getDescricaofornecedor() {
        return descricaofornecedor;
    }

    public void setDescricaofornecedor(String descricaofornecedor) {
        this.descricaofornecedor = descricaofornecedor;
    }

    public String getTiporeg() {
        return tiporeg;
    }

    public void setTiporeg(String tiporeg) {
        this.tiporeg = tiporeg;
    }

    public String getBase_icms() {
        return base_icms;
    }

    public void setBase_icms(String base_icms) {
        this.base_icms = base_icms;
    }

    public String getAliq_icms() {
        return aliq_icms;
    }

    public void setAliq_icms(String aliq_icms) {
        this.aliq_icms = aliq_icms;
    }

    public String getValor_icms() {
        return valor_icms;
    }

    public void setValor_icms(String valor_icms) {
        this.valor_icms = valor_icms;
    }

    public String getBase_st() {
        return base_st;
    }

    public void setBase_st(String base_st) {
        this.base_st = base_st;
    }

    public String getValor_st() {
        return valor_st;
    }

    public void setValor_st(String valor_st) {
        this.valor_st = valor_st;
    }

    public String getRed_bc() {
        return red_bc;
    }

    public void setRed_bc(String red_bc) {
        this.red_bc = red_bc;
    }

    public String getBase_pis() {
        return base_pis;
    }

    public void setBase_pis(String base_pis) {
        this.base_pis = base_pis;
    }

    public String getValor_pis() {
        return valor_pis;
    }

    public void setValor_pis(String valor_pis) {
        this.valor_pis = valor_pis;
    }

    public String getValor_cofins() {
        return valor_cofins;
    }

    public void setValor_cofins(String valor_cofins) {
        this.valor_cofins = valor_cofins;
    }

    public String getAliq_pis() {
        return aliq_pis;
    }

    public void setAliq_pis(String aliq_pis) {
        this.aliq_pis = aliq_pis;
    }

    public String getAliq_cofins() {
        return aliq_cofins;
    }

    public void setAliq_cofins(String aliq_cofins) {
        this.aliq_cofins = aliq_cofins;
    }

    public String getBase_ipi() {
        return base_ipi;
    }

    public void setBase_ipi(String base_ipi) {
        this.base_ipi = base_ipi;
    }

    public String getAliq_ipi() {
        return aliq_ipi;
    }

    public void setAliq_ipi(String aliq_ipi) {
        this.aliq_ipi = aliq_ipi;
    }

    public String getValor_ipi() {
        return valor_ipi;
    }

    public void setValor_ipi(String valor_ipi) {
        this.valor_ipi = valor_ipi;
    }

    public String getValor_outras() {
        return valor_outras;
    }

    public void setValor_outras(String valor_outras) {
        this.valor_outras = valor_outras;
    }

    public String getValor_seguro() {
        return valor_seguro;
    }

    public void setValor_seguro(String valor_seguro) {
        this.valor_seguro = valor_seguro;
    }

    public String getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(String valor_frete) {
        this.valor_frete = valor_frete;
    }

}
  