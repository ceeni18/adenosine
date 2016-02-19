package service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.SleepDetails;
import com.web.utils.Constants;

@Service("SleepDetailsService")
public class SleepDetailsService implements ISleepDetailsService {

	String redirectUrl;
	ModelAndView mv;
	String url;
	String urlParameters;
	HttpsURLConnection con;
	URL urlobj;
	DataOutputStream dataOutputStream;
	BufferedReader br;
	JSONObject jsonObject;

	// TODO : Need to plug-in date dynamically
	public SleepDetails getSleepDetails(String accessToken, String refreshToken)
			throws IOException {

		url = Constants.getMinutesAsleepURL() + "2015-11-19/2015-11-19"
				+ ".json";
		urlobj = new URL(url);

		con = (HttpsURLConnection) urlobj.openConnection();

		// add request header
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "Bearer " + accessToken);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		// read the data
		br = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String sleepData = "";

		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			sleepData = sleepData + inputLine + "\n";
		}

		System.out.print(sleepData);

		br.close();

		// parse json
		jsonObject = new JSONObject(sleepData);
		JSONObject innerJsonObject = new JSONObject(jsonObject
				.get("sleep-minutesAsleep").toString().replace("[", "")
				.replace("]", ""));

		SleepDetails sleepDetails = new SleepDetails(innerJsonObject.get(
				"value").toString());

		return sleepDetails;

	}
}
