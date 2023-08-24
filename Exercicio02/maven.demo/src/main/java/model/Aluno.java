package model;

public class Aluno
{
	private int matricula;
	private String nome;
	private String senha;
	private int idade;
	private char sexo;
	private int telefone;
	
	public Aluno() {
		this.matricula = -1;
		this.nome = "";
		this.senha = "";
		this.idade = -1;
		this.sexo = '*';
		this.telefone = -1;
	}
	
	public Aluno(int matricula, String nome, String senha, int idade, char sexo, int telefone)
	{
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
		this.idade = idade;
		this.sexo = sexo;
		this.telefone = telefone;
	}

	public int getMatricula()
	{
		return matricula;
	}

	public void setMatricula(int matricula)
	{
		this.matricula = matricula;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	public int getIdade()
	{
		return idade;
	}

	public void setIdade(int idade)
	{
		this.idade = idade;
	}

	public char getSexo()
	{
		return sexo;
	}

	public void setSexo(char sexo)
	{
		this.sexo = sexo;
	}
	
	public int getTelefone()
	{
		return telefone;
	}

	public void setTelefone(int telefone)
	{
		this.telefone = telefone;
	}

	@Override
	public String toString()
	{
		return "Usuario [Matricula: " + matricula + "] [Nome: " + nome + "] [Senha: " + senha + "] [Idade: " + idade + "] [Sexo: " + sexo + "] [Telefone: " + telefone + "]";
	}
	
}
