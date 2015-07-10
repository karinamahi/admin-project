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
	public void init(){
		dao = new UsuarioDao();
	}
	
	@Test
	public void deveAdicionarUmUsuario(){
		Usuario usuario = new Usuario();	
		usuario.setCpf("111222333");
		usuario.setRg("121212");
		usuario.setNome("Karina");
		usuario.setEmail("karina@test.com");
		usuario.setPerfil("master");
		usuario.setSenha("123");
		
		UsuarioDao dao = new UsuarioDao();
		dao.addUsuario(usuario);
		
		System.out.println("Usuário adicionado com sucesso!");
	}
	
	@Test
	public void deveRetornarTodosOsUsuarios(){
		List<Usuario> usuarios = dao.getLista();
		
		Assert.assertNotNull(usuarios);
		Assert.assertTrue(usuarios.size()>0);
		for(Usuario usuario : usuarios){
			System.out.println("CPF: " + usuario.getCpf());
			System.out.println("NOME: " + usuario.getNome());
			System.out.println("RG: " + usuario.getRg());
			System.out.println("EMAIL: " + usuario.getEmail());
			System.out.println("PERFIL: " + usuario.getPerfil() + "\n");
		}
	}
	@Test
	public void deveAlterarUsuario(){
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
}
