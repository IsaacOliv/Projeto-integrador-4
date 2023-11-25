package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;

@WebServlet("/loginServelet")
public class loginServelet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;   
	//private Login loginDao;

    public void init() throws ServletException {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao loginDao = new LoginDao();
		String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        loginDao.findByLoginSenha(login, senha);
		
        response.sendRedirect(request.getContextPath() + "/index.html");
	}

}
