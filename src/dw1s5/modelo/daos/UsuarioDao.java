package dw1s5.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import com.sun.net.httpserver.Authenticator.Result;

import dw1s5.modelo.entidades.Usuario;
import dw1s5.utils.DigestMD5;

public class UsuarioDao {
	private DataSource dataSource;
	
	public UsuarioDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}	
	
	public Optional<Usuario> getUsuarioPeloEmailESenha(String email, String senha) {
		String sql = "select nome, email from usuario where email=? and senha=?";
		Optional<Usuario> opt = Optional.empty();
		try(Connection con = dataSource.getConnection();
			PreparedStatement pStat = con.prepareStatement(sql))
		{
			String senhaCriptografada = new DigestMD5(senha).getSenhaCriptografada();
			pStat.setString(1, email);
			pStat.setString(2, senhaCriptografada);
			
			try(ResultSet rs = pStat.executeQuery()) {
				if(rs.next()) {
					String nome = rs.getString(1);					
					Usuario usuario = new Usuario(nome, email);
					opt = Optional.of(usuario);
				}
			}
			return opt;
		}
		catch(SQLException erro) {
			throw new RuntimeException(erro);
		}
	}
	
}
