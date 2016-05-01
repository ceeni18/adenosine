package service;

import com.web.model.SynchronizedData;
import com.web.model.TiSensorTemperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TiSensorRepositoryImpl;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by uday on 4/27/16.
 */

@Service("TiSensorService")
public class TiSensorService {
    @Autowired
    TiSensorRepositoryImpl tiSensorRepository;

    private String userId;
    private String todayDate;

    public void setSessionVariables(HttpSession session){
        this.userId = session.getAttribute("userId").toString();
        this.todayDate = session.getAttribute("todayDate").toString();
    }

    public List<TiSensorTemperature> getTemperaturesFromDB(){
        List<TiSensorTemperature> tiSensorTemperatures =
                tiSensorRepository.getTemperatures(userId, todayDate);
        return tiSensorTemperatures;
    }

    public List<SynchronizedData> getTemperatureInRequiredFormat(){

        List<TiSensorTemperature> temperatures = getTemperaturesFromDB();
        HashMap<String, String> tempHash = new HashMap<String, String>();

        for(int i=0; i<temperatures.size(); i++){
            TiSensorTemperature tiSensorTemperature = temperatures.get(i);
            tempHash.put(tiSensorTemperature.getTimestamp()+"",
                    tiSensorTemperature.getTemperature()+"");
        }

        List<SynchronizedData> synchronizedTemperatureData = ServiceUtils
                .getSynchronizedDataList();

        for(SynchronizedData sdm: synchronizedTemperatureData){
            if(tempHash.containsKey(sdm.getTime())){
                sdm.setValue(tempHash.get(sdm.getTime()));
            }
        }

        return synchronizedTemperatureData;
    }
}