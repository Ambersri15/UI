<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
   <script src= "https://code.jquery.com/jquery-1.12.4.min.js"> </script>
     
   <title>Amends</title>
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
  height: 300px;
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

function AAActive() {

document.getElementById("AASubmit").disabled = true;
$("#CR :input").prop("disabled", true);
$("#CC :input").prop("disabled", true);
$("#BCS :input").prop("disabled", true);

}
function CRActive() {

document.getElementById("CRSubmit").disabled = true;
$("#CC :input").prop("disabled", true);
$("#AA :input").prop("disabled", true);
$("#BCS :input").prop("disabled", true);

}

function CCActive() {
	
document.getElementById("CCSubmit").disabled = true;
$("#CR :input").prop("disabled", true);
$("#AA :input").prop("disabled", true);
$("#BCS :input").prop("disabled", true);

}
function BCSActive() {

document.getElementById("BCSSubmit").disabled = true;
$("#CR :input").prop("disabled", true);
$("#AA :input").prop("disabled", true);
$("#CC :input").prop("disabled", true);

}



</script>
</head>
<body>
<header>
<a href = "https://hibu.com/"><img alt="images/HibuLogo" src="images/HibuLogo.png"></a><span style="color:blue;font-size: 35px">Internal Testing Tool</span>

</header>
<section class="parent">

   <section class="child" id="Amend and Add">
   
   <form id="AA" name="Amends" onSubmit="AAActive();return displayMessage('AAdspMsg')" method="post" action="AmendsResponse" >
   
	
	<p>
 <strong style ="font-size: 25px">Step1:</strong> <select name = "actionItem" class="dropDown" id = "ActionItem">
              <option value="Amend and Add" selected >Amend and Add</option>
			  </select>
</p>
	
	<p>
   <div>
   <label for="BusinessID" id = "BusinessText"><strong style ="font-size: 15px">Business Id:</strong>  </label>
   <input type="text" name="businessId" id="businessId" pattern="8[0-9]{9}" placeholder="8000000000" minlength="10" maxlength="10" required>
   </div>
   </p>
   <p>
 <strong>Existing Product:</strong> <select name="existingProduct" id = "ExistingProduct" required>
                   <option value="" selected disabled hidden>Choose Existing Product Name</option>
				   <option value="Smart Site - Standard">Smart Site - Standard</option>
				   <option value="Smart Site - Standard (Spread Billing)">Smart Site - Standard (Spread Billing)</option>
				   <option value="Smart Site - Pro">Smart Site - Pro</option>
				   <option value="Smart Site - Pro (Spread Billing)">Smart Site - Pro (Spread Billing)</option>
				   <option value="Listings Management">Listings Management</option>
				   <option value="Mobile Boost (a la carte)">Mobile Boost (a la carte)</option>
				   <option value="Search (a la carte)">Managed Search</option>
				   <option value="Display (a la carte)">Display</option>
				   <option value="Social (a la carte)">Social</option>
				   <option value="Search - Guaranteed Clicks">Search - Guaranteed Clicks</option>
				   
				<option value="Online Foundation Solution + LR">Online Foundation Solution + LR</option>
				<option value="Foundation + 1 Ad Campaign + Social + LR">Foundation + 1 Ad Campaign + Social + LR</option>
				<option value="Foundation + 1 Ad Campaign + Display + LR">Foundation + 1 Ad Campaign + Display + LR</option>
				<option value="Foundation + 1 Ad Campaign + Search + LR">Foundation + 1 Ad Campaign + Search + LR</option>
				<option value="Foundation + Display & Social + LR">Foundation + Display & Social + LR</option>
				<option value="Foundation + Display & Search - Small + LR">Foundation + Display & Search - Small + LR</option>
				<option value="Foundation + Display & Search - Medium + LR">Foundation + Display & Search - Medium + LR</option>
				<option value="Foundation + Display & Search - Large + LR">Foundation + Display & Search - Large + LR</option>
				<option value="Foundation + Social & Search - Small + LR">Foundation + Social & Search - Small + LR</option>
				<option value="Foundation + Social & Search - Medium + LR">Foundation + Social & Search - Medium + LR</option>
				<option value="Foundation + Social & Search - Large + LR">Foundation + Social & Search - Large + LR</option>
				
			
				<option value="Smart Online Presence + LR">Smart Online Presence + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Social + LR">Smart Presence + 1 Ad Campaign + Social + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Display + LR">Smart Presence + 1 Ad Campaign + Display + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Search + LR">Smart Presence + 1 Ad Campaign + Search + LR</option>
				<option value="Smart Presence + Display & Social + LR">Smart Presence + Display & Social + LR</option>
				<option value="Smart Presence + Display & Search - Small + LR">Smart Presence + Display & Search - Small + LR</option>
				<option value="Smart Presence + Display & Search - Medium + LR">Smart Presence + Display & Search - Medium + LR</option>
				<option value="Smart Presence + Display & Search - Large + LR">Smart Presence + Display & Search - Large + LR</option>
				<option value="Smart Presence + Social & Search - Small + LR">Smart Presence + Social & Search - Small + LR</option>
				<option value="Smart Presence + Social & Search - Medium + LR">Smart Presence + Social & Search - Medium + LR</option>
				<option value="Smart Presence + Social & Search - Large + LR">Smart Presence + Social & Search - Large + LR</option>
				
				<option value="Smart Sync - Small + LR">Smart Sync - Small + LR</option>
				<option value="Smart Sync - Medium + LR">Smart Sync - Medium + LR</option>
				<option value="Smart Sync - Large + LR">Smart Sync - Large + LR</option>
				
				<option value="Synchronized Marketing - Small + LR">Synchronized Marketing - Small + LR</option>
				<option value="Synchronized Marketing - Medium + LR">Synchronized Marketing - Medium + LR</option>
				<option value="Synchronized Marketing - Large + LR">Synchronized Marketing - Large + LR</option>

				<option value="Online Foundation Solution">Online Foundation Solution</option>
				<option value="Foundation + 1 Ad Campaign + Social">Foundation + 1 Ad Campaign + Social</option>
				<option value="Foundation + 1 Ad Campaign + Display">Foundation + 1 Ad Campaign + Display</option>
				<option value="Foundation + Display & Social">Foundation + Display & Social</option>
				<option value="Foundation + Display & Search - Small">Foundation + Display & Search - Small</option>
				<option value="Foundation + Display & Search - Medium">Foundation + Display & Search - Medium</option>
				<option value="Foundation + Display & Search - Large">Foundation + Display & Search - Large</option>
				<option value="Foundation + Social & Search - Small">Foundation + Social & Search - Small</option>
				<option value="Foundation + Social & Search - Medium">Foundation + Social & Search - Medium</option>
				<option value="Foundation + Social & Search - Large">Foundation + Social & Search - Large</option>
				
				<option value="Smart Online Presence">Smart Online Presence</option>
				<option value="Smart Presence + 1 Ad Campaign + Social">Smart Presence + 1 Ad Campaign + Social</option>
				<option value="Smart Presence + 1 Ad Campaign + Display">Smart Presence + 1 Ad Campaign + Display</option>
				<option value="Smart Presence + Display & Social">Smart Presence + Display & Social</option>
				<option value="Smart Presence + Display & Search - Small">Smart Presence + Display & Search - Small</option>
				<option value="Smart Presence + Display & Search - Medium">Smart Presence + Display & Search - Medium</option>
				<option value="Smart Presence + Display & Search - Large">Smart Presence + Display & Search - Large</option>
				<option value="Smart Presence + Social & Search - Small">Smart Presence + Social & Search - Small</option>
				<option value="Smart Presence + Social & Search - Medium">Smart Presence + Social & Search - Medium</option>
				<option value="Smart Presence + Social & Search - Large">Smart Presence + Social & Search - Large</option>
				
				<option value="Smart Sync - Small">Smart Sync - Small</option>
				<option value="Smart Sync - Medium">Smart Sync - Medium</option>
				<option value="Smart Sync - Large">Smart Sync - Large</option>
				
				<option value="Synchronized Marketing - Small">Synchronized Marketing - Small</option>
				<option value="Synchronized Marketing - Medium">Synchronized Marketing - Medium</option>
				<option value="Synchronized Marketing - Large">Synchronized Marketing - Large</option>
				 
				
				
				
			</select>
			</p>
  
   <p>
 <strong>New Product:</strong> <select name="newProductName" id = "NewProductName" required>
                <option value="" selected disabled hidden>Choose New Product Name</option> 
                   <option value="Smart Site - Standard">Smart Site - Standard</option>
				   <option value="Smart Site - Standard (Spread Billing)">Smart Site - Standard (Spread Billing)</option>
				   <option value="Smart Site - Pro">Smart Site - Pro</option>
				   <option value="Smart Site - Pro (Spread Billing)">Smart Site - Pro (Spread Billing)</option>
				   
				   <option value="Listings Management">Listings Management</option>
				   <option value="Reviews">Reviews</option>
				   <option value="Mobile Boost (a la carte)">Mobile Boost (a la carte)</option>
				   
                   			<option value="Search (a la carte)">Managed Search</option>
				   <option value="Display (a la carte)">Display</option>
				   <option value="Social (a la carte)">Social</option>
				   <option value="Search - Guaranteed Clicks">Search - Guaranteed Clicks</option>
				   
			    	<option value="Online Foundation Solution + LR">Online Foundation Solution + LR</option>
				<option value="Foundation + 1 Ad Campaign + Social + LR">Foundation + 1 Ad Campaign + Social + LR</option>
				<option value="Foundation + 1 Ad Campaign + Display + LR">Foundation + 1 Ad Campaign + Display + LR</option>
				<option value="Foundation + 1 Ad Campaign + Search + LR">Foundation + 1 Ad Campaign + Search + LR</option>
				<option value="Foundation + Display & Social + LR">Foundation + Display & Social + LR</option>
				<option value="Foundation + Display & Search - Small + LR">Foundation + Display & Search - Small + LR</option>
				<option value="Foundation + Display & Search - Medium + LR">Foundation + Display & Search - Medium + LR</option>
				<option value="Foundation + Display & Search - Large + LR">Foundation + Display & Search - Large + LR</option>
				<option value="Foundation + Social & Search - Small + LR">Foundation + Social & Search - Small + LR</option>
				<option value="Foundation + Social & Search - Medium + LR">Foundation + Social & Search - Medium + LR</option>
				<option value="Foundation + Social & Search - Large + LR">Foundation + Social & Search - Large + LR</option>
				
			
				<option value="Smart Online Presence + LR">Smart Online Presence + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Social + LR">Smart Presence + 1 Ad Campaign + Social + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Display + LR">Smart Presence + 1 Ad Campaign + Display + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Search + LR">Smart Presence + 1 Ad Campaign + Search + LR</option>
				<option value="Smart Presence + Display & Social + LR">Smart Presence + Display & Social + LR</option>
				<option value="Smart Presence + Display & Search - Small + LR">Smart Presence + Display & Search - Small + LR</option>
				<option value="Smart Presence + Display & Search - Medium + LR">Smart Presence + Display & Search - Medium + LR</option>
				<option value="Smart Presence + Display & Search - Large + LR">Smart Presence + Display & Search - Large + LR</option>
				<option value="Smart Presence + Social & Search - Small + LR">Smart Presence + Social & Search - Small + LR</option>
				<option value="Smart Presence + Social & Search - Medium + LR">Smart Presence + Social & Search - Medium + LR</option>
				<option value="Smart Presence + Social & Search - Large + LR">Smart Presence + Social & Search - Large + LR</option>
				
				<option value="Smart Sync - Small + LR">Smart Sync - Small + LR</option>
				<option value="Smart Sync - Medium + LR">Smart Sync - Medium + LR</option>
				<option value="Smart Sync - Large + LR">Smart Sync - Large + LR</option>
				
				<option value="Synchronized Marketing - Small + LR">Synchronized Marketing - Small + LR</option>
				<option value="Synchronized Marketing - Medium + LR">Synchronized Marketing - Medium + LR</option>
				<option value="Synchronized Marketing - Large + LR">Synchronized Marketing - Large + LR</option>

				<option value="Online Foundation Solution">Online Foundation Solution</option>
				<option value="Foundation + 1 Ad Campaign + Social">Foundation + 1 Ad Campaign + Social</option>
				<option value="Foundation + 1 Ad Campaign + Display">Foundation + 1 Ad Campaign + Display</option>
				<option value="Foundation + Display & Social">Foundation + Display & Social</option>
				<option value="Foundation + Display & Search - Small">Foundation + Display & Search - Small</option>
				<option value="Foundation + Display & Search - Medium">Foundation + Display & Search - Medium</option>
				<option value="Foundation + Display & Search - Large">Foundation + Display & Search - Large</option>
				<option value="Foundation + Social & Search - Small">Foundation + Social & Search - Small</option>
				<option value="Foundation + Social & Search - Medium">Foundation + Social & Search - Medium</option>
				<option value="Foundation + Social & Search - Large">Foundation + Social & Search - Large</option>
				
				<option value="Smart Online Presence">Smart Online Presence</option>
				<option value="Smart Presence + 1 Ad Campaign + Social">Smart Presence + 1 Ad Campaign + Social</option>
				<option value="Smart Presence + 1 Ad Campaign + Display">Smart Presence + 1 Ad Campaign + Display</option>
				<option value="Smart Presence + Display & Social">Smart Presence + Display & Social</option>
				<option value="Smart Presence + Display & Search - Small">Smart Presence + Display & Search - Small</option>
				<option value="Smart Presence + Display & Search - Medium">Smart Presence + Display & Search - Medium</option>
				<option value="Smart Presence + Display & Search - Large">Smart Presence + Display & Search - Large</option>
				<option value="Smart Presence + Social & Search - Small">Smart Presence + Social & Search - Small</option>
				<option value="Smart Presence + Social & Search - Medium">Smart Presence + Social & Search - Medium</option>
				<option value="Smart Presence + Social & Search - Large">Smart Presence + Social & Search - Large</option>
				
				<option value="Smart Sync - Small">Smart Sync - Small</option>
				<option value="Smart Sync - Medium">Smart Sync - Medium</option>
				<option value="Smart Sync - Large">Smart Sync - Large</option>
				
				<option value="Synchronized Marketing - Small">Synchronized Marketing - Small</option>
				<option value="Synchronized Marketing - Medium">Synchronized Marketing - Medium</option>
				<option value="Synchronized Marketing - Large">Synchronized Marketing - Large</option>
			</select>
			</p>
<p>
				<strong>End User Email ID:</strong> <input name="emailId" id="EmailID" type="text"/ required>	
		</p>
    <p>
 	<input id="AASubmit" type = "Submit" value = "Submit" class = "submit"/>
 	<br>
 	</p>
 	
 	<div id = "AAdspMsg" style ="font-size: 18px"></div>
	</form>
	
   </section>

   <section class="child" id="Cancel and Replace">
  
  <form id="CR" name="Amends" onSubmit="CRActive();return displayMessage('CRdspMsg')" method="post" action="AmendsResponse" >
    <p>
 <strong style ="font-size: 25px">Step2:</strong> <select name = "actionItem" class="dropDown" id = "ActionItem">
              <option value="Cancel and Replace" selected >Cancel and Replace</option>
			  </select>
</p>
	
	<p>
   <div>
   <label for="BusinessID" id = "BusinessText"><strong style ="font-size: 15px">Business Id:</strong>  </label>
   <input type="text" name="businessId" id="businessId" pattern="8[0-9]{9}" placeholder="8000000000" minlength="10" maxlength="10" required>
   </div>
   </p>
   
  <p>
 <strong>Existing Product:</strong> <select name="existingProduct" id = "ExistingProduct" required>
                   <option value="" selected disabled hidden>Choose Existing Product Name</option>
				   <option value="Smart Site - Standard">Smart Site - Standard</option>
				   <option value="Smart Site - Standard (Spread Billing)">Smart Site - Standard (Spread Billing)</option>
				   <option value="Smart Site - Pro">Smart Site - Pro</option>
				   <option value="Smart Site - Pro (Spread Billing)">Smart Site - Pro (Spread Billing)</option>
				   <option value="Listings Management">Listings Management</option>
				   <option value="Mobile Boost (a la carte)">Mobile Boost (a la carte)</option>
				   <option value="Search (a la carte)">Managed Search</option>
				   <option value="Display (a la carte)">Display</option>
				   <option value="Social (a la carte)">Social</option>
				   <option value="Search - Guaranteed Clicks">Search - Guaranteed Clicks</option>
				   
				<option value="Online Foundation Solution + LR">Online Foundation Solution + LR</option>
				<option value="Foundation + 1 Ad Campaign + Social + LR">Foundation + 1 Ad Campaign + Social + LR</option>
				<option value="Foundation + 1 Ad Campaign + Display + LR">Foundation + 1 Ad Campaign + Display + LR</option>
				<option value="Foundation + 1 Ad Campaign + Search + LR">Foundation + 1 Ad Campaign + Search + LR</option>
				<option value="Foundation + Display & Social + LR">Foundation + Display & Social + LR</option>
				<option value="Foundation + Display & Search - Small + LR">Foundation + Display & Search - Small + LR</option>
				<option value="Foundation + Display & Search - Medium + LR">Foundation + Display & Search - Medium + LR</option>
				<option value="Foundation + Display & Search - Large + LR">Foundation + Display & Search - Large + LR</option>
				<option value="Foundation + Social & Search - Small + LR">Foundation + Social & Search - Small + LR</option>
				<option value="Foundation + Social & Search - Medium + LR">Foundation + Social & Search - Medium + LR</option>
				<option value="Foundation + Social & Search - Large + LR">Foundation + Social & Search - Large + LR</option>
				
			
				<option value="Smart Online Presence + LR">Smart Online Presence + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Social + LR">Smart Presence + 1 Ad Campaign + Social + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Display + LR">Smart Presence + 1 Ad Campaign + Display + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Search + LR">Smart Presence + 1 Ad Campaign + Search + LR</option>
				<option value="Smart Presence + Display & Social + LR">Smart Presence + Display & Social + LR</option>
				<option value="Smart Presence + Display & Search - Small + LR">Smart Presence + Display & Search - Small + LR</option>
				<option value="Smart Presence + Display & Search - Medium + LR">Smart Presence + Display & Search - Medium + LR</option>
				<option value="Smart Presence + Display & Search - Large + LR">Smart Presence + Display & Search - Large + LR</option>
				<option value="Smart Presence + Social & Search - Small + LR">Smart Presence + Social & Search - Small + LR</option>
				<option value="Smart Presence + Social & Search - Medium + LR">Smart Presence + Social & Search - Medium + LR</option>
				<option value="Smart Presence + Social & Search - Large + LR">Smart Presence + Social & Search - Large + LR</option>
				
				<option value="Smart Sync - Small + LR">Smart Sync - Small + LR</option>
				<option value="Smart Sync - Medium + LR">Smart Sync - Medium + LR</option>
				<option value="Smart Sync - Large + LR">Smart Sync - Large + LR</option>
				
				<option value="Synchronized Marketing - Small + LR">Synchronized Marketing - Small + LR</option>
				<option value="Synchronized Marketing - Medium + LR">Synchronized Marketing - Medium + LR</option>
				<option value="Synchronized Marketing - Large + LR">Synchronized Marketing - Large + LR</option>

				<option value="Online Foundation Solution">Online Foundation Solution</option>
				<option value="Foundation + 1 Ad Campaign + Social">Foundation + 1 Ad Campaign + Social</option>
				<option value="Foundation + 1 Ad Campaign + Display">Foundation + 1 Ad Campaign + Display</option>
				<option value="Foundation + Display & Social">Foundation + Display & Social</option>
				<option value="Foundation + Display & Search - Small">Foundation + Display & Search - Small</option>
				<option value="Foundation + Display & Search - Medium">Foundation + Display & Search - Medium</option>
				<option value="Foundation + Display & Search - Large">Foundation + Display & Search - Large</option>
				<option value="Foundation + Social & Search - Small">Foundation + Social & Search - Small</option>
				<option value="Foundation + Social & Search - Medium">Foundation + Social & Search - Medium</option>
				<option value="Foundation + Social & Search - Large">Foundation + Social & Search - Large</option>
				
				<option value="Smart Online Presence">Smart Online Presence</option>
				<option value="Smart Presence + 1 Ad Campaign + Social">Smart Presence + 1 Ad Campaign + Social</option>
				<option value="Smart Presence + 1 Ad Campaign + Display">Smart Presence + 1 Ad Campaign + Display</option>
				<option value="Smart Presence + Display & Social">Smart Presence + Display & Social</option>
				<option value="Smart Presence + Display & Search - Small">Smart Presence + Display & Search - Small</option>
				<option value="Smart Presence + Display & Search - Medium">Smart Presence + Display & Search - Medium</option>
				<option value="Smart Presence + Display & Search - Large">Smart Presence + Display & Search - Large</option>
				<option value="Smart Presence + Social & Search - Small">Smart Presence + Social & Search - Small</option>
				<option value="Smart Presence + Social & Search - Medium">Smart Presence + Social & Search - Medium</option>
				<option value="Smart Presence + Social & Search - Large">Smart Presence + Social & Search - Large</option>
				
				<option value="Smart Sync - Small">Smart Sync - Small</option>
				<option value="Smart Sync - Medium">Smart Sync - Medium</option>
				<option value="Smart Sync - Large">Smart Sync - Large</option>
				
				<option value="Synchronized Marketing - Small">Synchronized Marketing - Small</option>
				<option value="Synchronized Marketing - Medium">Synchronized Marketing - Medium</option>
				<option value="Synchronized Marketing - Large">Synchronized Marketing - Large</option>
				 
				
				
				
			</select>
			</p>
  
   <p>
 <strong>New Product:</strong> <select name="newProductName" id = "NewProductName" required>
                   <option value="" selected disabled hidden>Choose New Product Name</option> 
                   <option value="Smart Site - Standard">Smart Site - Standard</option>
				   <option value="Smart Site - Standard (Spread Billing)">Smart Site - Standard (Spread Billing)</option>
				   <option value="Smart Site - Pro">Smart Site - Pro</option>
				   <option value="Smart Site - Pro (Spread Billing)">Smart Site - Pro (Spread Billing)</option>
				   
				   <option value="Listings Management">Listings Management</option>
				   <option value="Reviews">Reviews</option>
				   <option value="Mobile Boost (a la carte)">Mobile Boost (a la carte)</option>
				   
                   <option value="Search (a la carte)">Managed Search</option>
				   <option value="Display (a la carte)">Display</option>
				   <option value="Social (a la carte)">Social</option>
				   <option value="Search - Guaranteed Clicks">Search - Guaranteed Clicks</option>
				   
			    <option value="Online Foundation Solution + LR">Online Foundation Solution + LR</option>
				<option value="Foundation + 1 Ad Campaign + Social + LR">Foundation + 1 Ad Campaign + Social + LR</option>
				<option value="Foundation + 1 Ad Campaign + Display + LR">Foundation + 1 Ad Campaign + Display + LR</option>
				<option value="Foundation + 1 Ad Campaign + Search + LR">Foundation + 1 Ad Campaign + Search + LR</option>
				<option value="Foundation + Display & Social + LR">Foundation + Display & Social + LR</option>
				<option value="Foundation + Display & Search - Small + LR">Foundation + Display & Search - Small + LR</option>
				<option value="Foundation + Display & Search - Medium + LR">Foundation + Display & Search - Medium + LR</option>
				<option value="Foundation + Display & Search - Large + LR">Foundation + Display & Search - Large + LR</option>
				<option value="Foundation + Social & Search - Small + LR">Foundation + Social & Search - Small + LR</option>
				<option value="Foundation + Social & Search - Medium + LR">Foundation + Social & Search - Medium + LR</option>
				<option value="Foundation + Social & Search - Large + LR">Foundation + Social & Search - Large + LR</option>
				
			
				<option value="Smart Online Presence + LR">Smart Online Presence + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Social + LR">Smart Presence + 1 Ad Campaign + Social + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Display + LR">Smart Presence + 1 Ad Campaign + Display + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Search + LR">Smart Presence + 1 Ad Campaign + Search + LR</option>
				<option value="Smart Presence + Display & Social + LR">Smart Presence + Display & Social + LR</option>
				<option value="Smart Presence + Display & Search - Small + LR">Smart Presence + Display & Search - Small + LR</option>
				<option value="Smart Presence + Display & Search - Medium + LR">Smart Presence + Display & Search - Medium + LR</option>
				<option value="Smart Presence + Display & Search - Large + LR">Smart Presence + Display & Search - Large + LR</option>
				<option value="Smart Presence + Social & Search - Small + LR">Smart Presence + Social & Search - Small + LR</option>
				<option value="Smart Presence + Social & Search - Medium + LR">Smart Presence + Social & Search - Medium + LR</option>
				<option value="Smart Presence + Social & Search - Large + LR">Smart Presence + Social & Search - Large + LR</option>
				
				<option value="Smart Sync - Small + LR">Smart Sync - Small + LR</option>
				<option value="Smart Sync - Medium + LR">Smart Sync - Medium + LR</option>
				<option value="Smart Sync - Large + LR">Smart Sync - Large + LR</option>
				
				<option value="Synchronized Marketing - Small + LR">Synchronized Marketing - Small + LR</option>
				<option value="Synchronized Marketing - Medium + LR">Synchronized Marketing - Medium + LR</option>
				<option value="Synchronized Marketing - Large + LR">Synchronized Marketing - Large + LR</option>

				<option value="Online Foundation Solution">Online Foundation Solution</option>
				<option value="Foundation + 1 Ad Campaign + Social">Foundation + 1 Ad Campaign + Social</option>
				<option value="Foundation + 1 Ad Campaign + Display">Foundation + 1 Ad Campaign + Display</option>
				<option value="Foundation + Display & Social">Foundation + Display & Social</option>
				<option value="Foundation + Display & Search - Small">Foundation + Display & Search - Small</option>
				<option value="Foundation + Display & Search - Medium">Foundation + Display & Search - Medium</option>
				<option value="Foundation + Display & Search - Large">Foundation + Display & Search - Large</option>
				<option value="Foundation + Social & Search - Small">Foundation + Social & Search - Small</option>
				<option value="Foundation + Social & Search - Medium">Foundation + Social & Search - Medium</option>
				<option value="Foundation + Social & Search - Large">Foundation + Social & Search - Large</option>
				
				<option value="Smart Online Presence">Smart Online Presence</option>
				<option value="Smart Presence + 1 Ad Campaign + Social">Smart Presence + 1 Ad Campaign + Social</option>
				<option value="Smart Presence + 1 Ad Campaign + Display">Smart Presence + 1 Ad Campaign + Display</option>
				<option value="Smart Presence + Display & Social">Smart Presence + Display & Social</option>
				<option value="Smart Presence + Display & Search - Small">Smart Presence + Display & Search - Small</option>
				<option value="Smart Presence + Display & Search - Medium">Smart Presence + Display & Search - Medium</option>
				<option value="Smart Presence + Display & Search - Large">Smart Presence + Display & Search - Large</option>
				<option value="Smart Presence + Social & Search - Small">Smart Presence + Social & Search - Small</option>
				<option value="Smart Presence + Social & Search - Medium">Smart Presence + Social & Search - Medium</option>
				<option value="Smart Presence + Social & Search - Large">Smart Presence + Social & Search - Large</option>
				
				<option value="Smart Sync - Small">Smart Sync - Small</option>
				<option value="Smart Sync - Medium">Smart Sync - Medium</option>
				<option value="Smart Sync - Large">Smart Sync - Large</option>
				
				<option value="Synchronized Marketing - Small">Synchronized Marketing - Small</option>
				<option value="Synchronized Marketing - Medium">Synchronized Marketing - Medium</option>
				<option value="Synchronized Marketing - Large">Synchronized Marketing - Large</option>
			</select>
			</p>	
   <p>
				<strong>End User Email ID:</strong> <input name="emailId" id="EmailID" type="text"/ required>	
		</p>
    <p>
 	<input id="CRSubmit" type = "Submit" value = "Submit" class = "submit"/>
 	</p>
 	
 	<div id = "CRdspMsg" style ="font-size: 18px"></div>
	</form>
  
  
    
    </section>

</section>
<section class="parent">
 <section class="child"  id="Cancels">
  

    <form id="CC" name="Amends" onSubmit="CCActive();return displayMessage('CCdspMsg')" method="post" action="AmendsResponse" >
    <p>
 <strong style ="font-size: 25px">Step3:</strong> <select name = "cancels" class="dropDown" id = "Cancels">
               <option value="" selected >Cancels</option>
			  </select>
</p>
<p>
   <div>
   <label for="BusinessID" id = "BusinessText"><strong style ="font-size: 15px">Business Id:</strong>  </label>
   <input type="text" name="businessId" id="businessId" pattern="8[0-9]{9}" placeholder="8000000000" minlength="10" maxlength="10" required>
   </div>
   </p>	
<p>
 <strong>Cancel Type:</strong> <select name = "actionItem" onchange="return dropDownDisable()" id = "ActionItem">
              <option value="" selected disabled hidden>Choose Your Cancel Type</option>
			  <option value ="Credit">Credit Cancel (Cancel All)</option>
			  <option value ="Customer">Customer Cancel (Cancel All)</option> 
			  </select>
 
</p>


  
<p>
	
    <p>

				<strong>End User Email ID:</strong> <input name="emailId" id="EmailID" type="text"/ required>	
		</p>
    <p>
 	<input id="CCSubmit" type = "Submit" value = "Submit" class = "submit"/>
 	<br>
 	</p>
 	
 	<div id = "CCdspMsg" style ="font-size: 18px"></div>
	</form>
	
   </section>
  <section class="child"  id="BudgetChangeForSolutions" >
  
  <form id="BCS" name="Amends" onSubmit="BCSActive();return displayMessage('BCSdspMsg')" method="post" action="AmendsResponse" >
       <p>
 <strong style ="font-size: 25px">Step4:</strong> <select name = "actionItem" class="dropDown" id = "ActionItem">
              <option value="Budget Change For Solutions" selected >Budget Change For Solutions</option>
			  </select>
</p>
	
	<p>
   <div>
   <label for="BusinessID" id = "BusinessText"><strong style ="font-size: 15px">Business Id:</strong>  </label>
   <input type="text" name="businessId" id="businessId" pattern="8[0-9]{9}" placeholder="8000000000" minlength="10" maxlength="10" required>
   </div>
   </p>
    <p>
 <strong>Existing Product:</strong> <select name="existingProduct" id = "ExistingProduct" required>
                   <option value="" selected disabled hidden>Choose Existing Product Name</option>
				   <option value="Search (a la carte)">Managed Search</option>
				   <option value="Display (a la carte)">Display</option>
				   <option value="Social (a la carte)">Social</option>
				<option value="Foundation + 1 Ad Campaign + Social + LR">Foundation + 1 Ad Campaign + Social + LR</option>
				<option value="Foundation + 1 Ad Campaign + Display + LR">Foundation + 1 Ad Campaign + Display + LR</option>
				<option value="Foundation + 1 Ad Campaign + Search + LR">Foundation + 1 Ad Campaign + Search + LR</option>
				<option value="Foundation + Display & Social + LR">Foundation + Display & Social + LR</option>
				<option value="Foundation + Display & Search - Small + LR">Foundation + Display & Search - Small + LR</option>
				<option value="Foundation + Display & Search - Medium + LR">Foundation + Display & Search - Medium + LR</option>
				<option value="Foundation + Display & Search - Large + LR">Foundation + Display & Search - Large + LR</option>
				<option value="Foundation + Social & Search - Small + LR">Foundation + Social & Search - Small + LR</option>
				<option value="Foundation + Social & Search - Medium + LR">Foundation + Social & Search - Medium + LR</option>
				<option value="Foundation + Social & Search - Large + LR">Foundation + Social & Search - Large + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Social + LR">Smart Presence + 1 Ad Campaign + Social + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Display + LR">Smart Presence + 1 Ad Campaign + Display + LR</option>
				<option value="Smart Presence + 1 Ad Campaign + Search + LR">Smart Presence + 1 Ad Campaign + Search + LR</option>
				<option value="Smart Presence + Display & Social + LR">Smart Presence + Display & Social + LR</option>
				<option value="Smart Presence + Display & Search - Small + LR">Smart Presence + Display & Search - Small + LR</option>
				<option value="Smart Presence + Display & Search - Medium + LR">Smart Presence + Display & Search - Medium + LR</option>
				<option value="Smart Presence + Display & Search - Large + LR">Smart Presence + Display & Search - Large + LR</option>
				<option value="Smart Presence + Social & Search - Small + LR">Smart Presence + Social & Search - Small + LR</option>
				<option value="Smart Presence + Social & Search - Medium + LR">Smart Presence + Social & Search - Medium + LR</option>
				<option value="Smart Presence + Social & Search - Large + LR">Smart Presence + Social & Search - Large + LR</option>				
				<option value="Smart Sync - Small + LR">Smart Sync - Small + LR</option>
				<option value="Smart Sync - Medium + LR">Smart Sync - Medium + LR</option>
				<option value="Smart Sync - Large + LR">Smart Sync - Large + LR</option>
				<option value="Synchronized Marketing - Small + LR">Synchronized Marketing - Small + LR</option>
				<option value="Synchronized Marketing - Medium + LR">Synchronized Marketing - Medium + LR</option>
				<option value="Synchronized Marketing - Large + LR">Synchronized Marketing - Large + LR</option>
				<option value="Foundation + 1 Ad Campaign + Social">Foundation + 1 Ad Campaign + Social</option>
				<option value="Foundation + 1 Ad Campaign + Display">Foundation + 1 Ad Campaign + Display</option>
				<option value="Foundation + Display & Social">Foundation + Display & Social</option>
				<option value="Foundation + Display & Search - Small">Foundation + Display & Search - Small</option>
				<option value="Foundation + Display & Search - Medium">Foundation + Display & Search - Medium</option>
				<option value="Foundation + Display & Search - Large">Foundation + Display & Search - Large</option>
				<option value="Foundation + Social & Search - Small">Foundation + Social & Search - Small</option>
				<option value="Foundation + Social & Search - Medium">Foundation + Social & Search - Medium</option>
				<option value="Foundation + Social & Search - Large">Foundation + Social & Search - Large</option>
				<option value="Smart Presence + 1 Ad Campaign + Social">Smart Presence + 1 Ad Campaign + Social</option>
				<option value="Smart Presence + 1 Ad Campaign + Display">Smart Presence + 1 Ad Campaign + Display</option>
				<option value="Smart Presence + Display & Social">Smart Presence + Display & Social</option>
				<option value="Smart Presence + Display & Search - Small">Smart Presence + Display & Search - Small</option>
				<option value="Smart Presence + Display & Search - Medium">Smart Presence + Display & Search - Medium</option>
				<option value="Smart Presence + Display & Search - Large">Smart Presence + Display & Search - Large</option>
				<option value="Smart Presence + Social & Search - Small">Smart Presence + Social & Search - Small</option>
				<option value="Smart Presence + Social & Search - Medium">Smart Presence + Social & Search - Medium</option>
				<option value="Smart Presence + Social & Search - Large">Smart Presence + Social & Search - Large</option>
				<option value="Smart Sync - Small">Smart Sync - Small</option>
				<option value="Smart Sync - Medium">Smart Sync - Medium</option>
				<option value="Smart Sync - Large">Smart Sync - Large</option>
				<option value="Synchronized Marketing - Small">Synchronized Marketing - Small</option>
				<option value="Synchronized Marketing - Medium">Synchronized Marketing - Medium</option>
				<option value="Synchronized Marketing - Large">Synchronized Marketing - Large</option>
				 
				
				
				
			</select>
			</p>
   
  
		<p>
 <strong>Products(For Budget Change):</strong> <select name="prod" id = "Prod" / required>
                <option value="" selected disabled hidden>Choose Products for Budget change</option> 
                   <option value="Managed Search,Display">Managed Search,Display</option>
				   <option value="Managed Search,Social">Managed Search,Social</option>
				   <option value="Display,Social">Display,Social</option>
				   <option value="Managed Search,Social,Display">Managed Search,Social,Display</option>
				   
				   <option value="Managed Search">Managed Search</option>
				   <option value="Social">Social</option>
				   <option value="Display">Display</option>
				   
                   </select>
			</p>
         <p>
				<strong>New Amount:</strong> <input name="Amounts" id="Amounts" type="text" placeholder="500,300"/ required>
					
		
   
				<strong>End User Email ID:</strong> <input name="emailId" id="EmailID" type="text"/ required>
		</p>
    <p>
 	<input id="BCSSubmit" type = "Submit" value = "Submit" class = "submit"/>
 	</p>
 	
 	<div id = "BCSdspMsg" style ="font-size: 18px"></div>
	</form>
  
   </section>
</section>

<footer>
  <p>Contact Us at @</p>
</footer>

</body>  
</html>