package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import diedral.acex.Compra;
import diedral.acex.PagoTarjeta;
import diedral.acex.Sesion;
import diedral.acex.Usuario;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;

public class PantallaPagoTarjeta extends Pantalla{
	private JTextField _texTitular, _textNumeroTarjeta, _textValorCompra;
	private JComboBox<String> _comboBoxServidores;
	private JButton _finalizarPago;
	public PantallaPagoTarjeta(Compra compra){
		_compra = compra;
		
		//Características ventana
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Variables locales auxiliares
		Dimension dim;
		
		// Crea un cuadro de inserción de nombre con su texto
		JPanel panelNombre = new JPanel(new GridLayout(1, 2));
		panelNombre.add(new JLabel("Titular"));
		panelNombre.add(_texTitular = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		dim = panelNombre.getMaximumSize();
		dim.height = _texTitular.getPreferredSize().height;
		panelNombre.setMaximumSize(dim);
		
		panel.add(panelNombre);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de nombre con su texto
		JPanel panelNumeroTarjeta = new JPanel(new GridLayout(1, 2));
		panelNumeroTarjeta.add(new JLabel("Número de Tarjeta"));
		panelNumeroTarjeta.add(_textNumeroTarjeta = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		panelNumeroTarjeta.setMaximumSize(dim);
		
		panel.add(panelNumeroTarjeta);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		//Panel que te da el valor de la compra
		JPanel panelValorCompra = new JPanel(new GridLayout(1, 2));
		panelValorCompra.add(new JLabel("Cantidad a pagar"));
		_importeCompra = _compra.calculaPrecio();
		_textValorCompra = new JTextField(_importeCompra + "");
		_textValorCompra.setEnabled(false);
		panelValorCompra.add(_textValorCompra);
		
		// Acota el tamaño del cuadro de texto para que no quede raro
		panelValorCompra.setMaximumSize(dim);
		
		panel.add(panelValorCompra);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		JPanel panelServidores = new JPanel(new GridLayout(1, 2));
		_servidores = new Vector<String>();
		_servidores.add("MasterCard");
		_servidores.add("Visa");
		_servidores.add("Maestro");
		_servidores.add("Discover");
		_comboBoxServidores = new JComboBox<String>(_servidores);
		panelServidores.add(_comboBoxServidores);
		
		_finalizarPago = new JButton("Finalizar pago");
		panelServidores.add(_finalizarPago);
		_finalizarPago.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				introducirDatos();
			}
		});
		
		panel.add(panelServidores);
		panelServidores.setMaximumSize(dim);
		
		//añadimos el panel a la ventana
		add(panel);
		
		introducirDatos(); //introducimos los datos que el cliente ha metido por 
	}
	private void introducirDatos(){
		String titular, numeroTarjeta, servidor;		
		titular = _texTitular.getText();
		numeroTarjeta = _textNumeroTarjeta.getText();
		servidor = _servidores.get(_comboBoxServidores.getSelectedIndex());
		if(titular != null && numeroTarjeta != null && servidor != null){
			_pagoTarjeta = new PagoTarjeta(_compra, titular, numeroTarjeta, _importeCompra); 
			if(!_pagoTarjeta.efectuar())
				JOptionPane.showMessageDialog(this, "El pago no se ha podido procesar. Datos incorrectos.");
			else
				JOptionPane.showMessageDialog(this, "La compra ha sido procesada correctamente. Gracias por confiar en nosotros.");
		} else
			JOptionPane.showMessageDialog(this, "Error. Rellene todos los campos obligatorios.");
	}
	
	@Override
	public String dameNombre() {
		return "Pago con Tarjeta";
	}

	
	/**
	 * UID Serial Version
	 */
	private static final long serialVersionUID = 5793918530048031037L;
	
	/**
	 * Pago con la tarjeta.
	 */
	private PagoTarjeta _pagoTarjeta;
	/**
	 * Compra que se va a pagar.
	 */
	private Compra _compra;
	 /**
	  *  Constante que indica un tamaño de Interespacio Vertical entre componentes.
	 */
	private static final int INTERESPACIO_VERTICAL = 10;
	/**
	 * Vector que tiene los nombres de los tipos de tarjetas de crédito con las que se puede pagar.
	 */
	private static Vector<String> _servidores;
	/**
	 * Importe de la compra a cobrar.
	 */
	private double _importeCompra;
	/**
	 * Usuario del sistema que quiere modificar sus datos.
	 */
	
}
