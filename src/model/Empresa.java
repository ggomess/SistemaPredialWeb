package model;

import java.io.Serializable;

public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String cnpj;
	private String conjunto;

	public Empresa() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() { 
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String fone) {
		this.cnpj = fone;
	}

	public String getConjunto() {
		return conjunto;
	}

	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", conjunto=" + conjunto + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (conjunto == null) {
			if (other.conjunto != null)
				return false;
		} else if (!conjunto.equals(other.conjunto))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
