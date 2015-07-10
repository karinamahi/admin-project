package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

import com.mysql.jdbc.Connection;

import db.ConnectionFactory;

public class UsuarioDao {

	private Connection connection;

	public UsuarioDao() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void addUsuario(Usuario usuario) {
		String sql = "insert into usuario"
				+ "(cpf, rg, nome, email, perfil, senha)"
				+ "values(?,?,?,?,?,?)";

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

	private Usuario convertResultSet2Usuario(ResultSet result) {
		try {
			Usuario usuario = new Usuario();
			usuario.setCpf(result.getString("cpf"));
			usuario.setNome(result.getString("nome"));
			usuario.setRg(result.getString("rg"));
			usuario.setPerfil(result.getString("perfil"));
			usuario.setEmail(result.getString("email"));
			return usuario;

		} catch (SQLException e) {
			System.out.println("Erro");
			e.printStackTrace();
		}
		return null;
	}

	public List<Usuario> getLista() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("select * from usuario");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = convertResultSet2Usuario(rs);
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void ImprimiUsuarios() {
		List<Usuario> usuarios = getLista();

		for (Usuario usuario : usuarios) {
			System.out.println("CPF: " + usuario.getCpf());
			System.out.println("NOME: " + usuario.getNome());
			System.out.println("RG: " + usuario.getRg());
			System.out.println("EMAIL: " + usuario.getEmail());
			System.out.println("PERFIL: " + usuario.getPerfil() + "\n");
		}
	}
	
	public void salvar(Usuario usuario){
		if(usuario.getId()!= null){
			alterarUsuario(usuario);
		}else{
			addUsuario(usuario);
		}
	}

	public void alterarUsuario(Usuario usuario) {
		String sql = "update usuario set cpf=?, rg=?, nome=?, email=?, perfil=?, senha=? where id=?";

		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getRg());
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getPerfil());
			stmt.setString(6, usuario.getSenha());
			stmt.setInt(7, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
