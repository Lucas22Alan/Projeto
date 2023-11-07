/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import DAO.orderServicoDAO;
import classes.clsaux;
import conexoes.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.clsItemOs;
import model.clsOrdem;

/**
 *
 * @author lucas
 */
public class infParceiro extends javax.swing.JDialog {

    /**
     * Creates new form infParceiro
     */
    public infParceiro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.carregaDados();
        this.carregaDadosOrdens();
    }
    public static String idparceiro=null;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbUltCompra = new javax.swing.JLabel();
        lbDatCad = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbVlrUltCompra = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbVlrMaior = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbSitCad = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbDiasAtrado = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbTitulosPendentes = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbTotalVendas = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbQntVendas = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbTicketMedio = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMov = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItem = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Comercial");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), null, null, new java.awt.Color(0, 51, 51)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Data Cadastro :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Ultima Compra :");

        lbUltCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbUltCompra.setForeground(new java.awt.Color(153, 0, 0));

        lbDatCad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Valor Ultima Compra :");

        lbVlrUltCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbVlrUltCompra.setForeground(new java.awt.Color(0, 153, 0));
        lbVlrUltCompra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Valor MAIOR Compra :");

        lbVlrMaior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbVlrMaior.setForeground(new java.awt.Color(0, 153, 0));
        lbVlrMaior.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setText("...........................");

        jLabel10.setText("........................");

        jLabel11.setText("...................");

        jLabel12.setText("..................");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("Situação Cadastral :");

        jLabel14.setText("....................");

        lbSitCad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSitCad.setForeground(new java.awt.Color(153, 0, 0));
        lbSitCad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Dias em Atraso :");

        jLabel17.setText("........................");

        lbDiasAtrado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbDiasAtrado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setText("Titulos Pendentes :");

        jLabel20.setText(".....................");

        lbTitulosPendentes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTitulosPendentes.setForeground(new java.awt.Color(255, 0, 0));
        lbTitulosPendentes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setText("Total de Vendas");

        jLabel23.setText("...........................");
        jLabel23.setToolTipText("");

        lbTotalVendas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTotalVendas.setForeground(new java.awt.Color(0, 153, 0));
        lbTotalVendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel25.setText("Quantidade de Vendas");

        jLabel26.setText("..................");
        jLabel26.setToolTipText("");

        lbQntVendas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbQntVendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel28.setText("Ticket Médio");

        jLabel29.setText("...............................");
        jLabel29.setToolTipText("");

        lbTicketMedio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTicketMedio.setForeground(new java.awt.Color(0, 153, 0));
        lbTicketMedio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTicketMedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbQntVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotalVendas, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDatCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbVlrMaior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbVlrUltCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(lbUltCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(91, 91, 91)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTitulosPendentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSitCad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDiasAtrado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(299, 299, 299)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(300, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(lbSitCad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lbDatCad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(lbDiasAtrado, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lbUltCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(lbTitulosPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20))
                    .addComponent(lbVlrUltCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbVlrMaior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQntVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTicketMedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(jLabel29)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Historico de O.S"));

        tbMov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero OS", "Data", "Valor", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMov.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbMov.getTableHeader().setReorderingAllowed(false);
        tbMov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMovMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbMov);
        if (tbMov.getColumnModel().getColumnCount() > 0) {
            tbMov.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbMov.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbMov.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbMov.getColumnModel().getColumn(3).setPreferredWidth(120);
        }

        tbItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descricao", "Vl. Unit", "Qnt ", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbItem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbItem.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbItem);
        if (tbItem.getColumnModel().getColumnCount() > 0) {
            tbItem.getColumnModel().getColumn(0).setPreferredWidth(230);
            tbItem.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbItem.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbItem.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown

    }//GEN-LAST:event_jPanel2ComponentShown

    private void tbMovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMovMouseClicked
        carregaItensOrdem(tbMov.getValueAt(tbMov.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tbMovMouseClicked
    public void carregaDados(){
        
        try {
            String sqldadosultimavenda="select first 1 tm.dat_finalizacao,\n" +
                    "        tp.data_cadastro,\n" +
                    "        tm.total,\n" +
                    "        tp.estado   \n" +
                    "from tmovimento tm\n" +
                    "join tparceiros tp on tm.id_parceiro=tp.idparceiro\n" +
                    "where tm.id_parceiro="+idparceiro+"  and tm.estado=2\n" +
                    "order by 1 desc";
            String sqlmaiorvenda="select first 1 tm.total\n" +
                    "from tmovimento tm where tm.id_parceiro="+idparceiro+"\n" +
                    "order by 1 desc";
            String sqlmediavendas="select  sum(tm.total),\n" +
                    "        count(tm.id_mov) as vendas,\n" +
                    "        sum(tm.total)/count(tm.id_mov)\n" +
                    "from tmovimento tm where tm.id_parceiro="+idparceiro+"";
            String sqltitulos="select sum(tc.valor_total)\n" +
                    "    from tcontas_a_receber_pagar tc\n" +
                    "    where estado=4 and tc.data_vencimento<current_date\n" +
                    "    and tc.id_parceiro="+idparceiro+"";
            String sqldatavencido="select first 1 tc.data_vencimento\n" +
                    "from tcontas_a_receber_pagar tc\n" +
                    "where tc.estado=4 and tc.id_parceiro="+idparceiro+"\n" +
                    "order by 1 desc";
            String dtcadastro,ultcomp,vlultcomp,vlmaiorcomp,totalvend,qntvend,tkmedio,sitcad,diasatraso=null,vltitpend=null;
            Date datatitulovencido=null;
            PreparedStatement ps= conexao.getPreparedStatementResult(sqldadosultimavenda);
            ResultSet rs = ps.executeQuery();
            rs.first();
            ultcomp=clsaux.convertDataExib(rs.getString(2));
            dtcadastro=clsaux.convertDataExib(rs.getString(1));
            vlultcomp=rs.getString(3);
            sitcad=rs.getString(4);
            rs.close();
            ps=conexao.getPreparedStatementResult(sqlmaiorvenda);
            rs=ps.executeQuery();
            rs.first();
            vlmaiorcomp=clsaux.trataCampoNulo(rs.getString(1));
            rs.close();
            ps=conexao.getPreparedStatementResult(sqlmediavendas);
            rs=ps.executeQuery();
            rs.first();
            totalvend=clsaux.trataCampoNulo(rs.getString(1));
            qntvend=clsaux.trataCampoNulo(rs.getString(2));
            tkmedio=clsaux.trataCampoNulo(rs.getString(3));
            rs.close();
            ps=conexao.getPreparedStatementResult(sqltitulos);
            rs=ps.executeQuery();
            rs.first();
            vltitpend=clsaux.trataCampoNulo(rs.getString(1));
            rs.close();
            /*ps=conexao.getPreparedStatementResult(sqldatavencido);
            rs=ps.executeQuery();
            datatitulovencido=rs.getDate(1);*/
            rs.close();
            ps.close();
            lbDatCad.setText(dtcadastro);
            lbUltCompra.setText(ultcomp);
            lbVlrUltCompra.setText(clsaux.formataReais(clsaux.capturaValores(vlultcomp)));
            lbVlrMaior.setText(clsaux.formataReais(clsaux.capturaValores(vlmaiorcomp)));
            lbTotalVendas.setText(clsaux.formataReais(clsaux.capturaValores(totalvend)));
            lbQntVendas.setText(qntvend);
            lbTicketMedio.setText(clsaux.formataReais(clsaux.capturaValores(tkmedio)));
            lbSitCad.setText(sitcad);
            lbDiasAtrado.setText(diasatraso);
            lbTitulosPendentes.setText(clsaux.formataReais(clsaux.capturaValores(vltitpend)));
        } catch (SQLException ex) {
            Logger.getLogger(infParceiro.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "Erro ao buscar dados do parceiro\n"+ex);
        } 
        
    }
    public void carregaDadosOrdens(){
        List<clsOrdem> ordens= new orderServicoDAO().retornaListaOsParceiro(idparceiro);
        DefaultTableModel tb = (DefaultTableModel) tbMov.getModel();
        tb.setNumRows(0);
        for (clsOrdem ordem : ordens){
            tb.addRow(new Object[]{
                ordem.getIdmovto(),
                clsaux.convertDataExib(ordem.getDataent()),
                clsaux.formataReais(clsaux.capturaValores(ordem.getTotal())),
                ordem.getSituacao()
                
            });
        }
    }
    
    public void carregaItensOrdem(String idordem){
        List<clsItemOs> itens= new orderServicoDAO().retornaListaItensOs(idordem);
        DefaultTableModel tb = (DefaultTableModel) tbItem.getModel();
        tb.setNumRows(0);
        for (clsItemOs item : itens){
            tb.addRow(new Object[]{
                item.getDesc(),
                clsaux.formato(clsaux.capturaValores(item.getValorunit())),
                clsaux.formato(clsaux.capturaValores(item.getQnt())),
                clsaux.formato(clsaux.capturaValores(item.getValortotal()))
                
            });
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
            java.util.logging.Logger.getLogger(infParceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(infParceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(infParceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(infParceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                infParceiro dialog = new infParceiro(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbDatCad;
    private javax.swing.JLabel lbDiasAtrado;
    private javax.swing.JLabel lbQntVendas;
    private javax.swing.JLabel lbSitCad;
    private javax.swing.JLabel lbTicketMedio;
    private javax.swing.JLabel lbTitulosPendentes;
    private javax.swing.JLabel lbTotalVendas;
    private javax.swing.JLabel lbUltCompra;
    private javax.swing.JLabel lbVlrMaior;
    private javax.swing.JLabel lbVlrUltCompra;
    private javax.swing.JTable tbItem;
    private javax.swing.JTable tbMov;
    // End of variables declaration//GEN-END:variables
}
