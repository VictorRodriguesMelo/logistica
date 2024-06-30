package com.logistica.entity;

public enum TiposVeiculos {
	caminhonete ("caminhonete"),
	caminhao("caminhao"),
	furgao("furgao");
	
	
  private String descricao;

  TiposVeiculos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
