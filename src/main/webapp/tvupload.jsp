<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
      <%@ page import="com.upload.uploadDB" %>
   
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
            <li><a  href="adminprofile?adminun=<%out.print(session.getAttribute("adminun"));%>">Profile</a></li>
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
                <h2>Upload Tv Series Here</h2>
                <form method="post" action="tvupload" enctype="multipart/form-data">
                    <%String adminun=(String)session.getAttribute("adminun"); %>
                  
                   <input type="text" class="inputBox" name="adminun" hidden="true" value="<%out.print(adminun); %>">
                    <input type="text" placeholder="Tv Series Name" class="inputBox" name="name" required> 
                    <input type="text" placeholder="Tv Series Language" class="inputBox" name="language" required>                                   
                    <input type="file" class="inputBox" name="file" required>
                    <input type="submit" value="Upload Tv Series" class="signUpbBtn" >
                    </form>
                     <center><hr></center><br>
                     <h2>Upload Episodes Here</h2>
                   <form method="post" action="tvupload2" >
                   
                    <select name="nameslist" id="language"  class="inputBox" required>
                  <%List<String> list=uploadDB.displayTvNames();%>
                  <%for(int x=0;x<list.size();x++){
                	    String name=list.get(x);                              %>
              
                     <option value="<%out.print(name); %>"><%out.print(name); %></option>
                    
                    <%} %>
                    </select>
                    
                    <input type="number" placeholder="Tv Series Season" class="inputBox" name="season" required>   
                     <input type="number" placeholder="Tv Series Episode" class="inputBox" name="episode" required>
                       <input type="text" placeholder="Tv Series Link" class="inputBox" name="link" required> 
                     <input type="number" placeholder="Tv Series Year" class="inputBox" name="year" required>  
                     <input type="number" placeholder="Tv Series Rating" class="inputBox" name="rating" required>                                   
                    
                    <input type="submit" value="Upload Episode" class="signUpbBtn" >
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