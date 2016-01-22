package dao;

import java.sql.Connection;
import java.sql.SQLException;

import model.Fornecedor;
import db.ConnectionFactoryPostreSQL;

public class FornecedorDAO {
	private Connection connection;
	
	public FornecedorDAO () {
		this.connection = (Connection) new ConnectionFactoryPostreSQL().getConnection();
	}
	
	public void addFornecedor(Fornecedor fornecedor){
		String sql = "insert into fornecedores " 
				+ "( cnpj, id, nome_fantasia, nome_empresarial)"
				+ "values( ?, nextval('sequence_teste'),?, ?)";
				
		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, fornecedor.getCnpj());
			stmt.setString(2, fornecedor.getNomeFantasia());
			stmt.setString(3, fornecedor.getNomeEmpresarial());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	} 
	
}
