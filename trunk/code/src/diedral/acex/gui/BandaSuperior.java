package diedral.acex.gui;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 * Banda superior para el manejo de la aplicación.
 */
class BandaSuperior extends javax.swing.JPanel {
	public BandaSuperior(){		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		add(Box.createHorizontalGlue());
		
		_registro = new JButton("Registrarse");
		
		_registro.setForeground(Color.RED);

		add(_registro);		
	}
	
	
	// ATRIBUTOS PRIVADOS

	/**
	 * Botón de registro
	 */
	private JButton _registro;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -472709487953510769L;
}
