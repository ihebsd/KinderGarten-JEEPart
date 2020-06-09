package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.jsf_app.DTO.KinderGarten;


@Local
public interface KinderGartenServiceLocal {
	List<KinderGarten> GetAll();
	public void Delete(int KinderGartenId);
	public void Create(KinderGarten p);
	public void Update(int id,KinderGarten p);

}
