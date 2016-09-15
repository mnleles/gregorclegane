package br.com.ura.gregor.clegane.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ura.gregor.clegane.model.Membership;

@Repository
public interface MembershipRepository extends MongoRepository<Membership, String>
{

}
