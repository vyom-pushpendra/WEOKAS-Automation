package vYomUtilities;

import jakarta.mail.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailOtpReader {

    public static String getOTP() throws Exception {

        String host = "imap.gmail.com";
        String username = "pushpendrakumar.qa@gmail.com";
        String password = "ezly fpog tlcn yvlc";

        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");

        Session session = Session.getInstance(props);

        Store store = session.getStore("imaps");
        store.connect(host, username, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();

        
        // check 20 last email
        for (int i = messages.length - 1;
             i >= 0 && i >= messages.length - 20;
             i--) {

            Message msg = messages[i];

            System.out.println("Subject : " + msg.getSubject());

            
            // only read okas otp
            if (msg.getSubject() != null &&
                msg.getSubject().contains("OKAS")) {

                String body = getTextFromMessage(msg);

                System.out.println("Body : " + body);

                Pattern pattern = Pattern.compile("\\d{6}");
                Matcher matcher = pattern.matcher(body);

                if (matcher.find()) {

                    String otp = matcher.group();

                    System.out.println("OTP Found : " + otp);

                    inbox.close(false);
                    store.close();

                    return otp;
                }
            }
        }

        inbox.close(false);
        store.close();

        return null;
    }

    private static String getTextFromMessage(Message message)
            throws Exception {

        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        }

        if (message.isMimeType("multipart/*")) {

            Multipart multipart =
                    (Multipart) message.getContent();

            for (int i = 0; i < multipart.getCount(); i++) {

                BodyPart bodyPart =
                        multipart.getBodyPart(i);

                if (bodyPart.isMimeType("text/plain")) {
                    return bodyPart.getContent().toString();
                }

                if (bodyPart.isMimeType("text/html")) {
                    String html =
                            bodyPart.getContent().toString();

                    return html.replaceAll("<[^>]*>", " ");
                }
            }
        }

        return "";
    }
}