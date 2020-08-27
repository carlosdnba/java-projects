package servlet;

import dao.DaoLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	
    private static final long serialVersionUI = 1L;

    // utiliza o metodo daoLogin criado
    private DaoLogin daoLogin = new DaoLogin();

    public LoginServlet() {
    	super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    	// recebe o login e a senha do front
    	String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        RequestDispatcher dispatcher;

        try {
        	
        	// verifica se o login e a senha existem e encaminha para as respectivas paginas
            if (this.daoLogin.validarLogin(login, senha)) {
                dispatcher = req.getRequestDispatcher("acesso_liberado.jsp");
            } else {
                dispatcher = req.getRequestDispatcher("acesso_negado.jsp");
            }

            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
