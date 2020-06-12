package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.jsf_app.DTO.Event;

@Local
public interface EventServiceLocal {
	List<Event> GetAll();
	public void Delete(int EventId);
	public void Create(Event p);
	public void Update(int id,Event p);

}
