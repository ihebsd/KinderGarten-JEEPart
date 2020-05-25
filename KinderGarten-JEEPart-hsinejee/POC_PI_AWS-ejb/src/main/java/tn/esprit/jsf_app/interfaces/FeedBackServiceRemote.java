package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Remote;

import  tn.esprit.jsf_app.DTO.Event;


@Remote
public interface FeedBackServiceRemote {
	List<FeedBack> GetAll();
	public void Delete(FeedBack FeedBackId);
	public void Create(FeedBack c);
	public void Update(int id,FeedBack c);
}
