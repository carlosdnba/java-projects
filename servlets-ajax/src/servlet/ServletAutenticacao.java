package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserLogado;

@WebServlet("/pages/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAutenticacao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		String url = request.getParameter("url");
		
//		aqui vai rolar uma validaçao de banco de dados mais tarde
		if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
//			se o login der bom
			UserLogado userLogado = new UserLogado();
			userLogado.setLogin(login);
			userLogado.setSenha(senha);

//			adiciona o usuario logado na sessão
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.setAttribute("usuario", userLogado);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/autenticar.jsp");
			dispatcher.forward(request, response);
		}
	
	
	}

}
