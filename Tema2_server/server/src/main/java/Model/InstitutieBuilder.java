package Model;

import java.util.List;

public class InstitutieBuilder {

	private String denumire;
	private int id;
    private String adresa;
    private List<OperaDeArtaPlastica> opereDeArta;
    
    public InstitutieBuilder withDenumire(String denumire) {
    	this.denumire = denumire;
    	return this;
    }
    
    public InstitutieBuilder withId(int id) {
    	this.id = id;
    	return this;
    }
    
    public InstitutieBuilder withAdresa(String adresa) {
    	this.adresa = adresa;
		return this;
    }
    
    public InstitutieBuilder withOpere(List<OperaDeArtaPlastica> opere) {
    	this.opereDeArta = opere;
    	return this;
    }
    
    public Institutie build() {
    	return new Institutie(denumire, id, adresa, opereDeArta);
    }
}
