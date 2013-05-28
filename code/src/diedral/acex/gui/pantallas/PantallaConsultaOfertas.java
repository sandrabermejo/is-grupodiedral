/*
 * PaginaConsultaOfertas.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import diedral.acex.GestorOfertas;
import diedral.acex.Oferta;
import diedral.acex.gui.Pantalla;

/**
 * PÃ¡gina de consulta de vuelos.
 */
public class PantallaConsultaOfertas extends Pantalla {

	public PantallaConsultaOfertas(){		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(new JTable(new PanelOfertas())), BorderLayout.NORTH);
	
	}
	
	public String dameNombre() {
		return "Consulta ofertas";
	}
	/**
	 * Panel de búsqueda
	 */
	private class PanelOfertas extends AbstractTableModel {

		public PanelOfertas(){
			_ofertas = (GestorOfertas.dameInstancia()).dameOfertas();
		}
		
		@Override
		public int getRowCount() {
			return (GestorOfertas.dameInstancia()).dimeCuantasOfertas();
		}


		@Override
		public int getColumnCount() {
			return 1;
		}


		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			_ofertas.get(rowIndex);
			return null;
		}
		
		public boolean isCellEditable(int row, int col){
			return false;
		}
		
		
		ArrayList<Oferta> _ofertas;
		
		/**
		 * Serial UID (para PanelBusqueda)
		 */
		private static final long serialVersionUID = -194473111700140658L;		
	}
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4868535547311346409L;
}