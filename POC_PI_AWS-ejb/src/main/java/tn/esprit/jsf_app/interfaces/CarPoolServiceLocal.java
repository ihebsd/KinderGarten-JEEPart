package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.jsf_app.DTO.CarPool;


@Local
public interface CarPoolServiceLocal {
	List<CarPool> GetAll();
	List<CarPool> GetMyCar(int idp);
	public void Delete(int Id);
	public void Create(CarPool p);
	public void Update(int id,CarPool p);
	

}
