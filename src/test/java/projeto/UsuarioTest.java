package projeto;

import java.util.List;

import org.junit.Test;

import com.projeto.model.models.Usuario;
import com.projeto.model.service.UsuarioService;

public class UsuarioTest {
	//@Test(expected = Exception.class)
	public void salvarUsuarioBancoDadosTeste() {
		Usuario usuario = new Usuario();
		usuario.setUsername("Beatriz <3");
		usuario.setPassword("miudinha");
		usuario.setEmail("cristina.b@gmail.com");
		usuario.setAtivo(true);
		usuario.setAdmin(false);
		
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.save(usuario);
		System.out.println("Salvando");
	}

	@Test(expected = Exception.class)
	public void alterarUsuarioBancoDadosTeste() {
		Usuario usuario = new Usuario();
		usuario.setId(2);
		usuario.setEmail("meuamor@gmail.com");
		
		UsuarioService usuarioService = new UsuarioService();
		usuario = usuarioService.findById(usuario.getId());
		
		usuarioService.update(usuario);
		System.out.println("Alterando");
	}
	
	//@Test(expected = Exception.class)
	public void listarTodosUsuarioTabelaUsuario() {
		UsuarioService usuarioService = new UsuarioService();
		List<Usuario> listaUsuario = usuarioService.findAll();
		for(Usuario usuario : listaUsuario) {
			System.out.println(usuario.toString());
		}
	}
	
	//@Test(expected = Exception.class)
	public void excluirUsuarioDaTabela() {
		Usuario usuario = new Usuario();
		usuario.setId(2);
		UsuarioService usuarioService = new UsuarioService();
		usuario = usuarioService.findById(usuario.getId());
		usuarioService.delete(usuario);
			
	}
}
