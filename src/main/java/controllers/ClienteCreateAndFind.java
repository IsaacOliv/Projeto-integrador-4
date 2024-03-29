package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;
@WebServlet("/CreateAndFind")
public class ClienteCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ClienteCreateAndFind() {
        super();
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pesquisa = request.getParameter("pesquisa");
		
		if(pesquisa == null) {
			pesquisa = "";
		}
		
		List<Cliente> clientes = ClienteDao.find(pesquisa);
		
		request.setAttribute("clientes", clientes);
		RequestDispatcher resquestDis = request.getRequestDispatcher("lista.jsp");
		
		resquestDis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();

		cliente.setNome(request.getParameter("nome"));
	    
	    // Converte a data de nascimento de String para Date
	    String dataNascimentoStr = request.getParameter("dataNascimento");
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        Date dataNascimento = dateFormat.parse(dataNascimentoStr);
	        cliente.setDataNascimento(dataNascimento);
	    } catch (ParseException e) {
	        e.printStackTrace(); 
	    }

	    cliente.setAtivo(true);
	    cliente.setLogin(request.getParameter("login"));
	    cliente.setSenha(request.getParameter("senha"));
	    
	    ClienteDao.create(cliente);
	    
		doGet(request, response);
	}

}
