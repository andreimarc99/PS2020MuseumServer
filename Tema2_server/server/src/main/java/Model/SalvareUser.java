package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalvareUser {
	private Database database;

	public void saveUser(final User user) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			if (user instanceof Administrator) {
				preparedStatement = connection.prepareStatement(
					"insert into MUZEU.ADMINISTRATOR (USERNAME, PAROLA) values (?, ?)");
			} else {
				preparedStatement = connection.prepareStatement(
						"insert into MUZEU.ANGAJAT (USERNAME, PAROLA) values (?, ?)");
			}
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(final User user) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			if (user instanceof Administrator) {
				preparedStatement = connection.prepareStatement(
					"DELETE FROM ADMINISTRATOR WHERE ADMINISTRATOR.USERNAME = ? AND ADMINISTRATOR.PAROLA = ?");
			} else {
				preparedStatement = connection.prepareStatement(
						"DELETE FROM ANGAJAT WHERE ANGAJAT.USERNAME = ? AND ANGAJAT.PAROLA = ?");
			}
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edit(final User user, String nume, String parola) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			if (user instanceof Administrator) {
				preparedStatement = connection.prepareStatement(
					"UPDATE ADMINISTRATOR SET USERNAME = ?, PAROLA = ? WHERE ADMINISTRATOR.USERNAME = ? AND ADMINISTRATOR.PAROLA = ?");
			} else {
				preparedStatement = connection.prepareStatement(
						"UPDATE ANGAJAT SET USERNAME = ?, PAROLA = ?  WHERE ANGAJAT.USERNAME = ? AND ANGAJAT.PAROLA = ?");
			}
			preparedStatement.setString(1, nume);
			preparedStatement.setString(2, parola);
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salvare(UserList userList) {
		for (User user : userList.getUsers()) {
			this.saveUser(user);
		}
	}
}
