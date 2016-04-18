<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery Store</title>
</head>
<link rel="stylesheet" type="text/css" href="main.css">

</head>
<body>
	<div class="Page-title">Welcome to Grocery Store</div>
	<div class="desktop-header">
		<ul class="links">
			<li><a href="UserAccount.html">User Account</a></li>
			<li><a onclick="validateAccess()"/>My Account</a></li>
			<li><a href="InventoryManagement.html">Inventory</a></li>
			<li><a href="Billing.html">Billing</a></li>
			<li><a href="about.html">About</a></li>
		</ul>
	</div>
	
	<script type="text/javascript">
function validateAccess() {
	var my_window = window.open("","mywindow", "width=600,height=300");
	my_window.document.write("this is pop up form");
	
	my_window.document.write("<form action= 'ChangePassword' method ='post' >");
	my_window.document.write("Enter Your Password   :");
	my_window.document.write("<input type='password' name='OldPassword'><br>");
    my_window.document.write("'New Password : <input type = 'password' name = 'NewPassword'><br>");
    my_window.document.write("Confirm New Password : <input type = 'password' name = 'ConfirmNewPassword'><br>");
    my_window.document.write("<input type='submit' value='SUBMIT'/>");
    my_window.document.write("<input type='button' value='CLOSE'  onclick='self.close()'/></form");	
    
    popup_window.close ();
}

function closeSelf(){
    // do something

	opener.location.reload(true);
    Validate.close(); 
}

</script>
	
	
	
	
</body>
</html>