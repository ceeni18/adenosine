package service;

import com.web.model.SynchronizedData;
import com.web.model.TiSensorHumidity;
import com.web.model.TiSensorLight;
import com.web.model.TiSensorTemperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import repository.TiSensorRepositoryImpl;

import javax.servlet.http.HttpSession;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

/**
 * Created by uday on 4/27/16.
 */

@Service("TiSensorService")
public class TiSensorService {
	private static final Logger logger = LoggerFactory.getLogger
			(TiSensorService.class);
	@Autowired
	TiSensorRepositoryImpl tiSensorRepository;

	private String userId;
	private String todayDate;
	private String yesterdayDate;


	public void setSessionVariables(HttpSession session) {
		this.userId = session.getAttribute("userId").toString();
		this.todayDate = session.getAttribute("todayDate").toString();
		this.yesterdayDate = session.getAttribute("yesterdayDate").toString();
	}

	public List<TiSensorTemperature> getTemperaturesFromDB() {
		List<TiSensorTemperature> tiSensorTemperatures =
				tiSensorRepository.getTemperatures(userId, yesterdayDate);
		return tiSensorTemperatures;
	}

	public List<TiSensorLight> getLightFromDB() {
		List<TiSensorLight> tiSensorLightData =
				tiSensorRepository.getLightData(userId, yesterdayDate);
		return tiSensorLightData;
	}

	public List<TiSensorHumidity> getHumidityFromDB() {
		List<TiSensorHumidity> tiSensorHumidityData =
				tiSensorRepository.getHumidityData(userId, yesterdayDate);
		return tiSensorHumidityData;
	}

	public List<SynchronizedData> getTemperatureInRequiredFormat() {

		List<TiSensorTemperature> temperatures = getTemperaturesFromDB();
		HashMap<String, String> tempHash = new HashMap<String, String>();

		for (int i = 0; i < temperatures.size(); i++) {
			TiSensorTemperature tiSensorTemperature = temperatures.get(i);
			tempHash.put(tiSensorTemperature.getTimestamp().substring(0, 5) + "",
					tiSensorTemperature.getTemperature() + "");
		}

		List<SynchronizedData> synchronizedTemperatureData = ServiceUtils
				.getSynchronizedDataList();

		for (SynchronizedData sdm : synchronizedTemperatureData) {
			if (tempHash.containsKey(sdm.getTime())) {
				sdm.setValue(tempHash.get(sdm.getTime()));
			}
		}

		return synchronizedTemperatureData;
	}

	public List<SynchronizedData> getLightInRequiredFormat() {
		List<TiSensorLight> lightData = getLightFromDB();
		HashMap<String, String> tempHash = new HashMap<String, String>();

		for (int i = 0; i < lightData.size(); i++) {
			TiSensorLight tiSensorLight = lightData.get(i);
			tempHash.put(tiSensorLight.getTimestamp().substring(0, 5) + "",
					tiSensorLight.getLight() + "");
		}

		List<SynchronizedData> synchronizedLightData = ServiceUtils
				.getSynchronizedDataList();

		for (SynchronizedData sdm : synchronizedLightData) {
			if (tempHash.containsKey(sdm.getTime())) {
				sdm.setValue(tempHash.get(sdm.getTime()));
			}
		}

		return synchronizedLightData;
	}

	public List<SynchronizedData> getHumidityInRequiredFormat() {
		List<TiSensorHumidity> humidityData = getHumidityFromDB();
		HashMap<String, String> tempHash = new HashMap<String, String>();

		for (int i = 0; i < humidityData.size(); i++) {
			TiSensorHumidity tiSensorHumidity = humidityData.get(i);
			tempHash.put(tiSensorHumidity.getTimestamp().substring(0, 5) + "",
					tiSensorHumidity.getHumidity() + "");
		}

		List<SynchronizedData> synchronizedHumidityData = ServiceUtils
				.getSynchronizedDataList();

		for (SynchronizedData sdm : synchronizedHumidityData) {
			if (tempHash.containsKey(sdm.getTime())) {
				sdm.setValue(tempHash.get(sdm.getTime()));
			}
		}

		return synchronizedHumidityData;
	}

	public void AddTemperatureToModel(ModelAndView mv) {
		addDataToModel(mv, "temperatureMinuteData", getTemperatureInRequiredFormat());
	}

	public void AddLightToModel(ModelAndView mv) {
		addDataToModel(mv, "lightMinuteData", getLightInRequiredFormat());
	}

	public void AddHumidityToModel(ModelAndView mv) {
		addDataToModel(mv, "humidityMinuteData", getHumidityInRequiredFormat());
	}

	private void addDataToModel(ModelAndView mv, String key,
			List<SynchronizedData> synchronizedData) {

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		DecimalFormat df = new DecimalFormat("#.##");
		try {
			for (int i = 0; i < synchronizedData.size(); i++) {
				SynchronizedData minutedata = synchronizedData.get(i);
				if (minutedata.getValue() == null) {
					sb.append("null, ");
				} else {
					sb.append(df.format(Double.parseDouble(minutedata
							.getValue())));
				}
			}
		} catch (Exception e) {
			logger.warn("Unable to get data for " + key + " " + e);
		}
		if (sb.length() > 1)
			sb.setLength(sb.length() - 2);
		sb.append("]");
		mv.addObject(key, sb.toString());
	}


}