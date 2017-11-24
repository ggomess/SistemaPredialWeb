package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import service.EmpresaService; 

/**
 * Servlet implementation class ManterEmpresaController
 */
@WebServlet("/ManterCliente.do")
public class ManterEmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pIdString = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pCnpj = request.getParameter("cnpj");
		String pConjunto = request.getParameter("conjunto");
		String pAcao = request.getParameter("acao");

		

		// Botao de criar ini
		if ("criar".equals(pAcao)) {
			Empresa empresa = new Empresa();
			empresa.setNome(pNome);
			empresa.setCnpj(pCnpj);
			empresa.setConjunto(pConjunto);

			EmpresaService es = new EmpresaService();
			es.criar(empresa);
			empresa = es.carregar(empresa.getId());

			request.setAttribute("empresa", empresa);

			RequestDispatcher view = request.getRequestDispatcher("Empresa.jsp");
			view.forward(request, response);
		} // botao criar fim

		
		// botao carregar inicio
		if ("carregar".equals(pAcao)) {
			int pId = Integer.parseInt(pIdString);
			Empresa empresa = new Empresa();
			empresa.setId(pId);

			EmpresaService es = new EmpresaService();

			empresa = es.carregar(empresa.getId());

			request.setAttribute("empresa", empresa);

			RequestDispatcher view = request.getRequestDispatcher("Empresa.jsp");
			view.forward(request, response);
		} // botao carregar fim
		
		// botao deltar inicio
		if ("deletar".equals(pAcao)) {
			int pId = Integer.parseInt(pIdString);
			Empresa empresa = new Empresa();
			empresa.setId(pId);
				
			EmpresaService es = new EmpresaService();
			es.excluir(empresa.getId());
			empresa = es.carregar(empresa.getId());

			request.setAttribute("empresa", empresa);

			RequestDispatcher view = request.getRequestDispatcher("Empresa.jsp");
			view.forward(request, response);
		} // fim do botao deletar

		
		//botao update inicio
		if ("atualizar".equals(pAcao)) {
			int pId = Integer.parseInt(pIdString);
			Empresa empresa = new Empresa();
			empresa.setId(pId);
			empresa.setNome(pNome);
			empresa.setCnpj(pCnpj);
			empresa.setConjunto(pConjunto);

			EmpresaService es = new EmpresaService();
			es.atualizar(empresa);
			empresa = es.carregar(empresa.getId());

			request.setAttribute("empresa", empresa);

			RequestDispatcher view = request.getRequestDispatcher("Empresa.jsp");
			view.forward(request, response);
		} //botao update fim
	}
}
