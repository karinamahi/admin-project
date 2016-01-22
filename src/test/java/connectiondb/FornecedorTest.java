package connectiondb;

import org.junit.Before;
import org.junit.Test;

import model.Fornecedor;
import dao.FornecedorDAO;

public class FornecedorTest {
	private FornecedorDAO dao = null;
	
	@Before
	public void init() {
		dao = new FornecedorDAO();
	}
	
	@Test
	public void deveAdicionarUmFornecedor() {
		Fornecedor forn = new Fornecedor();
		forn.setCnpj("123.123.123-12");
		forn.setNomeEmpresarial("Empresa Ltda");
		forn.setNomeFantasia("Empresa Legal");
		
		FornecedorDAO dao = new FornecedorDAO();
		dao.addFornecedor(forn);
		
		System.out.println("Fornecedor adicionado com sucesso");
	}
}
