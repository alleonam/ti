package app;

import java.util.*;

import dao.AlunoDAO;
import model.Aluno;

public class Aplicacao
{
	public static Scanner sc = new Scanner(System.in);
	
	public static int opcao()
	{
		int opcao;
		boolean ERRO;
		
		do
		{
			System.out.println("\n\n==== Opcoes ===");
			System.out.println("[1] Inserir");
			System.out.println("[2] Listar");
			System.out.println("[3] Atualizar");
			System.out.println("[4] Exluir");
			System.out.println("[5] Sair");
			
			opcao = sc.nextInt();
			
			ERRO = opcao < 1 || opcao > 5;
			
			if(ERRO)
				System.out.println("Opcao invalida.");
		} while(ERRO);
		
		return opcao;
	}
	
	public static void main(String[] args)
	{
		
		int opcao;
		
		do
		{
			opcao = opcao();
			
			switch(opcao)
			{
			case 1:
				inserir();
				break;
			case 2:
				listar();
				break;
			case 3:
				atualizar();
				break;
			case 4:
				excluir();
				break;
			case 5:
				System.out.println("Opcao sair selecionada.");
				break;
			}
		} while(opcao != 5);
	}
	
	public static void inserir()
	{
		int matricula;
		String nome;
		String senha;
		int idade;
		char sexo;
		int telefone;
		
		System.out.println("\n\n==== Inserir aluno === ");
		System.out.println("Entrar com matricula: ");
		matricula = sc.nextInt();
		System.out.println("Entrar com nome: ");
		nome = sc.next();
		System.out.println("Entrar com senha: ");
		senha = sc.next();
		System.out.println("Entrar com idade: ");
		idade = sc.nextInt();
		System.out.println("Entrar com sexo: ");
		sexo = sc.next().charAt(0);
		System.out.println("Entrar com telefone: ");
		telefone = sc.nextInt();
		
		Aluno aluno = new Aluno(matricula, nome, senha, idade, sexo, telefone);
		
		if(AlunoDAO.insert(aluno))
			System.out.println("Inserção com sucesso -> " + aluno);
	}
	
	public static void listar()
	{
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> alunos = alunoDAO.getOrderByMatricula();
		
		System.out.println("\n\n==== Mostrar alunos ordenados por matrícula === ");
		
		for (Aluno a: alunos)
		{
			System.out.println(a.toString());
		}
		
		System.out.println("\n\n==== Mostrar alunos ordenados por nome === ");
		
		alunos = alunoDAO.getOrderByNome();
		
		for (Aluno a: alunos)
		{
			System.out.println(a.toString());
		}
		
		System.out.println("\n\n==== Mostrar alunos ordenados por idade === ");
		
		alunos = alunoDAO.getOrderByIdade();
		
		for (Aluno a: alunos)
		{
			System.out.println(a.toString());
		}
		
		System.out.println("\n\n==== Mostrar alunos ordenados por sexo === ");
		
		alunos = alunoDAO.getOrderBySexo();
		
		for (Aluno a: alunos)
		{
			System.out.println(a.toString());
		}
		
		System.out.println("\n\n==== Mostrar alunos ordenados por telefone === ");
		
		alunos = alunoDAO.getOrderByTelefone();
		
		for (Aluno a: alunos)
		{
			System.out.println(a.toString());
		}
	}
	
	public static void atualizar()
	{
		int matricula;
		String nome;
		String senha;
		int idade;
		char sexo;
		int telefone;
		
		System.out.println("\n\n==== Atualizar aluno ===");
		listar();
		System.out.println("Entrar com matricula que deseja atualizar: ");
		matricula = sc.nextInt();
		System.out.println("Entrar com nome: ");
		nome = sc.next();
		System.out.println("Entrar com senha: ");
		senha = sc.next();
		System.out.println("Entrar com idade: ");
		idade = sc.nextInt();
		System.out.println("Entrar com sexo: ");
		sexo = sc.next().charAt(0);
		System.out.println("Entrar com telefone: ");
		telefone = sc.nextInt();
		
		Aluno aluno = new Aluno(matricula, nome, senha, idade, sexo, telefone);
		
		AlunoDAO.update(aluno);
	}
	
	public static void excluir()
	{
		int matricula;
		
		System.out.println("\n\n==== Excluir aluno ===");
		listar();
		System.out.println("Entrar com matricula que deseja excluir:");
		matricula = sc.nextInt();
		
		AlunoDAO.delete(matricula);
	}
}
