package diedral.acex.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import diedral.acex.Sesion;
import diedral.acex.eventos.OyenteCambios;

/**
 * Menú lateral para dar acceso a los diferentes servicios de la aplicación.
 */
class MenuLateral extends JPanel implements OyenteCambios<Sesion> {
	/**
	 * Crea el menú lateral por defecto.
	 * 
	 * @param mnj El manejador de pantallas sobre el que pueden
	 * actuar los elementos del menú.
	 * @param fabr Fábrica de pantallas
	 */
	public MenuLateral(ManejadorPantallas mnj, FabricaPantallas fabr){		
setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Guarda los parámetros
		_mnj = mnj;
		_fabr = fabr;
		
		// Añade el panel de botones al panel general
		add (creaBotones());
		add(Box.createVerticalGlue());
	}
	
	/**
	 * Crea el panel de botones.
	 * 
	 * @return Dicho panel de botones.
	 */
	private JPanel creaBotones() {
		JPanel botones = new JPanel(new GridLayout(5, 1));
		
		// Variable de botón temporal
		JButton t_btn;

		// Añade los botones al panel
		t_btn = new JButton("Inicio");
		
		t_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				_mnj.cambiaA(_fabr.damePantallaInicio());				
			}
		});
		
		botones.add(t_btn);
		
		
		// Añade los botones al panel
		t_btn = new JButton("Vuelos");
		
		t_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				_mnj.cambiaA(_fabr.damePantallaConsultaVuelos());
			}
		});
		
		botones.add(t_btn);
		
		// Añade los botones al panel
		t_btn = new JButton("Ofertas");
		
		t_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				_mnj.cambiaA(_fabr.damePantallaConsultaOfertas());				
			}
		});
		
		botones.add(t_btn);		
		
		t_btn = new JButton("Sugerencias");
		
		t_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				_mnj.cambiaA(_fabr.damePantallaSugerencias());				
			}
		});
		
		botones.add(t_btn);
		
		t_btn = new JButton("Vuelos contratados");
		
		t_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				_mnj.cambiaA(_fabr.damePantallaVueloContratado());				
			}
		});
		
		t_btn.setVisible(false);
		
		_botonesSesion.add(t_btn);
		
		botones.add(t_btn);
		
		return botones;
	}
	
	
	/*
	 * Recibe eventos sobre cambios en la sesión.
	 */
	@Override
	public void haCambiado(Sesion arg) {
		// Si se ha cerrado sesión oculta los botones que lo requieren
		if (arg.dameUsuario() == null)
			for (JButton btn : _botonesSesion)
				btn.setVisible(false);
		else
			for (JButton btn : _botonesSesion)
				btn.setVisible(true);
			
	}
	
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Botones que requieren sesión iniciada.
	 */
	Set<JButton> _botonesSesion = new HashSet<JButton>();
	
	/**
	 * Manejador de pantallas.
	 */
	private ManejadorPantallas _mnj;
	
	/**
	 * Fábrica de pantallas
	 */
	private FabricaPantallas _fabr;

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 6375760000993414292L;
}
