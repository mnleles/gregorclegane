package br.com.ura.gregor.clegane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ura.gregor.clegane.model.Membership;
import br.com.ura.gregor.clegane.service.AbstractService;
import br.com.ura.gregor.clegane.service.MembershipService;

@Controller
@RequestMapping("/membership")
public class MembershipController extends AbstractController<Membership>
{
	@Autowired
	private MembershipService service;

	@Override
	protected AbstractService<Membership> getService()
	{
		return service;
	}
}