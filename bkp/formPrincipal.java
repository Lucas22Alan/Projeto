
package grafic.interfac;


import java.awt.Toolkit;
import contrato.CRUDcontrato;
import contrato.lancamentoTiro;

public class formPrincipal extends javax.swing.JFrame {

    public formPrincipal() {
        initComponents();
        getImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        LbParceiros = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LbProdutos = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        LbContasPagar = new javax.swing.JLabel();
        LbContasReceber = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbContrato = new javax.swing.JLabel();
        lbalvo = new javax.swing.JLabel();
        labelEmpresa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArquivos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        MenuContrato = new javax.swing.JMenu();
        ContratoArma = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText("Esfhera Desenvolvimento Integrado");
        jLabel1.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(219, 227, 227));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(219, 227, 227));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        LbParceiros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cliente1.png"))); // NOI18N
        LbParceiros.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                LbParceirosMouseMoved(evt);
            }
        });
        LbParceiros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbParceirosMouseClicked(evt);
            }
        });

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        LbProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/barras2.png"))); // NOI18N
        LbProdutos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                LbProdutosMouseMoved(evt);
            }
        });
        LbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbProdutosMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        LbContasPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ApagarMenu.png"))); // NOI18N
        LbContasPagar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                LbContasPagarMouseMoved(evt);
            }
        });
        LbContasPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbContasPagarMouseClicked(evt);
            }
        });

        LbContasReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/AreceberMenu.png"))); // NOI18N
        LbContasReceber.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                LbContasReceberMouseMoved(evt);
            }
        });
        LbContasReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbContasReceberMouseClicked(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        lbContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Contrato.png"))); // NOI18N
        lbContrato.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbContratoMouseMoved(evt);
            }
        });
        lbContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbContratoMouseClicked(evt);
            }
        });

        lbalvo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alvogrde.png"))); // NOI18N
        lbalvo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbalvoMouseMoved(evt);
            }
        });
        lbalvo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbalvoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbParceiros)
                .addGap(10, 10, 10)
                .addComponent(LbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbContasPagar)
                .addGap(16, 16, 16)
                .addComponent(LbContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbContrato)
                .addGap(13, 13, 13)
                .addComponent(lbalvo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(jLabel2)
                .addContainerGap(1259, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(89, 89, 89))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbParceiros, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LbProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addComponent(LbContasPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbContasReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbalvo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelEmpresa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Empresa:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(621, 621, 621)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(jLabel1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(120, 120, 120)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(labelEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(225, 225, 225));
        jMenuBar1.setBorder(null);

        MenuArquivos.setBorder(null);
        MenuArquivos.setText("Arquivos     ");
        MenuArquivos.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MenuArquivos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cliente.png"))); // NOI18N
        jMenuItem1.setText("Parceiros");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuArquivos.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ProdutoMenu.png"))); // NOI18N
        jMenuItem2.setText("Produtos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuArquivos.add(jMenuItem2);
        MenuArquivos.add(jSeparator2);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Saidas.png"))); // NOI18N
        jMenu5.setText("Saídas de Produtos");
        jMenu5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Orcamentomenu.png"))); // NOI18N
        jMenuItem16.setText("Orçamento");
        jMenu5.add(jMenuItem16);

        jMenuItem17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prevenda.png"))); // NOI18N
        jMenuItem17.setText("Pedido de Venda");
        jMenu5.add(jMenuItem17);

        MenuArquivos.add(jMenu5);
        MenuArquivos.add(jSeparator1);

        jMenuItem15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/doclista.png"))); // NOI18N
        jMenuItem15.setText("Documentos");
        MenuArquivos.add(jMenuItem15);

        jMenuBar1.add(MenuArquivos);

        jMenu1.setBorder(null);
        jMenu1.setText("Tabelas    ");
        jMenu1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabelas.png"))); // NOI18N
        jMenuItem4.setText("Unidades");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabelas.png"))); // NOI18N
        jMenuItem5.setText("Cst");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabelas.png"))); // NOI18N
        jMenuItem6.setText("Alíquotas");
        jMenu1.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabelas.png"))); // NOI18N
        jMenuItem7.setText("Ncm");
        jMenu1.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabelas.png"))); // NOI18N
        jMenuItem8.setText("Pis/Cofins");
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("  Financeiro  ");
        jMenu3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

        jMenuItem13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Documento.png"))); // NOI18N
        jMenuItem13.setText("Contas");
        jMenu3.add(jMenuItem13);

        jMenuItem14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Documento.png"))); // NOI18N
        jMenuItem14.setText("Tipos & Subtipos");
        jMenu3.add(jMenuItem14);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lanacamento.png"))); // NOI18N
        jMenuItem3.setText("Conferência de Caixas");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fluxo.png"))); // NOI18N
        jMenuItem9.setText("Fluxo de Caixa");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenu2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Credito.png"))); // NOI18N
        jMenu2.setText("Títulos");
        jMenu2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

        jMenuItem10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ApagarPqno.png"))); // NOI18N
        jMenuItem10.setText("Contas a Pagar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Reforço.png"))); // NOI18N
        jMenuItem11.setText("Contas a Receber");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenu3.add(jMenu2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("   Configuração");
        jMenu4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

        jMenuItem12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/empresa.png"))); // NOI18N
        jMenuItem12.setText("Empresa");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuBar1.add(jMenu4);

        jMenu7.setText("Relátorios");

        jMenuItem23.setText("Titulos a receber e Recebidos");
        jMenu7.add(jMenuItem23);

        jMenuItem24.setText("Vendas");
        jMenu7.add(jMenuItem24);

        jMenuItem25.setText("Movimentos");
        jMenu7.add(jMenuItem25);

        jMenuItem26.setText("Totais por finalizadora");
        jMenu7.add(jMenuItem26);

        jMenuItem28.setText("jMenuItem28");
        jMenu7.add(jMenuItem28);

        jMenuItem27.setText("jMenuItem27");
        jMenu7.add(jMenuItem27);

        jMenuItem29.setText("jMenuItem29");
        jMenu7.add(jMenuItem29);

        jMenuBar1.add(jMenu7);

        jMenu6.setText(".");
        jMenu6.setEnabled(false);
        jMenu6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

        jMenuItem18.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/locacaopqno.png"))); // NOI18N
        jMenuItem18.setText("Cadastro de Patrimônio");
        jMenu6.add(jMenuItem18);

        jMenuItem19.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Locacoes.png"))); // NOI18N
        jMenuItem19.setText("Locações ");
        jMenuItem19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem19MouseClicked(evt);
            }
        });
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem19);

        jMenuItem20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem20.setText("Contratos");
        jMenu6.add(jMenuItem20);

        jMenuItem21.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Manutencaopqno.png"))); // NOI18N
        jMenuItem21.setText("Manutenção de Equipamentos");
        jMenu6.add(jMenuItem21);

        jMenuBar1.add(jMenu6);

        MenuContrato.setText("Clube de Tiro");
        MenuContrato.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

        ContratoArma.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        ContratoArma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/doclista.png"))); // NOI18N
        ContratoArma.setText("Contratos");
        ContratoArma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContratoArmaMouseClicked(evt);
            }
        });
        ContratoArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContratoArmaActionPerformed(evt);
            }
        });
        MenuContrato.add(ContratoArma);

        jMenuItem22.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alvo.png"))); // NOI18N
        jMenuItem22.setText("Lançamentos");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        MenuContrato.add(jMenuItem22);

        jMenuBar1.add(MenuContrato);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     CRUDparceiro dialog = new CRUDparceiro(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        CRUDprodutos dialog = new CRUDprodutos(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
     
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       new CRUDunidades().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new CRUDCst().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        CRUDprodutos dialog = new CRUDprodutos(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void LbParceirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbParceirosMouseClicked
      CRUDparceiro dialog = new CRUDparceiro(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_LbParceirosMouseClicked

    private void LbParceirosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbParceirosMouseMoved
        // TODO add your handling code here:
        LbParceiros.setToolTipText("Cadastro de Parceiros");
    }//GEN-LAST:event_LbParceirosMouseMoved

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
       CRUDTitulo dialog = new CRUDTitulo(new javax.swing.JFrame(), true);
           dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void LbProdutosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbProdutosMouseMoved
         LbProdutos.setToolTipText("Cadastro de Produtos");
    }//GEN-LAST:event_LbProdutosMouseMoved

    private void LbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbProdutosMouseClicked
         CRUDprodutos dialog = new CRUDprodutos(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_LbProdutosMouseClicked

    private void LbContasPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbContasPagarMouseClicked
        CRUDTitulo dialog = new CRUDTitulo(new javax.swing.JFrame(), true);
        dialog.setTitle("Cadastro de Contas a Pagar");
        dialog.setVisible(true);
           
    }//GEN-LAST:event_LbContasPagarMouseClicked

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
       CRUDTitulo dialog = new CRUDTitulo(new javax.swing.JFrame(), true);
           dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void LbContasPagarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbContasPagarMouseMoved
            LbContasPagar.setToolTipText("Contas a Pagar");
    }//GEN-LAST:event_LbContasPagarMouseMoved

    private void LbContasReceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbContasReceberMouseClicked
         CRUDTitulo dialog = new CRUDTitulo(new javax.swing.JFrame(), true);
         dialog.setTitle("Cadastro de Contas a Receber");  
         dialog.setVisible(true);
    }//GEN-LAST:event_LbContasReceberMouseClicked

    private void LbContasReceberMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbContasReceberMouseMoved
        LbContasReceber.setToolTipText("Contas a Receber");
    }//GEN-LAST:event_LbContasReceberMouseMoved

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        CRUDlocacoes dialog = new CRUDlocacoes(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem19MouseClicked
        CRUDlocacoes dialog = new CRUDlocacoes(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem19MouseClicked

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        FormEmpresa emp = new FormEmpresa();
        emp.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        CRUDFluxoCaixa dialog = new CRUDFluxoCaixa(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      CRUDCaixasPDVS dialog = new CRUDCaixasPDVS(new javax.swing.JFrame(), true);
      dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        CRUDCaixasPDVS dialog = new CRUDCaixasPDVS(new javax.swing.JFrame(), true);
      dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void ContratoArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratoArmaActionPerformed
         CRUDcontrato dialog = new CRUDcontrato(new javax.swing.JFrame(), true);
         dialog.setVisible(true);
    }//GEN-LAST:event_ContratoArmaActionPerformed

    private void lbContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContratoMouseClicked
        CRUDcontrato dialog = new CRUDcontrato(new javax.swing.JFrame(), true);
         dialog.setVisible(true);
    }//GEN-LAST:event_lbContratoMouseClicked

    private void lbContratoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContratoMouseMoved
        LbContasReceber.setToolTipText("Contratos");
    }//GEN-LAST:event_lbContratoMouseMoved

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
      CRUDparceiro dialog = new CRUDparceiro(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void ContratoArmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContratoArmaMouseClicked
        CRUDcontrato dialog = new CRUDcontrato(new javax.swing.JFrame(), true);
         dialog.setVisible(true);
    }//GEN-LAST:event_ContratoArmaMouseClicked

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        lancamentoTiro dialog = new lancamentoTiro(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void lbalvoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbalvoMouseMoved
        lbalvo.setToolTipText("Lancamentos");
    }//GEN-LAST:event_lbalvoMouseMoved

    private void lbalvoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbalvoMouseClicked
        lancamentoTiro dialog = new lancamentoTiro(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_lbalvoMouseClicked

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ContratoArma;
    private javax.swing.JLabel LbContasPagar;
    private javax.swing.JLabel LbContasReceber;
    private javax.swing.JLabel LbParceiros;
    private javax.swing.JLabel LbProdutos;
    private javax.swing.JMenu MenuArquivos;
    private javax.swing.JMenu MenuContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    public static javax.swing.JLabel labelEmpresa;
    private javax.swing.JLabel lbContrato;
    private javax.swing.JLabel lbalvo;
    // End of variables declaration//GEN-END:variables

   /* private Object LbParceiros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    private void getImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/Logo.png")));
    }
}
