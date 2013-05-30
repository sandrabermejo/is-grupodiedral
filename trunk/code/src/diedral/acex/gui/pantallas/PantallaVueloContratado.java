package diedral.acex.gui.pantallas;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import diedral.acex.Billete;
import diedral.acex.Compra;
import diedral.acex.Sesion;
import diedral.acex.Usuario;
import diedral.acex.Vuelo;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;

public class PantallaVueloContratado extends Pantalla {
	
	public PantallaVueloContratado() {
		
		// Si no hay sesión iniciada
		if (_sesion == null) {
			JOptionPane.showMessageDialog(this,
					"No ha iniciado sesión",
					"ACE Gestión Externa - Acceso",
					JOptionPane.ERROR_MESSAGE);
			_mnj.cambiaA(_fabrica.damePantallaInicio());
			return;
		}
		
		// Si hay sesión iniciada
		Usuario usuario = _sesion.dameUsuario();
		
		// Usuario no válido
		if (usuario == null) {
			JOptionPane.showMessageDialog(this,
					"Usuario no válido",
					"ACE Gestión Externa - Acceso",
					JOptionPane.ERROR_MESSAGE);
			_mnj.cambiaA(_fabrica.damePantallaInicio());
			return;			
		}
		
		//Usuario válido
		List<Compra> compras = usuario.dameCompras();
		
		// No ha realizado compras
		if(compras.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"El usuario no ha contratado ningún vuelo.",
					"ACE Gestión Externa - Acceso",
					JOptionPane.ERROR_MESSAGE);
			_mnj.cambiaA(_fabrica.damePantallaInicio());
			return;
		}
		
		// Tiene vuelos contratados	
		_tablaVuelos = new ModeloTablaVuelos();		
		JTable tabla = new JTable(_tablaVuelos);		
		add(new JScrollPane(tabla));		
		
		int numCompras = compras.size();
		Vector<Vuelo> vuelos = new Vector<Vuelo>();
		
		// Para cada compra
		for (int i = 0; i < numCompras; i++) {
			// Añadimos el vuelo
			List<Billete> billetes = compras.get(i).dameBilletes();
			if (billetes.size() != 0)
				vuelos.add(billetes.get(0).dameVuelo());
		}
		
		_tablaVuelos.ponVuelos(vuelos);
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
		public void ponVuelos(Vector<Vuelo> vuelos){
			_vuelos = vuelos;
			
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
			return _vuelos.size();
		}

		/**
		 * Valor de una celda.
		 */
		public Object getValueAt(int fila, int col) {
			Vuelo vuelo = _vuelos.elementAt(fila);
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
			
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
				default :
					return "--";
			}
		}
		
		/**
		 * Columnas de la tabla.
		 */
		private String[] _columnas = 
			{"Id", "Origen", "Fecha salida", "Destino", "Fecha llegada"};
		
		/**
		 * Vector de vuelos mostrados.
		 */
		private Vector<Vuelo> _vuelos = new Vector<Vuelo>();
		
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
	 * Fabrica
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
