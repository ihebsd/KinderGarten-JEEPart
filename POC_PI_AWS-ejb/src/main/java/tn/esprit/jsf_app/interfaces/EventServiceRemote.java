package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Remote;

import  tn.esprit.jsf_app.DTO.Event;

@Remote
public interface EventServiceRemote {
	
	List<Event> GetAll();
	public void Delete(Event EventId);
	public void Create(Event p);
	public void Update(int id,Event p);

}
