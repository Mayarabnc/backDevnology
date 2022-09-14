package com.api.devnology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.devnology.model.LinkModel;

@Repository
public interface LinkRepository extends JpaRepository<LinkModel, Long>{
	public List<LinkModel> findAllByNomeLinkContainingIgnoreCase(@Param("nomeLink") String nome);
								/*Buscar pelo "nome"(atributo da minha entidade) e trazer tudo que está dentro da variável sem levar em consideração o maiúsculo ou minúsculo */
}
