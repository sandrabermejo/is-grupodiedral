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
import diedral.acex.Oferta;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;

/**
 * PĂĄgina de consulta de vuelos.
 */
public class PantallaConsultaOfertas extends Pantalla {

    public PantallaConsultaOfertas(ManejadorPantallas mnj, FabricaPantallas fabrica){

        _mnj = mnj;
        _fabrica = fabrica;
        _tabla = new JTable(new PanelOfertas());

        setLayout(new BorderLayout());

        JButton verInfoOferta = new JButton("Ver detalles...");
        add(verInfoOferta);

        verInfoOferta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (_ofertas != null && _ofertas.size() != 0)
                    _mnj.cambiaA(_fabrica.damePantallaOferta(_ofertas.get(_tabla.getSelectedRow())));
            }
        });
        add(new JScrollPane(_tabla), BorderLayout.NORTH);

    }


    public String dameNombre() {
        return "Consulta ofertas";
    }

    /**
     * Panel de ofertas
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