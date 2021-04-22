package br.uece.me.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import br.uece.me.model.Pagamento;
import br.uece.me.model.Viagem;
import br.uece.me.model.enumeration.Tarifa;
import br.uece.me.model.enumeration.Zona;

public class PagamentoService {
	
	


	public BigDecimal calculaPagamentoInstantaneo(Viagem viagemAtual, List<Viagem> viagensAnteriores, Pagamento ultimoPagamentoDoPeriodo) {
		
		//List<Viagem> viagensParaAvaliacao = viagemRepository.viagensPorUsuarioEData(viagemAtual.getUsuario(), viagemAtual.getDataEmbarque());
		List<Viagem> viagensParaAvaliacao = viagensAnteriores;
		//Pagamento ultimoPagamento = pagamentoRepository.pagamentoPorUsuarioEData(viagemAtual.getUsuario(), viagemAtual.getDataEmbarque());
		Pagamento ultimoPagamento = ultimoPagamentoDoPeriodo;
		
		
		
		Tarifa tarifa = viagemAtual.getUsuario().getTarifa();
		
		Zona abrangencia = calculaAbrangenciaDeZona(viagensParaAvaliacao, viagemAtual);
		
		if (Tarifa.UNICO.equals(tarifa)){
			return calculoTarifaUnica(abrangencia, tarifa);
		}else {
			return calculaTarifaPeriodo(viagensParaAvaliacao, ultimoPagamento, abrangencia, tarifa);
		}
	}

	private BigDecimal calculaTarifaPeriodo(List<Viagem> viagensParaAvaliacao, Pagamento ultimoPagamento,
			Zona abrangencia, Tarifa tarifa) {
		if (Objects.isNull(viagensParaAvaliacao) || viagensParaAvaliacao.isEmpty()) {
			return calculoTarifaUnica(abrangencia, tarifa);
		}else {
			if (!Objects.isNull(ultimoPagamento) && 
					Zona.A.equals(ultimoPagamento.getAbrangencia()) &&
					Zona.B.equals(abrangencia)) {
				BigDecimal diferenca = tarifa.getValorZonaB().subtract(tarifa.getValorZonaA());
				return diferenca;
			}else {
				return new BigDecimal(0);
			}
		}
	}

	private BigDecimal calculoTarifaUnica(Zona abrangencia, Tarifa tarifa) {
		switch (abrangencia) {
			case A:
				return tarifa.getValorZonaA();
			case B:
				return tarifa.getValorZonaB();
			default:
				return tarifa.getValorZonaA();
		}
	}
	
	//Calcula se o usuário trafegou na Zona B ou só na A
	private Zona calculaAbrangenciaDeZona(List<Viagem> viagens, Viagem viagemAtual) {
		List<Viagem> viagensTmp = new LinkedList<Viagem>();
		viagensTmp.addAll(viagens);
		viagensTmp.add(viagemAtual);
		for (Viagem viagem: viagensTmp){
			if (!Objects.isNull(viagem.getEstacaoEmbarque()) && Zona.B.equals(viagem.getEstacaoEmbarque().getZona())) {
				return Zona.B;
			}
			if (!Objects.isNull(viagem.getEstacaoDesembarque()) && Zona.B.equals(viagem.getEstacaoDesembarque().getZona())) {
				return Zona.B;
			}
		};
		return Zona.A;
	}
	
	public void validarPagamento(Pagamento pagamento) {
		if(Objects.isNull(pagamento.getValor()))
			throw new RuntimeException("Valor obrigatório ao registrar o pagamento");
		
		if(Objects.isNull(pagamento.getAbrangencia()))
			throw new RuntimeException("Abrangencia obrigatória ao registrar o pagamento");
		
		if(Objects.isNull(pagamento.getUsuario()))
			throw new RuntimeException("Usuario obrigatório ao registrar o pagamento");
	}

	// Será executado cada vez que o usuário desembarcar
	public BigDecimal registrarPagamento(Viagem viagemAtual, List<Viagem> viagensAnteriores, Pagamento ultimoPagamentoDoPeriodo) {
		BigDecimal valorAPagar = calculaPagamentoInstantaneo(viagemAtual, viagensAnteriores, ultimoPagamentoDoPeriodo);
		
		if (valorAPagar.compareTo(new BigDecimal(0)) > 0) {
			Pagamento pagamento = new Pagamento();
			Zona abrangencia = calculaAbrangenciaDeZona(viagensAnteriores, viagemAtual);
			pagamento.setAbrangencia(abrangencia);
			pagamento.setValor(valorAPagar);
			pagamento.setUsuario(viagemAtual.getUsuario());
			
			validarPagamento(pagamento);
			
			//Tenta passar o cartao
			//Salva o pagamento no banco
		
		}
		
		return valorAPagar;
		
	}

}
