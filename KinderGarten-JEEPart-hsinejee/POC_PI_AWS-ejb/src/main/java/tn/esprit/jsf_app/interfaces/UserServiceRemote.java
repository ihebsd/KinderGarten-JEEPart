package tn.esprit.jsf_app.interfaces;

import javax.ejb.Remote;

import tn.esprit.jsf_app.DTO.User;

@Remote
public interface UserServiceRemote {
	User Login(String email ,String password);
	public void Register(User user);

}
