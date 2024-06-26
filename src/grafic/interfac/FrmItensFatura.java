/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import DAO.LocacaoDAO;
import DAO.listaplanosDAO;
import classes.clsaux;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import model.Torigem_fatura;

/**
 *
 * @author lucas
 */
public class FrmItensFatura extends javax.swing.JDialog {

    /**
     * Creates new form frmInformaItensReferente
     */
    public FrmItensFatura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       inicia();
    }
    
    String fatura=null;
   List<Torigem_fatura> lista;
   LocacaoDAO dao = new LocacaoDAO();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInfItens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAtualizaValor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Itens Referente a Fatura");

        jPanel1.setBackground(new java.awt.Color(219, 227, 227));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tblInfItens.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblInfItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descricão", "Qnt. Peças", "Valor", "Periodo", "Total", "Data Inicio Cob", "Data Final Cob", "Tipo Cobranca", "Diarias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInfItens.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblInfItens.setRowHeight(20);
        tblInfItens.getTableHeader().setReorderingAllowed(false);
        tblInfItens.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblInfItensKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblInfItens);
        if (tblInfItens.getColumnModel().getColumnCount() > 0) {
            tblInfItens.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblInfItens.getColumnModel().getColumn(1).setPreferredWidth(315);
            tblInfItens.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblInfItens.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblInfItens.getColumnModel().getColumn(4).setResizable(false);
            tblInfItens.getColumnModel().getColumn(5).setPreferredWidth(80);
            tblInfItens.getColumnModel().getColumn(6).setPreferredWidth(120);
            tblInfItens.getColumnModel().getColumn(7).setPreferredWidth(120);
            tblInfItens.getColumnModel().getColumn(8).setPreferredWidth(120);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 36)); // NOI18N
        jLabel1.setText("Itens Referentes a Fatura");

        btnAtualizaValor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAtualizaValor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/atualizar99.png"))); // NOI18N
        btnAtualizaValor.setText("Atualizar Valor");
        btnAtualizaValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaValorActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fechar99.png"))); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Total Fatura R$:");

        lbTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizaValor)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(btnAtualizaValor)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAtualizaValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaValorActionPerformed
        atualizaValor();
    }//GEN-LAST:event_btnAtualizaValorActionPerformed

    private void tblInfItensKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblInfItensKeyReleased
       calcula();
    }//GEN-LAST:event_tblInfItensKeyReleased

    
    public void inicia(){
      
        tblInfItens.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(createComboBox()));
    }
      
    private JComboBox<String> createComboBox() {
        JComboBox<String> comboBox = new JComboBox<>();
        for( Object fi: listaplanosDAO.listaplanos()){
            comboBox.addItem(fi.toString());
        }
        return comboBox;
    }
    public void carregaDados(String idfatura,String pago){
            fatura=idfatura;
            lista= dao.retornaDadosItensFatura(idfatura);
            DefaultTableModel tb= (DefaultTableModel) tblInfItens.getModel();
            tb.setNumRows(0);
            Double total=0.00;
            for (Torigem_fatura fat : lista){
                total=total+fat.getTotal();
                tb.addRow(new Object[]{
                    fat.getItem().getCodigoitem(),
                    fat.getItem().getDescricao(),
                    clsaux.formato(fat.getItem().getQntpecas()),
                    clsaux.formato(fat.getValor()),
                    clsaux.formato(fat.getPeriodo()),
                    clsaux.formato(fat.getTotal()),
                    clsaux.convertDataHoraExib(fat.getDatainicio()),
                    clsaux.convertDataHoraExib(fat.getDatafim()),
                    fat.getTipo(),
                    clsaux.calcularDiferencaDatas(clsaux.retornaDataSemHora(fat.getDatainicio()), clsaux.retornaDataSemHora(fat.getDatafim()))
                });
            }
            lbTotal.setText(clsaux.formato(total));
            if(pago.equals("S")){
                btnAtualizaValor.setEnabled(false);
            }
            
    }
    
    public void calcula(){
        Double total=0.00;
        Double qnt=0.00,totalunit=0.00,valor=0.00,pecas=0.00;
        for(int i=0; i< tblInfItens.getRowCount();i++){
            pecas=clsaux.capturaValores(tblInfItens.getValueAt(i, 2).toString());
            qnt=clsaux.capturaValores(tblInfItens.getValueAt(i, 4).toString());
            totalunit=clsaux.capturaValores(tblInfItens.getValueAt(i, 5).toString());
            valor=(totalunit/qnt)/pecas;
            tblInfItens.setValueAt( clsaux.formato(valor), i, 3);
            //tblInfItens.setValueAt(totalunit, i, 5);
            total=total+totalunit;
        }
        lbTotal.setText(clsaux.formato(total));
    }
    public void atualizaValor(){
         
        for(int i=0; i< tblInfItens.getRowCount();i++){
             lista.get(i).setPeriodo(clsaux.capturaValores(tblInfItens.getValueAt(i, 4).toString()));
             lista.get(i).setValor(clsaux.capturaValores(tblInfItens.getValueAt(i, 3).toString()));
             lista.get(i).setTotal(clsaux.capturaValores(tblInfItens.getValueAt(i, 5).toString()));
             dao.atualizaValorItensFatura(lista.get(i));
         
         }
        dao.atualizaValorFatura(fatura, clsaux.capturaValores(lbTotal.getText()),"N");
        this.dispose();
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
            java.util.logging.Logger.getLogger(FrmItensFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmItensFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmItensFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmItensFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmItensFatura dialog = new FrmItensFatura(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAtualizaValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tblInfItens;
    // End of variables declaration//GEN-END:variables
}
