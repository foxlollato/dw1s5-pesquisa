package dw1s5.modelo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import dw1s5.modelo.entidades.Candidato;
import dw1s5.modelo.entidades.Usuario;

public class CandidatoDao {
	private DataSource dataSource;
	
	public CandidatoDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void cadastrarCandidato(Candidato candidato)throws SQLException{
		String sql = "insert into candidato values(?,?,?,?)";
		try(Connection con = dataSource.getConnection()){			
			try(PreparedStatement pStat = con.prepareStatement(sql)){
				
				pStat.setString(1, candidato.getNome());
				pStat.setString(2, candidato.getCpf());
				pStat.setString(3, candidato.getFoto());
				pStat.setString(4, candidato.getCv());
				
				pStat.executeUpdate();
				
			}			
		}
	}
	public Optional<Candidato> listarCandidato(String cpf){
		String sql = "select nome, cpf, foto, cv from candidato where cpf=?";
				
		try(Connection con = dataSource.getConnection();
			PreparedStatement pStat = con.prepareStatement(sql))
		{	
			Optional<Candidato> opt = Optional.empty();
			pStat.setString(1, cpf);
			try(ResultSet rs = pStat.executeQuery()) {
				if(rs.next()) {
					String nome = rs.getString(1);					
					String foto = rs.getString(3);
					String cv = rs.getString(4);
					Candidato candidato = new Candidato(nome, cpf, foto, cv);
					opt = Optional.of(candidato);
				}
			}
			
			return opt;
		}
		catch(SQLException erro) {
			throw new RuntimeException("Erro durante a consulta", erro);
		}
		
	}
	
	
	
}
