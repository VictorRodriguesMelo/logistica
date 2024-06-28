package com.logistica.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Frete")
@Getter
@Setter
public class Frete implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer codigoFrete;
    private Double valor;
    private Double taxa;
    private String tipoVeiculo;
    private Veiculo veiculo;
    
	public Frete(Long id, Integer codigoFrete, Double valor, Double taxa, String tipoVeiculo, Veiculo veiculo) {
		super();
		this.id = id;
		this.codigoFrete = codigoFrete;
		this.valor = valor;
		this.taxa = taxa;
		this.tipoVeiculo = tipoVeiculo;
		this.veiculo = veiculo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCodigoFrete() {
		return codigoFrete;
	}
	public void setCodigoFrete(Integer codigoFrete) {
		this.codigoFrete = codigoFrete;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getTaxa() {
		return taxa;
	}
	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}