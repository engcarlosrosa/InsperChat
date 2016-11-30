package mvc.model;


import java.io.*;
import java.sql.*;
import java.util.*;
import org.springframework.web.multipart.MultipartFile;


public class UsuarioDAO {


    private Connection connection = null;
	
    public UsuarioDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost/meus_dados", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
    }
    /*try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
"jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_700d92b6f5ca64b",
"bcf67195a7d1bc",
"c3997232");
	} catch (SQLException | ClassNotFoundException e) {
		throw new RuntimeException(e);}
	}*/


    public void adiciona(Usuario usuario) throws IOException {
    	MultipartFile filePart = usuario.getFoto();
    	/* Rotina para salvar o arquivo no servidor
    	if (!filePart.isEmpty()) {
    	    String fileName = filePart.getOriginalFilename();
           File uploads = new File("/tmp");
       	    File file = new File(uploads, fileName);
       	    try (InputStream input = filePart.getInputStream()) {
       	        Files.copy(input, file.toPath());
       	    }
    	}
    	*/
        try {
            String sql = "INSERT INTO usuario (login, senha, foto) values(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,usuario.getLogin());
            stmt.setString(2,usuario.getSenha());
            stmt.setBinaryStream(3, filePart.getInputStream());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {e.printStackTrace();}
    }


    public boolean existeUsuario(Usuario usuario) {
        boolean existe = false;
    	try {	
            PreparedStatement stmt = connection.
            prepareStatement("SELECT COUNT(*) FROM usuario WHERE login=? AND senha=? LIMIT 1");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
        	if(rs.getInt(1) != 0) {existe=true;}
            }
            rs.close();
            stmt.close();
        } catch(SQLException e) {System.out.println(e);}
        return existe;
    }
    
    public byte[] buscaFoto(String login) {
    	byte[] imgData = null;
        try {	
            PreparedStatement stmt = connection.
                                    prepareStatement("SELECT * FROM usuario WHERE login=? ");
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
            	Blob image = rs.getBlob("foto");
            	imgData = image.getBytes(1, (int) image.length());
            }
            rs.close();
            stmt.close();
        } catch(SQLException e) {System.out.println(e);}
        return imgData;
    }
    public List<Usuario> getLista() {
    	byte[] imgData = null;
    	List<Usuario> usuarios = new ArrayList<Usuario>();
    	try {
    		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario");
    		ResultSet rs = stmt.executeQuery();
    		while (rs.next()) {
    			Usuario usuario = new Usuario();
    			usuario.setLogin(rs.getString("login"));
    			usuario.setSenha(rs.getString("senha"));
    			usuarios.add(usuario);
    		}
    		rs.close();
    		stmt.close();   		
    	}catch(SQLException e) {System.out.println(e);}
    	return usuarios;
    }
    public void close() {
        try { connection.close();}
        catch (SQLException e) {e.printStackTrace();}		
    }
}