package Model;

import java.io.Serializable;
import java.util.List;

public class GalerieArta extends Institutie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GalerieArta(String denumire, int id, String adresa, List<OperaDeArtaPlastica> opereDeArta) {
		super(denumire, id, adresa, opereDeArta);
		// TODO Auto-generated constructor stub
	}
}
