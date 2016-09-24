package br.com.ura.gregor.clegane.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ura.gregor.clegane.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>
{
	public Account findByUser(String user);
}