package br.uece.me.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

	@DisplayName("Cada vez que o usuário entra no metrô o sistema deve "
			+ "registrar data de entrada na Viagem")
	@Test
	public void testeResgistroDataEnbarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setDataEmbarque(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> viagemService.registrarEmbarque(viagem));
		assertEquals("Data de embarque obrigatória no início da viagem", exception.getMessage(), "Erro ao validar embarque - Data de embarque obrigatória no início da viagem");
	}
	
	@DisplayName("Cada vez que o usuário entra no metrô o sistema deve "
			+ "registrar a estação/zona tarifária de embarque na Viagem")
	@Test
	public void testeResgistroEstacaoEmbarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setEstacaoEmbarque(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> viagemService.registrarEmbarque(viagem));
		assertEquals("Estacao de embarque é obrigatória no início da viagem", exception.getMessage(), "Erro ao validar embarque - Estacao de embarque é obrigatória no início da viagem");
	}
	
	@DisplayName("Cada vez que o usuário sai do metrô o sistema deve "
			+ "registrar a estação/zona tarifária de desembarque na Viagem")
	@Test
	public void testeEstacaoDesembarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setEstacaoDesembarque(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> viagemService.registrarDesembarque(viagem));
		assertEquals("Estacao de desembarque é obrigatória no fim da viagem", exception.getMessage(), "Erro ao validar desembarque - Estacao de desembarque é obrigatória no fim da viagem");
	}
	
	@DisplayName("Cada vez que o usuário sai do metrô o sistema deve "
			+ "registrar data de desembarque na Viagem")
	@Test
	public void testeDataDesembarque(){
		Viagem viagem = ViagemMock.newViagem();
		viagem.setDataDesembarque(null);
		
		Exception exception = assertThrows(RuntimeException.class, () -> viagemService.registrarDesembarque(viagem));
		assertEquals("Data de desembarque obrigatória no fim da viagem", exception.getMessage(), "Erro ao validar desembarque - Data de desembarque obrigatória no fim da viagem");
	}
	
	@DisplayName("Ao registrar a saída o horário nunca deve ser anterior ao de embarque")
	@Test
	public void testeHorarioDesembarque(){
		Viagem viagem = ViagemMock.newViagem();
		Util.setData(viagem.getDataEmbarque(), 1, 1, 2022, 11, 0);
		
		Exception exception = assertThrows(RuntimeException.class, () -> viagemService.registrarDesembarque(viagem));
		assertEquals("Data de desembarque não pode ser anterior ao embarque", exception.getMessage(), "Erro ao validar desembarque - Data de desembarque não pode ser anterior ao embarque");
	}

}
