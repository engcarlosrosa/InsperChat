import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;
public class FotosDoUsuario {
	private Integer id;
	private String dadosPessoal_id;

	private Part foto30;
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

	public Part getFoto30() {
		return foto30;
	}
	public void setFoto30(Part foto30) {
		this.foto30 = foto30;
	}


	
	

}
