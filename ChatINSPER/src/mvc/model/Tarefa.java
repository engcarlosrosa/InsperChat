package mvc.model;


import java.util.Calendar;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
    private Long id;
    
    @NotNull(message="A descrição não pode ficar vazia")
    @Size(min=5, message="A descrição deve conter ao menos 5 caracteres")
    private String descricao;
    private boolean finalizado;
    
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Calendar dataFinalizacao;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public boolean isFinalizado() {return finalizado;}
    public void setFinalizado(boolean finalizado) {this.finalizado = finalizado;}
    public Calendar getDataFinalizacao() {return dataFinalizacao;}
    public void setDataFinalizacao(Calendar dataFinal) {this.dataFinalizacao = dataFinal;}
}