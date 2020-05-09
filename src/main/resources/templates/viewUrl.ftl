<head>
<style>
            table, th, td {
               border: 1px solid black;
               border-spacing: 0px;
            }
            th, td {
                padding: 10px;
            }
            
            tr td:last-child{
    width:1%;
    white-space:nowrap;
}
        </style>
</head>
<body background="images/pht7.jpg">

<div>

 <h2><a href="/search">Back to Home Page</a></h2>
      
</div>
Time Period
<b>:</b>
<label for="from">From : </label><input id="from" type="datetime-local" value="2018-05-07T00:00" min="2018-05-07T00:00" max="2018-06-14T00:00"/>&nbsp;&nbsp;
&nbsp;&nbsp;
 

<label for="to">To : </label><input id="to" type="datetime-local" value="2018-09-07T00:00" min="2018-09-07T00:00" max="2018-06-14T00:00"/>&nbsp;&nbsp;
&nbsp;&nbsp;

<input type="submit" value="Go">

						
<h2>Results Found:</h2>
<table   >
         <tr>
               <th>Title</th>
               
               <th>Date</th>
               
         </tr>
          <#list listCrawler as urls>
         <tr>
            
            <td><a href="${urls.link}">${urls.title}</a></td>
            <td>${urls.date} </td>
               
            
            
         </tr>
         </#list>
      </table> 
      <br>
      
      </body>