/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.clsConfigGeral;
import model.clsConfigPdv;
import classes.clsaux;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Tfinalizadoras;
import model.tparametros_financeiro;

/**
 *
 * @author Mk Solucoes
 */
public class configuracaoDAO {
    
    public clsConfigGeral buscarConfigGeral(clsConfigGeral conf){
      
        try {
            String sql="select * from tconfig";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            conf.setConsTiro(rs.getString("imprime_consumo_tiro"));
            conf.setCrediCliente(rs.getString("utiliza_credito_cliente"));
            conf.setFidelidade(rs.getString("fidelidade"));
            conf.setMesaFim(rs.getString("mesafim"));
            conf.setMesaIni(rs.getString("mesainicio"));
            conf.setPrecCategoria(rs.getString("usa_prec_cat_tiro"));
            conf.setDtinifdelidade(rs.getString("data_ini_fidelidade"));
            conf.setDtinventario(rs.getString("data_inventario"));
            conf.setDtmovcaixa(rs.getString("data_ini_mov_conta"));
            conf.setSerienfe(rs.getString("nfe_serie"));
            conf.setHamb(rs.getString("ambiente"));
            conf.setCaminhodll(rs.getString("dll_a3"));
            conf.setTipoCertificado(rs.getString("tipo_certificado"));
            conf.setMarca(rs.getString("marca_a3"));
            conf.setCertificado(rs.getString("caminho_certificado"));
            conf.setSenha(rs.getString("senha_certificado"));
            conf.setAtacarejo(rs.getString("utiliza_atacarejo"));
            conf.setCalculajuros(rs.getString("controla_juros"));
            conf.setPercJuros(rs.getDouble("perc_juros"));
            conf.setPercMulta(rs.getDouble("perc_multa"));
            conf.setCarencia(rs.getInt("carencia"));
            conf.setImpressaoCondicionalPadrao(rs.getString("imp_padrao_condi"));
            conf.setChavePix(rs.getString("chave"));
            conf.setClientid(rs.getString("client_id"));
            conf.setClientsecret(rs.getString("client_secret"));
            conf.setCadastroProdAutomatico(rs.getString("CADASTRAITEMAUTCOMPRA"));
            conf.setAssociacaoCompra(clsaux.trataCampoNuloConfig(rs.getString("tipo_associacao_compra")));
            conf.setIptef(rs.getString("IP_SERVIDOR_TEF"));
            conf.setCodlojatef(rs.getString("CODLOJA_TEF"));
            conf.setCaminhoxml(rs.getString("caminhoxml"));
            conf.setAmbinetepix(rs.getString("ambientepix"));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        return conf;
   }
    public List<clsConfigPdv> buscarPdvs(String idpdv){
        List<clsConfigPdv> lista= new ArrayList<>();
        try {
            String sql="select * from tconfigpdv";
            PreparedStatement ps= conexao.getPreparedStatement(sql);
            if(idpdv!="0"){
               
                sql="select * from tconfigpdv where idpdv=?";
                 ps= conexao.getPreparedStatement(sql);
                ps.setString(1, idpdv);
            }
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                clsConfigPdv pdv= new clsConfigPdv();
                
                pdv.setApenasComanda(rs.getString(16));
                pdv.setControlaEstoque(rs.getString(2));
                pdv.setCsc(rs.getString(17));
                pdv.setDigEtiqueta(rs.getString(10));
                pdv.setGerarMesa(rs.getString(12));
                pdv.setImpBar(rs.getString(7));
                pdv.setImpCoz(rs.getString(6));
                pdv.setImpCupom(rs.getString(8));
                pdv.setImpFichaCons(rs.getString(3));
                pdv.setPdv(rs.getString(1));
                pdv.setPortaBal(rs.getString(15));
                pdv.setSerie(rs.getString(19));
                pdv.setToke(rs.getString(18));
                pdv.setVendeEstZerado(rs.getString(4));
                pdv.setTextoFicha(rs.getString("titulo_ficha_consumo"));
                pdv.setPerguntaImpressao(rs.getString("solicita_impressao"));
                pdv.setGeraproducao(rs.getString("gera_producao_venda"));
                pdv.setObrigavendedor(rs.getString("obriga_vendedor"));
                pdv.setCancelafina(rs.getString("cancelafinalizadoraaut"));
                pdv.setIntegracaopix(rs.getString("integracao_pix"));
                pdv.setTipoimpressora(rs.getString("tipoimpressora"));
                pdv.setExibeEstoqueBusca(rs.getString("EXIBE_ESTOQUE_BUSCA"));
                pdv.setRodapecupom(rs.getString("rodapecupom"));
                pdv.setFechamentoCego(rs.getString("fechamento_cego"));
                pdv.setTipoLeituraBalanca(rs.getString("tipo_leitura_codigo_etiqueta"));
                pdv.setAlertaSonoro(clsaux.trataCampoNuloConfig(rs.getString("emitesom")));
                pdv.setTemtef(clsaux.trataCampoNuloConfig(rs.getString("usa_tef")));
                lista.add(pdv);
           }
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       return lista;
       
    
    }
    public List<String> buscarGrupoUsuario(){
         List<String> lista= new ArrayList<>();
        try {
           
            String sql="select * from tgrupo_usuario";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String inf;
                inf=rs.getString(1)+"- "+rs.getString(2);
                lista.add(inf);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public List<String> buscarPermissoes(){
         List<String> lista= new ArrayList<>();
        try {
           
            String sql="select * from tdados_permissao";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String inf;
                inf=rs.getString(1)+"-"+rs.getString(2);
                lista.add(inf);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public List<String> buscarPermissoesPorGrupo(String grupo){
         List<String> lista= new ArrayList<>();
        try {
           
            String sql="select * from tpermissao_gp_usuario where id_gp_usuario=? order by 1 asc";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, grupo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String inf;
                inf=rs.getString(1)+"- "+rs.getString(3);
                lista.add(inf);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void removerPermissao(String perm,String gp){
        try {
            String sql="delete from tpermissao_gp_usuario tp where tp.id_permissao=? and tp.id_gp_usuario=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, perm);
            ps.setString(2, gp);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    
    
    }
    public void inserirPermissao(String perm,String gp,String desc){
        try {
            String sql="UPDATE OR INSERT INTO TPERMISSAO_GP_USUARIO (ID_PERMISSAO, ID_GP_USUARIO, DESCRICAO, SISTEMA)\n" +
"                                     VALUES (?, ?, ?, '')\n" +
"                                   MATCHING (ID_PERMISSAO, ID_GP_USUARIO);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, perm);
            ps.setString(2, gp);
            ps.setString(3, desc);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    
    
    }
    public void inserirConfigGeral(clsConfigGeral conf){
        try {
            String sql="UPDATE OR INSERT INTO TCONFIG (FIDELIDADE, IMPRIME_CONSUMO_TIRO, DATA_INI_FIDELIDADE, UTILIZA_CREDITO_CLIENTE, DATA_INI_MOV_CONTA, USA_PREC_CAT_TIRO, MESAINICIO, MESAFIM,id,ambiente,nfe_serie,tipo_certificado"
                    + ",marca_a3,dll_a3,caminho_certificado,senha_certificado,controla_juros,perc_juros,perc_multa,carencia,imp_padrao_condi,client_id,client_secret,chave,utiliza_atacarejo,CADASTRAITEMAUTCOMPRA,tipo_associacao_compra,"
                    + " ip_servidor_tef,codloja_tef,caminhoxml,ambientepix)\n" +
                    "                       VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  MATCHING (ID) \n" +
                    "                     ";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, conf.getFidelidade());
            ps.setString(2, conf.getConsTiro());
            ps.setDate(3, clsaux.retornaData(conf.getDtinifdelidade()));
            ps.setString(4, conf.getCrediCliente());
            ps.setDate(5, clsaux.retornaData(conf.getDtmovcaixa()));
            ps.setString(6, conf.getPrecCategoria());
            ps.setString(7, conf.getMesaIni());
            ps.setString(8, conf.getMesaFim());
            ps.setInt(9, 1);
            ps.setString(10, conf.getHamb());
            ps.setString(11, conf.getSerienfe());
            ps.setString(12, conf.getTipoCertificado());
            ps.setString(13, conf.getMarca());
            ps.setString(14, conf.getCaminhodll());
            ps.setString(15, conf.getCertificado());
            ps.setString(16, conf.getSenha());
            ps.setString(17, conf.getContJuros());
            ps.setDouble(18, conf.getPercJuros());
            ps.setDouble(19, conf.getPercMulta());
            ps.setString(20,  clsaux.trataCampoNulo(conf.getCarencia()));
            ps.setString(21, conf.getImpressaoCondicionalPadrao());
            ps.setString(22, conf.getClientid());
            ps.setString(23, conf.getClientsecret());
            ps.setString(24, conf.getChavePix());
            ps.setString(25, conf.getAtacarejo());
            ps.setString(26, conf.getCadastroProdAutomatico());
            ps.setString(27, conf.getAssociacaoCompra());
            ps.setString(28, conf.getIptef());
            ps.setString(29, conf.getCodlojatef());
            ps.setString(30, conf.getCaminhoxml());
            ps.setString(31, conf.getAmbinetepix());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"Registro Gravado Com Sucesso ");
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void atualizarNumeroNfe(int numero){
        try {
            String sql="ALTER SEQUENCE GEN_TNOTAFISCAL_NUMERO RESTART WITH "+numero;
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public String buscarUltimaNfe(){
       String num="0";
        try {
            String sql="select GEN_ID(gen_tnotafiscal_numero, 0) FROM RDB$DATABASE;";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                num=rs.getString(1);
                
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    
    }
    public void inserirConfigPdv(clsConfigPdv conf){
        try {
            String sql="UPDATE OR INSERT INTO TCONFIGPDV (IDPDV, CONT_ESTOQUE_PDV, IMP_FICHA_CONSUMO, VENDE_EST0QUE_ZERADO, IMP_COZINHA, IMP_BAR, IMP_CUPOM, NUM_DIGITOS_ETIQUETA, "
                    + "GERA_MESA_AUTOMATICO, BAL_PORTA, APENAS_LANC_COMANDA, CSC, TOKEN, SERIE,titulo_ficha_consumo,solicita_impressao,gera_producao_venda,obriga_vendedor,cancelafinalizadoraaut,"
                    + "integracao_pix,tipoimpressora,exibe_estoque_busca,rodapecupom,fechamento_cego,tipo_leitura_codigo_etiqueta,emitesom,usa_tef)\n" +
"                          VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)\n" +
"                        MATCHING (IDPDV);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, conf.getPdv());
            ps.setString(2, conf.getControlaEstoque());
            ps.setString(3, conf.getImpFichaCons());
            ps.setString(4, conf.getVendeEstZerado());
            ps.setString(5, conf.getImpCoz());
            ps.setString(6, conf.getImpBar());
            ps.setString(7, conf.getImpCupom());
            ps.setString(8, conf.getDigEtiqueta());
            ps.setString(9, conf.getGerarMesa());
            ps.setString(10, conf.getPortaBal());
            ps.setString(11, conf.getApenasComanda());
            ps.setString(12, conf.getCsc());
            ps.setString(13, conf.getToke());
            ps.setString(14, conf.getSerie());
            ps.setString(15, conf.getTextoFicha());
            ps.setString(16, conf.getPerguntaImpressao());
            ps.setString(17, conf.getGeraproducao());
            ps.setString(18, conf.getObrigavendedor());
            ps.setString(19, conf.getCancelafina());
            ps.setString(20, conf.getIntegracaopix());
            ps.setString(21, conf.getTipoimpressora());
            ps.setString(22, conf.getExibeEstoqueBusca());
            ps.setString(23, conf.getRodapecupom());
            ps.setString(24, conf.getFechamentoCego());
            ps.setString(25, conf.getTipoLeituraBalanca());
            ps.setString(26, conf.getAlertaSonoro());
            ps.setString(27, conf.getTemtef());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"Registro Gravado Com Sucesso ");
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
 
     public void inseirFinalizadora(Tfinalizadoras fina){
        try {
            String sql="UPDATE OR INSERT INTO TFINALIZADORA (ID_FINALIZDORA, DESCRICAO, OBSERVACAO, PDV, RETAGUARDA, TROCO, TAXA_ADM, CONTA_MOV_SAI, CONTA_MOV_ENT, CONSIDERA_FLUXO_FINA,possui_condicao,condicao_padrao)\n" +
                    "                             VALUES (?,?,?,?,?,?,?,?,?,?,?,?)\n" +
                    "                           MATCHING (ID_FINALIZDORA);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, fina.getId());
            ps.setString(2, fina.getDescricao());
            ps.setString(3, fina.getObservacao());
            ps.setString(4, fina.getPdv());
            ps.setString(5, fina.getRetaguarda());
            ps.setString(6, fina.getTroco());
            ps.setDouble(7, fina.getTaxaadm());
            ps.setString(8, "");
            ps.setString(9, "");
            ps.setString(10, fina.getConsfluxo());
            ps.setString(11, fina.getValidaCondicao());
            ps.setString(12, fina.getCondicaoPadrao());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     }
     public Tfinalizadoras buscarFinalizadora(String idfina){
          Tfinalizadoras fina=new Tfinalizadoras();
        try {
            String sql="select * from tfinalizadora where id_finalizdora=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idfina);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                fina.setId(rs.getString(1));
                fina.setDescricao(rs.getString(2));
                fina.setObservacao(rs.getString(3));
                fina.setPdv(rs.getString(4));
                fina.setRetaguarda(rs.getString(5));
                fina.setTroco(rs.getString(6));
                fina.setTaxaadm(rs.getDouble(7));
                fina.setConsfluxo(rs.getString(10));
                fina.setCondicaoPadrao(rs.getString(12));
                fina.setValidaCondicao(clsaux.trataCampoNuloConfig(rs.getString(11)));
            }
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return fina;
         
     }
     public boolean inserirParametrosFinanceiro(tparametros_financeiro fin){
        boolean ret=false;
         try {
            String sql="UPDATE OR INSERT INTO TPARAMETROS_FINANCEIRO (ID, TP_PEDIDO, SB_PEDIDO, TP_ORCAMENTO, SB_ORCAMENTO, TP_CONDI, SB_CONDI, TP_ENTRADA, SB_ENTRADA, TP_CONF_CAIXA, SB_CONF_CAIXA, TP_TAXAS_FINANCEIRAS, SB_TAXAS_FINANCEIRAS)\n" +
                    "                                      VALUES (1, ?,?,?,?,?,?,?,?,?,?,?,?)\n" +
                    "                                    MATCHING (ID);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, fin.getTpPedido());
            ps.setString(2, fin.getSbPediso());
            ps.setString(3, fin.getTpOrcamento());
            ps.setString(4, fin.getSbOrcamento());
            ps.setString(5, fin.getTpCondi());
            ps.setString(6, fin.getSbCondi());
            ps.setString(7, fin.getTpEntrada());
            ps.setString(8, fin.getSbEntrada());
            ps.setString(9, fin.getTpConfCaixa());
            ps.setString(10, fin.getSbConfCaixa());
            ps.setString(11, fin.getTpTaxaFinanceira());
            ps.setString(12, fin.getSbTaxaFinanceira());
            ps.executeUpdate();
            ps.close();
            ret=true;
        } catch (SQLException ex) {
            Logger.getLogger(configuracaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return ret;
     }

     

}
