package com.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/updateControl")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class updateControl extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
		

	    public static final String UPLOAD_DIR = "images";
	    public String dbFileName = "";
	    
	    
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(Integer.parseInt(request.getParameter("id"))>0) {
		int id=  Integer.parseInt(request.getParameter("id"));
		 Movie getmovie;
		
		  
	     getmovie=uploadDB.getMovie(id);
	     request.setAttribute("getmovie", getmovie);
		 RequestDispatcher dis = request.getRequestDispatcher("updatemovie.jsp");
		 dis.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
	    int Id = Integer.parseInt(request.getParameter("id"));
		String Name = request.getParameter("name");
		String Link = request.getParameter("link");
		String Language = request.getParameter("language");
		int Year = Integer.parseInt(request.getParameter("year"));
		int Rating = Integer.parseInt(request.getParameter("rating"));
		
		Part part = request.getPart("file");//
        String fileName = extractFileName(part);//file name

       
        String applicationPath = getServletContext().getRealPath("");
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
   
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        String savePath = uploadPath + File.separator + fileName;
     
        String sRootPath = new File(savePath).getAbsolutePath();
    
        part.write(savePath + File.separator);
        File fileSaveDir1 = new File(savePath);
      
        dbFileName = UPLOAD_DIR + File.separator + fileName;
        part.write(savePath + File.separator);
     
		boolean isSuccess;
		
	
		
		isSuccess=uploadDB.updateMovie(Id,Name,Link,Language,dbFileName,savePath,Year,Rating);
		
		if(isSuccess==true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Success Updating');");
			out.println("location='movieupdate?id="+Id+"'");
			out.println("</script>");
			
			
		}else {
			 
			 String error="Not updated Error";
			 Movie getmovie;
		     getmovie=uploadDB.getMovie(Id);
		     request.setAttribute("getmovie", getmovie);
		     request.setAttribute("error", error);
			 RequestDispatcher dis = request.getRequestDispatcher("updatemovie.jsp");
			 dis.forward(request, response);
			
			
		}
		
		
	}
	
	  private String extractFileName(Part part) {//This method will print the file name.
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length() - 1);
	            }
	        }
	        return "";
	    }

}
