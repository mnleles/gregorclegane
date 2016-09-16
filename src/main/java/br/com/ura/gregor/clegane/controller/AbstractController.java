package br.com.ura.gregor.clegane.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ura.gregor.clegane.model.AbstractModel;
import br.com.ura.gregor.clegane.service.AbstractService;

public abstract class AbstractController<T extends AbstractModel>
{
	protected abstract AbstractService<T> getService();

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<T>> fetchAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(getService().fetchAll());
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Void> insert(@Valid @RequestBody T entity) throws Exception
	{
		entity = getService().insert(entity);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> fetchById(@PathVariable("id") String id) throws Exception
	{
		T entity = getService().fetchById(id);

		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception
	{
		getService().delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody T entity, @PathVariable("id") String id) throws Exception
	{
		entity.setId(id);
		getService().update(entity);

		return ResponseEntity.noContent().build();
	}
}