package br.com.pacotaogames.entities.enums;

public enum GeneroType {

	ACAO("AÇÃO"), 
	AVENTURA("AVENTURA"), 
	PRIMEIRA_PESSOA("PRIMEIRA PESSOA"), 
	LUTA("LUTA"),
	ESPORTES("ESPORTES");
	
	private String label;

	private GeneroType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
