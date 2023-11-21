package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarroDao;


@WebServlet("/CarroDelete")
public class CarroDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CarroDelete() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int carroId = Integer.parseInt(request.getParameter("carroId"));
		CarroDao.delete(carroId);
		
		CarroCreateAndFind carroCreateAndFind = new CarroCreateAndFind();
		carroCreateAndFind.doGet(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
