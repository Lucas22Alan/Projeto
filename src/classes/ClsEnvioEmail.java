/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.EmailDAO;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import model.Tconfig_email;
import model.clsDadosEmpresa;

/**
 *
 * @author Mk Solucoes
 */
public class ClsEnvioEmail {
    protected  static  Tconfig_email tconfig_email= new Tconfig_email();
    
     public static void enviarEmail(String destinatario,String texto){
        
        tconfig_email=EmailDAO.buscar(tconfig_email);
        System.out.println(tconfig_email.toString());
        try {
            Properties pro=new Properties();
            pro.put("mail.smtp.host", tconfig_email.getSmtp());
            pro.put("mail.smtp.socketFactory.port", tconfig_email.getPorta());
            pro.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            pro.setProperty("mail.smtp.starttls.enable", tconfig_email.getTls());
            pro.put("mail.smtp.auth", tconfig_email.getAut());
            pro.put("mail.smtp.port", tconfig_email.getPorta());
            
            
            Session ses=Session.getDefaultInstance(pro, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(tconfig_email.getEmail(), tconfig_email.getSenha());
                }
            });
            
            ses.setDebug(true);
            
            MimeMessage msg= new MimeMessage(ses);
            
            
            Message message= new MimeMessage(ses);
            message.setFrom(new InternetAddress(tconfig_email.getEmail()));
            
            Address [] dest= InternetAddress.parse(destinatario);
            
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("E-mail Sistema Esfhera Light");//aqui vem o assunto do email
            message.setText(texto);
           
            Transport.send(message);
            JOptionPane.showMessageDialog(null,"E-mail Enviado Com Sucesso!!!");
            
            
        } catch (AddressException ex) {
            Logger.getLogger(ClsEnvioEmail.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        } catch (MessagingException ex) {
            Logger.getLogger(ClsEnvioEmail.class.getName()).log(Level.SEVERE, null, ex);
             Logs.gravarLog.main(ex.getMessage());
        }
        
     }
    
    
    public static void enviarEmailComAnexo(String caminho,String destinatario,String texto){
        
        tconfig_email=EmailDAO.buscar(tconfig_email);
        System.out.println(tconfig_email.toString());
        try {
            Properties pro=new Properties();
            pro.put("mail.smtp.host", tconfig_email.getSmtp());
            //pro.put("mail.smtp.socketFactory.port", "587");
            pro.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            pro.setProperty("mail.smtp.starttls.enable", "true");
            pro.put("mail.smtp.auth", "false");
            pro.put("mail.smtp.port", "587");
            
            
            Session ses=Session.getDefaultInstance(pro, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(tconfig_email.getEmail(), tconfig_email.getSenha());
                }
            });
            
            ses.setDebug(true);
            
            MimeMessage msg= new MimeMessage(ses);
            MimeBodyPart part= new MimeBodyPart();
            
            Message message= new MimeMessage(ses);
            message.setFrom(new InternetAddress(tconfig_email.getEmail()));
            
            Address [] dest= InternetAddress.parse(destinatario);
            
            message.setRecipients(Message.RecipientType.TO, dest);
            message.setSubject("E-mail contendo Arquivos Xml");//aqui vem o assunto do email
            message.setText("Email com arquivos xml referente as notas fiscais em anexo...");
            
            // gerar anexos
            
            DataSource dt= new FileDataSource(caminho);
            
            part.setDescription("Arquivo Xml");
            part.setDataHandler(new DataHandler(dt));
            part.setFileName(dt.getName());
            
            Multipart mult=new MimeMultipart();
            mult.addBodyPart(part);
            
            message.setContent(mult);
            
            Transport.send(message);
            JOptionPane.showMessageDialog(null,"E-mail Enviado Com Sucesso!!!");
            
            
        } catch (AddressException ex) {
            Logger.getLogger(ClsEnvioEmail.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        } catch (MessagingException ex) {
            Logger.getLogger(ClsEnvioEmail.class.getName()).log(Level.SEVERE, null, ex);
             Logs.gravarLog.main(ex.getMessage());
        }
        
     }
    
    public static void enviarNfeXmlPdf(String xml,String pdf,String destinatario,String texto,String nf){
        
        tconfig_email=EmailDAO.buscar(tconfig_email);
        System.out.println(tconfig_email.toString());
        try {
            Properties pro=new Properties();
            pro.put("mail.smtp.host", tconfig_email.getSmtp());
            pro.put("mail.smtp.socketFactory.port", tconfig_email.getPorta());
            pro.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            pro.setProperty("mail.smtp.starttls.enable", tconfig_email.getTls());
            pro.put("mail.smtp.auth", tconfig_email.getAut());
            pro.put("mail.smtp.port", tconfig_email.getPorta());
            
            
            Session ses=Session.getDefaultInstance(pro, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(tconfig_email.getEmail(), tconfig_email.getSenha());
                }
            });
            
            ses.setDebug(true);
            
            MimeMessage msg= new MimeMessage(ses);
            MimeBodyPart part= new MimeBodyPart();
            MimeBodyPart partPdf= new MimeBodyPart();
            BodyPart partTexto= new MimeBodyPart();
            
            Message message= new MimeMessage(ses);
            message.setFrom(new InternetAddress(tconfig_email.getEmail()));
            
            Address [] dest= InternetAddress.parse(destinatario);
            
            message.setRecipients(Message.RecipientType.TO, dest);
            message.setSubject("E-mail contendo Nfe e Xml da Nota Fiscal Eletronica");//aqui vem o assunto do email
            
            
            // gerar anexos
            
            DataSource dt= new FileDataSource(xml);
            DataSource dtPdf= new FileDataSource(pdf);
            
            part.setDescription("Xml NFe "+nf);
            part.setDataHandler(new DataHandler(dt));
            part.setFileName(dt.getName());
            partPdf.setDescription("Pdf NFe "+nf);
            partPdf.setDataHandler(new DataHandler(dtPdf));
            partPdf.setFileName(dtPdf.getName());
            partTexto.setText("E-mail, contendo os arquivos Referente a NFe, emitida por "+clsDadosEmpresa.getRazao()+"...\nE-mail gerado e enviado por Esfhera Light...");
            Multipart mult=new MimeMultipart();
            mult.addBodyPart(partTexto);
            mult.addBodyPart(part);
            mult.addBodyPart(partPdf);
            message.setContent(mult);
            
            
            Transport.send(message);
            JOptionPane.showMessageDialog(null,"E-mail Enviado Com Sucesso!!!");
            
            
        } catch (AddressException ex) {
            Logger.getLogger(ClsEnvioEmail.class.getName()).log(Level.SEVERE, null, ex);
            Logs.gravarLog.main(ex.getMessage());
        } catch (MessagingException ex) {
            Logger.getLogger(ClsEnvioEmail.class.getName()).log(Level.SEVERE, null, ex);
             Logs.gravarLog.main(ex.getMessage());
        }
        
     }
    
}
