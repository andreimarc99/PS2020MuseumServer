package Model;

import java.io.Serializable;
import java.util.List;

public class Institutie implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String denumire;
    private int id;
    private String adresa;
    private List<OperaDeArtaPlastica> opereDeArta;

    public Institutie(String denumire, int id, String adresa, List<OperaDeArtaPlastica> opereDeArta) {
        this.id = id;
        this.denumire = denumire;
        this.adresa = adresa;
        this.opereDeArta = opereDeArta;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<OperaDeArtaPlastica> getOpereDeArta() {
        return opereDeArta;
    }

    public void setOpereDeArta(List<OperaDeArtaPlastica> opereDeArta) {
        this.opereDeArta = opereDeArta;
    }

    public void addOperaDeArta(OperaDeArtaPlastica operaDeArtaPlastica) {
        opereDeArta.add(operaDeArtaPlastica);
    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.getDenumire()+ " - institutia cu ID-ul  " + this.getId());
    	if (this instanceof Muzeu) {
    		sb.append(", tip: Muzeu");
    	} else if (this instanceof GalerieArta) {
    		sb.append(", tip: Galerie de Arta");
    	}
    	sb.append(", adresa " + this.getAdresa() + ":\n");
		for (OperaDeArtaPlastica o : this.getOpereDeArta()) {
			sb.append("\t" + o.getTitlu() + " - " + o.getNumeArtist() + " - " + o.getAnulRealizarii() + "\n");
		}
		return sb.toString();
    }
}

