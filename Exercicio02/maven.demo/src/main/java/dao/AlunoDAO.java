package dao;

import java.sql.*;
import java.util.*;
import model.Aluno;

public class AlunoDAO extends DAO {
	
	public AlunoDAO() {
		super();
		conectar();
	}

	protected void finalize() {
		close();
	}
	
	
	public static boolean insert(Aluno aluno) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO aluno (matricula, nome, senha, idade, sexo, telefone) "
				       + "VALUES ("+ aluno.getMatricula() + ", '" + aluno.getNome() + "', '"  
				       + aluno.getSenha() + "', '" + aluno.getIdade() + "', '" + aluno.getSexo() + "', '"
				       + aluno.getTelefone() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Aluno get(int matricula) {
		Aluno aluno = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + matricula;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 aluno = new Aluno(rs.getInt("matricula"), rs.getString("nome"), rs.getString("senha"), rs.getInt("idade"), rs.getString("sexo").charAt(0), rs.getInt("telefone"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return aluno;
	}
	
	
	public List<Aluno> get() {
		return get("");
	}

	
	public List<Aluno> getOrderByMatricula() {
		return get("matricula");		
	}
	
	
	public List<Aluno> getOrderByNome() {
		return get("nome");		
	}
	
	
	public List<Aluno> getOrderByIdade() {
		return get("idade");		
	}

	
	public List<Aluno> getOrderBySexo() {
		return get("sexo");		
	}	
	
	public List<Aluno> getOrderByTelefone() {
		return get("telefone");		
	}
	
	private List<Aluno> get(String orderBy) {	
	
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM aluno" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Aluno u = new Aluno(rs.getInt("matricula"), rs.getString("nome"), rs.getString("senha"), rs.getInt("idade"), rs.getString("sexo").charAt(0), rs.getInt("telefone"));
	            alunos.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return alunos;
	}
	
	
	public static boolean update(Aluno aluno) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE aluno SET nome = '" + aluno.getNome() + "', senha = '"  
				       + aluno.getSenha() + "', sexo = '" + aluno.getSexo() + "'"
					   + " WHERE matricula = " + aluno.getMatricula();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public static boolean delete(int matricula) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM aluno WHERE matricula = " + matricula;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public static boolean autenticar(String nome, String senha) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM aluno WHERE nome LIKE '" + nome + "' AND senha LIKE '" + senha  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}
}
