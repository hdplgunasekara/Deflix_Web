<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.author.article" %>
  <%@ page import="com.author.articleDB_util" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
 <style>
    .upbtn:link, .upbtn:visited {
     background-color: #f44336;
     height: 50px;
     color: white;
     padding: 14px 14px;
     text-align: center;
     text-padding: 5px 5px;
     text-decoration: none;
     display: inline-block;
}

	.upbtn:hover, .upbtn:active {
  	background-color: red;
  	}
  	
  	  .upbtn2:link, .upbtn2:visited {
     background-color: #4D79E1;
     height: 50px;
     color: white;
     padding: 14px 14px;
     text-align: center;
     text-padding: 5px 5px;
     text-decoration: none;
     display: inline-block;
}

	.upbtn2:hover, .upbtn2:active {
  	background-color: blue;
  	}
  	
  	  .upbtn3:link, .upbtn3:visited {
     background-color: #84F568;
     height: 50px;
     color: white;
     padding: 14px 14px;
     text-align: center;
     text-padding: 5px 5px;
     text-decoration: none;
     display: inline-block;
}

	.upbtn3:hover, .upbtn3:active {
  	background-color: green;
  	}
  
    </style>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./style/style.css">
   
<meta charset="ISO-8859-1">
<title>Article details</title>
<style type="text/css">
		body{
			font-family: Hind SemiBold;
		}
	
		table, th, td {
  			border: 1px solid black;
		}
	</style>
</head>
<body>

<% if(session.getAttribute("authorun") == null){
	response.sendRedirect("authorlogin.jsp");
}
%>
<%article a=(article)request.getAttribute("articleDetails"); %>





    <!---------------------------Header--------------------------->

    <nav>
        <div class="menuToggle " onclick="toggleMenu();">
        </div>

         <ul class="navigationL">
            <li><a  href="authorhome.jsp">Home</a></li>
               <li><a  href="Add_article_UI.jsp">Add Article</a></li>
                <li><a  href="Article.jsp">Article List</a></li>
           
        </ul>
        <ul class="navigation-R">
            <li><a  href="authorprofile?authorun=<%out.print(session.getAttribute("authorun")); %>">Profile</a></li>
            <li><a class="active" href="authorlogout.jsp">Log Out</a></li>
        </ul>
    </nav>
    <div class="logo_searchBar">
            <div class="col-lg-6 ">
                 <a href=""><img class="logo" src="./image/logo.png" width="250px" height="50px"></a>
            </div>
    </div>

    

    <!---------------------------Header--------------------------->
 <!---------------------------signup--------------------------->
  
    
    <div class="Sign_UpContainer">
        
        <div class="signUp_Box1">
            <div class="box">
                
          

<table id="customers">

	

	
	<tr>
		<td>Article ID</td>
		<td><% out.print(a.getID());%></td>
	</tr>
	<tr>
		<td> Name</td>
		<td><%out.print(a.getName()); %></td>
	</tr>
	<tr>
		<td>Rating</td>
		<td><%out.print(a.getRating()); %></td>
	</tr>
	<tr>
		<td>Category</td>
		<td><%out.print(a.getCategory()); %></td>
	</tr>
	<tr>
		<td>Description</td>
		<td><%out.print(a.getDescription());%></td>
	</tr>

	
	</table>
	
	
	<center>
	
	<a href="updatearticledetails?ID=<% out.print(a.getID());%>">
	<input type="button" name="update" value="Update Article" class="signUpbBtn" >
	<br><br>
	</a>
	
	
	
		<a href="deletearticledetails?ID=<%out.print(a.getID());%>" onclick="return confirm('Are you sure you want to delete')">
	<input type="button" name="delete" value="Delete Article" class="signUpbBtn" >
	<br><br>
	</a>
	</center>
	
	
	
	
	
	
	
	
	

	
	
	
	 
            </div>
        </div>
        
    </div>
  <!---------------------------signup--------------------------->
    <script type="text/javascript">
        function toggleMenu()
		{
            const menuToggle = document.querySelector('.menuToggle');
            const navigationL = document.querySelector('.navigationL');
            menuToggle.classList.toggle('active');
            navigationL.classList.toggle('active');
        }
         
  

	
    </script>
  
                
</body>
</html>