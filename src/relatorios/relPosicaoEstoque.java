/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import DAO.listaGrupDAO;
import classes.clsaux;
import conexoes.conexao;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.clsDadosEmpresa;
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
 * @author Mk Solucoes
 */
public class relPosicaoEstoque extends javax.swing.JDialog {

    /**
     * Creates new form relPosicaoEstoque
     */
    public relPosicaoEstoque(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicia();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbFiltro = new javax.swing.JComboBox<>();
        cbGrupo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ckTodos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Posição De Estoque");

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatorio Posição De Estoque");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Tipo Produto:");

        cbFiltro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativos +", "Todos", "Inativos", "estoque 0", "estoque positivo", "estoque negativo" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Grupo:");

        ckTodos.setBackground(new java.awt.Color(255, 255, 255));
        ckTodos.setSelected(true);
        ckTodos.setText("Todos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFiltro, 0, 148, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(ckTodos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ckTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.relEstoque(cbFiltro.getSelectedIndex());
        } catch (JRException ex) {
            Logger.getLogger(relPosicaoEstoque.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(relPosicaoEstoque.class.getName()).log(Level.SEVERE, null, ex);
             Logs.gravarLog.main(ex.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown

    }//GEN-LAST:event_jPanel2ComponentShown

    public void inicia(){
       DefaultComboBoxModel cb = new DefaultComboBoxModel(listaGrupDAO.listagrupo().toArray());
        cbGrupo.setModel(cb);
    }
    
     public void relEstoque(int selecionado) throws JRException, SQLException{
         String comp="";
            switch(selecionado){
                case 0 : comp="and tp.ativo='S'";
                        break;
                case 2: comp="and tp.ativo='N'";
                break;
                case 3: comp="and te.estoque=0";
                break;
                case 4: comp="and te.estoque>0";
                break;
                case 5: comp="and te.estoque<0";
                break;
            }
            String compgrupo="";
            if(ckTodos.isSelected());
            else{
                String grupo= clsaux.retornaId(cbGrupo.getSelectedItem());
                compgrupo=" and tp.id_grupo="+grupo;
            }
         String sql2="select tp.nomelongo,\n" +
                            "                    tb.baixa_barra as codigobaixa,\n" +
                            "                    te.estoque,\n" +
                            "                    cast ((tr.preco_custo)as numeric (10,2))as Custo,\n" +
                            "                    cast (sum(tr.preco_custo*te.estoque)as numeric (10,2)) as TCusto,\n" +
                            "                    cast ((tr.preco_venda)as numeric (10,2))as Venda,\n" +
                            "                    cast (sum(tr.preco_venda*te.estoque)as numeric (10,2)) as TVenda ,\n" +
                            "                    cast (sum(tr.preco_venda*te.estoque)-(sum(tr.preco_custo*te.estoque))as numeric (10,2)) as Lucro\n" +
                            "                    from tprodutos tp\n" +
                            "                    join tbarras tb on tp.id=tb.id_produto\n" +
                            "                    join stp_calc_estoque ((select data_inventario from tconfig),current_date) te on te.codproduto=tb.baixa_barra\n" +
                            "                    join tprecos tr on tp.id=tr.id\n" +
                            "                    where tp.excluido='N' " +comp+" "+compgrupo+" \n"+
                            "                    Group by 1,2,3,4,6 order by 3 asc ";
               String qtdtotal2="  select\n" +
                            "                         sum (te.estoque)as qtde,\n" +
                            "                         cast (sum(tr.preco_custo*te.estoque)as numeric (10,2)) as TCusto,\n" +
                            "                         cast (sum(tr.preco_venda*te.estoque)as numeric (10,2)) as TVenda ,\n" +
                            "                         cast (sum(tr.preco_venda*te.estoque)-(sum(tr.preco_custo*te.estoque))as numeric (10,2)) as Lucro\n" +
                            "                         from tprodutos tp\n" +
                            "                         join tbarras tb on tp.id=tb.id_produto\n" +
                            "                         join stp_calc_estoque ((select data_inventario from tconfig),current_date) te on te.codproduto=tb.baixa_barra\n" +
                            "                         join tprecos tr on tp.id=tr.id\n" +
                            "                         where tp.excluido='N'  " +comp+" "+compgrupo+"";
       try {
       JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
                viewer.setSize(1024,720);
                viewer.setLocationRelativeTo(null);
                JasperDesign jd;
                jd = JRXmlLoader.load(".\\relatorios\\relestoque.jrxml");
                JasperReport jr= JasperCompileManager.compileReport(jd);
                PreparedStatement ps=conexao.getPreparedStatementResult(qtdtotal2);
                PreparedStatement pst= conexao.getPreparedStatement(sql2);
                ResultSet rs = ps.executeQuery();
                rs.first();  
                String estoque=rs.getString(1);                
                String tcustos=rs.getString(2);
                String tvendas=rs.getString(3);
                String tlucros=rs.getString(4);
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
                parametros.put("dtini","");
                parametros.put("dtfim","");
                parametros.put("estoque",estoque);
                parametros.put("tvenda",tvendas);
                parametros.put("tcusto",tcustos);
                parametros.put("tlucro",tlucros);
                JasperPrint impre= JasperFillManager.fillReport(jr, parametros, jrds);
                JasperViewer jv = new JasperViewer(impre, true);
                viewer.getContentPane().add(jv.getContentPane());
                viewer.setVisible(true);
                rs.close();
                ps.close();
        } catch (JRException ex) {
            Logger.getLogger(relCReceber.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch(HeadlessException e){
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
            java.util.logging.Logger.getLogger(relPosicaoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relPosicaoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relPosicaoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relPosicaoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                relPosicaoEstoque dialog = new relPosicaoEstoque(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JComboBox<String> cbGrupo;
    private javax.swing.JCheckBox ckTodos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
