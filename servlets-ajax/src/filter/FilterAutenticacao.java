package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.UserLogado;

// com essa anotação, o mapeamento fica mais simples porque não precisa ser feito no web.xml, facilitando caso hajam futuras alteraçoẽs
@WebFilter(urlPatterns= {"/pages/acessoSistema.jsp"}) 
public class FilterAutenticacao implements Filter {
	
	// faz alguma coisa quando a aplicação é derrubada
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
//		retorna null caso nao esteja logado
		UserLogado userLogado = (UserLogado) session.getAttribute("usuario");
		
		if (userLogado == null) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/autenticar.jsp");
			dispatcher.forward(request, response);
			return; // processo para redirecionar
		}
		
		chain.doFilter(request, response);
	}
	
	// faz alguma coisa quando a aplicação é iniciada
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
