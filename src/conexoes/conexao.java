package conexoes;
import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.TipoCertificadoA3;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import model.clsConfig;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.clsDadosEmpresa;


public class conexao {
    public static String ip,endereco,cam;
    public static String banco="jdbc:firebirdsql:";
    private static final String usuario="SYSDBA";
    private static final String senha="masterkey";
    private static final String driver="org.firebirdsql.jdbc.FBDriver";
   
    
    private static Connection conn = null;
    
    public static Connection getConexao(){
        String caminho=banco+ip+endereco;
        if (conn==null){
                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(caminho,usuario,senha);
                }catch(ClassNotFoundException ex ){
                    JOptionPane.showMessageDialog(null, "classe nao encontrada"+ex.getMessage());
                }catch (SQLException es){
                    JOptionPane.showMessageDialog(null,"erro na conexao  "+ es.getMessage());
                }
        }
        return conn;  
    
    }
    public static Connection getConexaoRelatorio(){
     String caminho=banco+ip+endereco+"?defaultResultSetHoldable=True";
        try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(caminho,usuario,senha);
                }catch(ClassNotFoundException ex ){
                    JOptionPane.showMessageDialog(null, "classe nao encontrada"+ex.getMessage());
                }catch (SQLException es){
                    JOptionPane.showMessageDialog(null,"erro na conexao  "+ es.getMessage());
                }
        return conn;  }    
    public static PreparedStatement getPreparedStatement (String sql){
        if (conn==null){
           conn = getConexao();
        }try{
            return conn.prepareStatement(sql);
        }catch (SQLException ee){
            JOptionPane.showMessageDialog(null, "erro no sql "+ee.getMessage());
        }
       return null;
    }
    public static PreparedStatement getPreparedStatementResult (String sql){
        if (conn==null){
           conn = getConexao();
        }try{
            return conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        }catch (SQLException ee){
            JOptionPane.showMessageDialog(null, "erro no sql "+ee.getMessage());
        }
       return null;
    }
    public static ConfiguracoesNfe iniciaConfifNfe() throws CertificadoException, FileNotFoundException{
     Certificado cert = null;
        if(clsConfig.configuracaogeral.getTipoCertificado().equals("A3")){
            
            for(Certificado cliente : CertificadoService.listaCertificadosWindows()){
                if(cliente.getCnpjCpf().equals(clsDadosEmpresa.getCnpj())){
                    cert=cliente;
                }
            }
            if(cert==null){
                JOptionPane.showMessageDialog(null, "Atenção Certificado Não Encontrado!!!");
            }
        }else{
             cert = CertificadoService.certificadoPfx(clsConfig.configuracaogeral.getCertificado(), clsConfig.configuracaogeral.getSenha());
        }
         AmbienteEnum amb = AmbienteEnum.HOMOLOGACAO;
        if(clsConfig.configuracaogeral.getHamb().equals("P")){
              amb=AmbienteEnum.PRODUCAO; 
        }
       
       
        return ConfiguracoesNfe.criarConfiguracoes(EstadosEnum.PR, amb, cert,"C:\\esfhera\\adm\\schemas");
        
       
    
    
    }


}
