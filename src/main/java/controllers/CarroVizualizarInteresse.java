package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interessesDao;
import model.Carro;


@WebServlet("/CarroVizualizarInteresse")
public class CarroVizualizarInteresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CarroVizualizarInteresse() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carroId = Integer.parseInt(request.getParameter("carroId"));
        
        Carro carro = interessesDao.findByPk(carroId);

        request.setAttribute("carro", carro);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carro-detalhes.jsp");
        dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
