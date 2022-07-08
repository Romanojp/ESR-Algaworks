package com.algaworks.algafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.model.input.CidadeInput;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;

@Component
public class CidadeInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Cidade toDomainObject(CidadeInput cidadeInput) {

		return modelMapper.map(cidadeInput, Cidade.class);

	}

	public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade) {
		//para evitar org.hibernate.HibernateException: identifier of 
		//com.algaworks.algafood.domain.model,Cozinha was altered 1 to 2
		cidade.setEstado(new Estado());
		
		modelMapper.map(cidadeInput, cidade);

	}

}
