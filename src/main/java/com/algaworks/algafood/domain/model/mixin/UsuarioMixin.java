package com.algaworks.algafood.domain.model.mixin;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UsuarioMixin {
	
	@JsonIgnore
	private LocalDateTime dataCadastro;
	

}
