<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.upload.Author" %>
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

<% Author a=(Author)request.getAttribute("author"); %>

 <div class="Sign_UpContainer">
        
        <div class="signUp_Box">
            <div class="box">
            
<form action="authorupdate" method="post">
-Username-<input type="text" class="inputBox"  name="username"  value="<%out.print(a.getUsername()); %>" readonly >
-Password-<input type="password" class="inputBox"  name="password" value="<%out.print(a.getPassword()); %>"  required >
-Name-<input type="text" class="inputBox"  name="name" value="<%out.print(a.getName()); %>" required >
-Email-<input type="email" class="inputBox"  name="email" value="<%out.print(a.getEmail()); %>" required >
-Mobile-<input type="text" class="inputBox"  name="mobile" value="<%out.print(a.getMobile()); %>" required >
<input type="submit" value="Update" class="signUpbBtn">


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