package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Remote;

import  tn.esprit.jsf_app.DTO.Event;


@Remote
public interface ClaimServiceRemote {

	List<Claim> GetAll();
	public void Delete(Claim ClaimId);
	public void Create(Claim c);
	public void Update(int id,Claim c);
}
