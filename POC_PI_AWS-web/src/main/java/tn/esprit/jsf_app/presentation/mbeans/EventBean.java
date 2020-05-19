package tn.esprit.jsf_app.presentation.mbeans;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.jsf_app.DTO.*;
import tn.esprit.jsf_app.services.EventService;

@ManagedBean
@SessionScoped
public class EventBean {

	public int EventId;
	public String Name;
	public String image;
	public category Category;
	public int number_P;
	public String DateEvent;
	public String HeureD;
	public String HeureF;
	public String Description;
	private List<Event> Event;
	private static final long serialVersionUID = 1L;

	EventService E = new EventService();

	public int getEventId() {
		return EventId;
	}

	public List<Event> getEvent() {
		Event =E.GetAll();
		return Event;
	}

	public void setEvent(List<Event> event) {
		Event = event;
	}

	public List<Event> getEvents() {
		Event = E.GetAll();
		return Event;
	}

	public String supprimer(Event e) {
		System.out.println("aaaaaaaa");
		E.Delete(e);
		
		return "Event.jsf";

	}

	public String addEvent() {
		E.Create(new Event(Name, image, Category, number_P, DateEvent, HeureD, HeureF, Description));
		return "Event.jsf";
		
	

	}

	public String modifier(Event e) throws IOException {

		this.setEventId(e.getEventId());
		this.setName(e.getName());
		this.setImage(e.getImage());
		this.setDescription(e.getDescription());
		this.setDateEvent(e.getDateEvent());
		this.setHeureD(e.getHeureD());
		this.setHeureF(e.getHeureF());
		this.setNumber_P(e.getNumber_P());
		System.out.println(e.getEventId());

		return "Edit.jsf";

	}

	public String MAJEvent() {

		//E.Update(EventId, new Event(Name, image, Category, Description, HeureD, HeureF, number_P));
		Event = E.GetAll();

		return "Event.jsf";
	}

	public void setEventId(int eventId) {
		EventId = eventId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public category getCategory() {
		return Category;
	}

	public void setCategory(category category) {
		Category = category;
	}

	public int getNumber_P() {
		return number_P;
	}

	public void setNumber_P(int number_P) {
		this.number_P = number_P;
	}

	public String getDateEvent() {
		return DateEvent;
	}

	public void setDateEvent(String dateEvent) {
		DateEvent = dateEvent;
	}

	public String getHeureD() {
		return HeureD;
	}

	public void setHeureD(String heureD) {
		HeureD = heureD;
	}

	public String getHeureF() {
		return HeureF;
	}

	public void setHeureF(String heureF) {
		HeureF = heureF;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public EventService getE() {
		return E;
	}

	public void setE(EventService e) {
		E = e;
	}

}
