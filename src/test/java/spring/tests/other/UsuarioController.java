package spring.tests.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Usuario;
import dao.UsuarioDao;

@Component
public class UsuarioController {
	@Autowired
	private UsuarioDao usuarioDao;
	public UsuarioController(){
		System.out.println("Novo Servlet");
	}
	
	public void salvar(Usuario usuario){
		usuarioDao.salvar(usuario);
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
}
