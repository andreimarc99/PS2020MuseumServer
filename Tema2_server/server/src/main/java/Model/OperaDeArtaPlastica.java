package Model;

import java.io.Serializable;

public class OperaDeArtaPlastica implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titlu;
    private String numeArtist;
    private int anulRealizarii;
    private int idInst;

    public OperaDeArtaPlastica(String titlu, String numeArtist, int anulRealizarii, int idInst) {
        this.titlu = titlu;
        this.numeArtist = numeArtist;
        this.anulRealizarii = anulRealizarii;
        this.idInst = idInst;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getNumeArtist() {
        return numeArtist;
    }

    public void setNumeArtist(String numeArtist) {
        this.numeArtist = numeArtist;
    }

    public int getAnulRealizarii() {
        return anulRealizarii;
    }

    public void setAnulRealizarii(int anulRealizarii) {
        this.anulRealizarii = anulRealizarii;
    }

	public int getIdInst() {
		return idInst;
	}

	public void setIdInst(int idInst) {
		this.idInst = idInst;
	}
}
