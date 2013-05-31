package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;	
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import diedral.acex.Sesion;
import diedral.acex.Usuario;
import diedral.acex.Vuelo;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;
import diedral.acex.ventas.Compra;

public class PantallaVuelosContratados extends Pantalla {
	
	public PantallaVuelosContratados() {
		
		setLayout(new BorderLayout());
		
		// Tiene vuelos contratados	
		_tablaVuelos = new ModeloTablaVuelos();		
		final JTable tabla = new JTable(_tablaVuelos);		
		add(new JScrollPane(tabla));
		
		JButton boton = new JButton("Ver información detallada");
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tabla.getSelectedRow();
				Compra compra = _tablaVuelos._compras.get(i);
				_mnj.cambiaA(_fabrica.damePantallaDetalleVueloContratado(compra));
			}
			
		});
		add(boton, BorderLayout.SOUTH);
	}
	
	@Override
	public void alCargar() {
		// Obtiene el usuario
		Usuario usuario = _sesion.dameUsuario();
		
		// Usuario válido
		ArrayList<Compra> compras = (ArrayList<Compra>) usuario.dameCompras();
			
		// No ha realizado compras
		if(compras == null || compras.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"El usuario no ha contratado ningún vuelo.",
					"ACE Gestión Externa - Acceso",
					JOptionPane.ERROR_MESSAGE);
			
			/*
			 * Puede ser peligroso acudir al manejador de pantallas
			 * en medio de una operación 
			 */
			_mnj.cierraPantallaActual();
			
			return;
		}
		
		_tablaVuelos.ponVuelos(compras);
	}

	public void estableceContexto(ManejadorPantallas manejador, FabricaPantallas fabrica, Sesion sesion){
    	_mnj = manejador;
    	_fabrica = fabrica;
    	_sesion = sesion;
    }
	
	@ Override
	public String dameNombre() {
		return "Información de vuelo contratado";
	}
	
	/**
	 * Modelo para la tabla de vuelos.
	 *
	 */
	private class ModeloTablaVuelos extends AbstractTableModel {
		
		/**
		 * Fija la lista de vuelos de la tabla.
		 * 
		 * @param vuelos Vector de vuelos.
		 */
		public void ponVuelos(ArrayList<Compra> compras){
			_compras = compras;
			
			fireTableDataChanged();
		}

		/**
		 * Obtiene el número de columnas de la tabla.
		 */
		public int getColumnCount() {
			return _columnas.length;
		}
		
		/**
		 * Obtiene el nombre de las columnas
		 */
		public String getColumnName (int col){
			if (col >= 0 && col < _columnas.length)
				return _columnas[col];
			else
				return "Desconocido";
		}

		/**
		 * Número de filas
		 */
		public int getRowCount() {
			return _compras.size();
		}

		/**
		 * Valor de una celda.
		 */
		public Object getValueAt(int fila, int col) {
			Compra compra = _compras.get(fila);
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
			Vuelo vuelo = _compras.get(fila).dameVuelo();
			
			switch (col){
				case 0 :
					return vuelo.dameNumeroVuelo();
				case 1 :
					return vuelo.dameOrigen();
				case 2 :
					return formatoFecha.format(vuelo.dameFechaSalida().getTime());
				case 3 :
					return vuelo.dameDestino();
				case 4 :
					return formatoFecha.format(vuelo.dameFechaLlegada().getTime());
				case 5:
					return compra.dameBilletes().size();
				default :
					return "--";
			}
		}
		
		/**
		 * Columnas de la tabla.
		 */
		private String[] _columnas = 
			{"Id", "Origen", "Fecha salida", "Destino", "Fecha llegada", "Número de billetes"};
		
		/**
		 * Vector de vuelos mostrados.
		 */
		private ArrayList<Compra> _compras = new ArrayList<Compra>();
		
		/**
		 * Serial UID
		 */
		private static final long serialVersionUID = 6369952481607843951L;
	}
	
	/**
	 * Modelo de tabla de vuelos
	 */
	private ModeloTablaVuelos _tablaVuelos;
	
	/**
	 * Manejador pantallas
	 */
	private ManejadorPantallas _mnj;
	
	/**
	 * Fabrica de pantallas
	 */
	private FabricaPantallas _fabrica;
	
	/**
	 * Sesion
	 */
	private Sesion _sesion;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -3577328506682782280L;
}
