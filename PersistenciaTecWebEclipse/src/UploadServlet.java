// Import required java libraries
import java.io.*;
import java.util.*;
 
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.multipart.MultipartFile;

public class UploadServlet extends HttpServlet {
   
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 3000 * 1024;
   private int maxMemSize = 4 * 1024;
   private File file ;
   private String dadosPessoal_id;
   private FotosDoUsuario fotosDoUsuario;

   public void init( ){
      // Get the file location where it would be stored.
      filePath = 
             getServletContext().getInitParameter("file-upload"); 
      //System.out.println("oi");
   }
   public void service (HttpServletRequest request, 
               HttpServletResponse response)
              throws ServletException, java.io.IOException {
	   
       DAO dao = new DAO();
       FotosDoUsuario fotosDoUsuario = new FotosDoUsuario();
       /*JSONObject jsonObject;
       JSONParser parser = new JSONParser();
       
       try{
    	   jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
    	   System.out.println(request.getParameter("json"));
    	   //fotosDoUsuario.setDadosPessoal_id((String) jsonObject.get("dadosPessoal_id"));
       } catch(org.json.simple.parser.ParseException e){
    	   e.printStackTrace();
       }
	   */fotosDoUsuario.setDadosPessoal_id("1");
       //System.out.println(request.getParameter("json"));
      // Check that we have a file upload request
      isMultipart = ServletFileUpload.isMultipartContent(request);
      response.setContentType("text/html");
      java.io.PrintWriter out = response.getWriter( );
      if( !isMultipart ){
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
         out.println("<p>No file uploaded</p>"); 
         out.println("</body>");
         out.println("</html>");
         return;
      }
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("C:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );
      
      try{ 
      // Parse the request to get file items.
      List fileItems = upload.parseRequest(request);
      System.out.println(fileItems);
      System.out.println("AA");
      // Process the uploaded file items
      Iterator i = fileItems.iterator();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet upload</title>");  
      out.println("</head>");
      out.println("<body>");
      while ( i.hasNext () ) 
      {
         FileItem fi = (FileItem)i.next();
         if ( !fi.isFormField () )	
         {
            // Get the uploaded file parameters
            String fieldName = fi.getFieldName();
            String fileName = fi.getName();
            String contentType = fi.getContentType();
            boolean isInMemory = fi.isInMemory();
            long sizeInBytes = fi.getSize();
            // Write the file
            if( fileName.lastIndexOf("\\") >= 0 ){
               file = new File( filePath + 
               fileName.substring( fileName.lastIndexOf("\\"))) ;
            }else{
               file = new File( filePath + 
               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
            }
            fi.write( file ) ;
            System.out.print("oo");

            //System.out.println(request.getPart("file"));


            fotosDoUsuario.setFoto30((MultipartFile) file);
            //System.out.print("oa");

            dao.adicionaFotosDoUsuario(fotosDoUsuario);
            out.println("Uploaded Filename: " + fileName + "<br>");
         }
      }
      out.println("</body>");
      out.println("</html>");
   }catch(Exception ex) {
       System.out.println(ex);
   }
      //dao.close();
   }
   public void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
        throws ServletException, java.io.IOException {
        
        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
   } 
}