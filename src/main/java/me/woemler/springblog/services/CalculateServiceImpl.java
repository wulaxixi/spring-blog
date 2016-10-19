package me.woemler.springblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import me.woemler.springblog.models.Progress;
import me.woemler.springblog.repositories.ProgressRepository;

/**
 * @author PC
 *
 */
@Service
public class CalculateServiceImpl implements CalculateService {
	
	@Autowired
	private ProgressRepository progressRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void executePlus(String key) {
		int currIndex = 0;
		
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currIndex ++;
//			Progress p = null;//progressRepository.findOne();
			Criteria criteria = new Criteria();
			criteria.and("key").is(key);
			Query query = Query.query(criteria );
//			List<Progress> ps = mongoTemplate.find(query, Progress.class);
//			if(ps != null && ps.size()>0){
//				p = ps.get(0);
//				p.setProgress(currIndex);
//			}else p = new Progress(key,currIndex);
			Update update = new Update();
			update.set(key,currIndex);
			mongoTemplate.upsert(query, update , Progress.class);
//			progressRepository.save(p);
		}

	}

}
