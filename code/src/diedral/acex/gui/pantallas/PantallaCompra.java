package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import diedral.acex.Billete;
import diedral.acex.Compra;
import diedral.acex.Dni;
import diedral.acex.Pasajero;
import diedral.acex.Vuelo;
import diedral.acex.excepciones.CampoRequeridoException;
import diedral.acex.excepciones.FormatoIncorrectoException;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;

public class PantallaCompra extends Pantalla {

	public PantallaCompra(ManejadorPantallas mnj, FabricaPantallas fabrica, Vuelo vuelo, int numBilletes) {
		_mnj = mnj;
		_fabrica = fabrica;
		_vuelo = vuelo;
		_numBilletes = numBilletes;
		_numPasajerosAnadidos = 0;
	//	_compra = new Compra(_mnjSesion.dameUsuarioSesion());
		
		//Características ventana
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Variables locales auxiliares
		Dimension dim;
		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de nombre con su texto
		JPanel panelNombre = new JPanel(new GridLayout(1, 2));
		panelNombre.add(new JLabel("Nombre"));
		panelNombre.add(_nombre = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		dim = panelNombre.getMaximumSize();
		dim.height = _nombre.getPreferredSize().height;
		panelNombre.setMaximumSize(dim);
		panel.add(panelNombre);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de primer apellido con su texto
		JPanel panelApellido1 = new JPanel(new GridLayout(1, 2));
		panelApellido1.add(new JLabel("Primer apellido"));
		panelApellido1.add(_apellido1 = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		panelApellido1.setMaximumSize(dim);
		panel.add(panelApellido1);		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de segundo apellido con su texto
		JPanel panelApellido2 = new JPanel(new GridLayout(1, 2));
		panelApellido2.add(new JLabel("Segundo apellido"));
		panelApellido2.add(_apellido2 = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		panelApellido2.setMaximumSize(dim);
		panel.add(panelApellido2);		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de nacionalidad con su texto
		JPanel panelNacionalidad = new JPanel(new GridLayout(1, 2));
		panelNacionalidad.add(new JLabel("Nacionalidad"));
		panelNacionalidad.add(_nacionalidad = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		panelNacionalidad.setMaximumSize(dim);
		panel.add(panelNacionalidad);		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de fecha de nacimiento con su texto
		JPanel panelNacimiento = new JPanel(new GridLayout(1, 2));
		panelNacimiento.add(new JLabel("Fecha de nacimiento"));
		
		_fnacimiento = new JFormattedTextField(new GregorianCalendar());
		Dimension dimFecha = _fnacimiento.getPreferredSize();
		dim.width *= 2;
		
		_fnacimiento.setMaximumSize(dimFecha);
		_fnacimiento.setPreferredSize(dimFecha);
		
		panelNacimiento.add(_fnacimiento);
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		panelNacimiento.setMaximumSize(dim);
		panel.add(panelNacimiento);		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de DNI con su texto
		JPanel panelDni = new JPanel(new GridLayout(1, 2));
		panelDni.add(new JLabel("DNI"));
		panelDni.add(_dni = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		panelDni.setMaximumSize(dim);
		panel.add(panelDni);		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de DNI con su texto
		JPanel panelClase = new JPanel(new GridLayout(1, 2));
		panelClase.add(new JLabel("Clase"));
		panelClase.add(_clase = new JComboBox<Billete.Clase>());
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		panelClase.setMaximumSize(dim);
		panel.add(panelClase);		
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		
		JButton anadirPasajero = new JButton("Añadir pasajero");
		anadirPasajero.addActionListener(new AnadirPasajero());

		panel.add(anadirPasajero);
		this.add(panel);		
	}
	
	@Override
	public String dameNombre() {
		return "Compra";
	}
	
	private class AnadirPasajero implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String nombre = _nombre.getText();
				if (nombre == null)
					throw new CampoRequeridoException("Debe introducir el nombre");
				
				String apellido1 = _apellido1.getText();
				if (apellido1 == null)
					throw new CampoRequeridoException("Debe introducir el primer apellido");
				
				String apellido2 = _apellido2.getText();
				if (apellido2 == null)
					throw new CampoRequeridoException("Debe introducir el segundo apellido");
				
				String nacionalidad = _nacionalidad.getText();
				if (nacionalidad == null)
					throw new CampoRequeridoException("Debe introducir la nacionalidad");
				
				if (!_fnacimiento.isEditValid())
					throw new FormatoIncorrectoException("La fecha de nacimiento no es válida");
				
				// else
				
				GregorianCalendar fecha = (GregorianCalendar) _fnacimiento.getValue();
													
				String caddni = _dni.getText();
				
				char letra = caddni.charAt(caddni.length());
				caddni.substring(0, caddni.length()-1);
				int numero = Integer.parseInt(caddni);
				
				Dni dni = new Dni(numero, letra);
				
				Billete.Clase clase = (Billete.Clase) _clase.getSelectedItem();
				
				Pasajero pasajero = new Pasajero(nombre, apellido1, apellido2, nacionalidad, fecha, dni);
		//		_compra.anadeBillete(new Billete(_vuelo, pasajero, clase, _vuelo.damePrecio()));
				_numPasajerosAnadidos++;
				
				if (_numPasajerosAnadidos == _numBilletes)
;//					_mnj.cambiaA(_fabrica.damePantallaPago(_compra));
				
			} catch(Exception exc){
				JOptionPane.showMessageDialog(PantallaCompra.this,
						exc.getMessage(),
						"ACE Gestión Externa - Compra",
						JOptionPane.ERROR_MESSAGE);
			}			
		}		
	}
	
	/**
	 * Compra
	 */
	private Compra _compra;
	
	/**
	 * Vuelo
	 */
	private Vuelo _vuelo;
	
	/**
	 * Número de billetes a comprar
	 */
	private int _numBilletes;
	
	/**
	 * Número de pasajeros añadidos al vuelo
	 */
	private int _numPasajerosAnadidos;
	
	/**
	 * Nombre del pasajero
	 */
	private JTextField _nombre;
	
	/**
	 * Primero apellido del pasajero
	 */
	private JTextField _apellido1;
	
	/**
	 * Segundo apellido del pasajero
	 */
	private JTextField _apellido2;
	
	/**
	 * Nacionalidad del pasajero
	 */
	private JTextField _nacionalidad;
	
	/**
	 * Fecha de nacimiento
	 */
	private JFormattedTextField _fnacimiento;
	
	/**
	 * DNI
	 */
	private JTextField _dni;
	
	/**
	 * Clase
	 */
	private JComboBox<Billete.Clase> _clase;
	
	/**
	 * Manejador de pantallas
	 */
	private ManejadorPantallas _mnj;
	
	/**
	 * Fabrica de pantallas
	 */
	private FabricaPantallas _fabrica;
	
	/**
	 * Valor por defecto del espacio vertical entre componentes
	 */
	private static final int INTERESPACIO_VERTICAL = 10;	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4829215485539880056L;
}
