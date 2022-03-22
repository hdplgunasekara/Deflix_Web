<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page import="com.author.article" %>
<!DOCTYPE html>
<html>
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
<title>update article</title>
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
<%
article art=(article)request.getAttribute("articleDetails");
int ID= art.getID();
String name= art.getName();
int rating= art.getRating();
String category= art.getCategory();
String description= art.getDescription();

%>





<form action="update"  method="post">
ID : <input type="text" name="ID" value="<%=ID %>" class="inputBox" readonly><br>
    Name        : <input type="text" name="name" class="inputBox" value="<%=name %>"  required ><br>
    Rating      : <input type="text" name="rating" class="inputBox" value="<%=rating %>" required><br>
Category    : <input type="text" name ="category" class="inputBox" value="<%=category %>" required>
               <br>
<br>
Description : <textarea class="inputBox" style=" height: 200px" name="description" required> <%= description %></textarea> <br>
<input type="submit" name="submit"  value="Update Article" class="signUpbBtn"> <br>


</form>

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