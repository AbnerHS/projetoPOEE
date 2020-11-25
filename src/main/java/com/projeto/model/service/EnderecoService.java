package com.projeto.model.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.dao.EnderecoDao;
import com.projeto.model.models.Endereco;

public class EnderecoService extends ConexaoBancoService{
	private EnderecoDao enderecoDao;
	
	public EnderecoService() {
		this.enderecoDao = new EnderecoDao(this.getEntityManager());
	}
	
	public EnderecoDao getEnderecoDao() {
		return this.enderecoDao;
	}
	
	public Integer save(Endereco endereco) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		if(validarDigitacao(endereco) == VariaveisProjeto.DIGITACAO_OK) {
			try {
				trx.begin();
				this.getEnderecoDao().save(endereco);
				trx.commit();
			} catch(Exception e) {
				e.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_INCLUSAO;
			} finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn;
	}
	
	public Integer update(Endereco endereco) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		if(validarDigitacao(endereco) == VariaveisProjeto.DIGITACAO_OK) {
			try {
				trx.begin();
				this.getEnderecoDao().update(endereco);
				trx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_ALTERACAO;
			} finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn;
	}
	
	public Integer delete(Endereco endereco) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		if(validarDigitacao(endereco) == VariaveisProjeto.DIGITACAO_OK) {
			try {
				trx.begin();
				Endereco enderecoEncontrado = this.getEnderecoDao().findById(endereco.getId());
				this.getEnderecoDao().remove(enderecoEncontrado);
				trx.commit();
			} catch(Exception e) {
				e.printStackTrace();
				toReturn = VariaveisProjeto.ERRO_EXCLUSAO;
			} finally {
				this.close();
			}
		}
		return toReturn;
	}
	
	public Endereco findById(Integer id) {
		return this.getEnderecoDao().findById(id);
	}
	
	public List<Endereco> findAll() {
		return this.getEnderecoDao().findAll(Endereco.class);
	}
	
	public Integer validarDigitacao(Endereco endereco) {
		if(VariaveisProjeto.digitacaoCampo(endereco.getRua())) {
			return VariaveisProjeto.CAMPO_VAZIO;
		} else if(VariaveisProjeto.digitacaoCampo(endereco.getBairro())) {
			return VariaveisProjeto.CAMPO_VAZIO;
		} else if(VariaveisProjeto.digitacaoCampo(endereco.getNumero().toString())) {
			return VariaveisProjeto.CAMPO_VAZIO;
		}
		return VariaveisProjeto.DIGITACAO_OK;
	}
}
