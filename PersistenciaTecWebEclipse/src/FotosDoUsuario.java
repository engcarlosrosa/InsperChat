import org.springframework.web.multipart.MultipartFile;
public class FotosDoUsuario {
	private Integer id;
	private String dadosPessoal_id;

	private MultipartFile foto30;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDadosPessoal_id() {
		return dadosPessoal_id;
	}
	public void setDadosPessoal_id(String dadosPessoal_id) {
		this.dadosPessoal_id = dadosPessoal_id;
	}

	public MultipartFile getFoto30() {
		return foto30;
	}
	public void setFoto30(MultipartFile foto30) {
		this.foto30 = foto30;
	}


	
	

}
