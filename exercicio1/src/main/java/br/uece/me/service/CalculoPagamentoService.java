package br.uece.me.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import br.uece.me.model.Viagem;
import br.uece.me.model.enumeration.Tarifa;
import br.uece.me.model.enumeration.Zona;

public class CalculoPagamentoService {
	
	


	public BigDecimal calculaPagamentoInstantaneo(Viagem novaViagem, List<Viagem> viagensAnteriores) {
		
		//List<Viagem> viagensParaAvaliacao = viagemRepository.viagensPorUsuarioEData(novaViagem.getUsuario(), novaViagem.getDataEmbarque());
		List<Viagem> viagensParaAvaliacao = viagensAnteriores;
		
		BigDecimal res = new BigDecimal(0);
		
		Tarifa tarifa = novaViagem.getUsuario().getTarifa();
		
		Zona abrangencia = calculaAbrangenciaDeZona(viagensParaAvaliacao);
		
		switch (tarifa) {
		case UNICO:
			
			break;
		case DIARIO:
			
			break;
		case SEMANAL:
			
			break;
		case MENSAL:
			
			break;

		default:
			break;
		}
		
		return res;
	}
	
	//Calcula se o usuário trafegou na Zona B ou só na A
	private Zona calculaAbrangenciaDeZona(List<Viagem> viagens) {
		for (Viagem viagem: viagens){
			if (!Objects.isNull(viagem.getEstacaoEmbarque()) && Zona.B.equals(viagem.getEstacaoEmbarque().getZona())) {
				return Zona.B;
			}
			if (!Objects.isNull(viagem.getEstacaoDesembarque()) && Zona.B.equals(viagem.getEstacaoDesembarque().getZona())) {
				return Zona.B;
			}
		};
		return Zona.A;
	}

}
