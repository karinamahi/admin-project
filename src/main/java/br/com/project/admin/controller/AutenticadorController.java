package br.com.project.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import model.Usuario;

@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		HttpSession sessao = req.getSession(false);
		
		if(sessao!=null){
			sessao.invalidate();
		}
		resp.sendRedirect("login.html");
	};
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1) Capturando dados da tela
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		// 2) Colocando dados em um objeto Usuario
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		// 3)Consultando se usuario existe no banco
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Usuario usuAutenticado = usuarioDao.autenticar(usuario);
		
		// 4) Verificando se o usuario foi encontrado
		if(usuAutenticado!=null){
			
			// 5) Colocando usuario na sessao
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuAutenticado",usuAutenticado);
			sessao.setMaxInactiveInterval(60*5);
			
			// 6) Redirecionando usuario para tela principal
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		}else {
			resp.getWriter().print("<script> window.alert ('Usu�rio n�o encontrado!'); location.href='login.html'</script>");
			
		}
		
	}
}
