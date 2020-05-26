package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.jsf_app.DTO.FeedBack;


@Local
public interface FeedBackServiceLocal {
	List<FeedBack> GetAll();
	public void Delete(int FeedBackId);
	public void Create(FeedBack f);
	public void Update(int id,FeedBack f);
}
