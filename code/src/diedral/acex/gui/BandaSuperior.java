package diedral.acex.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Banda superior para el manejo de la aplicación.
 */
class BandaSuperior extends javax.swing.JPanel {
	public BandaSuperior(ManejadorPantallas mnj, FabricaPantallas fabrica){		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		_mnj = mnj;
		_fabrica = fabrica;
		
		// Crea el botón de registro
		_registro = new JButton("Registrarse");
		_registro.setForeground(Color.RED);
		
		// Crea el boton de acceder
		_acceder = new JButton("Acceder");
		_acceder.setForeground(Color.RED);
		
		_acceder.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				_mnj.cambiaA(_fabrica.damePantallaAcceso());
			}
			
		});
		
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
		
		add(_acceder);
		
		add(_registro);
	}
	
	
	// ATRIBUTOS PRIVADOS

	/**
	 * Manejador de pantallas
	 */
	private ManejadorPantallas _mnj;
	
	/**
	 * Fabrica de pantallas
	 */
	private FabricaPantallas _fabrica;
	
	/**
	 * Botón de registro
	 */
	private JButton _registro;
	
	/**
	 * Bot�n de acceder
	 */
	private JButton _acceder;
	
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
