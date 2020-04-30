package Model;

import java.io.Serializable;

public class TablouGalerieArta extends Tablou implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pret;

    public TablouGalerieArta(String titlu, String numeArtist, int anulRealizarii, String genPictura, String tehnica, int pret, int idInst) {
        super(titlu, numeArtist, anulRealizarii, genPictura, tehnica, idInst);
        this.pret = pret;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
    
    public String toString() {
    	return getTitlu() + " - " + getNumeArtist() + ", an: " + getAnulRealizarii() +
    			" - gen pictura: " + getGenPictura() + ", tehnica " + getTehnica() +
				", pret: " + getPret();
    }
}
