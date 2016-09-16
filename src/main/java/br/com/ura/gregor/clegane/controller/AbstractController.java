package br.com.ura.gregor.clegane.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ura.gregor.clegane.model.AbstractModel;
import br.com.ura.gregor.clegane.service.AbstractService;

public abstract class AbstractController<T extends AbstractModel>
{
	protected abstract AbstractService<T> getService();

	@RequestMapping(method = GET)
	public ResponseEntity<List<T>> fetchAll()
	{
		return ResponseEntity.status(OK).body(getService().fetchAll());
	}

	@RequestMapping(value = "/{id}", method = GET)
	public ResponseEntity<T> fetchById(@PathVariable("id") String id)
	{
		return ResponseEntity.status(OK).body(getService().fetchById(id));
	}

	@RequestMapping(method = POST)
	public ResponseEntity<T> insert(@Valid @RequestBody T entity)
	{
		return ResponseEntity.status(CREATED).body(getService().insert(entity));
	}

	@RequestMapping(method = PUT)
	public ResponseEntity<T> update(@RequestBody T entity)
	{
		return ResponseEntity.status(OK).body(getService().update(entity));
	}

	@RequestMapping(value = "/{id}", method = DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") String id)
	{
		getService().delete(id);
		return ResponseEntity.status(NO_CONTENT).build();
	}
}