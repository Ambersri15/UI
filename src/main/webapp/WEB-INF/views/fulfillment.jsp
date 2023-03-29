<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
   <script src= "https://code.jquery.com/jquery-1.12.4.min.js"> </script>
     
   <title>Fulfillment</title>
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
  padding: 15px;
  text-align: left;
  font-size: 35px;
  color: white;
}

.parent{
	width: 100%;
	padding: 5px;
	display: flex;
	
}

.child { 
  margin:10px auto;
  padding: 5px;
  border-style: double;
  border-color: blue;
  float: left;
  padding: 10px;
  width: 45%;
  background-color: white;
  height: 260px;
  box-sizing:border-box;
 justify-content:space-between;
  
} 

.button{
  //background-color: #4CAF50; 
  background-color: #ff0081;
  border: none;
  color: white;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

.dropDown{
  //background-color: #4CAF50; 
  background-color: #ff0081;
  appearance: none;
  border: none;
  color: white;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

.submit{
  background-color: lightblue; 
  border: none;
  color: black;
  padding: 4px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

/* Style the footer */
footer {
	 position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: #777;
  padding: 5px;
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

<script type="text/javascript">
function displayMessage(dspMsg)
{
  
  setInterval(function(){
	  var txt = document.getElementById(dspMsg);
	  txt.innerHTML="Please wait for the result to display";
	  txt.style.color="blue";
	  txt.style.display = (txt.style.display=='none'?'':'none');
	  
  },500);
  
  
  return true;
}



function SFActive() {

document.getElementById("SFSubmit").disabled = true;
$("#NSF :input").prop("disabled", true);
$("#DPP :input").prop("disabled", true);
$("#DCQ :input").prop("disabled", true);

}
function NSFActive() {

document.getElementById("NSFSubmit").disabled = true;
$("#DPP :input").prop("disabled", true);
$("#SF :input").prop("disabled", true);
$("#DCQ :input").prop("disabled", true);

}

function DPPActive() {
	
document.getElementById("DPPSubmit").disabled = true;
$("#NSF :input").prop("disabled", true);
$("#SF :input").prop("disabled", true);
$("#DCQ :input").prop("disabled", true);

}
function DCQActive() {

document.getElementById("DCQSubmit").disabled = true;
$("#NSF :input").prop("disabled", true);
$("#SF :input").prop("disabled", true);
$("#DPP :input").prop("disabled", true);

}



</script>
</head>
<body>
<header>
<a href = "https://hibu.com/"><img alt="images/HibuLogo" src="images/HibuLogo.png"></a><span style="color:blue;font-size: 35px">Internal Testing Tool</span>

</header>
<section class="parent">

   <section class="child" id="SAMI Fulfillment">
   
   <form id="SF" name="Fulfillment" onSubmit="SFActive();return displayMessage('SFdspMsg')" method="post" action="FulfillmentResponse" >
   
	
	<p>
 <strong style ="font-size: 25px">Step1:</strong> <select name = "actionItem" class="dropDown" id = "ActionItem">
              <option value="SAMI Fulfillment" selected >SAMI Fulfillment</option>
			  </select>
</p>
	
	<p>
   <div>
   <label for="BusinessID" id = "BusinessText"><strong style ="font-size: 15px">Business Id:</strong>  </label>
   <input type="text" name="businessId" id="businessId" pattern="8[0-9]{9}" placeholder="8000000000" minlength="10" maxlength="10" required>
   </div>
   </p>
<p>
				<strong>End User Email ID:</strong> <input name="emailId" id="EmailID" type="text" required/>	
		</p>
    <p>
 	<input id="SFSubmit" type = "Submit" value = "Submit" class = "submit"/>
 	<br>
 	</p>
 	
 	<div id = "SFdspMsg" style ="font-size: 18px"></div>
	</form>
	
   </section>

   <section class="child" id="Non SAMI Fulfillment">
  
  <form id="NSF" name="Fulfillment" onSubmit="NSFActive();return displayMessage('NSFdspMsg')" method="post" action="FulfillmentResponse" >
    <p>
 <strong style ="font-size: 25px">Step2:</strong> <select name = "actionItem" class="dropDown" id = "ActionItem">
              <option value="Non SAMI Fulfillment" selected >Non-SAMI Fulfillment</option>
			  </select>
</p>
	
	<p>
   <div>
   <label for="Case"><strong style ="font-size: 15px">Case Number:</strong> </label>
   <input type="text" id="CaseNo" name="CaseNo"  style="text-align:left;" pattern="10[0-9]{6}"  placeholder="10123456" minlength="8" maxlength="8" required>
   </div>
   </p>
   
   <p>
 <strong id = "ProductText" style ="font-size: 15px">Product Name:</strong> <select name="newProductName" id = "NewProductName">
 
                   <option value="" selected disabled hidden>Choose Existing Product Name</option>
				   <option value="Website (a la carte)">Website (a la carte)</option>
				   <option value="Online Foundation Solutions">Online Foundation Solutions</option>
				   <option value="Smart Presence Solutions">Smart Presence Solutions</option>
				   <option value="Smart Synchronized Solutions">Smart Synchronized Solutions</option>
				   <option value="Synchronized Marketing Solutions">Synchronized Marketing Solutions</option> 
				   <option value="Online Foundation Solutions + LR">Online Foundation Solutions + LR</option>
				   <option value="Smart Presence Solutions">Smart Presence Solutions + LR</option>
				   <option value="Smart Synchronized Solutions">Smart Synchronized Solutions + LR</option>
				   <option value="Synchronized Marketing Solutions + LR">Synchronized Marketing Solutions + LR</option> 

			</select>
	</p>		
   <p>
				<strong>End User Email ID:</strong> <input name="emailId" id="EmailID" type="text" required/>	
		</p>
    <p>
 	<input id="NSFSubmit" type = "Submit" value = "Submit" class = "submit"/>
 	</p>
 	
 	<div id = "NSFdspMsg" style ="font-size: 18px"></div>
	</form>
  
  
    
    </section>

</section>

<section class="parent">

   <section class="child"  id="Domain Provision and Publish">
   
   <form id="DPP" name="Fulfillment" onSubmit="DPPActive();return displayMessage('DPPdspMsg')" method="post" action="FulfillmentResponse" >
    <p>
 <strong style ="font-size: 25px">Step3:</strong> <select name = "actionItem" class="dropDown" id = "ActionItem">
              <option value="Domain Provision and Publish" selected >Domain Provision and Publish</option>
			  </select>
</p>
	
	<p>
   <div>
   <label for="BusinessID" id = "BusinessText"><strong style ="font-size: 15px">Business Id:</strong>  </label>
   <input type="text" name="businessId" id="businessId" pattern="8[0-9]{9}" placeholder="8000000000" minlength="10" maxlength="10" required>
   </div>
   </p>
  
<p>
				<strong>End User Email ID:</strong> <input name="emailId" id="EmailID" type="text" required/>	
		</p>
    <p>
 	<input id="DPPSubmit" type = "Submit" value = "Submit" class = "submit"/>
 	<br>
 	</p>
 	
 	<div id = "DPPdspMsg" style ="font-size: 18px"></div>
	</form>
	
   </section>

   <section class="child"  id="Assistant RCF Provisioning" >
  
  <form id="DCQ" name="Fulfillment" onSubmit="DCQActive();return displayMessage('DCQdspMsg')" method="post" action="FulfillmentResponse" >
       <p>
 <strong style ="font-size: 25px">Step4:</strong> <select name = "actionItem" class="dropDown" id = "ActionItem">
              <option value="Assistant RCF Provisioning" selected >Assistant RCF Provisioning</option>
			  </select>
</p>
	
	<p>
   <div>
   <label for="Case"><strong style ="font-size: 15px">Case Number:</strong> </label>
   <input type="text" id="CaseNo" name="CaseNo"  style="text-align:left;" pattern="00[0-9]{6}"  placeholder="00123456" minlength="8" maxlength="8" required>
   </div>
   </p>
   
   <p>
 <strong id = "ProductText" style ="font-size: 15px">RCF Type:</strong> <select name="newProductName" id = "NewProductName">
                   <option value="" selected disabled hidden>Choose RCF type</option>
				   <option value="Assistant RCF">Provision RCF from assistant page</option>
				   <option value="Qusetionnnaire RCF">Provision RCF from questionnaire page</option>
				    
				
			</select>
			</p>
   <p>
				<strong>End User Email ID:</strong> <input name="emailId" id="EmailID" type="text" required/>	
		</p>
    <p>
 	<input id="DCQSubmit" type = "Submit" value = "Submit" class = "submit"/>
 	</p>
 	
 	<div id = "DCQdspMsg" style ="font-size: 18px"></div>
	</form>
  
   </section>
   

</section>

<footer>
  <p>Contact Us at @</p>
</footer>

</body>  
</html>