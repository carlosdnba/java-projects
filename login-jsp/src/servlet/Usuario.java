package servlet;

import beans.BeanCursoJsp;
import dao.DaoUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@WebServlet(value = "/SalvarUsuario")
public class Usuario extends HttpServlet {

	private static final long serialVersionUI = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public Usuario() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String acao = req.getParameter("acao");

			String user = req.getParameter("user");


			if (acao.equalsIgnoreCase("delete")) {
				this.daoUsuario.delete(user);

				RequestDispatcher view = req.getRequestDispatcher("/cadastroUser.jsp");
				req.setAttribute("usuarios", this.daoUsuario.listar());

				view.forward(req, resp);

			} else if (acao.equalsIgnoreCase("editar")) {
				BeanCursoJsp beanCursoJsp = this.daoUsuario.consultar(user);


				RequestDispatcher view = req.getRequestDispatcher("/cadastroUser.jsp");
				req.setAttribute("user", beanCursoJsp);

				view.forward(req, resp);

			} else if (acao.equalsIgnoreCase("listartodos")) {

				RequestDispatcher view = req.getRequestDispatcher("/cadastroUser.jsp");
				req.setAttribute("usuarios", this.daoUsuario.listar());
				view.forward(req, resp);
			}


		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = req.getParameter("acao");

		if (acao != null && !acao.equalsIgnoreCase("reset")) {
			try {
				RequestDispatcher view = req.getRequestDispatcher("/cadastroUser.jsp");
				req.setAttribute("usuarios", this.daoUsuario.listar());

				view.forward(req, resp);
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			String id = req.getParameter("id");
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");
			String nome = req.getParameter("nome");
			String telefone = req.getParameter("telefone");
			String cep = req.getParameter("cep");
			String rua = req.getParameter("rua");
			String bairro = req.getParameter("bairro");
			String cidade = req.getParameter("cidade");
			String estado = req.getParameter("estado");

			BeanCursoJsp usuario = new BeanCursoJsp();
			usuario.setId(id.isEmpty() ? null : Long.parseLong(id));
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setNome(nome);
			usuario.setTelefone(telefone);
			usuario.setCep(cep);
			usuario.setRua(rua);
			usuario.setEstado(estado);
			usuario.setBairro(bairro);
			usuario.setCidade(cidade);

			try {
				
				if (ServletFileUpload.isMultipartContent(req)) {
					
					List<FileItem> fileItems = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
					
					for (FileItem fileItem : fileItems) {
						if (fileItem.getFieldName().equals("foto")) {
							
							new Base64();
							String fotoBase64 = Base64.encodeBase64String(fileItem.get());
							String contentType = fileItem.getContentType();
							
							usuario.setFotoBase64(fotoBase64);
							usuario.setContentType(contentType);
						}
						
					}
				}
				

				if (id == null || id.isEmpty() && !daoUsuario.validarLogin(login)) {
					req.setAttribute("msg", "Usuario já existe com mesmo login");
				}
				if (id == null || id.isEmpty() && daoUsuario.validarLogin(login)) {

					this.daoUsuario.salvarUsuario(usuario);
				} else if (id != null || id.isEmpty() && daoUsuario.validarLogin(login)) {
					this.daoUsuario.atualizar(usuario);
				}

				RequestDispatcher view = req.getRequestDispatcher("/cadastroUser.jsp");
				req.setAttribute("usuarios", this.daoUsuario.listar());

				view.forward(req, resp);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}
