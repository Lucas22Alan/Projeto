/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import model.clsDadosEmpresa;
import classes.clsaux;
import conexoes.conexao;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
 * @author lucas
 */
public class relComprasItensFornecedor extends javax.swing.JDialog {

    /**
     * Creates new form relComprasItensFornecedor
     */
    public relComprasItensFornecedor(java.awt.Frame parent, boolean modal) {
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

        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ftFinal = new javax.swing.JFormattedTextField();
        ftInicial = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cbAtirador = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbFiltro = new javax.swing.JCheckBox();
        cbFiltroCusto = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 102), new java.awt.Color(0, 153, 102), new java.awt.Color(0, 153, 102), new java.awt.Color(0, 153, 102)));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Confirma.png"))); // NOI18N
        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setText("Inicial :");

        try {
            ftFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftFinal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        try {
            ftInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftInicial.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Final ");

        cbAtirador.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        cbAtirador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        cbAtirador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAtiradorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setText("Fornecedor:");

        cbFiltro.setBackground(new java.awt.Color(255, 255, 255));
        cbFiltro.setSelected(true);
        cbFiltro.setText("Todos");
        cbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroActionPerformed(evt);
            }
        });

        cbFiltroCusto.setBackground(new java.awt.Color(255, 255, 255));
        cbFiltroCusto.setSelected(true);
        cbFiltroCusto.setText("Separar por custo");
        cbFiltroCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroCustoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbFiltro)
                        .addGap(92, 92, 92)
                        .addComponent(cbFiltroCusto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ftInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ftFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbAtirador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(60, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ftInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ftFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAtirador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFiltro)
                    .addComponent(cbFiltroCusto))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.relCompras();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbAtiradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAtiradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAtiradorActionPerformed

    private void cbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroActionPerformed

    }//GEN-LAST:event_cbFiltroActionPerformed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown

    }//GEN-LAST:event_jPanel2ComponentShown

    private void cbFiltroCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFiltroCustoActionPerformed
      public void relCompras(){
         Date dtini, dtfim=null;
         String cli=null;
         dtini=clsaux.retornaData(ftInicial.getText());
         dtfim=clsaux.retornaData(ftFinal.getText());
         cli=clsaux.retornaId(cbAtirador.getSelectedItem().toString()).trim();
         try {
                JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
                viewer.setSize(1024,720);
                viewer.setLocationRelativeTo(null);
                JasperDesign jd;
                String sql2 = null;
                jd = JRXmlLoader.load(".\\relatorios\\relComprasFornecedorItens.jrxml");
                JasperReport jr= JasperCompileManager.compileReport(jd);
                sql2="select tr.nomelongo as descricao_produto,\n" +
                    "        sum(ti.quantidade) as qnt,\n" +
                    "        ti.prec_venda as cust_compra,\n" +
                    "        sum (ti.total) as total,\n" +
                    "        tm.id_parceiro,\n" +
                    "        tp.razao_social\n" +
                    "from titens ti\n" +
                    "left join tmovimento tm  on ti.id_mov=tm.id_mov\n" +
                    "left join tparceiros tp  on tp.idparceiro=tm.id_parceiro\n" +
                    "left join tprodutos tr on ti.id_prod=tr.id\n" +
                    "where tm.dat_finalizacao\n" +
                    "between '"+dtini+"' and '"+dtfim+"' and\n" +
                    "tm.id_tipo=3\n" +
                    "group by 1,3,5,6";
                String sql="select  tr.nomelongo as descricao_produto,\n" +
                            "        cast(sum(ti.quantidade)as numeric(8,2)) as qnt,\n" +
                            "        cast (sum(ti.prec_venda) / count (ti.id) as numeric(8,2)) as cust_compra,\n" +
                            "        cast (sum (ti.total) as numeric (8,2)) as total,\n" +
                            "        tm.id_parceiro,\n" +
                            "        tp.razao_social\n" +
                            "from titens ti\n" +
                            "left join tmovimento tm  on ti.id_mov=tm.id_mov\n" +
                            "left join tparceiros tp  on tp.idparceiro=tm.id_parceiro\n" +
                            "left join tprodutos tr on ti.id_prod=tr.id\n" +
                            "where tm.dat_finalizacao\n" +
                            "between '"+dtini+"' and '"+dtfim+"' and \n" +
                            "tm.id_tipo=3\n" +
                            "group by 1,5,6"; 
                String qtdtotal="select cast(sum(tm.total)as numeric (6,2)) as total\n" +
                                "from tmovimento tm\n" +
                                "where tm.dat_finalizacao\n" +
                                "between '"+dtini+"' and '"+dtfim+"' and\n" +
                                "tm.id_tipo=3";
                PreparedStatement ps=conexao.getPreparedStatementResult(qtdtotal);
                if (cbFiltroCusto.isSelected()){
                    sql=sql2;
                }
                PreparedStatement pst= conexao.getPreparedStatement(sql);
                ResultSet rs = ps.executeQuery();
                rs.first();
                String vltotal=rs.getString(1);
                rs=pst.executeQuery();
                JRResultSetDataSource jrds= new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                parametros.put("RAZAO_SOCIAL", clsDadosEmpresa.getRazao());
                parametros.put("RUA", clsDadosEmpresa.getRua());
                parametros.put("NUMERO", clsDadosEmpresa.getNumero());
                parametros.put("BAIRRO", clsDadosEmpresa.getBairro());
                parametros.put("CEP", "00000-000");
                parametros.put("CIDADE", clsDadosEmpresa.getCidade());
                parametros.put("UF", clsDadosEmpresa.getEstado());
                parametros.put("FONE", clsDadosEmpresa.getFone());
                parametros.put("dtini",ftInicial.getText());
                parametros.put("dtfim",ftFinal.getText());
                parametros.put("tgastos", vltotal);
                JasperPrint impre= JasperFillManager.fillReport(jr, parametros, jrds);
                JasperViewer jv = new JasperViewer(impre, true);
                viewer.getContentPane().add(jv.getContentPane());
                viewer.setVisible(true);
             } catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (JRException ex) {
            Logger.getLogger(relRanking.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(relRanking.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
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
            java.util.logging.Logger.getLogger(relComprasItensFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relComprasItensFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relComprasItensFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relComprasItensFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                relComprasItensFornecedor dialog = new relComprasItensFornecedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbAtirador;
    private javax.swing.JCheckBox cbFiltro;
    private javax.swing.JCheckBox cbFiltroCusto;
    private javax.swing.JFormattedTextField ftFinal;
    private javax.swing.JFormattedTextField ftInicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
