<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="style/style.css">
     <link rel="stylesheet" href="stylee.css">
    <title>Deflix</title>
</head>

<body>

   

    <!---------------------------signup--------------------------->
  
    
    <div>
        
        <div class="signUp_Box">
            <div class="box">
                <h2>Author Login</h2>
                <form method="post" action="author" >
                    <input type="text" placeholder="Author Username" class="inputBox" name="adminun" required>
                    <input type="password" placeholder="Author Passwrod" class="inputBox" name="adminpw" required>
                     <a href="#" style="color:red;text-align:center;text-decoration:none;">Forgot password?</a><br>
                    
                    <input type="submit" value="Login" class="signUpbBtn" >
                    </form>
                <center><hr></center>
              <a href="index.jsp" style="color:blue;text-align:center;text-decoration:none;">Back To Site</a>
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