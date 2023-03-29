<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>ResultPage</title>
   </head>

   <body>
      
      
      <table>
         <tr>
            <td>New Plan Name : </td>
            <td>${newProductName}</td>
         </tr>
         <tr>
            <td>Action : </td>
            <td>Quote Submit</td>
         </tr>
         <tr>
         
            <td>BusinessID :</td>
            <td>${businessId}</td>
         </tr>
         
                  <tr>
         
            <td>BusinessAccountName :</td>
            
            <td>  <a href=${accountURL}>${accountName}</a></td>
         
         
         </tr>
         
                                   <tr>
         

         
           <tr>
         
         <td> Zephyr Card No : <a href=${executionURLData}>${tcmNumber}</a></td> </tr>
         

      </table> 
      <br> <br>
      <b>
      <a href = "http://UATKOPQAAPP02.corp.ybusa.net:8080/demo/home">Click here to be redirected to the Home Page</a>
  </b>
   </body>
   
</html>