import java.util.Properties;
import java.util.Vector;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * this class to send mails to persons with verification code
 * * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
public class MailUtil {
	/**
	 * this function  to send email with verification code and admin send that email to Person who SignUp 
	 * @param to email's Person who SignUP
	 * @param subject subject of email
	 * @param body body of email
	 */
	public static void sendEmail(String to, String subject, String body){
		 String from = "GofoProject2020@gmail.com";
		 final String password = "Eaalr?1999";

         Properties props = new Properties();    
         props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "465");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "465");    
         //get Session   
         Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication(from,password);  
          }    
         });    
         /**
          * compose message    
          */
         try {    
          MimeMessage message = new MimeMessage(session);    
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
          message.setSubject(subject);    
          message.setText(body);    
          //send message  
          Transport.send(message);    
          System.out.println("message sent successfully");    
         } catch (MessagingException e) {throw new RuntimeException(e);}    	  
}
	/**
	 *  function to send emails to Persons like when we invite team ,admin send emails to invited team
	 * @param to  Persons to send email
	 * @param subject is the subject of email
	 * @param body is the body of email
	 */
	public static void sendEmail(Vector<String> to, String subject, String body){
		 String from = "GofoProject2020@gmail.com";
		 final String password = "Eaalr?1999";

        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        /**
         * get Session   
         */
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        /**
         * compose message    
         */
        try {    
         MimeMessage message = new MimeMessage(session);
         for(String tto:to) message.addRecipient(Message.RecipientType.TO,new InternetAddress(tto));    
         message.setSubject(subject);    
         message.setText(body);    
         /**
          * send message  
          */
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    	  
}
}
