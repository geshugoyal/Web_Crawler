package com.webgeshu.crawlergeshu.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EntityScan
@Document(collection="listCrawler")
public class Crawler {
	
	@Id
	String id;
	

	String enterUrl;
	
	public Crawler(String enterUrl) {
		super();
		this.enterUrl = enterUrl;
		
	}

	public Crawler() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getEnterUrl() {
		return enterUrl;
	}

	public void setEnterUrl(String enterUrl) {
		this.enterUrl = enterUrl;
	}

}
