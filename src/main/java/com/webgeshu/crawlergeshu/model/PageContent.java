package com.webgeshu.crawlergeshu.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
@EntityScan
@Document(collection="listCrawler")
public class PageContent {
	
	@Id
	String id;
	
	
	private String link;
	private String title;
	private String date;
	//private String content;
	
	public PageContent(String link, String title, String date) {
		super();
		
		this.link = link;
		this.title = title;
		this.date= date;
		//this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public PageContent() {}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
/*
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	*/
	
}
