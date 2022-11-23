<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
	<h2>Create new Lead</h2>
	<form action = "saveLead" method = "post">
		<pre>
		FirstName<input type = "text"  name="firstName"/>
		LastName<input type = "text"  name="lastName"/>
		Mobile<input type = "text"  name="mobile"/>
		Email<input type = "text"  name="email"/>
		<input type = "submit"  value ="save" />
		</pre>
	</form>
	${msg}
</body>
</html>