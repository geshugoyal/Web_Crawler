package com.webgeshu.crawlergeshu.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.webgeshu.crawlergeshu.model.Crawler;
import com.webgeshu.crawlergeshu.model.PageContent;

@Service("crawlerService")
@Transactional
public class CrawlerDaoImpl implements CrawlerDao{
	Mongo mongo= new Mongo("localhost",27017);
	DB db= mongo.getDB("loginurl");
	DBCollection collection= db.getCollection("listCrawler");
	private static final String COLLECTION_NAME = "listCrawler";
	
	@Autowired(required=true)
	 private MongoTemplate mongoTemplate;
	
	
	 
	 public List<PageContent> listCrawler(String title) {
			
		// TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingPhrase("title").matchingPhrase(String.valueOf(title));
			System.out.println("From UserDao Implementation of listUser.."+title);
			return mongoTemplate.find(Query.query(new Criteria()
                   .orOperator(Criteria.where("title").regex(title, "i"),
                              Criteria.where("link").regex(title, "i"))
                   ), PageContent.class);
			//return mongoTemplate.findAll(PageContent.class, COLLECTION_NAME);
        //return mongoTemplate.find(criteria,PageContent.class, COLLECTION_NAME);
			
		}
	 
	 public List<PageContent> listCrawler() {
			
			
			System.out.println("From UserDao123456 Implementation of listUser..");
			return mongoTemplate.findAll(PageContent.class, COLLECTION_NAME);

			//return mongoTemplate.findAll(Welcome.class);
		}
	 
	 public PageContent findUserById(String id) {
  	   // Query query = new Query();
 		   //query.addCriteria(Criteria.where("id").is("user.getId().toString()"));
         //return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)) , Welcome.class, id);
  	   Query query = new Query();
         query.addCriteria(Criteria.where("id").is(id));
         PageContent user = mongoTemplate.findOne(query, PageContent.class);
 		   System.out.println("From UserDao Afterr Implementation of finduserbyid method.."+user.getLink());

         return user;
  	   
	}
	

	
	public void delete(String id) {
		
		Query query = new Query();
      query.addCriteria(Criteria.where("id").is(id));
      PageContent account = mongoTemplate.findOne(query, PageContent.class);
 	 System.out.println("from delete method.."+account.getLink());

      mongoTemplate.remove(account);
	}

	 
	public PageContent add(PageContent url) throws Exception{
	   // String url = "http://zeenews.india.com/hindi";
		
		System.out.println("from crawler service enterUrl");
        if (urlExist(url.getLink())) {  
            System.out.println("from existing method part add method");

			return null;
			
        }
        if(url.getId() != null && url.getId() != ""){
			   
			   DBObject query1 = new BasicDBObject();
			         query1.put("id", url.getId());
			         DBObject query = new BasicDBObject();
			   query.put("id", url.getId());
			  query.put("link", url.getLink());
			  query.put("title", url.getTitle());
			  query.put("date", url.getDate());
			         
			        ((DBCollection) mongoTemplate.getDb().getCollection("listCrawler")).update(query1, query);
			     }else{
			         
			    	    
		                System.out.println("from else part add method");

		                url.setId(UUID.randomUUID().toString());
			    	    mongoTemplate.save(url);
			    	    return url;
			     }
		return url;
	            }
	
	 private boolean urlExist(String enterUrl) {
		    Query query = new Query();
	        query.addCriteria(Criteria.where("link").is(enterUrl));
	        Crawler user = mongoTemplate.findOne(query, Crawler.class);
	        if (user != null) {
	            return true;
	        }
	        return false;
	 }	
	 
	

}
