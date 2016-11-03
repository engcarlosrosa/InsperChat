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
	" (nome, sobrenome, sexo, nascimento, email, senha, corDosOlhos,"
	+ " numeroMatricula, corCabelo, profissao, nivelDeEntrada, rg, cpf) "
	+ "values (?,?,?,?,?,MD5(?),?,?,?,?,?,MD5(?),MD5(?))";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, dadosPessoal.getNome());
			stmt.setString(2,dadosPessoal.getSobrenome());
			stmt.setLong(3, dadosPessoal.getSexo());
			stmt.setDate(4, new Date(dadosPessoal.getNascimento().getTimeInMillis()));
			stmt.setString(5, dadosPessoal.getEmail());
			stmt.setString(6, dadosPessoal.getSenha());
			stmt.setString(7, dadosPessoal.getCorDosOlhos());
			stmt.setString(8, dadosPessoal.getNumeroMatricula());
			stmt.setString(9, dadosPessoal.getCorCabelo());
			stmt.setString(10, dadosPessoal.getProfissao());
			stmt.setString(11, dadosPessoal.getNivelDeEntrada());
			stmt.setString(12, dadosPessoal.getRg());
			stmt.setString(13, dadosPessoal.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adicionaAcesso(Acessos acesso) {
		String sql = "INSERT INTO Acessos" + "(dadosPessoal_id, data) values(?,?)";
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, acesso.getDadosPessoal_id());
			stmt.setDate(2, new Date(acesso.getData().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<DadosPessoais> getListaDadosPessoais() {
		List<DadosPessoais> dadosPessoais = new ArrayList<DadosPessoais>();
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM DadosPessoais");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DadosPessoais dadosPessoal = new DadosPessoais();
				dadosPessoal.setId(rs.getInt("id"));
				dadosPessoal.setNome(rs.getString("nome"));
				dadosPessoal.setSobrenome(rs.getString("sobrenome"));
				dadosPessoal.setSexo(rs.getInt("sexo"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("nascimento"));
				dadosPessoal.setEmail(rs.getString("email"));
				dadosPessoal.setSenha(rs.getString("senha"));
				dadosPessoal.setCorDosOlhos(rs.getString("corDosOlhos"));

				dadosPessoal.setNumeroMatricula(rs.getString("numeroMatricula"));
				dadosPessoal.setCorCabelo(rs.getString("corCabelo"));
				dadosPessoal.setProfissao(rs.getString("profissao"));
				dadosPessoal.setNivelDeEntrada(rs.getString("nivelDeEntrada"));
				dadosPessoal.setRg(rs.getString("rg"));
				dadosPessoal.setCpf(rs.getString("cpf"));
				dadosPessoais.add(dadosPessoal);
			}
			rs.close();
			stmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dadosPessoais;
	}
	
	public List<Acessos> getListaAcessos() {
		List<Acessos> acessos = new ArrayList<Acessos>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Acessos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Acessos acesso = new Acessos();
				acesso.setId(rs.getInt("id"));
				acesso.setDadosPessoal_id(rs.getInt("dadosPessoal_id"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				acesso.setData(data);
				acessos.add(acesso);
			}
			rs.close();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return acessos;
	}
	
	public List<AcessosDetalhados> getListaAcessosDetalhados(){

		List<AcessosDetalhados> acessosDetalhados = new ArrayList<AcessosDetalhados>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT Acessos.id, "

					+ "Acessos.data, DadosPessoais.numeroMatricula,"
					+ "DadosPessoais.nome, DadosPessoais.nivelDeEntrada FROM Acessos "
					+ "JOIN DadosPessoais ON Acessos.dadosPessoal_id = DadosPessoais.id; ");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				AcessosDetalhados acessoDetalhado = new AcessosDetalhados();
				acessoDetalhado.setId(rs.getInt("id"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				acessoDetalhado.setData(data);

				acessoDetalhado.setMatricula(rs.getString("NumeroMatricula"));

				acessoDetalhado.setNome(rs.getString("nome"));
				acessoDetalhado.setNivelDeEntrada(rs.getString("nivelDeEntrada"));
				acessosDetalhados.add(acessoDetalhado);		
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acessosDetalhados;
	}
	
	public void alteraDadosPessoais(DadosPessoais dadosPessoal){
		String sql = "UPDATE DadosPessoais SET" 

	+ "nome=?, sobrenome=?, sexo=?, nascimento=?, email=?, senha=MD5(?), corDosOlhos=?, "
	+ "numeroMatricula=?, corCabelo=?, profissao=?,"
	+ " nivelDeEntrada=?, rg=MD5(?), cpf=MD5(?) WHERE ID=?";

		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, dadosPessoal.getNome());
			stmt.setString(2, dadosPessoal.getSobrenome());
			stmt.setInt(2, dadosPessoal.getSexo());
			stmt.setDate(3, new Date(dadosPessoal.getNascimento().getTimeInMillis()));
			stmt.setString(4, dadosPessoal.getEmail());
			stmt.setString(5, dadosPessoal.getSenha());
			stmt.setString(5, dadosPessoal.getCorDosOlhos());
			stmt.setString(7, dadosPessoal.getNumeroMatricula());
			stmt.setString(8,dadosPessoal.getCorCabelo());
			stmt.setString(9, dadosPessoal.getProfissao());
			stmt.setString(10, dadosPessoal.getNivelDeEntrada());
			stmt.setString(11, dadosPessoal.getRg());
			stmt.setString(12, dadosPessoal.getCpf());
			stmt.setInt(13, dadosPessoal.getId());
			stmt.execute();
			stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void removeDadosPessoais(Integer id){
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM DadosPessoais WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public int checaLogin(String senha, String email_inserido){
		
		String senha_dado = null;
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT senha FROM DadosPessoais WHERE email = "+ email_inserido);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				senha_dado = rs.getString("MD5(senha)");

			}
			rs.close();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();

	
		}
		
		if (senha_dado.equals(senha)){
			
			return -1;
		}
		else{
			
			return 0;
		}
		
	}
}
