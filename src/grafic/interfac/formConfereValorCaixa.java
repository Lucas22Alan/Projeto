/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import DAO.ConferenciaCxDAO;
import DAO.ContasReceberDAO;
import DAO.baseCaixaDAO;
import DAO.configuracaoDAO;
import DAO.listaDAO;
import DAO.listaInfAdcDAO;
import Impressao.ImpFechamentoCaixa;
import classes.ClsInformaFinanceiro;
import classes.clsFechamentoCaixa;
import classes.clsFinalizadora;
import classes.clsSuprimentoSangria;
import classes.clsaux;
import util.criaBotaoTabela;
import conexoes.conexao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CadContasRecPagar;
import model.Tcondicoes_venda;
import model.Tfinalizadoras;
import model.clsConfig;
import model.clsDadosPagamentoAdm;
import model.clsPagamentos;
import model.tfechamento_cego;

/**
 *
 * @author Lucas
 */
public class formConfereValorCaixa extends javax.swing.JDialog {
        String idcaixa,conferido,pdv=null;
        List<clsFinalizadora> finas= new ArrayList<>();
        List<String> listaFinalizadora= new ArrayList<>();
        
    /**
     * Creates new form formConfereValorCaixa
     */
    public formConfereValorCaixa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.inicia();
        
    }
    public void inicia(){
        TblConfcx.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e ){
                if (e.getClickCount()==2){
                    buscaInfFinalizadora(TblConfcx.getValueAt(TblConfcx.getSelectedRow(), 0).toString());
                } 
            }
          
        }); 
        listaFinalizadora=listaDAO.listapagamento();
    }
    public void iniciaValores(Date datain, Date datafim, String hrini, String hrfim, String idpdv,String idcx,String estado){
        conferido=estado;
        LbDatConf.setText(clsaux.convertDataExib(String.valueOf(datafim)));
        Lbsttsconferencia.setText("Em Conferencia");
        pdv=idpdv;
        DefaultTableModel tbto= (DefaultTableModel) TblConfcx.getModel();
        if(estado.equals("Sim")){
            Lbsttsconferencia.setText("Conferido");
            try{
            String sqlins="select tc.id_finalizadora,\n" +
                        "        tf.descricao,\n" +
                        "        tc.valor_apurado,\n" +
                        "        tc.valor_digitado,\n" +
                        "        tc.valor_conferido\n" +
                        "        from tconferencia_cx tc\n" +
                        "join tfinalizadora tf on tf.id_finalizdora=tc.id_finalizadora\n" +
                        " where tc.id_caixa=? order by 1 asc";
            PreparedStatement psins= conexao.getPreparedStatement(sqlins);
            psins.setString(1, idcx);
            ResultSet rsins = psins.executeQuery();
            while(rsins.next()){
                tbto.addRow(new Object[]{
                    rsins.getObject(1),
                    rsins.getObject(2),
                    clsaux.formato(rsins.getDouble(3)),
                    clsaux.formato(rsins.getDouble(4)),
                    "0,00",
                    clsaux.formato(rsins.getDouble(3)-rsins.getDouble(4))          
                });
            }
            }catch (SQLException err){
                Logger.getLogger(formConfereValorCaixa.class.getName()).log(Level.SEVERE, null, err);
            }
        }else{
        idcaixa=idcx;
        /*Double valorinformado=0.00;
        Double valorconferido=0.00;
        String sqltotais="select c.descricao,\n" +
                        "        sum (b.valor)as total,"
                + "              c.id_finalizdora from tpagamentos_pdv b\n" +
                        "join tfinalizadora c on b.id_finalizadora=c.id_finalizdora\n" +
                        "where b.id_movimento in (select a.id_mov from tmovimento a where a.id_caixa='"+idcx+"' and a.estado='2' and a.numero_pdv='"+idpdv+"')\n" +
                        "and b.estado='2' group by 1,3 order by 3 asc";
        PreparedStatement psto= conexao.getPreparedStatement(sqltotais);
        System.out.println(sqltotais);
        try {
            ResultSet rsto= psto.executeQuery();
            while(rsto.next()){
                tbto.addRow(new Object []{
                    rsto.getObject(3),
                    rsto.getObject(1),
                    rsto.getObject(2),
                    valorinformado,
                    valorconferido,
                    
                });
            
            }
            rsto.close();
            psto.close();
        } catch (SQLException ex) {
            Logger.getLogger(formConfereValorCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        this.consultarValores(idcaixa);
       }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Btnconf = new javax.swing.JButton();
        LbDatConf = new javax.swing.JLabel();
        LbStts = new javax.swing.JLabel();
        Lbsttsconferencia = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        txtOutras = new javax.swing.JTextField();
        txtInicial = new javax.swing.JTextField();
        txtRetiradas = new javax.swing.JTextField();
        txtReforco = new javax.swing.JTextField();
        txtVendBruta = new javax.swing.JTextField();
        txtCancelamentos = new javax.swing.JTextField();
        txtVendLiq = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblConfcx = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRet = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMovFin = new javax.swing.JTable();
        Btnconf1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conferencia de Valores de Caixa");

        jPanel1.setBackground(new java.awt.Color(219, 227, 227));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Conferencia de valores de caixa do dia:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Atenção ! Será considerado no financeiro o valor conferido, portanto nesta janela é possivel corrigir eventuais  erros  ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("de digitação do operador");

        Btnconf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btnconf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Confirma.png"))); // NOI18N
        Btnconf.setText("Conferido");
        Btnconf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnconfActionPerformed(evt);
            }
        });

        LbDatConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        LbStts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbStts.setText("Status:");

        Lbsttsconferencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Lbsttsconferencia.setForeground(new java.awt.Color(204, 0, 0));
        Lbsttsconferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LbsttsconferenciaFocusGained(evt);
            }
        });

        jLabel4.setText("Venda Bruta:");

        jLabel5.setText("Cancelamentos:");

        jLabel6.setText("Venda Liquida:");

        jLabel7.setText("Saldo Inicial:");

        jLabel8.setText("Retiradas:");

        jLabel9.setText("Reforço:");

        jLabel10.setText("Valor Outras Org:");

        jLabel11.setText("Saldo:");

        txtSaldo.setEditable(false);

        txtOutras.setEditable(false);

        txtInicial.setEditable(false);

        txtRetiradas.setEditable(false);

        txtReforco.setEditable(false);

        txtVendBruta.setEditable(false);

        txtCancelamentos.setEditable(false);

        txtVendLiq.setEditable(false);

        TblConfcx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Finalizadora", "Valor Apurado", "Valor Informado", "Valor Conferido", "Diferença Apurada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblConfcx.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(TblConfcx);
        if (TblConfcx.getColumnModel().getColumnCount() > 0) {
            TblConfcx.getColumnModel().getColumn(0).setResizable(false);
            TblConfcx.getColumnModel().getColumn(0).setPreferredWidth(100);
            TblConfcx.getColumnModel().getColumn(1).setResizable(false);
            TblConfcx.getColumnModel().getColumn(1).setPreferredWidth(120);
            TblConfcx.getColumnModel().getColumn(2).setResizable(false);
            TblConfcx.getColumnModel().getColumn(2).setPreferredWidth(100);
            TblConfcx.getColumnModel().getColumn(3).setResizable(false);
            TblConfcx.getColumnModel().getColumn(3).setPreferredWidth(100);
            TblConfcx.getColumnModel().getColumn(4).setResizable(false);
            TblConfcx.getColumnModel().getColumn(4).setPreferredWidth(60);
            TblConfcx.getColumnModel().getColumn(5).setResizable(false);
            TblConfcx.getColumnModel().getColumn(5).setPreferredWidth(300);
            TblConfcx.getColumnModel().getColumn(5).setHeaderValue("Diferença Apurada");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Finalizadoras", jPanel2);

        tbRet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Finalizadora", "Valor", "Hora", "Tipo", "Observacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRet.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tbRet);
        if (tbRet.getColumnModel().getColumnCount() > 0) {
            tbRet.getColumnModel().getColumn(0).setResizable(false);
            tbRet.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbRet.getColumnModel().getColumn(1).setResizable(false);
            tbRet.getColumnModel().getColumn(1).setPreferredWidth(120);
            tbRet.getColumnModel().getColumn(2).setResizable(false);
            tbRet.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbRet.getColumnModel().getColumn(3).setResizable(false);
            tbRet.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbRet.getColumnModel().getColumn(4).setResizable(false);
            tbRet.getColumnModel().getColumn(4).setPreferredWidth(60);
            tbRet.getColumnModel().getColumn(5).setResizable(false);
            tbRet.getColumnModel().getColumn(5).setPreferredWidth(300);
            tbRet.getColumnModel().getColumn(5).setHeaderValue("Diferença Apurada");
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Retiradas / Reforços", jPanel3);

        txtObs.setEditable(false);
        jScrollPane3.setViewportView(txtObs);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Observacao Fechamento Cego", jPanel4);

        tbMovFin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Movimento", "Finalizadora", "Valor Venda", "Troco", "Condicao", "Acao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMovFin.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbMovFin.setRowHeight(20);
        tbMovFin.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbMovFin);
        if (tbMovFin.getColumnModel().getColumnCount() > 0) {
            tbMovFin.getColumnModel().getColumn(0).setResizable(false);
            tbMovFin.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbMovFin.getColumnModel().getColumn(1).setResizable(false);
            tbMovFin.getColumnModel().getColumn(1).setPreferredWidth(70);
            tbMovFin.getColumnModel().getColumn(2).setResizable(false);
            tbMovFin.getColumnModel().getColumn(2).setPreferredWidth(120);
            tbMovFin.getColumnModel().getColumn(3).setResizable(false);
            tbMovFin.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbMovFin.getColumnModel().getColumn(4).setResizable(false);
            tbMovFin.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbMovFin.getColumnModel().getColumn(5).setResizable(false);
            tbMovFin.getColumnModel().getColumn(5).setPreferredWidth(60);
            tbMovFin.getColumnModel().getColumn(6).setResizable(false);
            tbMovFin.getColumnModel().getColumn(6).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Movimento Finalizadora", jPanel5);

        Btnconf1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btnconf1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IMPPDV.png"))); // NOI18N
        Btnconf1.setText("Imprime");
        Btnconf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btnconf1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCancelamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVendLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVendBruta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRetiradas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtReforco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOutras, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LbDatConf, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(LbStts)
                                .addGap(18, 18, 18)
                                .addComponent(Lbsttsconferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Btnconf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btnconf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(txtOutras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVendBruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(txtRetiradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCancelamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReforco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVendLiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbDatConf, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(LbStts)
                    .addComponent(Lbsttsconferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(Btnconf1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btnconf))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnconfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnconfActionPerformed
       if(conferido.equals("Sim")){
           JOptionPane.showMessageDialog(null, "Caixa já conferido!!!");
       }else{
        this.pegaValorInsereDb();
       }
    }//GEN-LAST:event_BtnconfActionPerformed

    private void LbsttsconferenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LbsttsconferenciaFocusGained
       corrigeValorFinalizadora();
    }//GEN-LAST:event_LbsttsconferenciaFocusGained

    private void Btnconf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnconf1ActionPerformed
       new ImpFechamentoCaixa("Reimp. Fechamento Caixa",pdv);
    }//GEN-LAST:event_Btnconf1ActionPerformed

    public void consultarValores(String idcaixa){
        try {
             String sql="select tf.descricao,\n" +
                        "        sum(iif(tc.valor_entrada is null, 0,tc.valor_entrada)) as valor_entrada,\n" +
                        "        sum(iif(tc.valor_saida is null,0,tc.valor_saida)) as valor_saida\n" +
                        "        from tmov_caixa tc\n" +
                        "        join tfinalizadora tf on tc.id_finalizadora=tf.id_finalizdora\n" +
                        "        where id_caixa='"+idcaixa+"' and id_finalizadora='1' and tipo='0' and (tc.inicial='N' or tc.inicial is null) group by 1";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            clsFechamentoCaixa.setRetiradas(rs.getDouble(3));
            clsFechamentoCaixa.setSuprimentos(rs.getDouble(2));
            rs.close();
            sql=" select\n" +
"                                sum(iif(tc.valor_entrada is null, 0,tc.valor_entrada)) as valor_entrada,\n" +
"                                sum(iif(tc.valor_saida is null,0,tc.valor_saida)) as valor_saida\n" +
"                                from tmov_caixa tc where id_caixa='"+idcaixa+"' and tipo>0";
            ps=conexao.getPreparedStatementResult(sql);
            ResultSet rs1=ps.executeQuery();
            rs1.first();
            clsFechamentoCaixa.setOutras(rs1.getDouble(1));
            rs1.close();
            sql="select sum(tm.total) as total\n" +
                "       from tmovimento tm\n" +
                "       where (tm.estado='2' or tm.estado='3') and tm.id_caixa='"+idcaixa+"' and tm.id_tipo=1";
            ps=conexao.getPreparedStatement(sql);
            ResultSet rss= ps.executeQuery();
            rss.next();
            clsFechamentoCaixa.setVendabruta(rss.getDouble(1));
            rss.close();
            sql="select  tf.descricao,\n" +
"                                sum(iif(tc.valor_entrada is null, 0,tc.valor_entrada)) as valor_entrada,\n" +
"                                sum(iif(tc.valor_saida is null,0,tc.valor_saida)) as valor_saida\n" +
"                                from tmov_caixa tc\n" +
"                                join tfinalizadora tf on tc.id_finalizadora=tf.id_finalizdora\n" +
"                                where id_caixa='"+idcaixa+"' group by 1";
            ps=conexao.getPreparedStatement(sql);
            ResultSet rs2=ps.executeQuery();
            List<String> outras= new ArrayList<>();
            while(rs2.next()){
                String re=rs2.getString(1)+"-"+rs2.getString(2);
                outras.add(re);
            }
            rs2.close();
            String sqlfin="select sum(tm.total) as total,\n" +
                "       sum (tf.valor-tf.troco) as total_finalizadora,\n" +
                "       tfin.descricao,tfin.id_finalizdora\n" +
                "       from tmovimento tm\n" +
                "       join tpagamentos_pdv tf on tm.id_mov=tf.id_movimento\n" +
                "       join tfinalizadora tfin on tf.id_finalizadora=tfin.id_finalizdora\n" +
                "       where tf.estado='2' and tm.estado='2' and tm.id_caixa='"+idcaixa+"' and tm.id_tipo=1 \n" +
                "       group by 3,4;";
            ps= conexao.getPreparedStatement(sqlfin);
            ResultSet rsf = ps.executeQuery();
            List<String > intermed= new ArrayList<>();
            String vlaarr=null;
           while (rsf.next()){
                
               /*if (rsf.getString(3).equals("DINHEIRO")){
                    System.out.println(rsf.getDouble(2));
                    Double totalfinaliza=rsf.getDouble(2)-clsFechamentoCaixa.getRetiradas();
                    vlaarr=rsf.getString(3)+"-"+clsaux.formato(totalfinaliza);
                    outras.add(vlaarr);
                    System.out.println(vlaarr);
                }else {*/
                    vlaarr=rsf.getString(3)+"-"+clsaux.formato(rsf.getDouble(2));
                    outras.add(vlaarr);
                //}
             }
           
              HashMap<String, Double> valid = new HashMap<>();
              
              for(String novo: outras){
                  String chave=clsaux.retornaId(novo);
                  Double vl= clsaux.capturaValores(clsaux.retornaAposId(novo));
                  if(valid.containsKey(clsaux.retornaId(novo))){
                      valid.put(chave, valid.get(chave)+vl);
                  }else{
                      valid.put(clsaux.retornaId(novo),vl);
                  }
              
              }
              for(Object tes :  valid.entrySet().toArray()){
                  String tempo=tes.toString().replaceAll("=", "-");
                  if(clsaux.retornaId(tempo).equals("DINHEIRO")){
                      Double valortempo=clsaux.capturaValores(clsaux.retornaAposId(tempo))-clsFechamentoCaixa.getRetiradas();
                      tempo="DINHEIRO-"+valortempo;
                  }
                  intermed.add(tempo);
                  
                 
              }
              
            clsFechamentoCaixa.finalizadoras=(ArrayList<String>) intermed;
            rsf.close();
            ps.close();
            baseCaixaDAO bs= new baseCaixaDAO();
            clsFechamentoCaixa.setCancelamentos(bs.retornaValorVendaCancelada(idcaixa));
            clsFechamentoCaixa.setSaldoinicial(bs.retornaSaldoInicial(idcaixa));
            clsFechamentoCaixa.setSuprimento(bs.consSuprimento(idcaixa,"0"));
            clsFechamentoCaixa.setSangria(bs.consSangria(idcaixa));
            clsFechamentoCaixa.setOutrasOrigens(bs.consSuprimentoOutrasOrigens(idcaixa));
            bs.consultaDadosAbertura(idcaixa);
            Double vendliq= clsFechamentoCaixa.getVendabruta()-clsFechamentoCaixa.getCancelamentos();
            Double saldo=vendliq+clsFechamentoCaixa.getSuprimentos()-clsFechamentoCaixa.getRetiradas()+clsFechamentoCaixa.getOutras()+clsFechamentoCaixa.getSaldoinicial();
            clsFechamentoCaixa.setSaldofinal(saldo);
            clsFechamentoCaixa.setVendaliquida(vendliq);
            clsFechamentoCaixa.setFinalizadorasFechaCego(bs.buscaRegistrosFechamento(idcaixa));
            if(clsFechamentoCaixa.getFinalizadorasFechaCego().size()>0){
                txtObs.setText(clsFechamentoCaixa.getFinalizadorasFechaCego().get(0).getObs());
            }
            processaPagamentos();
            txtCancelamentos.setText(clsaux.formato(clsFechamentoCaixa.getCancelamentos()));
            txtInicial.setText(clsaux.formato(clsFechamentoCaixa.getSaldoinicial()));
            txtOutras.setText(clsaux.formato(clsFechamentoCaixa.getOutras()));
            txtReforco.setText(clsaux.formato(clsFechamentoCaixa.getSuprimentos()));
            txtRetiradas.setText(clsaux.formato(clsFechamentoCaixa.getRetiradas()));
            txtSaldo.setText(clsaux.formato(saldo));
            txtVendBruta.setText(clsaux.formato(clsFechamentoCaixa.getVendabruta()));
            txtVendLiq.setText(clsaux.formato(clsFechamentoCaixa.getVendaliquida()));
            carregaValoresSangriaSuprimento(idcaixa);
        } catch (SQLException ex) {
            Logger.getLogger(formConfereValorCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void processaPagamentos(){
        finas.clear();
        for(String fin: clsFechamentoCaixa.finalizadoras){
            clsFinalizadora cl= new clsFinalizadora();
            String nome=clsaux.retornaId(fin);
            cl.setId(listaInfAdcDAO.pegaidfinalizadora(nome));
            cl.setNome(nome);
            cl.setValor(clsaux.capturaValores(clsaux.retornaAposId(fin)));
            for(tfechamento_cego novo:clsFechamentoCaixa.finalizadorasFechaCego){
                if(novo.getIdfinalizadora().equals(cl.getId())){
                    cl.setVldigitado(novo.getValor());
                    if(novo.getObs().length()>0){
                        txtObs.setText(novo.getObs());
                    }
                    break;
                }
            }
            finas.add(cl);
        }
        preencherDados();
    
    }
    public void preencherDados(){
        DefaultTableModel tbto= (DefaultTableModel) TblConfcx.getModel();
        tbto.setNumRows(0);
        for( clsFinalizadora fin: finas){
            tbto.addRow(new Object[]{
                fin.getId(),
                fin.getNome(),
                clsaux.formato(fin.getValor()),
                clsaux.formato(fin.getVldigitado()),
                "0,00",
                clsaux.formato(fin.getValor()-fin.getVldigitado())
                    
            });
        }
        
    
    
    
    }
    public void pegaValorInsereDb(){
        configuracaoDAO con= new configuracaoDAO();
        for (int i=0; i<TblConfcx.getRowCount(); i++){
        String idfinaliza=TblConfcx.getValueAt(i, 0).toString();    
        String finalizadora=TblConfcx.getValueAt(i, 1).toString();
        String vlconf=TblConfcx.getValueAt(i, 4).toString().replaceAll(",", ".");
        String vlapurado=TblConfcx.getValueAt(i, 2).toString().replaceAll(",", ".");
        String vldigitado=TblConfcx.getValueAt(i, 3).toString().replaceAll(",", ".");
        ConferenciaCxDAO.insConferecia(idcaixa, vlapurado, vldigitado, vlconf,idfinaliza);
        Tfinalizadoras fin=con.buscarFinalizadora(idfinaliza);
        Tcondicoes_venda condicao= new Tcondicoes_venda();
        condicao=condicao.getCondicaoPorId(fin.getCondicaoPadrao(), condicao);
            System.out.println("retorno condicao"+fin.getDescricao() +"-"+condicao.getGera_receber());
        if(!vlconf.equals("0.00")){
            if(idfinaliza.equals("1")){
               ClsInformaFinanceiro cl= new ClsInformaFinanceiro();
                clsDadosPagamentoAdm paga = new clsDadosPagamentoAdm();
                paga.setVltotal(clsaux.capturaValores(vlconf));
                paga.setParceiro("0");
                paga.setOrigem(idcaixa);
                paga.setTipo("Conferencia Caixa");
                paga.setDirecao("E");
                paga.setIdfinalizadora(idfinaliza);
                paga.setIdtipo("1");
                cl.trataTipoFinanceiro(paga);
            }
            if(idfinaliza.equals("2")||idfinaliza.equals("3")||idfinaliza.equals("9")){
                if(clsaux.trataCampoNuloConfig(condicao.getGera_receber()).equals("S")){
                    // aqui vai chaama funcao para pegar todas as vendas dessa finalizadora e gerar contas a receber 
                   
                    this.geraContasReceberTipoFinalizadora("2");
                }else{
                    ClsInformaFinanceiro cl= new ClsInformaFinanceiro();
                    clsDadosPagamentoAdm paga = new clsDadosPagamentoAdm();
                    Double taxaadm=condicao.getTaxa();
                    paga.setVltotal(clsaux.capturaValores(vlconf));
                    paga.setParceiro("0");
                    paga.setOrigem(idcaixa);
                    paga.setTipo("Conferencia Caixa");
                    paga.setDirecao("E");
                    paga.setIdfinalizadora(idfinaliza);
                    paga.setIdtipo("1");
                    cl.trataTipoFinanceiro(paga);
                    paga.setVltotal(clsaux.capturaValores(vlconf)*taxaadm/100);
                    paga.setTipo("Taxa Maquina");
                    paga.setDirecao("S");
                    paga.setIdtipo("2");
                    cl.trataTipoFinanceiro(paga);
                    }
            }
            
          }
        }
        conferido="Sim";
        JOptionPane.showMessageDialog(null, "Conferencia gravada com sucesso");
        CRUDCaixasPDVS.btnPesq.requestFocus();
        this.dispose();
    }
    public void carregaValoresSangriaSuprimento(String idcaixa){
         baseCaixaDAO bs= new baseCaixaDAO();
         List<clsSuprimentoSangria> lista= bs.consSangria(idcaixa);
         DefaultTableModel tbsangria= (DefaultTableModel) tbRet.getModel();
         tbsangria.setNumRows(0);
         for(clsSuprimentoSangria novo : lista){
             tbsangria.addRow(new Object[]{
                 novo.getIdfinalizadora(),
                 novo.getDescricao(),
                 clsaux.formato(novo.getValor()),
                 clsaux.convertDataHoraExib(novo.getData()),
                 "Retirada",
                 novo.getMotivo()
             });
         }
         lista=bs.consSuprimento(idcaixa, "0");
         for(clsSuprimentoSangria novo : lista){
             tbsangria.addRow(new Object[]{
                 novo.getIdfinalizadora(),
                 novo.getDescricao(),
                 clsaux.formato(novo.getValor()),
                 clsaux.convertDataHoraExib(novo.getData()),
                 "Reforço",
                 novo.getMotivo()
             });
         }
        
    }
    public void geraContasReceberTipoFinalizadora(String idfinalizadora){
        //pega todas as vendas da finalizadora selecionada, depois a cada venda gera um contas a receber pela condicao usada na finalizadora, calculando a quantidade de parcelas e 
        // também os prazos configurados
         System.out.println("vai gerar o contas a receber dessa finalizadora"+idfinalizadora);
        List<clsPagamentos> pag=ConferenciaCxDAO.retornaDadosGerarTitulos(idfinalizadora, idcaixa);
        Tcondicoes_venda condicao= new Tcondicoes_venda();
        System.out.println(pag.toString());
        for(clsPagamentos pg:pag){
            condicao=condicao.getCondicaoPorId(pg.getCondicao(), condicao);
            CadContasRecPagar cd = new CadContasRecPagar();
            ContasReceberDAO cr = new ContasReceberDAO();
            cd.setIdmovto(pg.getMvto());
            cd.setParceiro(condicao.getParceiro());
            cd.setNumero(pg.getMvto());
            cd.setEmisao(clsaux.retornaData(clsaux.preencheData()));
            cd.setEstadotitulo("4");
            cd.setTipo_titulo("7");
            cd.setConta("1");
            cd.setHistorico("10");
            cd.setTipo("2");
            cd.setIdcontrato("0");
            cd.setBanco("1");
            cd.setVendedor("0");
            cd.setParcela("1");
            cd.setJuros("0.00");
            cd.setDesconto("0.00");
            cd.setTipofinanceiro(clsConfig.financeiro.getTpConfCaixa());
            cd.setSubtipofinanceiro(clsConfig.financeiro.getSbConfCaixa());
            int parcelas=Integer.parseInt(condicao.getParcelas());
            Double valor=clsaux.capturaValores(pg.getValor());
            if(parcelas==1){
                Double vltaxa=valor*condicao.getTaxa()/100;
                cd.setValor(clsaux.formatoNfe(valor));
                cd.setSaldo(clsaux.formatoNfe(valor-vltaxa));
                cd.setVencimento(clsaux.retornaData(clsaux.calcularDataVencimento(Integer.parseInt(condicao.getDados()))));
                cd.setQntParcelas("1");
                cr.inserir(cd);
            }else if (parcelas>1){
                String [] prazos=listaDAO.listaPrazoCondicao(clsaux.retornaId(pg.getCondicao()));
                Double vlgeral=valor;
                Double vlparcela=valor/parcelas;
                Double vltaxa=vlparcela*condicao.getTaxa()/100;
                vlparcela= clsaux.capturaValores(clsaux.formato(vlparcela));
                for (int i=0; i<parcelas; i++){
                    if(i==parcelas){
                    vlparcela=vlgeral;
                      }
                    int dias=Integer.parseInt(prazos[i]);
                    cd.setValor(clsaux.formatoNfe(vlparcela));
                    cd.setSaldo(clsaux.formatoNfe(vlparcela-vltaxa));
                    cd.setVencimento(clsaux.retornaData(clsaux.calcularDataVencimento(dias)));
                    cd.setQntParcelas(String.valueOf(parcelas));
                    cr.inserir(cd);
                    vlgeral=vlgeral-vlparcela;
                }
            
            }
            
          }
        
        
        
    }
    public void buscaInfFinalizadora(String fin){
       
        List<clsPagamentos> lista=ConferenciaCxDAO.retornaDadosGerarTitulos(fin, idcaixa);
        DefaultTableModel tb= (DefaultTableModel) tbMovFin.getModel();
        tbMovFin.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(createComboBox()));
        //tbMovFin.getColumnModel().getColumn(5).setCellRenderer(btnTabela());
        new criaBotaoTabela(tbMovFin, 6,"Corrige Venda");
        tb.setNumRows(0);
        for(clsPagamentos novo:lista){
            tb.addRow(new Object[]{
                novo.getIdLancamento(),
                novo.getMvto(),
                novo.getDescricao(),
                clsaux.formato(clsaux.capturaValores(novo.getValor())),
                clsaux.formato(clsaux.capturaValores(novo.getTroco())),
                novo.getCondicao(),
                ""
            
            });
        }
        jTabbedPane1.setSelectedIndex(3);
        
    
    
    }
   
    private JComboBox<String> createComboBox() {
        JComboBox<String> comboBox = new JComboBox<>();
        for(String fi:listaFinalizadora){
            comboBox.addItem(fi);
        }
        return comboBox;
    }
    public  void corrigeValorFinalizadora(){
        String idbase=tbMovFin.getValueAt(tbMovFin.getSelectedRow(), 0).toString();
        String novafin=clsaux.retornaId(tbMovFin.getValueAt(tbMovFin.getSelectedRow(), 2));
       ConferenciaCxDAO dao= new ConferenciaCxDAO();
       dao.corrigeDadosFinalizadoraVenda(idbase,novafin);
       consultarValores(idcaixa);
       jTabbedPane1.setSelectedIndex(0);
      
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
            java.util.logging.Logger.getLogger(formConfereValorCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formConfereValorCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formConfereValorCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formConfereValorCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                formConfereValorCaixa dialog = new formConfereValorCaixa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Btnconf;
    private javax.swing.JButton Btnconf1;
    private javax.swing.JLabel LbDatConf;
    private javax.swing.JLabel LbStts;
    public static javax.swing.JLabel Lbsttsconferencia;
    private javax.swing.JTable TblConfcx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbMovFin;
    private javax.swing.JTable tbRet;
    private javax.swing.JTextField txtCancelamentos;
    private javax.swing.JTextField txtInicial;
    private javax.swing.JTextPane txtObs;
    private javax.swing.JTextField txtOutras;
    private javax.swing.JTextField txtReforco;
    private javax.swing.JTextField txtRetiradas;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtVendBruta;
    private javax.swing.JTextField txtVendLiq;
    // End of variables declaration//GEN-END:variables
}
