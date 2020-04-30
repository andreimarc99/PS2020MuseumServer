package Model;

import java.io.Serializable;

public abstract class Sculptura extends OperaDeArtaPlastica implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipSculptura;

    public Sculptura(String titlu, String numeArtist, int anulRealizarii, String tipSculptura, int idInst) {
        super(titlu, numeArtist, anulRealizarii, idInst);
        this.tipSculptura = tipSculptura;
    }

    public String getTipSculptura() {
        return tipSculptura;
    }

    public void setTipSculptura(String tipSculptura) {
        this.tipSculptura = tipSculptura;
    }
}
