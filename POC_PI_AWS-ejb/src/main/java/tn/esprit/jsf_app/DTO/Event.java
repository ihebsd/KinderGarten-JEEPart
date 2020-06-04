package tn.esprit.jsf_app.DTO;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import tn.esprit.jsf_app.DTO.category;

public class Event implements Serializable {
	
	public int EventId;
	public String Name; 
	public String image;
	public category Category;
	public int number_P ;
	public String DateEvent;
	public Date date;
	public String HeureD;
	public String HeureF;
	public String Description;
	private static final long serialVersionUID = 1L;
	
	public Event() {
		super();
	}
	public int getEventId() {
		return EventId;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	@Override
	public String toString() {
		return "Event [EventId=" + EventId + ", Name=" + Name + ", Picture=" + image + ", Theme=" + Category
				+ ", Description=" + Description + ", DateEvent=" + DateEvent + ", HeureDebut=" + HeureD + ", HeureDebut=" + HeureD + "]";
	}
	public Event(String name, String image, category category, int number_P, String dateEvent, String heureD,
			String heureF, String description) {
		
		super();
		Name = name;
		this.image = image;
		Category = category;
		this.number_P = number_P;
		DateEvent = dateEvent;
		HeureD = heureD;
		HeureF = heureF;
		Description = description;
	}
	

	
	
		
	
	 
      
   
}
