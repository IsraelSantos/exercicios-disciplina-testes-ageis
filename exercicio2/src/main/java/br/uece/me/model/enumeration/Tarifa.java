package br.uece.me.model.enumeration;

import java.math.BigDecimal;

public enum Tarifa {
	UNICO("Único", new BigDecimal(6.0), new BigDecimal(7.0)), 
	DIARIO("Diário", new BigDecimal(10.0), new BigDecimal(12.0)),
	SEMANAL("Semanal", new BigDecimal(30.0), new BigDecimal(45.0)), 
	MENSAL("Mensal", new BigDecimal(130.0), new BigDecimal(170.0));
	
	String nome;
	BigDecimal valorZonaA;
	BigDecimal valorZonaB;
	
	Tarifa(String nome, BigDecimal valorZonaA, BigDecimal valorZonaB){
		this.nome = nome;
		this.valorZonaA = valorZonaA;
		this.valorZonaB = valorZonaB;
	}

	public BigDecimal getValorZonaA() {
		return this.valorZonaA;
	}

	public BigDecimal getValorZonaB() {
		return this.valorZonaB;
	}
}
