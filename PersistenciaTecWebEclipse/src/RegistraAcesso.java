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

@SuppressWarnings("serial")
@WebServlet("/registraAcesso")
public class RegistraAcesso extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
							throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("dadosPessoal_id: <input type='number' name='dadosPessoal_id'><br>");
		out.println("Data: <input type='date' name='data'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
					HttpServletResponse response)
						throws ServletException, IOException {
		DAO dao = new DAO();
		
		Acessos acesso = new Acessos();
		acesso.setDadosPessoal_id(request.getParameter("dadosPessoal_id"));
		String dataS = request.getParameter("data");
		Date dataT = null;
		try{
			dataT = new SimpleDateFormat("yyyy-MM-dd").parse(dataS);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar dataF = Calendar.getInstance();
		dataF.setTime(dataT);
		acesso.setData(dataF);
		
		dao.adicionaAcesso(acesso);
		
		PrintWriter out= response.getWriter();
		out.println("<html><body>");
		out.println("adicionado" + acesso.getDadosPessoal_id());
		out.println("</body></html>");
		
		dao.close();
		
	}

}
