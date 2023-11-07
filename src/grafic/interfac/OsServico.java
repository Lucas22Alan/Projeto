/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import DAO.ContasReceberDAO;
import DAO.listaDAO;
import DAO.listaInfAdcDAO;
import DAO.orderServicoDAO;
import classes.ClsAutoComplete;
import model.clsItemOs;
import classes.clsaux;
import com.sun.glass.events.KeyEvent;
import conexoes.conexao;
import static grafic.interfac.OsItem.item;
import static grafic.interfac.OsItem.tipoform;
import static grafic.interfac.OsItem.txtCodProdOs;
import grafic.interfac.pesquisa.localizaProduto;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RKochhann
 */
public class OsServico extends javax.swing.JDialog {

    /**
     * Creates new form OsServico
     */
    public OsServico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.inicia();
        this.mapTeclas();
        this.estadoForm();
    }
    static String tipoform="O";
    static String item=null;
    static int indiceitem=0;

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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtCodProdOs = new javax.swing.JTextField();
        cbFuncionario = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtQtdeOs = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTotalProd = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbUnProd1 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        txtTotalProd1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPrecUnit = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        btnPesq = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnCancelarOs = new javax.swing.JButton();
        btnGravarOs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Serviços");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(219, 227, 227));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(219, 227, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Serviço");

        txtCodProdOs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCodProdOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProdOsActionPerformed(evt);
            }
        });

        cbFuncionario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Qtde");

        txtQtdeOs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtQtdeOs.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtQtdeOs.setText("1");
        txtQtdeOs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtdeOsFocusLost(evt);
            }
        });
        txtQtdeOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdeOsActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel15.setText("Total");

        txtTotalProd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotalProd.setForeground(new java.awt.Color(255, 0, 0));
        txtTotalProd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalProd.setText("0,00");
        txtTotalProd.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Funcionario");

        cbUnProd1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbUnProd1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UN", "HR" }));
        cbUnProd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnProd1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("UN");

        txtObs.setColumns(20);
        txtObs.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtObs.setRows(5);
        jScrollPane1.setViewportView(txtObs);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Obs");

        txtTotalProd1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotalProd1.setForeground(new java.awt.Color(255, 0, 0));
        txtTotalProd1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalProd1.setText("0,00");
        txtTotalProd1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalProd1FocusLost(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Desc. %");

        txtDesc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDesc.setForeground(new java.awt.Color(255, 0, 0));
        txtDesc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDesc.setText("0,00");
        txtDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescFocusLost(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Desc. R$");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("R$ Uni");

        txtPrecUnit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPrecUnit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecUnit.setText("0,00");
        txtPrecUnit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecUnitFocusLost(evt);
            }
        });
        txtPrecUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecUnitActionPerformed(evt);
            }
        });

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        btnPesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procura.png"))); // NOI18N
        btnPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbUnProd1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtQtdeOs)
                                    .addComponent(txtTotalProd1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
                            .addComponent(cbFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 18, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(jLabel13))
                                .addComponent(jLabel20))
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(txtTotalProd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDesc, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodProdOs, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescricao))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1)))
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodProdOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtQtdeOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUnProd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtPrecUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalProd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(txtTotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDesc, txtPrecUnit, txtQtdeOs, txtTotalProd, txtTotalProd1});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCodProdOs, txtDescricao});

        jPanel5.setBackground(new java.awt.Color(219, 227, 227));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null));

        btnCancelarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancela.png"))); // NOI18N
        btnCancelarOs.setText("Cancelar");
        btnCancelarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarOsActionPerformed(evt);
            }
        });

        btnGravarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Confirma.png"))); // NOI18N
        btnGravarOs.setText("Gravar");
        btnGravarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarOs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGravarOs)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravarOs)
                    .addComponent(btnCancelarOs))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelarOs, btnGravarOs});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarOsActionPerformed
        OsServico.tipoform="0";
        OsServico.indiceitem=0;
        OsServico.item=null;
        this.dispose();
    }//GEN-LAST:event_btnCancelarOsActionPerformed

    private void btnGravarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarOsActionPerformed
        if(clsaux.verificaNulo(txtCodProdOs.getText())){
            JOptionPane.showMessageDialog(null, "Falta Informar O Codigo Do Produto!!!");
        }else{
            this.acaoBtnGravar();
        }
        
    }//GEN-LAST:event_btnGravarOsActionPerformed

    private void txtPrecUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecUnitActionPerformed
       this.calculaValoritem();
    }//GEN-LAST:event_txtPrecUnitActionPerformed

    private void txtQtdeOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdeOsActionPerformed
         this.calculaValoritem();
    }//GEN-LAST:event_txtQtdeOsActionPerformed

    private void txtQtdeOsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtdeOsFocusLost
         this.calculaValoritem();
    }//GEN-LAST:event_txtQtdeOsFocusLost

    private void txtPrecUnitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecUnitFocusLost
         this.calculaValoritem();
    }//GEN-LAST:event_txtPrecUnitFocusLost

    private void txtCodProdOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProdOsActionPerformed
        if(clsaux.verificaNulo(txtCodProdOs.getText())){}else{
            this.preencheDados(txtCodProdOs.getText());
        }
        
        
    }//GEN-LAST:event_txtCodProdOsActionPerformed

    private void cbUnProd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnProd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUnProd1ActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
      /* txtCodProdOs.setText(clsaux.retornaAposId(txtDescricao.getText()));
       this.preencheDados(txtCodProdOs.getText());
       txtQtdeOs.requestFocus();*/
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void txtDescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescFocusLost
       this.validaDesconto("Normal");
    }//GEN-LAST:event_txtDescFocusLost

    private void txtTotalProd1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalProd1FocusLost
        this.validaDesconto("Percentual");
    }//GEN-LAST:event_txtTotalProd1FocusLost

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        OsServico.tipoform="0";
        OsServico.indiceitem=0;
        OsServico.item=null;
    }//GEN-LAST:event_formWindowClosed

    private void btnPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqActionPerformed
        localizaProduto dialog = new localizaProduto(new javax.swing.JFrame(), true); 
                localizaProduto.idchamado="3";
                localizaProduto.tipoBusca="servicos";
                dialog.setVisible(true);
    }//GEN-LAST:event_btnPesqActionPerformed

    public void inicia(){
        InputMap imp= this.getRootPane().getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        imp.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10,0),"busca_item");
        this.getRootPane().setInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW, imp);
        this.getRootPane().getActionMap().put("busca_item", new AbstractAction(){
            public void actionPerformed(ActionEvent ev){
                localizaProduto dialog = new localizaProduto(new javax.swing.JFrame(), true); 
                localizaProduto.idchamado="3";
                localizaProduto.tipoBusca="servicos";
                dialog.setVisible(true);
            }
        });
        DefaultComboBoxModel dfFunci= new DefaultComboBoxModel(ContasReceberDAO.vendedor().toArray());
        cbFuncionario.setModel(dfFunci);
        ArrayList<String> servicos= new ArrayList();
        servicos=listaDAO.listaProdutos("O");
        //ClsAutoComplete.setupAutoComplete(txtDescricao, servicos);
        DefaultComboBoxModel un = new DefaultComboBoxModel(listaInfAdcDAO.pegaUnid().toArray());
        cbUnProd1.setModel(un);
        txtObs.setLineWrap(true);
    }
    public void mapTeclas(){
        txtQtdeOs.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent evt){
                if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    txtPrecUnit.requestFocus();
                }
            }
            });
        txtPrecUnit.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent evt){
                if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    txtDesc.requestFocus();
                }
            }
            });
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent evt){
                if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    cbFuncionario.requestFocus();
                }
            }
            });
        cbFuncionario.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent evt){
                if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    btnGravarOs.requestFocus();
                }
            }
            });
        txtObs.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent evt){
                if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    btnGravarOs.requestFocus();
                }
            }
            });
        txtTotalProd1.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent evt){
                if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    txtDesc.requestFocus();
                }
            }
            });
        txtCodProdOs.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent evt){
                if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                    if(clsaux.verificaNulo(txtCodProdOs.getText())){}else{
                        txtQtdeOs.requestFocus();
                    }
                    
                }
            }
            });
        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent evt){
                if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                   txtCodProdOs.setText(clsaux.retornaAposId(txtDescricao.getText()));
                   //OsServico.preencheDados(txtCodProdOs.getText());
                   txtQtdeOs.requestFocus();
                }
            }
            });
        
        
    
    
    }
    public void preencheDados(String codigobarra){
         String sqlitem="select  tp.id,\n" +
                        "        tp.nomelongo,\n" +
                        "        tp.unid_venda,\n" +
                        "        tb.codigo_barras,\n" +
                        "        tb.referencia,\n" +
                        "        tc.preco_venda\n" +
                        "        from tprodutos tp\n" +
                        "join tbarras tb on tp.id=tb.id_produto\n" +
                        "join tprecos tc on tp.id=tc.id\n" +
                        "where tb.codigo_barras=? and tp.excluido='N'";
        PreparedStatement psp= conexao.getPreparedStatementResult(sqlitem);
        try {
            psp.setString(1, codigobarra);
            ResultSet rsp= psp.executeQuery();
            rsp.first();
            txtDescricao.setText(rsp.getString(2));
            
                txtPrecUnit.setText(clsaux.formato(rsp.getDouble(6)));
                cbUnProd1.setSelectedItem(rsp.getString(3));
            
            rsp.close();
            psp.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoItemDocumento.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Produto Não Encontrado!!!");
        }
    }
    public void calculaValoritem(){
        Double qnt=Double.parseDouble(txtQtdeOs.getText().replaceAll(",", "."));
        Double vlunit=Double.parseDouble(txtPrecUnit.getText().replaceAll(",", "."));
        Double desc=Double.parseDouble(txtDesc.getText().replaceAll(",", "."));
        Double total = qnt*vlunit-desc;
        txtTotalProd.setText(clsaux.formato(total));
    }
    public void insereLinha(){
        DefaultTableModel tb = (DefaultTableModel) OS.tbServicos.getModel();
        tb.addRow(new Object[]{
            OS.iditem,
            txtDescricao.getText(),
            txtQtdeOs.getText(),
            txtPrecUnit.getText(),
            txtTotalProd.getText(),
            txtObs.getText()
        });
        this.dispose();
        
        OS.calculaTotais();
    }
    public void acaoBtnGravar(){
        this.calculaValoritem();
        clsItemOs it= new clsItemOs();
        orderServicoDAO or= new orderServicoDAO();
        OS.iditem++;
        it.setIdos(OS.idos);
        it.setIditem(String.valueOf(OS.iditem));
        it.setCodigo(txtCodProdOs.getText());
        it.setDesconto(txtDesc.getText().replaceAll(",", "."));
        it.setQnt(txtQtdeOs.getText().replaceAll(",", "."));
        it.setValorunit(txtPrecUnit.getText().replaceAll(",", "."));
        it.setValortotal(txtTotalProd.getText().replaceAll(",", "."));
        it.setFuncionario(cbFuncionario.getSelectedItem().toString());
        it.setTipoitem("S");
        it.setObs(txtObs.getText());
        it.setUnid(cbUnProd1.getSelectedItem().toString());
        if(tipoform=="A"){
            it.setIditem(item);
            or.alterarItem(it);
            this.alteraLinha();
        } else {
            or.inserirItem(it);
            insereLinha();
        }
        OS.calculaTotais();
        this.dispose();
        OsServico.tipoform="0";
        OsServico.indiceitem=0;
        OsServico.item=null;
    }
    public void validaDesconto(String tipo){
        Double sub,subperc=0.00;
        Double vlunit,qntunit,desc,total,vlperc=0.00;
        vlunit=Double.parseDouble(txtPrecUnit.getText().replaceAll(",", "."));
        qntunit=Double.parseDouble(txtQtdeOs.getText().replaceAll(",", "."));
        desc=Double.parseDouble(txtDesc.getText().replaceAll(",", "."));
        total=Double.parseDouble(txtTotalProd.getText().replaceAll(",", "."));
        vlperc=Double.parseDouble(txtTotalProd1.getText().replaceAll(",", "."));
        if (desc>total||vlperc>100){
            JOptionPane.showMessageDialog(null, "Valor de Desconto Informado Invalido!!!", "Desconto Não permitido", HEIGHT);
        }else{
            if(tipo=="Percentual"){
                sub=total-(total*vlperc/100);
                desc=total*vlperc/100;
                subperc=vlperc;
                txtDesc.setText(clsaux.formato(desc));
            }else{
                sub=vlunit*qntunit-desc;
                subperc=desc/(vlunit*qntunit)*100;
            }
            txtTotalProd.setText(clsaux.formato(sub));
            txtTotalProd1.setText(clsaux.formato(subperc));
            }
        
    }
    public void estadoForm(){
        if (tipoform=="I"){
        } else if (tipoform=="A"){
            this.dadosAlterar();
        }
    }
    public void alteraLinha(){
        DefaultTableModel tb = (DefaultTableModel) OS.tbServicos.getModel();
        System.out.println(indiceitem);
        tb.setValueAt(item, indiceitem, 0);
        tb.setValueAt(txtDescricao.getText(), indiceitem, 1);
        tb.setValueAt(clsaux.formato(Double.parseDouble(txtQtdeOs.getText().replaceAll(",", "."))), indiceitem, 2);
        tb.setValueAt(clsaux.formato(Double.parseDouble(txtPrecUnit.getText().replaceAll(",", "."))), indiceitem, 3);
        tb.setValueAt(clsaux.formato(Double.parseDouble(txtTotalProd.getText().replaceAll(",", "."))), indiceitem, 4);
        
    }
    public void dadosAlterar(){
        orderServicoDAO od= new  orderServicoDAO();
        clsItemOs cs = new clsItemOs();
        cs.setIdos(OS.idos);
        cs.setIditem(item);
        od.buscaDadosItemAlterar(cs);
        txtCodProdOs.setText(cs.getCodigo());
        txtQtdeOs.setText(cs.getQnt());
        txtPrecUnit.setText(cs.getValorunit());
        txtDesc.setText(cs.getDesconto());
        txtTotalProd.setText(cs.getValortotal());
        txtObs.setText(cs.getObs());
        cbUnProd1.setSelectedItem(cs.getUnid());
        cbFuncionario.setSelectedItem(cs.getFuncionario());
        txtDescricao.setText(cs.getDesc());
        txtQtdeOs.requestFocus();
        //this.validaDesconto("Normal");
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
            java.util.logging.Logger.getLogger(OsServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OsServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OsServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OsServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OsServico dialog = new OsServico(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelarOs;
    private javax.swing.JButton btnGravarOs;
    private javax.swing.JButton btnPesq;
    private javax.swing.JComboBox cbFuncionario;
    private javax.swing.JComboBox cbUnProd1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField txtCodProdOs;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtPrecUnit;
    private javax.swing.JTextField txtQtdeOs;
    private javax.swing.JTextField txtTotalProd;
    private javax.swing.JTextField txtTotalProd1;
    // End of variables declaration//GEN-END:variables

   
}