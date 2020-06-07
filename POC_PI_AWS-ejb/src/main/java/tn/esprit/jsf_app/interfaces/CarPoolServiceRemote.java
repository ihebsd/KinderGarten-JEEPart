package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.jsf_app.DTO.CarPool;

@Remote
public interface CarPoolServiceRemote {
	
	List<CarPool> GetAll();
	List<CarPool> GetMyCar(int idp);
	public void Delete(CarPool Id);
	public void Create(CarPool p);
	public void Update(int id,CarPool p);

}
