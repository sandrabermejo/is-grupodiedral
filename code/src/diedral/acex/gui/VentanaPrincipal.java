/*
 * VentanaPrincipal.java - ACE Gestión Externa - Grupo Diedral 2013 
 */
package diedral.acex.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import diedral.acex.AyudantePersistencia;
import diedral.acex.Sesion;

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
		
		// Usa la apariencia nativa del sistema (algo se parece)
		try {
			UIManager.setLookAndFeel(
				UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			// No importa
		}

		// Tamaño de la ventana
		setSize(800, 600);

		// Ubica los paneles superior y lateral
		MenuLateral lateral = new MenuLateral(this, _fabrica);
		
		add(lateral, BorderLayout.WEST);
		add(_bandaSuperior = new BandaSuperior(this, _fabrica), BorderLayout.NORTH);
		
		// Registra a los paneles como oyentes de cambios en la sesión
		_sesion.registraOyenteCambio(_bandaSuperior);
		_sesion.registraOyenteCambio(lateral);
		
		// El marco central es donde se muestran las pantallas particulares
		_marco = new MarcoCentral();
		add(_marco, BorderLayout.CENTER);

		// Fija la barra de menús
		setJMenuBar(fabricaBarraMenus());
		
		// Establece lo que hacer al salir
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent we) {
				// Guarda los datos
				AyudantePersistencia.dameInstancia().almacenaTodos();
				
				// Finaliza la aplicación
				System.exit(0);
			}
		});

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

		// Establece el contexto de la ventana y llama a métodos
		pt.estableceContexto(this, _fabrica, _sesion);
		pt.alCargar();
		pt.alMostrar();

		// Establece el nombre de la ventana de acuerdo a su nombre
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

		// Establece el contexto y llama al método de muestra
		pt.estableceContexto(this, _fabrica, _sesion);
		pt.alMostrar();
	}

	/**
	 * Solicita al manejador el cierre de la pantalla actual.
	 */
	public void cierraPantallaActual() {
		// Elimina la pantalla actual
		_marco.cierraCima();
		
		// Si está vacío carga la pantalla de inicio
		if (_marco.estaVacio())
			cambiaA(_fabrica.damePantallaInicio());
	}
	
	
	// MÉTODOS PRIVADOS

	/**
	 * Crea la barra de menús.
	 * 
	 * @return La barra de menús.
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
		
		
		// Menú "Ayuda"
		JMenu ayuda = new JMenu("Ayuda");
		
		// Añade el elemento "Acerca de..."
		JMenuItem acercaDe = new JMenuItem("Acerca de...");
		
		acercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(VentanaPrincipal.this,
						"<html><b>Airline Common Environment ε</b>" +
						"<br><i>Gestión Externa</i><br><br> Grupo Diedral 2013</html>",
						"Acerca de...",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		ayuda.add(acercaDe);
		
		// Crea la barra de menús
		JMenuBar mb = new JMenuBar();

		mb.add(nav);
		mb.add(ayuda);

		return mb;
	}
	
	/**
	 * Panel central de la ventana.	
	 */
	private class MarcoCentral extends JPanel {
		public MarcoCentral(){
			// Crea el borde de la pantalla
			_tb = BorderFactory.createTitledBorder("Marco de pantallas");
			
			setBorder(BorderFactory.createCompoundBorder(
				_tb, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			
			// Establece una CardLayout (pensada para fines más sofisticados)
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
			if (!_pantallas.isEmpty())
				_pantallas.element().alCerrar();
			
			removeAll();
			
			_pantallas.clear();
		}
		
		/**
		 * ¿Está el marco vacío?
		 * 
		 * @return Un booleano.
		 */
		public boolean estaVacio(){
			return _pantallas.isEmpty();
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
		
		/**
		 * Serial UID
		 */
		private static final long serialVersionUID = 7132566251439458651L;
	}

	// PRIVATE FIELDS
	
	/**
	 * Marco central
	 */
	private MarcoCentral _marco;
	
	/**
	 * Banda superior
	 */
	private BandaSuperior _bandaSuperior;
	
	/**
	 * Sesión
	 */
	private Sesion _sesion = new Sesion();
	
	/**
	 * Fábrica de pantallas
	 */
	private FabricaPantallas _fabrica = new FabricaPantallas();
	
	/**
	 * Serial UID 
	 */
	private static final long serialVersionUID = -1668893384096959140L;
}
