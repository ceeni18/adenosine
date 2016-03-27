package service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.web.controller.IndexController;
import com.web.model.HeartRateDetails;
import com.web.model.SleepDetails;
import com.web.utils.Constants;

import repository.FitbitDetailsRepositoryIntf;

@Service("SleepDetailsService")
public class FitbitDetailsServiceImpl implements FitbitDetailsServiceIntf {
	private static final Logger logger = Logger.getLogger(
											FitbitDetailsServiceImpl.class);
	String redirectUrl;
	ModelAndView mv;
	String url;
	String urlParameters;
	HttpsURLConnection con;
	URL urlobj;
	DataOutputStream dataOutputStream;
	BufferedReader br;
	JSONObject jsonObject;
	FitbitDetailsRepositoryIntf fitbitDetailsRepository;

	@Autowired
	Constants constants;
	
	@Autowired
	public FitbitDetailsServiceImpl(FitbitDetailsRepositoryIntf sleepRepository) {
		this.fitbitDetailsRepository = sleepRepository;
	}

	public SleepDetails getSleepDetails(String accessToken, String refreshToken)
			throws IOException {

		url = constants.getSleepLogURL() + "2015-12-19"
				+ Constants.JSON_EXTENSION;
		urlobj = new URL(url);

		con = (HttpsURLConnection) urlobj.openConnection();

		// add request header
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "Bearer " + accessToken);
		int responseCode = con.getResponseCode();
		logger.info("\nSending 'GET' request to URL : " + url);
		logger.info("Response Code : " + responseCode);
		// read the data
		br = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String sleepData = "";

		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			sleepData = sleepData + inputLine + "\n";
		}

		logger.info(sleepData);
		br.close();

		// parse Sleep json data
		jsonObject = new JSONObject(sleepData);
		JSONArray sleepObj = jsonObject.getJSONArray("sleep");
		JSONArray sleepMinObj = null;
		SleepDetails sleepDetails = null;
		Map<String, Integer> sleepMap = new HashMap<String, Integer>();

		if (sleepObj != null) {
			for (int i = 0; i < sleepObj.length(); i++) {
				JSONObject jObj = sleepObj.getJSONObject(i);
				long id = Long.parseLong(jObj.get("logId").toString());
				int eff = Integer.parseInt(jObj.get("efficiency").toString());
				long dur = Math.round(Long.parseLong(jObj.get("duration").toString())/(1000*60*60*24));
				int rCount = Integer.parseInt(jObj.get("restlessCount")
						.toString());
				int aCount = Integer
						.parseInt(jObj.get("awakeCount").toString());
				boolean isMain = Boolean.parseBoolean(jObj.get("isMainSleep")
						.toString());
				// String dTime = jsObj.get("dateTime").toString();
				// int val = Integer.parseInt(jsObj.get("value").toString());
				sleepMinObj = jObj.getJSONArray("minuteData");
				for (int j = 0; j < sleepMinObj.length(); j++) {
					JSONObject sObj = sleepMinObj.getJSONObject(j);
					sleepMap.put(sObj.get("dateTime").toString(),
							Integer.parseInt(sObj.get("value").toString()));
				}
				Map<String, Integer> sortSleepMap = new TreeMap<String, Integer>(
						sleepMap);
				if (isMain) {
					// sleepDetails = new SleepDetails(id, eff, dur, rCount,
					// aCount, isMain, dTime, val);
					sleepDetails = new SleepDetails(id, eff, dur, rCount,
							aCount, isMain, sortSleepMap);
				}
			}
		}
		if (sleepDetails != null)
			fitbitDetailsRepository.saveSleepData(sleepDetails);
		return sleepDetails;

	}

	public HeartRateDetails getHeartRateDetails(String accessToken,
			String refreshToken) throws IOException {
		url = constants.getHeartRateURL();
		urlobj = new URL(url);

		con = (HttpsURLConnection) urlobj.openConnection();

		// add request header
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "Bearer " + accessToken);

		int responseCode = con.getResponseCode();
		logger.info("\nSending 'GET' request to URL : " + url);
		logger.info("Response Code : " + responseCode);

		// read the data
		br = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String heartData = "";

		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			heartData = heartData + inputLine + "\n";
		}

		br.close();

		HeartRateDetails heartRateDetails = new HeartRateDetails();

		// parse Sleep json data
		jsonObject = new JSONObject(heartData);
		JSONArray heartObj = jsonObject.getJSONArray("activities-heart");

		if (heartObj != null) {
			JSONObject childJSONObject = heartObj.getJSONObject(0);
			if (childJSONObject != null)
				heartRateDetails.setTime(childJSONObject.getString("dateTime"));

			JSONObject value = childJSONObject.getJSONObject("value");
			if (value != null){
				try{
				heartRateDetails.setHeartRate(value.getInt("restingHeartRate"));
				}
				catch(Exception ex){ }
				}

			fitbitDetailsRepository.saveHeartRateData(heartRateDetails);
		}

		return heartRateDetails;
	}
}