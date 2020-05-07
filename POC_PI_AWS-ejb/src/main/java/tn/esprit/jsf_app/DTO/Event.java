package tn.esprit.jsf_app.DTO;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import tn.esprit.jsf_app.DTO.Category;

public class Event implements Serializable {
	
	public int EventId;
	public String Name; 
	public String image;
	public String Category;
	public int number_P ;
	public String DateEvent;
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
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
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
	
	
	@Override
	public String toString() {
		return "Event [EventId=" + EventId + ", Name=" + Name + ", Picture=" + image + ", Theme=" + Category
				+ ", Description=" + Description + ", DateEvent=" + DateEvent + ", HeureDebut=" + HeureD + ", HeureDebut=" + HeureD + "]";
	}
	public Event( String name, String image, String Category, String Description, String DateEvent, String HeureD, String HeureF) {
		
		Name = name;
		image = image;
		Category = Category;
		Description = Description;
		DateEvent = DateEvent;
		HeureF = HeureF;
		HeureD = HeureD;
	}
	public Event(int eventId, String name, String image, String Category, String Description, String DateEvent, String HeureD, String HeureF) {
		super();
		
		EventId = eventId;
		Name = name;
		image = image;
		Category = Category;
		Description = Description;
		DateEvent = DateEvent;
		HeureF = HeureF;
		HeureD = HeureD;
		
		
	}
	 
      
   
}
