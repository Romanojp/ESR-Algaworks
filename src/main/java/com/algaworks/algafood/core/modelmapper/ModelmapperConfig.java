package com.algaworks.algafood.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelmapperConfig {
	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
		
	}

}
