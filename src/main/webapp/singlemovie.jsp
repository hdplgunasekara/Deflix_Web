<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.upload.Movie" %>
  <%@ page import="com.upload.uploadDB" %>
  
<!DOCTYPE html>
<html lang="en">

<head>
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

<% Movie movie=(Movie)request.getAttribute("getmovie"); %>

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
            <li><<a  href="adminprofile?adminun=<%out.print(session.getAttribute("adminun")); %>">Profile</a></li>
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
  
    
    <div class="Sign_UpContainer2">
        
        <div class="signUp_Box">
            <div class="box">
                <h2>ID- <% out.print(movie.getId()); %></h2>
                <table id="customers">
                <th><center>Movie Name</center></th>
                <tr>
                <td>
                <% out.print(movie.getName()); %>
                </td>
                </tr>

                </table>
                
                 <table id="customers">
                <th><center>Movie Year</center></th>
                <tr>
                <td>
                <%                
                 out.print(movie.getYear());
                %>
                </td>
                </tr>
                </table>  
                
                  <table id="customers">
                <th><center>Movie Rating</center></th>
                <tr>
                <td>
                <%                
                 out.print(movie.getRating());
                %>
                </td>
                </tr>
                </table>  
                
                <table id="customers">
                <th><center>Thumbnail</center></th>
                <tr>
                <td>
                <img src="<% out.print(movie.getFilename()); %>" alt="thumbnail" width="200" height="250">
              
                </td>
                </tr>
                  

                </table>
                
                <table id="customers">
                <th><center>Movie Language</center></th>
                <tr>
                <td>
                <%                
                 out.print(movie.getLanguage());
                %>
                </td>
                </tr>
                </table>           
                
                <table id="customers">
                <th><center>Movie Link</center></th>
                <tr>
                <td>
                <% out.print(movie.getLink()); %>
                </td>
                </tr>
                </table>
                <a href="delete?id=<%out.print(movie.getId()); %>"><button type="button" class="signUpbBtn" onclick="return confirm('Are you sure you want to delete <%out.print(movie.getName());%>')">Delete</button></a>
                <a href="movieupdate?id=<%out.print(movie.getId());  %>"><button type="button" class="signUpbBtn">Update</button></a>
              
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