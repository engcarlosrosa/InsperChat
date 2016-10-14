
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class DAO {
	private Connection connection = null;
	public DAO() {
	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados", "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adicionaInformacoesPessoais(InformacoesPessoais informacaoPessoal){
		String sql = "INSERT INTO InformacoesPessoais" + 
	"(nome, sexo, nascimento, email, senha, corDosOlhos, numeroMatricula, corCabelo, profissao) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, informacaoPessoal.getNome());
			stmt.setString(2, informacaoPessoal.getSexo());
			stmt.setDate(3, new Date(informacaoPessoal.getNascimento().getTimeInMillis()));
			stmt.setString(4, informacaoPessoal.getEmail());
			stmt.setString(5, informacaoPessoal.getSenha());
			stmt.setString(6, informacaoPessoal.getCorDosOlhos());
			stmt.setString(7, informacaoPessoal.getNumeroMatricula());
			stmt.setString(8, informacaoPessoal.getCorCabelo());
			stmt.setString(9, informacaoPessoal.getProfissao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


