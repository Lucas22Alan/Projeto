/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import DAO.lancamentoTiroDAO;
import model.clsDadosEmpresa;
import model.clsHistoricoCredito;
import classes.clsaux;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author lucas
 */
public class FrmHistoricoCredito extends javax.swing.JDialog {

    /**
     * Creates new form frmCreditoCliente
     */
    public FrmHistoricoCredito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.localizaCredito();
    }

    public static  String idcredito=null;
    public static String restante="0,00";
    String parceiro="0";
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
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbLancamentos = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        btnLocalizarOs = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lbTotalreg = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(219, 227, 227));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(219, 227, 227));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 51));
        jLabel8.setText("Filtros");

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TbLancamentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TbLancamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo", "Parceiro", "Valor", "Estado", "Data Consumo", "Hora Consumo", "Data Cancelado", "Movimento", "Titulo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbLancamentos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TbLancamentos.setRowHeight(20);
        TbLancamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TbLancamentos);
        if (TbLancamentos.getColumnModel().getColumnCount() > 0) {
            TbLancamentos.getColumnModel().getColumn(1).setPreferredWidth(100);
            TbLancamentos.getColumnModel().getColumn(2).setResizable(false);
            TbLancamentos.getColumnModel().getColumn(2).setPreferredWidth(200);
            TbLancamentos.getColumnModel().getColumn(3).setPreferredWidth(100);
            TbLancamentos.getColumnModel().getColumn(4).setPreferredWidth(100);
            TbLancamentos.getColumnModel().getColumn(5).setPreferredWidth(100);
            TbLancamentos.getColumnModel().getColumn(7).setPreferredWidth(150);
            TbLancamentos.getColumnModel().getColumn(8).setPreferredWidth(100);
            TbLancamentos.getColumnModel().getColumn(9).setPreferredWidth(100);
        }

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Estado Documento");

        cbTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Finalizado", "Cancelado" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
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

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Total de Registros :");

        lbTotalreg.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbTotalreg.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34))
                        .addComponent(btnLocalizarOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalreg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLocalizarOs)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTotalreg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        jPanel4.setBackground(new java.awt.Color(219, 227, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Os.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("- Financeiro / Credito de Cliente / Historico ");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("Historico Consumo Credito Parceiro");

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

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/impressora_1.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 0, 0));
        jLabel24.setText("Imprimir");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
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
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel22)))))
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
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoActionPerformed

    private void btnLocalizarOsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnLocalizarOsFocusGained
        this.localizaCredito();
    }//GEN-LAST:event_btnLocalizarOsFocusGained

    private void btnLocalizarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarOsActionPerformed
        this.localizaCredito();
    }//GEN-LAST:event_btnLocalizarOsActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        this.realizaImpressao();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
       this.realizaImpressao();
    }//GEN-LAST:event_jLabel24MouseClicked
    
    public void localizaCredito(){
        
        try {
            String sql="select tm.id_mov,\n" +
                        "       tp.razao_social,\n" +
                        "       tm.valor,\n" +
                        "       td.descricao,\n" +
                        "       tm.data,\n" +
                        "       tm.hr,\n" +
                        "       tm.data_cancelado,\n" +
                        "       tm.id_movimento,\n" +
                        "       tm.id_titulo,tm.tipo,tm.parceiro\n" +
                        " from tmov_crdi_parc tm\n" +
                        " left join tparceiros tp on tm.parceiro=tp.idparceiro\n" +
                        " left join testado_operacoes td on tm.estado=td.id\n" +
                        " where tm.id_credito=?";
            if(cbTipo.getSelectedItem().toString().equals("Finalizado")){
                sql="select tm.id_mov,\n" +
                        "       tp.razao_social,\n" +
                        "       tm.valor,\n" +
                        "       td.descricao,\n" +
                        "       tm.data,\n" +
                        "       tm.hr,\n" +
                        "       tm.data_cancelado,\n" +
                        "       tm.id_movimento,\n" +
                        "       tm.id_titulo,tm.tipo,tm.parceiro\n" +
                        " from tmov_crdi_parc tm\n" +
                        " left join tparceiros tp on tm.parceiro=tp.idparceiro\n" +
                        " left join testado_operacoes td on tm.estado=td.id\n" +
                        " where tm.id_credito=? and tm.estado='2'";
            }else if (cbTipo.getSelectedItem().toString().equals("Cancelado")){
                sql="select tm.id_mov,\n" +
                        "       tp.razao_social,\n" +
                        "       tm.valor,\n" +
                        "       td.descricao,\n" +
                        "       tm.data,\n" +
                        "       tm.hr,\n" +
                        "       tm.data_cancelado,\n" +
                        "       tm.id_movimento,\n" +
                        "       tm.id_titulo,tm.tipo,tm.parceiro\n" +
                        " from tmov_crdi_parc tm\n" +
                        " left join tparceiros tp on tm.parceiro=tp.idparceiro\n" +
                        " left join testado_operacoes td on tm.estado=td.id\n" +
                        " where tm.id_credito=? and tm.estado='3'";
            }
            PreparedStatement ps= conexao.getPreparedStatement(sql);
            ps.setString(1, idcredito);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tb=(DefaultTableModel) TbLancamentos.getModel();
            tb.setNumRows(0);
            while(rs.next()){
                tb.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(10),
                    rs.getString(2),
                    clsaux.formato(rs.getDouble(3)),
                    rs.getString(4),
                    clsaux.convertDataExib(rs.getString(5)),
                    rs.getString(6),
                    clsaux.convertDataHoraExib(rs.getString(7)),
                    rs.getString(8),
                    rs.getString(9)
            });
            parceiro=rs.getString("parceiro");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrmHistoricoCredito.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    };
    public void realizaImpressao(){
        try {
            String caminhojasper=".\\relatorios\\historicoCredito.jasper";
            List <clsHistoricoCredito> lista= new ArrayList();
            for(int i=0; i<TbLancamentos.getRowCount();i++){
                clsHistoricoCredito cls= new clsHistoricoCredito();
                cls.setId(TbLancamentos.getValueAt(i, 0).toString());
                cls.setTipo(TbLancamentos.getValueAt(i, 1).toString());
                cls.setParceiro(TbLancamentos.getValueAt(i, 2).toString());
                cls.setValor(clsaux.capturaValores(TbLancamentos.getValueAt(i, 3).toString()));
                cls.setEstado(TbLancamentos.getValueAt(i, 4).toString());
                cls.setData(TbLancamentos.getValueAt(i, 5).toString());
                cls.setDatacancelado(TbLancamentos.getValueAt(i, 7).toString());
                lista.add(cls);
            }
            HashMap parametros= new HashMap();
            parametros.put("RAZAO_SOCIAL", clsDadosEmpresa.getRazao());
            parametros.put("RUA", clsDadosEmpresa.getRua());
            parametros.put("NUMERO", clsDadosEmpresa.getNumero());
            parametros.put("BAIRRO", clsDadosEmpresa.getBairro());
            parametros.put("CEP", "00000-000");
            parametros.put("CIDADE", clsDadosEmpresa.getCidade());
            parametros.put("UF", clsDadosEmpresa.getEstado());
            parametros.put("FONE", clsDadosEmpresa.getFone());
            parametros.put("SALDO", restante);
            parametros.put("SALDOTOTAL", clsaux.formato(lancamentoTiroDAO.retornaCreditoDisponivel(parceiro)));
            JRBeanCollectionDataSource datasource=new JRBeanCollectionDataSource(lista);
            JasperPrint print=null;
            print=JasperFillManager.fillReport(caminhojasper, parametros, datasource);
            JasperViewer view= new JasperViewer(print);
            JDialog dialog=new JDialog(new javax.swing.JFrame(),"Visualização Do Relatório", true);
            dialog.setSize(900, 700);
            dialog.setLocationRelativeTo(null);
            dialog.getContentPane().add(view.getContentPane());
            dialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(FrmHistoricoCredito.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Para Gerar Impressão" +ex.getMessage());
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
            java.util.logging.Logger.getLogger(FrmHistoricoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHistoricoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHistoricoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHistoricoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmHistoricoCredito dialog = new FrmHistoricoCredito(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton btnLocalizarOs;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbTotalreg;
    // End of variables declaration//GEN-END:variables
}