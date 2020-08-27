package excecoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class capturarExcecao
 */
@WebServlet("/pages/capturarExcecoes")
public class CapturarExcecao extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CapturarExcecao() {
    	super();
    }

    
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			System.out.println(request.getParameter("valorParam"));
			
			response.setStatus(200);
			response.getWriter().write("Processada com sucesso.");
		} catch (Exception e) {
			
			response.getWriter().write("Falha no processamento");
			response.setStatus(500);
		}
	}	
}
