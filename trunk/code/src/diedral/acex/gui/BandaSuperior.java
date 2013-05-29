package diedral.acex.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import diedral.acex.Sesion;
import diedral.acex.eventos.OyenteCambios;

/**
 * Banda superior para el manejo de la aplicación.
 */
class BandaSuperior extends JPanel implements OyenteCambios<Sesion> {
	/**
	 * Crea la banda superior de la aplicación.
	 * 
	 * @param mnj Manejador de pantallas.
	 * @param fabrica Fábrica.
	 * @param sesion Sesión.
	 */
	public BandaSuperior(ManejadorPantallas mnj, FabricaPantallas fabrica){		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		_mnj = mnj;
		_fabrica = fabrica;
		
		// Crea el botón de registro
		_registro = new JButton("Registrarse");
		_registro.setForeground(Color.RED);
		
		// Crea el boton de acceder
		_acceder = new BotonUsuario("Acceder");
		_acceder.setForeground(Color.RED);
		
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
	
	
	@Override
	public void haCambiado(Sesion arg) {
		_acceder.setText(arg.dameUsuario().dameCorreo());	
	}
	
	
	// OYENTE BOTÓN DE USUARIO
	
	private class BotonUsuario extends JButton {
		BotonUsuario(String texto){
			super(texto);
			
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					_mnj.cambiaA(_fabrica.damePantallaAcceso());
				}
			});
		}
		
		/**
		 * Serial UID
		 */
		private static final long serialVersionUID = 4417627566354659381L;
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
	 * Botón de acceder
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
