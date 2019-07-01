package dw1s5.controle.helpers;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javadoc.ThrowsTag;

import dw1s5.modelo.daos.CandidatoDao;
import dw1s5.modelo.entidades.Candidato;
import dw1s5.utils.BuscadorDataSource;

public class ExibeCandidatoHelper implements Helper {
	
	String pagina="/WEB-INF/exibeCandidato.jsp";
		
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		String uploadPath = request.getServletContext().getRealPath("");
		CandidatoDao candidatoDao = new CandidatoDao(BuscadorDataSource.getInstance().getDataSource());
		String cpf = request.getParameter("cpf");
		
		Optional<Candidato> opt = candidatoDao.listarCandidato(cpf);
			
			opt.ifPresent(candidato -> {		
					request.setAttribute("candidato", candidato);
			});
		
				
		return pagina;
	}
	
}
