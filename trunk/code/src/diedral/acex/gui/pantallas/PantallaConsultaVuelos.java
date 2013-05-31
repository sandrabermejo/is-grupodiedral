/*
 * PaginaConsultaVuelos.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

import diedral.acex.Aeropuerto;
import diedral.acex.Sesion;
import diedral.acex.Vuelo;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;
import diedral.acex.scentral.GestorVuelos;

/**
 * Página de consulta de vuelos.
 */
public class PantallaConsultaVuelos extends Pantalla {

	/**
	 * Crea una pantalla de consulta de vuelos
	 */
	public PantallaConsultaVuelos(){		
		setLayout(new BorderLayout());
		
		// Añade el panel de búsqueda
		add(new PanelBusqueda(), BorderLayout.NORTH);
		
		// Crea y ubica la tabla (con su modelo) de vuelos encontrados
		_tablaVuelos = new ModeloTablaVuelos();
		
		JTable tabla = new JTable(_tablaVuelos);
		add(new JScrollPane(tabla));
		
		// Añade el cambio a información de vuelo seleccionado
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				_manejadorPantallas.cambiaA(_fabrica.damePantallaDetalleVuelo(
						_tablaVuelos.vueloEn(lse.getFirstIndex())));
			}
		});
	}
	
	public String dameNombre() {
		return "Consulta de vuelos";
	}
	
	@Override
	public void estableceContexto(ManejadorPantallas manejador,
			FabricaPantallas fabrica, Sesion sesion) {
		_manejadorPantallas = manejador;
		_fabrica = fabrica;
	}
	
	/**
	 * Panel de búsqueda
	 */
	private class PanelBusqueda extends JPanel {
		/**
		 * Crea un panel de búsqueda.
		 */
		public PanelBusqueda() {
			// Le pone un borde
			setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Buscar"),
					BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			
			// Fija la distribución
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			// Crea una máscara para fechas
			MaskFormatter msk = null;
			
			try {
				 msk = new MaskFormatter("##/##/####");
			}
			catch (ParseException pe){
				// Esto se puede determinar en tiempo de compilación
			}
			
			// Panel temporal para cada fila
			JPanel tpanel = new JPanel();
			tpanel.setLayout(new BoxLayout(tpanel, BoxLayout.LINE_AXIS));

			// ((1)) Primero aeropuertos
			
			// Aeropuerto de origen
			{				
			_origen = new JComboBox<Aeropuerto>(new Vector<Aeropuerto>(GestorVuelos.dameInstancia().dameAeropuertos()));
			_origen.setSelectedIndex(-1);
			
			JButton borrarSelec = new JButton(new ImageIcon(
					this.getClass().getResource("../iconos/edit-clear.png")));
			
			borrarSelec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					_origen.setSelectedIndex(-1);
				}
			});
			
			tpanel.add(new JLabel("Origen: "));
			tpanel.add(Box.createHorizontalStrut(21));
			tpanel.add(_origen);
			tpanel.add(Box.createHorizontalStrut(5));
			tpanel.add(borrarSelec);
			
			}
			
			add(tpanel);
			
			// Aeropuerto de destino
			tpanel = new JPanel();
			tpanel.setLayout(new BoxLayout(tpanel, BoxLayout.LINE_AXIS));
			
			
			// Aeropuerto de destino
			{
			_destino = new JComboBox<Aeropuerto>(new Vector<Aeropuerto>(GestorVuelos.dameInstancia().dameAeropuertos()));
			_destino.setSelectedIndex(-1);
			
			JButton borrarSelec = new JButton(new ImageIcon(
					this.getClass().getResource("../iconos/edit-clear.png")));
			
			borrarSelec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					_destino.setSelectedIndex(-1);
				}
			});
			
			tpanel.add(new JLabel("Destino: "));
			tpanel.add(Box.createHorizontalStrut(15));
			tpanel.add(_destino);
			tpanel.add(Box.createHorizontalStrut(5));
			tpanel.add(borrarSelec);
			
			}
			
			add(tpanel);
			
			add(Box.createVerticalStrut(5));
			
			// ((2)) Fecha salida
			tpanel = new JPanel();
			tpanel.setLayout(new BoxLayout(tpanel, BoxLayout.LINE_AXIS));
			
			_fechaSalidaMin = new JFormattedTextField(msk);
			_fechaLlegadaMax = new JFormattedTextField(msk);
			
			{	
			JButton borrarSelec = new JButton(new ImageIcon(
					this.getClass().getResource("../iconos/edit-clear.png")));
			
			borrarSelec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// Esto no funciona bien
					_fechaSalidaMin.setValue("");
					_fechaLlegadaMax.setText("");
				}
			});
			
			// Añade los componentes con sus correspondientes separaciones
			tpanel.add(new JLabel("Fecha de salida: desde "));
			tpanel.add(Box.createHorizontalStrut(5));
			tpanel.add(_fechaSalidaMin);
			tpanel.add(Box.createHorizontalStrut(5));
			tpanel.add(new JLabel(" hasta "));
			tpanel.add(Box.createHorizontalStrut(5));
			tpanel.add(_fechaLlegadaMax);
			tpanel.add(Box.createHorizontalStrut(5));
			tpanel.add(borrarSelec);
			
			}
			
			add(tpanel);
			add(Box.createVerticalStrut(5));
			
			// ((3)) Botón de búsqueda
			
			tpanel = new JPanel();
			tpanel.setLayout(new BoxLayout(tpanel, BoxLayout.LINE_AXIS));
			tpanel.add(Box.createHorizontalGlue());
			
			JButton btn = new JButton("Buscar");
			
			btn.setIcon(new ImageIcon(
					this.getClass().getResource("../iconos/system-search.png")));
			
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					// Criterio de búsqueda
					GestorVuelos.CriterioBusqueda criterio = new GestorVuelos.CriterioBusqueda();	
					
					criterio.conOrigen(_origen.getItemAt(_origen.getSelectedIndex()));
					criterio.conDestino(_destino.getItemAt(_destino.getSelectedIndex()));
					
					if (_fechaSalidaMin.isEditValid() && _fechaLlegadaMax.isEditValid())
						criterio.conSalida(parseaFecha(_fechaSalidaMin.getText()),
								parseaFecha(_fechaLlegadaMax.getText()));
					
					// Busca los vuelos con el gestor
					Set<Vuelo> vuelos = GestorVuelos.dameInstancia().buscaVuelo(criterio);
					
					// Los aplica a la tabla
					_tablaVuelos.ponVuelos(new Vector<Vuelo>(vuelos));
				}
			});
			
			tpanel.add(btn);
			
			add(tpanel);
		}
		
		
		/**
		 * Interpreta una fecha a partir de un texto.
		 */
		private GregorianCalendar parseaFecha(String fecha) {
			// Formateador de fechas
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/mm/yyyy");	
			
			GregorianCalendar ret = new GregorianCalendar();
			
			try {
				ret.setTime(formatoFecha.parse(fecha));
			} catch (ParseException e) {
				return null;
			}
			
			return ret;
		}
		
		// ATRIBUTOS PRIVADOS (de PanelBusqueda)
		
		/**
		 * Selector de aeropuerto de origen
		 */
		private JComboBox<Aeropuerto> _origen;
		
		/**
		 * Selector de aeropuerto de destino
		 */
		private JComboBox<Aeropuerto> _destino;
		
		/**
		 * Selector de fecha de salida
		 */
		private JFormattedTextField _fechaSalidaMin;
		
		/**
		 * Selector de fecha de llegada
		 */
		private JFormattedTextField _fechaLlegadaMax;
		
			
		/**
		 * Serial UID (para PanelBusqueda)
		 */
		private static final long serialVersionUID = -194473111700140658L;
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
		 * Devuelve el vuelo en la posición i-ésima.
		 * 
		 * @param indice Índice.
		 */
		public Vuelo vueloEn(int indice){
			return _vuelos.elementAt(indice);
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
		private static final long serialVersionUID = 1853343405213592855L;
	}
	
	/**
	 * Fábrica de pantallas
	 */
	private FabricaPantallas _fabrica;
	
	/**
	 * Manejador de pantallas
	 */
	private ManejadorPantallas _manejadorPantallas;
	
	/**
	 * Modelo de tabla de vuelos
	 */
	private ModeloTablaVuelos _tablaVuelos;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4868535547311346409L;
}