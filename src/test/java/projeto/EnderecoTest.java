package projeto;

import java.util.List;

import org.junit.Test;

import com.projeto.model.models.Endereco;
import com.projeto.model.service.EnderecoService;

public class EnderecoTest {
	//@Test(expected = Exception.class)
	public void salvarEndereco() {
		Endereco endereco = new Endereco();
		endereco.setRua("Alameda das Rosas");
		endereco.setNumero(200);
		endereco.setBairro("Residencial");
		EnderecoService enderecoService = new EnderecoService();
		enderecoService.save(endereco);
		System.out.println("Salvando");
	}
	
	//@Test(expected = Exception.class)
	public void alterarEndereco() {
		Endereco endereco = new Endereco();
		EnderecoService enderecoService = new EnderecoService();
		endereco.setId(1);
		endereco.setRua("Alameda das Azaleias");
		endereco.setBairro("Residencial");
		endereco.setNumero(22);
		endereco.setComplemento("perto do mercado");
		enderecoService.update(endereco);
		System.out.println(endereco.toString());
		System.out.println("Alterando");
	}
	
	//@Test(expected = Exception.class)
	public void listarTodosEnderecos() {
		EnderecoService enderecoService = new EnderecoService();
		List<Endereco> listaEndereco = enderecoService.findAll();
		for(Endereco endereco : listaEndereco) {
			System.out.println(endereco.toString());
		}
	}
	@Test(expected = Exception.class)
	public void deletarEndereco() {
		Endereco endereco = new Endereco();
		EnderecoService enderecoService = new EnderecoService();
		endereco.setId(1);
		endereco = enderecoService.findById(endereco.getId());
		enderecoService.delete(endereco);
		System.out.println("Deletando");
	}
}
