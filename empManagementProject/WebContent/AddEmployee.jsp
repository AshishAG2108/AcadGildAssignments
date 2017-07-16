<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 3 MVC - HelloWorld Index Page</title>
</head>
<body>

	<center>
		<!-- <h2>Hello World</h2>
		<h3>
			<a href="saveEmployee?username=Ashish&password=temp">Click Here</a>
		</h3> -->
		
		  <h1>Add New Employee</h1>  
       <form method="post" action="saveEmployee">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><input name="name" /></td> 
          <!-- <td><form:input path="name"  /></td>   -->
         </tr>    
         <tr>    
          <td>Salary :</td>  
          <td><input name="salary" /></td>   
          <!-- <td><form:input path="salary" /></td>   -->
         </tr>   
         <tr>    
          <td>Employee ID :</td>  
          <td><input name="empId" /></td>   
          <!-- <td><form:input path="empId" /></td>  --> 
         </tr>   
         <tr>    
          <td>Employee Location :</td>    
          <td><input name="empLocation" /></td> 
          <!-- <td><form:input path="empLocation" /></td> -->  
         </tr>  
         <tr>     
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form>   
		
	</center>
</body>
</html>