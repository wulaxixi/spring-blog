package me.woemler.springblog.models;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Progress")
public class Progress {
	
	private String key;
	
	
	private Integer progress;
	
	@PersistenceConstructor
	public Progress(String key,Integer progress) {
		this.key = key;
		this.progress = progress;
	}
	
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public Integer getProgress() {
		return progress;
	}


	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	
}
