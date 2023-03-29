<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
   <head>
   <title>Quote Submission</title>
<meta charset="ISO-8859-1">
<style>
footer {
  text-align: center;
  padding: 3px;
  background-color: #ff0081;
  color: white;
}
</style>
<head>
<a href = "https://hibu.com/"><img alt="images/HibuLogo" src="images/HibuLogo.png"></a><span style="color:black;font-size: 35px">Internal Testing Tool</span>
<hr size="7" color="blue">
<!-- <hr size="1" color="#ff0081">
<hr size="1" color="green -->
<script type="text/javascript">
function displayMessage()
{
  
  setInterval(function(){
	  var txt = document.getElementById("dspMsg");
	  txt.innerHTML="Please wait for the result to display";
	  txt.style.color="blue";
	  txt.style.display = (txt.style.display=='none'?'':'none');
	  
  },500);
  
  
  return true;
}
function myFunction() {
document.getElementById("Submit").disabled = true;
//document.getElementById('NewProductName').disabled = true;
}

</script>
</head>
<!-- <body style="background-color:powderblue;" > -->
<body>
<form id="QuoteSubmit" name="Orderplacement" onSubmit="myFunction();displayMessage()"  method="post" action="Response">
<br>
 <p>
 <strong>Action Name:</strong> <select name = "actionItem" id = "ActionItem">
              <option value="Quote Submission" selected disabled >Quote Submission</option>
			  </select>
</p> 
   <p>
 <strong>New Product:</strong> <select name="newProductName" id="NewProductName">
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

				<option value="Online Foundation Solution + LR + Ast">Online Foundation Solution + LR + Ast</option>
				<option value="Foundation + 1 Ad Campaign + Social + LR + Ast">Foundation + 1 Ad Campaign + Social + LR + Ast</option>
				<option value="Foundation + 1 Ad Campaign + Display + LR + Ast">Foundation + 1 Ad Campaign + Display + LR + Ast</option>
				<option value="Foundation + 1 Ad Campaign + Search + LR + Ast">Foundation + 1 Ad Campaign + Search + LR + Ast</option>
				<option value="Foundation + Display & Social + LR + Ast">Foundation + Display & Social + LR + Ast</option>
				<option value="Foundation + Display & Search - Small + LR + Ast">Foundation + Display & Search - Small + LR + Ast</option>
				<option value="Foundation + Display & Search - Medium + LR + Ast">Foundation + Display & Search - Medium + LR + Ast</option>
				<option value="Foundation + Display & Search - Large + LR + Ast">Foundation + Display & Search - Large + LR + Ast</option>
				<option value="Foundation + Social & Search - Small + LR + Ast">Foundation + Social & Search - Small + LR + Ast</option>
				<option value="Foundation + Social & Search - Medium + LR + Ast">Foundation + Social & Search - Medium + LR + Ast</option>
				<option value="Foundation + Social & Search - Large + LR + Ast">Foundation + Social & Search - Large + LR + Ast</option>
				
				<option value="Smart Online Presence + LR + Ast">Smart Online Presence + LR + Ast</option>
		        <option value="Smart Presence + 1 Ad Campaign + Social + LR + Ast">Smart Presence + 1 Ad Campaign + Social + LR + Ast</option>
			<option value="Smart Presence + 1 Ad Campaign + Display + LR + Ast">Smart Presence + 1 Ad Campaign + Display + LR + Ast</option>
			<option value="Smart Presence + 1 Ad Campaign + Search + LR + Ast">Smart Presence + 1 Ad Campaign + Search + LR + Ast</option>
			<option value="Smart Presence + Display & Social + LR + Ast">Smart Presence + Display & Social + LR + Ast</option>
			<option value="Smart Presence + Display & Search - Small + LR + Ast">Smart Presence + Display & Search - Small + LR + Ast</option>
			<option value="Smart Presence + Display & Search - Medium + LR + Ast">Smart Presence + Display & Search - Medium + LR + Ast</option>
			<option value="Smart Presence + Display & Search - Large + LR + Ast">Smart Presence + Display & Search - Large + LR + Ast</option>
			<option value="Smart Presence + Social & Search - Small + LR + Ast">Smart Presence + Social & Search - Small + LR + Ast</option>
			<option value="Smart Presence + Social & Search - Medium + LR + Ast">Smart Presence + Social & Search - Medium + LR + Ast</option>
			<option value="Smart Presence + Social & Search - Large + LR + Ast">Smart Presence + Social & Search - Large + LR + Ast</option>
				
				<option value="Smart Sync - Small + LR + Ast">Smart Sync - Small + LR + Ast</option>
				<option value="Smart Sync - Medium + LR + Ast">Smart Sync - Medium + LR + Ast</option>
				<option value="Smart Sync - Large + LR + Ast">Smart Sync - Large + LR + Ast</option>
				
				<option value="Synchronized Marketing - Small + LR + Ast">Synchronized Marketing - Small + LR + Ast</option>
				<option value="Synchronized Marketing - Medium + LR + Ast">Synchronized Marketing - Medium + LR + Ast</option>
				<option value="Synchronized Marketing - Large + LR + Ast">Synchronized Marketing - Large + LR + Ast</option>


				<option value="Online Foundation Solution + Ast">Online Foundation Solution + Ast</option>
				<option value="Foundation + 1 Ad Campaign + Social + Ast">Foundation + 1 Ad Campaign + Social + Ast</option>
				<option value="Foundation + 1 Ad Campaign + Display + Ast">Foundation + 1 Ad Campaign + Display + Ast</option>
				<option value="Foundation + Display & Social + Ast">Foundation + Display & Social + Ast</option>
				<option value="Foundation + Display & Search - Small + Ast">Foundation + Display & Search - Small + Ast</option>
				<option value="Foundation + Display & Search - Medium + Ast">Foundation + Display & Search - Medium + Ast</option>
				<option value="Foundation + Display & Search - Large + Ast">Foundation + Display & Search - Large + Ast</option>
				<option value="Foundation + Social & Search - Small + Ast">Foundation + Social & Search - Small + Ast</option>
				<option value="Foundation + Social & Search - Medium + Ast">Foundation + Social & Search - Medium + Ast</option>
				<option value="Foundation + Social & Search - Large + Ast">Foundation + Social & Search - Large + Ast</option>
				
				<option value="Smart Online Presence + Ast">Smart Online Presence + Ast</option>
				<option value="Smart Presence + 1 Ad Campaign + Social + Ast">Smart Presence + 1 Ad Campaign + Social + Ast</option>
				<option value="Smart Presence + 1 Ad Campaign + Display + Ast">Smart Presence + 1 Ad Campaign + Display +Ast</option>
				<option value="Smart Presence + Display & Social + Ast">Smart Presence + Display & Social + Ast</option>
				<option value="Smart Presence + Display & Search - Small + Ast">Smart Presence + Display & Search - Small + Ast</option>
				<option value="Smart Presence + Display & Search - Medium + Ast">Smart Presence + Display & Search - Medium + Ast</option>
				<option value="Smart Presence + Display & Search - Large + Ast">Smart Presence + Display & Search - Large + Ast</option>
				<option value="Smart Presence + Social & Search - Small + Ast">Smart Presence + Social & Search - Small + Ast</option>
				<option value="Smart Presence + Social & Search - Medium + Ast">Smart Presence + Social & Search - Medium + Ast</option>
				<option value="Smart Presence + Social & Search - Large + Ast">Smart Presence + Social & Search - Large + Ast</option>
				
				<option value="Smart Sync - Small + Ast">Smart Sync - Small + Ast</option>
				<option value="Smart Sync - Medium + Ast">Smart Sync - Medium + Ast</option>
				<option value="Smart Sync - Large + Ast">Smart Sync - Large + Ast</option>
				
				<option value="Synchronized Marketing - Small + Ast">Synchronized Marketing - Small + Ast</option>
				<option value="Synchronized Marketing - Medium + Ast">Synchronized Marketing - Medium + Ast</option>
				<option value="Synchronized Marketing - Large + Ast">Synchronized Marketing - Large + Ast</option>

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
				<strong>Sales Rep Type:</strong> <select name="salesRepType" id="SalesRepType">
						     <option value="" selected disabled hidden>Choose Sales Rep Type</option>
						     <option value="TSales">TSales</option>
						     <option value="Premise">Premise</option>
				</select>		
		</p>
		<p>
				<strong>End User Email ID:</strong> <input name="emailId" id="EmailID" type="text" required/>	
		</p>
			
    <p>
 	<input id="Submit" type = "Submit" value = "Submit"/>
 	<br>
 	</p>
 	
 	<div id = "dspMsg" style ="font-size: 25px"></div>
	
	
</form>

</body>
  
</html>