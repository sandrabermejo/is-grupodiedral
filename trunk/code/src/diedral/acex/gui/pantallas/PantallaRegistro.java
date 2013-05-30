/*
 * PaginaRegistro.java - ACE Gestion Externa - Grupo diedral 2013
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

import diedral.acex.GestorUsuarios;
import diedral.acex.Sesion;
import diedral.acex.Usuario;
import diedral.acex.excepciones.UsuarioInvalidoException;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;

public class PantallaRegistro extends Pantalla {
	/**
	 * Constuctor
	 */
	public PantallaRegistro() {
		
		//Caracteristicas ventana
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Variables locales auxiliares
		Dimension dim;
		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de insercion de NOMBRE con su texto
		JPanel panelNombre = new JPanel(new GridLayout(1, 2));
		panelNombre.add(new JLabel("Nombre"));
		panelNombre.add(_nombre = new JTextField(""));
		
		// Acota el tamanio del cuadro de texto para que no quede raro
		dim = panelNombre.getMaximumSize();
		dim.height = _nombre.getPreferredSize().height;
		panelNombre.setMaximumSize(dim);
		panel.add(panelNombre);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de insercion de PRIMER APELLIDO con su texto
		JPanel panelPrimerApellido = new JPanel(new GridLayout(1, 2));
		panelPrimerApellido.add(new JLabel("Primer Apellido"));
		panelPrimerApellido.add(_apellido1 = new JTextField(""));
		
		// Acota el tamanio del cuadro de texto para que no quede raro
		panelPrimerApellido.setMaximumSize(dim);
		panel.add(panelPrimerApellido);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de insercion de SEGUNDO APELLIDO con su texto
		JPanel panelSegundoApellido = new JPanel(new GridLayout(1, 2));
		panelSegundoApellido.add(new JLabel("Segundo Apellido"));
		panelSegundoApellido.add(_apellido2 = new JTextField(""));
		
		// Acota el tamanio del cuadro de texto para que no quede raro
		panelSegundoApellido.setMaximumSize(dim);
		panel.add(panelSegundoApellido);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de insercion de CORREO con su texto
		JPanel panelCorreo = new JPanel(new GridLayout(1, 2));
		panelCorreo.add(new JLabel("Correo"));
		panelCorreo.add(_correo = new JTextField(""));
		
		// Acota el tamanio del cuadro de texto para que no quede raro
		dim = panelCorreo.getMaximumSize();
		dim.height = _correo.getPreferredSize().height;
		panelCorreo.setMaximumSize(dim);
		panel.add(panelCorreo);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
				
		// Crea un cuadro de insercion de CONTRASENA
		JPanel panelContrasena = new JPanel(new GridLayout(1, 2));
		panelContrasena.add(new JLabel("Contrasena"));
		panelContrasena.add(_contrasena = new JPasswordField(""));
		
		// Acota el tamanio del cuadro de texto para que no quede raro
		panelContrasena.setMaximumSize(dim);
		panel.add(panelContrasena);
				
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		JButton registrarse = new JButton("Registrarse");
		registrarse.addActionListener(new Registrarse());
		panel.add(registrarse);
		
		add(panel);
	}
	
	/**
	 * Devuelve el nombre de la ventana
	 */
	public String dameNombre(){
		return "Registrarse";
	}
	
	@Override
	public void estableceContexto(ManejadorPantallas manejador, FabricaPantallas fabrica, Sesion sesion) {
		_mnj = manejador;
		_sesion = sesion;
	}
	private boolean validarDatos(String nombre, String apellido1, String apellido2, String correo, String contrasena){
		return nombre!= null && apellido1 != null && apellido2 != null && correo != null && contrasena != null;
	}
	
	/**
	 * Clase oyente para iniciar sesion
	 *
	 */
	private class Registrarse implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Registramos los datos
			String nombre = _nombre.getText();
			String apellido1 = _apellido1.getText(), apellido2 = _apellido2.getText();
			String correo = _correo.getText();
			String contrasena = new String(_contrasena.getPassword());
			// Comprobamos que todos los campos han sido rellenados
			if(validarDatos(nombre, apellido1, apellido2, correo, contrasena)){
				// Si los datos son validos creamos un usuario con los datos introducidos
				Usuario usuario = new Usuario(nombre, apellido1, apellido2, contrasena, correo);
				try {
					// Introducimos el usuario
					GestorUsuarios.dameInstancia().meteUsuario(usuario);
					_sesion.cargaUsuario(usuario);
					JOptionPane.showConfirmDialog(PantallaRegistro.this, "Usuario regristrado con exito!");
					_mnj.cierraPantallaActual();
				} catch (UsuarioInvalidoException e2) { // Si el usuario ya existe
					JOptionPane.showMessageDialog(PantallaRegistro.this,
					"Datos no validos.",
					"ACE Gestion Externa - Acceso",
					JOptionPane.ERROR_MESSAGE);
				}			
			} else { // Algun campo esta incompleto
				JOptionPane.showMessageDialog(PantallaRegistro.this,
				"Campos de texto incompletos.",
				"ACE Gestion Externa - Acceso",
				JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	// MIEMBROS PRIVADOS
	
	/**
	 * Manejador de pantallas
	 */
	private ManejadorPantallas _mnj;
	
	/**
	 * Sesion actual
	 */
	private Sesion _sesion;

	/**
	 * Campo de nombre
	 */
	private JTextField _nombre;

	/**
	 * Campo de apellido1
	 */
	private JTextField _apellido1;

	/**
	 * Campo de apellido2
	 */
	private JTextField _apellido2;
	
	/**
	 * Campo de correo electronico (contacto)
	 */
	private JTextField _correo;
	
	/**
	 * Campo de contrasena
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
