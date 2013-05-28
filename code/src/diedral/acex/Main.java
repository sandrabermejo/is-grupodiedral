package diedral.acex;	

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import diedral.acex.gui.VentanaPrincipal;

/**
 * Clase principal de la aplicación.
 */
public class Main {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable () {
			public void run(){
				VentanaPrincipal principal = new VentanaPrincipal();
				
				//principal.setDefaultCloseOperation();
				
				principal.setVisible(true);
			}
		});
	}
}
