package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.web.config.Constants;
import com.web.model.SynchronizedData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ServiceUtils {
    public static final Gson gson = new GsonBuilder()
            .serializeNulls()
            .create();
    private static final Logger logger = LoggerFactory.getLogger(ServiceUtils
            .class);

    public static String httpGet(String urlString, String accessToken) {
        HttpsURLConnection con = null;
        try {
            URL url = new URL(urlString);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " +
                    accessToken);
            con.setRequestProperty("Accept-Language", "en_US");

            logger.info("\nSending 'GET' request to URL :: " + url);
            int responseCode = con.getResponseCode();
            logger.info("Response Code :: " + responseCode);

            if (responseCode == 200) {
                return processData(con);
            }
        } catch (MalformedURLException ex) {
            logger.error("" + ex);
        } catch (IOException ex) {
            logger.error("" + ex);
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    logger.error("" + ex);
                }
            }
        }
        return null;
    }

    public static String processData(HttpsURLConnection con) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader
                (con.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        logger.debug("Received data :: " + sb.toString());
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    public static String getTodayDate() {
        DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormat);
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public static String getYesterdayDate() {
        DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormat);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return dateFormat.format(cal.getTime());
    }

    public static String getYesterdayDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormat);
        Date oneDayBefore = null;
        try {
            Date date = dateFormat.parse(dateString);
            oneDayBefore = new Date(date.getTime() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateFormat.format(oneDayBefore);
    }

    public static List<SynchronizedData> getSynchronizedDataList() {
        List<SynchronizedData> synchronizedData = new
                ArrayList<SynchronizedData>();
        DecimalFormat formatter = new DecimalFormat("00");
        for (int i = 22; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                String minute = "" + i + ":" + formatter.format(j);
                SynchronizedData sdm = new SynchronizedData();
                sdm.setTime(minute);
                synchronizedData.add(sdm);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 60; j++) {
                String minute = "" + formatter.format(i) + ":"
                        + formatter.format(j);
                SynchronizedData sdm = new SynchronizedData();
                sdm.setTime(minute);
                synchronizedData.add(sdm);
            }
        }

        return synchronizedData;
    }

    public static void sendEmailNotification(String name, String email,
                                             String subject, String body) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        try {
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(Constants.GMAIL_USERNAME,
                                    Constants.GMAIL_PASSWORD);
                        }
                    });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Constants.GMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText("Dear " + name + ",\n Thank you for contacting us. "
                    + "We will get back to you as soon as we can.\n\n\n Your message - \n\n"
                    + subject + "\n\n" + body);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
