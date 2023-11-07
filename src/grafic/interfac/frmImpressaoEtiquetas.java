/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import DAO.etiquetaDAO;
import DAO.lancamentoTiroDAO;
import DAO.orderServicoDAO;
import DAO.produtoDAO;
import model.clsDadosEmpresa;
import model.clsEtiqueta;
import model.clsImpressaoEtiqueta;
import model.clsLancamentoTiro;
import classes.clsLocalizaProduto;
import classes.clsaux;
import com.sun.glass.events.KeyEvent;
import conexoes.conexao;
import grafic.interfac.pesquisa.localizaProduto;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.clsDadosEstoque;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.validaDigitosBarras;

/**
 *
 * @author RKochhann
 */
public class frmImpressaoEtiquetas extends javax.swing.JDialog {

    /**
     * Creates new form CRUDservicos
     */
    public frmImpressaoEtiquetas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.inicia();
    }
    
    clsEtiqueta etiqueta= new clsEtiqueta();
    List<clsImpressaoEtiqueta> lista = new ArrayList<>();

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
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbLancamentos = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cbEtiqueta = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        btnLocalizarOs = new javax.swing.JButton();
        btnImpOs = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbFiltro = new javax.swing.JComboBox<>();
        txtCampoPesquisado = new javax.swing.JTextField();
        ftInicio = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        ftFim = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        cbQnt = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(219, 227, 227));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(219, 227, 227));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TbLancamentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TbLancamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descricao", "Preço", "Quantidade Imprimir", "Oferta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbLancamentos.setRowHeight(20);
        jScrollPane1.setViewportView(TbLancamentos);
        if (TbLancamentos.getColumnModel().getColumnCount() > 0) {
            TbLancamentos.getColumnModel().getColumn(0).setResizable(false);
            TbLancamentos.getColumnModel().getColumn(1).setResizable(false);
            TbLancamentos.getColumnModel().getColumn(2).setResizable(false);
            TbLancamentos.getColumnModel().getColumn(3).setResizable(false);
            TbLancamentos.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Modelo Etiqueta");

        cbEtiqueta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEtiquetaActionPerformed(evt);
            }
        });

        btnLocalizarOs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procurar.png"))); // NOI18N
        btnLocalizarOs.setText("Localizar");
        btnLocalizarOs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnLocalizarOsFocusGained(evt);
            }
        });
        btnLocalizarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarOsActionPerformed(evt);
            }
        });

        btnImpOs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImpOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Printer.png"))); // NOI18N
        btnImpOs.setText("Imprimir");
        btnImpOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpOsActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(219, 227, 227));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Pesquisar Por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(219, 227, 227));

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1- Codigo", "2- Data Alterado", "3- Data Oferta", "4- Nf Compra", "5- Marcados" }));

        txtCampoPesquisado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCampoPesquisado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampoPesquisadoActionPerformed(evt);
            }
        });

        try {
            ftInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Início");

        try {
            ftFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftFim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Término");

        cbQnt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1- Qnt Padrao 1", "2- Qnt Padrao Estoque" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(ftInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ftFim, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCampoPesquisado, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(cbQnt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbQnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCampoPesquisado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(btnLocalizarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImpOs, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLocalizarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImpOs, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        jPanel4.setBackground(new java.awt.Color(219, 227, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Os.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("- Arquivos / Impressão De Etiquetas");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("Impressão De Etiquetas");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DelFinan.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Remover");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/close2.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 0, 0));
        jLabel22.setText("Fechar");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocalizarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarOsActionPerformed
        String selecionado=clsaux.retornaId(cbFiltro.getSelectedItem().toString());
        if(txtCampoPesquisado.getText().length()>0){
            selecionado="1";
        }
        this.validaPesquisa(selecionado); 
    }//GEN-LAST:event_btnLocalizarOsActionPerformed

    private void btnImpOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpOsActionPerformed
        this.chamarImpressao();
    }//GEN-LAST:event_btnImpOsActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       this.removeItem();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.removeItem();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void btnLocalizarOsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnLocalizarOsFocusGained
       
    }//GEN-LAST:event_btnLocalizarOsFocusGained

    private void cbEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEtiquetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEtiquetaActionPerformed

    private void txtCampoPesquisadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampoPesquisadoActionPerformed
        String selecionado=clsaux.retornaId(cbFiltro.getSelectedItem().toString());
        if(txtCampoPesquisado.getText().length()>0){
            selecionado="1";
        }
        this.validaPesquisa(selecionado);  
    }//GEN-LAST:event_txtCampoPesquisadoActionPerformed
    public void removeItem(){
        DefaultTableModel tb=(DefaultTableModel) TbLancamentos.getModel();
        tb.removeRow(TbLancamentos.getSelectedRow());
        
    }
    
    public void inicia(){
        InputMap imp= this.getRootPane().getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        imp.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10,0),"busca");
        this.getRootPane().getActionMap().put("busca", new AbstractAction(){
            public void actionPerformed(ActionEvent ev){
                localizaProduto dialo = new localizaProduto(new javax.swing.JFrame(), true);
                localizaProduto.idchamado="7";
                dialo.setVisible(true);
            }
        });
        DefaultComboBoxModel cbeti= new DefaultComboBoxModel(etiquetaDAO.listaEtiquetas().toArray());
        cbEtiqueta.setModel(cbeti);
        ftInicio.setText(clsaux.preencheData());
        ftFim.setText(clsaux.preencheData());
    }
    public void validaPesquisa(String filtro){
        System.out.println("filtro usado  "+filtro);
        switch(filtro){
            case "1": pesquisaPorCodigo();
            break;
            case "2": pesquisaPorData();
            break;
            case "3": //pesquisaPorData();
            break;
            case "4":
            break;
            case "5": pesquisaMarcados();
            break;
                
        }
    }
    public void pesquisaPorCodigo(){
        try {
            String campo=validaDigitosBarras.preencheCodigo(txtCampoPesquisado.getText());
            clsLocalizaProduto prod= new clsLocalizaProduto();
            prod.setCodibarra(campo);
            produtoDAO.buscaProduto(prod);
            preencherTabela(prod.getCodibarra(), prod.getDescricao(),"1", prod.getPrecvenda(),prod.getOferta());
            txtCampoPesquisado.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(frmImpressaoEtiquetas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Produto Não Encontrado");
        }
   }
    public void pesquisaMarcados(){
        produtoDAO dao = new produtoDAO();
        List<clsLocalizaProduto> lista= dao.retornaListaProdutosMarcados();
        for(clsLocalizaProduto novo: lista){
            if(clsaux.retornaId(cbQnt.getSelectedItem()).equals("1")){
                preencherTabela(novo.getCodibarra(), novo.getDescricao(),"1", novo.getPrecvenda(),novo.getOferta());
            }else{
                clsDadosEstoque estoque=produtoDAO.retornaValorEstoque(novo.getCodibarra());
                preencherTabela(novo.getCodibarra(), novo.getDescricao(),estoque.getEstoquedisponivel().toString(), novo.getPrecvenda(),novo.getOferta());
            }
            
        }
    }
    public void pesquisaPorData(){
        produtoDAO dao = new produtoDAO();
        List<clsLocalizaProduto> lista= dao.retornaListaPodutosPorData(ftInicio.getText(), ftFim.getText());
        for(clsLocalizaProduto novo: lista){
            if(clsaux.retornaId(cbQnt.getSelectedItem()).equals("1")){
                preencherTabela(novo.getCodibarra(), novo.getDescricao(),"1", novo.getPrecvenda(),novo.getOferta());
            }else{
                clsDadosEstoque estoque=produtoDAO.retornaValorEstoque(novo.getCodibarra());
                preencherTabela(novo.getCodibarra(), novo.getDescricao(),estoque.getEstoquedisponivel().toString(), novo.getPrecvenda(),novo.getOferta());
            }
            
        }
        
    
    
    }
    public void preencherTabela(String cod,String nome,String qnt,Double prec,Double oferta){
        DefaultTableModel tb=(DefaultTableModel) TbLancamentos.getModel();
        TbLancamentos.setRowSorter(new TableRowSorter(tb));
        tb.addRow(new Object[]{
            cod,
            nome,
            clsaux.formato(prec),
            qnt,
            clsaux.formato(oferta)
        });
    }
   
    public void chamarImpressao(){
        Boolean marc=false;
        try {
            etiquetaDAO dao = new etiquetaDAO();
        for (int i=0; i<TbLancamentos.getRowCount();i++){
            
                int qnt=clsaux.capturaValores(TbLancamentos.getValueAt(i, 3).toString()).intValue();
               for(int l=0;l<qnt; l++){
                    clsImpressaoEtiqueta eti= new clsImpressaoEtiqueta();
                    eti.setCodigo(TbLancamentos.getValueAt(i, 0).toString());
                    eti.setDescricao(TbLancamentos.getValueAt(i, 1).toString());
                    eti.setPrec(TbLancamentos.getValueAt(i, 2).toString());
                    eti.setPreco(clsaux.capturaValores(TbLancamentos.getValueAt(i, 2).toString()));
                    eti.setRodape(etiqueta.getImprodape());
                    eti.setVlpromocional(clsaux.capturaValor(TbLancamentos.getValueAt(i, 4).toString()));
                    lista.add(eti);
                }
                dao.limpaMarcados(TbLancamentos.getValueAt(i, 0).toString());
        }
        
        this.imprimirNormal();
       }catch (Exception ex) {
                Logs.gravarLog.main(ex.getMessage());
                Logger.getLogger(frmImpressaoEtiquetas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public void imprimirNormal() throws JRException{
        etiqueta.setId(clsaux.retornaId(cbEtiqueta.getSelectedItem().toString()));
        etiqueta=etiquetaDAO.retornaEtiqueta(etiqueta);
        
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
            viewer.setSize(1024,720);
            viewer.setLocationRelativeTo(null);
            JasperDesign jd;
            jd = JRXmlLoader.load(conexao.cam+"/etiqueta/"+etiqueta.getNomefxml()+".jrxml");
            JasperReport jr= JasperCompileManager.compileReport(jd);
            JRBeanCollectionDataSource datasource=new JRBeanCollectionDataSource(lista);
            Map parametros = new HashMap();
            JasperPrint impre= JasperFillManager.fillReport(jr, parametros, datasource);
            if(etiqueta.getImpdireto().equals("S"))JasperPrintManager.printPage(impre, 0, true);
            else{
                JasperViewer jv = new JasperViewer(impre, true);
                viewer.getContentPane().add(jv.getContentPane());
                viewer.setVisible(true);
            }
            lista.clear();
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
            java.util.logging.Logger.getLogger(frmImpressaoEtiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmImpressaoEtiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmImpressaoEtiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmImpressaoEtiquetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmImpressaoEtiquetas dialog = new frmImpressaoEtiquetas(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable TbLancamentos;
    private javax.swing.JButton btnImpOs;
    public static javax.swing.JButton btnLocalizarOs;
    private javax.swing.JComboBox<String> cbEtiqueta;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JComboBox<String> cbQnt;
    private javax.swing.JFormattedTextField ftFim;
    private javax.swing.JFormattedTextField ftInicio;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTextField txtCampoPesquisado;
    // End of variables declaration//GEN-END:variables
}
