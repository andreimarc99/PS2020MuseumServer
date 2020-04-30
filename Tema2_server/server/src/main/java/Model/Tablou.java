package Model;

import java.io.Serializable;

public abstract class Tablou extends OperaDeArtaPlastica implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String genPictura;
    private String tehnica;
    
    public Tablou(String titlu, String numeArtist, int anulRealizarii, String genPictura, String tehnica, int idInst) {
        super(titlu, numeArtist, anulRealizarii, idInst);
        this.genPictura = genPictura;
        this.tehnica = tehnica;
    }

    public String getTehnica() {
        return tehnica;
    }

    public void setTehnica(String tehnica) {
        this.tehnica = tehnica;
    }

    public String getGenPictura() {
        return genPictura;
    }

    public void setGenPictura(String genPictura) {
        this.genPictura = genPictura;
    }
}
