/*
 * PantallaSugerencias.java - ACE Gestión Externa - Grupo Diedral 2013
 */

package diedral.acex.gui.pantallas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.beans.Introspector;

import diedral.acex.GestorSugerencias;
import diedral.acex.Sugerencia;
import diedral.acex.excepciones.CampoRequeridoException;
import diedral.acex.excepciones.FormatoIncorrectoException;

public class PantallaSugerencias extends diedral.acex.gui.Pantalla {
	/**
	 * Contruye una pantalla de sugerencias.
	 */
	public PantallaSugerencias(){
		// Añade un distribuidor 'caja'
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// Variable temporal para dimensiones
		Dimension dim;
		
		// Añade una entradilla de texto
		add(new JLabel("Exponga el motivo de su reclamación o sugerencia:"));
		
		add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea el cuadro para escribir el mensaje y lo inserta
		_mensaje = new JTextArea();
		add(new JScrollPane(_mensaje));
		
		add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));

		// Crea un cuadro de inserción de nombre con su texto
		JPanel panelNombre = new JPanel(new GridLayout(1, 2));

		panelNombre.add(new JLabel("Nombre (opcional)"));
		panelNombre.add(_nombre = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		dim = panelNombre.getMaximumSize();
		dim.height = _nombre.getPreferredSize().height;
		panelNombre.setMaximumSize(dim);
		
		add(panelNombre);
		
		add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));

		// Otro panel para el correo electrónico
		JPanel panelContacto = new JPanel(new GridLayout(1, 2));

		panelContacto.add(new JLabel("Correo electrónico (opcional)"));
		panelContacto.add(_contacto = new JTextField(""));
		
		// Valen las mismas dimensiones que antes
		panelContacto.setMaximumSize(dim);

		add(panelContacto);
		
		add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea el botón 'Enviar' y lo añade en un panel nuevo
		JButton enviar = new JButton("Enviar");
		enviar.addActionListener(new EnviarSugerencia());
		enviar.setIcon(new ImageIcon(
				this.getClass().getResource("../iconos/mail-forward.png")));
		
		JPanel botones = new JPanel();
		botones.setLayout(new BoxLayout(botones, BoxLayout.LINE_AXIS));
		botones.add(Box.createHorizontalGlue());
		botones.add(enviar);

		add(botones);
	}

	/**
	 * Manejador del evento de puesta en funcionamiento.
	 */
	public void alMostrar() { }

	/**
	 * Manejador del evento de ocultación.
	 *
	 * @return {@code true} si se acepta la petición, {@code false} si se
	 * rechaza.
	 */
	public boolean alOcultar() {
		return true;
	}

	/**
	 * Manejador del evento de cierre.
	 *
	 * @return {@code true} si se acepta la petición, {@code false} si se
	 * rechaza.
	 */
	public boolean alCerrar() {
		// Si todo está vacío sale directamente
		if (_mensaje.getText().isEmpty() 	&&
				_nombre.getText().isEmpty() &&
				_contacto.getText().isEmpty())
			return true;
		
		// Si no es así, pregunta al usuario
		if (JOptionPane.showConfirmDialog(this,
				"Si abandona esta página perderá los datos introducidos.",
				"ACE - Gestión Externa - Sugerencias",
				JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
			
			_mensaje.setText(""); _nombre.setText(""); _contacto.setText("");
			
			return true;
		}
			
		
		return false;
	}	

	/**
	 * Devuelve el nombre de la ventana
	 */
	public String dameNombre(){
		return "Sugerencias";
	}

	private class EnviarSugerencia implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				
				// Crea una sugerencia (puede generar excepciones)
				Sugerencia sug = new Sugerencia(_mensaje.getText(),
						_nombre.getText(), _contacto.getText());
				
				long ref = GestorSugerencias.dameInstancia().enviarSugerencia(sug);
				
				if (ref == 0)
					JOptionPane.showMessageDialog(PantallaSugerencias.this,
							"No se ha podido registrar la sugerencia.",
							"ACE Gestión Externa - Sugerencias",
							JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(PantallaSugerencias.this,
							"Sugerencia recibida. Número de referencia " + ref + ".",
							"ACE Gestión Externa - Sugerencias",
							JOptionPane.INFORMATION_MESSAGE);
				
				
			} catch (CampoRequeridoException cre) {
				muestraError("Faltan campos requeridos", cre);
			} catch (FormatoIncorrectoException fie) {
				muestraError("Formato incorrecto en los datos", fie);
			}
			
		}
	}
	
	
	// MÉTODOS PRIVADOS
	
	/**
	 * Muestra un mensaje de error causado por una excepción.
	 * 
	 * @param mensaje Causa general del error.
	 * @param exc Excepción para mensaje detallado.
	 */
	private void muestraError(String mensaje, Exception exc){
		JOptionPane.showMessageDialog(this,
				mensaje +
				(exc.getLocalizedMessage() != null
				?		": " + Introspector.decapitalize(exc.getLocalizedMessage()) + "."
				:	"."),
				"ACE Gestión Externa - Sugerencias",
				JOptionPane.ERROR_MESSAGE);
	}
	
	// MIEMBROS PRIVADOS

	/**
	 * Campo de mensaje
	 */
	private JTextArea _mensaje;

	/**
	 * Campo de nombre
	 */
	private JTextField _nombre;

	/**
	 * Campo de correo electrónico (contacto)
	 */
	private JTextField _contacto;
	
	/**
	 * Valor por defecto del espacio vertical entre componentes
	 */
	private static final int INTERESPACIO_VERTICAL = 10;
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 5313233541380924039L;
}