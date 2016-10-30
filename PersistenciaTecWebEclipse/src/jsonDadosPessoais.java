import java.io.IOException;
import java.io.FileWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

@WebServlet("/jsonDadosPessoais?id=?")
public class jsonDadosPessoais {
	protected void service (HttpServletRequest request, 
							HttpServletResponse response)
							throws ServletException, IOException {
		DAO dao = new DAO();
		DadosPessoais dadosPessoais = dao.getDadosPessoais();
		
		String json = new Gson().toJson(dadosPessoais);
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
