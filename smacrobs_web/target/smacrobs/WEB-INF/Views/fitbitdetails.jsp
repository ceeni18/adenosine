<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Refresh" content="5;url=index.jsp">
<title>Fitbit Details</title>
</head>
<body>
	<center>
		<h2>Fitbit Data:</h2>
		<h2>
			${message} ${sleepDetails.sleepMinutes}
		</h2>
		
		<p>Name: ${userProfile.fullName}</p>
		<p>Gender: ${userProfile.gender}</p>
		<p>Age: ${userProfile.age}</p>
		<p>DOB: ${userProfile.dateOfBirth}</p>
		<img src=${userProfile.avatar} alt="profilepic"></img>
		<p>Height: ${userProfile.height}</p>
	</center>
</body>
</html>