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

@WebServlet("/RecebeEmail")
public class RecebendoEmailJson extends HttpServlet {
	
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
			System.out.println(dao.dadosEmail(email));
			String json = new Gson().toJson(dao.dadosEmail(email));
			System.out.println(json);
			response.getWriter().write(json);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.close();	
	}

}
