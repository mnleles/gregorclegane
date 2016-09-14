package br.com.ura.gregor.clegane.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ura.gregor.clegane.model.Membership;

public interface MembershipRepository extends MongoRepository<Membership, String>
{

}
