package tn.esprit.jsf_app.presentation.mbeans;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import tn.esprit.jsf_app.DTO.Event;
import tn.esprit.jsf_app.DTO.*;
import tn.esprit.jsf_app.services.EventService;

@ManagedBean
public class EventBean {

	public int EventId;
	public String Name;
	public String image;

	public int getEventId() {
		return EventId;
	}

	public Category Category;
	public int number_P;
	public String DateEvent;
	public String HeureD;
	public String HeureF;
	public String Description;
	private List<Event> Event;
	private static final long serialVersionUID = 1L;

	EventService E = new EventService();

	public List<Event> getEvent() {
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
		E.Delete(e);
		return "event.jsf";

	}

	public String addEvent()  {
		E.Create(new Event(Name, image,
		 Category,
		 Description,
		 DateEvent,
		 HeureD,
		 HeureF	 
		 ));
		return "event.jsf";

	}

	public String modifier(Event e) throws IOException {

		this.setEventId(e.getEventId());
		this.setName(e.getName());
		this.setImage(e.getImage());
		this.setCategory(e.getCategory());
		this.setDescription(e.getDescription());
		this.setDateEvent(e.getDateEvent());
		this.setHeureD(e.getHeureD());
		this.setHeureF(e.getHeureF());
		this.setNumber_P(e.getNumber_P());
		System.out.println(e.getEventId());

		return "edit.jsf";

	}

	public String MAJEvent() {

		E.Update(EventId, new Event(Name, image,Category, Description, DateEvent, HeureD, HeureF ));
		Event = E.GetAll();

		return "event.jsf";
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

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
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