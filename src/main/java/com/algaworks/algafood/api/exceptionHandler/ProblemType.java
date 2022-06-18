package com.algaworks.algafood.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel","Mensagem Incompreensivel"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado","Recurso não encontrada"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio","Violação de regra de negocio"),
	PARAMETRO_INVALIDO("/parametro-invalido","Parametro Invalido"),
	ERRO_DE_SISTEMA("/erro-de-sistema","Erro de Sistema");
	
	private String title;
	private String uri;
	
	
	
	private ProblemType(String path, String title) {
		this.uri="hattps://algafood.com.br" + path;
		this.title = title;
	}
	
	

}
