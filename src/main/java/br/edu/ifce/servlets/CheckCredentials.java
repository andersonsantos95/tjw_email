package br.edu.ifce.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCredentials
 */
public class CheckCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbPassword;

    public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	/**
     * Default constructor.
     */
    public CheckCredentials() {
        // TODO Auto-generated constructor stub
    	super();
    }
    
    public void init(ServletConfig config) throws ServletException{
    	this.dbPassword = config.getInitParameter("admin");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomeUsuario = request.getParameter("admin");
		String senhaUsuario = request.getParameter("senhaUsuario");
		if(nomeUsuario.equals("admin") && senhaUsuario.equals(this.dbPassword)){
			request.getSession().setAttribute("usuario", nomeUsuario);
		}
		doGet(request, response);
	}

}
