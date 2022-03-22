package com.upload;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class FileUploadServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;
	

    public static final String UPLOAD_DIR = "images";
    public String dbFileName = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        
        String name = request.getParameter("name");
        String link = request.getParameter("link");
        String language = request.getParameter("language");
        int year=Integer.parseInt( request.getParameter("year"));
        int rating=Integer.parseInt( request.getParameter("rating"));
        String adminun=request.getParameter("adminun");

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
     
        
         boolean isAvailable = uploadDB.checkavailability(name);
         
         if(isAvailable==true) {
        	 
        	out.println("<script type='text/javascript'>");
   			out.println("alert('Movie Already Available');");
   			out.println("location='upload.jsp'");
   			out.println("</script>");
        	 
        	 
         }else {
        	 
        	
        	 
        	 boolean isSuccess = uploadDB.uploadmovie(name,link,language,dbFileName,savePath,year,rating,adminun);
        	 if(isSuccess==true) {
        		 
        		out.println("<script type='text/javascript'>");
      			out.println("alert('Successfully Uploaded ');");
      			out.println("location='movieadmin.jsp'");
      			out.println("</script>");
        		 
        	 }else {
        		 
        		 out.println("<script type='text/javascript'>");
     			out.println("alert('Upload Failed ');");
     			out.println("location='upload.jsp'");
     			out.println("</script>");
        		 
        	 }
        	 
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