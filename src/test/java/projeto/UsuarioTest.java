package projeto;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.projeto.model.models.Usuario;
import com.projeto.model.service.UsuarioService;

public class UsuarioTest {
	//@Test(expected = Exception.class)
	public void salvarUsuarioBancoDadosTeste() {
		Usuario usuario = new Usuario();
		usuario.setUsername("Abner");
		usuario.setPassword("12345");
		usuario.setEmail("abner.henrique22@gmail.com");
		usuario.setAtivo(false);
		usuario.setAdmin(false);
		
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.save(usuario);
		System.out.println("Salvando");
	}

	@Test(expected = Exception.class)
	public void alterarUsuarioBancoDadosTeste() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setEmail("abnerh@gmail.com");
		
		UsuarioService usuarioService = new UsuarioService();
		usuario = usuarioService.findById(usuario.getId());
		
		usuarioService.update(usuario);
		System.out.println("Alterando");
	}
}
