package me.woemler.springblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import me.woemler.springblog.models.Progress;
import me.woemler.springblog.repositories.ProgressRepository;

@Service
public class AsyncServiceImpl implements AsyncService {
	
	@Autowired
	private CalculateService calculateService;
	@Autowired
	private ProgressRepository progressRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	@Async("taskExecutor")
	public void asyncMethod(String cacheKey) throws Exception {
		calculateService.executePlus(cacheKey);
	}

	@Override
	public Object getProcess(String cacheKey) throws Exception {
		
		Criteria criteria = new Criteria();
		criteria.and("key").is(cacheKey);
		Query query = Query.query(criteria );
		Progress p = mongoTemplate.findOne(query, Progress.class);
		if(p==null)return "0";
		return p.getProgress();
	}

	@Override
	public void clearCache(String cacheKey) throws Exception {
		// TODO Auto-generated method stub

	}

}
