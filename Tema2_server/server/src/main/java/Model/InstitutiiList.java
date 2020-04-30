package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InstitutiiList implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private List<Institutie> institutii = new ArrayList<Institutie>();

	public List<Institutie> getInstitutii() {
		return institutii;
	}

	public void setInstitutii(List<Institutie> inst1) {
		institutii = inst1;
	}
	
	public void addInstitutie(Institutie institutie) {
		institutii.add(institutie);
	}

}
