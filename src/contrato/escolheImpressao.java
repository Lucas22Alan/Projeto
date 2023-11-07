/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrato;

import classes.clsaux;
import classes.infRelatorios;
import conexoes.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.jasperreports.engine.JREmptyDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lucas
 */
public class escolheImpressao extends javax.swing.JDialog {

    /**
     * Creates new form escolheImpressao
     */
    public escolheImpressao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    static String idimpressao=null;
    public static String idparceiro=null;

   

    
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
        btnContrato = new javax.swing.JRadioButton();
        btnDecrankin = new javax.swing.JRadioButton();
        btnDecFili = new javax.swing.JRadioButton();
        btnModalidade = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnFiliaca = new javax.swing.JRadioButton();
        btnDecHab = new javax.swing.JRadioButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Impressão ");
        setBackground(new java.awt.Color(219, 227, 227));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnContrato.setBackground(new java.awt.Color(219, 227, 227));
        btnContrato.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        btnContrato.setText(" Contrato");
        btnContrato.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnContrato.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnDecrankin.setBackground(new java.awt.Color(255, 255, 255));
        btnDecrankin.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        btnDecrankin.setText(" Declaração Ranking");
        btnDecrankin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDecrankin.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDecrankin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecrankinActionPerformed(evt);
            }
        });

        btnDecFili.setBackground(new java.awt.Color(219, 227, 227));
        btnDecFili.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        btnDecFili.setText(" Guia Tráfego");
        btnDecFili.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDecFili.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnModalidade.setBackground(new java.awt.Color(255, 255, 255));
        btnModalidade.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        btnModalidade.setText(" Modalidade e Prova");
        btnModalidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModalidade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnModalidade.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModalidadeActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(87, 140, 140));

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/impressora.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jButton1)
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

        btnFiliaca.setBackground(new java.awt.Color(219, 227, 227));
        btnFiliaca.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        btnFiliaca.setText(" Declaracao filiacao");
        btnFiliaca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFiliaca.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnDecHab.setBackground(new java.awt.Color(255, 255, 255));
        btnDecHab.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        btnDecHab.setText(" Declaracao habitualidade");
        btnDecHab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDecHab.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDecrankin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDecFili, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFiliaca, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDecHab))
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnContrato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDecrankin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDecFili)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModalidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiliaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDecHab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModalidadeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.localizarImpressoes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDecrankinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecrankinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDecrankinActionPerformed
    public void pegaInfImpressao(){
       
    
    
    }
    public void localizarImpressoes(){
        try {
            if (btnContrato.isSelected()){
                 this.imprimeContrato();
                 this.dispose();
            }
            if (btnDecrankin.isSelected()){
                this.imprimeDeclaracaoranquing();
                this.dispose();
            }
            if (btnDecFili.isSelected()){
                this.imprimeDeclaracaoGuiaTrafego();
                this.dispose();
            }
            if (btnModalidade.isSelected()){
                this.imprimeModalidade();
                this.dispose();
            }
            if (btnFiliaca.isSelected()){
                this.imprimeFiliaco();
                this.dispose();
            }
            if (btnDecHab.isSelected()){
                this.imprimeHabitualidade();
                this.dispose();
            }
        } catch (JRException | SQLException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    }
    public static void imprimeContrato() throws JRException, SQLException{
        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
        viewer.setSize(1024,720);
        viewer.setLocationRelativeTo(null);
        JasperDesign jd = JRXmlLoader.load(".\\contrato\\contrato\\contrato.jrxml");
        JasperReport jr= JasperCompileManager.compileReport(jd);
        //JRBeanCollectionDataSource cds = new JRBeanCollectionDataSource();
        String sql="select tp.*,\n" +
"           te.*,"
                + "tc.valor as VALOR_MENSALIDADE,"
                + "tc.valor_plano as VALOR_DO_PLANO\n" +
"           from tparceiros tp\n" + 
"           join tenderecos te on tp.idparceiro=te.id_parceiro\n" +
"           join tcontrato tc on tp.idparceiro=tc.id_parceiro" +
          " where tc.id_contrato='"+idimpressao+"' ";
        PreparedStatement ps=conexao.getPreparedStatement(sql);
        ResultSet rs = ps.executeQuery();
        JRResultSetDataSource jrds= new JRResultSetDataSource(rs);
       // JREmptyDataSource jrds = new JREmptyDataSource();
        Map parametros = new HashMap();
        JasperPrint impre= JasperFillManager.fillReport(jr, parametros, jrds);
        JasperViewer jv = new JasperViewer(impre, true);
        viewer.getContentPane().add(jv.getContentPane());
        viewer.setVisible(true);
        //jv.show();
        
    }
    public void imprimeDeclaracaoranquing(){
        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
            viewer.setSize(1024,720);
            viewer.setLocationRelativeTo(null);
            JasperDesign jd;
            jd = JRXmlLoader.load(".\\contrato\\declaracaoRanking.jrxml");
         JasperReport jr= JasperCompileManager.compileReport(jd);
        //JRBeanCollectionDataSource cds = new JRBeanCollectionDataSource();
        String sql="select tp.razao_social as fNome,\n" +
"       tp.cr as fCr,\n" +
"       tp.num_filiacao as fFiliacao,\n" +
"       tp.data_filiacao as fData\n" +
"       from tparceiros tp\n" +
"       where tp.idparceiro='"+idparceiro+"' ";
        PreparedStatement ps=conexao.getPreparedStatementResult(sql);
        ResultSet rs = ps.executeQuery();
        rs.first();
        infRelatorios ir= new infRelatorios();
        ir.setfNome(rs.getString(1));
        ir.setfCr(rs.getString(2));
        ir.setfFiliacao(rs.getString(3));
        ir.setfData(clsaux.convertDataExib(rs.getString(4)));
        ir.setfAno(clsaux.retornaAno());
        ir.setfMes(clsaux.retornaMes());
        ir.setfDia(clsaux.retornaDia());
        List listage = new ArrayList();
        listage.add(ir);
        JRBeanCollectionDataSource cds = new JRBeanCollectionDataSource(listage);
        //JRResultSetDataSource jrds= new JRResultSetDataSource(rs);
        // JREmptyDataSource jrds = new JREmptyDataSource();
        Map parametros = new HashMap();
        JasperPrint impre= JasperFillManager.fillReport(jr, parametros, cds);
        JasperViewer jv = new JasperViewer(impre, true);
        viewer.getContentPane().add(jv.getContentPane());
        viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
           catch (SQLException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
    }
    public void imprimeDeclaracaoGuiaTrafego(){
        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
            viewer.setSize(1024,720);
             viewer.setLocationRelativeTo(null);
             JasperDesign jd;
            jd = JRXmlLoader.load(".\\contrato\\guiatrafego.jrxml");
         JasperReport jr= JasperCompileManager.compileReport(jd);
        
        String sql="select tp.razao_social as fNome,\n" +
"       tp.cr as fCr,\n" +
"       tp.num_filiacao as fFiliacao,\n" +
"       tp.data_filiacao as fData\n" +
"       from tparceiros tp\n" +
"       where tp.idparceiro='"+idparceiro+"' ";
        PreparedStatement ps=conexao.getPreparedStatementResult(sql);
        ResultSet rs = ps.executeQuery();
        rs.first();
        infRelatorios ir= new infRelatorios();
        ir.setfNome(rs.getString(1));
        ir.setfCr(rs.getString(2));
        ir.setfFiliacao(rs.getString(3));
        ir.setfData(clsaux.convertDataExib(rs.getString(4)));
        ir.setfAno(clsaux.retornaAno());
        ir.setfMes(clsaux.retornaMes());
        ir.setfDia(clsaux.retornaDia());
        List listage = new ArrayList();
        listage.add(ir);
        JRBeanCollectionDataSource cds = new JRBeanCollectionDataSource(listage);
        //JRResultSetDataSource jrds= new JRResultSetDataSource(rs);
        //JREmptyDataSource jrds = new JREmptyDataSource();
        Map parametros = new HashMap();
        JasperPrint impre= JasperFillManager.fillReport(jr, parametros, cds);
        JasperViewer jv = new JasperViewer(impre, true);
        viewer.getContentPane().add(jv.getContentPane());
        viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
           catch (SQLException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
    }
    public void imprimeModalidade(){
       try {
        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
        viewer.setSize(1024,720);
        viewer.setLocationRelativeTo(null);
        JasperDesign jd;
        jd = JRXmlLoader.load(".\\contrato\\modalidadeProva.jrxml");
        JasperReport jr= JasperCompileManager.compileReport(jd);
        String sql="select tp.razao_social as fNome,\n" +
"       tp.cr as fCr,\n" +
"       tp.num_filiacao as fFiliacao,\n" +
"       tp.data_filiacao as fData\n" +
"       from tparceiros tp\n" +
"       where tp.idparceiro='"+idparceiro+"' ";
        PreparedStatement ps=conexao.getPreparedStatementResult(sql);
        ResultSet rs = ps.executeQuery();
        rs.first();
        infRelatorios ir= new infRelatorios();
        ir.setfNome(rs.getString(1));
        ir.setfCr(rs.getString(2));
        ir.setfFiliacao(rs.getString(3));
        ir.setfData(clsaux.convertDataExib(rs.getString(4)));
        ir.setfAno(clsaux.retornaAno());
        ir.setfMes(clsaux.retornaMes());
        ir.setfDia(clsaux.retornaDia());
        ir.setfProva("treino");
        ir.setfArmamento("pistola");
        ir.setfModalidade("IPSC");
        List listage = new ArrayList();
        listage.add(ir);
        JRBeanCollectionDataSource cds = new JRBeanCollectionDataSource(listage);
        Map parametros = new HashMap();
        //parametros.put("modalidade", listage.size());
        JasperPrint impre= JasperFillManager.fillReport(jr, parametros, cds);
        JasperViewer jv = new JasperViewer(impre, true);
        viewer.getContentPane().add(jv.getContentPane());
        viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
           catch (SQLException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
    }
    public void imprimeFiliaco(){
         try {
        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
        viewer.setSize(1024,720);
        viewer.setLocationRelativeTo(null);
        JasperDesign jd;
        jd = JRXmlLoader.load(".\\contrato\\DeclaracaoFiliacao.jrxml");
        JasperReport jr= JasperCompileManager.compileReport(jd);
        String sql="select tp.razao_social as fNome,\n" +
"       tp.cr as fCr,\n" +
"       tp.num_filiacao as fFiliacao,\n" +
"       tp.data_filiacao as fData,"
                + "tp.cnpj as fCpf\n" +
"       from tparceiros tp\n" +
"       where tp.idparceiro='"+idparceiro+"' ";
        PreparedStatement ps=conexao.getPreparedStatementResult(sql);
        ResultSet rs = ps.executeQuery();
        rs.first();
        infRelatorios ir= new infRelatorios();
        ir.setfNome(rs.getString(1));
        ir.setfCr(rs.getString(2));
        ir.setfFiliacao(rs.getString(3));
        ir.setfData(clsaux.convertDataExib(rs.getString(4)));
        ir.setfAno(clsaux.retornaAno());
        ir.setfMes(clsaux.retornaMes());
        ir.setfDia(clsaux.retornaDia());
        ir.setfCpf(rs.getString(5));
        List listage = new ArrayList();
        listage.add(ir);
        JRBeanCollectionDataSource cds = new JRBeanCollectionDataSource(listage);
        Map parametros = new HashMap();
        //parametros.put("modalidade", listage.size());
        JasperPrint impre= JasperFillManager.fillReport(jr, parametros, cds);
        JasperViewer jv = new JasperViewer(impre, true);
        viewer.getContentPane().add(jv.getContentPane());
        viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
           catch (SQLException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
    }
    public void imprimeHabitualidade(){
        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
            viewer.setSize(1024,720);
             viewer.setLocationRelativeTo(null);
             JasperDesign jd;
            jd = JRXmlLoader.load(".\\contrato\\DeclaracaoHabitualidade.jrxml");
         JasperReport jr= JasperCompileManager.compileReport(jd);
        //JRBeanCollectionDataSource cds = new JRBeanCollectionDataSource();
        String sql="select tp.razao_social as fNome,\n" +
"       tp.cr as fCr,\n" +
"       tp.num_filiacao as fFiliacao,\n" +
"       tp.data_filiacao as fData\n" +
"       from tparceiros tp\n" +
"       where tp.idparceiro='"+idparceiro+"' ";
        PreparedStatement ps=conexao.getPreparedStatementResult(sql);
        ResultSet rs = ps.executeQuery();
        rs.first();
        infRelatorios ir= new infRelatorios();
        ir.setfNome(rs.getString(1));
        ir.setfCr(rs.getString(2));
        ir.setfFiliacao(rs.getString(3));
        ir.setfData(clsaux.convertDataExib(rs.getString(4)));
        ir.setfAno(clsaux.retornaAno());
        ir.setfMes(clsaux.retornaMes());
        ir.setfDia(clsaux.retornaDia());
        List listage = new ArrayList();
        listage.add(ir);
        JRBeanCollectionDataSource cds = new JRBeanCollectionDataSource(listage);
        //JRResultSetDataSource jrds= new JRResultSetDataSource(rs);
        // JREmptyDataSource jrds = new JREmptyDataSource();
        Map parametros = new HashMap();
        JasperPrint impre= JasperFillManager.fillReport(jr, parametros, cds);
        JasperViewer jv = new JasperViewer(impre, true);
        viewer.getContentPane().add(jv.getContentPane());
        viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
           catch (SQLException ex) {
            Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio...\n"+ex);
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
       try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
           try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
           } catch (InstantiationException ex) {
               Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IllegalAccessException ex) {
               Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
           } catch (UnsupportedLookAndFeelException ex) {
               Logger.getLogger(escolheImpressao.class.getName()).log(Level.SEVERE, null, ex);
           }
}
        
        
        
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                escolheImpressao dialog = new escolheImpressao(new javax.swing.JFrame(), true);
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
    private javax.swing.JRadioButton btnContrato;
    private javax.swing.JRadioButton btnDecFili;
    private javax.swing.JRadioButton btnDecHab;
    private javax.swing.JRadioButton btnDecrankin;
    private javax.swing.JRadioButton btnFiliaca;
    private javax.swing.JRadioButton btnModalidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}