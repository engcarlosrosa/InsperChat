import java.util.Calendar;

public class DadosPessoais {
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String sexo;
	private String email;
	private String senha;
	private String numeroMatricula;
	private String profissao;
	private String rg;

	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	
	public String getSexo() {return sexo;}
	public void setSexo(String sexo) {this.sexo = sexo;}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNumeroMatricula() {
		return numeroMatricula;
	}
	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
	
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	

}