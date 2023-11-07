/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import DAO.AdicionalDAO;
import DAO.listaGrupDAO;
import DAO.permissaoUsuarioDAO;
import DAO.produtoDAO;
import model.Unidades;
import classes.clsaux;
import model.produtos;
import conexoes.conexao;
import contrato.escolheImpressao;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import util.CriaMenuOpcoes;
import static grafic.interfac.CRUDAdicionais.tbAdicional;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Tcad_adicional;
import model.Tdados_adicional_item;

/**
 *
 * @author Rodrigo
 */
public class CRUDAdicionais extends javax.swing.JDialog {

    /**
     * Creates new form CRUDproduto
     */
    public CRUDAdicionais(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicia();
    }

    public static List<Tcad_adicional> lista= new ArrayList<>();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAdicional = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbItensRef = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        PanelOpcProcura = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        txtCodInserir = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        cbGrupo = new javax.swing.JComboBox<>();
        cbSubGrupo = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(219, 227, 227));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tbAdicional.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbAdicional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Adc", "Descricao", "Preço", "Cod. Prod. Base", "Desc. Prod. Base", "Qnt. Prod. Base", "Cust. Prod. Base"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAdicional.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbAdicional.setRowHeight(24);
        tbAdicional.getTableHeader().setReorderingAllowed(false);
        tbAdicional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAdicionalMouseClicked(evt);
            }
        });
        tbAdicional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbAdicionalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbAdicionalKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbAdicional);
        if (tbAdicional.getColumnModel().getColumnCount() > 0) {
            tbAdicional.getColumnModel().getColumn(0).setResizable(false);
            tbAdicional.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbAdicional.getColumnModel().getColumn(1).setResizable(false);
            tbAdicional.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbAdicional.getColumnModel().getColumn(2).setResizable(false);
            tbAdicional.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbAdicional.getColumnModel().getColumn(3).setResizable(false);
            tbAdicional.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbAdicional.getColumnModel().getColumn(4).setResizable(false);
            tbAdicional.getColumnModel().getColumn(4).setPreferredWidth(200);
            tbAdicional.getColumnModel().getColumn(5).setResizable(false);
            tbAdicional.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbAdicional.getColumnModel().getColumn(6).setResizable(false);
            tbAdicional.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tbItensRef.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbItensRef.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Codigo", "Descrição", "Unidade", "Preço Venda", "Grupo", "Sub Grupo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbItensRef.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbItensRef.setRowHeight(24);
        tbItensRef.getTableHeader().setReorderingAllowed(false);
        tbItensRef.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbItensRefMouseClicked(evt);
            }
        });
        tbItensRef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbItensRefKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbItensRefKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbItensRef);
        if (tbItensRef.getColumnModel().getColumnCount() > 0) {
            tbItensRef.getColumnModel().getColumn(0).setResizable(false);
            tbItensRef.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbItensRef.getColumnModel().getColumn(1).setResizable(false);
            tbItensRef.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbItensRef.getColumnModel().getColumn(2).setResizable(false);
            tbItensRef.getColumnModel().getColumn(2).setPreferredWidth(250);
            tbItensRef.getColumnModel().getColumn(3).setResizable(false);
            tbItensRef.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbItensRef.getColumnModel().getColumn(4).setResizable(false);
            tbItensRef.getColumnModel().getColumn(4).setPreferredWidth(120);
            tbItensRef.getColumnModel().getColumn(5).setResizable(false);
            tbItensRef.getColumnModel().getColumn(5).setPreferredWidth(180);
            tbItensRef.getColumnModel().getColumn(6).setPreferredWidth(180);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("- Produtos Referente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Adicional", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null));

        PanelOpcProcura.setBackground(new java.awt.Color(226, 247, 231));

        javax.swing.GroupLayout PanelOpcProcuraLayout = new javax.swing.GroupLayout(PanelOpcProcura);
        PanelOpcProcura.setLayout(PanelOpcProcuraLayout);
        PanelOpcProcuraLayout.setHorizontalGroup(
            PanelOpcProcuraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelOpcProcuraLayout.setVerticalGroup(
            PanelOpcProcuraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/movtoprod99.png"))); // NOI18N
        jButton2.setText("Inserir Por Grupo");
        jButton2.setActionCommand("Resumo");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtCodInserir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodInserir.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo Item Inserir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        txtCodInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodInserirActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/movtoprod99.png"))); // NOI18N
        jButton3.setText("Inserir Por Item");
        jButton3.setActionCommand("Resumo");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbGrupo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cbSubGrupo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/movtoprod99.png"))); // NOI18N
        jButton4.setText("Inserir Por SubGrupo");
        jButton4.setActionCommand("Resumo");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(cbGrupo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodInserir)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelOpcProcura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(123, 123, 123))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSubGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(PanelOpcProcura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(txtCodInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSubGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prod98.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 36)); // NOI18N
        jLabel3.setText("Cadastro Adicionais");
        jLabel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel3FocusGained(evt);
            }
        });

        btnFechar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fechar99.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnExcluirItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/deletar99.png"))); // NOI18N
        btnExcluirItem.setText("Excluir");
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar97.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnIncluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mais99.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("- Arquivos / Produtos/Cadastro Adicionais");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodInserirActionPerformed
        
    }//GEN-LAST:event_txtCodInserirActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        int yn= JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro selecionado?", "exclusão de registro", JOptionPane.YES_NO_OPTION);
        if (yn== JOptionPane.YES_OPTION){
            new AdicionalDAO().removeCadastroAdicional(tbAdicional.getValueAt(tbAdicional.getSelectedRow(), 0).toString());
            populaTabelaAdicionais();
        }

    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       FrmCadAdicional dialog = new FrmCadAdicional(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.dadosAlterar(tbAdicional.getValueAt(tbAdicional.getSelectedRow(), 0).toString());
        dialog.setVisible(true);
       
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
     FrmCadAdicional dialog = new FrmCadAdicional(new javax.swing.JFrame(), true);
     dialog.setLocationRelativeTo(null);
     dialog.dadosIncluir();
     dialog.setVisible(true);
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void tbAdicionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAdicionalMouseClicked
       
    }//GEN-LAST:event_tbAdicionalMouseClicked

    private void tbAdicionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbAdicionalKeyPressed
       
    }//GEN-LAST:event_tbAdicionalKeyPressed

    private void tbAdicionalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbAdicionalKeyReleased
       
    }//GEN-LAST:event_tbAdicionalKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      this.inserirPorGrupo("G",clsaux.retornaId(cbGrupo.getSelectedItem()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbItensRefMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItensRefMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbItensRefMouseClicked

    private void tbItensRefKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbItensRefKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbItensRefKeyPressed

    private void tbItensRefKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbItensRefKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbItensRefKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.inserirPorGrupo("S",clsaux.retornaId(cbSubGrupo.getSelectedItem()));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
       
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
    }//GEN-LAST:event_formWindowActivated

    private void jLabel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel3FocusGained
       populaTabelaAdicionais();
    }//GEN-LAST:event_jLabel3FocusGained

    public void inicia(){
        tbAdicional.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e ){
                if (e.getClickCount()==2){
                   populaTabelaProd();
                } 
            }
          
        }); 
        
        DefaultComboBoxModel CbGrup = new DefaultComboBoxModel(listaGrupDAO.listagrupo().toArray());
        cbGrupo.setModel(CbGrup);
        DefaultComboBoxModel subgrupo = new DefaultComboBoxModel(listaGrupDAO.listaSubGrupo().toArray());
        cbSubGrupo.setModel(subgrupo);
        
        populaTabelaAdicionais();
        this.criaMenuItem();
      }
    
    public void inserirPorGrupo(String tp,String idselecionada){
        String adc= tbAdicional.getValueAt(tbAdicional.getSelectedRow(), 0).toString();
        new AdicionalDAO().InserirItensPorGrupo(idselecionada, tp,adc);
        populaTabelaProd();
    }
  
    
    public void removeItem(){
        String adc= tbAdicional.getValueAt(tbAdicional.getSelectedRow(), 0).toString();
        String cod=tbItensRef.getValueAt(tbItensRef.getSelectedRow(), 1).toString();
        
        new AdicionalDAO().removeItemAdicional(adc, cod);
        populaTabelaProd();
        
    }
    
    public void populaTabelaAdicionais(){
        lista=new AdicionalDAO().retornaListaAdicional();
        DefaultTableModel tb= (DefaultTableModel) tbAdicional.getModel();
        tb.setNumRows(0);
        for(Tcad_adicional cad : lista){
            tb.addRow(new Object[]{
                cad.getId(),
                cad.getDescricao(),
                clsaux.formato(cad.getPrec_venda()),
                cad.getCod_base(),
                cad.getDescricao_base(),
                clsaux.formato(cad.getQntusar()),
                clsaux.formato(cad.getCusto_base())
            
            });
        }
        
        
    }
    public void populaTabelaProd(){
        String adc= tbAdicional.getValueAt(tbAdicional.getSelectedRow(), 0).toString();
        List<Tdados_adicional_item> dados=new AdicionalDAO().retornaItensPorAdicinal(adc);
        
        DefaultTableModel tbprod= (DefaultTableModel) tbItensRef.getModel();
        tbprod.setNumRows(0);
        
        for(Tdados_adicional_item dad:dados){
            tbprod.addRow(new Object[]{
                dad.getIdproduto(),
                dad.getCodbarras(),
                dad.getDescricao(),
                dad.getUnidade(),
                clsaux.formato(dad.getVenda()),
                dad.getGrupo(),
                dad.getSubgrupo()
            
            });
        }
        
    }
    
    
    
   
    public void criaMenuItem(){
        JPopupMenu menu=new JPopupMenu();
        JMenuItem menuexluido= new JMenuItem("Remover Item Do Adicional");
        menuexluido.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent e) {
               removeItem();
            }
        });
        menu.add(menuexluido);
        CriaMenuOpcoes.listaCliqDireitoMouse(tbItensRef, menu);
        
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
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Windows".equals(info.getName())) {
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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CRUDAdicionais dialog = new CRUDAdicionais(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelOpcProcura;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JComboBox<String> cbGrupo;
    private javax.swing.JComboBox<String> cbSubGrupo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable tbAdicional;
    public static javax.swing.JTable tbItensRef;
    private javax.swing.JTextField txtCodInserir;
    // End of variables declaration//GEN-END:variables
}