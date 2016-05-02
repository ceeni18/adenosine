package repository;

import com.web.model.Recommendations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by uday on 4/26/16.
 */
@Repository("RecommendationsRepository")
public class RecommendationsRepository {
    private static final Logger logger = LoggerFactory.getLogger
            (RecommendationsRepository.class);

    @Autowired
    MongoTemplate mongoOperation;

    public Recommendations getRecommendations(String userId, String
            date){
        Recommendations recommendations = null;
        try {
            recommendations = mongoOperation.findOne(
                    new Query().addCriteria(Criteria.where("userId").is(userId)
                            .andOperator(Criteria.where("date").is(date))),
                    Recommendations.class, "recommendations");
        } catch (Exception e) {
            logger.error("unable to get recommendations from DB " + e.getMessage());
        }
        if(recommendations != null && recommendations.getTopics() != null){
            logger.debug("Recommendations retrieved from db for user " +
                    ""+userId+" and " +
                    "date: "+ date + " are " +recommendations.getTopics().toString());
        }
        return recommendations;
    }

    public void saveRecommendations(Recommendations recommendations){
        mongoOperation.save(recommendations);
    }
}
