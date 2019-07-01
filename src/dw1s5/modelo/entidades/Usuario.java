package dw1s5.modelo.entidades;

public class Usuario {
	
	private String nome;
	private String email;
	private String senha;
	
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;		
	}
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;		
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}
	
}
