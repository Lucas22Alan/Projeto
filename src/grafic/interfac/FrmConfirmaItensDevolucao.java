/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import Controller.BaseDevolucaoAuto;
import DAO.BaseGeralDAO;
import DAO.clienteDAO;
import DAO.lancDocumentDAO;
import DAO.nfeDAO;
import classes.ClsParametrizaTributos;
import classes.clsaux;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.clientes;
import model.clsLancDocCabecalho;
import model.clsLancDocument;
import model.clsNfTransporte;
import model.clsNfe;

/**
 *
 * @author Lucas
 */
public class FrmConfirmaItensDevolucao extends javax.swing.JDialog {

    /**
     * Creates new form FrmConfirmaItensDevolucao
     */
    public FrmConfirmaItensDevolucao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pegaDuploClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtNfe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNfs = new javax.swing.JTextField();
        txtNomeParceiro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCfop = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmar Itens Devolução");

        jPanel1.setBackground(new java.awt.Color(219, 227, 227));

        tbItens.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "X", "Descricao", "Quantidade", "Unitario", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbItens.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbItens.setRowHeight(20);
        tbItens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbItens);
        if (tbItens.getColumnModel().getColumnCount() > 0) {
            tbItens.getColumnModel().getColumn(0).setResizable(false);
            tbItens.getColumnModel().getColumn(1).setResizable(false);
            tbItens.getColumnModel().getColumn(1).setPreferredWidth(290);
            tbItens.getColumnModel().getColumn(2).setResizable(false);
            tbItens.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbItens.getColumnModel().getColumn(3).setResizable(false);
            tbItens.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbItens.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setText("Nº Nfe:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Nfe's Informadas:");

        txtNfs.setEditable(false);

        txtNomeParceiro.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Parceiro:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Cnpj:");

        txtCnpj.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("CFOP Utilizar Nfe:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNfe, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNfs, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCfop, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNfs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCfop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Confirma.png"))); // NOI18N
        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Total NFE R$:");

        lbTotal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel6)))
                .addGap(10, 10, 10))
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
     gerarRegistro();
    }//GEN-LAST:event_jButton1ActionPerformed

    List<clsLancDocument> itens= new ArrayList<>();
    List<clsLancDocCabecalho> notas= new ArrayList<>();
    clsLancDocCabecalho ld = new clsLancDocCabecalho();
    lancDocumentDAO ldDAO= new lancDocumentDAO();
    clientes parceiro= new clientes();
    clsNfe nf = new clsNfe();
    
    public void inicia(String mvtoOrig){
        ld.setIdmovimento(mvtoOrig);
        ldDAO.buscaCabecalhoDoc(ld);
        itens= ldDAO.buscaItens(mvtoOrig);
        notas.add(ld);
        txtNfs.setText(ld.getDocument());
        parceiro=clienteDAO.buscar("nada", parceiro, ld.getIdparceiro());
        txtCnpj.setText(parceiro.getCnpj());
        txtNomeParceiro.setText(parceiro.getRazaoSocial());
        txtCfop.setText("5202");
        populaTabela();
    }
    
    public void populaTabela(){
        DefaultTableModel tb= (DefaultTableModel) tbItens.getModel();
        for(clsLancDocument it:itens){
            tb.addRow(new Object[]{
                new Boolean(false),
                it.getDescricaofornecedor(),
                it.getQuantidade(),
                it.getPrecovenda(),
                it.getTotal()
            });
        }
    }
    public void pegaDuploClick(){
        tbItens.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e ){
                if(e.getClickCount()==1){
                    validaCelulaMarcada();
                }
            }
          
        }); 
    }
    public void validaCelulaMarcada(){
        Double selecionado=0.00;
             for (int i=0; i<tbItens.getRowCount(); i++){
               if((Boolean)tbItens.getValueAt(i, 0)==true){
                   selecionado=selecionado+(clsaux.capturaValores(tbItens.getValueAt(i, 2).toString())*clsaux.capturaValores(tbItens.getValueAt(i, 3).toString()));
                }
             }
          
        lbTotal.setText(clsaux.formato(selecionado));
    }
    
    
   
    public void gerarRegistro(){
        BaseDevolucaoAuto basedev= new BaseDevolucaoAuto();
        List<clsLancDocument> itensnovo= new ArrayList<>();
        for (int i=0; i<tbItens.getRowCount(); i++){
               if((Boolean)tbItens.getValueAt(i, 0)==true){
                   Double qnt= clsaux.capturaValores(tbItens.getValueAt(i, 2).toString());
                   itens.get(i).setQuantidade(qnt.toString());
                   itensnovo.add(itens.get(i));
                   System.out.println(itens.toString());
                }
         }
        
        if(itensnovo.size()>0){
            String idmovNovo=new BaseGeralDAO().gerarIds("GEN_TMOVIMENTO_ID");
            String chaveCompra=ld.getChaveacesso();
            ld.setIdmovimento(idmovNovo);
            nf=basedev.gerarInfNfe(nf, ld,parceiro);
                ld=basedev.limparDadosReg(ld);
                ldDAO.atualizaRegistroMovto(ld);
                recalculaValoresCabecalho(itensnovo, idmovNovo);
                ldDAO.atualizaRegistroMovto(ld);
               nfeDAO.inserirMovimentoNfe(nf);
               nfeDAO.gravaInfReferencia(idmovNovo, chaveCompra);
               clsNfTransporte tr= new clsNfTransporte();
               tr.setIdmovimento(idmovNovo);
               tr.setModfrete("9");
               nfeDAO.inserirAtualizaTransporteNf(tr);
               this.dispose();
            }else{
            JOptionPane.showMessageDialog(null, "Nenhum Item Marcado!");
        }
    }
    
    public void recalculaValoresCabecalho(List<clsLancDocument> dados,String mvto){
        Double baseicms=0.00,basest=0.00,baseipi=0.00;
        Double vlicms=0.00,vlst=0.00,vlipi=0.00,vlpis=0.00,vlcofins=0.00,vlprod=0.00,vltotal=0.00;
        for(clsLancDocument ite:dados){
                ite.setIdmovto(mvto);
                if(ite.getCst().length()<3) ite.setCst("900");
                ite.setCfop(new ClsParametrizaTributos().parametricaCfopConformeCstNfe(ite.getCst(), "4", "S", nf.getInddest()));
                ite=new ClsParametrizaTributos().calculaValoresItem(ite);
                ldDAO.insereItensReferenteMovto(ite);
                baseicms=baseicms+clsaux.capturaValores(ite.getBase_icms());
                basest=basest+clsaux.capturaValores(ite.getBase_st());
                baseipi=baseipi+clsaux.capturaValores(ite.getBase_ipi());
                vlicms=vlicms+clsaux.capturaValores(ite.getValor_icms());
                vlst=vlst+clsaux.capturaValores(ite.getValor_st());
                vlipi=vlipi+clsaux.capturaValores(ite.getValor_ipi());
                vlpis=vlpis+clsaux.capturaValores(ite.getValor_pis());
                vlcofins=vlcofins+clsaux.capturaValores(ite.getValor_cofins());
                vlprod=vlprod+clsaux.capturaValores(ite.getSubtotal());
                vltotal=vltotal+clsaux.capturaValores(ite.getTotal());
            }
        ld.setTotalprod(vlprod.toString());
        ld.setBaseicms(baseicms.toString());
        ld.setBasest(basest.toString());
        ld.setValoripi(vlipi.toString());
        ld.setValoricms(vlicms.toString());
        ld.setValorst(vlst.toString());
        ld.setValor_cofins(vlcofins.toString());
        ld.setValor_pis(vlpis.toString());
        ld.setTotal(vltotal.toString());
        
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
            java.util.logging.Logger.getLogger(FrmConfirmaItensDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConfirmaItensDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConfirmaItensDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConfirmaItensDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmConfirmaItensDevolucao dialog = new FrmConfirmaItensDevolucao(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tbItens;
    private javax.swing.JTextField txtCfop;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtNfe;
    private javax.swing.JTextField txtNfs;
    private javax.swing.JTextField txtNomeParceiro;
    // End of variables declaration//GEN-END:variables
}
