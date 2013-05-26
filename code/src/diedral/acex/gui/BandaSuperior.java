package diedral.acex.gui;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Banda superior para el manejo de la aplicación.
 */
class BandaSuperior extends javax.swing.JPanel {
	public BandaSuperior(){		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		// Crea el botón de registro
		_registro = new JButton("Registrarse");
		_registro.setForeground(Color.RED);
		
		
		// Crea el botón de retroceso a la página anterior 
		_btnanterior = new JButton();
		
		_btnanterior.setIcon(new ImageIcon(
				this.getClass().getResource("iconos/go-previous.png")));
		
		_btnanterior.setEnabled(false);
		
		// Crea el botón de página siguiente
		_btnsiguiente = new JButton();
		
		_btnsiguiente.setIcon(new ImageIcon(
				this.getClass().getResource("iconos/go-next.png")));
		
		_btnsiguiente.setEnabled(false);
		
		add(_btnanterior);
		
		add(_btnsiguiente);
		
		add(Box.createHorizontalGlue());
		
		add(_registro);
	}
	
	
	// ATRIBUTOS PRIVADOS

	/**
	 * Botón de registro
	 */
	private JButton _registro;
	
	/**
	 * Botón de 'Anterior'
	 */
	private JButton _btnanterior;
	
	/**
	 * Botón de 'Siguiente'
	 */
	private JButton _btnsiguiente;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -472709487953510769L;
}
