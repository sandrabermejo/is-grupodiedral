/*
 * PantallaRestablecerContrasena.java - ACE Gestión Externa - Grupo Diedral 2013
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
import javax.swing.JTextField;

import diedral.acex.Usuario;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;
import diedral.acex.scentral.GestorUsuarios;

public class PantallaRestablecerContrasena extends Pantalla {

	public PantallaRestablecerContrasena() {
		//Características ventana
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Variables locales auxiliares
		Dimension dim;
		
		// Añade una entradilla de texto
		JLabel info = new JLabel("Un eMail sera enviado a su direccion de correo electronico asociada.");
		panel.add(info);
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
		
		JButton solicitar = new JButton("Solicitar");
		panel.add(solicitar);
		solicitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String correo = _correo.getText();
				// Si el correo no es valido informamos del error
				Usuario usuario = GestorUsuarios.dameInstancia().buscaUsuario(correo);
				if (usuario == null) // No hay un usuario con el correo introducido
					JOptionPane.showMessageDialog(PantallaRestablecerContrasena.this,
							"Correo no valido!",
							"ACE Gestion Externa - Restablecer contrasena",
							JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(PantallaRestablecerContrasena.this, "Mensaje enviado!");
					// Redireccionar a pantalla de inicio?
			}			
		});
		add(panel);
	}

	
	public String dameNombre() {
		return "Restablecer contrasena";
	}
	
	// MIEMBROS PRIVADOS
	
	/**
	 * Manejador de pantallas
	 */
	private ManejadorPantallas _manejadorPantallas;
	
	/**
	 * Fabrica de pantallas
	 */
	private FabricaPantallas _fabrica;
	
	/**
	 * Campo de correo electronico (contacto)
	 */
	private JTextField _correo;
		
	/**
	 * Valor por defecto del espacio vertical entre componentes
	 */
	private static final int INTERESPACIO_VERTICAL = 10;	
}
