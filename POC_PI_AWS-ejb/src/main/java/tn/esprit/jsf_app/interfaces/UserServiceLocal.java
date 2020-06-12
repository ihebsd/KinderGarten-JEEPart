package tn.esprit.jsf_app.interfaces;

import javax.ejb.Local;

import tn.esprit.jsf_app.DTO.User;

@Local
public interface UserServiceLocal {
User Login(String email ,String password);
}
