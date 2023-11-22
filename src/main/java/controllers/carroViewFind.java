package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarroDao;
import model.Carro;


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

}
