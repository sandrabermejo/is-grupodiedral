package diedral.acex;

import diedral.acex.gui.VentanaPrincipal;

/**
 * Clase principal de la aplicación.
 */
public class Main {
	public static void main(String[] args){
		VentanaPrincipal mw = new VentanaPrincipal();
		mw.setDefaultCloseOperation(VentanaPrincipal.EXIT_ON_CLOSE);

		mw.setVisible(true);
	}
}
