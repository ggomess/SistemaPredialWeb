package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.JSONFunctions;
import model.Empresa;
import service.EmpresaService;
import Util.JsonFacade;


/**
 * Servlet implementation class JsonEmpresa
 */
@WebServlet("/JsonEmpresa")
public class JsonEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonEmpresa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		EmpresaService es = new EmpresaService();
		
		ArrayList<Empresa> lista = es.select();
		
		String json = JsonFacade.ToJSon(lista);
		
		PrintWriter out = response.getWriter();
		
		out.println(json);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			String json = JsonFacade.makeJSon(request);
			Empresa empresa = new Empresa();
			EmpresaService es = new EmpresaService();
			empresa = JsonFacade.FromJson(json, empresa);
			
			es.criar(empresa); 
			
			} catch(Exception ex) {
				throw ex;
			}
	}

}
