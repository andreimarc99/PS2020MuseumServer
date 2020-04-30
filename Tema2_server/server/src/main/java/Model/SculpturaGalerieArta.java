package Model;

import java.io.Serializable;

public class SculpturaGalerieArta extends Sculptura implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pret;

    public SculpturaGalerieArta(String titlu, String numeArtist, int anulRealizarii, String tipSculptura, int pret, int idInst) {
        super(titlu, numeArtist, anulRealizarii, tipSculptura, idInst);
        this.setPret(pret);
    }

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}
	
	public String toString() {
		return getTitlu() + " - " + getNumeArtist() + ", an: " + getAnulRealizarii() + 
				", tip: " + getTipSculptura() + ", pret: " + getPret();
	}
}
