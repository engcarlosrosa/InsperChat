
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
			String nascimento = (String) jsonObject.get("nascimento");
			Date data = null;
			try{
				data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);			
			} catch (ParseException e){
				e.printStackTrace();			
			}
			Calendar dataNascimento = Calendar.getInstance();
			dadosPessoal.setNascimento(dataNascimento);
			dadosPessoal.setEmail((String) jsonObject.get("email"));
			dadosPessoal.setSenha((String) jsonObject.get("senha"));
			dadosPessoal.setCorDosOlhos((String) jsonObject.get("corDosOlhos"));
			dadosPessoal.setNumeroMatricula((String) jsonObject.get("numeroMatricula"));
			dadosPessoal.setCorCabelo((String) jsonObject.get("corCabelo"));
			dadosPessoal.setProfissao((String) jsonObject.get("profissao"));
			dadosPessoal.setNivelDeEntrada((String) jsonObject.get("nivelDeEntrada"));
			dadosPessoal.setRg((String) jsonObject.get("rg"));
			dadosPessoal.setCpf((String) jsonObject.get("cpf"));
			dao.adicionaDadosPessoais(dadosPessoal);
			//String json = new Gson().toJson(dao.adicionaDadosPessoais(dadosPessoal));
			//System.out.println(json);
			//response.getWriter().write(json);
		} catch (org.json.simple.parser.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dao.close();
	}

}
