/*
 * VentanaPrincipal.java - ACE Gestión Externa - Grupo Diedral 2013 
 */
package diedral.acex.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

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

		add(new MenuLateral(), BorderLayout.WEST);
		add(new BandaSuperior(), BorderLayout.NORTH);

		setJMenuBar(fabricaBarraMenus());

		FabricaPantallas fabrica = new FabricaPantallas();

		cambiaA(fabrica.dameSugerencias());
	}

	/**
	 * Solicita al manejador de pantallas que cambie la pantalla
	 * activa por la indicada.
	 *
	 * @param pt Pantalla a la que cambiar.
	 */
	public void cambiaA(Pantalla pt) {
		// Elimina la pantalla actual
		if (!_pantal.isEmpty()){
			Pantalla cima = _pantal.element();

			if (!cima.alCerrar())
				return;
			else
				_pantal.remove();
		}

		// Y añade la nueva
		add(pt, BorderLayout.CENTER);

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
		if (!_pantal.isEmpty()){
			Pantalla cima = _pantal.element();

			if (!cima.alOcultar())
				return;
		}

		// Añade la nueva
		add(pt, BorderLayout.CENTER);

		pt.alMostrar();
	}

	/**
	 * Solicita al manejador el cierre de la pantalla actual.
	 */
	public void cierraPantallaActual() {
		// Elimina la pantalla actual
		if (!_pantal.isEmpty()){
			Pantalla cima = _pantal.element();

			if (!cima.alCerrar())
				return;

			_pantal.remove();


			// Carga la pantalla anterior
			if (!_pantal.isEmpty()){
				add(_pantal.element(), BorderLayout.CENTER);

				_pantal.element().alMostrar();
			}
		}

		
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

		// Crea la barra de menús
		JMenuBar mb = new JMenuBar();

		mb.add(nav);

		return mb;
	}

	// PRIVATE FIELDS

	/**
	 * Pila de pantallas
	 */
	private Queue<Pantalla> _pantal = new ArrayDeque<>();
	
	/**
	 * Serial UID 
	 */
	private static final long serialVersionUID = -1668893384096959140L;
}
