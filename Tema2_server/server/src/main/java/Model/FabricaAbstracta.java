package Model;

public class FabricaAbstracta {

	public static void creareOperaDeArta(String obj) {
		String[] str = obj.split(" ");
		switch (str[0]) {
			case "Tablou":
				switch(str[1]) {
				case "muzeu":
					new FabricaTablou().creareTablouMuzeu();
					break;
				case "galerie":
					new FabricaTablou().creareTablouGalerie();
					break;
				}
				break;
			case "Sculptura":
				switch(str[1]) {
				case "muzeu":
					new FabricaSculptura().creareSculpturaMuzeu();
					break;
				case "galerie":
					new FabricaSculptura().creareSculpturaGalerie();
					break;
				}
				break;
		}
	}
}
