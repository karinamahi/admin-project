package dao;

import java.sql.SQLException;

import model.Usuario;

import com.mysql.jdbc.Connection;

import db.ConnectionFactory;

public class UsuarioDao {
	
	private Connection connection;	
	
	public UsuarioDao(){
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
	 public void addUsuario(Usuario usuario){
		 String sql = "insert into usuario" + "(cpf, rg, nome, email, perfil, senha)" + "values(?,?,?,?,?,?)";
		 
		 try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getRg());
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getPerfil());
			stmt.setString(6, usuario.getSenha());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	 }
	
}
