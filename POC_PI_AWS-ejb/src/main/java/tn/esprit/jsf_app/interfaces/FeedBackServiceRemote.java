package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.jsf_app.DTO.FeedBack;


@Remote
public interface FeedBackServiceRemote {
	List<FeedBack> GetAll();
	public void Delete(FeedBack FeedBackId);
	public void Create(FeedBack f);
	public void Update(int id,FeedBack f);

}
