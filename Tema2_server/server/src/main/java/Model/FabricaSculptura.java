package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class FabricaSculptura extends FabricaAbstracta {

	private Database database;

	public void salvareSculpturaMuzeu(SculpturaMuzeu sculptura) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"insert into MUZEU.SCULPTURA_MUZEU (TITLU, ARTIST, AN_REALIZARE, TIP_SCULPTURA, ID_INSTITUTIE) values (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, sculptura.getTitlu());
			preparedStatement.setString(2, sculptura.getNumeArtist());
			preparedStatement.setInt(3, sculptura.getAnulRealizarii());
			preparedStatement.setString(4, sculptura.getTipSculptura());
			preparedStatement.setInt(5, sculptura.getIdInst());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvareSculpturaGalerie(SculpturaGalerieArta sculptura) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"insert into MUZEU.SCULPTURA_GALERIE (TITLU, ARTIST, AN_REALIZARE, TIP_SCULPTURA, ID_INSTITUTIE, PRET) values (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, sculptura.getTitlu());
			preparedStatement.setString(2, sculptura.getNumeArtist());
			preparedStatement.setInt(3, sculptura.getAnulRealizarii());
			preparedStatement.setString(4, sculptura.getTipSculptura());
			preparedStatement.setInt(5, sculptura.getIdInst());
			preparedStatement.setInt(6, sculptura.getPret());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Sculptura buildSculptura(String type, String titlu, String artist, int anRealizare, String tipSculptura,
			int pret, int idInst) {
		Sculptura sculptura = null;
		switch (type) {
		case "Muzeu":
			this.salvareSculpturaMuzeu(new SculpturaMuzeu(titlu, artist, anRealizare, tipSculptura, idInst));
			break;
		case "GalerieArta":
			this.salvareSculpturaGalerie(
					new SculpturaGalerieArta(titlu, artist, anRealizare, tipSculptura, pret, idInst));
			break;
		default:
			System.out.println("Error");
			return null;
		}
		return sculptura;
	}

	public void creareSculpturaMuzeu() {

		String titlu = new String();
		String artist = new String();
		String anRealizare = new String();
		String tipSculptura = new String();
		String denumireMuzeu = new String();
		Integer idMuzeu = 0;
		Integer an = 0;
		titlu = JOptionPane.showInputDialog(null, "Introduceti titlul sculpturii: ");
		if (!titlu.equals("")) {
			artist = JOptionPane.showInputDialog(null, "Introduceti numele artistului: ");
			if (!artist.equals("")) {
				anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				if (!anRealizare.equals("")) {
					tipSculptura = JOptionPane.showInputDialog(null, "Introduceti tipul sculpturii: ");
					if (!tipSculptura.equals("")) {
						denumireMuzeu = JOptionPane.showInputDialog(null,
								"Introduceti ID-ul muzeului de care face parte: ");
						if (!denumireMuzeu.equals("")) {
							try {
								an = Integer.valueOf(anRealizare);
								idMuzeu = Integer.valueOf(denumireMuzeu);
								this.buildSculptura("Muzeu", titlu, artist, an, tipSculptura, 0, idMuzeu);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Format incorect");
							}
						} else {
							denumireMuzeu = JOptionPane.showInputDialog(null,
									"Introduceti ID-ul muzeului de care face parte: ");
						}
					} else {
						tipSculptura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
					}
				} else {
					anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				}
			} else {
				artist = JOptionPane.showInputDialog(null, "Introduceti numeel artistului: ");
			}
		} else {
			titlu = JOptionPane.showInputDialog(null, "Introduceti titlul tabloului: ");
		}

	}

	public void creareSculpturaGalerie() {
		String titlu = new String();
		String artist = new String();
		String anRealizare = new String();
		String tipSculptura = new String();
		String denumireMuzeu = new String();
		String pretStr = new String();
		Integer pret = 0;
		Integer idMuzeu = 0;
		Integer an = 0;
		titlu = JOptionPane.showInputDialog(null, "Introduceti titlul sculpturii: ");
		if (!titlu.equals("")) {
			artist = JOptionPane.showInputDialog(null, "Introduceti numele artistului: ");
			if (!artist.equals("")) {
				anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				if (!anRealizare.equals("")) {
					tipSculptura = JOptionPane.showInputDialog(null, "Introduceti tipul sculpturii: ");
					if (!tipSculptura.equals("")) {
						pretStr = JOptionPane.showInputDialog(null, "Introduceti pretul sculpturii: ");
						if (!pretStr.equals("")) {
							denumireMuzeu = JOptionPane.showInputDialog(null,
									"Introduceti ID-ul muzeului de care face parte: ");
							if (!denumireMuzeu.equals("")) {
								try {
									pret = Integer.valueOf(pretStr);
									an = Integer.valueOf(anRealizare);
									idMuzeu = Integer.valueOf(denumireMuzeu);
									this.buildSculptura("GalerieArta", titlu, artist, an, tipSculptura, pret, idMuzeu);
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(null, "Format incorect");
								}
							} else {
								denumireMuzeu = JOptionPane.showInputDialog(null,
										"Introduceti ID-ul muzeului de care face parte: ");
							}
						} else {
							pretStr = JOptionPane.showInputDialog(null, "Introduceti pretul sculpturii");
						}
					} else {
						tipSculptura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
					}
				} else {
					anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				}
			} else {
				artist = JOptionPane.showInputDialog(null, "Introduceti numeel artistului: ");
			}
		} else {
			titlu = JOptionPane.showInputDialog(null, "Introduceti titlul tabloului: ");
		}
	}

	public SculpturaMuzeu newSculpturaMuzeu() {
		String titlu = new String();
		String artist = new String();
		String anRealizare = new String();
		String tipSculptura = new String();
		String denumireMuzeu = new String();
		Integer idMuzeu = 0;
		Integer an = 0;
		titlu = JOptionPane.showInputDialog(null, "Introduceti titlul sculpturii: ");
		if (!titlu.equals("")) {
			artist = JOptionPane.showInputDialog(null, "Introduceti numele artistului: ");
			if (!artist.equals("")) {
				anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				if (!anRealizare.equals("")) {
					tipSculptura = JOptionPane.showInputDialog(null, "Introduceti tipul sculpturii: ");
					if (!tipSculptura.equals("")) {
						denumireMuzeu = JOptionPane.showInputDialog(null,
								"Introduceti ID-ul muzeului de care face parte: ");
						if (!denumireMuzeu.equals("")) {
							try {
								an = Integer.valueOf(anRealizare);
								idMuzeu = Integer.valueOf(denumireMuzeu);
								return new SculpturaMuzeu(titlu, artist, an, tipSculptura, idMuzeu);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Format incorect");
							}
						} else {
							denumireMuzeu = JOptionPane.showInputDialog(null,
									"Introduceti ID-ul muzeului de care face parte: ");
						}
					} else {
						tipSculptura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
					}
				} else {
					anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				}
			} else {
				artist = JOptionPane.showInputDialog(null, "Introduceti numeel artistului: ");
			}
		} else {
			titlu = JOptionPane.showInputDialog(null, "Introduceti titlul tabloului: ");
		}
		return null;
	}

	public SculpturaGalerieArta newSculpturaGalerie() {
		String titlu = new String();
		String artist = new String();
		String anRealizare = new String();
		String tipSculptura = new String();
		String denumireMuzeu = new String();
		String pretStr = new String();
		Integer pret = 0;
		Integer idMuzeu = 0;
		Integer an = 0;
		titlu = JOptionPane.showInputDialog(null, "Introduceti titlul sculpturii: ");
		if (!titlu.equals("")) {
			artist = JOptionPane.showInputDialog(null, "Introduceti numele artistului: ");
			if (!artist.equals("")) {
				anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				if (!anRealizare.equals("")) {
					tipSculptura = JOptionPane.showInputDialog(null, "Introduceti tipul sculpturii: ");
					if (!tipSculptura.equals("")) {
						pretStr = JOptionPane.showInputDialog(null, "Introduceti pretul sculpturii: ");
						if (!pretStr.equals("")) {
							denumireMuzeu = JOptionPane.showInputDialog(null,
									"Introduceti ID-ul muzeului de care face parte: ");
							if (!denumireMuzeu.equals("")) {
								try {
									pret = Integer.valueOf(pretStr);
									an = Integer.valueOf(anRealizare);
									idMuzeu = Integer.valueOf(denumireMuzeu);
									return new SculpturaGalerieArta(titlu, artist, an, tipSculptura, pret, idMuzeu);
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(null, "Format incorect");
								}
							} else {
								denumireMuzeu = JOptionPane.showInputDialog(null,
										"Introduceti ID-ul muzeului de care face parte: ");
							}
						} else {
							pretStr = JOptionPane.showInputDialog(null, "Introduceti pretul sculpturii");
						}
					} else {
						tipSculptura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
					}
				} else {
					anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				}
			} else {
				artist = JOptionPane.showInputDialog(null, "Introduceti numeel artistului: ");
			}
		} else {
			titlu = JOptionPane.showInputDialog(null, "Introduceti titlul tabloului: ");
		}
		return null;
	}

	public void stergereSculpturaMuzeu(OperaDeArtaPlastica opera) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM MUZEU.SCULPTURA_MUZEU WHERE TITLU = ?");
			preparedStatement.setString(1, opera.getTitlu());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void stergereSculpturaGalerie(OperaDeArtaPlastica opera) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM MUZEU.SCULPTURA_GALERIE WHERE TITLU = ?");
			preparedStatement.setString(1, opera.getTitlu());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editareSculpturaMuzeu(OperaDeArtaPlastica opera, SculpturaMuzeu newOpera) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE MUZEU.SCULPTURA_MUZEU SET TITLU = ?, ARTIST = ?, AN_REALIZARE = ?, TIP_SCULPTURA = ?, ID_INSTITUTIE = ? WHERE TITLU = ?");
			preparedStatement.setString(1, newOpera.getTitlu());
			preparedStatement.setString(2, newOpera.getNumeArtist());
			preparedStatement.setInt(3, newOpera.getAnulRealizarii());
			preparedStatement.setString(4, newOpera.getTipSculptura());
			preparedStatement.setInt(5, newOpera.getIdInst());
			preparedStatement.setString(6, opera.getTitlu());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editareSculpturaGalerie(OperaDeArtaPlastica opera, SculpturaGalerieArta newOpera) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE MUZEU.SCULPTURA_GALERIE SET TITLU = ?, ARTIST = ?, AN_REALIZARE = ?, TIP_SCULPTURA = ?, ID_INSTITUTIE = ?, PRET = ? WHERE TITLU = ?");
			preparedStatement.setString(1, newOpera.getTitlu());
			preparedStatement.setString(2, newOpera.getNumeArtist());
			preparedStatement.setInt(3, newOpera.getAnulRealizarii());
			preparedStatement.setString(4, newOpera.getTipSculptura());
			preparedStatement.setInt(5, newOpera.getIdInst());
			preparedStatement.setInt(6, newOpera.getPret());
			preparedStatement.setString(7, opera.getTitlu());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
