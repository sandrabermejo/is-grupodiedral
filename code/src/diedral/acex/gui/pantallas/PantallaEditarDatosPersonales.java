package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import diedral.acex.GestorUsuarios;
import diedral.acex.gui.Pantalla;

public class PantallaEditarDatosPersonales extends Pantalla {
	
	public PantallaEditarDatosPersonales(){
		
		//Características ventana
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Variables locales auxiliares
		Dimension dim;
		
		// Crea un cuadro de inserción de nombre con su texto
		JPanel panelNombre = new JPanel(new GridLayout(1, 2));
		panelNombre.add(new JLabel("Nombre"));
		panelNombre.add(_textNombre = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			dim = panelNombre.getMaximumSize();
			dim.height = _textNombre.getPreferredSize().height;
			panelNombre.setMaximumSize(dim);
		panel.add(panelNombre);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de primer apellido con su texto
		JPanel panelApellido1 = new JPanel(new GridLayout(1, 2));
		panelApellido1.add(new JLabel("Primer Apellido"));
		panelApellido1.add(_textApellido1 = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelApellido1.setMaximumSize(dim);
			
		panel.add(panelApellido1);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de segundo apellido con su texto
		JPanel panelApellido2 = new JPanel(new GridLayout(1, 2));
		panelApellido2.add(new JLabel("Segundo Apellido"));
		panelApellido2.add(_textApellido2 = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelApellido2.setMaximumSize(dim);
			
		panel.add(panelApellido2);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de correo con su texto
		JPanel panelCorreo = new JPanel(new GridLayout(1, 2));
		panelCorreo.add(new JLabel("Correo"));
		panelCorreo.add(_textCorreo = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelCorreo.setMaximumSize(dim);
			
		panel.add(panelCorreo);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de contraseña con su texto
		JPanel panelContrasenya = new JPanel(new GridLayout(1, 2));
		panelContrasenya.add(new JLabel("Contraseña"));
		_textContrasenya = new JTextField("");
		_textContrasenya.setEnabled(false); //la contraseña no se puede modificar aqui
		panelContrasenya.add(_textContrasenya);
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelContrasenya.setMaximumSize(dim);
		
		panel.add(panelContrasenya);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de NIF con su texto
		JPanel panelNIF = new JPanel(new GridLayout(1, 2));
		panelNIF.add(new JLabel("NIF"));
		_textNIF = new JTextField("");
		_textNIF.setEnabled(false); //el DNI no se puede modificar aqui
		panelNIF.add(_textNIF);
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelNIF.setMaximumSize(dim);

		panel.add(panelNIF);
		
			
		add(panel); //añadimos el panel al centro.
	}
	@Override
	public String dameNombre() {
		return "Editar datos personales";
	}
	
	public void introducirDatos(){
		String nombre = _textNombre.getText();
		String apellido1 = _textApellido1.getText();
		String apellido2 = _textApellido2.getText();
		String correo = _textCorreo.getText();
		boolean datosValidos = true;
		if(correo != null) //si el correo ha sido modificado
			datosValidos = GestorUsuarios.dameInstancia().validar(correo);
		//if(datosValidos)
			//¿usuario?-> modificalosdatos. ¿Como lo hago? //TODO
		
	}
	/**
	 * UID Serial Version
	 */
	private static final long serialVersionUID = 5520092526372803516L;
	/**
	 * Constante que indica un tamaño de Interespacio Vertical entre componentes.
	 */
	private static final int INTERESPACIO_VERTICAL = 10;
	/**
	 * Campo de nombre.
	 */
	private JTextField _textNombre;
	/**
	 * Campo de primer apellido.
	 */
	private JTextField _textApellido1;
	/**
	 * Campo de segundo apellido.
	 */
	private JTextField _textApellido2;
	/**
	 * Campo de correo.
	 */
	private JTextField _textCorreo;
	/**
	 * Campo de NIF. No puede ser editado aquí.
	 */
	private JTextField _textNIF;
	/**
	 * Campo de contraseña. No puede ser editado aquí.
	 */
	private JTextField _textContrasenya;
}
