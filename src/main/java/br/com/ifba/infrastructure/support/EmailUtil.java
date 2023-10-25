package br.com.ifba.infrastructure.support;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.ifba.entity.usuario.model.Usuario;

/**
 *
 * @author tarciiz
 * @apiNote
 *          Salmos 1.0 credentials:
 *          Email: salmosrecover@outlook.com.br
 *          Senha: salmos1.0
 */

public class EmailUtil {
    private static final String USERNAME = "salmosrecover@outlook.com.br";
    private static final String PASSWORD = "salmos1.0";
    private static final String HOST = "smtp-mail.outlook.com";
    private static final String PORT = "587";
    static Session session;

    static {
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Hotmail */
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.user", USERNAME);
        props.put("mail.smtp.pwd", PASSWORD);
        // props.put("mail.smtp.ssl.enable", "true");

        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        /** Ativa Debug para sessão */
        session.setDebug(true);
    }

    public static boolean sendEmail(String adress, String title, String msg) {
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            // Remetente

            Address[] toUser = InternetAddress.parse(adress);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(title);// Assunto
            message.setText(msg);
            /** Método para enviar a mensagem criada */
            Transport.send(message, USERNAME, PASSWORD);

            System.out.println("Feito!!!");
            return true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean sendRecoverPasswordEmail(String adress, String code, Usuario user) {
        String subject = "Recupere sua senha do Salmos";

        String messageText = "";

        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader("src/br/com/ifba/salmos/infrastructure/support/emailTemplate.html"));
            System.out.println("Arquivo aq:::: \n" + in.toString());
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Erro::: " + e.getMessage());
        }
        messageText = contentBuilder.toString();

        messageText = messageText.replace("**helloMessage**", "Olá");
        // messageText = messageText.replace("**name**", user.getPessoa().getNome());

        messageText = messageText.replace("**codeInfo**", "Seu código SalmosRecover é:");
        messageText = messageText.replace("**infoMessage**",
                "Você solicitou a recuperação do seu acesso do Salmos 1.0");
        messageText = messageText.replace("**num0**", String.valueOf(code.charAt(0)));
        messageText = messageText.replace("**num1**", String.valueOf(code.charAt(1)));
        messageText = messageText.replace("**num2**", String.valueOf(code.charAt(2)));
        messageText = messageText.replace("**num3**", String.valueOf(code.charAt(3)));
        messageText = messageText.replace("**num4**", String.valueOf(code.charAt(4)));
        messageText = messageText.replace("**finalMessage**",
                "Caso você não tenha solicitado essa alteração, entre em contato com seu supervisor!");

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            // Remetente

            Address[] toUser = InternetAddress.parse(adress);

            message.setRecipients(Message.RecipientType.TO, toUser);

            message.setSubject(subject);// Assunto

            message.setContent(messageText, "text/html");

            // message.setContent(messageText, "text/html;charset=UTF-8");

            /** Método para enviar a mensagem criada */
            Transport.send(message, USERNAME, PASSWORD);

            System.out.println("Feito!!!");
            return true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
