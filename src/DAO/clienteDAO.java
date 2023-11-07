
package DAO;

import Logs.gravarLog;
import model.clientes;
import classes.clsaux;
import classes.infContrato;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class clienteDAO {
    public clienteDAO(){

        }
    
    public String inserir (clientes cliente){
        String sqlInsereCliente ="insert into tparceiros (idparceiro, cnpj, razao_social, fantasia, inscricao_estadual"
                + ", fone, celular,email, ins_municipal,data_nascimento,sexo, tipo_parceiro,tipo_pessoa,estado_civil,profissao,excluido,id_plano,cr,data_filiacao,env_api,estado) values (gen_id(gen_tparceiros_id,1),?,?,?,?,'"+cliente.getFone()+"','"+cliente.getCelular()+"','"+cliente.getEmail()+"',?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqlInsereEndereco="insert into tenderecos(id, id_parceiro, rua, bairro, numero, estado, cidade,cep, complemento"
                + ")values (gen_id(GEN_TENDERECOS_ID,1),gen_id(gen_tparceiros_id,0),?,?,?,?,?,'"+cliente.getCep()+"',?);";
        String sqlid="select gen_id(gen_tparceiros_id,0) from rdb$database";
        PreparedStatement psInscli= conexao.getPreparedStatement(sqlInsereCliente);
        String id="0";
        try{
                psInscli.setString(1, cliente.getCnpj());
                psInscli.setString(2, cliente.getRazaoSocial());
                psInscli.setString(3, cliente.getFantasia());
                psInscli.setString(4, cliente.getInscricaoEstadual());
                psInscli.setString(5, cliente.getInsMunicipal());
                psInscli.setDate(6, clsaux.retornaData(cliente.getDataNas()));
                psInscli.setString(7, cliente.getSexo());
                psInscli.setString(8, cliente.getTipoparceiro());
                psInscli.setString(9, cliente.getTipopessoa());
                psInscli.setString(10, cliente.getEstado_civil());
                psInscli.setString(11, cliente.getProfissao());
                psInscli.setString(12, "N");
                psInscli.setString(13, cliente.getIdplano());
                psInscli.setString(14, cliente.getCr());
                psInscli.setDate(15, clsaux.retornaData(cliente.getDatafili()));
                psInscli.setString(16, cliente.getSincroniza());
                psInscli.setString(17, cliente.getEstadocadastro());
                psInscli.executeUpdate();
                psInscli.close();
                PreparedStatement psinsend = conexao.getPreparedStatement(sqlInsereEndereco);
                psinsend.setString(1, cliente.getRua());
                psinsend.setString(2, cliente.getBairro());
                psinsend.setString(3, cliente.getNumero());
                psinsend.setString(4, cliente.getEstado());
                psinsend.setString(5, cliente.getCidade());
                psinsend.setString(6, cliente.getComplemento());
                psinsend.executeUpdate();
                psinsend.close();
                
                PreparedStatement psid= conexao.getPreparedStatement(sqlid);
                ResultSet rs= psid.executeQuery();
                if(rs.next()){
                   id=rs.getString(1);
                }
                psid.close();
                rs.close();
                
        }catch (SQLException err){
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, err);
            JOptionPane.showMessageDialog(null, "erro no comando"  +err.getMessage());
            gravarLog.main(err.getMessage().toString());
        }
        return id;
    }
    public static clientes buscar (String cpf, clientes cli,String id){
        try{
        String sql="select tp.idparceiro,\n" +
"        tp.cnpj,\n" +
"        tp.razao_social,\n" +
"        tp.inscricao_estadual,\n" +
"        tp.fone,\n" +
"        tp.celular,\n" +
"        tp.email,\n" +
"        tp.cr,\n" +
"        te.rua,\n" +
"        te.bairro,\n" +
"        te.numero,\n" +
"        te.cep,"
                + "te.cidade,"
                + "te.estado,"
                + "tp.profissao,"
                + "tp.estado_civil,"
                + "tp.nacionalidade,"
                + "tp.sexo,"
                + "tp.org_exp_rg,"
                + "tp.num_filiacao,"
                + "tp.tipo_pessoa,"
                + "tp.fantasia,"
                + "te.complemento,"
                + "tp.data_nascimento,"
                + "tp.id_plano,"
                + "tc.desc_plano, tp.data_filiacao, tp.env_api,tp.estado,tp.tipo_parceiro,td.mun_fg \n" +
" from tparceiros tp\n" +
" join tenderecos te on tp.idparceiro=te.id_parceiro\n"
 + "left join tplanos_clube tc on tp.id_plano=tc.id_plano\n" +
" left join tcidades td on te.cidade=td.nome_cidade and te.estado=td.estado "
                + "where tp.cnpj=? or tp.idparceiro=?;";
        PreparedStatement ps = conexao.getPreparedStatementResult(sql);
        ps.setString(1, cpf);
        ps.setString(2, id);
        ResultSet rs = ps.executeQuery();
        rs.first();
        cli.setid(rs.getInt(1));
        cli.setRazaoSocial(rs.getString(3));
        cli.setCnpj(rs.getString(2));
        cli.setInscricaoEstadual(rs.getString(4));
        cli.setCr(rs.getString(8));
        cli.setFone(rs.getString(5));
        cli.setCelular(rs.getString(6));
        cli.setEmail(rs.getString(7));
        cli.setRua(rs.getString(9));
        cli.setBairro(rs.getString(10));
        cli.setNumero(rs.getString(11));
        cli.setCep(rs.getString(12));
        cli.setCidade(rs.getString(13));
        cli.setEstado(rs.getString(14));
        cli.setProfissao(rs.getString(15));
        cli.setEstado_civil(rs.getString(16));
        cli.setNacionalida(rs.getString(17));
        cli.setSexo(rs.getString(18));
        cli.setOrg_exp(rs.getString(19));
        cli.setNumfiliacao(rs.getString(20));
        cli.setTipopessoa(rs.getString(21));
        cli.setFantasia(rs.getString(22));
        cli.setComplemento(rs.getString(23));
        cli.setDataNas(rs.getString(24));
        cli.setIdplano(rs.getString(25)+"-"+rs.getString(26));
        cli.setDatafili(rs.getString(27));
        cli.setSincroniza(rs.getString(28));
        cli.setEstadocadastro(rs.getString(29));
        cli.setTipoparceiro(rs.getString(30));
        cli.setCodmun(rs.getString(31));
        rs.close();
        ps.close();
        }catch(SQLException er){
            JOptionPane.showMessageDialog(null,"Parceiro Não Encontrado!!!");
            gravarLog.main(er.getMessage().toString());
        }
        return cli;
    }
    public String inserirPorContrato(clientes cliente, infContrato infcon){
        String sqlInsereCliente ="insert into tparceiros (idparceiro, cnpj, razao_social, fantasia, inscricao_estadual"
                + ", fone, celular,email, ins_municipal,data_nascimento,sexo, tipo_parceiro,cr,data_filiacao,fim_filiacao,estado_civil,profissao,nacionalidade,org_exp_rg,num_filiacao,excluido) values (gen_id(gen_tparceiros_id,1),?,?,?,?,'"+cliente.getFone()+"','"+cliente.getCelular()+"','"+cliente.getEmail()+"',?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqlInsereEndereco="insert into tenderecos(id, id_parceiro, rua, bairro, numero, estado, cidade,cep, complemento"
                + ")values (gen_id(GEN_TENDERECOS_ID,1),gen_id(gen_tparceiros_id,0),?,?,?,?,?,'"+cliente.getCep()+"',?);";
        String buscaid="select gen_id(gen_tparceiros_id,0) from rdb$database";
        PreparedStatement psInscli= conexao.getPreparedStatement(sqlInsereCliente);
        String retornoid=null;
        try{
                psInscli.setString(1, cliente.getCnpj());
                psInscli.setString(2, cliente.getRazaoSocial());
                psInscli.setString(3, cliente.getFantasia());
                psInscli.setString(4, cliente.getInscricaoEstadual());
                psInscli.setString(5, cliente.getInsMunicipal());
                psInscli.setDate(6, clsaux.retornaData(cliente.getDataNas()));
                psInscli.setString(7, cliente.getSexo());
                psInscli.setString(8, cliente.getTipoparceiro());
                psInscli.setString(9, cliente.getCr());
                psInscli.setDate(10, clsaux.retornaData(infcon.getData_filiacao()));
                psInscli.setDate(11, clsaux.retornaData(infcon.getData_fim_vigencia()));
                psInscli.setString(12, cliente.getEstado_civil());
                psInscli.setString(13, cliente.getProfissao());
                psInscli.setString(14, cliente.getNacionalida());
                psInscli.setString(15, cliente.getOrg_exp());
                psInscli.setString(16, cliente.getNumfiliacao());
                psInscli.setString(17, "N");
                psInscli.executeUpdate();
                psInscli.close();
                PreparedStatement psinsend = conexao.getPreparedStatement(sqlInsereEndereco);
                psinsend.setString(1, cliente.getRua());
                psinsend.setString(2, cliente.getBairro());
                psinsend.setString(3, cliente.getNumero());
                psinsend.setString(4, cliente.getEstado());
                psinsend.setString(5, cliente.getCidade());
                psinsend.setString(6, cliente.getComplemento());
                psinsend.executeUpdate();
                psinsend.close();
                JOptionPane.showMessageDialog(null, "Parceiro Inserido com Sucesso");
                PreparedStatement ps= conexao.getPreparedStatementResult(buscaid);
                ResultSet rs= ps.executeQuery();
                rs.first();
                retornoid=rs.getString(1);
                rs.close();
                ps.close();
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, "erro no comando"+err.getMessage());
            gravarLog.main(err.getMessage().toString());
        }        
        return retornoid ;
    }
    public void atualizarCadastro(clientes cl){
        try {
                String sql="update tparceiros set razao_social=?,fantasia=?,inscricao_estadual=?,fone=?,celular=?,tipo_parceiro=?,\n" +
                    "tipo_pessoa=?,email=?,sexo=?,estado_civil=?,profissao=?,id_plano=?,cr=?,data_filiacao=?,env_api=?,estado=?,cnpj=?,data_nascimento=? where idparceiro=?";
                String sqlendereco="update tenderecos set rua=?,bairro=?,numero=?,estado=?,cidade=?,cep=?,complemento=?\n" +
                    "where id_parceiro=?";
                 PreparedStatement ps= conexao.getPreparedStatement(sql);
                 ps.setString(19, String.valueOf(cl.getid()));
                 ps.setString(1, cl.getRazaoSocial());
                 ps.setString(2, cl.getFantasia());
                 ps.setString(3, cl.getInscricaoEstadual());
                 ps.setString(4, cl.getFone());
                 ps.setString(5, cl.getCelular());
                 ps.setString(6, cl.getTipoparceiro());
                 ps.setString(7, cl.getTipopessoa());
                 ps.setString(8, cl.getEmail());
                 ps.setString(9, cl.getSexo());
                 ps.setString(10, cl.getEstado_civil());
                 ps.setString(11, cl.getProfissao());
                 ps.setString(12, cl.getIdplano());
                 ps.setString(13, cl.getCr());
                 ps.setDate(14, clsaux.retornaData(cl.getDatafili()));
                 ps.setString(15, cl.getSincroniza());
                 ps.setString(16, cl.getEstadocadastro());
                 ps.setString(17, cl.getCnpj());
                 ps.setDate(18, clsaux.retornaData(cl.getDataNas()));
                 ps.executeUpdate();
                 ps.close();
                 PreparedStatement pse=conexao.getPreparedStatement(sqlendereco);
                 pse.setString(1, cl.getRua());
                 pse.setString(2, cl.getBairro());
                 pse.setString(3, cl.getNumero());
                 pse.setString(4, cl.getEstado());
                 pse.setString(5, cl.getCidade());
                 pse.setString(6, cl.getCep());
                 pse.setString(7, cl.getComplemento());
                 pse.setString(8, String.valueOf(cl.getid()));
                 pse.executeUpdate();
                 pse.close();
                 JOptionPane.showMessageDialog(null, "Registro Atualizado com sucesso!!!");
        } catch (SQLException ex) {
            gravarLog.main(ex.getMessage().toString());
            JOptionPane.showMessageDialog(null, "ERRO ao atualizar cadastro!!! \n\n"+ex.getMessage());
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deletar(String idparceirodeletar){
         try {
            String sqldeleta="update tparceiros set excluido='S' where idparceiro=?;";
            PreparedStatement psd= conexao.getPreparedStatement(sqldeleta);
            psd.setString(1, idparceirodeletar);
            psd.executeUpdate();
            psd.close();
            JOptionPane.showMessageDialog(null,"Excluido com sucesso");
        } catch (SQLException ex) {
            gravarLog.main(ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO ao atualizar cadastro!!! \n\n"+ex.getMessage());
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public static String buscarPorCnpj(String cnpj){
         String idparceiro="0";
        try {
            String sql="select idparceiro from tparceiros where cnpj='"+cnpj+"'";
            PreparedStatement ps= conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            idparceiro=rs.getString(1);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            idparceiro="0";
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idparceiro;
        
    }

}
