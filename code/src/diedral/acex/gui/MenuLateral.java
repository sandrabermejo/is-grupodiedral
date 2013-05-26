package diedral.acex.gui;

import java.awt.GridLayout;
import javax.swing.JButton;

/**
 * Menú lateral para dar acceso a los diferentes servicios de la aplicación.
 */
class MenuLateral extends javax.swing.JPanel {
	/**
	 * Crea el menú lateral por defecto.
	 */
	public MenuLateral(){		
		setLayout(new GridLayout(2, 1));

		add(new JButton("Consutar vuelos"));
		add(new JButton("Sugerencias"));
	}
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 6375760000993414292L;
}
