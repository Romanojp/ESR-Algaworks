package com.algaworks.algafood.domain.model.mixin;

import com.algaworks.algafood.domain.model.Estado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CidadeMixin {
	
	@JsonIgnoreProperties("nome")
	private Estado estado;

}
