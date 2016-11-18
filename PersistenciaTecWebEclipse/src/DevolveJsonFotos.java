
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

/**
 * Servlet implementation class RecebeJsonAcesso
 */
@WebServlet("/DevolveJsonFotos")
public class DevolveJsonFotos  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, 
							HttpServletResponse response) 
								throws ServletException, IOException {
		DAO dao = new DAO();
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		
		try {
			jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
			
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			System.out.println(dao.getFoto((String) jsonObject.get("dadosPessoal_id")));
			response.getOutputStream().write(dao.getFoto((String) jsonObject.get("dadosPessoal_id")));
	    	response.getOutputStream().close();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.close();
	}


}