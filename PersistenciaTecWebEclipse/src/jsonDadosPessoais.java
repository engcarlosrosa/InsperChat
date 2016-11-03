import java.io.IOException;
import java.io.FileWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet("/jsonDadosPessoais")
public class jsonDadosPessoais extends HttpServlet{
	protected void service (HttpServletRequest request, 
							HttpServletResponse response)
							throws ServletException, IOException {
		
		String param = request.getParameter("id");
		System.out.println(param);
		DAO dao = new DAO();
		DadosPessoais dadosPessoais = dao.getDadosPessoais(Integer.parseInt(param));
		System.out.println(dadosPessoais);
		String json = new Gson().toJson(dadosPessoais);
		System.out.println(json);
		FileWriter writeFile = null;
		
		try{
			writeFile = new FileWriter("dadosPessoais.json");
			writeFile.write(json);
			writeFile.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		response.getWriter().write(json);
	}
	
}
