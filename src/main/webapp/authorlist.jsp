<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.upload.Author" %>
  <%@ page import="com.upload.AuthorDB" %>
  
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
    <title>Deflix</title>
</head>

<body>

<% if(session.getAttribute("adminun") == null){
	response.sendRedirect("adminlogin.jsp");
}
%>


<% ArrayList<Author> Author=(ArrayList<Author>)AuthorDB.displayAuthor(); %>
    <!---------------------------Header--------------------------->

    <nav>
        <div class="menuToggle " onclick="toggleMenu();">
        </div>

         <ul class="navigationL">
            <li><a  href="adminhome.jsp">Home</a></li>
            <li><a  href="upload.jsp">Upload</a></li>
            <li><a  href="movieadmin.jsp">Movie List</a></li>
            <li><a  href="addadmin.jsp">Add Admin</a></li>
             <li><a  href="addauthor.jsp">Add Author</a></li>
             <li><a  href="authorlist.jsp">Author List</a></li>
           <li><a  href="contactuslist.jsp">Messages</a></li>
           <li><a  href="admintvserieslist.jsp">TV Series List</a></li>
             <li><a  href="tvupload.jsp">TV Upload</a></li>
           
        </ul>
        <ul class="navigation-R">
            <li><a  href="adminprofile?adminun=<%out.print(session.getAttribute("adminun")); %>">Profile</a></li>
            <li><a class="active" href="adminlogout.jsp">Log Out</a></li>
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
                <h2>Author List</h2>
                <table id="customers">
 <tr>
<th>Username</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>DELETE</th>
    
</tr>  

<% for(int x=0;x<Author.size();x++) {  %>
    <% 
    Author mv = (Author)Author.get(x); 
    %>
 

<tr>

<td><% out.print(mv.getUsername()); %></td>
<td><% out.print(mv.getName()); %></td>
<td><% out.print(mv.getEmail()); %></td>
<td><% out.print(mv.getMobile()); %></td>
<td> <a href="authordelete?id=<%out.print(mv.getUsername()); %>"class="upbtn" onclick="return confirm('Are you sure you want to delete <% out.print(mv.getUsername()); %>')">delete</a></td>
</tr>
    
<% } %>
    
    
    
    

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