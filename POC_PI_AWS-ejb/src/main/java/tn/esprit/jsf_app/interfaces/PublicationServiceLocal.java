package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.jsf_app.DTO.Publication;

@Local
public interface PublicationServiceLocal {
	List<Publication> GetAll();
	public void Delete(Publication publication);
	public void Create(Publication p);
	public void Update(int id,Publication p);

}
