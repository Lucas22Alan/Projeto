
package grafic.interfac;


import Boletos.ClsBoletoAilos;
import DAO.AvisosDAO;
import DAO.lancDocumentDAO;
import DAO.permissaoUsuarioDAO;
import classes.ClsImportaTabelaIbpt;
import classes.ClsVerificaVersao;
import classes.clsaux;
import model.clsConfig;
import conexoes.conexao;
import relatorios.frmRelMovimentoCaixa;
import relatorios.relAniversariante;
import relatorios.relRanking;
import relatorios.relCadastros;
import relatorios.relEstoque;
import relatorios.relVendasporProdutos;
import relatorios.relCReceber;
import relatorios.relVendasVendedor;
import java.awt.Toolkit;
import contrato.CRUDcontrato;
import contrato.lancamentoTiro;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jxl.read.biff.BiffException;
import model.CadContasRecPagar;
import relatorios.FrmMovOs;
import relatorios.FrmRelDreResumido;
import relatorios.frmRelDevolucao;
import relatorios.frmRelLocacao;
import relatorios.frmRelLocacaoItens;
import relatorios.frmRelLocacaoProduto;
import relatorios.relCPagar;
import relatorios.frmRelMovCaixaTipo;
import relatorios.frmRelMovOsFuncionario;
import relatorios.frmRelMovOsFuncionarioAndamento;
import relatorios.frmRelPontosTotais;
import relatorios.frmRelVendasDocumentosFiscais;
import relatorios.frmRelVendasGeral;
import relatorios.frmRelVendasParceiro;
import relatorios.frmRelVendasTotalDiario;
import relatorios.relComprasItensFornecedor;
import relatorios.relComprasPorFornecedor;
import relatorios.relPosicaoEstoque;
import relatorios.relProdutosCadastro;
import relatorios.relResumoMovimentoFinanceiro;
import relatorios.relTotaisFinalizdora;
import relatorios.relVendasporProdutosPercentual;

public class formPrincipal1 extends javax.swing.JFrame {

    public formPrincipal1() {
        initComponents();
        getImage();
        this.inicia();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
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
        lbFluxo = new javax.swing.JLabel();
        lbDocumentos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbNfe = new javax.swing.JLabel();
        lbCondicional = new javax.swing.JLabel();
        lbContrato1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        labelEmpresa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbVersaoSistema = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        pnAvisos = new javax.swing.JPanel();
        lbFecharAvisos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbDiasRestante = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArquivos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem52 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        jMenuItem55 = new javax.swing.JMenuItem();
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenuItem70 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        menuTipoSub = new javax.swing.JMenuItem();
        menuContas = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem74 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuConferenciaCaixa = new javax.swing.JMenuItem();
        menuMovimentacaoCaixa = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem61 = new javax.swing.JMenuItem();
        jMenuItem62 = new javax.swing.JMenuItem();
        jMenuItem63 = new javax.swing.JMenuItem();
        menuConfig = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem54 = new javax.swing.JMenuItem();
        jMenuItem56 = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenuItem64 = new javax.swing.JMenuItem();
        jMenuItem65 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        MenuContrato = new javax.swing.JMenu();
        ContratoArma = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        MenuAtirado = new javax.swing.JMenu();
        MiAniver = new javax.swing.JMenuItem();
        MiCad = new javax.swing.JMenuItem();
        MiRank = new javax.swing.JMenuItem();
        MiTotalPonto = new javax.swing.JMenuItem();
        MenuFinanceiro = new javax.swing.JMenu();
        MiContasReceber = new javax.swing.JMenuItem();
        MiContaPagar = new javax.swing.JMenuItem();
        MiMovCaixa = new javax.swing.JMenuItem();
        MiMovTipo = new javax.swing.JMenuItem();
        MiFluxo = new javax.swing.JMenuItem();
        MiResumoMov = new javax.swing.JMenuItem();
        MenuVendas = new javax.swing.JMenu();
        MiVenProduto = new javax.swing.JMenuItem();
        MiProdMedia = new javax.swing.JMenuItem();
        MiTotalFin = new javax.swing.JMenuItem();
        MiVendasVend = new javax.swing.JMenuItem();
        MiVendGeral = new javax.swing.JMenuItem();
        MiVendParc = new javax.swing.JMenuItem();
        MiVendDiario = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        MenuProdutos = new javax.swing.JMenu();
        MiPosicaoEsto = new javax.swing.JMenuItem();
        MiApuracaoEst = new javax.swing.JMenuItem();
        MiDevo = new javax.swing.JMenuItem();
        MiDevo1 = new javax.swing.JMenuItem();
        MenuOs = new javax.swing.JMenu();
        MiOsMov = new javax.swing.JMenuItem();
        MiOsFunFin = new javax.swing.JMenuItem();
        MiOsFunAnd = new javax.swing.JMenuItem();
        MiOsServ = new javax.swing.JMenuItem();
        MenuCompras = new javax.swing.JMenu();
        MiCOmprasForn = new javax.swing.JMenuItem();
        MiComprasProd = new javax.swing.JMenuItem();
        MenuLocacao = new javax.swing.JMenu();
        MiLocPerio = new javax.swing.JMenuItem();
        MiLocItens = new javax.swing.JMenuItem();
        MiLocProd = new javax.swing.JMenuItem();
        jMenuItem73 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        menuSinc = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem60 = new javax.swing.JMenuItem();

        jMenuItem34.setText("jMenuItem34");

        jMenu13.setText("File");
        jMenuBar2.add(jMenu13);

        jMenu14.setText("Edit");
        jMenuBar2.add(jMenu14);

        jMenuItem48.setText("jMenuItem48");

        jMenuItem67.setText("jMenuItem67");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrativo Esfhera Light");
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logoNova.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel3.setMinimumSize(new java.awt.Dimension(200, 500));
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jPanel3.setBackground(new java.awt.Color(219, 227, 227));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        LbParceiros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/parc98.png"))); // NOI18N
        LbParceiros.setToolTipText("Parceiros");
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

        LbProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prod98.png"))); // NOI18N
        LbProdutos.setToolTipText("Produtos");
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
        jPanel6.setPreferredSize(new java.awt.Dimension(2, 32));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        LbContasPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cpagar98.png"))); // NOI18N
        LbContasPagar.setToolTipText("Contas a Pagar");
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

        LbContasReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/creceber98.png"))); // NOI18N
        LbContasReceber.setToolTipText("Contas a Receber");
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
            .addGap(0, 22, Short.MAX_VALUE)
        );

        lbContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pedvend98.png"))); // NOI18N
        lbContrato.setToolTipText("Pedido de Venda");
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

        lbalvo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cond98.png"))); // NOI18N
        lbalvo.setToolTipText("Condicionais");
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

        lbFluxo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cfluxo98.png"))); // NOI18N
        lbFluxo.setToolTipText("Fluxo de Caixa");
        lbFluxo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbFluxoMouseMoved(evt);
            }
        });
        lbFluxo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFluxoMouseClicked(evt);
            }
        });

        lbDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/doc98.png"))); // NOI18N
        lbDocumentos.setToolTipText("Documentos");
        lbDocumentos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbDocumentosMouseMoved(evt);
            }
        });
        lbDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDocumentosMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ordem98.png"))); // NOI18N
        jLabel5.setToolTipText("Ordem de Serviço");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        lbNfe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfe98.png"))); // NOI18N
        lbNfe.setToolTipText("Nota Fiscal Eletronica");
        lbNfe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNfeMouseClicked(evt);
            }
        });

        lbCondicional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cond98.png"))); // NOI18N
        lbCondicional.setToolTipText("Condicionais");
        lbCondicional.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbCondicionalMouseMoved(evt);
            }
        });
        lbCondicional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCondicionalMouseClicked(evt);
            }
        });

        lbContrato1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prazopdv.png"))); // NOI18N
        lbContrato1.setToolTipText("Locações De Equipamentos");
        lbContrato1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbContrato1MouseMoved(evt);
            }
        });
        lbContrato1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbContrato1MouseClicked(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbParceiros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LbContasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LbContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbFluxo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbalvo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCondicional, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNfe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbContrato1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(367, 367, 367)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbParceiros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFluxo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbContasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNfe, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbalvo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbCondicional, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbContrato1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LbContasPagar, LbContasReceber, jLabel5, lbContrato, lbFluxo, lbNfe, lbalvo});

        labelEmpresa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Versão Sistema:");

        lbVersaoSistema.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Dias Restantes:");

        lbUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        pnAvisos.setBackground(new java.awt.Color(255, 255, 255));
        pnAvisos.setLayout(new java.awt.GridLayout(0, 2, 5, 5));

        lbFecharAvisos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFecharAvisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/infpdv.png"))); // NOI18N
        lbFecharAvisos.setText("Fechar Avisos");
        lbFecharAvisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFecharAvisosMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Usuario Logado:");

        lbDiasRestante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Empresa:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbVersaoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDiasRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(pnAvisos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(lbFecharAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbFecharAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(pnAvisos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbDiasRestante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVersaoSistema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jMenuBar1.setBackground(new java.awt.Color(225, 225, 225));
        jMenuBar1.setBorder(null);

        MenuArquivos.setBorder(null);
        MenuArquivos.setText("Arquivos       ");
        MenuArquivos.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MenuArquivos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/parceiro99.png"))); // NOI18N
        jMenuItem1.setText("Parceiros");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(105, 30));
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

        jMenu17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prodteste99.png"))); // NOI18N
        jMenu17.setText("Produtos");
        jMenu17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos99.png"))); // NOI18N
        jMenuItem2.setText("Produtos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem2);

        jMenuItem49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/estoque99.png"))); // NOI18N
        jMenuItem49.setText("Acompanhamento De Estoque");
        jMenuItem49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem49ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem49);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos99.png"))); // NOI18N
        jMenuItem3.setText("Cadastro Adicionais");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem3);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos99.png"))); // NOI18N
        jMenuItem7.setText("Cadastro Pizza");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem7);

        MenuArquivos.add(jMenu17);
        MenuArquivos.add(jSeparator1);

        jMenuItem15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/documentos99.png"))); // NOI18N
        jMenuItem15.setText("Documentos");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        MenuArquivos.add(jMenuItem15);

        jMenuItem42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/condicionais99.png"))); // NOI18N
        jMenuItem42.setText("Condicionais");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        MenuArquivos.add(jMenuItem42);

        jMenuItem51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfe99.png"))); // NOI18N
        jMenuItem51.setText("Nota Fiscal Eletrônica");
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        MenuArquivos.add(jMenuItem51);

        jMenuItem52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/balanca99.png"))); // NOI18N
        jMenuItem52.setText("Exportação Balança");
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        MenuArquivos.add(jMenuItem52);

        jMenuItem53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir99.png"))); // NOI18N
        jMenuItem53.setText("Impressão De Etiquetas");
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        MenuArquivos.add(jMenuItem53);

        jMenuItem55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/venda99.png"))); // NOI18N
        jMenuItem55.setText("Pedido De Venda");
        jMenuItem55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem55ActionPerformed(evt);
            }
        });
        MenuArquivos.add(jMenuItem55);

        jMenuItem57.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/servic99.png"))); // NOI18N
        jMenuItem57.setText("Ordem De Serviço");
        jMenuItem57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem57ActionPerformed(evt);
            }
        });
        MenuArquivos.add(jMenuItem57);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        jMenu4.setText("Locações");

        jMenuItem66.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        jMenuItem66.setText("Locações");
        jMenuItem66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem66ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem66);

        jMenuItem70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        jMenuItem70.setText("Manutencoes");
        jMenu4.add(jMenuItem70);

        MenuArquivos.add(jMenu4);

        jMenuBar1.add(MenuArquivos);

        jMenu1.setBorder(null);
        jMenu1.setText("Tabelas       ");
        jMenu1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        menuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        menuUsuario.setText("Usuarios");
        menuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuUsuario);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/unidgrup99.png"))); // NOI18N
        jMenuItem4.setText("Unidades");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/unidgrup99.png"))); // NOI18N
        jMenuItem5.setText("Grupos");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/func99.png"))); // NOI18N
        jMenuItem35.setText("Funcionarios");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem35);

        menuTipoSub.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        menuTipoSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        menuTipoSub.setText("Tipos & Subtipos");
        menuTipoSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTipoSubActionPerformed(evt);
            }
        });
        jMenu1.add(menuTipoSub);

        menuContas.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        menuContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        menuContas.setText("Contas");
        menuContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuContasActionPerformed(evt);
            }
        });
        jMenu1.add(menuContas);

        jMenuItem17.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        jMenuItem17.setText("Históricos");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenuItem74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        jMenuItem74.setText("Condições Aprazo");
        jMenuItem74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem74ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem74);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        jMenuItem6.setText("Cad. Bairro");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Financeiro          ");
        jMenu3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

        menuConferenciaCaixa.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        menuConferenciaCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confcaixa99.png"))); // NOI18N
        menuConferenciaCaixa.setText("Conferência de Caixas");
        menuConferenciaCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuConferenciaCaixaMouseClicked(evt);
            }
        });
        menuConferenciaCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConferenciaCaixaActionPerformed(evt);
            }
        });
        jMenu3.add(menuConferenciaCaixa);

        menuMovimentacaoCaixa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuMovimentacaoCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/movcaixa99.png"))); // NOI18N
        menuMovimentacaoCaixa.setText("Movimentação De Caixas");
        menuMovimentacaoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMovimentacaoCaixaActionPerformed(evt);
            }
        });
        jMenu3.add(menuMovimentacaoCaixa);

        jMenuItem9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fluxo99.png"))); // NOI18N
        jMenuItem9.setText("Fluxo de Caixa");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pagar99.png"))); // NOI18N
        jMenuItem10.setText("Contas a Pagar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/creceber99.png"))); // NOI18N
        jMenuItem11.setText("Contas a Receber");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/credcli99.png"))); // NOI18N
        jMenuItem40.setText("Credito Para Cliente");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem40);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cad99.png"))); // NOI18N
        jMenu2.setText("Boletos");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jMenuItem61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem61.setText("Gerar Remessa");
        jMenuItem61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem61ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem61);

        jMenuItem62.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem62.setText("Receber Remessa");
        jMenu2.add(jMenuItem62);

        jMenuItem63.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem63.setText("Historico De Remessas");
        jMenu2.add(jMenuItem63);

        jMenu3.add(jMenu2);

        jMenuBar1.add(jMenu3);

        menuConfig.setText("Configuração       ");
        menuConfig.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

        jMenuItem12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/emp99.png"))); // NOI18N
        jMenuItem12.setText("Empresa");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        menuConfig.add(jMenuItem12);

        jMenuItem54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir99.png"))); // NOI18N
        jMenuItem54.setText("Cadastro Etiqueta");
        jMenuItem54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem54ActionPerformed(evt);
            }
        });
        menuConfig.add(jMenuItem54);

        jMenuItem56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excel99.png"))); // NOI18N
        jMenuItem56.setText("Importação via Excel");
        jMenuItem56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem56ActionPerformed(evt);
            }
        });
        menuConfig.add(jMenuItem56);

        jMenuItem58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/config99.png"))); // NOI18N
        jMenuItem58.setText("Configuração Geral");
        jMenuItem58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem58ActionPerformed(evt);
            }
        });
        menuConfig.add(jMenuItem58);

        jMenuItem64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/config99.png"))); // NOI18N
        jMenuItem64.setText("Config. Boletos");
        jMenuItem64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem64ActionPerformed(evt);
            }
        });
        menuConfig.add(jMenuItem64);

        jMenuItem65.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/config99.png"))); // NOI18N
        jMenuItem65.setText("Finalizadoras");
        jMenuItem65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem65ActionPerformed(evt);
            }
        });
        menuConfig.add(jMenuItem65);

        jMenuBar1.add(menuConfig);

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

        MenuContrato.setText("Clube de Tiro       ");
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
        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alvopqnomenu.png"))); // NOI18N
        jMenuItem22.setText("Lançamentos");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        MenuContrato.add(jMenuItem22);

        jMenuBar1.add(MenuContrato);

        jMenu7.setText("Relatórios     ");
        jMenu7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N

        MenuAtirado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/parceiro99.png"))); // NOI18N
        MenuAtirado.setText("Parceiros");
        MenuAtirado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        MiAniver.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiAniver.setText("Aniversariantes");
        MiAniver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiAniverActionPerformed(evt);
            }
        });
        MenuAtirado.add(MiAniver);

        MiCad.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiCad.setText("Cadastros");
        MiCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiCadActionPerformed(evt);
            }
        });
        MenuAtirado.add(MiCad);

        MiRank.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiRank.setText("Ranking");
        MiRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiRankActionPerformed(evt);
            }
        });
        MenuAtirado.add(MiRank);

        MiTotalPonto.setText("Totais Pontos");
        MiTotalPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiTotalPontoActionPerformed(evt);
            }
        });
        MenuAtirado.add(MiTotalPonto);

        jMenu7.add(MenuAtirado);

        MenuFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relfinan99.png"))); // NOI18N
        MenuFinanceiro.setText("Financeiro");
        MenuFinanceiro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        MiContasReceber.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiContasReceber.setText("Contas a Receber");
        MiContasReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiContasReceberActionPerformed(evt);
            }
        });
        MenuFinanceiro.add(MiContasReceber);

        MiContaPagar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiContaPagar.setText("Contas a Pagar");
        MiContaPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiContaPagarActionPerformed(evt);
            }
        });
        MenuFinanceiro.add(MiContaPagar);

        MiMovCaixa.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiMovCaixa.setText("Movimentacao de Caixa");
        MiMovCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiMovCaixaActionPerformed(evt);
            }
        });
        MenuFinanceiro.add(MiMovCaixa);

        MiMovTipo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiMovTipo.setText("Movimento de Caixa Por Tipo de Movimento");
        MiMovTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiMovTipoActionPerformed(evt);
            }
        });
        MenuFinanceiro.add(MiMovTipo);

        MiFluxo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiFluxo.setText("Fluxo de Caixa");
        MiFluxo.setToolTipText("");
        MiFluxo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiFluxoActionPerformed(evt);
            }
        });
        MenuFinanceiro.add(MiFluxo);

        MiResumoMov.setText("Resumo de Movimento");
        MiResumoMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiResumoMovActionPerformed(evt);
            }
        });
        MenuFinanceiro.add(MiResumoMov);

        jMenu7.add(MenuFinanceiro);

        MenuVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relvend99.png"))); // NOI18N
        MenuVendas.setText("Vendas");
        MenuVendas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        MiVenProduto.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiVenProduto.setText("Por Produto");
        MiVenProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiVenProdutoActionPerformed(evt);
            }
        });
        MenuVendas.add(MiVenProduto);

        MiProdMedia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MiProdMedia.setText("Por Produto- Média de Crescimento e Redução");
        MiProdMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiProdMediaActionPerformed(evt);
            }
        });
        MenuVendas.add(MiProdMedia);

        MiTotalFin.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiTotalFin.setText("Totais Por Finalizadora");
        MiTotalFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiTotalFinActionPerformed(evt);
            }
        });
        MenuVendas.add(MiTotalFin);

        MiVendasVend.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiVendasVend.setText("Vendas por Vendedor");
        MiVendasVend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiVendasVendActionPerformed(evt);
            }
        });
        MenuVendas.add(MiVendasVend);

        MiVendGeral.setText("Vendas Geral");
        MiVendGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiVendGeralActionPerformed(evt);
            }
        });
        MenuVendas.add(MiVendGeral);

        MiVendParc.setText("Vendas Por Parceiros");
        MiVendParc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiVendParcActionPerformed(evt);
            }
        });
        MenuVendas.add(MiVendParc);

        MiVendDiario.setText("Venda Total Diario");
        MiVendDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiVendDiarioActionPerformed(evt);
            }
        });
        MenuVendas.add(MiVendDiario);

        jMenuItem13.setText("Venda Documentos Fiscais");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        MenuVendas.add(jMenuItem13);

        jMenu7.add(MenuVendas);

        MenuProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prodteste99.png"))); // NOI18N
        MenuProdutos.setText("Produtos");
        MenuProdutos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        MiPosicaoEsto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MiPosicaoEsto.setText("Posição De Estoque");
        MiPosicaoEsto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiPosicaoEstoActionPerformed(evt);
            }
        });
        MenuProdutos.add(MiPosicaoEsto);

        MiApuracaoEst.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MiApuracaoEst.setText("Apuração De Estoque");
        MiApuracaoEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiApuracaoEstActionPerformed(evt);
            }
        });
        MenuProdutos.add(MiApuracaoEst);

        MiDevo.setText("Devoluções");
        MiDevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiDevoActionPerformed(evt);
            }
        });
        MenuProdutos.add(MiDevo);

        MiDevo1.setText("Produtos Cadastrados");
        MiDevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiDevo1ActionPerformed(evt);
            }
        });
        MenuProdutos.add(MiDevo1);

        jMenu7.add(MenuProdutos);

        MenuOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/servic99.png"))); // NOI18N
        MenuOs.setText("Ordem de Serviços");
        MenuOs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        MiOsMov.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiOsMov.setText("Movimentação");
        MiOsMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiOsMovActionPerformed(evt);
            }
        });
        MenuOs.add(MiOsMov);

        MiOsFunFin.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiOsFunFin.setText("Por Funcionários Finalizadas");
        MiOsFunFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiOsFunFinActionPerformed(evt);
            }
        });
        MenuOs.add(MiOsFunFin);

        MiOsFunAnd.setText("Por Funcionários em Andamento");
        MiOsFunAnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiOsFunAndActionPerformed(evt);
            }
        });
        MenuOs.add(MiOsFunAnd);

        MiOsServ.setText("Por Serviço");
        MiOsServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiOsServActionPerformed(evt);
            }
        });
        MenuOs.add(MiOsServ);

        jMenu7.add(MenuOs);

        MenuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/compra99.png"))); // NOI18N
        MenuCompras.setText("Compras");
        MenuCompras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        MiCOmprasForn.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiCOmprasForn.setText("Compras Totais Por Fornecedor");
        MiCOmprasForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiCOmprasFornActionPerformed(evt);
            }
        });
        MenuCompras.add(MiCOmprasForn);

        MiComprasProd.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        MiComprasProd.setText("Compras Produtos Por Fonecedor");
        MiComprasProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiComprasProdActionPerformed(evt);
            }
        });
        MenuCompras.add(MiComprasProd);

        jMenu7.add(MenuCompras);

        MenuLocacao.setText("Locações");

        MiLocPerio.setText("Locacoes Por periodo");
        MiLocPerio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiLocPerioActionPerformed(evt);
            }
        });
        MenuLocacao.add(MiLocPerio);

        MiLocItens.setText("Locacoes Itens Periodo");
        MiLocItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiLocItensActionPerformed(evt);
            }
        });
        MenuLocacao.add(MiLocItens);

        MiLocProd.setText("Locações Por Produto");
        MiLocProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiLocProdActionPerformed(evt);
            }
        });
        MenuLocacao.add(MiLocProd);

        jMenuItem73.setText("Itens Em Manutenção");
        jMenuItem73.setEnabled(false);
        MenuLocacao.add(jMenuItem73);

        jMenu7.add(MenuLocacao);

        jMenuBar1.add(jMenu7);

        jMenu11.setText("Serviços");

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/servic99.png"))); // NOI18N
        jMenuItem8.setText("Ordem");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem8);

        jMenuBar1.add(jMenu11);

        jMenu15.setText("      Diversos");

        menuSinc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menuSinc.setText("Sincronizar Clube de Pontos");
        menuSinc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSincActionPerformed(evt);
            }
        });
        jMenu15.add(menuSinc);

        jMenuItem43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem43.setText("Correção Descontos");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem43);

        jMenuItem60.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem60.setText("Importar Tabela IBPT");
        jMenuItem60.setToolTipText("Atenção, verifique se o arquivo está na pasta c:\\esfhera\\adm\\importacao\\ibpt.xls");
        jMenuItem60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem60ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem60);

        jMenuBar1.add(jMenu15);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        CRUDunidade dialog = new CRUDunidade(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
       CRUDTitulo.tipo="Cadastro de Contas a Pagar";
       CRUDTitulo dialog = new CRUDTitulo(new javax.swing.JFrame(), true);
       dialog.setTitle("Cadastro de Contas a Pagar"); 
       
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
        CRUDTitulo.tipo="Cadastro de Contas a Pagar";
        CRUDTitulo dialog = new CRUDTitulo(new javax.swing.JFrame(), true);
        dialog.setTitle("Cadastro de Contas a Pagar");
        dialog.setVisible(true);
           
    }//GEN-LAST:event_LbContasPagarMouseClicked

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
       CRUDTitulo.tipo="Cadastro de Contas a Receber";
       CRUDTitulo dialog = new CRUDTitulo(new javax.swing.JFrame(), true);
       dialog.setTitle("Cadastro de Contas a Receber"); 
       dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void LbContasPagarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbContasPagarMouseMoved
            LbContasPagar.setToolTipText("Contas a Pagar");
    }//GEN-LAST:event_LbContasPagarMouseMoved

    private void LbContasReceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbContasReceberMouseClicked
        CRUDTitulo.tipo="Cadastro de Contas a Receber"; 
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

    private void menuConferenciaCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConferenciaCaixaActionPerformed
      CRUDCaixasPDVS dialog = new CRUDCaixasPDVS(new javax.swing.JFrame(), true);
      dialog.setVisible(true);
    }//GEN-LAST:event_menuConferenciaCaixaActionPerformed

    private void menuConferenciaCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuConferenciaCaixaMouseClicked
        CRUDCaixasPDVS dialog = new CRUDCaixasPDVS(new javax.swing.JFrame(), true);
      dialog.setVisible(true);
    }//GEN-LAST:event_menuConferenciaCaixaMouseClicked

    private void ContratoArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratoArmaActionPerformed
         CRUDcontrato dialog = new CRUDcontrato(new javax.swing.JFrame(), true);
         dialog.setVisible(true);
    }//GEN-LAST:event_ContratoArmaActionPerformed

    private void lbContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContratoMouseClicked
        CRUDOrcamentos dialog = new CRUDOrcamentos(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_lbContratoMouseClicked

    private void lbContratoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContratoMouseMoved
        lbContrato.setToolTipText("Pedido De Venda");
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

    private void MiRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiRankActionPerformed
        relRanking dialog = new relRanking(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiRankActionPerformed

    private void MiAniverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiAniverActionPerformed
        relAniversariante dialog = new relAniversariante(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiAniverActionPerformed

    private void MiCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiCadActionPerformed
       relCadastros dialog = new relCadastros(new javax.swing.JFrame(), true);
       dialog.setVisible(true);
       
    }//GEN-LAST:event_MiCadActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
       CRUDDocumentos dialog = new CRUDDocumentos(new javax.swing.JFrame(), true);
       dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void MiContasReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiContasReceberActionPerformed
        relCReceber dialog = new relCReceber(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiContasReceberActionPerformed

    private void MiVendasVendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiVendasVendActionPerformed
        relVendasVendedor dialog = new relVendasVendedor(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiVendasVendActionPerformed

    private void MiVenProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiVenProdutoActionPerformed
       relVendasporProdutos dialog = new relVendasporProdutos(new javax.swing.JFrame(), true);
       dialog.setVisible(true);
    }//GEN-LAST:event_MiVenProdutoActionPerformed

    private void lbFluxoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFluxoMouseClicked
        CRUDFluxoCaixa dialog = new CRUDFluxoCaixa(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_lbFluxoMouseClicked

    private void lbFluxoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFluxoMouseMoved
        lbFluxo.setToolTipText("Fluxo de Caixa");
    }//GEN-LAST:event_lbFluxoMouseMoved

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         CRUDTabelas dialog = new CRUDTabelas(new javax.swing.JFrame(), true);
         CRUDTabelas.tipoform="G";
         dialog.setTitle("Cadastro de Grupos...");
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        CRUDTabelas dialog = new CRUDTabelas(new javax.swing.JFrame(), true);
        CRUDTabelas.tipoform="HI";
        dialog.setTitle("Cadastro de Históricos...");
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
       CRUDTabelas dialog = new CRUDTabelas(new javax.swing.JFrame(), true);
         CRUDTabelas.tipoform="G";
         dialog.setTitle("Cadastro de Grupos...");
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem5MouseClicked

    private void lbDocumentosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDocumentosMouseMoved
        lbDocumentos.setToolTipText("Documentos Emitidos");
    }//GEN-LAST:event_lbDocumentosMouseMoved

    private void lbDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDocumentosMouseClicked
        CRUDDocumentos dialog = new CRUDDocumentos(new javax.swing.JFrame(), true);
       dialog.setVisible(true);
    }//GEN-LAST:event_lbDocumentosMouseClicked

    private void MiApuracaoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiApuracaoEstActionPerformed
       relEstoque dialog = new relEstoque(new javax.swing.JFrame(), true);
       dialog.setVisible(true);
    }//GEN-LAST:event_MiApuracaoEstActionPerformed

    private void menuContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuContasActionPerformed
         CRUDTabelas dialog = new CRUDTabelas(new javax.swing.JFrame(), true);
         CRUDTabelas.tipoform="CO";
         dialog.setTitle("Cadastro de Contas...");
         dialog.setVisible(true);
    }//GEN-LAST:event_menuContasActionPerformed

    private void menuTipoSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTipoSubActionPerformed
         CRUDTabelas dialog = new CRUDTabelas(new javax.swing.JFrame(), true);
         CRUDTabelas.tipoform="TS";
         dialog.setTitle("Cadastro de Tipo e SubTipo de Movimentação...");
         dialog.setVisible(true);
    }//GEN-LAST:event_menuTipoSubActionPerformed

    private void MiMovCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiMovCaixaActionPerformed
        frmRelMovimentoCaixa dialog = new frmRelMovimentoCaixa(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiMovCaixaActionPerformed

    private void MiTotalFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiTotalFinActionPerformed
        relTotaisFinalizdora dialog = new relTotaisFinalizdora(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiTotalFinActionPerformed

    private void MiMovTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiMovTipoActionPerformed
        frmRelMovCaixaTipo dialog = new frmRelMovCaixaTipo(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiMovTipoActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        CRUDservicos dialog = new CRUDservicos(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
         CRUDfuncionarios dialog = new CRUDfuncionarios(new javax.swing.JFrame(), true);
         dialog.setLocationRelativeTo(null);
         dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        CRUDservicos dialog = new CRUDservicos(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void menuSincActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSincActionPerformed
        frmSincronizarClubePontos dialog = new frmSincronizarClubePontos(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuSincActionPerformed

    private void MiContaPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiContaPagarActionPerformed
        relCPagar dialog = new relCPagar(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiContaPagarActionPerformed

    private void MiTotalPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiTotalPontoActionPerformed
      frmRelPontosTotais dialog = new frmRelPontosTotais(new javax.swing.JFrame(), true);
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);
    }//GEN-LAST:event_MiTotalPontoActionPerformed

    private void MiCOmprasFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiCOmprasFornActionPerformed
        relComprasPorFornecedor dialog = new relComprasPorFornecedor(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiCOmprasFornActionPerformed

    private void MiComprasProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiComprasProdActionPerformed
        // TODO add your handling code here:
        relComprasItensFornecedor dialog = new relComprasItensFornecedor(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiComprasProdActionPerformed

    private void MiResumoMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiResumoMovActionPerformed
        relResumoMovimentoFinanceiro dialog = new relResumoMovimentoFinanceiro(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiResumoMovActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        CRUDcreditoCliente dialog = new CRUDcreditoCliente(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void MiVendGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiVendGeralActionPerformed
       frmRelVendasGeral dialog = new frmRelVendasGeral(new javax.swing.JFrame(), true);
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_MiVendGeralActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        CRUDCondicional dialog = new CRUDCondicional(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        this.corrigeDesconto();
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void MiOsMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiOsMovActionPerformed
        FrmMovOs dialog = new FrmMovOs(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiOsMovActionPerformed

    private void MiOsServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiOsServActionPerformed
        frmRelMovOsFuncionario dialog = new frmRelMovOsFuncionario(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiOsServActionPerformed

    private void MiOsFunFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiOsFunFinActionPerformed
        frmRelMovOsFuncionario dialog = new frmRelMovOsFuncionario(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiOsFunFinActionPerformed

    private void MiOsFunAndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiOsFunAndActionPerformed
        frmRelMovOsFuncionarioAndamento dialog = new frmRelMovOsFuncionarioAndamento(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiOsFunAndActionPerformed

    private void MiVendParcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiVendParcActionPerformed
        frmRelVendasParceiro dialog = new frmRelVendasParceiro(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiVendParcActionPerformed

    private void menuMovimentacaoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMovimentacaoCaixaActionPerformed
        frmValoresCaixa dialog = new frmValoresCaixa(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuMovimentacaoCaixaActionPerformed

    private void jMenuItem49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem49ActionPerformed
        frmAcompanhamentoEstoque dialog = new frmAcompanhamentoEstoque(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem49ActionPerformed

    private void MiProdMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiProdMediaActionPerformed
        relVendasporProdutosPercentual dialog = new relVendasporProdutosPercentual(new javax.swing.JFrame(), true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
    }//GEN-LAST:event_MiProdMediaActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
       this.abreCrudNfe();
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void lbNfeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNfeMouseClicked
        this.abreCrudNfe();
    }//GEN-LAST:event_lbNfeMouseClicked

    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
       frmEnvioCargaBalanca dialog = new frmEnvioCargaBalanca(new javax.swing.JFrame(), true);
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem52ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        // TODO add your handling code here:
        frmImpressaoEtiquetas dialog = new frmImpressaoEtiquetas(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem55ActionPerformed
        CRUDOrcamentos dialog = new CRUDOrcamentos(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem55ActionPerformed

    private void jMenuItem56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem56ActionPerformed
      frmImportarItensFora dialog = new frmImportarItensFora(new javax.swing.JFrame(), true);
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem56ActionPerformed

    private void jMenuItem58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem58ActionPerformed
        frmCadConfiguracao dialog = new frmCadConfiguracao(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem58ActionPerformed

    private void jMenuItem54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem54ActionPerformed
      FrmCadEtiqueta dialog = new FrmCadEtiqueta(new javax.swing.JFrame(), true);
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem54ActionPerformed

    private void jMenuItem57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem57ActionPerformed
      CRUDservicos dialog = new CRUDservicos(new javax.swing.JFrame(), true);
      dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem57ActionPerformed

    private void lbCondicionalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCondicionalMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCondicionalMouseMoved

    private void lbCondicionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCondicionalMouseClicked
        CRUDCondicional dialog = new CRUDCondicional(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_lbCondicionalMouseClicked

    private void menuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuarioActionPerformed
        CRUDUsuarios dialog = new CRUDUsuarios(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuUsuarioActionPerformed

    private void MiFluxoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiFluxoActionPerformed
       FrmRelDreResumido dialog = new FrmRelDreResumido(new javax.swing.JFrame(), true);
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_MiFluxoActionPerformed

    private void jMenuItem60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem60ActionPerformed
        try {
            ClsImportaTabelaIbpt ibpt= new ClsImportaTabelaIbpt();
            ibpt.importarTabela();
        } catch (IOException ex) {
            Logs.gravarLog.gravaSemMensagem(ex.getMessage());
            Logger.getLogger(formPrincipal1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
             Logs.gravarLog.gravaSemMensagem(ex.getMessage());
            Logger.getLogger(formPrincipal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem60ActionPerformed

    private void jMenuItem64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem64ActionPerformed
        FrmCadConfigBoleto dialog = new FrmCadConfigBoleto(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem64ActionPerformed

    private void jMenuItem66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem66ActionPerformed
        CRUDlocacoes dialog = new CRUDlocacoes(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem66ActionPerformed

    private void MiPosicaoEstoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiPosicaoEstoActionPerformed
        relPosicaoEstoque dialog = new relPosicaoEstoque(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiPosicaoEstoActionPerformed

    private void MiVendDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiVendDiarioActionPerformed
        frmRelVendasTotalDiario dialog = new frmRelVendasTotalDiario(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiVendDiarioActionPerformed

    private void jMenuItem65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem65ActionPerformed
       FrmCadFinalizadora dialog = new FrmCadFinalizadora(new javax.swing.JFrame(), true);
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem65ActionPerformed

    private void lbContrato1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContrato1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbContrato1MouseMoved

    private void lbContrato1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContrato1MouseClicked
        CRUDlocacoes dialog = new CRUDlocacoes(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_lbContrato1MouseClicked

    private void MiDevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiDevoActionPerformed
       frmRelDevolucao dialog = new frmRelDevolucao(new javax.swing.JFrame(), true);
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_MiDevoActionPerformed

    private void MiLocPerioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiLocPerioActionPerformed
       frmRelLocacao dialog = new frmRelLocacao(new javax.swing.JFrame(), true);
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_MiLocPerioActionPerformed

    private void MiLocItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiLocItensActionPerformed
        frmRelLocacaoItens dialog = new frmRelLocacaoItens(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_MiLocItensActionPerformed

    private void MiLocProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiLocProdActionPerformed
     frmRelLocacaoProduto dialog = new frmRelLocacaoProduto(new javax.swing.JFrame(), true);
     dialog.setLocationRelativeTo(null);
     dialog.setVisible(true);
    }//GEN-LAST:event_MiLocProdActionPerformed

    private void lbFecharAvisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFecharAvisosMouseClicked
        pnAvisos.removeAll();
        pnAvisos.updateUI();
        lbFecharAvisos.setVisible(false);
    }//GEN-LAST:event_lbFecharAvisosMouseClicked

    private void jMenuItem74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem74ActionPerformed
       CRUDCondicoes dialog = new CRUDCondicoes(new javax.swing.JFrame(), true);
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem74ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        CRUDAdicionais dialog = new CRUDAdicionais(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       CRUDTabelas dialog = new CRUDTabelas(new javax.swing.JFrame(), true);
       CRUDTabelas.tipoform="BA";
       dialog.setTitle("Cadastro de Bairros...");
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        CRUDCadPizza dialog = new CRUDCadPizza(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        frmRelVendasDocumentosFiscais dialog = new frmRelVendasDocumentosFiscais(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem61ActionPerformed
       new ClsBoletoAilos().gerarRequisicao();
    }//GEN-LAST:event_jMenuItem61ActionPerformed

    private void MiDevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiDevo1ActionPerformed
       relProdutosCadastro dialog = new relProdutosCadastro(new javax.swing.JFrame(), true);
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
       //teste
    }//GEN-LAST:event_MiDevo1ActionPerformed
    
    public void abreCrudNfe(){
        CRUDNfe dialog = new CRUDNfe(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    
    }
    public void corrigeDesconto(){
        try {
            lancDocumentDAO lc=new lancDocumentDAO();
            String sql="select id_mov, desconto from tmovimento where desconto>0";
            PreparedStatement ps= conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lc.realizaRateioDescontoItens(rs.getString(1), rs.getDouble(2));
            }
             JOptionPane.showMessageDialog(null, "Desconto rateado com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar rateio \n"+ ex.getMessage());
            Logger.getLogger(formPrincipal1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    public void carregaAvisosSistema(){
        AvisosDAO aviso= new AvisosDAO();
        List<String> aniversario= aviso.retornaListaAniversarianteMes();
        List<CadContasRecPagar> titulosPagar=aviso.retornaListaTitulosVencendoDia("1");
        List<CadContasRecPagar> titulosReceber=aviso.retornaListaTitulosVencendoDia("2");
        JPanel panelAniversarios = new JPanel();
        panelAniversarios.setBackground(Color.WHITE);
       // panelAniversarios.setLayout(new GridLayout(0, 2, 10, 10));
        panelAniversarios.setLayout(new BoxLayout(panelAniversarios, BoxLayout.Y_AXIS));
        JPanel penelAux = new JPanel();
        penelAux.setBackground(Color.WHITE);
        penelAux.setLayout(new BoxLayout(penelAux, BoxLayout.Y_AXIS));
        JPanel penelAux2 = new JPanel();
        penelAux2.setBackground(Color.WHITE);
        penelAux2.setLayout(new BoxLayout(penelAux2, BoxLayout.Y_AXIS));
        JPanel penelAux3 = new JPanel();
        penelAux3.setBackground(Color.WHITE);
        for(String novo: aniversario){
            JLabel lb = new JLabel("Nome: "+clsaux.retornaAposId(novo));
            lb.setMinimumSize(new Dimension(250, 10));
            lb.setMaximumSize(new Dimension(250, 10));
            lb.setPreferredSize(new Dimension(250, 10));
            JLabel lbdia= new JLabel("Dia Aniversario: "+clsaux.retornaId(novo));
            JLabel lbdivide= new JLabel("____________________________________________________________________________________________");
            JLabel lbespaco= new JLabel("   ");
            panelAniversarios.add(lb);
            panelAniversarios.add(lbdia);
            panelAniversarios.add(lbdivide);
            panelAniversarios.add(lbespaco);
        }
        panelAniversarios.setBorder(BorderFactory.createTitledBorder("Aniversariantes Do Mês..."));
        for(CadContasRecPagar titulo:titulosPagar){
            JLabel lb = new JLabel("Nome: "+titulo.getRazaoparceiro()+"       Valor : "+clsaux.formato(clsaux.capturaValores(titulo.getValortotal())));
            penelAux.add(lb);
        }
        penelAux.setBorder(BorderFactory.createTitledBorder("Titulos A Pagar Vencendo Hoje"));
        for(CadContasRecPagar titulo:titulosReceber){
            JLabel lb = new JLabel("Nome: "+titulo.getRazaoparceiro()+"       Valor : "+clsaux.formato(clsaux.capturaValores(titulo.getValortotal())));
            penelAux2.add(lb);
        }
        penelAux2.setBorder(BorderFactory.createTitledBorder("Titulos A Receber Vencendo Hoje"));
        pnAvisos.add(panelAniversarios);
        pnAvisos.add(penelAux);
        pnAvisos.add(penelAux2);
        pnAvisos.add(penelAux3);
        pnAvisos.updateUI();
        
    }
    public void inicia(){
        this.setExtendedState(MAXIMIZED_BOTH);
       
        lbVersaoSistema.setText(clsConfig.versao);
        this.setTitle("Administrativo Esfhera Light --Versão: "+ClsVerificaVersao.versaoCompilada);
        java.awt.Dimension dime= java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0,0,dime.width,dime.height);
        carregaAvisosSistema();
        
        int inf=clsaux.calcularDiferencaDatas(clsaux.preencheData(), clsaux. convertDataExib(clsConfig.validadeSistema));
        lbDiasRestante.setText(String.valueOf(inf));
        if(inf<5){
            JOptionPane.showMessageDialog(null, "Atenção Seu Sistema Está Próximo De Vencer\nEntre em Contato Conosco Para Validar Licença!");
        }
        this.validaPermissao();
    }
    public void validaPermissao(){
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("117"));else menuUsuario.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("118"));else menuTipoSub.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("119"));else menuContas.setVisible(false);
      
      
      //Aqui vai validar as funcoes para aba relatorios
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("150"));else MenuAtirado.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("151"));else MenuFinanceiro.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("152"));else MenuVendas.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("153"));else MenuProdutos.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("154"));else MenuOs.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("155"));else MenuCompras.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("156"));else MenuLocacao.setVisible(false);
      
      // aqui valida as funcoes para opcoes dos relatorios
      
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("160"));else MiAniver.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("161"));else MiCad.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("162"));else MiRank.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("163"));else MiTotalPonto.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("164"));else MiContasReceber.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("165"));else MiContaPagar.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("166"));else MiMovCaixa.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("167"));else MiMovTipo.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("168"));else MiFluxo.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("169"));else MiResumoMov.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("170"));else MiVenProduto.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("171"));else MiProdMedia.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("172"));else MiTotalFin.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("173"));else MiVendasVend.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("174"));else MiVendGeral.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("175"));else MiVendParc.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("176"));else MiVendDiario.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("177"));else MiPosicaoEsto.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("178"));else MiApuracaoEst.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("179"));else MiDevo.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("180"));else MiOsMov.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("181"));else MiOsFunFin.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("182"));else MiOsFunAnd.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("183"));else MiOsServ.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("184"));else MiCOmprasForn.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("185"));else MiComprasProd.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("186"));else MiLocPerio.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("187"));else MiLocItens.setVisible(false);
      if(permissaoUsuarioDAO.verificaPermissaoUsuConectado("188"));else MiLocProd.setVisible(false);
    }
   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ContratoArma;
    public static javax.swing.JLabel LbContasPagar;
    public static javax.swing.JLabel LbContasReceber;
    private javax.swing.JLabel LbParceiros;
    private javax.swing.JLabel LbProdutos;
    private javax.swing.JMenu MenuArquivos;
    private javax.swing.JMenu MenuAtirado;
    private javax.swing.JMenu MenuCompras;
    public static javax.swing.JMenu MenuContrato;
    private javax.swing.JMenu MenuFinanceiro;
    private javax.swing.JMenu MenuLocacao;
    private javax.swing.JMenu MenuOs;
    private javax.swing.JMenu MenuProdutos;
    private javax.swing.JMenu MenuVendas;
    private javax.swing.JMenuItem MiAniver;
    private javax.swing.JMenuItem MiApuracaoEst;
    private javax.swing.JMenuItem MiCOmprasForn;
    private javax.swing.JMenuItem MiCad;
    private javax.swing.JMenuItem MiComprasProd;
    private javax.swing.JMenuItem MiContaPagar;
    private javax.swing.JMenuItem MiContasReceber;
    private javax.swing.JMenuItem MiDevo;
    private javax.swing.JMenuItem MiDevo1;
    private javax.swing.JMenuItem MiFluxo;
    private javax.swing.JMenuItem MiLocItens;
    private javax.swing.JMenuItem MiLocPerio;
    private javax.swing.JMenuItem MiLocProd;
    private javax.swing.JMenuItem MiMovCaixa;
    private javax.swing.JMenuItem MiMovTipo;
    private javax.swing.JMenuItem MiOsFunAnd;
    private javax.swing.JMenuItem MiOsFunFin;
    private javax.swing.JMenuItem MiOsMov;
    private javax.swing.JMenuItem MiOsServ;
    private javax.swing.JMenuItem MiPosicaoEsto;
    private javax.swing.JMenuItem MiProdMedia;
    private javax.swing.JMenuItem MiRank;
    private javax.swing.JMenuItem MiResumoMov;
    private javax.swing.JMenuItem MiTotalFin;
    private javax.swing.JMenuItem MiTotalPonto;
    private javax.swing.JMenuItem MiVenProduto;
    private javax.swing.JMenuItem MiVendDiario;
    private javax.swing.JMenuItem MiVendGeral;
    private javax.swing.JMenuItem MiVendParc;
    private javax.swing.JMenuItem MiVendasVend;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    public static javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem10;
    public static javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem54;
    private javax.swing.JMenuItem jMenuItem55;
    private javax.swing.JMenuItem jMenuItem56;
    private javax.swing.JMenuItem jMenuItem57;
    private javax.swing.JMenuItem jMenuItem58;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem60;
    private javax.swing.JMenuItem jMenuItem61;
    private javax.swing.JMenuItem jMenuItem62;
    private javax.swing.JMenuItem jMenuItem63;
    private javax.swing.JMenuItem jMenuItem64;
    private javax.swing.JMenuItem jMenuItem65;
    private javax.swing.JMenuItem jMenuItem66;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem70;
    private javax.swing.JMenuItem jMenuItem73;
    private javax.swing.JMenuItem jMenuItem74;
    private javax.swing.JMenuItem jMenuItem8;
    public static javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public static javax.swing.JLabel labelEmpresa;
    public static javax.swing.JLabel lbCondicional;
    private javax.swing.JLabel lbContrato;
    private javax.swing.JLabel lbContrato1;
    public javax.swing.JLabel lbDiasRestante;
    private javax.swing.JLabel lbDocumentos;
    private javax.swing.JLabel lbFecharAvisos;
    public static javax.swing.JLabel lbFluxo;
    private javax.swing.JLabel lbNfe;
    public static javax.swing.JLabel lbUsuario;
    public javax.swing.JLabel lbVersaoSistema;
    public static javax.swing.JLabel lbalvo;
    public static javax.swing.JMenuItem menuConferenciaCaixa;
    public static javax.swing.JMenu menuConfig;
    private javax.swing.JMenuItem menuContas;
    public static javax.swing.JMenuItem menuMovimentacaoCaixa;
    public javax.swing.JMenuItem menuSinc;
    public javax.swing.JMenuItem menuTipoSub;
    private javax.swing.JMenuItem menuUsuario;
    private javax.swing.JPanel pnAvisos;
    // End of variables declaration//GEN-END:variables

   /* private Object LbParceiros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    private void getImage() {
        try{
           // setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/LogoResumida.png")));
            setIconImage(Toolkit.getDefaultToolkit().getImage("c:/esfhera/adm/imagens/LogoResumida.png"));
        
        }catch(Exception ep){
             Logger.getLogger(formPrincipal1.class.getName()).log(Level.SEVERE, null, ep);
            JOptionPane.showMessageDialog(null, "erro ao buscar logo\n"+ ep.getMessage());
            Logs.gravarLog.main(ep.getMessage());
        }
        
    }
}
