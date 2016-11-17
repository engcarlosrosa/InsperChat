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
 * Servlet implementation class RecebeJsonLogin
 */
@WebServlet("/RecebeJsonLogin")
public class RecebeJsonLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request,
							HttpServletResponse response)
								throws ServletException, IOException {

		request.getParameter("json");
		DAO dao = new DAO();
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		try {
			jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
			String email = (String) jsonObject.get("email");
			String senha = (String) jsonObject.get("senha");
			System.out.println(dao.checaLogin(senha, email));
			String json = new Gson().toJson(dao.checaLogin(senha, email));
			System.out.println(json);
			response.getWriter().write(json);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.close();	
	}

}
