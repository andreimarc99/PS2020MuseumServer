package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalvareInstitutii {
	private Database database;

	public void salvareInstitutie(final Institutie institutie) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection
					.prepareStatement("insert into MUZEU.INSTITUTIE (DENUMIRE, ADRESA) values (?, ?)");
			preparedStatement.setString(1, institutie.getDenumire());
			preparedStatement.setString(2, institutie.getAdresa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (OperaDeArtaPlastica o : institutie.getOpereDeArta()) {
			if (o instanceof TablouMuzeu) {
				new FabricaTablou().salvareTablouMuzeu((TablouMuzeu) o);
			} else if (o instanceof TablouGalerieArta) {
				new FabricaTablou().salvareTablouGalerie((TablouGalerieArta) o);
			} else if (o instanceof SculpturaMuzeu) {
				new FabricaSculptura().salvareSculpturaMuzeu((SculpturaMuzeu) o);
			} else {
				new FabricaSculptura().salvareSculpturaGalerie((SculpturaGalerieArta) o);
			}
		}
	}
}
