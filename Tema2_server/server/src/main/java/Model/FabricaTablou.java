package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class FabricaTablou extends FabricaAbstracta {
	private Database database;

	public void salvareTablouMuzeu(TablouMuzeu tablou) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"insert into MUZEU.TABLOU_MUZEU (TITLU, ARTIST, AN_REALIZARE, GEN_PICTURA, TEHNICA, ID_INSTITUTIE) values (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, tablou.getTitlu());
			preparedStatement.setString(2, tablou.getNumeArtist());
			preparedStatement.setInt(3, tablou.getAnulRealizarii());
			preparedStatement.setString(4, tablou.getGenPictura());
			preparedStatement.setString(5, tablou.getTehnica());
			preparedStatement.setInt(6, tablou.getIdInst());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvareTablouGalerie(TablouGalerieArta tablou) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"insert into MUZEU.TABLOU_GALERIE (TITLU, ARTIST, AN_REALIZARE, GEN_PICTURA, PRET, TEHNICA, ID_INSTITUTIE) values (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, tablou.getTitlu());
			preparedStatement.setString(2, tablou.getNumeArtist());
			preparedStatement.setInt(3, tablou.getAnulRealizarii());
			preparedStatement.setString(4, tablou.getGenPictura());
			preparedStatement.setInt(5, tablou.getPret());
			preparedStatement.setString(6, tablou.getTehnica());
			preparedStatement.setInt(7, tablou.getIdInst());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Tablou buildTablou(String type, String titlu, String artist, int anRealizare, String genPictura,
			String tehnica, int pret, int idInst) {
		Tablou tablou = null;
		switch (type) {
		case "Muzeu":
			this.salvareTablouMuzeu(new TablouMuzeu(titlu, artist, anRealizare, genPictura, tehnica, idInst));
			break;
		case "GalerieArta":
			this.salvareTablouGalerie(
					new TablouGalerieArta(titlu, artist, anRealizare, genPictura, tehnica, pret, idInst));
			break;
		default:
			System.out.println("Error");
			return null;
		}
		return tablou;
	}

	public TablouGalerieArta newTablouGalerie() {
		String titlu = new String();
		String artist = new String();
		String anRealizare = new String();
		String genPictura = new String();
		String tehnica = new String();
		String denumireMuzeu = new String();
		String pretStr = new String();
		Integer pret = 0;
		Integer idMuzeu = 0;
		Integer an = 0;
		titlu = JOptionPane.showInputDialog(null, "Introduceti titlul tabloului: ");
		if (!titlu.equals("")) {
			artist = JOptionPane.showInputDialog(null, "Introduceti numele artistului: ");
			if (!artist.equals("")) {
				anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				if (!anRealizare.equals("")) {
					genPictura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
					if (!genPictura.equals("")) {
						tehnica = JOptionPane.showInputDialog(null, "Introduceti tehnica: ");
						if (!tehnica.equals("")) {
							pretStr = JOptionPane.showInputDialog(null, "Introduceti pretul: ");
							if (!pretStr.equals("")) {
								denumireMuzeu = JOptionPane.showInputDialog(null,
										"Introduceti ID-ul muzeului de care face parte: ");
								if (!denumireMuzeu.equals("")) {
									try {
										an = Integer.valueOf(anRealizare);
										pret = Integer.valueOf(pretStr);
										idMuzeu = Integer.valueOf(denumireMuzeu);
										return new TablouGalerieArta(titlu, artist, an, genPictura, tehnica, pret,
												idMuzeu);
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(null, "Format incorect");
									}
								} else {
									denumireMuzeu = JOptionPane.showInputDialog(null,
											"Introduceti ID-ul muzeului de care face parte: ");
								}
							} else {
								pretStr = JOptionPane.showInputDialog(null, "Introduceti pretul: ");
							}
						} else {
							tehnica = JOptionPane.showInputDialog(null, "Introduceti tehnica: ");
						}
					} else {
						genPictura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
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

	public void creareTablouGalerie() {
		String titlu = new String();
		String artist = new String();
		String anRealizare = new String();
		String genPictura = new String();
		String tehnica = new String();
		String denumireMuzeu = new String();
		String pretStr = new String();
		Integer pret = 0;
		Integer idMuzeu = 0;
		Integer an = 0;
		titlu = JOptionPane.showInputDialog(null, "Introduceti titlul tabloului: ");
		if (!titlu.equals("")) {
			artist = JOptionPane.showInputDialog(null, "Introduceti numele artistului: ");
			if (!artist.equals("")) {
				anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				if (!anRealizare.equals("")) {
					genPictura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
					if (!genPictura.equals("")) {
						tehnica = JOptionPane.showInputDialog(null, "Introduceti tehnica: ");
						if (!tehnica.equals("")) {
							pretStr = JOptionPane.showInputDialog(null, "Introduceti pretul: ");
							if (!pretStr.equals("")) {
								denumireMuzeu = JOptionPane.showInputDialog(null,
										"Introduceti ID-ul muzeului de care face parte: ");
								if (!denumireMuzeu.equals("")) {
									try {
										an = Integer.valueOf(anRealizare);
										pret = Integer.valueOf(pretStr);
										idMuzeu = Integer.valueOf(denumireMuzeu);
										buildTablou("GalerieArta", titlu, artist, an, genPictura, tehnica, pret,
												idMuzeu);
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(null, "Format incorect");
									}
								} else {
									denumireMuzeu = JOptionPane.showInputDialog(null,
											"Introduceti ID-ul muzeului de care face parte: ");
								}
							} else {
								pretStr = JOptionPane.showInputDialog(null, "Introduceti pretul: ");
							}
						} else {
							tehnica = JOptionPane.showInputDialog(null, "Introduceti tehnica: ");
						}
					} else {
						genPictura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
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

	public TablouMuzeu newTablouMuzeu() {
		String titlu = new String();
		String artist = new String();
		String anRealizare = new String();
		String genPictura = new String();
		String tehnica = new String();
		String denumireMuzeu = new String();
		Integer idMuzeu = 0;
		Integer an = 0;
		titlu = JOptionPane.showInputDialog(null, "Introduceti titlul tabloului: ");
		if (!titlu.equals("")) {
			artist = JOptionPane.showInputDialog(null, "Introduceti numele artistului: ");
			if (!artist.equals("")) {
				anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				if (!anRealizare.equals("")) {
					genPictura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
					if (!genPictura.equals("")) {
						tehnica = JOptionPane.showInputDialog(null, "Introduceti tehnica: ");
						if (!tehnica.equals("")) {
							denumireMuzeu = JOptionPane.showInputDialog(null,
									"Introduceti ID-ul muzeului de care face parte: ");
							if (!denumireMuzeu.equals("")) {
								try {
									an = Integer.valueOf(anRealizare);
									idMuzeu = Integer.valueOf(denumireMuzeu);
									// buildTablou("Muzeu", titlu, artist, an, genPictura, tehnica, 0, idMuzeu);
									return new TablouMuzeu(titlu, artist, an, genPictura, tehnica, idMuzeu);
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(null, "Format incorect");
								}
							} else {
								denumireMuzeu = JOptionPane.showInputDialog(null,
										"Introduceti ID-ul muzeului de care face parte: ");
							}
						} else {
							tehnica = JOptionPane.showInputDialog(null, "Introduceti tehnica: ");
						}
					} else {
						genPictura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
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

	public void creareTablouMuzeu() {
		String titlu = new String();
		String artist = new String();
		String anRealizare = new String();
		String genPictura = new String();
		String tehnica = new String();
		String denumireMuzeu = new String();
		Integer idMuzeu = 0;
		Integer an = 0;
		titlu = JOptionPane.showInputDialog(null, "Introduceti titlul tabloului: ");
		if (!titlu.equals("")) {
			artist = JOptionPane.showInputDialog(null, "Introduceti numele artistului: ");
			if (!artist.equals("")) {
				anRealizare = JOptionPane.showInputDialog(null, "Introduceti anul realizarii: ");
				if (!anRealizare.equals("")) {
					genPictura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
					if (!genPictura.equals("")) {
						tehnica = JOptionPane.showInputDialog(null, "Introduceti tehnica: ");
						if (!tehnica.equals("")) {
							denumireMuzeu = JOptionPane.showInputDialog(null,
									"Introduceti ID-ul muzeului de care face parte: ");
							if (!denumireMuzeu.equals("")) {
								try {
									an = Integer.valueOf(anRealizare);
									idMuzeu = Integer.valueOf(denumireMuzeu);
									buildTablou("Muzeu", titlu, artist, an, genPictura, tehnica, 0, idMuzeu);
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(null, "Format incorect");
								}
							} else {
								denumireMuzeu = JOptionPane.showInputDialog(null,
										"Introduceti ID-ul muzeului de care face parte: ");
							}
						} else {
							tehnica = JOptionPane.showInputDialog(null, "Introduceti tehnica: ");
						}
					} else {
						genPictura = JOptionPane.showInputDialog(null, "Introduceti genul picturii: ");
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

	public void editareTablouMuzeu(OperaDeArtaPlastica opera, TablouMuzeu newOpera) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE MUZEU.TABLOU_MUZEU SET TITLU = ?, ARTIST = ?, AN_REALIZARE = ?, GEN_PICTURA = ?, TEHNICA = ?, ID_INSTITUTIE = ? WHERE TITLU = ?");
			preparedStatement.setString(1, newOpera.getTitlu());
			preparedStatement.setString(2, newOpera.getNumeArtist());
			preparedStatement.setInt(3, newOpera.getAnulRealizarii());
			preparedStatement.setString(4, newOpera.getGenPictura());
			preparedStatement.setString(5, newOpera.getTehnica());
			preparedStatement.setInt(6, newOpera.getIdInst());
			preparedStatement.setString(7, opera.getTitlu());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editareTablouGalerie(OperaDeArtaPlastica opera, TablouGalerieArta newOpera) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE MUZEU.TABLOU_GALERIE SET TITLU = ?, ARTIST = ?, AN_REALIZARE = ?, GEN_PICTURA = ?, PRET = ?, TEHNICA = ?, ID_INSTITUTIE = ? WHERE TITLU = ?");
			preparedStatement.setString(1, newOpera.getTitlu());
			preparedStatement.setString(2, newOpera.getNumeArtist());
			preparedStatement.setInt(3, newOpera.getAnulRealizarii());
			preparedStatement.setString(4, newOpera.getGenPictura());
			preparedStatement.setInt(5, newOpera.getPret());
			preparedStatement.setString(6, newOpera.getTehnica());
			preparedStatement.setInt(7, newOpera.getIdInst());
			preparedStatement.setString(8, opera.getTitlu());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stergereTablouMuzeu(OperaDeArtaPlastica opera) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"DELETE FROM MUZEU.TABLOU_MUZEU WHERE TITLU = ?");
			preparedStatement.setString(1, opera.getTitlu());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stergereTablouGalerie(OperaDeArtaPlastica opera) {
		database = new Database();
		final Connection connection = database.getConnection();

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(
					"DELETE FROM MUZEU.TABLOU_GALERIE WHERE TITLU = ?");
			preparedStatement.setString(1, opera.getTitlu());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
