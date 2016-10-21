import java.util.Calendar;

public class InformacoesPessoais {
	private String nome;
	private String pai;
	private String sexo;
	private String nacionalidade;
	private String racaCor;
	private String religao;
	private Calendar nascimento;
	private String mae;
	private String estadoCivil;
	private String naturalidade;
	private String necessidadeEspecial;
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getPai() {return pai;}
	public void setPai(String pai) {this.pai = pai;}
	
	public String getSexo() {return sexo;}
	public void setSexo(String sexo) {this.sexo = sexo;}
	
	public String getNacionalidade() {return nacionalidade;}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getRacaCor() {return racaCor;}
	public void setRacaCor(String racaCor) {this.racaCor = racaCor;}
	
	public String getReligao() {return religao;}
	public void setReligao(String religao) {this.religao = religao;}
	
	public Calendar getNascimento() {return nascimento;}
	public void setNascimento(Calendar nascimento) {this.nascimento = nascimento;}
	
	public String getMae() {return mae;}
	public void setMae(String mae) {this.mae = mae;}
	
	public String getEstadoCivil() {return estadoCivil;}
	public void setEstadoCivil(String estadoCivil) {this.estadoCivil = estadoCivil;}
	
	public String getNaturalidade() {return naturalidade;}
	public void setNaturalidade(String naturalidade) {this.naturalidade = naturalidade;}
	
	public String getNecessidadeEspecial() {return necessidadeEspecial;}
	public void setNecessidadeEspecial(String necessidadeEspecial) {
		this.necessidadeEspecial = necessidadeEspecial;
	}
	
}