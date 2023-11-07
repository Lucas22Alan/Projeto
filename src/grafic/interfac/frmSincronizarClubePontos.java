/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafic.interfac;

import model.clsConfig;
import conexoes.conexao;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;

/**
 *
 * @author lucas
 */
public class frmSincronizarClubePontos extends javax.swing.JDialog {

    /**
     * Creates new form frmSincronizarClubePontos
     */
    public frmSincronizarClubePontos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        cbEnvParceiros = new javax.swing.JCheckBox();
        cbEnvPontos = new javax.swing.JCheckBox();
        cbEnvTitulos = new javax.swing.JCheckBox();
        cbEnvItensTitulos = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Envio Informações para API");

        jPanel1.setBackground(new java.awt.Color(219, 227, 227));

        jPanel2.setBackground(new java.awt.Color(219, 227, 227));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Seleciona as Informações a Sincronizar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        cbEnvParceiros.setBackground(new java.awt.Color(219, 227, 227));
        cbEnvParceiros.setSelected(true);
        cbEnvParceiros.setText("Cadastro de Parceiros");

        cbEnvPontos.setBackground(new java.awt.Color(219, 227, 227));
        cbEnvPontos.setSelected(true);
        cbEnvPontos.setText("Pontos Acumulados");

        cbEnvTitulos.setBackground(new java.awt.Color(219, 227, 227));
        cbEnvTitulos.setText("Titulos");

        cbEnvItensTitulos.setBackground(new java.awt.Color(219, 227, 227));
        cbEnvItensTitulos.setText("Itens Referente a Titulos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbEnvParceiros)
                        .addGap(26, 26, 26)
                        .addComponent(cbEnvPontos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbEnvTitulos, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbEnvItensTitulos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEnvParceiros)
                    .addComponent(cbEnvPontos)
                    .addComponent(cbEnvTitulos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(cbEnvItensTitulos)
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Confirma.png"))); // NOI18N
        jButton1.setText("Iniciar Envio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(219, 227, 227));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Log", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jButton1)
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (clsConfig.enviaapi.equals("S")){
            Thread nova= new Thread(()->{
                try {
                    carregaInfEnv();
                } catch (BadLocationException ex) {
                    Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            nova.start();
        }else {
            JOptionPane.showMessageDialog(null, "Não está habilitado o envio de\n    informações para API...");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void carregaInfEnv() throws BadLocationException{
            imprimeLog("Iniciando Envio");
            if (cbEnvParceiros.isSelected()){
               this.envParceiros();
            }
            if(cbEnvPontos.isSelected()){
                this.envPontosClube();
            }
            if (cbEnvTitulos.isSelected()){
                this.envTitulos();
            }
            if (cbEnvItensTitulos.isSelected()){
               this.validaTituloEnviado();
            }
            imprimeLog("Informações Enviadas Com Sucesso!!!");
    }
    public void envParceiros() throws BadLocationException{
        try {
            String sql="select idparceiro,cnpj,razao_social from tparceiros where env_api='S';";
            PreparedStatement ps =conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //imprimeLog("enviando Dados "+env+"/"+"reg");
                imprimeLog("Enviando Dados Parceiro "+rs.getString(1));
                this.comunicaApiEnvInf("http://esfheradev-com.umbler.net/clientes",rs.getString(1),rs.getString(3),rs.getString(2));
            };
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        }
        
    }
    public void envPontosClube(){
        try {
            String sql="select  sum(ti.pontos),\n" +
                    "        iif((select  sum (tp.qnt_pontos) from tresgate_pontos tp\n" +
                    "        where tp.estado=2 and tp.id_parceiro=tm.id_parceiro) is null,'0.00',\n" +
                    "        (select  sum (tp.qnt_pontos) from tresgate_pontos tp\n" +
                    "        where tp.estado=2 and tp.id_parceiro=tm.id_parceiro))as consumido,\n" +
                    "        tm.id_parceiro\n" +
                    "        from titens ti\n" +
                    "        join tmovimento tm on ti.id_mov=tm.id_mov\n" +
                    "        where tm.dat_finalizacao between\n" +
                    "        (select data_ini_fidelidade from tconfig) and current_date and tm.estado=2 and ti.estado=2 and\n" +
                    "        (tm.id_tipo=1 or tm.id_tipo=2)\n" +
                    "        group by 3";
            PreparedStatement ps =conexao.getPreparedStatement(sql);
            ResultSet rs1 = ps.executeQuery();
            while(rs1.next()){
                imprimeLog("Enviando Dados Pontos Parceiro "+rs1.getString(3));
                Double total=rs1.getDouble(1)-rs1.getDouble(2);
                this.comunicaApiEnvPts("http://esfheradev-com.umbler.net/received/ptsPorClienteV1",rs1.getString(3),total);
            };
            rs1.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        }
    }
    public void envTitulos(){
         try {
            String sql="select tc.id,tc.id_parceiro,tc.data,tc.valor,tc.estado,\n" +
                        "       tc.valor - iif(tc.valor_pago is null, 0.00,tc.valor_pago),\n" +
                        "        tp.descricao,\n" +
                        "        tc.data_pagamento\n" +
                        "from tcontas_a_receber_pagar  tc\n" +
                        "join testado_operacoes tp on tc.estado=tp.id\n" +
                        "where  pagar_receber=2";
            PreparedStatement ps =conexao.getPreparedStatement(sql);
            ResultSet rs1 = ps.executeQuery();
            while(rs1.next()){
                imprimeLog("Enviando Dados Pontos Parceiro "+rs1.getString(2));
                this.comunicaApiEnvTitulos("http://esfheradev-com.umbler.net/received/tituloPorParceirosV1",
                        rs1.getString(1),
                        rs1.getDouble(4),
                        rs1.getString(2),
                        rs1.getString(5),
                        rs1.getString(3),
                        rs1.getString(7),
                        rs1.getDouble(6),
                        rs1.getString(8)
                        );
            };
            rs1.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void envItensTitulos(){
        String var=null;
        try {
            String sql="select ti.codi_barra,\n" +
                    "        tp.nomecurto,\n" +
                    "        ti.quantidade,\n" +
                    "        ti.prec_venda,\n" +
                    "        ti.total,\n" +
                    "        tr.id\n" +
                    " from titens ti\n" +
                    " join tprodutos tp on ti.id_prod=tp.id\n" +
                    " join tcontas_a_receber_pagar tr on tr.id_movimento=ti.id_mov\n" +
                    " where tr.pagar_receber=2 and tr.estado=4 and tr.id>(select ult_titulo_env_api from tconfig)";
            PreparedStatement ps = conexao.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                imprimeLog("Enviando Itens Titulo "+ rs.getString(6));
                this.comunicaApiEnvItens("http://esfheradev-com.umbler.net/received/itensPorTitulosV1", rs.getString(6), rs.getString(1), rs.getString(2), rs.getDouble(4),rs.getDouble(5), rs.getDouble(3));
                var=rs.getString(6);
            }
            rs.close();
            ps.close();
            String atualizaid="update tconfig set ult_titulo_env_api=?";
            PreparedStatement psa=conexao.getPreparedStatement(atualizaid);
            psa.setString(1, var);
            psa.executeUpdate();
            psa.close();
        } catch (SQLException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
            
        }
        
        
    }
    public void comunicaApiEnvInf(String urloriginal,String id,String nome,String cpf){
        try {
            URL url= new URL(urloriginal);
            Map<String, Object> parametros=new LinkedHashMap();
            parametros.put("nome", nome);
            parametros.put("cpf", cpf);
            parametros.put("id", id);
            StringBuilder posDat= new StringBuilder();
            for (Map.Entry<String,Object> param: parametros.entrySet()){
                if(posDat.length()!=0) posDat.append("&");
                posDat.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                posDat.append("=");
                posDat.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
            }
            byte [] postDataBytes= posDat.toString().getBytes("UTF-8");
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            int resposta=conn.getResponseCode();
            if (resposta==200){
                imprimeLog("Enviado com sucesso");
            } else {
                imprimeLog("Erro ao enviar codigo do erro" +resposta);
            }
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        }
    }
    public void comunicaApiEnvPts(String urloriginal,String id,Double pontos){
        try {
            URL url= new URL(urloriginal);
            Map<String, Object> parametros=new LinkedHashMap();
            parametros.put("pontos", pontos);
            parametros.put("id", id);
            StringBuilder posDat= new StringBuilder();
            for (Map.Entry<String,Object> param: parametros.entrySet()){
                if(posDat.length()!=0) posDat.append("&");
                posDat.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                posDat.append("=");
                posDat.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
            }
            byte [] postDataBytes= posDat.toString().getBytes("UTF-8");
            
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            int resposta=conn.getResponseCode();
            if (resposta==200){
                imprimeLog("Enviado com sucesso");
            } else {
                imprimeLog("Erro ao enviar codigo do erro" +resposta);
            }
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        }
    }
    public void comunicaApiEnvTitulos(String urloriginal,String idtitulo,Double valor, String idparceiro,String estado,String data,String descest, Double pago,String datapg){
        try {
            URL url= new URL(urloriginal);
            Map<String, Object> parametros=new LinkedHashMap();
            parametros.put("id", idparceiro);
            parametros.put("valor", valor);
            parametros.put("situacao", estado);
            parametros.put("titulo", idtitulo);
            parametros.put("emissao", data);
            parametros.put("descest", descest);
            parametros.put("vlpg", pago);
            parametros.put("dtpg", datapg);
            StringBuilder posDat= new StringBuilder();
            for (Map.Entry<String,Object> param: parametros.entrySet()){
                if(posDat.length()!=0) posDat.append("&");
                posDat.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                posDat.append("=");
                posDat.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
            }
            byte [] postDataBytes= posDat.toString().getBytes("UTF-8");
            
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            int resposta=conn.getResponseCode();
            if (resposta==200){
                imprimeLog("Enviado com sucesso");
            } else {
                imprimeLog("Erro ao enviar codigo do erro" +resposta);
            }
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        }
    }
    public void comunicaApiEnvItens(String urloriginal,String idtitulo,String barras, String descricao, Double unit, Double total, Double qnt){
     try {
            URL url= new URL(urloriginal);
            Map<String, Object> parametros=new LinkedHashMap();
            parametros.put("titulo",idtitulo );
            parametros.put("codigobarras", barras );
            parametros.put("nome", descricao);
            parametros.put("qnt", qnt);
            parametros.put("vlunit",unit );
            parametros.put("total", total);
            StringBuilder posDat= new StringBuilder();
            for (Map.Entry<String,Object> param: parametros.entrySet()){
                if(posDat.length()!=0) posDat.append("&");
                posDat.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                posDat.append("=");
                posDat.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
            }
            byte [] postDataBytes= posDat.toString().getBytes("UTF-8");
            
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            int resposta=conn.getResponseCode();
            if (resposta==200){
                imprimeLog("Enviado com sucesso");
            } else {
                imprimeLog("Erro ao enviar codigo do erro" +resposta);
            }
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
            imprimeLog(ex.getMessage());
        }    
    
    }
    public void validaTituloEnviado(){
        try {
            String sql="select first 1 id,\n" +
                    "       (select ult_titulo_env_api from tconfig)\n" +
                    " from tcontas_a_receber_pagar\n" +
                    "where pagar_receber=2 order by 1 desc";
            PreparedStatement ps = conexao.getPreparedStatementResult(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            Double ulttitulo=rs.getDouble(1);
            Double ultenv=rs.getDouble(2);
            if (ulttitulo>ultenv){
                this.envItensTitulos();
            } else {
                imprimeLog("Não existem itens a ser enviados");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    private void imprimeLog(String texto){
        System.out.println(texto);
        EventQueue.invokeLater(()->txtLog.append(texto+" \n"));
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
            java.util.logging.Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSincronizarClubePontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmSincronizarClubePontos dialog = new frmSincronizarClubePontos(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox cbEnvItensTitulos;
    private javax.swing.JCheckBox cbEnvParceiros;
    private javax.swing.JCheckBox cbEnvPontos;
    private javax.swing.JCheckBox cbEnvTitulos;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}