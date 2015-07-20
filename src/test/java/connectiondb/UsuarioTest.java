package connectiondb;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.UsuarioDao;
import model.Usuario;

public class UsuarioTest {
	private UsuarioDao dao = null;

	@Before
	public void init() {
		dao = new UsuarioDao();
	}

	@Test
	public void deveAdicionarUmUsuario() {
		Usuario usuario = new Usuario();
		usuario.setCpf("999");
		usuario.setRg("99");
		usuario.setNome("Zé");
		usuario.setEmail("ze@test.com");
		usuario.setPerfil("Analista");
		usuario.setSenha("999");

		UsuarioDao dao = new UsuarioDao();
		dao.addUsuario(usuario);

		System.out.println("Usuário adicionado com sucesso!");
	}

	@Test
	public void deveRetornarTodosOsUsuarios() {
		List<Usuario> usuarios = dao.getLista();

		Assert.assertNotNull(usuarios);
		Assert.assertTrue(usuarios.size() > 0);
		for (Usuario usuario : usuarios) {
			System.out.println("CPF: " + usuario.getCpf());
			System.out.println("NOME: " + usuario.getNome());
			System.out.println("RG: " + usuario.getRg());
			System.out.println("EMAIL: " + usuario.getEmail());
			System.out.println("PERFIL: " + usuario.getPerfil() + "\n");
		}
	}

	@Test
	public void deveAlterarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setCpf("123");
		usuario.setEmail("ka@test.com");
		usuario.setRg("111");
		usuario.setPerfil("Analista");
		usuario.setNome("Katia");
		usuario.setSenha("katia123");
		usuario.setId(3);
		UsuarioDao dao = new UsuarioDao();
		dao.alterarUsuario(usuario);
		System.out.println("Usuário alterado com sucesso!");
	}

	@Test
	public void deveSalvarUsuario() {
		Usuario usuario = new Usuario();
		// usuario.setId(2);
		usuario.setNome("Pedro");
		usuario.setCpf("555");
		usuario.setRg("51");
		usuario.setEmail("pedro@pedro");
		usuario.setSenha("123");
		usuario.setPerfil("Analista");

		UsuarioDao dao = new UsuarioDao();
		dao.salvar(usuario);
		System.out.println("Salvo com sucesso!");
	}

	@Test
	public void deveBuscarPorId() {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.buscarPorId(30);
		System.out.println(usuario);
	}
	
	@Test
	public void deveBuscarTodosUsuarios() {
		UsuarioDao dao = new UsuarioDao();
		List<Usuario> lista = dao.buscarTodos();
		for(Usuario u:lista){
			System.out.println(u);
		}
	}
	
	@Test
	public void deveAutenticarUsuario(){
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();
		usuario.setEmail("maria@maria");
		usuario.setSenha("1414");
		Usuario usuRetorno = dao.autenticar(usuario);
		System.out.println(usuRetorno);
	}
}
