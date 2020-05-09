package com.webgeshu.crawlergeshu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.webgeshu.crawlergeshu.model.Crawler;
import com.webgeshu.crawlergeshu.model.PageContent;
import com.webgeshu.crawlergeshu.service.CrawlerService;
import com.webgeshu.crawlergeshu.service.Engine;
import com.webgeshu.crawlergeshu.model.Pivot;

@Controller
public class CrawlerController {
	
	Crawler crawler; 
	@Autowired  
	private CrawlerService crawlerService;
	
	 static List<Pivot> listCrawler = new ArrayList<Pivot>();
	 MongoClient mongoClient = new MongoClient("localhost", 27017);
     MongoDatabase database = mongoClient.getDatabase("loginurl");
     MongoCollection<Document> col = database.getCollection("listCrawler");
     static {
    		
    		listCrawler.add(new Pivot("http://zeenews.india.com/"));
    		listCrawler.add(new Pivot("http://livemint.com/"));
    		listCrawler.add(new Pivot("https://edition.cnn.com/"));
    		listCrawler.add(new Pivot("https://www.bbc.co.uk/news"));
    		listCrawler.add(new Pivot("http://hindustantimes.com/"));
    		//pivots.add(new Pivot("http://hindustantimes.com/"));
    		}
    
	@RequestMapping("/")
	   public ModelAndView forms() {
		 return new ModelAndView("search");
	}
	
	
	 @RequestMapping(value = { "/listUrl" }, method = RequestMethod.GET)                    
	    public  ModelAndView listUrl(Model model, @RequestParam String search) {
		// model.addAttribute("listCrawler", crawlerService.listCrawler(text)));
		 model.addAttribute("listCrawler", crawlerService.listCrawler(search));
	     model.addAttribute("search", search);
		 return new ModelAndView("viewUrl");

	    }
	
	
	@RequestMapping(value = { "/listCrawler" }, method = RequestMethod.GET)                    
    public  ModelAndView listUser() {
	   
	 ModelAndView model = new ModelAndView("viewUrl");
		 model.addObject("listCrawler", crawlerService.listCrawler());
		 return model;

    }
	
	 @RequestMapping(value = "/delete", params = {"id"})  
     public @ResponseBody ModelAndView delete(@RequestParam(value = "id") String id, @ModelAttribute(value="crawler") PageContent crawler,  Model model)
      {
  	 System.out.println("from delete method.."+crawler.getId());

  	 //System.out.println(welcomeService.findUserById(user.getId()));
        crawler = crawlerService.findUserById(id);
   	 
		 System.out.println("from controller delete Method Called");
		 crawlerService.delete(id);
		 return new ModelAndView ("listCrawler");

      }    
	
	@RequestMapping(value = { "/listDb" }, method = RequestMethod.GET)                    
    public  ModelAndView listDb() {
	   
	 ModelAndView model = new ModelAndView("viewDb");
		 model.addObject("listCrawler", crawlerService.listCrawler());
		 return model;

    }
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	   public ModelAndView search(Model model) {
		Crawler enterUrl1 = new Crawler();
        model.addAttribute("listCrawler", enterUrl1);
       
		 System.out.println("the url get method entered is:"+enterUrl1);
		 System.out.println("the url get method id is:"+enterUrl1.getEnterUrl());
		 
		 return new ModelAndView("search");
	 
	}
	
@RequestMapping(value = "/search", method = RequestMethod.POST)
public  ModelAndView search(@ModelAttribute("crawler") @Valid Crawler crawler, ModelMap model) throws Exception {
	 // System.out.println("inside aff "+crawler.getId());

	 System.out.println("the url post method entered is:"+crawler);
	 System.out.println("the url post method id is:"+crawler.getEnterUrl());

	  model.addAttribute("enterUrl", crawler.getEnterUrl());
	 //listCrawler.add(crawler);
	 
	     model.addAttribute("listCrawler", crawlerService.listCrawler(crawler.getEnterUrl()));
	     model.addAttribute("search", crawler.getEnterUrl());
	     
	// Engine engine= new Engine(listCrawler);
	//	List<PageContent> pages= engine.searchSubPivotContent();
		//System.out.println("geshugfd");
/*
		for(PageContent pg :pages) {
			//System.out.println("geshugoyal1234");
            System.out.println(pg.getTitle());
			System.out.println(pg.getLink());
			//System.out.println(pg.getContent());
			System.out.println("-------------------------------------");
			//listCrawler.add(pg);
			//listCrawler.add(new PageContent("getTitle().toString()", "getLink().toString()"));
			 
			
	     crawlerService.add(pg);
		}
	  */
		 System.out.println("the url post method id is:"+crawler.getEnterUrl());

	 return new ModelAndView("viewUrl");
  

}

@RequestMapping(value = "/enter", method = RequestMethod.GET)
public  ModelAndView enter(@ModelAttribute("crawler") @Valid Crawler crawler, ModelMap model) throws Exception {
	 // System.out.println("inside aff "+crawler.getId());

	 System.out.println("the url post method entered is:"+crawler);
	 System.out.println("the url post method id is:"+crawler.getEnterUrl());

	  model.addAttribute("enterUrl", crawler.getEnterUrl());
	  model.addAttribute("listCrawler", crawlerService.listCrawler());
	 //listCrawler.add(crawler);
	 
	   
	     
	 Engine engine= new Engine(listCrawler);
		List<PageContent> pages= engine.searchSubPivotContent();
		//System.out.println("geshugfd");

		for(PageContent pg :pages) {
			//System.out.println("geshugoyal1234");
            System.out.println(pg.getTitle());
			System.out.println(pg.getLink());
			//System.out.println(pg.getContent());
			System.out.println("-------------------------------------");
			//listCrawler.add(pg);
			//listCrawler.add(new PageContent("getTitle().toString()", "getLink().toString()"));
			 
			
	     crawlerService.add(pg);
		}
	  
		 System.out.println("the url post method id is:"+crawler.getEnterUrl());

	 return new ModelAndView("searchResult");
  

}
}

