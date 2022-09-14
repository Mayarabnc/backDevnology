package com.api.devnology.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.devnology.model.LinkModel;
import com.api.devnology.repository.LinkRepository;

/*Indica que a classe é uma rest controller, que ela é responsavel por responder todas as requisições HTTP enviadas para o endpoint*/
@RestController

					/*endpoint*/
@RequestMapping("/link")

				/*Para aceitar requisições de qualquer origem*/
@CrossOrigin(origins = "*")
public class LinkController {
		
		/*Injetar dependência*/
	@Autowired 
	private LinkRepository repository;
	
		/*Indica que o metodo responderá as requisições do tipo GET que forem enviadas para o endpoint*/
	@GetMapping
	public ResponseEntity<List<LinkModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LinkModel> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/nomeLink/{nomeLink}")				/*Insere a variável do endpoint*/
	public ResponseEntity<List<LinkModel>> GetByNome(@PathVariable String nomeLink){
													/*Pega uma variável de dentro do caminho da URI*/
		return ResponseEntity.ok(repository.findAllByNomeLinkContainingIgnoreCase(nomeLink));
	}
	
		/*Indica que o metodo responderá as requisições do tipo POST que forem enviadas para o endpoint*/
	@PostMapping
	public ResponseEntity<LinkModel> post(@Valid @RequestBody LinkModel link) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(link));		
	}
	
		/*Indica que o metodo responderá as requisições do tipo PUT que forem enviadas para o endpoint*/
	@PutMapping
	public ResponseEntity<LinkModel> put (@Valid @RequestBody LinkModel link){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(link));
	}
	
		/*Indica que o metodo responderá as requisições do tipo DELETE que forem enviadas para o endpoint*/
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
