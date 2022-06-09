package dev.ifrs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Paciente extends PanacheEntityBase{
    
    //private static final long serialVersionUID = 1L;
	
	// ver jwt

	//Atributos
	
    @Id
	@SequenceGenerator(
		name = "pacienteSeq",
		sequenceName = "pac_id_seq",	
		allocationSize = 1,
		initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacienteSeq")
	public Long id;
	
	private String nome;
	private String cpf;
	private String email;
	private String userLogin;
	private String userSenha;
	private String telefone;
	private String endereco;
	
	@OneToMany (cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name="Consultas_Pac")
	@JsonBackReference
	private Set<Consulta> consultas;

	
	//Contrutores
	//ver o construtor sem parametros
	public Paciente() {};
	public Paciente(String nome) {
		this.nome = nome;
	};
	
	public Paciente(String nome, String cpf, String email, String userLogin, String userSenha, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.userLogin = userLogin;
		this.userSenha = userSenha;
		this.endereco = endereco;
	}
	
	public Paciente(String nome, String cpf, String email, String userLogin, String userSenha, String endereco, Set<Consulta> consultas) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.userLogin = userLogin;
		this.userSenha = userSenha;
		this.endereco = endereco;
		this.consultas = consultas;
	}
	
	
	//Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	public String getUserSenha() {
		return userSenha;
	}
	public void setUserSenha(String userSenha) {
		this.userSenha = userSenha;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Set<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	public void addConsulta(Consulta consulta) {
		this.consultas.add(consulta);
	}


// funcoes
/*
login

criar usuario
marcar consulta
checar agenda



*/ 

    
}
