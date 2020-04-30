package Model;

import java.io.Serializable;

public class SculpturaMuzeu extends Sculptura implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SculpturaMuzeu(String titlu, String numeArtist, int anulRealizarii, String tipSculptura, int idInst) {
        super(titlu, numeArtist, anulRealizarii, tipSculptura, idInst);
    }
	
	public String toString() {
		return getTitlu() + " - " + getNumeArtist() + ", an: " + getAnulRealizarii() + 
				", tip: " + getTipSculptura();
	}
}
