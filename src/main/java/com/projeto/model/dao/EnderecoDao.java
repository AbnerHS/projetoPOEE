package com.projeto.model.dao;

import javax.persistence.EntityManager;

import com.projeto.model.models.Endereco;

public class EnderecoDao extends GenericDao<Endereco, Integer>{

	public EnderecoDao(EntityManager entityManager) {
		super(entityManager);
	}
	
}
