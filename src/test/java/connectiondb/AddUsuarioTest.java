package connectiondb;

import dao.UsuarioDao;
import model.Usuario;

public class AddUsuarioTest {
	
	public static void main(String[] args) {
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
}
