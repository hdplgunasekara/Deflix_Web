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
<title>Article</title>
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
        
        <div class="signUp_Box">
            <div class="box">
                <h2>Article List</h2>
                
               


<% ArrayList<article> Article=(ArrayList<article>)articleDB_util.getArticleDetails(); %>

                <table id="customers">

 <tr>
<th>ID</th>
<th>NAME</th>
<th>CATEGORY </th>
<th>VIEW </th>
</tr>  
<% for(int x=0;x<Article.size();x++) {  %>
    <% 
    article mv = (article)Article.get(x); 
    %>
 <tr>
<td><% out.print(mv.getID()); %></td>
<td><% out.print(mv.getName()); %></td>
<td><% out.print(mv.getCategory()); %></td>
<td><a href="d?article_ID=<% out.print(mv.getID());%>"   class="upbtn3">VIEW</a></td>


<% } %>
</tr>
</table>
          
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