package dw1s5.controle.helpers;

import java.io.File;
import java.nio.file.Paths;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dw1s5.modelo.daos.CandidatoDao;
import dw1s5.modelo.entidades.Candidato;
import dw1s5.utils.BuscadorDataSource;



public class CadastrarHelper  implements Helper{
	private final String UPLOAD_DIRECTORY="uploads";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pagina = "/WEB-INF/erro.html";
		
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String uploadPath = request.getServletContext().getRealPath("") + UPLOAD_DIRECTORY;
		
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		
		
		
		Part fotoPart = request.getPart("foto");
		String foto = Paths.get(fotoPart.getSubmittedFileName()).getFileName().toString();
		String fotoPath = uploadPath + File.separator + foto;

		
		Part cvPart = request.getPart("cv");
		String cv = Paths.get(cvPart.getSubmittedFileName()).getFileName().toString();
		String cvPath = uploadPath + File.separator + cv;

		
		fotoPart.write(fotoPath);
		cvPart.write(cvPath);
		
		String fotoDb = UPLOAD_DIRECTORY + File.separator + foto;
		String cvDb = UPLOAD_DIRECTORY + File.separator + cv;
		Candidato candidato = new Candidato(nome, cpf, fotoDb, cvDb);
		CandidatoDao candidatoDao = new CandidatoDao(BuscadorDataSource.getInstance().getDataSource());		
		
		candidatoDao.cadastrarCandidato(candidato);		
		pagina="/";
		
		return pagina;
	}
	
	
	
}
