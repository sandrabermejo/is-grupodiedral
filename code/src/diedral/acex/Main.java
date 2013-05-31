package diedral.acex;	

import java.awt.EventQueue;

import diedral.acex.gui.VentanaPrincipal;

/**
 * Clase principal de la aplicación.
 */
public class Main {
	/**
	 * Punto de entrada de la aplicación.
	 * 
	 * @param args Parámetros de línea de comandos.
	 */
	public static void main(String[] args){
		
		// Crea la ventana principal y la muestra
		EventQueue.invokeLater(new Runnable () {
			public void run(){
				VentanaPrincipal principal = new VentanaPrincipal();
				
				principal.setDefaultCloseOperation(VentanaPrincipal.EXIT_ON_CLOSE);
				
				principal.setVisible(true);
			}
		});
	}
}
