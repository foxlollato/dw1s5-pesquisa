package dw1s5.modelo.entidades;

public class Candidato {
	private String nome;
	private String cpf;
	private String foto;
	private String cv;
	
	
	public Candidato(String nome, String cpf, String foto, String cv){
		this.nome = nome;
		this.cpf = cpf;
		this.foto = foto;
		this.cv = cv;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public String getCv() {
		return cv;
	}
	

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	@Override
	public String toString() {
		return "Candidato [nome=" + nome + ", cpf=" + cpf + ", foto=" + foto + ", cv=" + cv + "]";
	}
	
}
