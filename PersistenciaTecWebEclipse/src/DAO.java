
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
	
	public void adicionaDadosPessoais(DadosPessoais dadosPessoal){
		String sql = "INSERT INTO DadosPessoais" + 
	"(nome, sexo, nascimento, email, senha, corDosOlhos, numeroMatricula, corCabelo, profissao, nivelDeEntrada, rg, cpf) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, dadosPessoal.getNome());
			stmt.setString(2, dadosPessoal.getSexo());
			stmt.setDate(3, new Date(dadosPessoal.getNascimento().getTimeInMillis()));
			stmt.setString(4, dadosPessoal.getEmail());
			stmt.setString(5, dadosPessoal.getSenha());
			stmt.setString(6, dadosPessoal.getCorDosOlhos());
			stmt.setLong(7, dadosPessoal.getNumeroMatricula());
			stmt.setString(8, dadosPessoal.getCorCabelo());
			stmt.setString(9, dadosPessoal.getProfissao());
			stmt.setString(10, dadosPessoal.getNivelDeEntrada());
			stmt.setInt(11, dadosPessoal.getRg());
			stmt.setInt(12, dadosPessoal.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}


