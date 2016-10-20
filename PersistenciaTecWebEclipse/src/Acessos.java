import java.util.Calendar;
import java.util.Date;

public class Acessos {
	private Integer id;
	private Integer dadosPessoal_id;
	private Calendar data;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDadosPessoal_id() {
		return dadosPessoal_id;
	}
	public void setDadosPessoal_id(Integer dadosPessoal_id) {
		this.dadosPessoal_id = dadosPessoal_id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}


}
