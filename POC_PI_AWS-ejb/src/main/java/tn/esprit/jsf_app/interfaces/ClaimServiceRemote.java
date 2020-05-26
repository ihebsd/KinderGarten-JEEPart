package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.jsf_app.DTO.Claim;


@Remote
public interface ClaimServiceRemote {
	List<Claim> GetAll();
	public void Delete(Claim ComplaintId);
	public void Create(Claim c);
	public void Update(int id,Claim c);

}
