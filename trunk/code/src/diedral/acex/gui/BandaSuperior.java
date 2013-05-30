package diedral.acex.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

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
		
		_registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_mnj.cambiaA(_fabrica.damePantallaRegistro());
			}
		});
		
		// Crea el boton de acceder
		_acceder = new BotonUsuario("Acceder");
		
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
	
	/**
	 * Registra un oyente de acción del botón 'Anterior'
	 * 
	 * @param oyente Oyente.
	 */
	public void registraOyenteAnterior(ActionListener oyente){
		_btnanterior.addActionListener(oyente);
	}
	
	/**
	 * Registra un oyente de acción del botón 'Siguiente'
	 * 
	 * @param oyente Oyente.
	 */
	public void registraOyenteSiguiente(ActionListener oyente){
		_btnsiguiente.addActionListener(oyente);
	}	
	
	@Override
	public void haCambiado(Sesion arg) {
		_sesion = arg;
		
		if (arg.dameUsuario() == null) {
			_acceder.sinUsuarioActivo();
			_registro.setVisible(true);
		}
		else {
			_acceder.usuarioRegistrado(arg.dameUsuario().dameCorreo());
			_registro.setVisible(false);
		}
	}
	
	// OYENTE BOTÓN DE USUARIO
	
	/**
	 * Clase para el botón de usuario.
	 *
	 */
	private class BotonUsuario extends JButton {
		BotonUsuario(String texto){
			super(texto);
			
			sinUsuarioActivo();
			
			crearMenu();
			
			setComponentPopupMenu(_menu);
		}
		
		/**
		 * Muestra el botón con la apariencia correspondiente a un usuario
		 * registrado.
		 * 
		 * @param id Identificador del usuario.
		 */
		public void usuarioRegistrado(String id){
			// Pone el identificador de usuario como texto
			setText(id);
			
			// Lo pinta de gris oscuro (se ven bien)
			setForeground(Color.DARK_GRAY);
			
			// Pone el botón como acceso a edición de usuario
			removeActionListener(AL_ACCEDER);
			addActionListener(AL_EDITAR_USUARIO);
		}
		
		/**
		 * Muestra el botón como si no hubiese usuario registrado.
		 */
		public void sinUsuarioActivo(){
			// Pone Acceder como texto
			setText("Acceder");
			
			// Lo pinta de rojo
			setForeground(Color.RED);
			
			// Pone el botón como acceso a la función acceder
			removeActionListener(AL_EDITAR_USUARIO);
			addActionListener(AL_ACCEDER);
		}
		
		
		// MÉTODOS PRIVADOS (de BotonUsuario)

		/**
		 * Crea el menú.
		 */
		private void crearMenu(){
			// Botón para cerrar sesión
			JMenuItem tmp = new JMenuItem("Cerrar sesión");
			
			tmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (_sesion != null)
						_sesion.expropiarUsuario();
				}
			});

			_menu.add(tmp);
		}
		
		
		// ATRIBUTOS PRIVADOS (de BotonUsuario)
		
		/**
		 * Menú emergente
		 */
		private JPopupMenu _menu = new JPopupMenu();
		
		/**
		 * Acción de acceso de usuario
		 */
		private final ActionListener AL_ACCEDER = new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				_mnj.cambiaA(_fabrica.damePantallaAcceso());
			}
		};
		
		/**
		 * Acción de edición de usuario
		 */
		private final ActionListener AL_EDITAR_USUARIO = new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				_mnj.cambiaA(_fabrica.damePantallaEditarDatosPersonales());
			}
		};
		
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
	 * Sesión actual (para cerrar sesión)
	 */
	private Sesion _sesion;
	
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
	private BotonUsuario _acceder;
	
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
