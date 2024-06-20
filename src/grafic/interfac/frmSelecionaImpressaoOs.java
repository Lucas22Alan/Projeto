/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import model.clsDadosEmpresa;
import classes.clsaux;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.clsConfig;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Mk Solucoes
 */
public class frmSelecionaImpressaoOs extends javax.swing.JDialog {

    /**
     * Creates new form frmSelecionaImpressaoOs
     */
    public frmSelecionaImpressaoOs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.inicia();
    }

    public static String idos;
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cbA4 = new javax.swing.JRadioButton();
        cbTermica = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cbA5 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar Tipo Impressão");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbA4.setBackground(new java.awt.Color(255, 255, 255));
        cbA4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        cbA4.setText("A4");
        cbA4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cbA4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        cbTermica.setBackground(new java.awt.Color(255, 255, 255));
        cbTermica.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        cbTermica.setText("Térmica 80 Colunas");
        cbTermica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cbTermica.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cbTermica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTermicaActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(87, 140, 140));

        btnImprimir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/impressora.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addGap(20, 20, 20))
        );

        jPanel7.setBackground(new java.awt.Color(87, 140, 140));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        cbA5.setBackground(new java.awt.Color(255, 255, 255));
        cbA5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        cbA5.setSelected(true);
        cbA5.setText("A5");
        cbA5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cbA5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbA4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTermica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbA5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbA4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTermica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbA5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTermicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTermicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTermicaActionPerformed

    
    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if(cbA4.isSelected()==true){
            imprimirOs(idos,"A4");
        }if(cbA5.isSelected()){
            imprimirOs(idos,"A5");
        }  
        else{
            imprimirOs(idos,"Termica");
        }
        this.dispose();
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    public void inicia(){
       String impressao=clsaux.trataCampoNuloConfig(clsConfig.configuracaogeral.getTipoImpOs());
       if(impressao.equals("N")||impressao.equals("A4"))cbA4.setSelected(true);
       else if(impressao.equals("A5")) cbA5.setSelected(true);
       else if (impressao.equals("T")) cbTermica.setSelected(true);
       btnImprimir.requestFocus();
    }
    public static void imprimirOs(String idos,String tipo){
        String modelo,marca,prob,serie,obser,desc,datain,placa,obsgeral=null;
        String rsocial,fantasia,cnpj,fone,celular,estado=null;
        String tipoImpressao;
        Double totalserv,totalprod,totalgeral=0.00;
        if(tipo.equals("A4")){
            tipoImpressao="RelOs.jrxml";
        }else if(tipo.equals("A5")){
            tipoImpressao="RelOsA5.jrxml";
        }
        else{
            tipoImpressao="RelOsTermica.jrxml";
        }
        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
            viewer.setSize(1024,720);
            viewer.setLocationRelativeTo(null);
            JasperDesign jd;
            jd = JRXmlLoader.load(conexao.cam+"ordemServico/"+tipoImpressao);
            JasperReport jr= JasperCompileManager.compileReport(jd);
            String sql="select tr.nomelongo as nomelongo,\n" +
                        "        tp.id_os,\n" +
                        "        tp.vl_unit,\n" +
                        "        tp.qnt,\n" +
                        "        tp.unid as unid_venda,\n" +
                        "        tp.desconto,\n" +
                        "        tp.total,\n" +
                        "        iif(tp.tipo_item='P','Produto','Servico') as TIPO, iif(tp.obs_item is null, 'Nao Informado',tp.obs_item) as obs_item, \n" +
                        "  tp.funcionario,tp.id_item from tos_item tp\n"
                    + "   join tbarras tb on tp.cod_item=tb.codigo_barras \n " +
                        "join tprodutos tr on tb.id_produto=tr.id\n" +
                        " where id_os=? and tp.estado='2'\n" +
                        "order by 8 desc, 10 asc ";
            String sql2="select tp.marca,\n" +
                        "        tp.modelo,\n" +
                        "        tp.serie,\n" +
                        "        tp.problema,\n" +
                        "        tp.obs,\n" +
                        "        tp.total_servicos,\n" +
                        "        tp.total_produtos,\n" +
                        "        tp.desconto,\n" +
                        "        tp.total,data_entrada, ts.descricao,tp.placa,obs_geral\n" +
                        " from tordem_servico tp join testado_operacoes ts on tp.situacao_os=ts.id\n" +
                        " where tp.id_ordem=?";
            String sqlparceiro="select tp.cnpj,tp.razao_social,tp.fantasia,tp.fone,tp.celular\n" +
" from tparceiros tp\n" +
"join tordem_servico tos on tos.id_parceiro=tp.idparceiro\n" +
"where tos.id_ordem=?";
            PreparedStatement ps  = conexao.getPreparedStatement(sql2);
            PreparedStatement ps2  = conexao.getPreparedStatement(sql);
            PreparedStatement ps3  = conexao.getPreparedStatement(sqlparceiro);
            ps2.setString(1, idos);
            ps.setString(1,idos );
            ps3.setString(1, idos);
            ResultSet rs = ps.executeQuery();
            rs.next();
            marca=rs.getString(1);
            modelo=rs.getString(2);
            serie=rs.getString(3);
            prob=rs.getString(4);
            obser=rs.getString(5);
            totalserv=rs.getDouble(6);
            totalprod=rs.getDouble(7);
            desc=clsaux.formato(rs.getDouble(8));
            totalgeral=rs.getDouble(9);
            datain=clsaux.convertDataExib(rs.getString(10));
            estado=rs.getString(11);
            placa=rs.getString(12);
            obsgeral=rs.getString(13);
            rs.close();
            rs=ps3.executeQuery();
            rs.next();
            cnpj=rs.getString(1);
            rsocial=rs.getString(2);
            fantasia=rs.getString(3);
            fone=rs.getString(4);
            celular=rs.getString(5);
            rs.close();
            rs=ps2.executeQuery();
            JRResultSetDataSource jrds= new JRResultSetDataSource(rs);
            Map parametros = new HashMap();
            System.out.println( clsDadosEmpresa.getEmail());
            parametros.put("razao_social", clsDadosEmpresa.getRazao());
            parametros.put("cnpj", clsDadosEmpresa.getCnpj());
            parametros.put("email", clsDadosEmpresa.getEmail());
            parametros.put("RUA", clsDadosEmpresa.getRua());
            parametros.put("NUMERO", clsDadosEmpresa.getNumero());
            parametros.put("BAIRRO", clsDadosEmpresa.getBairro());
            parametros.put("CEP", clsDadosEmpresa.getCep());
            parametros.put("CIDADE", clsDadosEmpresa.getCidade());
            parametros.put("UF", clsDadosEmpresa.getEstado());
            parametros.put("FONE", clsDadosEmpresa.getFone());
            parametros.put("modelo", modelo);
            parametros.put("marca", marca);
            parametros.put("observacao", obser);
            parametros.put("serie", serie);
            parametros.put("problema", prob);
            parametros.put("placa", placa);
            parametros.put("serv", totalserv);
            parametros.put("prod", totalprod);
            parametros.put("desc", desc);
            parametros.put("total", totalgeral);
            parametros.put("idos", idos);
            parametros.put("razaosocialcli", rsocial);
            parametros.put("cnpjcli", cnpj);
            parametros.put("fantasiacli", fantasia);
            parametros.put("fonecli", fone);
            parametros.put("celularcli", celular);
            parametros.put("dtini", datain);
            parametros.put("estado", estado);
            parametros.put("obsgeral", obsgeral);
            JasperPrint impre= JasperFillManager.fillReport(jr, parametros, jrds);
            JasperViewer jv = new JasperViewer(impre, true);
            viewer.getContentPane().add(jv.getContentPane());
            viewer.setVisible(true);
       } catch (JRException ex) {
            Logger.getLogger(CRUDservicos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro para gerar relatorio...\n"+ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(CRUDservicos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro para gerar relatorio...\n"+ex.getMessage());
            
        }
    
    
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
            java.util.logging.Logger.getLogger(frmSelecionaImpressaoOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSelecionaImpressaoOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSelecionaImpressaoOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSelecionaImpressaoOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmSelecionaImpressaoOs dialog = new frmSelecionaImpressaoOs(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnImprimir;
    private javax.swing.JRadioButton cbA4;
    private javax.swing.JRadioButton cbA5;
    private javax.swing.JRadioButton cbTermica;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
