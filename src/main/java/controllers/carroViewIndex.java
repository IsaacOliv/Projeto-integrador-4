package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarroDao;
import model.Carro;


@WebServlet("/carroViewIndex")
public class carroViewIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public carroViewIndex() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Carro> carros = CarroDao.listaCarrosView(0);
		
		request.setAttribute("Carros", carros);
		RequestDispatcher requestDispathcer = request.getRequestDispatcher("carros-lista-usuario.jsp");
		requestDispathcer.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
