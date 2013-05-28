/*
 * VentanaPrincipal.java - ACE Gestión Externa - Grupo Diedral 2013 
 */
package diedral.acex.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import diedral.acex.GestorVuelos;

/**
 * Ventana principal de la interfaz de gestión externa de ACE.
 *
 */
public class VentanaPrincipal extends javax.swing.JFrame implements ManejadorPantallas {
	/**
	 * Construye una ventana principal inicialmente vacía.
	 */
	public VentanaPrincipal(){
		super("ACE - Gestión interna");
		
		 try {
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
		 }
		 catch (Exception e){
			 
		 }

		setSize(800, 600);

		// Ubica los paneles superior y lateral
		add(new MenuLateral(this, _fabrica), BorderLayout.WEST);
		add(new BandaSuperior(), BorderLayout.NORTH);
		
		_marco = new MarcoCentral();
		add(_marco, BorderLayout.CENTER);

		setJMenuBar(fabricaBarraMenus());

		// Al inicio carga la pantalla de inicio
		cambiaA(_fabrica.damePantallaInicio());
	}

	/**
	 * Solicita al manejador de pantallas que cambie la pantalla
	 * activa por la indicada.
	 *
	 * @param pt Pantalla a la que cambiar.
	 */
	public void cambiaA(Pantalla pt) {
		// Descarta las pantallas anteriores
		_marco.descartaPantallas();

		// Y añade la nueva
		_marco.apilaPantalla(pt);
		_marco.validate();

		pt.alMostrar();

		if (pt.dameNombre() != null)
			setTitle("ACE - Gestión interna - " + pt.dameNombre());
	}

	/**
	 * Solicita al manejador de pantallas que muestre pantalla
	 * indicada dejando la pantalla actual en segundo plano.
	 *
	 * @param pt Pantalla a que mostrar.
	 */
	public void muestra(Pantalla pt) {
		// Elimina la pantalla actual
		_marco.apilaPantalla(pt);

		pt.alMostrar();
	}

	/**
	 * Solicita al manejador el cierre de la pantalla actual.
	 */
	public void cierraPantallaActual() {
		// Elimina la pantalla actual
		_marco.cierraCima();		
	}


	
	// MÉTODOS PRIVADOS

	/**
	 * Crea la barra de menús.
	 */
	private JMenuBar fabricaBarraMenus(){
		// Crea el menú "Navegador"
		JMenu nav = new JMenu("Navegador");

		// Añade el elemento "Salir"
		JMenuItem salir = new JMenuItem("Salir");

		salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
			java.awt.event.InputEvent.ALT_DOWN_MASK));

		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				dispatchEvent(new WindowEvent(VentanaPrincipal.this,
					WindowEvent.WINDOW_CLOSING));
			}
		});

		nav.add(salir);
		
		
		// Temporal para depuración
		
		JMenu depr = new JMenu("Depuración");
		
		// JMenuItem 
		JMenuItem arOferta = new JMenuItem("Archivar vuelos");
		
		arOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(GestorVuelos.sincronizaDatos());
			}
		});
		
		depr.add(arOferta);

		// Crea la barra de menús
		JMenuBar mb = new JMenuBar();

		mb.add(nav);
		mb.add(depr);

		return mb;
	}
	
	/**
	 * Panel central de la ventana.	
	 */
	private class MarcoCentral extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7132566251439458651L;

		public MarcoCentral(){
			// Crea el borde de la pantalla
			_tb = BorderFactory.createTitledBorder("AA");
			
			setBorder(BorderFactory.createCompoundBorder(
				_tb,
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			
			setLayout(new CardLayout());
		}
		
		/**
		 * Apila una nueva pantalla en el marco de pantallas.
		 * 
		 * @param pt Pantalla.
		 */
		public void apilaPantalla(Pantalla pt){
			_tb.setTitle(pt.dameNombre());
			
			add(pt, pt.toString());
			updateUI();
			
			_pantallas.add(pt);
		}
		
		/**
		 * Cierra la pantalla que se encuentra en primer plano
		 * en la pila de pantallas.
		 * 
		 */
		public void cierraCima(){
			if (!_pantallas.isEmpty())
				remove(_pantallas.remove());
		}
		
		/**
		 * Descarta todas las pantallas del marco principal: las que
		 * están en primer plano y en segundo plano.
		 * 
		 */
		public void descartaPantallas(){
			removeAll();
			
			_pantallas.clear();
		}
		
		
		// ATRIBUTOS PRIVADOS (de Ventana Principal)
		
		/**
		 * Pila de pantallas
		 */
		private Queue<Pantalla> _pantallas = new ArrayDeque<>();
		
		/**
		 * Card Layout
		 */
		//private CardLayout _clayout;
		
		/**
		 * Borde con título del marco
		 */
		private TitledBorder _tb;
	}

	// PRIVATE FIELDS
	
	/**
	 * Marco central
	 */
	private MarcoCentral _marco;
	
	
	/**
	 * Fábrica de pantallas
	 */
	private FabricaPantallas _fabrica = new FabricaPantallas();
	
	/**
	 * Serial UID 
	 */
	private static final long serialVersionUID = -1668893384096959140L;
}
