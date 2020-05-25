package tn.esprit.jsf_app.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.jsf_app.DTO.KinderGarten;

@Remote
public interface KinderGartenServiceRemote {
	List<KinderGarten> GetAll();
	public void Delete(KinderGarten KinderGarten);
	public void Create(KinderGarten p);
	public void Update(int id,KinderGarten p);

}
