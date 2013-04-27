<%@ page language="java" contentType="text/html;" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"

<html>

	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Codecenter Candidate Demo input form</title>
	
	</head>

	<body>
	
		<h2>Candidate Demo input form</h2>
		
		<c:if test="${resultMessage != null}">
			<p>
	   			<c:out value="${resultMessage}" />
				
			</p>
		</c:if>
		
		<form method="POST" action="/CodecenterCandidateDemo/inputform">
			<table>
				<tr>
					<td>First name</td>
					<td><input type="text" name="firstName" maxlength="30"></td>
					<td>
						<c:if test="${firstNameInvalid != null}">
   							<c:out value="${firstNameInvalid}" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Last name</td>
					<td><input type="text" name="lastName" maxlength="30"></td>
					<td>
						<c:if test="${lastNameInvalid != null}">
   							<c:out value="${lastNameInvalid}" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>
						<input type="radio" name="gender" value="male" checked>Male 
						<input type="radio" name="gender" value="female">Female
					</td>
					<td>
						<c:if test="${genderInvalid != null}">
   							<c:out value="${genderInvalid}" />
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Why are you applying to this job?</td>
					<td><textarea name="description" rows="10" cols="50" maxlength="2000"></textarea></td>
					<td>
						<c:if test="${descriptionInvalid != null}">
   							<c:out value="${descriptionInvalid}" />
						</c:if>
					</td>
				</tr>
			</table>
			<br>
			<input type=submit value="Submit">
		</form>
	
	</body>



</html>