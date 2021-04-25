package br.uece.me.testes;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

import br.uece.me.mock.ViagemMock;
import br.uece.me.model.Viagem;
import br.uece.me.service.ViagemService;
import br.uece.me.util.Util;

/**
 * US03: COMO usuário EU preciso passar o cartão na catraca PARA registrar minha viagem
 * 
 * @author israel.santos
 * @author marcos.eduardo
 */
public class ViagemTest {
	
	ViagemService viagemService = new ViagemService();

	@Test
//	@DisplayName("Cada vez que o usuário entra no metrô o sistema deve "
//			+ "registrar data de entrada na Viagem")
	public void testeResgistroDataEnbarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setDataEmbarque(null);
		
		assertThatThrownBy(() -> {viagemService.registrarEmbarque(viagem);}).isInstanceOf(RuntimeException.class)
        .hasMessageContaining("Data de embarque obrigatória no início da viagem");
		
	}
	
	@Test
//	@DisplayName("Cada vez que o usuário entra no metrô o sistema deve "
//			+ "registrar a estação/zona tarifária de embarque na Viagem")
	public void testeResgistroEstacaoEmbarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setEstacaoEmbarque(null);
		
		assertThatThrownBy(() -> {viagemService.registrarEmbarque(viagem);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Estacao de embarque é obrigatória no início da viagem");
	}
	
	@Test
//	@DisplayName("Cada vez que o usuário sai do metrô o sistema deve "
//			+ "registrar a estação/zona tarifária de desembarque na Viagem")
	public void testeEstacaoDesembarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setEstacaoDesembarque(null);
		
		assertThatThrownBy(() -> {viagemService.registrarDesembarque(viagem);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Estacao de desembarque é obrigatória no fim da viagem");
	}
	
	@Test
//	@DisplayName("Cada vez que o usuário sai do metrô o sistema deve "
//			+ "registrar data de desembarque na Viagem")
	public void testeDataDesembarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setDataDesembarque(null);
		
		assertThatThrownBy(() -> {viagemService.registrarDesembarque(viagem);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Data de desembarque obrigatória no fim da viagem");
	}
	
	@Test
//	@DisplayName("Ao registrar a saída o horário nunca deve ser anterior ao de embarque")
	public void testeHorarioDesembarque(){
		Viagem viagem = ViagemMock.newViagem();
		Util.setData(viagem.getDataEmbarque(), 1, 1, 2022, 11, 0);
		
		assertThatThrownBy(() -> {viagemService.registrarDesembarque(viagem);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Data de desembarque não pode ser anterior ao embarque");
	}

	@Test
//	@DisplayName("A viagem deve registrar o usuário que a realizou no embarque")
	public void testeUsuarioEmbarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setUsuario(null);
		
		assertThatThrownBy(() -> {viagemService.validarEmbarque(viagem);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Usuário obrigatório no registro da viagem");
	}
	
	@Test
//	@DisplayName("A viagem deve registrar o usuário que a realizou no desembarque")
	public void testeUsuarioDesembarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setUsuario(null);
		
		assertThatThrownBy(() -> {viagemService.validarDesembarque(viagem);}).isInstanceOf(RuntimeException.class)
		.hasMessageContaining("Usuário obrigatório no registro da viagem");
	}

}
