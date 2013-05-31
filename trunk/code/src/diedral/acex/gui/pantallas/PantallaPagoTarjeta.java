package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import diedral.acex.Sesion;
import diedral.acex.Usuario;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;
import diedral.acex.ventas.Compra;
import diedral.acex.ventas.PagoTarjeta;

public class PantallaPagoTarjeta extends Pantalla{
	/**
	 * Clase interna privada que contiene dos String con el nombre de un servidor y otro con la dirección donde se encuentra su icono.
	 */
	private class DatosServidores{
		public DatosServidores(String nombre, String direccionIcono){
			_nombre = nombre;
			_direccionIcono = direccionIcono;
		}
		private String _nombre;
		private String _direccionIcono;
	}
	public PantallaPagoTarjeta(Compra compra){
		if(compra == null) {
			JOptionPane.showMessageDialog(this, "No puede pagar una compra vacía. Por favor seleccione una compra antes de realizar un pago.");
			_mnj.cierraPantallaActual();
		}
			
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
		_textNumeroTarjeta = new JTextField("");
		panelNumeroTarjeta.add(_textNumeroTarjeta);
		
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
		
		
		//Comienza el añadido de la lista de servidores a elegir
		_servidores = new ButtonGroup();
		inicializaServidores(); //inicializamos los servidores que tiene el sistema
		JPanel panelServidores = new JPanel();
		panelServidores.setLayout(new BoxLayout(panelServidores, BoxLayout.LINE_AXIS));
		for (DatosServidores servidor: _datosServidores){
			JRadioButton boton = new JRadioButton();
			_servidores.add(boton);
			panelServidores.add(boton);
			panelServidores.add(new JLabel(new ImageIcon(this.getClass().getResource(servidor._direccionIcono))));
			panelServidores.add(Box.createHorizontalGlue());
		}
		panel.add(panelServidores);
		
		//ahora añadimos el boton de finalizar pago compra
		JPanel panelFinalizar = new JPanel();
		panelFinalizar.setLayout(new BoxLayout(panelFinalizar, BoxLayout.LINE_AXIS));
		panelFinalizar.add(Box.createHorizontalGlue());
		_finalizarPago = new JButton("Finalizar pago");
		panelFinalizar.add(_finalizarPago);
		_finalizarPago.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				introducirDatos();
			}
		});
		
		panel.add(Box.createVerticalStrut(2*INTERESPACIO_VERTICAL));
		panel.add(panelFinalizar);
		panelServidores.setMaximumSize(dim);
		
		//añadimos el panel a la ventana
		add(panel);
	}
	/**
	 * Inicializa la lista de servidores con el nombre de cada servidor y la direccion donde tiene la imagen de icono a cargar.
	 */
	private void inicializaServidores(){
		_datosServidores = new ArrayList<DatosServidores>();
		_datosServidores.add(new DatosServidores("Mastercard", "../iconos/mastercard.jpg"));
		_datosServidores.add(new DatosServidores("Visa", "../iconos/visa.jpg"));
		_datosServidores.add(new DatosServidores("Maestro", "../iconos/maestro.jpg"));
		_datosServidores.add(new DatosServidores("Discoverer", "../iconos/discoverer.jpg"));
	}
	private void introducirDatos(){
		String titular, numeroTarjeta;		
		titular = _texTitular.getText();
		numeroTarjeta = _textNumeroTarjeta.getText();
		if(titular == null){
			JOptionPane.showMessageDialog(this, "Rellene el titular, por favor.");
		} else if (numeroTarjeta == null){
			JOptionPane.showMessageDialog(this, "Rellene el número de Tarjeta, por favor.");
		} else {
			if(numeroTarjeta.length() == 16) {
				_pagoTarjeta = new PagoTarjeta(_compra, titular, numeroTarjeta, _importeCompra); 
				if(!_pagoTarjeta.efectuar())
					JOptionPane.showMessageDialog(this, "El pago no se ha podido procesar. Datos incorrectos.");
				else {
					JOptionPane.showMessageDialog(this, "La compra ha sido procesada " +
							"correctamente. Gracias por confiar en nosotros.");
					Usuario us = _sesion.dameUsuario();
					if(us != null)
						us.añadeCompra(_compra);
					_mnj.cierraPantallaActual();
				}
			} else
				JOptionPane.showMessageDialog(this, "El número de tarjeta de la cuenta bancaria" +
						" no tiene el número de caracteres requeridos.");
		} 
	}
	
	@Override
	public String dameNombre() {
		return "Pago con Tarjeta";
	}
	public void estableceContexto(ManejadorPantallas manejador, FabricaPantallas fabrica,
			Sesion sesion) {
		_mnj = manejador;
		_fabrica = fabrica;
		_sesion = sesion;
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
	 * Grupo que tiene los nombres de los tipos de tarjetas de crédito con las que se puede pagar.
	 */
	private static ButtonGroup _servidores;
	/**
	 * Vector que contiene los datos de los servidores a cargar.
	 */
	private static ArrayList<DatosServidores> _datosServidores;
	
	/**
	 * Importe de la compra a cobrar.
	 */
	private double _importeCompra;
	/**
	 * Atributo que con los métodos que te generan nuevas pantallas.
	 */
	private FabricaPantallas _fabrica;
	/**
	 * Atributo con el que se maneja las pantallas.
	 */
	private ManejadorPantallas _mnj;
	
	/**
	 * Sesion
	 */
	private Sesion _sesion;
	
	/**
	 * Cajas de texto de los campos a rellenar
	 */
	private JTextField _texTitular, _textNumeroTarjeta, _textValorCompra;
	/**
	 * Botón de finalizar pago.
	 */
	private JButton _finalizarPago;
}
