package model;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
	
	@NamedQuery(name="UsuarioPessoa.todos", query="select u from UsuarioPessoa u")
	
})
public class UsuarioPessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private String sobrenome;
	private Integer idade;
	private String email;
	private String login;
	private String senha;
	
	@OneToMany(mappedBy = "usuarioPessoa")
	private List<TelefoneUser> telefoneUsers;
	
	public void setTelefoneUsers(List<TelefoneUser> telefoneUsers) {
		this.telefoneUsers = telefoneUsers;
	}
	
	public List<TelefoneUser> getTelefoneUsers() {
		return telefoneUsers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade
				+ ", email=" + email + ", login=" + login + ", senha=" + senha + "]";
	}

}
