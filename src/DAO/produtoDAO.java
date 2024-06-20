package DAO;

import model.Unidades;
import model.clsItemComposicao;
import classes.clsLocalizaProduto;
import classes.clsaux;
import model.produtos;
import conexoes.conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Tcat_precos;
import model.Tprecos;
import model.clsConfig;
import model.clsDadosEstoque;
import model.clsLancDocument;
import model.tprecos_atacarejo;

public class produtoDAO {
    public produtoDAO(){
    }
    
    
    
    public String Inserir(produtos produto){
        if(produto.getCodi_barra().equals("00000000000000")){
            JOptionPane.showMessageDialog(null, "Atenção produto com codigo de barras invalido, registro não será gravado!");
            return "0";
        }else{
        
        String idproduto="0";
        String sql="insert into tprodutos(id,nomelongo, nomecurto,unid_venda, excluido,id_grupo,pontos_retira, pontos_validos,tipo_produto,imp_ficha_ind,ativo,id_subgrupo,id_setor,baixa_producao_venda,imprime_etiqueta,data_cadastro,data_alterado, "
                + "possui_atacarejo,locacao,preco_variavel,impressora_producao,tem_adicional,tem_pizza,urlimagem,enviacardapio,descritivocardapio,observacao,linkimg,ativocardapio)"
                + " values (gen_id(GEN_TPRODUTOS_ID,1),?,?,?,?,?,?,?,?,?,'S',?,?,?,?,current_date,current_date,?,?,?,?,?,?,?,?,?,?,?,?);";
        String sqlprecos="insert into tprecos(id, preco_venda, margem, preco_custo, ncm, sit_tributaria, cest, cfop,pis_entrada"
                + ", pis_saida, aliq_icms,custo_atual,custo_medio,preco_oferta,inicio_oferta,fim_oferta)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";      
        String sqlbarras="UPDATE OR INSERT into tbarras(id_produto,codigo_barras, baixa_barra, fator, estoque_minimo, referencia,pesavel,id_balanca,leitura_aut_pdv,data_validade)"
                + "values (?,?,?,?,?,?,?,?,?,?)  MATCHING (codigo_barras)";
        
        String sqlidprod="select GEN_ID(gen_tprodutos_id, 0) FROM RDB$DATABASE;";
                  
        PreparedStatement pstcadpro= conexao.getPreparedStatement(sql);
       
        try {
            
            pstcadpro.setString(1, produto.getNomelongo());
            pstcadpro.setString(2, produto.getNomecurto());
            pstcadpro.setString(3, produto.getUnid_venda());
            pstcadpro.setString(4, "N");
            pstcadpro.setString(5, produto.getGrupo());
            pstcadpro.setString(6, "0");
            pstcadpro.setString(7, "0");
            pstcadpro.setString(8, produto.getTipo());
            pstcadpro.setString(9, produto.getImp_ficha());
            pstcadpro.setString(10, produto.getSubgrupo());
            pstcadpro.setString(11, produto.getSetor());
            pstcadpro.setString(12, produto.getBaixa_producao());
            pstcadpro.setString(13, produto.getImprimeEtiqueta());
            pstcadpro.setString(14, produto.getTemAtacarejo());
            pstcadpro.setString(15, produto.getTemLocacao());
            pstcadpro.setString(16, produto.getPrecoVariado());
            pstcadpro.setString(17, produto.getImpressoraProducao());
            pstcadpro.setString(18, "N");
            pstcadpro.setString(19, "N");
            pstcadpro.setString(20, produto.getUrlImagem());
            pstcadpro.setString(21, produto.getEnviaCardapio());
            pstcadpro.setString(22, produto.getDescritivoCardapio());
            pstcadpro.setString(23, produto.getObservacao());
            pstcadpro.setString(24, produto.getIdimagem());
            pstcadpro.setString(25, produto.getAtivoCardapio());
            pstcadpro.executeUpdate();
            pstcadpro.close();
            
            PreparedStatement psid= conexao.getPreparedStatementResult(sqlidprod);
            ResultSet rsid=psid.executeQuery();
            rsid.first();
            produto.setId(rsid.getInt(1));
            idproduto=rsid.getString(1);
            rsid.close();
            psid.close();
            
            PreparedStatement pstcadprecos= conexao.getPreparedStatement(sqlprecos);
            System.out.println(produto.getPreco_venda());
            pstcadprecos.setInt(1, produto.getId());
            pstcadprecos.setString(2, produto.getPreco_venda());
            pstcadprecos.setString(3,produto.getMargem());
            pstcadprecos.setString(4, produto.getPreco_custo());
            pstcadprecos.setString(5, produto.getNcm());
            pstcadprecos.setString(6, produto.getSit_tributaria());
            System.out.println(produto.getCest());
            pstcadprecos.setString(7, produto.getCest());
            System.out.println(produto.getCest());
            if(produto.getSit_tributaria().equals("500")){
                 pstcadprecos.setString(8, "5405");
            }else pstcadprecos.setString(8, "5102");
            pstcadprecos.setString(9, produto.getPis_ent());
            pstcadprecos.setString(10, produto.getPis_sai());
            pstcadprecos.setString(11, produto.getAliq_icms());
            pstcadprecos.setString(12, produto.getCusto_atual());
            pstcadprecos.setString(13, produto.getCusto_medio());
            pstcadprecos.setDouble(14, produto.getPreco_oferta());
            pstcadprecos.setDate(15,  clsaux.retornaData(produto.getComeco()));
            pstcadprecos.setDate(16, clsaux.retornaData(produto.getFim()));
            pstcadprecos.executeUpdate();
            pstcadprecos.close();
            PreparedStatement psbarras= conexao.getPreparedStatement(sqlbarras);
            psbarras.setInt(1, produto.getId());
            psbarras.setString(2, produto.getCodi_barra());
            psbarras.setString(3, produto.getBaixa_barra());
            psbarras.setString(4, produto.getFator());
            psbarras.setString(5, produto.getEstoque_minimo());
            psbarras.setString(6, produto.getReferencia());
            psbarras.setString(7, produto.getPesavel());
            psbarras.setString(8, produto.getBalanca());
            psbarras.setString(9, produto.getPesagem_aut());
            psbarras.setDate(10,  clsaux.retornaData(produto.getDatavalidade()));
            psbarras.executeUpdate();
            psbarras.close();
            
            }catch (SQLException ee){
                Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ee);
                //JOptionPane.showMessageDialog(null, ee);
                Logs.gravarLog.gravaSemMensagem("Erro para cadastrar produto"+ee.getMessage());
            }
          return idproduto;
        }
        
    }
    public void Alterar (produtos produto){
        if (produto.isPreconovo()){
            ajustaAuditProd(produto.getId());
            new TauditDAO().inserir(String.valueOf(produto.getId()), clsaux.capturaValores(produto.getPrecoold()), clsaux.capturaValores(produto.getPreco_venda()));
        }
        String sql="update tprodutos set nomelongo=?, nomecurto=?, unid_venda=?, id_grupo=?, pontos_retira=?, pontos_validos=?,tipo_produto=?,imp_ficha_ind=?,"
                + "ativo=?,id_subgrupo=?,id_setor=?,baixa_producao_venda=?,imprime_etiqueta=?,data_alterado=current_date,possui_atacarejo=?,locacao=?,preco_variavel=?,impressora_producao=? "
                + ", urlimagem=?, enviacardapio=?,descritivocardapio=?,linkimg=?,ativocardapio=?  where id=?;";
        String sqlprecos="update tprecos set preco_venda=?, margem=?, preco_custo=?, ncm =?, sit_tributaria=?, cest=?, cfop=?"
                + ",pis_entrada=?, pis_saida=?, aliq_icms=?,preco_oferta=?,inicio_oferta=?,fim_oferta=? where id=?";      
        String sqlbarras="update tbarras set baixa_barra=?, fator=?, estoque_minimo=?, referencia=?,pesavel=?,id_balanca=?,leitura_aut_pdv=?,data_validade=?,codigo_barras=? where id_produto=?";
                  
        PreparedStatement pstcadpro= conexao.getPreparedStatement(sql);
       
        try {
            pstcadpro.setString(1, produto.getNomelongo());
            pstcadpro.setString(2, produto.getNomecurto());
            pstcadpro.setString(3, produto.getUnid_venda());
            pstcadpro.setString(4, produto.getGrupo());
            pstcadpro.setString(5, "0");
            pstcadpro.setString(6, "0");
            pstcadpro.setString(7, produto.getTipo());
            pstcadpro.setString(8, produto.getImp_ficha());
            pstcadpro.setString(9, produto.getAtivo());
            pstcadpro.setString(10, produto.getSubgrupo());
            pstcadpro.setString(11, produto.getSetor());
            pstcadpro.setString(12, produto.getBaixa_producao());
            pstcadpro.setString(13, produto.getImprimeEtiqueta());
            pstcadpro.setString(14, produto.getTemAtacarejo());
            pstcadpro.setString(15, produto.getTemLocacao());
            pstcadpro.setString(16, produto.getPrecoVariado());
            pstcadpro.setString(17, produto.getImpressoraProducao());
            pstcadpro.setString(18, produto.getUrlImagem());
            pstcadpro.setString(19, produto.getEnviaCardapio());
            pstcadpro.setString(20, produto.getDescritivoCardapio());
            pstcadpro.setString(21, produto.getIdimagem());
            pstcadpro.setString(22, produto.getAtivoCardapio());
            pstcadpro.setInt(23, produto.getId());
            pstcadpro.executeUpdate();
            pstcadpro.close();
            PreparedStatement pstcadprecos= conexao.getPreparedStatement(sqlprecos);
            pstcadprecos.setString(1, produto.getPreco_venda());
            pstcadprecos.setString(2, produto.getMargem());
            pstcadprecos.setString(3, produto.getPreco_custo());
            pstcadprecos.setString(4, produto.getNcm());
            pstcadprecos.setString(5, produto.getSit_tributaria());
            pstcadprecos.setString(6, produto.getCest());
            pstcadprecos.setString(7, "5405");
            pstcadprecos.setString(8, produto.getPis_ent());
            pstcadprecos.setString(9, produto.getPis_sai());
            pstcadprecos.setString(10, produto.getAliq_icms());
            pstcadprecos.setDouble(11, produto.getPreco_oferta());
            pstcadprecos.setDate(12, clsaux.retornaData(produto.getComeco()));
            pstcadprecos.setDate(13, clsaux.retornaData(produto.getFim()));
            pstcadprecos.setInt(14, produto.getId());
            pstcadprecos.executeUpdate();
            pstcadprecos.close();
            PreparedStatement psbarras= conexao.getPreparedStatement(sqlbarras);
            psbarras.setString(1, produto.getBaixa_barra());
            psbarras.setString(2, produto.getFator());
            psbarras.setString(3, produto.getEstoque_minimo());
            psbarras.setString(4, produto.getReferencia());
            psbarras.setString(5, produto.getPesavel());
            psbarras.setString(6, produto.getBalanca());
            psbarras.setString(7, produto.getPesagem_aut());
            psbarras.setDate(8,  clsaux.retornaData(produto.getDatavalidade()));
            psbarras.setString(9, produto.getCodi_barra());
            psbarras.setInt(10, produto.getId());
            psbarras.executeUpdate();
            psbarras.close();
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso!!!");
    
    }   catch (SQLException ee){
            JOptionPane.showMessageDialog(null, ee);
        }}
    public void Excluir (String id){
           try{
            String deletar="update tprodutos set excluido='S' where id="+id+";";
            PreparedStatement psdel = conexao.getPreparedStatement(deletar);
            psdel.execute();
            psdel.close();
    }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
     }}
    public void restauraExcluido (String id){
           try{
            String deletar="update tprodutos set excluido='N' where id="+id+";";
            PreparedStatement psdel = conexao.getPreparedStatement(deletar);
            psdel.execute();
            psdel.close();
    }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
     }}
    public void ajustaAuditProd(int id){
        try {
            String sql="update tprecos tc set tc.prec_venda_ant=tc.preco_venda, tc.ncm_ant=tc.ncm, tc.cst_ant=tc.sit_tributaria,\n" +
                    "tc.alteracao=current_timestamp, tc.us_alteracao=?, tc.origem_alteracao=? where tc.id=?";
            PreparedStatement ps= conexao.getPreparedStatement(sql);
            ps.setString(1, clsConfig.usuarioLogado);
            ps.setString(2, "Alterado Via Cadastro Produtos");
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
                
    }
    public void PesqItemAlterar (String id, produtos prodd, Unidades unid){
               String sql1="select tp.*, tg.nome from tprodutos tp left join tgrupos tg on tp.id_grupo=tg.id_grupo where id="+id+"";
               String sql2="select * from tbarras where id_produto="+id+"";
               String sql3= "select * from tprecos where id="+id+"";
               PreparedStatement pspesqitem = conexao.getPreparedStatement(sql1);
               try {
               ResultSet rspesqitem = pspesqitem.executeQuery();
                   rspesqitem.next();
                   prodd.setId(rspesqitem.getInt(1));
                   prodd.setNomecurto(rspesqitem.getString(2));
                   prodd.setNomelongo(rspesqitem.getString(3));
                   prodd.setUnid_venda(rspesqitem.getString(6));
                   prodd.setGrupo(rspesqitem.getString(9).trim()+" -"+rspesqitem.getString(14));
                  // prodd.setPtsretira(rspesqitem.getString(10));
                   //prodd.setPtsvale(rspesqitem.getString(11));
                   prodd.setImp_ficha(rspesqitem.getString("imp_ficha_ind"));
                   prodd.setAtivo(rspesqitem.getString("ativo"));
                   prodd.setSubgrupo(rspesqitem.getString("id_subgrupo"));
                   prodd.setSetor(rspesqitem.getString("id_setor"));
                   prodd.setBaixa_producao(rspesqitem.getString("baixa_producao_venda"));
                   prodd.setImprimeEtiqueta(rspesqitem.getString("imprime_etiqueta"));
                   prodd.setTemAtacarejo(rspesqitem.getString("possui_atacarejo"));
                   prodd.setTipo(rspesqitem.getString("tipo_produto"));
                   prodd.setTemLocacao(rspesqitem.getString("locacao"));
                   prodd.setPrecoVariado(rspesqitem.getString("preco_variavel"));
                   prodd.setImpressoraProducao(rspesqitem.getString("impressora_producao"));
                   prodd.setEnviaCardapio(rspesqitem.getString("enviacardapio"));
                   prodd.setUrlImagem(rspesqitem.getString("urlimagem"));
                   prodd.setDescritivoCardapio(rspesqitem.getString("descritivocardapio"));
                   prodd.setIdimagem(rspesqitem.getString("linkimg"));
                   prodd.setAtivoCardapio(rspesqitem.getString("ativocardapio"));
                   rspesqitem.close();
                   pspesqitem.close();
                   PreparedStatement pssql2 = conexao.getPreparedStatement(sql2);
                   ResultSet rssql2 = pssql2.executeQuery();
                   rssql2.next();
                   prodd.setBaixa_barra(rssql2.getString(3));
                   prodd.setCodi_barra(rssql2.getString(2));
                   prodd.setFator(rssql2.getString(4));
                   prodd.setEstoque_minimo(rssql2.getString(5));
                   prodd.setReferencia(rssql2.getString(6));
                   prodd.setBalanca(rssql2.getString("id_balanca"));
                   prodd.setPesavel(rssql2.getString("pesavel"));
                   prodd.setPesagem_aut(rssql2.getString("leitura_aut_pdv"));
                   prodd.setDatavalidade(rssql2.getString("data_validade"));
                   rssql2.close();
                   pssql2.close();
                   PreparedStatement pssql3 = conexao.getPreparedStatement(sql3);
                   ResultSet rssql3 = pssql3.executeQuery();
                   rssql3.next();
                   prodd.setPreco_custo(rssql3.getString(4));
                   prodd.setCusto_atual(rssql3.getString(13));
                   prodd.setCusto_medio(rssql3.getString(14));
                   prodd.setPreco_venda(rssql3.getString(2));
                   prodd.setMargem(rssql3.getString(3));
                   prodd.setNcm(rssql3.getString(5));
                   prodd.setPis_ent(rssql3.getString(9));
                   prodd.setPis_sai(rssql3.getString(10));
                   prodd.setAliq_icms(rssql3.getString(11));
                   prodd.setPreco_oferta(rssql3.getDouble("preco_oferta"));
                   prodd.setComeco(rssql3.getString("inicio_oferta"));
                   prodd.setFim(rssql3.getString("fim_oferta"));
                   prodd.setSit_tributaria(rssql3.getString("SIT_tributaria"));
                   rssql3.close();
                   pssql3.close();
               }catch (SQLException er){
                   JOptionPane.showMessageDialog(null, er);
               }
               
        }
    public static String PegaIdCodBarra(){
        String SqlConsulta="select gen_id(gen_codigo_barras,1) from rdb$database;";
        String id=null;
        try{
        PreparedStatement psid=conexao.getPreparedStatement(SqlConsulta);
        ResultSet rsid= psid.executeQuery();
        rsid.next();
        id =rsid.getString(1);
     }catch (SQLException er){
            JOptionPane.showMessageDialog(null, "Erro para buscar o id do codigo de barras"+er);
         }
      return id;  
    }
    public static String calculaEstoque(String idprod){
        Double totalestoque=null;
        try {
            String sql1="select * from tajusta_estoque  where id_item=?\n" +
                        "order by 5 desc;";
            
            PreparedStatement ps= conexao.getPreparedStatementResult(sql1);
            ps.setString(1, idprod);
            ResultSet rs = ps.executeQuery();
            rs.first();
            Double totalajustado=rs.getDouble(2);
            String data=rs.getString(5);
            String hora=rs.getString(4);
            rs.close();
            ps.close();
            data=clsaux.convertDataExib(data);
            String sql2="select sum(ti.quantidade) as saida from titens ti\n" +
                        "join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                        "where ti.id_prod='"+idprod+"' and tm.dat_finalizacao>'"+data+"' and ti.estado='2';";
            String sql3=" select sum(ti.quantidade) as saida from titens ti\n" +
                        "     join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                        "     where ti.id_prod='"+idprod+"' and tm.dat_finalizacao=? and tm.hora_finalizacao<'"+hora+"' and\n" +
                        "     ti.estado='2';";
            PreparedStatement pss=conexao.getPreparedStatementResult(sql2);
            ResultSet rss= pss.executeQuery();
            rss.first();
            PreparedStatement p= conexao.getPreparedStatementResult(sql3);
            p.setDate(1, clsaux.retornaData(data));
            ResultSet r = p.executeQuery();
            r.first();
            Double totalvendadia=r.getDouble(1);
            Double totalvendido=rss.getDouble(1);
            totalvendido=totalvendido-totalvendadia;
            totalestoque= totalajustado-totalvendido;
            
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(totalestoque);       
    }
    public static clsDadosEstoque retornaValorEstoque(String idprod){
       clsDadosEstoque valor= new clsDadosEstoque();
           try {
            String sql="select * from stp_calc_estoque_item(current_date,'"+idprod+"','01.01.2018')";
            String sqlcondi="select * from cons_estoque_condicionais tc where tc.idprod='"+idprod+"'";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            rs.first();
            valor.setCodigo(rs.getString("scodigo"));
            valor.setCustoatual(rs.getDouble("scusto"));
            valor.setCustocompra(rs.getDouble("scusto_compra"));
            valor.setCustomedio(rs.getDouble("scustomedio"));
            valor.setEstoque(rs.getDouble("sestoque"));
            rs.close();
            ps.close();
            PreparedStatement psc= conexao.getPreparedStatement(sqlcondi);
            ResultSet rsc= psc.executeQuery();
            if(rsc.next()){
                valor.setEstoquerua(rsc.getDouble("quantidade"));
                valor.setEstoquedisponivel(valor.getEstoque()-valor.getEstoquerua());
            }else{
                valor.setEstoquerua(0.00);
                valor.setEstoquedisponivel(valor.getEstoque());
            }
            rsc.close();
            psc.close();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
          return valor;  
    }
    public void atualizaCategoriaPreco(String cat,String pre, String pro){
        String slq="UPDATE OR INSERT INTO TCAT_PRECOS (IDPROD, ID_CATEGORIA, PREC_VENDA, DATA_ALTERADO)\n" +
"                           VALUES (?, ?, ?, current_date)  MATCHING (IDPROD, ID_CATEGORIA);";
        PreparedStatement ps= conexao.getPreparedStatement(slq);
        try {
            ps.setString(1, pro);
            ps.setString(2, cat);
            ps.setString(3, pre);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro ao atualizar categoria de preco\n"+ex.getMessage());
        }
        
    }
    public Tprecos retornaAuditoriaProduto(String id){
        Tprecos aud= new Tprecos();
        try {
            String sql="select tc.*,tp.data_cadastro,tp.data_alterado from tprecos tc join tprodutos tp on tc.id=tp.id\n" +
"where tc.id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                aud.setAlteracao(rs.getString("alteracao"));
                aud.setCfop(rs.getString("cfop"));
                aud.setCstantigo(rs.getString("cst_ant"));
                aud.setCusto(rs.getDouble("preco_custo"));
                aud.setCustoatual(rs.getDouble("custo_atual"));
                aud.setId(rs.getString("id"));
                aud.setMargem(rs.getDouble("margem"));
                aud.setNcm(rs.getString("ncm"));
                aud.setNcmantigo(rs.getString("ncm_ant"));
                aud.setOrigemalt(rs.getString("origem_alteracao"));
                aud.setPreco(rs.getDouble("preco_venda"));
                aud.setPrecoantigo(rs.getDouble("prec_venda_ant"));
                aud.setSittributaria(rs.getString("sit_tributaria"));
                aud.setUsuarioalt(rs.getString("us_alteracao"));
                aud.setDatcad(rs.getString("data_cadastro"));
                aud.setAltcad(rs.getString("data_alterado"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aud;
        
    }
    public List<Tcat_precos> RetornaPrecoCategoriaPorProduto(String barras){
       List<Tcat_precos> lista= new ArrayList<>();
        try {
            String sql="select tc.idprod,tc.id_categoria,tc.prec_venda ,tp.desc_plano,tb.codigo_barras from tcat_precos tc\n" +
                    "join tplanos_clube tp on tc.id_categoria=tp.id_plano\n" +
                    "join tbarras tb on tc.idprod=tb.id_produto\n" +
                    "where tb.codigo_barras=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, barras);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Tcat_precos cat = new Tcat_precos();
                cat.setBarras(rs.getString(5));
                cat.setCategoria(rs.getString(4));
                cat.setIdcategoria(rs.getString(2));
                cat.setIdprod(rs.getString(1));
                cat.setPreco(rs.getDouble(3));
                lista.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public void excluirCategoriaPreco(String idcategoria,String idproduto){
        try {
            String sql="delete from tcat_precos where idprod=? and id_categoria=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idproduto);
            ps.setString(2, idcategoria);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro ao excluir categoria de preco\n"+ex.getMessage());
        }
    }
    public static List listaprodutos(){
         List <String> listprod= new ArrayList<>();
         
         try{
         String sqlProd="select id,nomelongo from tprodutos\n" +
                        "where excluido='N'\n" +
                        "order by nomelongo";
         PreparedStatement psprod= conexao.getPreparedStatement(sqlProd);
         ResultSet rsprod = psprod.executeQuery();
         while(rsprod.next()){
            listprod.add(rsprod.getString(1)+" -"+rsprod.getString(2));
        }
        }catch (SQLException er){
            JOptionPane.showMessageDialog(null, "Erro ao buscar grupos "+er);
        }
        return listprod;   
    }
    public static String retornaCodBaixa(String idproduto){
        String retorno="";
        try {
            String sqlProd="select baixa_barra from tbarras where id_produto=?";
            PreparedStatement psprod= conexao.getPreparedStatementResult(sqlProd);
            psprod.setString(1, idproduto);
            ResultSet rsprod = psprod.executeQuery();
            rsprod.first();
            retorno=rsprod.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao buscar codigo de baixa\n"+ex);
        }
        return retorno;
    }
    public Boolean inserirItemComposicao(clsItemComposicao comp){
        boolean erro=false;
        try {
            String sql="UPDATE OR INSERT INTO TCOMPOSICAO_PRODUTO (ID_COMPOSICAO, DESCRICAO, BARRAS_ORIGEM, CODIGO_BAIXA, EXCLUIDO, DATA, QUANTIDADE, VL_PERCA, VL_CUSTO)\n" +
                    "                                   VALUES (gen_id(tcomposicao_produto_id,1), ?, ?, ?, 'N', current_date, ?, ?, ?) MATCHING (BARRAS_ORIGEM, CODIGO_BAIXA);";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, comp.getDescricao());
            ps.setString(2, comp.getCodigoItemAcabado());
            ps.setString(3, comp.getCodigoMateriaPrima());
            ps.setDouble(4, comp.getQuantidade());
            ps.setDouble(5, comp.getPerca());
            ps.setDouble(6, comp.getCusto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Para gravar composicao produto!!!\n"+ex.getMessage());
            erro=true;
        }
        return erro;
    }
    public void removerItemComposicao(clsItemComposicao comp){
         
        try {
            String sql="delete from tcomposicao_produto tc where tc.barras_origem=? and tc.codigo_baixa=? and tc.quantidade=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, comp.getCodigoItemAcabado());
            ps.setString(2, comp.getCodigoMateriaPrima());
            ps.setDouble(3, comp.getQuantidade());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Para Excluir composicao produto!!!\n"+ex.getMessage());
         
        }
        
    }
    public static void buscaProduto(clsLocalizaProduto lp) throws SQLException{
           String sql="select tb.codigo_barras,\n" +
                    "        tp.nomecurto,\n" +
                    "        tc.preco_venda,\n" +
                    "        tb.baixa_barra,\n" +
                    "        tb.fator,\n" +
                    "        tc.custo_atual, tp.id,tp.unid_venda,tc.preco_oferta,tb.referencia\n" +
                    " from tprodutos tp\n" +
                    "join tbarras tb on tp.id=tb.id_produto\n" +
                    "join tprecos tc on tc.id=tp.id\n" +
                    "where tb.codigo_barras=? and tp.excluido='N'";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, lp.getCodibarra());
            ResultSet rs = ps.executeQuery();
            rs.first();
            lp.setCodibarra(rs.getString(1));
            lp.setDescricao(rs.getString(2));
            lp.setPrecvenda(rs.getDouble(3));
            lp.setCodibaixa(rs.getString(4));
            lp.setFator(rs.getString(5));
            lp.setPreccusto(rs.getDouble(6));
            lp.setIdproduto(rs.getString(7));
            lp.setUnidade(rs.getString(8));
            lp.setOferta(rs.getDouble(9));
            lp.setReferencia(rs.getString(10));
            rs.close();
            ps.close();
    }
    public static Boolean verificaBarrasCadastrada(String cod){
        Boolean retorno=false;
        try {
            String sql="select count(tb.id_produto) from tbarras tb where tb.codigo_barras=?";
            PreparedStatement ps= conexao.getPreparedStatementResult(sql);
            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();
            rs.first();
            if(rs.getInt(1)>0){
                retorno=true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar codigo!!!\n"+ex.getMessage());
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return retorno;
    }

    public List<tprecos_atacarejo> retornaListaPrecosAtacarejo(String barras){
        List<tprecos_atacarejo> precos= new ArrayList<>();
        try {
            
            String sql="select * from tprecos_atacarejo where codi_barra=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, barras);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tprecos_atacarejo preco= new tprecos_atacarejo();
                preco.setCodigo(rs.getString(1));
                preco.setQuantidade(rs.getDouble(2));
                preco.setPreco(rs.getDouble(3));
                preco.setDataincluido(rs.getDate(4));
                precos.add(preco);
            }
            rs.close();
            ps.close();
            } catch (SQLException ex) {
                Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     return precos;
    }
    
    public void cadastraPrecosAtacarejo(List<tprecos_atacarejo> precos){
         try {
        String sql="UPDATE OR INSERT INTO TPRECOS_ATACAREJO (CODI_BARRA, QUANTIDADE, PRECO, DATA_CADASTRO)\n" +
"                                     VALUES (?, ?, ?, current_date)\n" +
"                                   MATCHING (CODI_BARRA, QUANTIDADE);";
        PreparedStatement ps = conexao.getPreparedStatement(sql);
        for(tprecos_atacarejo preco : precos){
                ps.setString(1, preco.getCodigo());
                ps.setDouble(2, preco.getQuantidade());
                ps.setDouble(3, preco.getPreco());
                ps.executeUpdate();
                ps.clearParameters();
            
        }
        ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
                Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void removerPrecoAtacarejo(String codigo,Double qnt){
         try {
        String sql="delete from tprecos_atacarejo tp where tp.codi_barra=? and tp.quantidade=?";
        PreparedStatement ps = conexao.getPreparedStatement(sql);
        ps.setString(1, codigo);
        ps.setDouble(2, qnt);
        ps.executeUpdate();
        ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
                Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public List<clsLocalizaProduto> retornaListaProdutosMarcados(){
        List<clsLocalizaProduto> lista= new ArrayList<>();
        try {
            String sql="select tb.codigo_barras,\n" +
                    "        tp.nomecurto,\n" +
                    "        tc.preco_venda,\n" +
                    "        tb.baixa_barra,\n" +
                    "        tb.fator,\n" +
                    "        tc.custo_atual, tp.id,tp.unid_venda,tb.referencia\n" +
                    " from tprodutos tp\n" +
                    "join tbarras tb on tp.id=tb.id_produto\n" +
                    "join tprecos tc on tc.id=tp.id\n" +
                    "where tp.imprime_etiqueta='S'";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clsLocalizaProduto lp= new clsLocalizaProduto();
                lp.setCodibarra(rs.getString(1));
                lp.setDescricao(rs.getString(2));
                lp.setPrecvenda(rs.getDouble(3));
                lp.setCodibaixa(rs.getString(4));
                lp.setFator(rs.getString(5));
                lp.setPreccusto(rs.getDouble(6));
                lp.setIdproduto(rs.getString(7));
                lp.setUnidade(rs.getString(8));
                lp.setReferencia(rs.getString(9));
                lista.add(lp);
            }
            rs.close();
            ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
        return lista;
    
    }
    public List<clsLocalizaProduto> retornaListaPodutosPorData(String ini,String fim){
        List<clsLocalizaProduto> lista= new ArrayList<>();
        try {
            String sql="select tb.codigo_barras,\n" +
                    "        tp.nomecurto,\n" +
                    "        tc.preco_venda,\n" +
                    "        tb.baixa_barra,\n" +
                    "        tb.fator,\n" +
                    "        tc.custo_atual, tp.id,tp.unid_venda,tb.referencia\n" +
                    " from tprodutos tp\n" +
                    "join tbarras tb on tp.id=tb.id_produto\n" +
                    "join tprecos tc on tc.id=tp.id\n" +
                    "where tp.data_alterado between ? and ?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setDate(1, clsaux.retornaData(ini));
            ps.setDate(2, clsaux.retornaData(fim));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clsLocalizaProduto lp= new clsLocalizaProduto();
                lp.setCodibarra(rs.getString(1));
                lp.setDescricao(rs.getString(2));
                lp.setPrecvenda(rs.getDouble(3));
                lp.setCodibaixa(rs.getString(4));
                lp.setFator(rs.getString(5));
                lp.setPreccusto(rs.getDouble(6));
                lp.setIdproduto(rs.getString(7));
                lp.setUnidade(rs.getString(8));
                lp.setReferencia(rs.getString(9));
                lista.add(lp);
            }
            rs.close();
            ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        }
        return lista;
    
    }
    public void ajustaEstoqueItem(String qnt,String produto){
        try {
            String sql="insert into tmovimento (id_mov,id_tipo,id_modelo,numero_documento,data,hora,estado,sub_total,total,\n" +
                        "acrescimo,desconto,dat_finalizacao,hora_finalizacao,id_parceiro) values (gen_id(gen_tmovimento_id,1),4,99,9999,current_date,current_time,2,0.00,\n" +
                        "0.00,0.00,0.00,current_date,current_time,'0')";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.executeUpdate();
            ps.close();
            String pegaid="select gen_id(gen_tmovimento_id,0) from rdb$database";
            PreparedStatement psi= conexao.getPreparedStatementResult(pegaid);
            ResultSet rs = psi.executeQuery();
            rs.first();
            String numeromovi=rs.getString(1);
            rs.close();
            psi.close();
            String sqlinsereitm="insert into titens(id,id_mov,num_item,id_prod,quantidade,prec_venda,total,estado,cust_unitario,codi_barra,codigo_baixa,fator)\n" +
                                "values(gen_id(gen_titens_id,1),?,1,?,?,0.00,0.00,2,0.00,(select tp.codigo_barras from tbarras tp where tp.id_produto=?),(select tp.baixa_barra from tbarras tp where tp.id_produto=?),1);";
            PreparedStatement pst=conexao.getPreparedStatement(sqlinsereitm);
            pst.setString(1, numeromovi);
            pst.setString(2, produto);
            pst.setString(3, qnt);
            pst.setString(4, produto);
            pst.setString(5, produto);
            pst.executeUpdate();
            pst.close();
         } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque \n\n"+ex.getMessage());
        }
    }
    public void ajustaEstoqueItemLote(List<String> dados){
        try {
            String sql="insert into tmovimento (id_mov,id_tipo,id_modelo,numero_documento,data,hora,estado,sub_total,total,\n" +
                        "acrescimo,desconto,dat_finalizacao,hora_finalizacao,id_parceiro) values (gen_id(gen_tmovimento_id,1),4,99,9999,current_date,current_time,2,0.00,\n" +
                        "0.00,0.00,0.00,current_date,current_time,'0')";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.executeUpdate();
            ps.close();
            String pegaid="select gen_id(gen_tmovimento_id,0) from rdb$database";
            PreparedStatement psi= conexao.getPreparedStatementResult(pegaid);
            ResultSet rs = psi.executeQuery();
            rs.first();
            String numeromovi=rs.getString(1);
            rs.close();
            psi.close();
            String sqlinsereitm="insert into titens(id,id_mov,num_item,id_prod,quantidade,prec_venda,total,estado,cust_unitario,codi_barra,codigo_baixa,fator)\n" +
                                "values(gen_id(gen_titens_id,1),?,?,(select tp.id_produto from tbarras tp where tp.codigo_barras=?),?,0.00,0.00,2,0.00,?,?,1);";
            PreparedStatement pst=conexao.getPreparedStatement(sqlinsereitm);
            String codigo=null;
            String qnt=null;
            int id=1;
            for(String dado:dados){
                codigo=clsaux.retornaId(dado);
                qnt=clsaux.retornaAposId(dado);
                qnt=qnt.replaceAll(",", ".");
                pst.setString(1, numeromovi);
                pst.setString(2, String.valueOf(id));
                pst.setString(3, codigo);
                pst.setString(4, qnt);
                pst.setString(5, codigo);
                pst.setString(6, codigo);
                pst.executeUpdate();
                id++;
             }
            
            pst.close();
         } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque \n\n"+ex.getMessage());
        }
    }
    
    public clsLancDocument retornaBarrasAssociadoNfCompra(String idfornecedor,clsLancDocument ite){
        
         System.out.println("dados busca"+idfornecedor+"  n"+ite.getCodfornecedor());
        try {
            String sql="select ti.codi_barra,ti.id_mov,ti.id_prod,tp.nomelongo from titens ti\n" +
                    "join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                    "left join tprodutos tp on ti.id_prod=tp.id\n" +
                    "where tm.id_parceiro=? and ti.cod_fornecedor=?  and tm.estado='2'\n" +
                    "order by tm.dat_finalizacao desc";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idfornecedor);
            ps.setString(2, ite.getCodfornecedor());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ite.setBarras(rs.getString(1));
                ite.setIdproduto(rs.getString(3));
                ite.setDescricaofornecedor(rs.getString(4));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logs.gravarLog.main(ex.getMessage());
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ite;
    }
    public static void marcaItemImpressaoEtiquera(String idproduto){
        try {
            String sql="update tprodutos tp set tp.imprime_etiqueta='S' where tp.id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idproduto);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
