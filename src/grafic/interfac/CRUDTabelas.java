/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import DAO.tabelasDAO;
import classes.clsaux;
import model.clsConta;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class CRUDTabelas extends javax.swing.JDialog {

    /**
     * Creates new form CRUDTabelas
     */
    public CRUDTabelas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public static String tipoform="O";

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
        tblUnidade = new javax.swing.JTable();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCampProcura = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabelas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 153, 102), new java.awt.Color(0, 153, 102), null));

        tblUnidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblUnidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUnidade.setRowHeight(20);
        jScrollPane1.setViewportView(tblUnidade);
        if (tblUnidade.getColumnModel().getColumnCount() > 0) {
            tblUnidade.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblUnidade.getColumnModel().getColumn(1).setPreferredWidth(180);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIncluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mais99.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar97.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluirItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/deletar99.png"))); // NOI18N
        btnExcluirItem.setText("Excluir");
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        btnFechar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fechar99.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Procurar");

        txtCampProcura.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procurar99.png"))); // NOI18N
        btnBuscar.setText("Localizar");
        btnBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnBuscarFocusGained(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCampProcura)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirItem)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCampProcura, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.acaoBtnbuscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        if (tipoform.equals("CO")){
            frmCadConta dialog = new frmCadConta(new javax.swing.JFrame(), true);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            
        } else if (tipoform.equals("TS")){
            frmCadTipoSub.tipo="I";
            frmCadTipoSub dialog = new frmCadTipoSub(new javax.swing.JFrame(), true);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        
        }else if(tipoform.equals("BA")){
            //abre cadastro de bairro
             FrmCadBairro dialog = new FrmCadBairro(new javax.swing.JFrame(), true);
             dialog.carregaDadosInicio();
             dialog.setLocationRelativeTo(null);
             dialog.setVisible(true);
        }else {
        frmCadTabelas dialog = new frmCadTabelas(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
      if (tipoform.equals("CO")){
            frmCadConta dialog = new frmCadConta(new javax.swing.JFrame(), true);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            
        } else if (tipoform.equals("TS")){
            frmCadTipoSub.tipo="A";
            frmCadTipoSub.id=tblUnidade.getValueAt(tblUnidade.getSelectedRow(), 0).toString();
            frmCadTipoSub dialog = new frmCadTipoSub(new javax.swing.JFrame(), true);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        
        }else if(tipoform.equals("BA")){
            //abre cadastro de bairro
             FrmCadBairro dialog = new FrmCadBairro(new javax.swing.JFrame(), true);
             dialog.carregaDadosAlterar(tblUnidade.getValueAt(tblUnidade.getSelectedRow(), 0).toString());
             dialog.setLocationRelativeTo(null);
             dialog.setVisible(true);
        } else {
               String id=null;
               id=tblUnidade.getValueAt(tblUnidade.getSelectedRow(),0).toString();
               this.buscarDadosExibi(id);
        } 
        
        
        
        
      
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
       excluirRegistro();
    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnBuscarFocusGained
       this.acaoBtnbuscar();
    }//GEN-LAST:event_btnBuscarFocusGained
    
     public void excluirRegistro(){
         tabelasDAO tab= new tabelasDAO();
         String id= tblUnidade.getValueAt(tblUnidade.getSelectedRow(),0).toString();
         tab.escluirRegistro(id, tipoform);
     }
     public void acaoBtnbuscar(){
         String campo=txtCampProcura.getText();
                if (tipoform.equals("CO")){
               this.buscarInf("select * from tconta where nome_conta like '%"+campo+"%';");
           }else if (tipoform.equals("G")){
               this.buscarInf("select * from tgrupos where nome like '%"+campo+"%';");
           } else if (tipoform.equals("HI")){
               this.buscarInf("select * from thistorico where historico like '%"+campo+"%';");
           }else if (tipoform.equals("TS")){
               this.buscarInf("select * from ttipo_movimento where descricao_movimento like '%"+campo+"%';");
           }else if (tipoform.equals("BA")){
               this.buscarInf("select tb.id, tb.nome||'   Valor : '|| tb.taxa_entrega from tcad_bairro tb where tb.nome like '%"+campo+"%'");
           }
}
    public void buscarInf(String campo){
        try {
            //String sql="select * from tgrupos where nome like'%"+campo+"%';";
            PreparedStatement psg= conexao.getPreparedStatement(campo);
            ResultSet rsg = psg.executeQuery();
            DefaultTableModel tb= (DefaultTableModel) tblUnidade.getModel();
            tb.setNumRows(0);
            while (rsg.next()){
               tb.addRow(new Object []{
                   rsg.getString(1),
                   rsg.getString(2)
               });
            }
            rsg.close();
            psg.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDTabelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscarDadosExibi(String id){
        String sql= null; 
        if (tipoform.equals("G")){
            sql="Select * from tgrupos where id_grupo=?";
            this.preencherDadosExib(sql, id);
        }else if (tipoform.equals("HI")){
            sql="select * from thistorico where id=?";
            this.preencherDadosExib(sql, id);
        } else if (tipoform.equals("CO")){
            this.pegarDadosConta(id);
        }
   }
    public void preencherDadosExib(String sql,String id){
        try {
                PreparedStatement ps = conexao.getPreparedStatementResult(sql);
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                rs.first();
                String nome,idretorno,pdv=null;
                String card="Nao";
                nome=rs.getString(2);
                Double comissao=rs.getDouble("comissao");
                idretorno=rs.getString(1);
                if(tipoform.equals("G")){
                     if(clsaux.trataCampoNuloConfig(rs.getString(3)).equals("N")){
                       pdv="Nao";
                    }else{
                        pdv="Sim";
                    }
                      if(clsaux.trataCampoNuloConfig(rs.getString(5)).equals("N")){
                       card="Nao";
                    }else{
                        card="Sim";
                    }
                     
                }else{
                    pdv="Nao";
                }
                rs.close();
                ps.close();
                frmCadTabelas dialog = new frmCadTabelas(new javax.swing.JFrame(), true);
                frmCadTabelas.txtNome.setText(nome);
                frmCadTabelas.txtId.setText(id);
                frmCadTabelas.txtComissao.setText(clsaux.formato(comissao));
                clsaux.carregaComboBox(frmCadTabelas.cbPdv, pdv);
                clsaux.carregaComboBox(frmCadTabelas.cbCardapio, card);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(CRUDTabelas.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 
    public void pegarDadosConta(String id){
        try {
            String sq="select * from tconta where id_conta=?";
            PreparedStatement ps = conexao.getPreparedStatementResult(sq);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            clsConta ct = new clsConta();
            ct.setId(rs.getString(1));
            ct.setContanome(rs.getString(2));
            ct.setObs(rs.getString(3));
            ct.setLimite(rs.getString(4));
            ct.setSaldo(rs.getString(5));
            rs.close();
            ps.close();
            frmCadConta dialog = new frmCadConta(new javax.swing.JFrame(), true);
            dialog.preencheDados(ct);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDTabelas.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(CRUDTabelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDTabelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDTabelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDTabelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CRUDTabelas dialog = new CRUDTabelas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAlterar;
    public static javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUnidade;
    private javax.swing.JTextField txtCampProcura;
    // End of variables declaration//GEN-END:variables
}
