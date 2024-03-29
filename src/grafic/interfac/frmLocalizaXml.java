/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import DAO.clienteDAO;
import DAO.lancDocumentDAO;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TEnviNFe;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe;
import br.com.swconsultoria.nfe.util.XmlNfeUtil;
import model.clientes;
import conexoes.conexao;
import static grafic.interfac.LancamentoDocumentos.txtIdParceiro;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Mk Solucoes
 */
public class frmLocalizaXml extends javax.swing.JDialog {

    /**
     * Creates new form frmLocalizaXml
     */
    public static String caminhoxml=null;
    public frmLocalizaXml(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        txtcaminho = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(219, 227, 227));

        txtcaminho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaminhoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Selecionar arquivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Importar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("Selecionar Arquivo XML Para Importar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtcaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaminhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaminhoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        abrirPesquisaArquivos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            importaXml();
        } catch (CertificadoException ex) {
            Logger.getLogger(frmLocalizaXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmLocalizaXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(frmLocalizaXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void abrirPesquisaArquivos(){
        int retorno=fileChooser.showOpenDialog(this);
        if (retorno==JFileChooser.APPROVE_OPTION){
            File arquivo=fileChooser.getSelectedFile();
            txtcaminho.setText(arquivo.getName());
            caminhoxml=arquivo.getAbsolutePath();
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao Localizar Arquivo!!!");
        }
    
        
    }
    
    public void importaXml() throws CertificadoException, FileNotFoundException, IOException, JAXBException{
       
        //pego o caminho, le xml e converte em uma String
        String xml= XmlNfeUtil.leXml(caminhoxml);
       //pega a string do xml e converte no objeto para popular as classes da biblioteca com os dados do xml 
        TEnviNFe nfe=XmlNfeUtil.xmlToObject(xml, TEnviNFe.class);
        
       // System.out.println(nfe.getNFe());
        TNFe.InfNFe.Emit emit = nfe.getNFe().get(0).getInfNFe().getEmit();
        String parceiro="0";
        parceiro=clienteDAO.buscarPorCnpj(emit.getCNPJ());
        if(parceiro.equals("0")){
           parceiro=this.cadastraParceiro(emit);
        }   
        if(lancDocumentDAO.verificaRegistroLancado(parceiro, nfe.getNFe().get(0).getInfNFe().getIde().getNNF(), nfe.getNFe().get(0).getInfNFe().getIde().getSerie())==true){
            JOptionPane.showMessageDialog(null, "Nota Fiscal Já Lançada!!!");
             this.dispose();
        }else{
           LancamentoDocumentos dialog = new LancamentoDocumentos(new javax.swing.JFrame(), true,nfe,parceiro);
           LancamentoDocumentos.txtIdParceiro.setText(parceiro);
           LancamentoDocumentos.estadoform="I";
           LancamentoDocumentos.numeitem=1;
           dialog.setLocationRelativeTo(null);
           dialog.setVisible(true);
           this.dispose();
        }
    }
    
    public String cadastraParceiro(TNFe.InfNFe.Emit emit){
        String id="0";
        clientes cli= new clientes();
        cli.setCnpj(emit.getCNPJ());
        cli.setInscricaoEstadual(emit.getIE());
        cli.setRazaoSocial(emit.getXNome());
        cli.setFantasia(emit.getXFant());
        cli.setRua(emit.getEnderEmit().getXLgr());
        cli.setBairro(emit.getEnderEmit().getXBairro());
        cli.setNumero(emit.getEnderEmit().getNro());
        cli.setCidade(emit.getEnderEmit().getXMun());
        cli.setEstado(emit.getEnderEmit().getUF().name());
        cli.setCep(emit.getEnderEmit().getCEP());
        cli.setFone(emit.getEnderEmit().getFone());
        cli.setTipopessoa("Juridico");
        cli.setTipoparceiro("F");
        clienteDAO cd= new clienteDAO();
        cd.inserir(cli);
        id=clienteDAO.buscarPorCnpj(emit.getCNPJ());
        return id;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLocalizaXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLocalizaXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLocalizaXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLocalizaXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLocalizaXml dialog = new frmLocalizaXml(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtcaminho;
    // End of variables declaration//GEN-END:variables
}
