package Model;

import java.io.Serializable;

public class TablouMuzeu extends Tablou implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TablouMuzeu(String titlu, String numeArtist, int anulRealizarii, String genPictura, String tehnica, int idInst) {
		super(titlu, numeArtist, anulRealizarii, genPictura, tehnica, idInst);
	}

	public String toString() {
		return getTitlu() + " - " + getNumeArtist() + ", an: " + getAnulRealizarii() + 
				" - gen pictura: " + getGenPictura() + ", tehnica " + getTehnica();
	}
}
