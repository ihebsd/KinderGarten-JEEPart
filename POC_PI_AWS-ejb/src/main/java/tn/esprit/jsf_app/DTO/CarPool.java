package tn.esprit.jsf_app.DTO;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.Locale.Category;


public class CarPool implements Serializable {
	
	public CarPool() {
		super();
	}

	public int Id;
	public String Title; 
	public String From ;
	public String To ;
	public String Time ;
	public Date Timee ;
	public String Date ;
	public Date Datee ;
	public String Message ;
	public int NbPlaceDispo ;
	public Boolean Daily ;
	public Boolean Weekly ;
	public Boolean EveryWeekDay ;
	public Boolean Others ;
	public String UntilDate ;
	public Date  UntilDatee ;
	public int  idParent ;
	public int  idKid ;
	
	
	


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	@Override
	public String toString() {
		return "CarPool [Id=" + Id + ", Title=" + Title + ", From=" + From + ", To=" + To + ", Time=" + Time + ", Date="
				+ Date + ", Message=" + Message + ", NbPlaceDispo=" + NbPlaceDispo + ", Daily=" + Daily + ", Weekly="
				+ Weekly + ", EveryWeekDay=" + EveryWeekDay + ", Others=" + Others + ", UntilDate=" + UntilDate
				+ ", idParent=" + idParent + ", idKid=" + idKid + "]";
	}

	public CarPool(int id, String title, String from, String to, String time, String date, String message,
			int nbPlaceDispo, Boolean daily, Boolean weekly, Boolean everyWeekDay, Boolean others, String untilDate,
			int idParent, int idKid) {
		super();
		Id = id;
		Title = title;
		From = from;
		To = to;
		Time = time;
		Date = date;
		Message = message;
		NbPlaceDispo = nbPlaceDispo;
		Daily = daily;
		Weekly = weekly;
		EveryWeekDay = everyWeekDay;
		Others = others;
		UntilDate = untilDate;
		this.idParent = idParent;
		this.idKid = idKid;
	}

	public CarPool(int id, String title, String from, String to, java.util.Date timee, java.util.Date datee,
			String message, int nbPlaceDispo, Boolean daily, Boolean weekly, Boolean everyWeekDay, Boolean others,
			java.util.Date untilDatee, int idParent, int idKid) {
		super();
		Id = id;
		Title = title;
		From = from;
		To = to;
		Timee = timee;
		Datee = datee;
		Message = message;
		NbPlaceDispo = nbPlaceDispo;
		Daily = daily;
		Weekly = weekly;
		EveryWeekDay = everyWeekDay;
		Others = others;
		UntilDatee = untilDatee;
		this.idParent = idParent;
		this.idKid = idKid;
	}

	public CarPool(String title, String from, String to, String time, String date, String message, int nbPlaceDispo,
			Boolean daily, Boolean weekly, Boolean everyWeekDay, Boolean others, String untilDate, int idParent,
			int idKid) {
		super();
		Title = title;
		From = from;
		To = to;
		Time = time;
		Date = date;
		Message = message;
		NbPlaceDispo = nbPlaceDispo;
		Daily = daily;
		Weekly = weekly;
		EveryWeekDay = everyWeekDay;
		Others = others;
		UntilDate = untilDate;
		this.idParent = idParent;
		this.idKid = idKid;
	}
	
	


	

	





	
	
   
}
