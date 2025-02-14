package com.logistica.entity;

import java.io.Serializable;
import java.util.Objects;

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
    private Integer distancia;
    private Boolean emAndamento;
    
    public Frete() {
    }

	public Frete(Integer codigoFrete, String tipoVeiculo, Integer distancia) {
		this.codigoFrete = codigoFrete;
		this.tipoVeiculo = tipoVeiculo;
		this.distancia = distancia;
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

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(Boolean emAndamento) {
		this.emAndamento = emAndamento;
	}

    @Override
	public int hashCode() {
		return Objects.hash(codigoFrete, distancia, id, taxa, tipoVeiculo, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frete other = (Frete) obj;
		return Objects.equals(codigoFrete, other.codigoFrete) && Objects.equals(distancia, other.distancia)
				&& Objects.equals(id, other.id) && Objects.equals(taxa, other.taxa)
				&& Objects.equals(tipoVeiculo, other.tipoVeiculo) && Objects.equals(valor, other.valor);
	}

}