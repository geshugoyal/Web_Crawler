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

     @Autowired  
     Crawler crawler; 
	
     @Autowired  
     private CrawlerService crawlerService;
	
     static List<Pivot> listCrawler = new ArrayList<Pivot>();
     MongoClient mongoClient = new MongoClient("localhost", 27017);
     MongoDatabase database = mongoClient.getDatabase("loginurl");
     MongoCollection<Document> col = database.getCollection("listCrawler");
    
	@RequestMapping("/")
	   public ModelAndView forms() {
		 return new ModelAndView("search");
	}
	
	
	 @RequestMapping(value = { "/listUrl" }, method = RequestMethod.GET)                    
	    public  ModelAndView listUrl(Model model, @RequestParam String search) {
		    
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
	public @ResponseBody ModelAndView delete(@RequestParam(value = "id") String id, @ModelAttribute(value="crawler") PageContent crawler,  Model model){
		log.info("from delete method.."+crawler.getId());
		crawler = crawlerService.findUserById(id);

		log.info("from controller delete Method Called");
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
		log.info("the url get method entered is:"+enterUrl1);
		log.info("the url get method id is:"+enterUrl1.getEnterUrl());

		return new ModelAndView("search");

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public  ModelAndView search(@ModelAttribute("crawler") @Valid Crawler crawler, ModelMap model) throws Exception {

		log.info("the url post method entered is:"+crawler);
		log.info("the url post method id is:"+crawler.getEnterUrl());
		model.addAttribute("enterUrl", crawler.getEnterUrl());
		 //listCrawler.add(crawler);

		model.addAttribute("listCrawler", crawlerService.listCrawler(crawler.getEnterUrl()));
		model.addAttribute("search", crawler.getEnterUrl());  
		log.info("the url post method id is:"+crawler.getEnterUrl());

		return new ModelAndView("viewUrl");
	}

	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public  ModelAndView enter(@ModelAttribute("crawler") @Valid Crawler crawler, ModelMap model) throws Exception {

		 log.info("the url post method entered is:"+crawler);
		 log.info("the url post method id is:"+crawler.getEnterUrl());

		  model.addAttribute("enterUrl", crawler.getEnterUrl());
		  model.addAttribute("listCrawler", crawlerService.listCrawler());
		 //listCrawler.add(crawler);

		 Engine engine= new Engine(listCrawler);
		 List<PageContent> pages= engine.searchSubPivotContent();

		for(PageContent pg :pages) {
			//listCrawler.add(pg);
			//listCrawler.add(new PageContent("getTitle().toString()", "getLink().toString()"));
			crawlerService.add(pg);
		}

		log.info("the url post method id is:"+crawler.getEnterUrl());

		return new ModelAndView("searchResult");

	}
}

