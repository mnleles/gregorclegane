package br.com.ura.gregor.clegane.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.ura.gregor.clegane.model.Account;
import br.com.ura.gregor.clegane.model.Role;
import br.com.ura.gregor.clegane.repository.AccountRepository;

public class UserDetailsServiceImpl implements UserDetailsService
{
	private AccountRepository repository;

	public UserDetailsServiceImpl(AccountRepository repository)
	{
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException
	{
		Account account = repository.findByUser(user);
		if (account == null)
		{
			throw new UsernameNotFoundException("User not found: " + user);
		}

		return new User(account.getUser(), account.getPassword(), toGrantedAuthorityList(account.getRoles()));
	}

	private Set<GrantedAuthority> toGrantedAuthorityList(List<Role> roles)
	{
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		for (Role role : roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.name()));
		}

		return authorities;
	}
}