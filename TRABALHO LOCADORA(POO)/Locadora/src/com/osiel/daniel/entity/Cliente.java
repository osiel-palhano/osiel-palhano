package com.osiel.daniel.entity;

public class Cliente {

	private Long id;
	private String nome;
	private String telefone;
	private String endereco;
	private String eMail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return eMail;
	}

	public void setEmail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
