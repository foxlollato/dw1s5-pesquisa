package dw1s5.controle.helpers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dw1s5.modelo.daos.UsuarioDao;
import dw1s5.utils.BuscadorDataSource;

public class CadastroHelper implements Helper {

	String pagina = "/WEB-INF/cadastro.jsp";
		
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		return pagina;
	}
	
}
