package repository;

import com.web.model.TiSensorTemperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.model.MappingInstantiationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by uday on 4/27/16.
 */
@Repository("TiSensorRepositoryImpl")
public class TiSensorRepositoryImpl {
    private static final Logger logger = LoggerFactory.getLogger
            (TiSensorRepositoryImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;

    public List<TiSensorTemperature> getTemperatures(String userId, String date){
        List<TiSensorTemperature> tiSensorTemperatures = null;
        try {
            tiSensorTemperatures = mongoTemplate.find(
                    new Query().addCriteria(Criteria.where("userId").is(userId)
                            .andOperator(Criteria.where("date").is(date))),
                    TiSensorTemperature.class, "tiSensorTemperature");
        }catch (MappingInstantiationException e){
            logger.info("unable to get data "+e);
        }
        return tiSensorTemperatures;
    }
}
