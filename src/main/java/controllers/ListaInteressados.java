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


@WebServlet("/lista-carros-interessados")
public class ListaInteressados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ListaInteressados() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Carro> carros = CarroDao.findByInteresse(1);
	    
	    request.setAttribute("carros", carros);
	    
	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista-carros-interessados.jsp");
	    requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
