package com.algaworks.algafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.model.input.CozinhaInput;
import com.algaworks.algafood.domain.model.Cozinha;


@Component
public class CozinhaInputDisassembler {

	@Autowired
	private ModelMapper modelmapper;
	
	public Cozinha toDomainObject(CozinhaInput cozinhaInput) {
		 return modelmapper.map(cozinhaInput, Cozinha.class);
		
	}
	
	public void copyToDomainObject (CozinhaInput cozinhaInput, Cozinha cozinha) {
		modelmapper.map(cozinhaInput, cozinha);
		
	}
}
