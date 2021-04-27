package br.uece.me.cucumber.passos;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.uece.me.mock.ViagemMock;
import br.uece.me.model.Viagem;
import br.uece.me.service.ViagemService;
import cucumber.api.java8.Pt;

public class ViagemTestePassos implements Pt{
	
	private Viagem viagem = null;
	
	private ViagemService viagemService = new ViagemService();
	
	public ViagemTestePassos() {
		
		Dado("a viagem criada sem data de embarque no embarque", () -> {
			viagem = ViagemMock.newViagem();
			viagem.setDataEmbarque(null);
		});

		Entao("é realizada a verificação da data de embarque e o sistema deve retornar {string}", (String retorno) -> {
			assertThatThrownBy(() -> {viagemService.registrarEmbarque(viagem);}).isInstanceOf(RuntimeException.class)
	        .hasMessageContaining(retorno);
		});

		Dado("a viagem criada sem estação de embarque no embarque", () -> {
			viagem = ViagemMock.newViagem();
			viagem.setEstacaoEmbarque(null);
		});

		Entao("é realizada a verificação da estação de embarque e o sistema deve retornar {string}", (String retorno) -> {
			assertThatThrownBy(() -> {viagemService.registrarEmbarque(viagem);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(retorno);
		});

		Dado("a viagem atualizada sem estação de desembarque no desembarque", () -> {
			viagem = ViagemMock.newViagem();
			viagem.setEstacaoDesembarque(null);
		});

		Entao("é realizada a verificação da estação de desembarque e o sistema deve retornar {string}", (String retorno) -> {
			assertThatThrownBy(() -> {viagemService.registrarDesembarque(viagem);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(retorno);
		});

		Dado("a viagem atualizada sem data de desembarque no desembarque", () -> {
			viagem = ViagemMock.newViagem();
			viagem.setDataDesembarque(null);
		});

		Entao("é realizada a verificação da data de desembarque e o sistema deve retornar {string}", (String retorno) -> {
			assertThatThrownBy(() -> {viagemService.registrarDesembarque(viagem);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(retorno);
		});

		Dado("a viagem atualizada com data de embarque {string} e data de desembarque {string}", (String dataEmbarque, String dataDesembarque) -> {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			Calendar embarque = Calendar.getInstance();
			embarque.setTime(sdf.parse(dataEmbarque));
			
			Calendar desembarque = Calendar.getInstance();
			desembarque.setTime(sdf.parse(dataDesembarque));
			
			viagem = ViagemMock.newViagem();
			viagem.setDataEmbarque(embarque.getTime());
			viagem.setDataDesembarque(desembarque.getTime());
		});

		Entao("é realizada a verificação das datas e o sistema deve retornar {string}", (String retorno) -> {
			assertThatThrownBy(() -> {viagemService.registrarDesembarque(viagem);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(retorno);
		});

		Dado("a viagem criada sem usuário no embarque", () -> {
			viagem = ViagemMock.newViagem();
			viagem.setUsuario(null);
		});

		Entao("é realizada a verificação do usuário no embarque e o sistema deve retornar {string}", (String retorno) -> {
			assertThatThrownBy(() -> {viagemService.validarEmbarque(viagem);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(retorno);
		});

		Dado("a viagem criada sem usuário no desembarque", () -> {
			viagem = ViagemMock.newViagem();
			viagem.setUsuario(null);
		});

		Entao("é realizada a verificação do usuário no desembarque e o sistema deve retornar {string}", (String retorno) -> {
			assertThatThrownBy(() -> {viagemService.validarDesembarque(viagem);}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(retorno);
		});
		
	}

}
