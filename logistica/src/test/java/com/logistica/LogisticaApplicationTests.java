package com.logistica;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.logistica.controller.FreteController;
import com.logistica.controller.UsuarioController;
import com.logistica.controller.VeiculoController;
import com.logistica.entity.Usuario;
import com.logistica.entity.Veiculo;

@SpringBootTest
class LogisticaApplicationTests {
	
	@Autowired
	private FreteController freteController;
	
	@Autowired
    private UsuarioController usuarioController;
	
	@Autowired
	private VeiculoController veiculoController;
	
	@Test
	void contextLoads() {
		//testeFrete();
		testeUsuario();
		testeVeiculo();
	}
	
	/*public void testeFrete() {
		Frete frete = new Frete(1, "caminhonete", 1000);
		freteController.registerFrete(frete);
		
		List<Frete> listaFretes = freteController.getFrete();
		for(Frete item : listaFretes) {
			System.out.println("##### DISTANCIA: " + item.getDistancia());
			System.out.println("##### EM ANDAMENTO: " + item.getEmAndamento());
		}
	}*/
	
	public void testeUsuario() {
		Usuario usuarioJoao = new Usuario(null, 10, "João Paulo");
		usuarioController.registerUsuario(usuarioJoao);
		
		List <Usuario> listaUsuario = usuarioController.getUsuario();
		for(Usuario item : listaUsuario) {
			System.out.println("##### NOME USUARIO: " + item.getNome());
		}
	}
	
	public void testeVeiculo() {
		Veiculo veiculoCaminhonete = new Veiculo(null, "caminhonete", "bbb-2020");
		veiculoController.registerVeiculo(veiculoCaminhonete);
		
		List<Veiculo> listaVeiculos = veiculoController.getVeiculo();
		for(Veiculo item : listaVeiculos) {
			System.out.println("##### NOME VEÍCULO: " +item.getName());
		}
	}
}
