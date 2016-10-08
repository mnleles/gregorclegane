package br.com.ura.gregor.clegane.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.ura.gregor.clegane.repository.AccountRepository;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	private AccountRepository repository;

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
				.antMatchers("/index", "/").permitAll()
				.antMatchers("/pages-login*").anonymous()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/pages-login.html")
				.defaultSuccessUrl("/index_admin.html")
				.failureUrl("/pages-login.html?error=true")
				.and()
				.logout().logoutSuccessUrl("/pages-login.html")
				.and().httpBasic();
		;
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring()
				.antMatchers("/assets/**")
				.antMatchers("/audio/**")
				.antMatchers("/css/**")
				.antMatchers("/img/**")
				.antMatchers("/js/**")
				.antMatchers("/landingpage/**");
	}

	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception
	{
		return new UserDetailsServiceImpl(repository);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsServiceBean());
	}
}