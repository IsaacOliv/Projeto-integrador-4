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


@WebServlet("/CarroCreateAndFind")
public class CarroCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarroCreateAndFind() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");
		if(pesquisa == null) {
			pesquisa="";
		}
		List<Carro> carros = CarroDao.find(pesquisa);
		
		request.setAttribute("Carros", carros);
		RequestDispatcher requestDispathcer = request.getRequestDispatcher("carros-lista.jsp");
		requestDispathcer.forward(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carro carro = new Carro();
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
		
		CarroDao.create(carro);
  
		doGet(request, response);
	}

}
