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


@WebServlet("/CarroUpdate")
public class CarroFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarroFindAndUpdate() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int carroId = Integer.parseInt(request.getParameter("carroId"));
		Carro carro = CarroDao.findByPk(carroId);
		
		request.setAttribute("carro", carro);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("carro-formUpdate.jsp");
		requestDispatcher.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Carro carro = new Carro();
		
		carro.setId(Integer.parseInt(request.getParameter("id")));
		
		carro.setMarca(request.getParameter("marca"));
		carro.setModelo(request.getParameter("modelo"));
		int anoFabricacao = Integer.parseInt(request.getParameter("anoFabricacao"));
		int anoModelo = Integer.parseInt(request.getParameter("anoModelo"));
		double valor = Double.parseDouble(request.getParameter("valor"));
		carro.setAnoFabricacao(anoFabricacao);
		carro.setAnoModelo(anoModelo);
		carro.setValor(valor);
		
		carro.setDescricao(request.getParameter("descricao"));
		carro.setFotoCarro(request.getParameter("fotoCarro"));
		
		CarroDao.update(carro);
		
		CarroCreateAndFind carroCreateAndFind = new CarroCreateAndFind();
		carroCreateAndFind.doGet(request, response);
		//doGet(request, response);
	}

}
