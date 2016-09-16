package br.com.ura.gregor.clegane.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ura.gregor.clegane.model.AbstractModel;

public abstract class AbstractService<T extends AbstractModel>
{
	protected abstract MongoRepository<T, String> getRepository();

	public List<T> fetchAll()
	{
		return getRepository().findAll();
	}

	public T fetchById(String id)
	{
		return getRepository().findOne(id);
	}

	public T insert(T entity)
	{
		if (entity.getId() != null)
		{
			return null;
		}

		return getRepository().save(entity);
	}

	public void delete(String id)
	{
		getRepository().delete(id);
	}

	public T update(T entity)
	{
		T result = getRepository().findOne(entity.getId());
		if (result == null)
		{
			return null;
		}

		return getRepository().save(entity);
	}
}