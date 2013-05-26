/*
 * PantallaSugerencias.java - ACE Gestión Externa - Grupo Diedral 2013
 */

package diedral.acex.gui.pantallas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import diedral.acex.GestorSugerencias;
import diedral.acex.Sugerencia;
import diedral.acex.excepciones.CampoRequeridoException;
import diedral.acex.excepciones.FormatoIncorrectoException;
import diedral.acex.gui.ManejadorPantallas;

public class PantallaSugerencias extends diedral.acex.gui.Pantalla {
	/**
	 * Contruye una pantalla de sugerencias.
	 */
	public PantallaSugerencias(){
		setBorder(BorderFactory.createCompoundBorder(
    			BorderFactory.createTitledBorder("Sugerencias"),
			BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		setLayout(new GridLayout(5, 1));

		add(new JLabel("Exponga el motivo de su reclamación o sugerencia"));
		add(new JScrollPane(_mensaje = new JTextArea("")));

		JPanel tmp1 = new JPanel(new GridLayout(1, 2));

		tmp1.add(new JLabel("Nombre (opcional)"));
		tmp1.add(_nombre = new JTextField(""));

		JPanel tmp2 = new JPanel(new GridLayout(1, 2));

		tmp2.add(new JLabel("Correo electrónico (opcional)"));
		tmp2.add(_contacto = new JTextField(""));

		add(tmp1);
		add(tmp2);
		
		JButton enviar = new JButton("Enviar");
		enviar.addActionListener(new EnviarSugerencia());

		add(enviar);
	}

	/**
	 * Manejador del evento de puesta en funcionamiento.
	 */
	public void alMostrar() {
	}

	/**
	 * Manejador del evento de ocultación.
	 *
	 * @return {@code true} si se acepta la petición, {@code false} si se
	 * rechaza.
	 */
	public boolean alOcultar() {return false;}

	/**
	 * Manejador del evento de cierre.
	 *
	 * @return {@code true} si se acepta la petición, {@code false} si se
	 * rechaza.
	 */
	public boolean alCerrar() {return false;}

	/**
	 * Establece un manejador de pantallas con el que comunicarse.
	 */
	public void estableceManejador(ManejadorPantallas manejador) {}	

	/**
	 * Devuelve el nombre de la ventana
	 */
	public String dameNombre(){
		return "Sugerencias";
	}

	private class EnviarSugerencia implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Sugerencia sug = new Sugerencia(_mensaje.getText(),
						_nombre.getText(), _contacto.getText());
				
				// Esto claramente no tendría que ser así
				GestorSugerencias gs = new GestorSugerencias();
				
				long ref = gs.enviarSugerencia(sug);
				
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
				JOptionPane.showMessageDialog(PantallaSugerencias.this,
						"Faltan campos requeridos: " + cre.getMessage());
			} catch (FormatoIncorrectoException fie) {
				JOptionPane.showMessageDialog(PantallaSugerencias.this,
						"Formato incorrecto en los datos: " + fie.getMessage());
			}
			
		}
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
	 * Serial UID
	 */
	private static final long serialVersionUID = 5313233541380924039L;
}