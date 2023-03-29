<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Fulfillment Result Page</title>
   </head>

   <body>
      
      
      <table>
        
         <tr>
            <td>Action : </td>
            <td>${actionItem} was Successful.</td>
         </tr>
         
          <tr>
         
            <td>BusinessID/CaseNo :</td>
            <td>${businessId}</td>
         </tr>
        
         <tr>
         
              <td> Zephyr Card No : <a href=${executionURLData}>${tcmNumber}</a></td> 
              
         </tr>
   
      </table> 
     
      <br> <br>
      <b>
      <a href = "http://uatkopqaapp01.corp.ybusa.net:8080/demo/home">Click here to be redirected to the Home Page</a>
  </b>
   </body>
   
</html>