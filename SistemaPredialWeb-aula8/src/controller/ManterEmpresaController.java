package controller;

import model.Empresa;
import service.EmpresaService;
import java.io.PrintWriter;

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

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Empresa Criada!</title></head><body>");
			out.println(	"id: "+empresa.getId()+"<br>");
			out.println(	"nome: "+empresa.getNome()+"<br>");
			out.println(	"fone: "+empresa.getCnpj()+"<br>");
			out.println(	"e-mail: "+empresa.getConjunto()+"<br>");
		    out.println("</body></html>");
		} // botao criar fim

		// botao deletar inicio
		if ("deletar".equals(pAcao)) {
			int pId = Integer.parseInt(pIdString);
			Empresa empresa = new Empresa();
			empresa.setId(pId);

			EmpresaService es = new EmpresaService();
			es.excluir(empresa.getId());
			empresa = es.carregar(empresa.getId());

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Empresa Deletada!</title></head><body>");
			out.println(	"id: "+empresa.getId()+"<br>");
			out.println(	"nome: "+empresa.getNome()+"<br>");
			out.println(	"fone: "+empresa.getCnpj()+"<br>");
			out.println(	"e-mail: "+empresa.getConjunto()+"<br>");
		    out.println("</body></html>");
		} // fim do botao deletar

		// botao carregar inicio
		if ("carregar".equals(pAcao)) {
			int pId = Integer.parseInt(pIdString);
			Empresa empresa = new Empresa();
			empresa.setId(pId);

			EmpresaService es = new EmpresaService();

			empresa = es.carregar(empresa.getId());

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Empresa</title></head><body>");
			out.println(	"id: "+empresa.getId()+"<br>");
			out.println(	"nome: "+empresa.getNome()+"<br>");
			out.println(	"fone: "+empresa.getCnpj()+"<br>");
			out.println(	"e-mail: "+empresa.getConjunto()+"<br>");
		    out.println("</body></html>");
		} // botao carregar fim
		
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
			
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Empresa Atualizada!</title></head><body>");
			out.println(	"id: "+empresa.getId()+"<br>");
			out.println(	"nome: "+empresa.getNome()+"<br>");
			out.println(	"fone: "+empresa.getCnpj()+"<br>");
			out.println(	"e-mail: "+empresa.getConjunto()+"<br>");
		    out.println("</body></html>");


			
		} //botao update fim
	}
}
