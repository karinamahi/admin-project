package br.com.project.admin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import dao.UsuarioDao;

//http://localhost:8080/admin-project/usuariocontroller.do
@WebServlet("/usuariocontroller.do")
public class UsuarioController extends HttpServlet {

	public UsuarioController() {
		System.out.println("Novo Servlet");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Init..");
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String acao = req.getParameter("acao");
		if (acao.equals("excluir")) {
			String id = req.getParameter("id");
			Usuario usuario = new Usuario();
			if (id != null)
				usuario.setId(Integer.parseInt(id));

			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.excluir(usuario);
			//resp.getWriter().print("<b>Excluído com sucesso!</b>");
			resp.sendRedirect("usuariocontroller.do?acao=listar");
			System.out.println("Chamou!" + req);
			
		} else if (acao.equals("listar")) {
			UsuarioDao usuarioDao = new UsuarioDao();
			List<Usuario> lista = usuarioDao.buscarTodos();

			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("WEB-INF/listausu.jsp");
			dispatcher.forward(req, resp);
			
		} else if(acao.equals("alt")){
			String id = req.getParameter("id");
			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario usuario = usuarioDao.buscarPorId(Integer.parseInt(id));
			req.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/usuarioform.jsp");
			dispatcher.forward(req, resp);
			
		}else if(acao.equals("cad")){
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setCpf("");
			usuario.setNome("");
			usuario.setRg("");
			usuario.setEmail("");
			usuario.setPerfil("");
			usuario.setSenha("");
			
			req.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/usuarioform.jsp");
			dispatcher.forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Chamou!");
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String cpf = req.getParameter("cpf");
		String rg = req.getParameter("rg");
		String perfil = req.getParameter("perfil");

		Usuario usuario = new Usuario();
		if (id != "")
			usuario.setId(Integer.parseInt(id));

		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setCpf(cpf);
		usuario.setRg(rg);
		usuario.setPerfil(perfil);

		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(usuario);
		resp.getWriter().print("<b>Sucesso!</b>");

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void destroy() {
		System.out.println("Destroy..");
		super.destroy();
	}
}
