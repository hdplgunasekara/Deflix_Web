<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.upload.Admin" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="style/style.css">
    <title>Deflix</title>
</head>
<body>
<% 
if(session.getAttribute("adminun") == null){
	
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

<% Admin a=(Admin)request.getAttribute("admin"); %>

 <div class="Sign_UpContainer">
        
        <div class="signUp_Box">
            <div class="box">
            
<form action="adminupdate" method="post">
-Username-<input type="text" class="inputBox"  name="username"  value="<%out.print(a.getUsername()); %>" readonly >
-Password-<input type="password" class="inputBox"  name="password" value="<%out.print(a.getPassword()); %>"  required >
-Name-<input type="text" class="inputBox"  name="name" value="<%out.print(a.getName()); %>" required >
-Email-<input type="email" class="inputBox"  name="email" value="<%out.print(a.getEmail()); %>" required >
-Mobile-<input type="text" class="inputBox"  name="mobile" value="<%out.print(a.getMobile()); %>" required >
<input type="submit" value="Update" class="signUpbBtn">
<a href="admindelete?adminun=<%out.print(a.getUsername()); %>"><button type="button" class="signUpbBtn" onclick="return confirm('Are you sure you want to delete <%out.print(a.getUsername());%>')">Delete</button></a>

</form>

</div>
</div>
</div>

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