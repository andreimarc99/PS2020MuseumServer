package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CitireUser {
	private Database database;
	
	public List<User> getUsers() {
		List<Angajat> angajati = new CitireUser().findAllAngajati();
		List<Administrator> admini = new CitireUser().findAllAdmins();
		List<User> users = new ArrayList<User>();
		
		for (Angajat a : angajati) {
			users.add(a);
		}
		
		for (Administrator a : admini) {
			users.add(a);
		}
		return users;
	}
	
	public List<Administrator> findAllAdmins() {
		database = new Database();
		ResultSet resultSet = database.executeStatement("select * from ADMINISTRATOR;");

		final List<Administrator> users = new ArrayList<Administrator>();

		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					final String username = resultSet.getString("USERNAME");
					final String password = resultSet.getString("PAROLA");
					final Administrator user = new Administrator(username, password);
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public List<Angajat> findAllAngajati() {
		database = new Database();
		ResultSet resultSet = database.executeStatement("select * from ANGAJAT;");

		final List<Angajat> users = new ArrayList<Angajat>();

		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					final String username = resultSet.getString("USERNAME");
					final String password = resultSet.getString("PAROLA");
					final Angajat user = new Angajat(username, password);
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
}
