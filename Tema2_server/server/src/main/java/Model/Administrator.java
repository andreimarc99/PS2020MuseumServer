package Model;

@SuppressWarnings("serial")
public class Administrator extends User {
    public Administrator(String username, String password) {
        super(username, password);
    }
    public String toString() {
    	return "Admin: " + getUsername();
    }
}
