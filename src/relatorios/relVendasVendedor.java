/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import DAO.ContasReceberDAO;
import model.clsDadosEmpresa;
import classes.clsaux;
import conexoes.conexao;
import grafic.interfac.pesquisa.localizaProduto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.KeyStroke;
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
 * @author Rodrigo
 */
public class relVendasVendedor extends javax.swing.JDialog {

    /**
     * Creates new form relCadastros
     */
    public relVendasVendedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.inicia();
    }
    

     public static List<String> gruposSelecionados= new ArrayList<>();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbVendedor = new javax.swing.JComboBox<>();
        ftDatFim = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        ftDatInicio = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnGerar = new javax.swing.JButton();
        ckResumido = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txtGrupos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório - Vendas Por Vendedor");

        jPanel1.setBackground(new java.awt.Color(219, 227, 227));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 102), new java.awt.Color(0, 153, 102), new java.awt.Color(0, 153, 102), new java.awt.Color(0, 153, 102)));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel5.setText("Vendedor:");

        cbVendedor.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N

        try {
            ftDatFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftDatFim.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel4.setText("Final :");

        try {
            ftDatInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftDatInicio.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel3.setText("Inicial :");

        btnGerar.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Confirma.png"))); // NOI18N
        btnGerar.setText("Gerar");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        ckResumido.setBackground(new java.awt.Color(255, 255, 255));
        ckResumido.setText("Resumido");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Grupos:");

        txtGrupos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtGrupos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGruposFocusGained(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procura.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo Comissao:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Grupo" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftDatInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftDatFim, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ckResumido)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbVendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGrupos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftDatInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(ftDatFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckResumido)
                    .addComponent(jLabel1)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
       this.gerar();
    }//GEN-LAST:event_btnGerarActionPerformed

    private void txtGruposFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGruposFocusGained
         String res=gruposSelecionados.toString().replace("[", "");
        txtGrupos.setText(res.replace("]", ""));
    }//GEN-LAST:event_txtGruposFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       gruposSelecionados.clear();
       txtGrupos.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed
    public void gerar(){
        Date dataini,datafim=null;
        String vendedor=clsaux.retornaId(cbVendedor.getSelectedItem().toString()).trim();
        dataini=clsaux.retornaData(ftDatInicio.getText());
        datafim= clsaux.retornaData(ftDatFim.getText());
        int tipoComissao= cbTipo.getSelectedIndex();
        try { 
                JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
                viewer.setSize(1024,720);
                viewer.setLocationRelativeTo(null);
                JasperDesign jd;
                jd = JRXmlLoader.load(".\\relatorios\\relVendasVendedor.jrxml");
                if(ckResumido.isSelected())  jd = JRXmlLoader.load(".\\relatorios\\relVendasVendedorResumido.jrxml");
                JasperReport jr= JasperCompileManager.compileReport(jd);
                String sql="select tp.nomelongo as Produto,\n" +
                            "       ti.total as Venda_total ,\n" +
                            "       ti.cust_unitario,\n" +
                            "       iif(ti.cust_total is null, '0,00', ti.cust_total) as Custo_total,\n" +
                            "       ti.total-ti.cust_total as Lucro_bruto,\n" +
                            "       (ti.total-ti.cust_total)* tf.comissao/100 as Valor_comissao,\n" +
                            "       (ti.total-ti.cust_total)-((ti.total-ti.cust_total)* tf.comissao/100) as Lucro_liquido,\n" +
                            "       tm.id_vendedor,\n" +
                            "       tf.nome as Vendedor,\n" +
                            "       tf.comissao as Comissao,\n"
                        + "         tm.dat_finalizacao as Data \n" +
                            " from tmovimento tm\n" +
                            " join titens ti on tm.id_mov=ti.id_mov\n" +
                            " join tfuncionarios tf on tm.id_vendedor=tf.id\n" +
                            " join tprodutos tp on ti.id_prod=tp.id\n" +
                            " where tm.dat_finalizacao between '"+dataini+"' and '"+datafim+"' and tm.estado=2 and ti.estado=2 and tm.id_vendedor='"+vendedor+"' and tm.id_tipo<3";
                String sqlvalores="select sum (ti.total) as Venda_total,\n" +
                        "    sum (ti.cust_total) as Custo_total,\n" +
                        "    sum (iif(ti.cust_total is null, ti.total,ti.total-ti.cust_total))as Lucro_bruto,\n" +
                        "    sum((ti.total-ti.cust_total)* tf.comissao/100) as Valor_comissao,\n" +
                        "    sum((ti.total-ti.cust_total)-((ti.total-ti.cust_total)* tf.comissao/100)) as Lucro_liquido\n" +
                        "from tmovimento tm\n" +
                        " join titens ti on tm.id_mov=ti.id_mov\n" +
                        " join tfuncionarios tf on tm.id_vendedor=tf.id\n" +
                        " join tprodutos tp on ti.id_prod=tp.id\n" +
                        " where tm.dat_finalizacao between '"+dataini+"' and '"+datafim+"'  and tm.estado=2 and ti.estado=2 and tm.id_vendedor='"+vendedor+"' and tm.id_tipo<3"; 
                
                if(gruposSelecionados.size()>0){
                    String dados= txtGrupos.getText();
                    if(tipoComissao==0){
                          sql="select tp.nomelongo as Produto,\n" +
                            "       ti.total as Venda_total ,\n" +
                            "       ti.cust_unitario,\n" +
                            "       iif(ti.cust_total is null, '0,00', ti.cust_total) as Custo_total,\n" +
                            "       ti.total-ti.cust_total as Lucro_bruto,\n" +
                            "       (ti.total-ti.cust_total)* tf.comissao/100 as Valor_comissao,\n" +
                            "       (ti.total-ti.cust_total)-((ti.total-ti.cust_total)* tf.comissao/100) as Lucro_liquido,\n" +
                            "       tm.id_vendedor,\n" +
                            "       tf.nome as Vendedor,\n" +
                            "       tf.comissao as Comissao,\n"
                        + "         tm.dat_finalizacao as Data \n" +
                            " from tmovimento tm\n" +
                            " join titens ti on tm.id_mov=ti.id_mov\n" +
                            " join tfuncionarios tf on tm.id_vendedor=tf.id\n" +
                            " join tprodutos tp on ti.id_prod=tp.id\n" +
                            " where tm.dat_finalizacao between '"+dataini+"' and '"+datafim+"' and tm.estado=2 and ti.estado=2 and tm.id_vendedor='"+vendedor+"' \n"
                                 + " and tm.id_tipo<3 and tp.id_grupo in ("+dados+")";
                    sqlvalores="select sum (ti.total) as Venda_total,\n" +
                           "    sum (ti.cust_total) as Custo_total,\n" +
                           "    sum (iif(ti.cust_total is null, ti.total,ti.total-ti.cust_total))as Lucro_bruto,\n" +
                           "    sum((ti.total-ti.cust_total)* tf.comissao/100) as Valor_comissao,\n" +
                           "    sum((ti.total-ti.cust_total)-((ti.total-ti.cust_total)* tf.comissao/100)) as Lucro_liquido\n" +
                           "from tmovimento tm\n" +
                           " join titens ti on tm.id_mov=ti.id_mov\n" +
                           " join tfuncionarios tf on tm.id_vendedor=tf.id\n" +
                           " join tprodutos tp on ti.id_prod=tp.id\n" +
                           " where tm.dat_finalizacao between '"+dataini+"' and '"+datafim+"'  and tm.estado=2 and ti.estado=2 and tm.id_vendedor='"+vendedor+"' \n"
                            + "and tm.id_tipo<3 and tp.id_grupo in ("+dados+")"; 
                
                    }else{
                        
                         sql="select tp.nomelongo as Produto,\n" +
                            "       ti.total as Venda_total ,\n" +
                            "       ti.cust_unitario,\n" +
                            "       iif(ti.cust_total is null, '0,00', ti.cust_total) as Custo_total,\n" +
                            "       ti.total-ti.cust_total as Lucro_bruto,\n" +
                            "       (ti.total-ti.cust_total)* tg.comissao/100 as Valor_comissao,\n" +
                            "       (ti.total-ti.cust_total)-((ti.total-ti.cust_total)* tg.comissao/100) as Lucro_liquido,\n" +
                            "       tm.id_vendedor,\n" +
                            "       tf.nome as Vendedor,\n" +
                            "       tg.comissao as Comissao,\n"
                        + "         tm.dat_finalizacao as Data \n" +
                            " from tmovimento tm\n" +
                            " join titens ti on tm.id_mov=ti.id_mov\n" +
                            " join tfuncionarios tf on tm.id_vendedor=tf.id\n" +
                            " join tprodutos tp on ti.id_prod=tp.id\n" +
                            " join tgrupos tg on tp.id_grupo=tg.id_grupo \n"
                                + " where tm.dat_finalizacao between '"+dataini+"' and '"+datafim+"' and tm.estado=2 and ti.estado=2 and tm.id_vendedor='"+vendedor+"' \n"
                                 + " and tm.id_tipo<3 and tp.id_grupo in ("+dados+")";
                 sqlvalores="select sum (ti.total) as Venda_total,\n" +
                        "    sum (ti.cust_total) as Custo_total,\n" +
                        "    sum (iif(ti.cust_total is null, ti.total,ti.total-ti.cust_total))as Lucro_bruto,\n" +
                        "    sum((ti.total-ti.cust_total)* tg.comissao/100) as Valor_comissao,\n" +
                        "    sum((ti.total-ti.cust_total)-((ti.total-ti.cust_total)* tg.comissao/100)) as Lucro_liquido\n" +
                        "from tmovimento tm\n" +
                        " join titens ti on tm.id_mov=ti.id_mov\n" +
                        " join tfuncionarios tf on tm.id_vendedor=tf.id\n" +
                        " join tprodutos tp on ti.id_prod=tp.id\n" +
                        "  join tgrupos tg on tp.id_grupo=tg.id_grupo  where tm.dat_finalizacao between '"+dataini+"' and '"+datafim+"'  and tm.estado=2 and ti.estado=2 and tm.id_vendedor='"+vendedor+"'\n"
                         + " and tm.id_tipo<3 and tp.id_grupo in ("+dados+")"; 
                        
                    }
                }else{
                    if(tipoComissao==1){
                      sql="select tp.nomelongo as Produto,\n" +
                            "       ti.total as Venda_total ,\n" +
                            "       ti.cust_unitario,\n" +
                            "       iif(ti.cust_total is null, '0,00', ti.cust_total) as Custo_total,\n" +
                            "       ti.total-ti.cust_total as Lucro_bruto,\n" +
                            "       (ti.total-ti.cust_total)* tg.comissao/100 as Valor_comissao,\n" +
                            "       (ti.total-ti.cust_total)-((ti.total-ti.cust_total)* tg.comissao/100) as Lucro_liquido,\n" +
                            "       tm.id_vendedor,\n" +
                            "       tf.nome as Vendedor,\n" +
                            "       tg.comissao as Comissao,\n"
                        + "         tm.dat_finalizacao as Data \n" +
                            " from tmovimento tm\n" +
                            " join titens ti on tm.id_mov=ti.id_mov\n" +
                            " join tfuncionarios tf on tm.id_vendedor=tf.id\n" +
                            " join tprodutos tp on ti.id_prod=tp.id\n" +
                            " join tgrupos tg on tp.id_grupo=tg.id_grupo \n"
                                + " where tm.dat_finalizacao between '"+dataini+"' and '"+datafim+"' and tm.estado=2 and ti.estado=2 and tm.id_vendedor='"+vendedor+"' and tm.id_tipo<3";
                 sqlvalores="select sum (ti.total) as Venda_total,\n" +
                        "    sum (ti.cust_total) as Custo_total,\n" +
                        "    sum (iif(ti.cust_total is null, ti.total,ti.total-ti.cust_total))as Lucro_bruto,\n" +
                        "    sum((ti.total-ti.cust_total)* tg.comissao/100) as Valor_comissao,\n" +
                        "    sum((ti.total-ti.cust_total)-((ti.total-ti.cust_total)* tg.comissao/100)) as Lucro_liquido\n" +
                        "from tmovimento tm\n" +
                        " join titens ti on tm.id_mov=ti.id_mov\n" +
                        " join tfuncionarios tf on tm.id_vendedor=tf.id\n" +
                        " join tprodutos tp on ti.id_prod=tp.id\n" +
                        " join tgrupos tg on tp.id_grupo=tg.id_grupo where tm.dat_finalizacao between '"+dataini+"' and '"+datafim+"'  and tm.estado=2 and ti.estado=2 and tm.id_vendedor='"+vendedor+"' and tm.id_tipo<3"; 
                        
                    }
                    
                }
                PreparedStatement ps=conexao.getPreparedStatementResult(sql);
                PreparedStatement pst= conexao.getPreparedStatement(sqlvalores);
                ResultSet rs = pst.executeQuery();
                rs.next();
                String valorto= clsaux.formataReais(rs.getDouble(1));
                String tocusto= clsaux.formataReais(rs.getDouble(2));
                String tolucrobruto= clsaux.formataReais(rs.getDouble(3));
                String valorcomissao= clsaux.formataReais(rs.getDouble(4));
                String lucroliquido= clsaux.formataReais(rs.getDouble(5));
                String cont="proc";
                pst.close();
                rs=ps.executeQuery();
                JRResultSetDataSource jrds= new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                parametros.put("dat_inicio", ftDatInicio.getText());
                parametros.put("dat_fim", ftDatFim.getText());
                parametros.put("RAZAO_SOCIAL", clsDadosEmpresa.getRazao());
                parametros.put("RUA", clsDadosEmpresa.getRua());
                parametros.put("NUMERO", clsDadosEmpresa.getNumero());
                parametros.put("BAIRRO", clsDadosEmpresa.getBairro());
                parametros.put("CEP", "00000-000");
                parametros.put("CIDADE", clsDadosEmpresa.getCidade());
                parametros.put("UF", clsDadosEmpresa.getEstado());
                parametros.put("FONE", clsDadosEmpresa.getFone());
                parametros.put("totalgeral", valorto);
               // parametros.put("cont", "1111");
                parametros.put("totalcusto", tocusto);
                parametros.put("lucrobruto", tolucrobruto);
                parametros.put("valorcomissao", valorcomissao);
                parametros.put("lucroliquido", lucroliquido);
                JasperPrint impre= JasperFillManager.fillReport(jr, parametros, jrds);
                JasperViewer jv = new JasperViewer(impre, true);
                viewer.getContentPane().add(jv.getContentPane());
                viewer.setVisible(true);
               
           } catch (JRException ex) {
            Logger.getLogger(relCReceber.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException exx) {
            Logger.getLogger(relCReceber.class.getName()).log(Level.SEVERE, null, exx);
            JOptionPane.showMessageDialog(null, exx.getMessage());
        } catch(java.lang.Throwable e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    }
    public void inicia(){
        DefaultComboBoxModel cb= new DefaultComboBoxModel( ContasReceberDAO.vendedor().toArray());
        cbVendedor.setModel(cb);
        
        
            
       InputMap im = this.getRootPane().getInputMap(jPanel1.WHEN_IN_FOCUSED_WINDOW);
       im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10,0), "BUSCA");
       this.getRootPane().setInputMap(jPanel1.WHEN_IN_FOCUSED_WINDOW, im);
       this.getRootPane().getActionMap().put("BUSCA", new AbstractAction(){
                public void actionPerformed(ActionEvent e){
                    localizaProduto.idchamado="18";
                    localizaProduto.tipoBusca="grupos";
                   localizaProduto dialog = new localizaProduto(new javax.swing.JFrame(), true);
                   dialog.setLocationRelativeTo(null);
                   dialog.setVisible(true);
                }
        });
       
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
            java.util.logging.Logger.getLogger(relVendasVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relVendasVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relVendasVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relVendasVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                relVendasVendedor dialog = new relVendasVendedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGerar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbVendedor;
    private javax.swing.JCheckBox ckResumido;
    private javax.swing.JFormattedTextField ftDatFim;
    private javax.swing.JFormattedTextField ftDatInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTextField txtGrupos;
    // End of variables declaration//GEN-END:variables
}
