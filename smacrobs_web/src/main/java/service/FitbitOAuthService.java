package service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.FitbitTokens;
import com.web.utils.Constants;

public class FitbitOAuthService {
	String redirectUrl;
	ModelAndView mv;
	String url;
	String urlParameters;
	HttpsURLConnection con;
	URL urlobj;
	DataOutputStream dataOutputStream;
	BufferedReader br;
	JSONObject jsonObject;

	public FitbitTokens getFitbitTokens(String authCode) throws IOException {
		// Create URL
		url = Constants.getFitbitUriForTokens();
		urlobj = new URL(url);

		// Create Connection
		con = (HttpsURLConnection) urlobj.openConnection();

		// add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Authorization",
				"Basic MjI3Rk40OjVmNmU0NmI0ZDI5NTZlODAwNTZjYjk3ZGEwYTI3YTZm");
		con.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		urlParameters = getURLParameters() + authCode;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream dataOutputStream = new DataOutputStream(
				con.getOutputStream());
		dataOutputStream.writeBytes(urlParameters);

		// Close
		dataOutputStream.flush();
		dataOutputStream.close();

		int responseCode = con.getResponseCode();

		// Debug statements
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		// read the response
		br = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String inputLine;
		String fitbitTokens = "";

		while ((inputLine = br.readLine()) != null) {
			fitbitTokens = fitbitTokens + inputLine + "\n";
		}
		br.close();

		// print result
		System.out.println(fitbitTokens);

		// parse json
		jsonObject = new JSONObject(fitbitTokens);
		String accessToken = jsonObject.get("access_token").toString();
		String refreshToken = jsonObject.get("refresh_token").toString();
		
		FitbitTokens fitbittokens = new FitbitTokens(accessToken,refreshToken);
		return fitbittokens;
	}
	
	private String getURLParameters()
	{
		return "client_id=227FN4&grant_type=authorization_code&redirect_uri=http://localhost:8081/smacrobs/oauthredirect&code=";
	}
	

}
