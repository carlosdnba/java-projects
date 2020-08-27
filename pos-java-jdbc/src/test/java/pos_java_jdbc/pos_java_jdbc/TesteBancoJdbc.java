package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	/*
	@Test
	public void initBanco() {
		
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("Lagertha");
		userposjava.setEmail("lagertha@email.com.uk");
		
		userPosDAO.salvar(userposjava);
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println("Nome: " + userposjava.getNome());
				System.out.println("Email: " + userposjava.getEmail());
				System.out.println("-----------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		
		try {
			
			Userposjava userposjava = dao.buscar(6L);
			
			System.out.println(userposjava);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			Userposjava objetoBanco = dao.buscar(3L);
			
			objetoBanco.setNome("Claudioberto");
			dao.atualizar(objetoBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initDeletar() {
		
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(8L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testeInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(21) 98735-1234");
		telefone.setTipo("Casa");
		telefone.setUsuario(3L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
		
		System.out.println("Salvo com sucesso!");
		
	}
	
	@Test
	public void testeCarregaFone() {
		
		UserPosDAO dao = new UserPosDAO();
		
		List <BeanUserFone> beanUserFones = dao.listaUserFone(15L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("--------------------------------------------------------------------------------------");
		}
	}
	*/

	@Test
	public void testeDeleteUserFone() {
		UserPosDAO dao = new UserPosDAO();

		dao.deleteFonesPorUser(3L);
	}
}













