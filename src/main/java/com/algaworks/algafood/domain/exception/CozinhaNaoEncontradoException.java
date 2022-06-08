package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CozinhaNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public CozinhaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	
	public CozinhaNaoEncontradoException(Long estadoId) {
		this(String.format("Não existe um cadastro de cozinha com codigo %d",estadoId));
	}

}
