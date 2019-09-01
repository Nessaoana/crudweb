package crudweb.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudweb.entidades.ListaUser;
import crudweb.entidades.User;

public class CadastroController {

	public class ControllerServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private ListaUser ls;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
	 
	        try {
	            switch (action) {
	            case "/new":
	                showNewForm(request, response);
	                break;
	            case "/insert":
	                insertUser(request, response);
	                break;
	            /*case "/delete":
	                deleteBook(request, response);
	                break;
	            case "/edit":
	                showEditForm(request, response);
	                break;
	            case "/update":
	                updateBook(request, response);
	                break;*/
	            default:
	                listUser(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	    
	    private void insertUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    	
	    	
			String name = request.getParameter("nome");
			int idade = Integer.parseInt(request.getParameter("idade"));
			String sexo = request.getParameter("sexo");
			
			
			User usuarioNovo = new User(name, idade, sexo);
			
			ls.setUsuarios(usuarioNovo);	
			
			request.setAttribute("Usuarios", usuarioNovo);
			
			request.getRequestDispatcher("usuarios.jsp").forward(request, response);

	        response.sendRedirect("list");
	    }
	    
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        List<User> listUser = ls.getUsuarios();
	        request.setAttribute("listBook", listUser);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
	        dispatcher.forward(request, response);
	    }
	    

	 
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar.jsp");
	        dispatcher.forward(request, response);
	    }
	  /*
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Book existingBook = bookDAO.getBook(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
	        request.setAttribute("book", existingBook);
	        dispatcher.forward(request, response);
	 
	    }
	 

	 
	    private void updateBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        float price = Float.parseFloat(request.getParameter("price"));
	 
	        Book book = new Book(id, title, author, price);
	        bookDAO.updateBook(book);
	        response.sendRedirect("list");
	    }
	 
	    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	 
	        Book book = new Book(id);
	        bookDAO.deleteBook(book);
	        response.sendRedirect("list");
	 
	    }*/
	}
}