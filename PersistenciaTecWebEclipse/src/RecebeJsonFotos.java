import java.nio.file.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@MultipartConfig
@WebServlet("/RecebeJsonFotos")
public class RecebeJsonFotos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, 
							HttpServletResponse response) 
								throws ServletException, IOException {
		   
	       DAO dao = new DAO();
	       FotosDoUsuario fotosDoUsuario = new FotosDoUsuario();
	       JSONObject jsonObject;
	       JSONParser parser = new JSONParser();
	       
	       try{
	    	   jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
	    	   fotosDoUsuario.setDadosPessoal_id((String) jsonObject.get("DadosPessoal_id"));
	       } catch(org.json.simple.parser.ParseException e){
	    	   e.printStackTrace();
	       }
	       Part filePart = request.getPart("file");
	       
	       //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	       //File uploads = new File("/temp");
	       fotosDoUsuario.setFoto30((MultipartFile) filePart);
           dao.adicionaFotosDoUsuario(fotosDoUsuario);
           dao.close();
		
	}

}
