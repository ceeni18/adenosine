package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by uday on 4/9/16.
 */
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

            logger.info("\nSending 'GET' request to URL : " + url);
            int responseCode = con.getResponseCode();
            logger.info("Response Code : " + responseCode);

            if (responseCode == 200) {
                return processData(con);
            }
        } catch (MalformedURLException ex) {
            logger.error(""+ex);
        } catch (IOException ex) {
            logger.error(""+ex);
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    logger.error(""+ex);
                }
            }
        }
        return null;
    }

    public static String processData(HttpsURLConnection con) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader
                (con.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        logger.info("Received data: " + sb.toString());
        if(sb.length() == 0){
            return null;
        }
        return sb.toString();
    }
}
