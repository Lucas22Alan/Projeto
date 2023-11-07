/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.ClsDadosBoleto;
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
import model.tconfig_boleto;

/**
 *
 * @author Mk Solucoes
 */
public class BoletoDAO {
    
    public ClsDadosBoleto buscaDadosBoleto(String idtitulo){
        ClsDadosBoleto boleto= new ClsDadosBoleto();
        try {
            String sql="select tc.nosso_numero,\n" +
                    "        tc.data_emissao,\n" +
                    "        tc.data_vencimento,\n" +
                    "        tc.valor_total,\n" +
                    "        tp.razao_social,\n" +
                    "        tp.cnpj,\n" +
                    "        tp1.rua,\n" +
                    "        tp1.numero,\n" +
                    "        tp1.bairro,\n" +
                    "        tp1.cep,\n" +
                    "        tp1.estado,\n" +
                    "        tp1.cidade,\n" +
                    "        tf1.banco,\n" +
                    "        tf1.agencia,\n" +
                    "        tf1.agenciadig,\n" +
                    "        tf1.benef,\n" +
                    "        tf1.benefdig,\n" +
                    "        tf1.convenio,\n" +
                    "        tf1.carteira,\n" +
                    "        tf1.locais_pag,\n" +
                    "        tf1.instrucoes\n" +
                    "from tcontas_a_receber_pagar tc\n" +
                    "join tparceiros tp on tc.id_parceiro= tp.idparceiro\n" +
                    "join tenderecos tp1 on tp1.id_parceiro=tp.idparceiro\n" +
                    "join ttiptitulos tf on tc.tipo_titulo=tf.id\n" +
                    "join tconfig_boleto tf1 on tf.config_boleto=tf1.idconfig\n" +
                    "where tc.id=?";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, idtitulo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                boleto.setNumeroboleto(rs.getString(1));
                boleto.setDatDocumento(clsaux.retornaDataCalendar(rs.getDate(2)));
                boleto.setDatProcessamento(boleto.getDatDocumento());
                boleto.setDatVencimento(clsaux.retornaDataCalendar(rs.getDate(3)));
                boleto.setValor(rs.getDouble(4));
                boleto.setPagNome(rs.getString(5));
                boleto.setPagDoc(rs.getString(6));
                boleto.setPagRua(rs.getString(7)+", "+rs.getString(8));
                boleto.setPagBairro(rs.getString(9));
                boleto.setPagCep(rs.getString(10));
                boleto.setPagUf(rs.getString(11));
                boleto.setPagCidade(rs.getString(12));
                boleto.setBanco(rs.getString(13));
                boleto.setAgencia(rs.getString(14));
                boleto.setDigagencia(rs.getString(15));
                boleto.setCodigo(rs.getString(16));
                boleto.setDigcodigo(rs.getString(17));
                boleto.setConvenio(rs.getString(18));
                boleto.setCarteira(rs.getString(19));
                boleto.setLocais(rs.getString(20));
                boleto.setInstucoes(rs.getString(21));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return boleto;

    
    }
    public List<ClsDadosBoleto> buscaListaBoletosRemessa( ){
        List<ClsDadosBoleto> lista= new ArrayList<>();
        
        try {
            String sql="select tc.nosso_numero,\n" +
                    "        tc.data_emissao,\n" +
                    "        tc.data_vencimento,\n" +
                    "        tc.valor_total,\n" +
                    "        tp.razao_social,\n" +
                    "        tp.cnpj,\n" +
                    "        tp1.rua,\n" +
                    "        tp1.numero,\n" +
                    "        tp1.bairro,\n" +
                    "        tp1.cep,\n" +
                    "        tp1.estado,\n" +
                    "        tp1.cidade,\n" +
                    "        tf1.banco,\n" +
                    "        tf1.agencia,\n" +
                    "        tf1.agenciadig,\n" +
                    "        tf1.benef,\n" +
                    "        tf1.benefdig,\n" +
                    "        tf1.convenio,\n" +
                    "        tf1.carteira,\n" +
                    "        tf1.locais_pag,\n" +
                    "        tf1.instrucoes\n" +
                    "from tcontas_a_receber_pagar tc\n" +
                    "join tparceiros tp on tc.id_parceiro= tp.idparceiro\n" +
                    "join tenderecos tp1 on tp1.id_parceiro=tp.idparceiro\n" +
                    "join ttiptitulos tf on tc.tipo_titulo=tf.id\n" +
                    "join tconfig_boleto tf1 on tf.config_boleto=tf1.idconfig\n" +
                    "where tc.enviado_banco is null";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ClsDadosBoleto boleto= new ClsDadosBoleto();
                boleto.setNumeroboleto(rs.getString(1));
                boleto.setDatDocumento(clsaux.retornaDataCalendar(rs.getDate(2)));
                boleto.setDatProcessamento(boleto.getDatDocumento());
                boleto.setDatVencimento(clsaux.retornaDataCalendar(rs.getDate(3)));
                boleto.setValor(rs.getDouble(4));
                boleto.setPagNome(rs.getString(5));
                boleto.setPagDoc(rs.getString(6));
                boleto.setPagRua(rs.getString(7)+", "+rs.getString(8));
                boleto.setPagBairro(rs.getString(9));
                boleto.setPagCep(rs.getString(10));
                boleto.setPagUf(rs.getString(11));
                boleto.setPagCidade(rs.getString(12));
                boleto.setBanco(rs.getString(13));
                boleto.setAgencia(rs.getString(14));
                boleto.setDigagencia(rs.getString(15));
                boleto.setCodigo(rs.getString(16));
                boleto.setDigcodigo(rs.getString(17));
                boleto.setConvenio(rs.getString(18));
                boleto.setCarteira(rs.getString(19));
                boleto.setLocais(rs.getString(20));
                boleto.setInstucoes(rs.getString(21));
                lista.add(boleto);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    
    }
    
    public static List<String> retornaListaConfigBoleto(){
        List<String> lista= new ArrayList<>();
        
        try {
            String sql="select tb.idconfig,tb.descricao from tconfig_boleto  tb";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String dado="";
                dado=rs.getString(1)+"- "+rs.getString(2);
                lista.add(dado);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    
    
    }
 
    public tconfig_boleto retornaConfiguracaoBoleto(String id){
        tconfig_boleto conf= new tconfig_boleto();
        try {
            String sql="select * from tconfig_boleto where idconfig=?";
            
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            conf.setIdconfig(rs.getString("idconfig"));
            conf.setDescricao(rs.getString("descricao"));
            conf.setBanco(rs.getString("banco"));
            conf.setAgencia(rs.getString("agencia"));
            conf.setAgenciadig(rs.getString("agenciadig"));
            conf.setBenef(rs.getString("benef"));
            conf.setBenefdig(rs.getString("benefdig"));
            conf.setConvenio(rs.getString("convenio"));
            conf.setCarteira(rs.getString("carteira"));
            conf.setUltimoboleto(rs.getString("ultimo_boleto"));
            conf.setLocais_pag(rs.getString("locais_pag"));
            conf.setInstrucoes(rs.getString("instrucoes"));
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf;
    }
    
    public void inserirAlteraConfig(tconfig_boleto conf){
        try {
            String sql="UPDATE OR INSERT INTO TCONFIG_BOLETO (IDCONFIG, DESCRICAO, BANCO, AGENCIA, AGENCIADIG, BENEF, BENEFDIG, CONVENIO, CARTEIRA, ULTIMO_BOLETO, LOCAIS_PAG, INSTRUCOES)\n" +
                    "                              VALUES (?, ?, ?,?,?,?,?,?,?,?,?,?)\n" +
                    "                            MATCHING (IDCONFIG);";
            
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ps.setString(1, conf.getIdconfig());
            ps.setString(2, conf.getDescricao());
            ps.setString(3, conf.getBanco());
            ps.setString(4, conf.getAgencia());
            ps.setString(5, conf.getAgenciadig());
            ps.setString(6, conf.getBenef());
            ps.setString(7, conf.getBenefdig());
            ps.setString(8, conf.getConvenio());
            ps.setString(9, conf.getCarteira());
            ps.setString(10, conf.getUltimoboleto());
            ps.setString(11, conf.getLocais_pag());
            ps.setString(12, conf.getInstrucoes());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Gravado Com Sucesso!!!");
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String retornaProximaId(){
        String ret="0";
        try {
            String sql="select first 1 idconfig from tconfig_boleto  order by 1 desc";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            int id=rs.getInt(1);
            id++;
            ret=String.valueOf(id);
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ret="0";
        }
        return ret;
    
    }
}
