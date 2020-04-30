package Model;


@SuppressWarnings("serial")
public class Angajat extends User {
    public Angajat(String username, String password) {
        super(username, password);
    }
    
    public String toString() {
    	return "Angajat: " + getUsername() + ", parola: " + getPassword();
    }
}
