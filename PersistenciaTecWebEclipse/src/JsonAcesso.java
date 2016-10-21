import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/jsonAcesso")
public class JsonAcesso extends HttpServlet{
	
	protected void service (HttpServletRequest request,
							HttpServletResponse response)
								throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		List<AcessosDetalhados> acessoDetalhado = dao.getListaAcessosDetalhados();

		
		String json = new Gson().toJson(acessoDetalhado);
		response.getWriter().write(json);
		}
	}


