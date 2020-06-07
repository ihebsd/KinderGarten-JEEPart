package tn.esprit.jsf_app.presentation.mbeans;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale.Category;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import tn.esprit.jsf_app.DTO.CarPool;
import tn.esprit.jsf_app.DTO.User;
import tn.esprit.jsf_app.services.CarPoolService;
import tn.esprit.jsf_app.services.MailUser;
import tn.esprit.jsf_app.services.UserService;

@ManagedBean
@SessionScoped
public class CarPoolBean {

	public int Id;
	public String Title;
	public String From;
	public String To;
	public String Time;
	public Date Timee;
	public String Date;
	public Date Datee;
	public String Message;
	public int NbPlaceDispo;
	public Boolean Daily;
	public Boolean Weekly;
	public Boolean EveryWeekDay;
	public Category category;
	public Boolean Others;
	public String UntilDate;
	public Date UntilDatee;
	public int idParent;
	public int idKid;
	public String destination, subject, msg;
	public int getId() {
		return Id;
	}

	public List<CarPool> CarPool;
	public List<CarPool> MyCarPool;
	MailUser mail = new MailUser();
	UserService userservice = new UserService();
	CarPoolService E = new CarPoolService();

	public List<CarPool> getCarPool() {
		CarPool = E.GetAll();

		return CarPool;
	}

	public void setCarPool(List<CarPool> carPool) {
		CarPool = carPool;
	}

	public void setMyCarPool(List<CarPool> mycarPool) {
		MyCarPool = mycarPool;
	}

	public List<CarPool> getMyCarPool() {
		System.out.println("id" + User.getConnectedUser().getIdUser());
		MyCarPool = E.GetMyCar(User.getConnectedUser().getIdUser());

		return MyCarPool;
	}

	public String supprimer(CarPool e) {
		System.out.println("deleteeeeeeeeeeeeeeeeeeeee");
		E.Delete(e);
		return "/CarPool/MyIndex?faces-redirect=true";

	}

	public Boolean test(CarPool c) {
		int uc = User.getConnectedUser().getIdUser();
		System.out.println("user conn" + uc);
		System.out.println("user connected" + c.idParent);

		if (c.idParent != uc)
			return true;
		return false;
	}

	public String AddCarPool() {
		this.setIdParent(User.getConnectedUser().getIdUser());

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date = format.format(Datee);
		Time = format.format(Timee);

		if (UntilDate != null) {
			UntilDate = format.format(UntilDatee);
		} else {
			UntilDate = null;
		}

		System.out.println("date" + Date);
		System.out.println("date" + Datee);

		System.out.println("aaa");
		E.Create(new CarPool(Id, Title, From, To, Time, Date, Message, NbPlaceDispo, Daily, Weekly, EveryWeekDay,
				Others, UntilDate, idParent, idKid));

		return "/CarPool/Index?faces-redirect=true";

	}

	public String UpdateCarPool(CarPool c) throws IOException {
		this.setIdParent(User.getConnectedUser().getIdUser());

		this.setId(c.getId());
		this.setTitle(c.getTitle());
		this.setFrom(c.getFrom());
		this.setTo(c.getTo());
		this.setTime(c.getTime());
		this.setDate(c.getDate());
		this.setMessage(c.getMessage());
		this.setNbPlaceDispo(c.getNbPlaceDispo());
		this.setDaily(c.getDaily());
		this.setWeekly(c.getWeekly());
		this.setEveryWeekDay(c.getEveryWeekDay());
		this.setOthers(c.getOthers());
		this.setUntilDate(c.getUntilDate());
		this.setIdParent(c.getIdParent());
		this.setIdKid(c.getIdKid());

		return "/CarPool/Update?faces-redirect=true";

	}

	public String contacter(CarPool c) {

		String msg = "Hi  " + userservice.GetUserById(c.idParent).getNom() + ", " + User.getConnectedUser().getNom()
				+ " " + User.getConnectedUser().getPrenom()
				+ " Want to join your carpool please reply fast as you can.Send your Reply To This Mail "
				+ User.getConnectedUser().getEmail()
				+ " LOGIN IN : http://localhost:9080/POC_PI_AWS-web/Login/Login.jsf";

		mail.sendMail(userservice.GetUserById(c.idParent).getEmail(), "Request To join CarPool", msg);

		return "/CarPool/Index?faces-redirect=true";
	}

	public String PutCarPool() {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss");
		Date = format.format(Datee);
		Time = format.format(Timee);
		UntilDate = null;

		if (UntilDate != null) {
			UntilDate = format.format(UntilDatee);
		} else {
			UntilDate = null;
		}
		System.out.println("updateeeeeeeeeeeeeeeeeeeeeeeeeeee");
		E.Update(Id, new CarPool(Title, From, To, Time, Date, Message, NbPlaceDispo, Daily, Weekly, EveryWeekDay,
				Others, UntilDate, idParent, idKid));
		return "/CarPool/MyIndex?faces-redirect=true";
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		To = to;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public Date getTimee() {
		return Timee;
	}

	public void setTimee(Date timee) {
		Timee = timee;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Date getDatee() {
		return Datee;
	}

	public void setDatee(Date datee) {
		Datee = datee;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getNbPlaceDispo() {
		return NbPlaceDispo;
	}

	public void setNbPlaceDispo(int nbPlaceDispo) {
		NbPlaceDispo = nbPlaceDispo;
	}

	public Boolean getDaily() {
		return Daily;
	}

	public void setDaily(Boolean daily) {
		Daily = daily;
	}

	public Boolean getWeekly() {
		return Weekly;
	}

	public void setWeekly(Boolean weekly) {
		Weekly = weekly;
	}

	public Boolean getEveryWeekDay() {
		return EveryWeekDay;
	}

	public void setEveryWeekDay(Boolean everyWeekDay) {
		EveryWeekDay = everyWeekDay;
	}

	public Boolean getOthers() {
		return Others;
	}

	public void setOthers(Boolean others) {
		Others = others;
	}

	public String getUntilDate() {
		return UntilDate;
	}

	public void setUntilDate(String untilDate) {
		UntilDate = untilDate;
	}

	public Date getUntilDatee() {
		return UntilDatee;
	}

	public void setUntilDatee(Date untilDatee) {
		UntilDatee = untilDatee;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public int getIdKid() {
		return idKid;
	}

	public void setIdKid(int idKid) {
		this.idKid = idKid;
	}

	public CarPoolService getE() {
		return E;
	}

	public void setE(CarPoolService e) {
		E = e;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
