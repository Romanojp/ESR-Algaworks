package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.algaworks.algafood.Groups;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
/*	https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints*/
	
	
//	@NotNull
//	@NotEmpty
	@NotBlank(groups = Groups.CadastroRestaurante.class)
	@Column(nullable = false)
	private String nome;
	
	//@DecimalMin("1")
	@PositiveOrZero(groups = Groups.CadastroRestaurante.class)
	@Column(name = "taxa_frete", nullable = false)
	private BigDecimal taxaFrete;
	
	//@JsonIgnore
	@Valid
	@JsonIgnoreProperties("hibernateLazyInitializer")
	@NotNull(groups = Groups.CadastroRestaurante.class)
	@ManyToOne //(fetch = FetchType.LAZY) //por padrão tudo que for to one sera carregado com a estrategia eager loading
	@JoinColumn(name = "cozinha_id", nullable = false)
	private Cozinha cozinha;
	
	@JsonIgnore
	@Embedded
	private Endereco endereco;
	
	@JsonIgnore 
	@CreationTimestamp
	@Column(nullable = false,  columnDefinition = "datetime")
	private LocalDateTime dataCadastro;
	
	@JsonIgnore
	@UpdateTimestamp
	@Column(nullable = false, columnDefinition = "datetime") 
	private LocalDateTime dataAtualizacao;
	
	@JsonIgnore
	@ManyToMany //tudo que termina com to many utiliza a estrategia lazy loadinga(carregamento preguiçoso)
	@JoinTable(name = "restaurante_forma_pagamento" , 
	joinColumns = @JoinColumn(name = "restaurante_id" ),
	inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
	private List<FormaPagamento> formasPagamento = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurante")
	private List<Produto> produtos = new ArrayList<>();
}
