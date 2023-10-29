package com.jovemprogramador.eventosapp.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Evento {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	@NotBlank
	private String nome;
	@NotBlank
    private String local;
	@NotBlank
    private String data;
	@NotBlank
    private String horario;
	
    @OneToMany
    private List<Convidado> convidado;


	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

    public String getNome() {
        return nome;
    }

 

    public void setNome(String nome) {
        this.nome = nome;
    }

 

    public String getLocal() {
        return local;
    }

 

    public void setLocal(String local) {
        this.local = local;
    }

 

    public String getData() {
        return data;
    }

 

    public void setData(String data) {
        this.data = data;
    }

 

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

	public List<Convidado> getConvidado() {
		return convidado;
	}

	public void setConvidado(List<Convidado> convidado) {
		this.convidado = convidado;
	}

}
