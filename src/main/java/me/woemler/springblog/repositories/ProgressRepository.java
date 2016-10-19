
package me.woemler.springblog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.woemler.springblog.models.Progress;

/**
 * @author woemler
 */

public interface ProgressRepository extends MongoRepository<Progress, String> {
	
}
