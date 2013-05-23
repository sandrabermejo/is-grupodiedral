package diedral.acex.gui;

import java.awt.BorderLayout;

/**
 * Ventana principal de la interfaz de gestión externa de ACE.
 *
 */
public class VentanaPrincipal extends javax.swing.JFrame {
	/**
	 * Construye una ventana principal inicialmente vacía.
	 */
	public VentanaPrincipal(){
		super("ACE - Gestión interna");

		setSize(800, 600);

		add(new MenuLateral(), BorderLayout.WEST);
		add(new BandaSuperior(), BorderLayout.NORTH);
	}
}
