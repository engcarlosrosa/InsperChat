

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
@WebServlet("/RecebeJsonAcesso")
public class RecebeJsonAcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, 
							HttpServletResponse response) 
								throws ServletException, IOException {
		DAO dao = new DAO();
		Acessos acesso = new Acessos();
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		
		try {
			jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
			acesso.setDadosPessoal_id((String) jsonObject.get("pessoa_id"));
			dao.adicionaAcesso(acesso);
			System.out.println(dao.getListaAcessosDetalhados());
			String json = new Gson().toJson(dao.getListaAcessosDetalhados());
			response.getWriter().write(json);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.close();
	}


}
