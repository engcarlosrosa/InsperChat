import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

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
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
	"jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_700d92b6f5ca64b",
	"bcf67195a7d1bc",
	"c3997232");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}*/
	}
	
	public void adicionaDadosPessoais(DadosPessoais dadosPessoal){
		String sql = "INSERT INTO DadosPessoais" + 
	" (nome, sobrenome, sexo, email, senha,"
	+ " numeroMatricula, profissao, rg) "
	+ "values (?,?,?,?,MD5(?),?,?,?)";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, dadosPessoal.getNome());
			stmt.setString(2,dadosPessoal.getSobrenome());
			stmt.setString(3, dadosPessoal.getSexo());
			stmt.setString(4, dadosPessoal.getEmail());
			stmt.setString(5, dadosPessoal.getSenha());
			stmt.setString(6, dadosPessoal.getNumeroMatricula());
			stmt.setString(7, dadosPessoal.getProfissao());
			stmt.setString(8, dadosPessoal.getRg());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adicionaAcesso(Acessos acesso) {
		String sql = "INSERT INTO Acessos" + "(dadosPessoal_id) values(?)";
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, acesso.getDadosPessoal_id());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionaFotosDoUsuario(FotosDoUsuario fotosDoUsuario) throws IOException{
		MultipartFile filePart30 = fotosDoUsuario.getFoto30();
		try {
            String sql = "INSERT INTO fotos (dadosPessoal_id, foto30) "
            		+ "values(?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,fotosDoUsuario.getDadosPessoal_id());
            stmt.setBinaryStream(2, filePart30.getInputStream());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {e.printStackTrace();}
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
				dadosPessoal.setSexo(rs.getString("sexo"));
				//Calendar data = Calendar.getInstance();
				//data.setTime(rs.getDate("nascimento"));
				dadosPessoal.setEmail(rs.getString("email"));
				dadosPessoal.setSenha(rs.getString("senha"));
				dadosPessoal.setNumeroMatricula(rs.getString("numeroMatricula"));
				dadosPessoal.setProfissao(rs.getString("profissao"));
				dadosPessoal.setRg(rs.getString("rg"));
		
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
				acesso.setDadosPessoal_id(rs.getString("dadosPessoal_id"));
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
	
	public DadosPessoais getDadosPessoais(Integer id) {
		DadosPessoais dadosPessoais = new DadosPessoais();
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM DadosPessoais WHERE id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				dadosPessoais.setId(rs.getInt("id"));
				dadosPessoais.setNome(rs.getString("nome"));
				dadosPessoais.setSobrenome(rs.getString("sobrenome"));
				dadosPessoais.setSexo(rs.getString("sexo"));
				dadosPessoais.setEmail(rs.getString("email"));
				dadosPessoais.setSenha(rs.getString("senha"));
				dadosPessoais.setNumeroMatricula(rs.getString("numeroMatricula"));
				dadosPessoais.setProfissao(rs.getString("profissao"));
				dadosPessoais.setRg(rs.getString("rg"));
				
			}
			rs.close();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return dadosPessoais;
	}
	
	public List<AcessosDetalhados> getListaAcessosDetalhados(){

		List<AcessosDetalhados> acessosDetalhados = new ArrayList<AcessosDetalhados>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT Acessos.id, "

					+ "Acessos.data, DadosPessoais.numeroMatricula,"
					+ "DadosPessoais.nome FROM Acessos "
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
				//acessoDetalhado.setNivelDeEntrada(rs.getString("nivelDeEntrada"));
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

	+ "nome=?, sobrenome=?, sexo=?, email=?, senha=?, "
	+ "numeroMatricula=?, profissao=?,"
	+  "rg=?, cpf=? WHERE ID=?";

		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, dadosPessoal.getNome());
			stmt.setString(2, dadosPessoal.getSobrenome());
			stmt.setString(3, dadosPessoal.getSexo());
			stmt.setString(4, dadosPessoal.getEmail());
			stmt.setString(5, dadosPessoal.getSenha());
			stmt.setString(6, dadosPessoal.getNumeroMatricula());
			stmt.setString(7, dadosPessoal.getProfissao());
			stmt.setString(8, dadosPessoal.getRg());
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
			stmt = connection.prepareStatement("DELETE * FROM DadosPessoais WHERE id=?");
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
	
	public DadosPessoais checaLogin(String senha, String email){

		DadosPessoais dadosPessoais = new DadosPessoais();
		
		PreparedStatement stmt;
		
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM DadosPessoais WHERE email=? and senha = md5(?)");
			stmt.setString(1,email);
			stmt.setString(2,senha);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				dadosPessoais.setId(rs.getInt("id"));
				dadosPessoais.setNome(rs.getString("nome"));
				dadosPessoais.setSobrenome(rs.getString("sobrenome"));
				dadosPessoais.setSexo(rs.getString("sexo"));
				dadosPessoais.setEmail(rs.getString("email"));
				//dadosPessoais.setSenha(rs.getString("senha"));
				dadosPessoais.setNumeroMatricula(rs.getString("numeroMatricula"));
				dadosPessoais.setProfissao(rs.getString("profissao"));
				dadosPessoais.setRg(rs.getString("rg"));
				

			}
			rs.close();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();

	
		}
		
		if(dadosPessoais.getNome() != null){
			
			return dadosPessoais;
		}
		else{
			
			return null;
		}
		
	}
	
	public DadosPessoais dadosEmail(String email){

		DadosPessoais dadosPessoais = new DadosPessoais();
		
		PreparedStatement stmt;
		
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM DadosPessoais WHERE email=?");
			stmt.setString(1,email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				dadosPessoais.setId(rs.getInt("id"));
				dadosPessoais.setNome(rs.getString("nome"));
				dadosPessoais.setSobrenome(rs.getString("sobrenome"));
				dadosPessoais.setSexo(rs.getString("sexo"));
				dadosPessoais.setEmail(rs.getString("email"));
				dadosPessoais.setNumeroMatricula(rs.getString("numeroMatricula"));
				dadosPessoais.setProfissao(rs.getString("profissao"));
				dadosPessoais.setRg(rs.getString("rg"));
				

			}
			rs.close();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();

	
		}
		
		return dadosPessoais;
		
	}
	
}
