
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

//import com.google.gson.Gson;

@WebServlet("/RecebeJsonDadosPessoais")
public class RecebeJsonDadosPessoais extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void service (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, 
													IOException{
		
		DAO dao = new DAO();
		DadosPessoais dadosPessoal = new DadosPessoais();
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();

		try {
			jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
			dadosPessoal.setNome((String) jsonObject.get("nome"));
			dadosPessoal.setSobrenome((String) jsonObject.get("sobrenome"));
			dadosPessoal.setSexo((String) jsonObject.get("sexo"));
			dadosPessoal.setEmail((String) jsonObject.get("email"));
			dadosPessoal.setSenha((String) jsonObject.get("senha"));
			dadosPessoal.setNumeroMatricula((String) jsonObject.get("numeroMatricula"));
			dadosPessoal.setProfissao((String) jsonObject.get("profissao"));
			dadosPessoal.setRg((String) jsonObject.get("rg"));
			dao.adicionaDadosPessoais(dadosPessoal);
			String json = new Gson().toJson(dao.getListaDadosPessoais());
			System.out.println(json);
			response.getWriter().write(json);
		} catch (org.json.simple.parser.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dao.close();
	}

}
