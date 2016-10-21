import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/criaDadosPessoais")
public class CriaDadosPessoais extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
				throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Nome: <input type='text' name='nome'><br>");
		out.println("Sobrenome: <input type='text' name='sobrenome'><br>");
		out.println("Sexo: <input type='number' name='sexo'><br>");
		out.println("Nascimento: <input type='date' name='nascimento'><br>");
		out.println("Email: <input type='text' name='email'><br>");
		out.println("Senha <input type='text' name='senha'><br>");
		out.println("Cor dos olhos: <input type='text' name='corDosOlhos'><br>");
		out.println("Numero de Matricula: <input type='text' name='numeroMatricula'><br>");
		out.println("Cor do Cabelo: <input type='text' name='corCabelo'><br>");
		out.println("Profissao: <input type='text' name='profissao'><br>");
		out.println("Nivel de entrada: <input type='text' name='nivelDeEntrada'><br>");
		out.println("Rg: <input type='text' name='rg'><br>");
		out.println("Cpf: <input type='text' name='cpf'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("</body></html>");
	}
	
		@Override
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) 
					throws ServletException, IOException {
			DAO dao = new DAO();
			
			DadosPessoais dadosPessoal = new DadosPessoais();
			dadosPessoal.setNome(request.getParameter("nome"));
			dadosPessoal.setSobrenome(request.getParameter("sobrenome"));
			dadosPessoal.setSexo(Integer.valueOf(request.getParameter("sexo")));
			String nascimento = request.getParameter("nascimento");
			Date data = null;
			try {
				data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
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
			PrintWriter out= response.getWriter();
			out.println("<html><body>");
			out.println("adicionado" + dadosPessoal.getNome());
			out.println("</body></html>");
			
			dao.close();
			
		}
	}


