package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.jsf_app.DTO.Publication;


@Remote
public interface PublicationServiceRemote {
	List<Publication> GetAll();
	public void Delete(Publication publication);
	public void Create(Publication p);
	public void Update(int id,Publication p);

}
