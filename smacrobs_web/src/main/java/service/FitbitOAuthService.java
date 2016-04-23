package service;

import com.web.config.Constants;
import com.web.model.FitbitTokens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service("FitbitOAuthService")
public class FitbitOAuthService implements FitbitOAuthServiceIntf {
	private static final Logger logger = LoggerFactory.getLogger(FitbitOAuthService
			.class);


	public FitbitTokens getFitbitTokens(String authCode) {
		logger.info("Asking Fitbit for access tokens");
		HttpsURLConnection con = null;
		String data = null;
		try {
			URL url = new URL(Constants.fitbitUriForTokens);
			con = (HttpsURLConnection) url.openConnection();

			// add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization",
					"Basic "+Constants.appClientIdAndSecrect);
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			con.setRequestProperty("Accept-Language", "en_US");

			// Send post request
			con.setDoOutput(true);
			DataOutputStream dataOutputStream = new DataOutputStream(con
					.getOutputStream());
			dataOutputStream.writeBytes(getURLParameters(authCode));
			dataOutputStream.flush();
			dataOutputStream.close();
			logger.debug("\nSent 'POST' request to URL : " + con.getURL()+
					" Response Code : " + con.getResponseCode());
			data = ServiceUtils.processData(con);
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
		FitbitTokens fitbitTokens = ServiceUtils.gson.fromJson(data,
				FitbitTokens.class);
		return fitbitTokens;
	}

	private String getURLParameters(String authCode) {
		return "client_id="+Constants.fitbitOauthClientId +
				"&grant_type=authorization_code" +
				"&redirect_uri=" + Constants.LOCALHOST + Constants
				.redirectUriFromFitbit +
				"&code=" + authCode;
	}
}
