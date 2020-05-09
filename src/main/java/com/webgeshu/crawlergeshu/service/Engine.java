package com.webgeshu.crawlergeshu.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webgeshu.crawlergeshu.model.PageContent;
import com.webgeshu.crawlergeshu.model.Pivot;

public class Engine {
	
	private List<Pivot> pivotList;

	public Engine(List<Pivot> pivotList) {
		this.pivotList = pivotList;
	}
	
	public List<Pivot> searchSubPivot(){
		List<Pivot> urls= new ArrayList<>();
		
		for(Pivot p: this.pivotList) {
			//System.out.println("geshu sdxcfgvbhnj");

			Document doc;
			
			try {
				//System.out.println("geshu jhgf");

				doc= Jsoup.connect(p.getPivot()).get();
				Elements links= doc.select("a[href]");
				for(Element link : links) {
					//System.out.println(link.attr("href"));
					urls.add(new Pivot(link.attr("href")));
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return urls;
	}
	
	public List<PageContent> searchSubPivotContent(){
		 List<PageContent> pages= new ArrayList<>();
		 //System.out.println("geshu dfgbh 1234");
		 List<Pivot> pivots= this.searchSubPivot();
		 //System.out.println("geshu mnhyhju");
		
		 for(Pivot p: pivots) {
				//System.out.println("geshu dfgbh");

			 Document doc;
				
				try {
					//System.out.println("geshu lkjhgfv");

					doc= Jsoup.connect(p.getPivot()).get();
					String title=doc.title();
					String content= doc.body().text();
					 Date date = new Date();
					 DateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
				        df.setTimeZone(TimeZone.getTimeZone("GMT"));
					pages.add(new PageContent(p.getPivot(),title,df.format(date.getTime())));
					
					}
				catch(IllegalArgumentException e){
					
				}
                
				catch(IOException e) {
					e.printStackTrace();
				}
		 }
		 return pages;
}

	public List<Pivot> getPivotList() {
		return pivotList;
	}
	
	

}
