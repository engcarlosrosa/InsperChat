
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

@SuppressWarnings("serial")
@WebServlet("/recebeJsonDadosPessoais")
public class RecebeJsonDadosPessoais extends HttpServlet{
	public void service (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, 
													IOException{
		DAO dao = new DAO();
		DadosPessoais dadosPessoal = new DadosPessoais();
		dadosPessoal.setNome(request.getParameter("nome"));
		dadosPessoal.setSobrenome(request.getParameter("sobrenome"));
		dadosPessoal.setSexo(Integer.valueOf(request.getParameter("sexo")));
		String nascimento = request.getParameter("nascimento");
		@SuppressWarnings("unused")
		Date data = null;
		try{
			data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);			
		} catch (ParseException e){
			e.printStackTrace();			
		}
		Calendar dataNascimento = Calendar.getInstance();
		dadosPessoal.setNascimento(dataNascimento);
		dadosPessoal.setEmail(request.getParameter("email"));
		dadosPessoal.setSenha(request.getParameter("senha"));
		dadosPessoal.setCorDosOlhos(request.getParameter("corDosOlhos"));
		dadosPessoal.setNumeroMatricula(request.getParameter("numeroMatricula"));
		dadosPessoal.setCorCabelo(request.getParameter("corCabelo"));
		dadosPessoal.setProfissao(request.getParameter("profissao"));
		dadosPessoal.setNivelDeEntrada(request.getParameter("nivelDeEntrada"));
		dadosPessoal.setRg(request.getParameter("rg"));
		dadosPessoal.setCpf(request.getParameter("cpf"));
		dao.adicionaDadosPessoais(dadosPessoal);
		System.out.println(dadosPessoal);
		dao.close();
	}

}
