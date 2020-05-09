/*
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawlerTest {
	
	
		
		public static void main(String[] args) throws IOException {
			
			String address="https://failover-www.livemint.com/htarchive/1";
			Document pod = Jsoup.connect(address).ignoreContentType(true).get();
			URL pagelocation= new URL(address);
			Scanner in= new Scanner(pagelocation.openStream());
			
			while(in.hasNext()) {
				String line= in.next();
				if((line.contains("href=\"http://")) || line.contains("href=\"/")) {
				int from= line.indexOf("\"");
				int to= line.lastIndexOf("\"");
				System.out.println(line.substring(from + 1,  to));
				}
				
			}				}
		}
*/