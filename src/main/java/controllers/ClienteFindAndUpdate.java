package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;


@WebServlet("/ClienteUpdate")
public class ClienteFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ClienteFindAndUpdate() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		
		Cliente cliente = ClienteDao.findByPk(clienteId);
		
		request.setAttribute("cliente", cliente);
		RequestDispatcher resquestDis = request.getRequestDispatcher("update.jsp");
		
		resquestDis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(Integer.parseInt(request.getParameter("id")));
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
		
	    ClienteDao.update(cliente);
	    
	    ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);
		
	}

}
