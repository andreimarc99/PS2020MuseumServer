package Model;

import java.io.Serializable;
import java.util.List;

public class Muzeu extends Institutie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Muzeu(String denumire, int id, String adresa, List<OperaDeArtaPlastica> opereDeArta) {
		super(denumire, id, adresa, opereDeArta);
	}
}
