
package com.webgeshu.crawlergeshu.service;

import java.util.List;

import com.webgeshu.crawlergeshu.model.Crawler;
import com.webgeshu.crawlergeshu.model.PageContent;



public interface CrawlerService{
	
    public List<PageContent> listCrawler(String text);
    public List<PageContent> listCrawler();
    public PageContent findUserById(String id);
    public void delete(String id);
	
	public PageContent add(PageContent url) throws Exception;
	
		

}
