package model;

import java.sql.Date;


public class produtos {
    int  id;
    boolean preconovo=false;
    String precoold="";
    String nomecurto="",ativo="S",imprimeEtiqueta="N";
    String nomelongo="";
    String codi_barra="";
    String preco_venda;
    String margem;
    String preco_custo,custo_medio,custo_atual="";
    String ncm="";
    String sit_tributaria="";
    String cest="";
    String baixa_barra, fator, estoque_minimo, referencia,aliq_icms,pis_ent,pis_sai,unid_venda, grupo,subgrupo,setor,tipo="";
    String pesavel,balanca="";
    String pesagem_aut,imp_ficha,baixa_producao,temAtacarejo,temLocacao,precoVariado,impressoraProducao;
    Double preco_oferta=0.00;
    String comeco,fim,datavalidade;
    String urlImagem="",enviaCardapio="N",descritivoCardapio="";
    String observacao="";
    String ativoCardapio,idimagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPreconovo() {
        return preconovo;
    }

    public void setPreconovo(boolean preconovo) {
        this.preconovo = preconovo;
    }

    public String getPrecoold() {
        return precoold;
    }

    public void setPrecoold(String precoold) {
        this.precoold = precoold;
    }

    public String getNomecurto() {
        return nomecurto;
    }

    public void setNomecurto(String nomecurto) {
        this.nomecurto = nomecurto;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getImprimeEtiqueta() {
        return imprimeEtiqueta;
    }

    public void setImprimeEtiqueta(String imprimeEtiqueta) {
        this.imprimeEtiqueta = imprimeEtiqueta;
    }

    public String getNomelongo() {
        return nomelongo;
    }

    public void setNomelongo(String nomelongo) {
        this.nomelongo = nomelongo;
    }

    public String getCodi_barra() {
        return codi_barra;
    }

    public void setCodi_barra(String codi_barra) {
        this.codi_barra = codi_barra;
    }

    public String getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(String preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getMargem() {
        return margem;
    }

    public void setMargem(String margem) {
        this.margem = margem;
    }

    public String getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(String preco_custo) {
        this.preco_custo = preco_custo;
    }

    public String getCusto_medio() {
        return custo_medio;
    }

    public void setCusto_medio(String custo_medio) {
        this.custo_medio = custo_medio;
    }

    public String getCusto_atual() {
        return custo_atual;
    }

    public void setCusto_atual(String custo_atual) {
        this.custo_atual = custo_atual;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getSit_tributaria() {
        return sit_tributaria;
    }

    public void setSit_tributaria(String sit_tributaria) {
        this.sit_tributaria = sit_tributaria;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public String getBaixa_barra() {
        return baixa_barra;
    }

    public void setBaixa_barra(String baixa_barra) {
        this.baixa_barra = baixa_barra;
    }

    public String getFator() {
        return fator;
    }

    public void setFator(String fator) {
        this.fator = fator;
    }

    public String getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(String estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getAliq_icms() {
        return aliq_icms;
    }

    public void setAliq_icms(String aliq_icms) {
        this.aliq_icms = aliq_icms;
    }

    public String getPis_ent() {
        return pis_ent;
    }

    public void setPis_ent(String pis_ent) {
        this.pis_ent = pis_ent;
    }

    public String getPis_sai() {
        return pis_sai;
    }

    public void setPis_sai(String pis_sai) {
        this.pis_sai = pis_sai;
    }

    public String getUnid_venda() {
        return unid_venda;
    }

    public void setUnid_venda(String unid_venda) {
        this.unid_venda = unid_venda;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPesavel() {
        return pesavel;
    }

    public void setPesavel(String pesavel) {
        this.pesavel = pesavel;
    }

    public String getBalanca() {
        return balanca;
    }

    public void setBalanca(String balanca) {
        this.balanca = balanca;
    }

    public String getPesagem_aut() {
        return pesagem_aut;
    }

    public void setPesagem_aut(String pesagem_aut) {
        this.pesagem_aut = pesagem_aut;
    }

    public String getImp_ficha() {
        return imp_ficha;
    }

    public void setImp_ficha(String imp_ficha) {
        this.imp_ficha = imp_ficha;
    }

    public String getBaixa_producao() {
        return baixa_producao;
    }

    public void setBaixa_producao(String baixa_producao) {
        this.baixa_producao = baixa_producao;
    }

    public String getTemAtacarejo() {
        return temAtacarejo;
    }

    public void setTemAtacarejo(String temAtacarejo) {
        this.temAtacarejo = temAtacarejo;
    }

    public String getTemLocacao() {
        return temLocacao;
    }

    public void setTemLocacao(String temLocacao) {
        this.temLocacao = temLocacao;
    }

    public String getPrecoVariado() {
        return precoVariado;
    }

    public void setPrecoVariado(String precoVariado) {
        this.precoVariado = precoVariado;
    }

    public String getImpressoraProducao() {
        return impressoraProducao;
    }

    public void setImpressoraProducao(String impressoraProducao) {
        this.impressoraProducao = impressoraProducao;
    }

    public Double getPreco_oferta() {
        return preco_oferta;
    }

    public void setPreco_oferta(Double preco_oferta) {
        this.preco_oferta = preco_oferta;
    }

    public String getComeco() {
        return comeco;
    }

    public void setComeco(String comeco) {
        this.comeco = comeco;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getEnviaCardapio() {
        return enviaCardapio;
    }

    public void setEnviaCardapio(String enviaCardapio) {
        this.enviaCardapio = enviaCardapio;
    }

    public String getDescritivoCardapio() {
        return descritivoCardapio;
    }

    public void setDescritivoCardapio(String descritivoCardapio) {
        this.descritivoCardapio = descritivoCardapio;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getAtivoCardapio() {
        return ativoCardapio;
    }

    public void setAtivoCardapio(String ativoCardapio) {
        this.ativoCardapio = ativoCardapio;
    }

    public String getIdimagem() {
        return idimagem;
    }

    public void setIdimagem(String idimagem) {
        this.idimagem = idimagem;
    }
 

    

   
}
