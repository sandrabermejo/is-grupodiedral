/*
 * PaginaConsultaOfertas.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import diedral.acex.GestorOfertas;
import diedral.acex.Sesion;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;
import diedral.acex.ventas.Oferta;

/**
 * Página de consulta de vuelos.
 */
public class PantallaConsultaOfertas extends Pantalla {

    public PantallaConsultaOfertas(){
        _tabla = new JTable(new PanelOfertas());

        setLayout(new BorderLayout());

        JButton verInfoOferta = new JButton("Ver detalles...");
        add(verInfoOferta);

        verInfoOferta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	int filaSeleccionada = _tabla.getSelectedRow();
                if (_ofertas != null && _ofertas.size() != 0 && filaSeleccionada != -1)
                    _mnj.cambiaA(_fabrica.damePantallaOferta(_ofertas.get(filaSeleccionada)));
            }
        });
        add(new JScrollPane(_tabla), BorderLayout.NORTH);

    }
    public void estableceContexto(ManejadorPantallas manejador, FabricaPantallas fabrica, Sesion sesion){
    	_mnj = manejador;
    	_fabrica = fabrica;
    }


    public String dameNombre() {
        return "Consulta ofertas";
    }

    /**
     * Panel de ofertas
     */
    private class PanelOfertas extends AbstractTableModel {
    	final int numCol = 3;
		public PanelOfertas(){
            _ofertas = new ArrayList<Oferta>(GestorOfertas.dameInstancia().dameOfertas());
        }

        @Override
        public int getRowCount() {
            return (GestorOfertas.dameInstancia()).dimeCuantasOfertas();
        }


        @Override
        public int getColumnCount() {
            return numCol;
        }
        
        @Override
        public String getColumnName(int column) {
        	switch(column){
        		case 0:
        			return "Nombre";
        		case 1:
        			return "Destino";
        		case 2:
        			return "Descuento";
        			
        	}
        	return super.getColumnName(column);
        }


        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
           switch(columnIndex){
           		case 0:
           			return _ofertas.get(rowIndex).dameNombre();
           		case 1:
           			return _ofertas.get(rowIndex).dameDestino();
           		case 2:
           			return "descuento: " +_ofertas.get(rowIndex).dameDescuento();
           }
            return  "Sin Nombre";
        }

        public boolean isCellEditable(int row, int col){
            return false;
        }

		/**
		 * Serial UID (de PantallaConsultaOfertas)
		 */
		private static final long serialVersionUID = -8556619820067983514L;
    }

    private ArrayList<Oferta> _ofertas;
    private ManejadorPantallas _mnj;
    private FabricaPantallas _fabrica;
    private JTable _tabla;

    /**
     * Serial UID (para PanelBusqueda)
     */
    private static final long serialVersionUID = -194473111700140658L;
}
