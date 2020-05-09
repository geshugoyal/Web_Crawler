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
<h2>Results Found:</h2>
<table   >
         <tr>
               <th>Title</th>
               <th>Link</th>
               <th>Delete</th>
               <th>Date</th>
               
         </tr>
          <#list listCrawler as urls>
         <tr>
            <td>${urls.title} </td>
            <td><a href="${urls.link}">${urls.link}</a></td>
             <td><h4><a href="/delete?id=${urls.id}">Delete</a></h4></td>
            <td>${urls.date} </td>
            
               
            
            
         </tr>
         </#list>
      </table> 
      <br>
      
      </body>