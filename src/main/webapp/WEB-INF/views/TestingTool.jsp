<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
   <head>
   <title>Hibu-QA-Testing Tool</title>
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
}

function dropDownDisable(){
	var Action = document.getElementById("ActionItem").value;
	var amendAdd = "Amend and Add";
	var cancelandreplace = "Cancel and Replace";
	var creditcancel = "Credit";
	var customercancel = "Customer";
	var quotesubmission = "Quote Submission";
	var fulfillment = "Fulfillment";
	
	if(Action.localeCompare(creditcancel) == 0){
		
		document.getElementById('ExistingProduct').disabled = true;
		document.getElementById('NewProductName').disabled = true;
		document.getElementById('QuoteNo').disabled = true;
		    document.getElementById('businessId').disabled = false;
	}
	if(Action.localeCompare(customercancel) == 0){
		
		document.getElementById('ExistingProduct').disabled = true;
		document.getElementById('NewProductName').disabled = true;
		document.getElementById('QuoteNo').disabled = true;
		    document.getElementById('businessId').disabled = false;
	}
	
	if(Action.localeCompare(cancelandreplace) == 0){
		//window.location.reload(); // Refreshing a page
		document.getElementById('QuoteNo').disabled = true;
		    document.getElementById('ExistingProduct').disabled = false;
		    document.getElementById('NewProductName').disabled = false;
		    document.getElementById('businessId').disabled = false;
		
	}	
	if(Action.localeCompare(amendAdd) == 0){
		
	document.getElementById('QuoteNo').disabled = true;
	    document.getElementById('ExistingProduct').disabled = false;
		document.getElementById('NewProductName').disabled = false;
		document.getElementById('businessId').disabled = false;
	}	
	if(Action.localeCompare(quotesubmission) == 0){
		
	document.getElementById('QuoteNo').disabled = true;
	document.getElementById('ExistingProduct').disabled = true;
	document.getElementById('businessId').disabled = true;
	    document.getElementById('NewProductName').disabled = false;
	}	
	if(Action.localeCompare(fulfillment) == 0){
		/*setTimeout(function() {
      document.location = "/next/page/to/go/to.jsp";
  }, 1000);*/ // <-- this is the Wait time in milliseconds
		
	document.getElementById('ExistingProduct').disabled = true;
	document.getElementById('NewProductName').disabled = true;
	    document.getElementById('businessId').disabled = false;
		document.getElementById('QuoteNo').disabled = true;
	}	
	 return true;
}

</script>
</head>
<!-- <body style="background-color:powderblue;" > -->
<body>
<form:form name="Orderplacement" onSubmit="myFunction();return displayMessage()" method="post" action="ResultPage">
<br>
<p>
 <strong>Action Name:</strong> <select name = "actionItem" onchange="return dropDownDisable()" id = "ActionItem">
              <option value="" selected disabled hidden>Choose Your Action</option>
			  <option value = "Quote Submission">Quote Submission</option>
			  <option value = "Fulfillment">Fulfillment</option>
              <option value = "Amend and Add">Amend and Add</option>
			  <option value = "Cancel and Replace">Cancel and Replace</option>
			  <option value = "Customer">Customer Cancel (Cancel All)</option>
			  <option value = "Credit">Credit Cancel (Cancel All)</option>
			  </select>
 
</p>
<p>
<div>
<label for="BusinessID"><strong>Business Id:</strong>  </label>
<input type="text" name="businessId" id="businessId" pattern="8[0-9]{9}" placeholder="8000000000" minlength="10" maxlength="10" required>
</div>
</p>
<p>
<div>
<label for="Quote"><strong>Quote Number:</strong> </label>
<input type="text" id="QuoteNo" name="quoteID"  style="text-align:left;" pattern="Q-[0-9]{5}"  placeholder="Q-11111" minlength="7" maxlength="7" required>
</div>
</p>
<p>
 <strong>Existing Product:</strong> <select name="existingProduct" id = "ExistingProduct">
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
				   
				
				<option value="Foundation + Display & Social + LR">Foundation + Display & Social + LR</option>
				<option value="Foundation + Display & Search - Small + LR">Foundation + Display & Search - Small + LR</option>
				<option value="Foundation + Display & Search - Medium + LR">Foundation + Display & Search - Medium + LR</option>
				<option value="Foundation + Display & Search - Large + LR">Foundation + Display & Search - Large + LR</option>
				<option value="Foundation + Social & Search - Small + LR">Foundation + Social & Search - Small + LR</option>
				<option value="Foundation + Social & Search - Medium + LR">Foundation + Social & Search - Medium + LR</option>
				<option value="Foundation + Social & Search - Large + LR">Foundation + Social & Search - Large + LR</option>
				
			
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
				
				<option value="Foundation + Display & Social">Foundation + Display & Social</option>
				<option value="Foundation + Display & Search - Small">Foundation + Display & Search - Small</option>
				<option value="Foundation + Display & Search - Medium">Foundation + Display & Search - Medium</option>
				<option value="Foundation + Display & Search - Large">Foundation + Display & Search - Large</option>
				<option value="Foundation + Social & Search - Small">Foundation + Social & Search - Small</option>
				<option value="Foundation + Social & Search - Medium">Foundation + Social & Search - Medium</option>
				<option value="Foundation + Social & Search - Large">Foundation + Social & Search - Large</option>
				
			
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
 <strong>New Product:</strong> <select name="newProductName" id = "NewProductName">
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
				   
			    <option value="Foundation + Display & Social + LR">Foundation + Display & Social + LR</option>
				<option value="Foundation + Display & Search - Small + LR">Foundation + Display & Search - Small + LR</option>
				<option value="Foundation + Display & Search - Medium + LR">Foundation + Display & Search - Medium + LR</option>
				<option value="Foundation + Display & Search - Large + LR">Foundation + Display & Search - Large + LR</option>
				<option value="Foundation + Social & Search - Small + LR">Foundation + Social & Search - Small + LR</option>
				<option value="Foundation + Social & Search - Medium + LR">Foundation + Social & Search - Medium + LR</option>
				<option value="Foundation + Social & Search - Large + LR">Foundation + Social & Search - Large + LR</option>
				
			
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
				
				
				
				<option value="Foundation + Display & Social">Foundation + Display & Social</option>
				<option value="Foundation + Display & Search - Small">Foundation + Display & Search - Small</option>
				<option value="Foundation + Display & Search - Medium">Foundation + Display & Search - Medium</option>
				<option value="Foundation + Display & Search - Large">Foundation + Display & Search - Large</option>
				<option value="Foundation + Social & Search - Small">Foundation + Social & Search - Small</option>
				<option value="Foundation + Social & Search - Medium">Foundation + Social & Search - Medium</option>
				<option value="Foundation + Social & Search - Large">Foundation + Social & Search - Large</option>
				
			
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
 	<input id="Submit" type = "Submit" value = "Submit"/>
 	<br>
 	</p>
 	
 	<b><h3>Instructions: </h3></b>
 	<b> 1)Fulfillment Action: </b> Make sure you have done RCF Provision for "Search" Product.<br>
 	<b> 2)Cancel and Replace Action: </b> Make sure Amend Block Date and Term End Dates are set to Past Date for all Budget lines.<br>
 	<b> 3)Add Product Action: </b> Make sure you are not having two listings in a account.<br>
 	&nbsp;&nbsp; Example1:If you are having any Package or Website you can add any SAMI product.<br>
 	&nbsp;&nbsp; Example2:If you are having any SAMI you can add any product.<br>
 	<b> 4)Cancel All Action: </b> Make sure the products are available in the account to Cancel.<br>
 	
 	<div id = "dspMsg" style ="font-size: 25px"></div>
	
	
</form:form>

</body>
  
</html>