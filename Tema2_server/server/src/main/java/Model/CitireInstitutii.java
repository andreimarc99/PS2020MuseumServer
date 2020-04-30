package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitireInstitutii {
	private Database database;

	public int getIdFromDenumire(String denumire) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM INSTITUTIE WHERE DENUMIRE = ?");
			preparedStatement.setString(1, denumire);
			resultSet = preparedStatement.executeQuery();
			int id = 0;
			if (resultSet.next()) {
				id = resultSet.getInt("ID");
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<OperaDeArtaPlastica> getOpereForInstitutie(int id) {
		List<OperaDeArtaPlastica> opere = new ArrayList<OperaDeArtaPlastica>();
		database = new Database();
		final Connection connection = database.getConnection();

		ResultSet resultSetTablouriMuzeu = null;
		PreparedStatement preparedStatementTabMuzeu;

		try {
			preparedStatementTabMuzeu = connection.prepareStatement(
					"SELECT * FROM MUZEU.tablou_muzeu as tab INNER JOIN INSTITUTIE as inst ON tab.ID_INSTITUTIE = ? where tab.id_institutie = inst.id;");
			preparedStatementTabMuzeu.setInt(1, id);
			resultSetTablouriMuzeu = preparedStatementTabMuzeu.executeQuery();
			while (resultSetTablouriMuzeu.next()) {
				String titlu = resultSetTablouriMuzeu.getString("TITLU");
				String artist = resultSetTablouriMuzeu.getString("ARTIST");
				int an = resultSetTablouriMuzeu.getInt("AN_REALIZARE");
				String genPictura = resultSetTablouriMuzeu.getString("GEN_PICTURA");
				String tehnica = resultSetTablouriMuzeu.getString("TEHNICA");
				int idInst = resultSetTablouriMuzeu.getInt("ID_INSTITUTIE");
				opere.add(new TablouMuzeu(titlu, artist, an, genPictura, tehnica, idInst));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet resultSetTablouriGalerie = null;
		PreparedStatement preparedStatementTabGalerie;

		try {
			preparedStatementTabGalerie = preparedStatementTabMuzeu = connection.prepareStatement(
					"SELECT * FROM MUZEU.TABLOU_GALERIE as tab INNER JOIN INSTITUTIE as inst ON tab.ID_INSTITUTIE = ? where tab.id_institutie = inst.id;");
			preparedStatementTabGalerie.setInt(1, id);
			resultSetTablouriGalerie = preparedStatementTabGalerie.executeQuery();
			while (resultSetTablouriGalerie.next()) {
				String titlu = resultSetTablouriGalerie.getString("TITLU");
				String artist = resultSetTablouriGalerie.getString("ARTIST");
				int an = resultSetTablouriGalerie.getInt("AN_REALIZARE");
				String genPictura = resultSetTablouriGalerie.getString("GEN_PICTURA");
				int pret = resultSetTablouriGalerie.getInt("PRET");
				String tehnica = resultSetTablouriGalerie.getString("TEHNICA");
				int idInst = resultSetTablouriGalerie.getInt("ID_INSTITUTIE");
				opere.add(new TablouGalerieArta(titlu, artist, an, genPictura, tehnica, pret, idInst));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet resultSetSculpturiMuzeu = null;
		PreparedStatement preparedStatementSculptMuzeu;

		try {
			preparedStatementSculptMuzeu = connection.prepareStatement(
					"SELECT * FROM MUZEU.SCULPTURA_MUZEU as tab INNER JOIN INSTITUTIE as inst ON tab.ID_INSTITUTIE = ? where tab.id_institutie = inst.id;");
			preparedStatementSculptMuzeu.setInt(1, id);
			resultSetSculpturiMuzeu = preparedStatementSculptMuzeu.executeQuery();
			while (resultSetSculpturiMuzeu.next()) {
				String titlu = resultSetSculpturiMuzeu.getString("TITLU");
				String artist = resultSetSculpturiMuzeu.getString("ARTIST");
				int an = resultSetSculpturiMuzeu.getInt("AN_REALIZARE");
				String tipSculptura = resultSetSculpturiMuzeu.getString("TIP_SCULPTURA");
				int idInst = resultSetSculpturiMuzeu.getInt("ID_INSTITUTIE");
				opere.add(new SculpturaMuzeu(titlu, artist, an, tipSculptura, idInst));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet resultSetSculpturiGalerie = null;
		PreparedStatement preparedStatementSculptGalerie;

		try {
			preparedStatementSculptGalerie = connection.prepareStatement(
					"SELECT * FROM MUZEU.SCULPTURA_GALERIE as tab INNER JOIN INSTITUTIE as inst ON tab.ID_INSTITUTIE = ? where tab.id_institutie = inst.id;");
			preparedStatementSculptGalerie.setInt(1, id);
			resultSetSculpturiGalerie = preparedStatementSculptGalerie.executeQuery();
			while (resultSetSculpturiGalerie.next()) {
				String titlu = resultSetSculpturiGalerie.getString("TITLU");
				String artist = resultSetSculpturiGalerie.getString("ARTIST");
				int an = resultSetSculpturiGalerie.getInt("AN_REALIZARE");
				String tipSculptura = resultSetSculpturiGalerie.getString("TIP_SCULPTURA");
				int idInst = resultSetSculpturiGalerie.getInt("ID_INSTITUTIE");
				int pret = resultSetSculpturiGalerie.getInt("PRET");
				opere.add(new SculpturaGalerieArta(titlu, artist, an, tipSculptura, pret, idInst));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return opere;
	}

	public List<Institutie> getInstitutii() {
		database = new Database();
		ResultSet resultSet = database.executeStatement("select * from INSTITUTIE;");

		List<Institutie> institutii = new ArrayList<Institutie>();

		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					int id = resultSet.getInt("ID");
					String denumire = resultSet.getString("DENUMIRE");
					String adresa = resultSet.getString("ADRESA");
					Institutie inst = new Institutie(denumire, id, adresa, getOpereForInstitutie(id));
					institutii.add(inst);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//Application.getInstitutii().setInstitutii(institutii);
		return institutii;
	}
}
