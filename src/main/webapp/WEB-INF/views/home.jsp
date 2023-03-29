<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
   <title>Hibu QA Home</title>
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #ccc;
  padding: 30px;
  text-align: left;
  font-size: 35px;
  color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 30%;
  height: 450px; /* only for demonstration, should be removed */
  background: powderblue;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #f1f1f1;
  height: 450px;
}


section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style>
</head>
<body>
<header>
<a href = "https://hibu.com/"><img alt="images/HibuLogo" src="images/HibuLogo.png"></a><span style="color:blue;font-size: 35px">Internal Testing Tool</span>

</header>

<section>
 <nav>
     <ul>
       <li><a href="http://UATKOPQAAPP02.corp.ybusa.net:8080/demo/quotesubmission" style="color:#ff0081;text-decoration: none;">Quote Submission</a></li>
	   <br>
      <li><a href="http://UATKOPQAAPP02.corp.ybusa.net:8080/demo/fulfillment" style="color:#ff0081;text-decoration: none;">Fulfillment</a></li>
	  <br>
      <li><a href="http://UATKOPQAAPP02.corp.ybusa.net:8080/demo/amends" style="color:#ff0081;text-decoration: none;">Amends</a></li>
   
    </ul>
  </nav> 
  
  
  <article>
    <h1 style="color:green">HIBU Description</h1>
    This is a User Interface to HIBU QA Automation Framework. The purpose of this testing page is to bring our test cases to forefront, for our Business and Development teams to use it. 
<br><br>Tool will help users with:<br><br>

* Quote Submissions<br><br>
* SAMI Fulfillment<br><br>
* Non-SAMI Fulfillment<br><br>
* Domain Provisioning<br><br>
* Website Publishing<br><br>
* Questionnaire<br><br>
* Cancel a solution and Replace with a Solution or alacate<br><br>
* Add Product to existing Solutions or alacarte products<br><br>
  </article>
</section>

<footer>
  <p>Contact Us at @</p>
</footer>

</body>  
</html>