package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.jsf_app.DTO.Claim;


@Local
public interface ClaimServiceLocal {

	List<Claim> GetAll();
	public void Delete(int ComplaintId);
	public void Create(Claim c);
	public void Update(int id,Claim c);
}
