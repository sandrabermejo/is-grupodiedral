package diedral.acex;	

import java.awt.EventQueue;

import diedral.acex.gui.VentanaPrincipal;

/**
 * Clase principal de la aplicación.
 */
public class Main {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable () {
			public void run(){
				VentanaPrincipal principal = new VentanaPrincipal();
				
				principal.setDefaultCloseOperation(VentanaPrincipal.EXIT_ON_CLOSE);
				
				principal.setVisible(true);
			}
		});
	}
}
