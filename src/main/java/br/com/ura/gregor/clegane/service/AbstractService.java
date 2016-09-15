package br.com.ura.gregor.clegane.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import br.com.ura.gregor.clegane.model.AbstractModel;

@Service
public abstract class AbstractService<T extends AbstractModel>
{
	protected abstract MongoRepository<T, String> getRepository();

	public List<T> fetchAll()
	{
		return getRepository().findAll();
	}

	public T fetchById(String id) throws Exception
	{
		T entity = getRepository().findOne(id);
		if (entity == null)
		{
			throw new Exception();
		}

		return entity;
	}

	public T insert(T entity) throws Exception
	{
		if (entity.getId() != null)
		{
			T result = getRepository().findOne(entity.getId());

			if (result != null)
			{
				throw new Exception();
			}
		}

		return getRepository().save(entity);
	}

	public void delete(String id) throws Exception
	{
		try
		{
			getRepository().delete(id);
		}
		catch (EmptyResultDataAccessException e)
		{
			throw new Exception();
		}
	}

	public void update(T entity) throws Exception
	{
		T result = getRepository().findOne(entity.getId());
		if (result == null)
		{
			throw new Exception();
		}

		getRepository().save(entity);
	}
}
