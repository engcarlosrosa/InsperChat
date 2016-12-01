package mvc.model;


import java.sql.Date;
import java.sql.*;
import java.util.*;


public class TarefaDAO {


    private Connection connection = null;
	
    public TarefaDAO() {
    	 try {
            Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost/meus_dados", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
    
    	 /*try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
"jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_700d92b6f5ca64b",
"bcf67195a7d1bc",
"c3997232");
	} catch (SQLException | ClassNotFoundException e) {
		throw new RuntimeException(e);}}*/
    }

    
    public void adicionaMensagem(Mensagem mensagem){
    	try {
    		String sql = "INSERT INTO Mensagens"
    				+ "(usuario, mensagem) values(?,?)";
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		stmt.setString(1, mensagem.getUsuario());
    		stmt.setString(2, mensagem.getMensagem());
    		stmt.execute();
    		stmt.close();
    	} catch (SQLException e) {e.printStackTrace();}
    }
    
    public List<Mensagem> getListaMensagem() {
    	List<Mensagem> mensagens = new ArrayList<Mensagem>();
    	try {
    		PreparedStatement stmt = 
    				connection.prepareStatement("SELECT * FROM Mensagens");
    		ResultSet rs = stmt.executeQuery();
    		while (rs.next()) {
    			Mensagem mensagem = new Mensagem();
    			mensagem.setId(rs.getLong("id"));
    			mensagem.setUsuario(rs.getString("usuario"));
    			Calendar data = Calendar.getInstance();
    			Date dataMensagem = rs.getDate("data");
    			data.setTime(dataMensagem);
    			mensagem.setMensagem(rs.getString("mensagem"));
    			mensagem.setData(data);
    			mensagens.add(mensagem);
    		}
    		rs.close();
    		stmt.close();
    	} catch(SQLException e) {System.out.println(e);}
    	return mensagens;
    }
	
    public void close() {
        try { connection.close();}
        catch (SQLException e) {e.printStackTrace();}		
    }


}