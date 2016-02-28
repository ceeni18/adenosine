<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fitbit Details</title>

<script type="text/javascript">
	function redirectFunc() {
		alert("in redirect func");
		//window.open("http://https://www.fitbit.com/logout");
		window.open("http://localhost:8081/smacrobs");
	}
</script>
</head>
<body>
	<div align="right">
		<a href='https://www.fitbit.com/logout' onclick="redirectFunc()">Logout</a>
	</div>
	<center>
		<h1>Fitbit Data</h1>

		<h2>User Details</h2>
		<p>Name: ${userProfile.fullName}</p>
		<p>Gender: ${userProfile.gender}</p>
		<p>Age: ${userProfile.age} years</p>
		<p>DOB: ${userProfile.dateOfBirth}</p>
		<img src=${userProfile.avatar } alt="profilepic"></img>

		<h2>Sleep Data</h2>
		<p>Sleep Log ID: ${sleepDetails.logId}</p>
		<p>Sleep Efficiency: ${sleepDetails.efficiency} %</p>
		<p>Sleep Duration: ${sleepDetails.duration} ms</p>
		<p>Awake Count: ${sleepDetails.awakeCount}</p>
		<p>Restless Count: ${sleepDetails.restlessCount}</p>
		<p>Main Sleep: ${sleepDetails.isMainSleep}</p>

		<h2>Minute by Minute Sleep Data</h2>
		<table>
			<c:forEach var="data" items="${sleepDetails.dataMap}">
				<tr>
					<td><c:out value="${data.key}" /></td>
					<td><c:out value="${data.value}" /></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
