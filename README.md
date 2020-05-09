# Web_Crawler
Title of the Project:  News Web Crawler 

# Purpose
The purpose of this document is to specify the requirements and preview some elements of the analysis model of the program News Web Crawler. This web crawler intendeds for functionalities:
1.	Identify the content of websites
2.	Determine how websites link to each other

We can provide search results based on the content, and identify "importance" by seeing which sites are linked to the most for the content being searched for. 
The scope of website crawling is firstly limited to what is publically accessible - some sites will require credentials to access all content, and what is technically accessible. 
Also, if content is presented via javascript, then this may not be crawled, as crawling engines often do not execute scripts on the sites they access.A Web crawler is an Internet bot which helps in Web indexing. They crawl one page at a time through a website until all pages have been indexed. Web crawlers help in collecting information about a website and the links related to them, and also help in validating the HTML code and hyperlinks

News Web Crawler is an application which consists of: 
                         
a.	Crawler Main Application:
It is a class named as CrawlerApplication.java and this program is the main program which is responsible for the successful run of the application. Also, it uses annotation @SpringBootApplication to enable configuration and component scan.

b.	Crawler Controller:
It is a class named as CrawlerController.java and Controller is responsible for controlling the flow of the application execution. When we make a request 

(means request a page) to application, a controller is responsible for returning the response to that request. The controller can perform one or more actions. The controller action can return different types of action results to a particular request. The Controller is responsible for controlling the application logic and acts as the coordinator between the View and the Model. The Controller receives an input from the users via the View, then processes the user's data with the help of Model and passes the results back to the View.

c.	Crawler Model:
It is named as CrawlerModel.java and is responsible for managing the data of the application. It responds to the request from the view and it also responds to instructions from the controller to update itself. It represents the underlying, logical structure of data in a software application and the high-level class associated with it. This object model does not contain any information about the user interface.

d.	Crawler Service:
The service layer is there to provide logic to operate on the data sent to and from the DAO and the client.  By convention we mark service class by @Service annotation. Services should call DAOs and perform business operations. Typically transactions demarcation is performed on service layer to span several DAO calls. Then we have the class CrawlerServiceImplementation.java which implements the interface CrawlerService.java class.

e.	Crawler DAO:
 DAO class is marked  with  annotation @Repository. DAO performs raw database operations and translate them to some higher level constructs (objects, collections). Finally DAO abstracts business logic from persistence details  and DAO provides data to services. We have the class CrawlerDaoImplementation.java which implements the interface CrawlerDao.java class.

f.	Crawler Views:
The Views are responsible for rendering the model data and in general it generates HTML output that the client's browser can interpret. A defined service method can return a String, which contains the name of the view to be used to render the model.


# Requirement Specification:

•	Spring Tool Suite (IDE)

•	SpringBoot (RAD Platform)

•	Java (implementation by Spring MVC)

•	MongoDb (databse used)

•	Freemarker Template (for designing frontend)

# Project Scope
An application that automatically traverses the Web might work as follows: 
• A base set of known working hyperlinks is used as a starting point. 
• Each of these hyperlinks is placed in a queue. 

The Web crawler will endeavor to retrieve each of the pages in this queue. Because the Web is a hyperlinked environment, each of these pages will in all likelihood have links to various other pages on various other Web servers.
 • The Web crawler retrieves the first page in its queue and adds an entry for this page in the index. 
• Then, it adds each of the hyperlinks that exist on that Web page to the queue. 
• It repeats this process of retrieval and recording for each page in its queue.

The Advantages of Web Crawling

The major advantages of web scraping services are explained in the following points:

•	Inexpensive – Web scraping services provide an essential service at a low cost. It is paramount that data is collected back from websites and analyzed so that the internet functions regularly. Web scraping services do the job in an efficient and budget friendly manner.
•	Easy to implement – Once a web scraping services deploys the proper mechanism to extract data, you are assured that you are not only getting data from a single page but from the entire domain. This means that with just a onetime investment, a lot of data can be collected.
•	Low maintenance and speed– One aspect that is often overlooked when installing new services is the maintenance cost. Long term maintenance costs can cause the project budget to spiral out of control. Thankfully, web scraping technologies need very little to no maintenance over a long period. Another characteristic that must also be mentioned is the speed with which web scraping services do their job. A job that could take a person week is finished in a matter of hours.
•	Accuracy – The web scraping services are not only fast, they are accurate too. Simple errors in data extraction can cause major mistakes later on. Accurate extraction of any type of data is thus very important .In websites that deal in pricing data, sales prices, real estate numbers or any kind of financial data, the accuracy is extremely important.

The Disadvantages of Web Crawling:

The major disadvantages of web scraping services are explained in the following points.
•	Difficult to analyze – For anybody who is not an expert, the scraping processes are confusing to understand. Although this is not a major problem, but some errors could be fixed faster if it was easier to understand for more software developers.
•	Data analysis – The data that has been extracted will first need to be treated so that they can be easily understood. In certain cases, this might take a long time and a lot of energy to complete.
•	Time – It is common for new data extraction applications to take some time in the beginning as the software often has a learning curve. Sometimes web scraping services take time to become familiar with the core application and need to adjust to the scrapping language. This means that such services can take some days before they are up and running at full speed.
•	Speed and protection policies – Most web scrapping services are slower than API calls and another problem is the websites that do not allow screen scrapping. In such cases web scrapping services are rendered useless. Also, if the developer of the website decides to introduce some changes in the code, the scrapping service might stop working.


# Software Specification:
1.	Spring Tool Suite-3.9.1.RELEASE (IDE)
2.	Java SpringBoot 2.0 (RAD Platform)
3.	HTML / CSS / JavaScript (for User Interface)
4.  MongoDB (NoSQL Database)

# Description Of Project

The News Web Crawler is a combination of various categories of features involved that can be performed on the various news websites url and the created list of urls.

 Basic Features of the News Web Crawler:

1.)	Add new urls to the data base by creating a pivot list of the defined urls.
Here I have used only a few number of news websites url. Thye can be added or deleted as by the users choice. 

2.)	Read the searched urls from the matched searched word from the database.

3.)	Update the news list by the http GET request for adding the new urls to the database, that can be done from the side of admin only.

4.)	Delete if there is any not required url found and  that can not be done by the user accessing the application.

# STEP BY WORKING OF APPLICATION

1.)	When the user opens the application onto the browser, the front activity displayed consists of the search_activity.ftl.

2.)	From this activity the user searches the keyword or the headline by entering the keyword to searched into the search box.

3.)	Then the server receives a POST request to get the required display page.

4.)	This will display the required urls, stored into database. The headlines of the urls having a match of the search keyword is displayed.

5.)	The display page consists of the headline’s hyperlink and the date and time on which it was stored into the database.

6.)	This activity also contains a search option between the required dates for the searched keyword. Then it displays the results matched only between the entered date.

7.)	The user can click of the desired url, then it will give back the clicked website’s original page and the user can have a better read about the headline.

8.)	This was the flow for the end user side.

9.)	Now, to have the required websites entry to the database. The admin sends a http POST request to have the list of websites to be parsed. The the crawler controller handles the flow of the application. By using the required endpoint the database is updated.
            
10.)	Then after updating the database it will have the documents saved into it. Also, the collection of the database can be backuped for the more abstraction and future loss secure purposes by restoring it back.
 
11.)	Then the page displayed on to the browser to the admin will be as shown in the figure below. It will have a hyperlink to view the enteries into the database and a hyperlink to either move back back to the user displayed home page.

12.)	To view the database the user clicks on View Database Url, and this will drop the admin to the Page displayed for the urls saved in database. Also, these urls displayed have the headlines and the date of saving displayed along with it. Moreover, including to it these urls have the access by the admin to be manually deleted if at some point of time it is required.
