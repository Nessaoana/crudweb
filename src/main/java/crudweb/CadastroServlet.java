package crudweb;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudweb.entidades.ListaUser;
import crudweb.entidades.User;

@WebServlet(name = "CadastroServlet", urlPatterns = { "/cadastro" }, loadOnStartup = 1)
public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = -2459069235625043917L;
	
	User usuarioNovo;
	//ListaUser listaUsuarios ;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("nome");
		int idade = Integer.parseInt(request.getParameter("idade"));
		String sexo = request.getParameter("sexo");
		
		usuarioNovo = new User(name, idade, sexo);
		
		//listaUsuarios = new ListaUser();
		
		//listaUsuarios.setUsuarios(usuarioNovo);		
		
	}
}