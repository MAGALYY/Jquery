package mx.edu.utng.avance.model;

/**
 * Created by EquipoHome on 15/04/2016.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




//Class is extending AsyncTask because this class is going to perform a networking operation
public class Correo {

    private Session session;

    //Information to send email
    private String email;
    private String subject;
    private String message;



    //Class Constructor
    public Correo( String email, String subject, String message){
        //Initializing variables
        Log.i("Email", "recibido: "+email);
        this.email = email;
        this.subject = subject;
        this.message = message;
    }



    public void enviarResultado() {
        //Creating properties
        Properties props = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable", "true");

        sistemas auth = new sistemas();
        Session session = Session.getInstance(props , auth);

        try {
            //Creating MimeMessage object
            MimeMessage mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress("manual.jquery.16@gmail.com"));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Adding subject
            mm.setSubject(subject);
            //Adding message
            mm.setText(message);

            //Sending email
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}


class sistemas extends javax.mail.Authenticator
{
    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = "manual.jquery.16@gmail.com";
        String password = "Jquery16/";

        return new PasswordAuthentication(username, password);
    }
}
