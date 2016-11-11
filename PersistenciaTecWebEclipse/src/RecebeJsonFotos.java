
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

@MultipartConfig
@WebServlet("/RecebeJsonFotos")
public class RecebeJsonFotos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost (HttpServletRequest request, 
							HttpServletResponse response) 
								throws ServletException, IOException {
		DAO dao = new DAO();
		FotosDoUsuario fotosDoUsuario = new FotosDoUsuario();
		fotosDoUsuario.setDadosPessoal_id(request.getParameter("dadosPessoal_id"));
		//fotosDoUsuario.setFoto1(request.getParameter("foto1"));
		
	}

}
