package br.com.ura.gregor.clegane.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ura.gregor.clegane.model.Membership;
import br.com.ura.gregor.clegane.repository.MembershipRepository;

public class MembershipService extends AbstractService<Membership>
{
	@Autowired
	private MembershipRepository repository;

	@Override
	protected MongoRepository<Membership, String> getRepository()
	{
		return repository;
	}
}