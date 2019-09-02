package crudweb.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudweb.entidades.ListaUser;
import crudweb.entidades.User;


@WebServlet("/")
	public class CadastroServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    @SuppressWarnings("unchecked")
		private ArrayList<User> ls = new ArrayList();
	    ListaUser lsa = new ListaUser();
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
	                
	            case "/ver":
	                seeUser(request, response);
	                break;
	            /*case "/delete":
	                deleteBook(request, response);
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
			String email = request.getParameter("email");
			int idade = Integer.parseInt(request.getParameter("idade"));

			User usuarioNovo = new User(name, email, idade);
			
			
			ls.add(usuarioNovo);	
			
			System.out.println(ls);
			
	        response.sendRedirect("list");

	    }
	    
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {

	    	lsa.setUsuarios(ls);
	    	System.out.println(lsa.getUsuarios().toString());
	    	
	    	
	        request.setAttribute("listUser", ls);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("usuarios.jsp");
	        dispatcher.forward(request, response);
	    }
	    

	 
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("usuarios.jsp");
	        dispatcher.forward(request, response);
	    }
	    
	    
	    
	    private void seeUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	    	
	        String nome = (request.getParameter("nome"));
	        ListaUser.getUsuario(nome);
	        
	        
	        String name = request.getParameter("nome");
			String email = request.getParameter("email");
			int idade = Integer.parseInt(request.getParameter("idade"));
			
	        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
	        request.setAttribute("usuario", nome);
	        dispatcher.forward(request, response);
	 
	    }
	  /*
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