/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;


import model.clsDadosEmpresa;
import classes.clsaux;
import DAO.listaGrupDAO;
import DAO.produtoDAO;
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

public class relVendasporProdutos extends javax.swing.JDialog {

    /**
     * Creates new form relVendasporProdutos
     */
    public relVendasporProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.inicia();
    }

    public static List<String> ProdutosSelecionados= new ArrayList<>();
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
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbFiltro = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        cbGrupo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        btnLimpa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ftFinal = new javax.swing.JFormattedTextField();
        ftInicial = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbOrdem = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório - Vendas Por Produtos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 153, 102), new java.awt.Color(0, 153, 102), null));

        cbFiltro.setBackground(new java.awt.Color(255, 255, 255));
        cbFiltro.setText("Filtros");
        cbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel5.setText("Grupos :");

        cbGrupo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        cbGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-Todos" }));
        cbGrupo.setEnabled(false);
        cbGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGrupoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel6.setText("Produto :");

        txtProduto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProdutoFocusGained(evt);
            }
        });

        btnLimpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fechar99.png"))); // NOI18N
        btnLimpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFiltro)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpa))
                .addContainerGap(13, Short.MAX_VALUE))
        );

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

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel7.setText("Ordem:");

        cbOrdem.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        cbOrdem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1- Quantidade", "2- Total", "3- Descricao" }));
        cbOrdem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrdemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ftInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ftFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.relVendas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
       
    }//GEN-LAST:event_jPanel2ComponentShown

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
       
    }//GEN-LAST:event_jPanel1ComponentShown

    private void cbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroActionPerformed
        this.inicia();
        cbGrupo.enable(true);
       
    }//GEN-LAST:event_cbFiltroActionPerformed

    private void cbGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGrupoActionPerformed

    private void cbOrdemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrdemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrdemActionPerformed

    private void txtProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdutoFocusGained
       String res=ProdutosSelecionados.toString().replace("[", "");
        txtProduto.setText(res.replace("]", ""));
    }//GEN-LAST:event_txtProdutoFocusGained

    private void btnLimpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaActionPerformed
       ProdutosSelecionados.clear();
       txtProduto.setText("");
    }//GEN-LAST:event_btnLimpaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      ProdutosSelecionados.clear();
       txtProduto.setText("");
    }//GEN-LAST:event_formWindowClosing

   public void inicia(){
       DefaultComboBoxModel df = new DefaultComboBoxModel (listaGrupDAO.listagrupo().toArray());
       cbGrupo.setModel(df);
       cbGrupo.setSelectedIndex(0);
       
        DefaultComboBoxModel pr = new DefaultComboBoxModel (produtoDAO.listaprodutos().toArray());
      
       
       InputMap im = this.getRootPane().getInputMap(jPanel1.WHEN_IN_FOCUSED_WINDOW);
       im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10,0), "BUSCA");
       this.getRootPane().setInputMap(jPanel1.WHEN_IN_FOCUSED_WINDOW, im);
       this.getRootPane().getActionMap().put("BUSCA", new AbstractAction(){
                public void actionPerformed(ActionEvent e){
                    localizaProduto.idchamado="14";
                    localizaProduto.tipoBusca="normal";
                   localizaProduto dialog = new localizaProduto(new javax.swing.JFrame(), true);
                   dialog.setLocationRelativeTo(null);
                   dialog.setVisible(true);
                }
        });
       
}
    
   
    public void relVendas(){
       Date dtini, dtfim=null;
       String grupo,prod,filtro,ordem=null;
       dtini=clsaux.retornaData(ftInicial.getText());
       dtfim=clsaux.retornaData(ftFinal.getText());
       grupo=clsaux.retornaId(cbGrupo.getSelectedItem().toString()).trim();
       prod=clsaux.retornaId("");
       ordem=clsaux.retornaId(cbOrdem.getSelectedItem());
       try {
       JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
                viewer.setSize(1024,720);
                viewer.setLocationRelativeTo(null);
                JasperDesign jd;
                
                String sql = null,qtdtotal=null;
                
               jd = JRXmlLoader.load(".\\relatorios\\relvendas.jrxml");
                JasperReport jr= JasperCompileManager.compileReport(jd);
                
                switch(ordem){
                    case "1": ordem="order by 3 desc";
                    break;
                    case "2": ordem="order by 4 desc";
                    break;
                    case "3": ordem="order by 2 asc";
                    break;
                }
                if(cbFiltro.isSelected()){
                     if(ProdutosSelecionados.size()>0){
                         // filtra pela lista de produtos selecionados
                         String dados=txtProduto.getText();
                         
                                         sql="select tb.codigo_barras,\n" +
"                                         tp.nomelongo,\n" +
"                                         cast (sum (ti.quantidade)as numeric(5)) as Quantidade,\n" +
"                                         cast (sum (ti.total)as numeric (5,2))as Total,\n" +
"                                         cast (sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Custo,\n" +
"                                         cast (sum (ti.total )- sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Lucro,\n" +
"                                         cast ((sum (ti.total)- sum((ti.quantidade)*ti.cust_unitario))/ iif(sum(ti.cust_total)=0,1,sum(ti.cust_total)) *100 as numeric(5,2)) as porcentagem\n" +
"                                         from titens ti\n" +
"                                         join tprodutos tp on ti.id_prod=tp.id\n" +
"                                         join tprecos tr on ti.id_prod=tr.id\n" +
"                                         join tmovimento tm on ti.id_mov=tm.id_mov\n" +
"                                         join tbarras tb on tp.id=tb.id_produto\n" +
"                                         where (tm.id_tipo='2' or tm.id_tipo='5' or tm.id_tipo='1') and tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
"                                         and tm.estado='2'\n" +
"                                         and ti.estado='2'\n" +
"                                         and ti.codi_barra in ("+dados+")\n" +
"                                         GROUP BY 1,2 "+ordem;
                                 qtdtotal="select\n" +
                                          "cast (sum (ti.quantidade)as numeric(5)) as Quantidade,\n" +
                                          "cast (sum (ti.total)as numeric (5,2))as Total,\n" +
                                          "cast (sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Custo,\n" +
                                         "cast (sum (ti.total )- sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Lucro,\n"
                                         + "cast ((sum (ti.total)- sum((ti.quantidade)*ti.cust_unitario))/ iif(sum(ti.cust_total)=0,1,sum(ti.cust_total)) *100 as numeric(5,2)) as porcentagem\n" +
                                         " from titens ti\n" +
"                                         join tprodutos tp on ti.id_prod=tp.id\n" +
"                                         join tprecos tr on ti.id_prod=tr.id\n" +
"                                         join tmovimento tm on ti.id_mov=tm.id_mov\n" +
"                                         join tbarras tb on tp.id=tb.id_produto\n" +
"                                         where (tm.id_tipo='2' or tm.id_tipo='5' or tm.id_tipo='1') and tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"' \n" +
"                                         and tm.estado='2'\n" +
"                                         and ti.estado='2'\n" +
"                                         and ti.codi_barra in ("+dados+")";
                                       
                        }else{
                           //filtrar por grupo apenas
                           sql="select tb.codigo_barras,\n" +
                                         "tp.nomelongo,\n" +
                                         "cast (sum (ti.quantidade)as numeric(5)) as Quantidade,\n" +
                                         "cast (sum (ti.total)as numeric (5,2))as Total,\n" +
                                         "cast (sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Custo,\n" +
                                         "cast (sum (ti.total )- sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Lucro, \n"
                                       + "cast ((sum (ti.total)- sum((ti.quantidade)*ti.cust_unitario))/ iif(sum(ti.cust_total)=0,1,sum(ti.cust_total)) *100 as numeric(5,2)) as porcentagem\n" +
                                         "from titens ti\n" +
                                         "join tprodutos tp on ti.id_prod=tp.id\n" +
                                         "join tprecos tr on ti.id_prod=tr.id\n" +
                                         "join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                                         "join tbarras tb on tp.id=tb.id_produto\n" +
                                         "where tm.id_tipo='2'and tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                                         "and tm.estado='2'\n" +
                                         "and tp.id_grupo='"+grupo+"'"+
                                         " and ti.estado='2'" +
                                         "or\n" +
                                         "tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                                         "and tm.id_tipo='1' and tm.estado='2'\n"+ 
                                         "and tp.id_grupo='"+grupo+"'"+
                                         "and ti.estado='2'" +
                                         "or\n" +
                                         "tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                                         "and tm.id_tipo='5' and tm.estado='2'\n"+ 
                                         "and tp.id_grupo='"+grupo+"'"+
                                         "and ti.estado='2'" +     
                                         "GROUP BY 1,2 "+ordem;
                                 qtdtotal="select\n" +
                                          "cast (sum (ti.quantidade)as numeric(5)) as Quantidade,\n" +
                                          "cast (sum (ti.total)as numeric (5,2))as Total,\n" +
                                          "cast (sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Custo,\n" +
                                         "cast (sum (ti.total )- sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Lucro,\n"
                                         + "cast ((sum (ti.total)- sum((ti.quantidade)*ti.cust_unitario))/ iif(sum(ti.cust_total)=0,1,sum(ti.cust_total)) *100 as numeric(5,2)) as porcentagem\n" +
                                         "from titens ti\n" +
                                          "join tprodutos tp on ti.id_prod=tp.id\n" +
                                          "join tprecos tr on ti.id_prod=tr.id\n" +
                                          "join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                                          "where tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                                          "and tm.id_tipo='2' and tm.estado='2'\n" +
                                          "and tp.id_grupo='"+grupo+"'"+
                                          " and ti.estado='2'"+
                                          "or\n" +
                                          "tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                                          "and tm.id_tipo='1' and tm.estado='2'"+
                                          "and tp.id_grupo='"+grupo+"'"+
                                          "and ti.estado='2'"+
                                          "or\n" +
                                          "tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                                          "and tm.id_tipo='5' and tm.estado='2'"+
                                          "and tp.id_grupo='"+grupo+"'"+
                                          "and ti.estado='2'";
                              
                     }
                  }else{
                     //System.out.println("Filtro nao foi selecionado");
                  sql="select tb.codigo_barras,\n" +
                      "tp.nomelongo,\n" +
                      "cast (sum (ti.quantidade)as numeric(5)) as Quantidade,\n" +
                      "cast (sum (ti.total)as numeric (5,2))as Total,\n" +
                      "cast (sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Custo,\n" +
                      "cast (sum (ti.total )- sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Lucro,\n"
                          + "cast ((sum (ti.total)- sum((ti.quantidade)*ti.cust_unitario))/ iif(sum(ti.cust_total)=0,1,sum(ti.cust_total))*100 as numeric(5,2)) as porcentagem\n" +
                      "from titens ti\n" +
                      "join tprodutos tp on ti.id_prod=tp.id\n" +
                      "join tprecos tr on ti.id_prod=tr.id\n" +
                      "join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                      "join tbarras tb on tp.id=tb.id_produto\n" +
                      "where tm.id_tipo='2'and tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                      "and tm.estado='2' and ti.estado='2'\n" +
                      "or\n" +
                      "tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                      "and tm.id_tipo='1' and tm.estado='2' and ti.estado='2'\n"+ 
                      "or\n" +
                      "tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                      "and tm.id_tipo='5' and tm.estado='2' and ti.estado='2'\n"+    
                      "GROUP BY 1,2 "+ordem;
                  qtdtotal="select\n" +
                           "cast (sum (ti.quantidade)as numeric(5)) as Quantidade,\n" +
                           "cast (sum (ti.total)as numeric (5,2))as Total,\n" +
                           "cast (sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Custo,\n" +
                           "cast (sum (ti.total )- sum((ti.quantidade)*ti.cust_unitario)as numeric (5,2)) as Lucro,\n"
                          + "cast ((sum (ti.total)- sum((ti.quantidade)*ti.cust_unitario))/ iif(sum(ti.cust_total)=0,1,sum(ti.cust_total))*100 as numeric(5,2)) as porcentagem\n" +
                           "from titens ti\n" +
                           "join tprodutos tp on ti.id_prod=tp.id\n" +
                           "join tprecos tr on ti.id_prod=tr.id\n" +
                           "join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                           "where tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                           "and tm.id_tipo='2' and tm.estado='2' and ti.estado='2'\n" +
                           "or\n" +
                           "tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                           "and tm.id_tipo='1' and tm.estado='2' and ti.estado='2'\n" +
                           "or\n" +
                           "tm.dat_finalizacao between '"+dtini+"' and '"+dtfim+"'\n" +
                           "and tm.id_tipo='5' and tm.estado='2' and ti.estado='2'";
                  } 
                PreparedStatement ps=conexao.getPreparedStatementResult(qtdtotal);
                PreparedStatement pst= conexao.getPreparedStatement(sql);
                ResultSet rs = ps.executeQuery();
                rs.first();
                String qtde=rs.getString(1);
                String tvendas=rs.getString(2);
                String tcustos=rs.getString(3);
                String tlucros=rs.getString(4);
                String tporce=rs.getString(5);
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
                parametros.put("qtdevendas",qtde);
                parametros.put("tvenda",tvendas);
                parametros.put("tcusto",tcustos);
                parametros.put("tlucro",tlucros);
                parametros.put("tporcent", tporce);
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
            java.util.logging.Logger.getLogger(relVendasporProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relVendasporProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relVendasporProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relVendasporProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                relVendasporProdutos dialog = new relVendasporProdutos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLimpa;
    private javax.swing.JCheckBox cbFiltro;
    private javax.swing.JComboBox<String> cbGrupo;
    private javax.swing.JComboBox<String> cbOrdem;
    private javax.swing.JFormattedTextField ftFinal;
    private javax.swing.JFormattedTextField ftInicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
