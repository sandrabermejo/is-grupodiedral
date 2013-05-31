/*
 * PantallaAcceso.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import diedral.acex.Sesion;
import diedral.acex.Usuario;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;
import diedral.acex.scentral.GestorUsuarios;

public class PantallaAcceso extends Pantalla {

	/**
	 * Crea una pantalla de acceso.
	 * 
	 */
	public PantallaAcceso() {
		
		//Características ventana
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Variables locales auxiliares
		Dimension dim;
		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de nombre con su texto
		JPanel panelCorreo = new JPanel(new GridLayout(1, 2));
		panelCorreo.add(new JLabel("Correo"));
		panelCorreo.add(_correo = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		dim = panelCorreo.getMaximumSize();
		dim.height = _correo.getPreferredSize().height;
		panelCorreo.setMaximumSize(dim);
		panel.add(panelCorreo);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de primer apellido con su texto
		JPanel panelContrasena = new JPanel(new GridLayout(1, 2));
		panelContrasena.add(new JLabel("Contraseña"));
		panelContrasena.add(_contrasena = new JPasswordField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		panelContrasena.setMaximumSize(dim);
		panel.add(panelContrasena);
		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		
		
		// Panel con los botones de iniciar sesion y de olvido de contrasena
		JPanel botones = new JPanel();
		botones.setLayout(new BorderLayout());
				
		// Boton para iniciar sesion
		JButton confirmar = new JButton("Iniciar sesion");
		confirmar.addActionListener(new IniciarSesion());
		botones.add(confirmar, BorderLayout.WEST);
				
		// Boton para restablecer contrasena
		JButton olvido = new JButton("¿Ha olvidado su contrasena?");
		botones.add(olvido, BorderLayout.EAST);
		olvido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				_manejadorPantallas.cambiaA(_fabrica.damePantallaRestablecerContrasena());
            }
		});
		
		panel.add(botones);
		add(panel, BorderLayout.NORTH);
	}

	public String dameNombre() {
		return "Acceso";
	}
	
	@Override
	public void estableceContexto(ManejadorPantallas manejador,
			FabricaPantallas fabrica, Sesion sesion) {
		_manejadorPantallas = manejador;
		_fabrica = fabrica;
		_sesion = sesion;
	}
	
	/**
	 * Clase oyente para iniciar sesión.
	 *
	 */
	private class IniciarSesion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String correo = _correo.getText();
			
			if(correo.isEmpty() || correo == null) {
				JOptionPane.showMessageDialog(PantallaAcceso.this,
						"Introduzca su cuenta de correo.",
						"ACE Gestión Externa - Acceso",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
					
			// Busca el usuario por el correo
			Usuario usuario = GestorUsuarios.dameInstancia().buscaUsuario(correo);
			
			if (usuario == null || !usuario.comprobarContrasena(new String(_contrasena.getPassword())))
				JOptionPane.showMessageDialog(PantallaAcceso.this,
						"ID o constraseña no válida.",
						"ACE Gestión Externa - Acceso",
						JOptionPane.ERROR_MESSAGE);
			else {
				_sesion.cargaUsuario(usuario);
				_manejadorPantallas.cierraPantallaActual();
				 //JOptionPane.showMessageDialog(PantallaAcceso.this, "Sesion iniciada con exito!");
			}
								
		}
		
	}
	
	/**
	 * Manejador de pantallas
	 */
	private ManejadorPantallas _manejadorPantallas;
	
	/**
	 * Fabrica de pantallas
	 */
	private FabricaPantallas _fabrica;
	
	/**
	 * Sesión actual
	 */
	private Sesion _sesion;
	
	/**
	 * Correo
	 */
	private JTextField _correo;
	
	/**
	 * Contraseña
	 */
	private JPasswordField _contrasena;
	
	/**
	 * Valor por defecto del espacio vertical entre componentes
	 */
	private static final int INTERESPACIO_VERTICAL = 10;	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7267686888267890536L;

}
