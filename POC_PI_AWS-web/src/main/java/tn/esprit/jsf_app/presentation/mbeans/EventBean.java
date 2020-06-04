package tn.esprit.jsf_app.presentation.mbeans;

import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import tn.esprit.jsf_app.DTO.*;
import tn.esprit.jsf_app.services.EventService;

@ManagedBean
@SessionScoped
public class EventBean {

	public int EventId;
	public String Name;
	public static String image;
	public category Category;
	public int number_P;
	public String DateEvent;
	public Date date;
	public String HeureD;
	public String HeureF;
	public String Description;
	private List<Event> Event;
	private static final long serialVersionUID = 1L;

	EventService E = new EventService();
	
	private String LO;

	public String getLO() {
		return LO;
	}

	public void setLO(String lO) {
		LO = lO;
	}
	
	public void doUpload() {

		try {
			InputStream in = logo.getInputStream();
			image = logo.getSubmittedFileName();
			File f = new File("C:/Users/Culer/Desktop/.net project/Pi Dev PAAS SAAS KinderGarten/Solution-4Arctic-2020/Solution.Web/Content/Uploads/"
					+ logo.getSubmittedFileName());
			System.out.println("iheb" + f.getAbsolutePath());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);

			byte[] buffer = new byte[1024];
			int length;

			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			out.close();
			in.close();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

	public void doUpload1() {

		try {
			InputStream in = logo.getInputStream();

			File f = new File(
					"C:/Users/Culer/Desktop/AWS_PI-master/AWS_PI-master/POC_PI_AWS-web/src/main/webapp/Ressources/Uploads/"
							+ logo.getSubmittedFileName());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);

			byte[] buffer = new byte[1024];
			int length;

			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			out.close();
			in.close();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

	public Part getLogo() {
		return logo;
	}

	public void setLogo(Part logo) {
		this.logo = logo;
	}

	public boolean isUpladed() {
		return upladed;
	}

	public void setUpladed(boolean upladed) {
		this.upladed = upladed;
	}

	private Part logo;
	private boolean upladed;

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
		
		return "/Event/Event?faces-redirect=true";

	}

	public String addEvent() {
		System.out.println("aaaaaaaa"+date);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		DateEvent = format.format(date);
		System.out.println("aaaaaaaa"+DateEvent);

		E.Create(new Event(Name, image, Category, number_P, DateEvent, HeureD, HeureF, Description));
		return "/Event/Event?faces-redirect=true";
		
	

	}

	public String modifier(Event e) throws IOException {

		this.setEventId(e.getEventId());
		this.setName(e.getName());
		this.setImage(e.getImage());
		this.setDescription(e.getDescription());
		this.setDate(e.getDate());
		this.setHeureD(e.getHeureD());
		this.setHeureF(e.getHeureF());
		this.setNumber_P(e.getNumber_P());
		System.out.println(e.getEventId());

		return "/Event/Edit?faces-redirect=true";

	}
	
	public String Details(Event e) throws IOException {

		this.setEventId(e.getEventId());
		this.setName(e.getName());
		this.setName(e.getName());
		this.setDescription(e.getDescription());
		this.setDateEvent(e.getDateEvent());
		this.setHeureD(e.getHeureD());
		this.setHeureF(e.getHeureF());
		this.setNumber_P(e.getNumber_P());		
		this.setLO(e.getImage());
		System.out.println("yezzi"+LO);	
		

		return "/Event/Details?faces-redirect=true";

	}

	/*public String MAJEvent() {

		//E.Update(EventId, new Event(Name, image, Category, Description, HeureD, HeureF, number_P));
		Event = E.GetAll();

		return "Event.jsf";
	}*/
	
	public String PutEvent()  {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateEvent = format.format(date);
		E.Update( EventId,new Event(Name, image, Category, number_P, DateEvent, HeureD, HeureF, Description));
		return "/Event/Event?faces-redirect=true";
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

	public EventService getE() {
		return E;
	}

	public void setE(EventService e) {
		E = e;
	}

}
