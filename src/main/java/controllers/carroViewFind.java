package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarroDao;
import dao.interessesDao;
import model.Carro;
import model.interessesClientes;


@WebServlet("/carroViewFind")
public class carroViewFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public carroViewFind() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int carroId = Integer.parseInt(request.getParameter("carroId"));
		Carro carro = CarroDao.findByPk(carroId);
		
		request.setAttribute("carro", carro);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("vizualizar-carro.jsp");
		requestDispatcher.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//cria o cliente
		interessesClientes interesses = new interessesClientes();
		
		int telefone = Integer.parseInt(request.getParameter("telefoneCliente"));
		int id_carro = Integer.parseInt(request.getParameter("id_carro"));
		interesses.setId_carro(id_carro);
		interesses.setTelefoneCliente(telefone);
		interesses.setNomeCliente(request.getParameter("nomeCliente"));
		interessesDao.create(interesses);
		
		//da update no carro (sei que nao é necessario mas eu ja fiz e nao vou apagar, se tiver achando ruim apaga ai tu)
		Carro carro = new Carro();
		carro.setId(Integer.parseInt(request.getParameter("id_carro")));
		carro.setInteresse(1);
		interessesDao.updateInteresseCarro(carro);
		
		response.sendRedirect(request.getContextPath() + "/carroViewIndex");
	}

}
