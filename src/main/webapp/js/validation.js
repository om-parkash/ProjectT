function ValidateLogin(username, password) 
{
	this.validateUser = function(){ // java script function  to validate username and password
		var result = true;
		if((username == null) || (username == "") || (username.length < 4))
		{
		alert ( "Username can't be empty and must contain atleast 4 character." ); //java script warning message for empty or invalid username will be displayed
		result = false;
		} 
		
		if (result && (password == null || password == "" || password.length < 4))
		{
		alert ( "Password can't be empty and must contain atleast 4 character." ); //java script warning message for empty or invalid password will be displayed
		result = false;
		}
		return result;
	};
}
