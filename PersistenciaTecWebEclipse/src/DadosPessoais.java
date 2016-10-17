import java.util.Calendar;

public class DadosPessoais {
	
	private Integer id;
	private String nome;
	private String sexo;
	private Calendar nascimento;
	private String email;
	private String senha;
	private String corDosOlhos;
	private Integer numeroMatricula;
	private String corCabelo;
	private String profissao;
	private String nivelDeEntrada;
	private Integer rg;
	private Integer cpf;
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	
	public String getSexo() {return sexo;}
	public void setSexo(String sexo) {this.sexo = sexo;}

	public Calendar getNascimento() {return nascimento;}
	public void setNascimento(Calendar nascimento) {this.nascimento = nascimento;}
	
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
	public String getCorDosOlhos() {
		return corDosOlhos;
	}
	public void setCorDosOlhos(String corDosOlhos) {
		this.corDosOlhos = corDosOlhos;
	}
	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}
	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
	public String getCorCabelo() {
		return corCabelo;
	}
	public void setCorCabelo(String corCabelo) {
		this.corCabelo = corCabelo;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getNivelDeEntrada() {
		return nivelDeEntrada;
	}
	public void setNivelDeEntrada(String nivelDeEntrada) {
		this.nivelDeEntrada = nivelDeEntrada;
	}
	public Integer getRg() {
		return rg;
	}
	public void setRg(Integer rg) {
		this.rg = rg;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	

}
