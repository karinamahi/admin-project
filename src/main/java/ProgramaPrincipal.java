import dao.UsuarioDao;


public class ProgramaPrincipal {
	public static void main(String[] args) {
		UsuarioDao dao = new UsuarioDao();
		dao.ImprimiUsuarios();
	}
}
