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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<T> fetchById(@PathVariable("id") String id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(getService().fetchById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<T> insert(@Valid @RequestBody T entity)
	{
		entity = getService().insert(entity);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();

		return ResponseEntity.created(uri).body(entity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<T> update(@RequestBody T entity)
	{
		return ResponseEntity.status(HttpStatus.OK).body(getService().update(entity));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception
	{
		getService().delete(id);
		return ResponseEntity.noContent().build();
	}
}