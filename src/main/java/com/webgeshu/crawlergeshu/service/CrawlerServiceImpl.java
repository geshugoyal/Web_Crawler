package com.webgeshu.crawlergeshu.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webgeshu.crawlergeshu.dao.CrawlerDao;
import com.webgeshu.crawlergeshu.model.Crawler;
import com.webgeshu.crawlergeshu.model.PageContent;

@Service
public class CrawlerServiceImpl implements CrawlerService {
	
	@Autowired
	CrawlerDao crawlerDao;

	public List<PageContent> listCrawler(String text) {
		return crawlerDao.listCrawler(text);
	}
	public List<PageContent> listCrawler(){
		return crawlerDao.listCrawler();
	}
	public PageContent add(PageContent url) throws Exception {
		return crawlerDao.add(url);
	}
	
	public PageContent findUserById(String id) {
		return crawlerDao.findUserById(id);
	}
    public void delete(String id) {
    	crawlerDao.delete(id);
    }

	
}