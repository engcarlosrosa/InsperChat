

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;


@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    DAO dao = new DAO();
	    FotosDoUsuario fotosDoUsuario = new FotosDoUsuario();
	    fotosDoUsuario.setDadosPessoal_id(request.getParameter("description"));
	    fotosDoUsuario.setFoto30(request.getPart("file"));
	    dao.adicionaFotosDoUsuario(fotosDoUsuario);
	    dao.close();
	    }
	}

