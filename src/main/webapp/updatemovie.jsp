<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.upload.Movie" %>
   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="style/style.css">
    <title>Deflix</title>
</head>

<body>

<% if(session.getAttribute("adminun") == null){
	response.sendRedirect("adminlogin.jsp");
}

%>


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

    <!---------------------------updateform--------------------------->
    
 <% Movie movie=(Movie)request.getAttribute("getmovie"); %>
<% String error=" "; %>
<%  error=(String)request.getAttribute("error"); %>
  
    
    <div class="Sign_UpContainer2">
        
        <div class="signUp_Box">
            <div class="box">
                <h2>Update Here</h2>
                <form action="movieupdate" method="post" enctype="multipart/form-data">
                <% if(error!=null){ %>
		<h4 style="color:Red;"><% out.print(error);} %></h4><br>
	  Movie Id  <input type="number" class="inputBox" name="id" value="<% out.print(movie.getId()); %>" readonly><br><br>
      Movie Name <input type="text" class="inputBox" name="name" value="<% out.print(movie.getName()); %>"  ><br>
	  Movie Link <input type="text" class="inputBox" name="link" value="<% out.print(movie.getLink()); %>"  ><br>
	  Movie Year <input type="text" class="inputBox" name="year" value="<% out.print(movie.getYear()); %>"  ><br>
	  Movie Rating <input type="text" class="inputBox" name="rating" value="<% out.print(movie.getRating()); %>"  ><br>
	 
	  Movie Language  <select name="language" id="language"  class="inputBox" >
  				        <option value="tamil">Tamil</option>
 				        <option value="hindi">Hindi</option>
					    <option value="telugu">Telugu</option>
						<option value="sinhala">Sinhala</option>
						<option value="english" >English</option>
						<option value="malayalam">Malayalam</option>
						<option value="language not selected" selected>Select Language</option>
					</select>
		<p>previously selected language : <%
		
		 out.print(movie.getLanguage());
		%></p>
	 
	  <img src="<% out.print(movie.getFilename()); %>" alt="Movie Thumbnail" width="200" height="250"><br>
	  
	  Movie Thumbnail <input type="file" name="file" class="inputBox"   required  ><br>
		
		
		<input type="submit" name="submit" value="Update" class="signUpbBtn" >
		</form>
                <center><hr></center>
              
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