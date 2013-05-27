/*
 * PantallaInicio.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui.pantallas;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import diedral.acex.gui.Pantalla;

/**
 * Pantalla de inicio de la aplicación.
 */
public class PantallaInicio extends Pantalla {

	/**
	 * Crea una pantalla de inicio.
	 */
	public PantallaInicio(){
		// Crea el borde de la pantalla
		setBorder(BorderFactory.createCompoundBorder(
    			BorderFactory.createTitledBorder("Página de inicio"),
			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		// Establece la distribución
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(new JLabel("<html><b>Airline Common Environment</b></html>"));
		
		add(Box.createVerticalGlue());
		
		_avisos = new JLabel();
		_avisos.setText(_noticias[0]);
		
		add(_avisos);
		
		add(Box.createVerticalStrut(20));
	}
	
	@Override
	public void alMostrar() {
		_hebraAv = new HebraAvisos();
		_hebraAv.start();
	}
	
	public boolean alCerrar() {
		//_hebraAv.interrupt();
		
		return true;
	}
	
	public boolean alOcultar() {
		return alCerrar();
	}
	
	
	public String dameNombre() {
		return "Inicio";
	}
	
	
	// MIEMBROS PRIVADOS
	
	/**
	 * Clase para cambiar los avisos de la pantalla inicial cada
	 * cierto tiempo.
	 */
	private class HebraAvisos extends Thread {
		/**
		 * Construye una hebra de avisos.
		 */
		public HebraAvisos(){
			this.setName("hebra-avisos");
		}
		
		public void run() {
			while (true){				
				_avisos.setText(_noticias[_ind]);

				try {
					sleep(RETARDO);
				}
				catch (InterruptedException ie){
					break;
				}
				
				_ind = (_ind + 1) % _noticias.length;
			}
		}
		
		/**
		 * Retardo aplicado
		 */
		public final static int RETARDO = 10000;
		
		/**
		 * indice de la muestra de noticias
		 */
		private int _ind = 0;
	}

	/**
	 * area de avisos
	 */
	JLabel _avisos;
	
	/**
	 * Hebra de avisos
	 */
	HebraAvisos _hebraAv;
	
	/**
	 * Texto de muestra
	 */
	private final String[] _noticias = new String[]{
			"<html><i>Nueva interfaz de Gestión Externa de ACE</i>" +
					"<p>Airline Common Environment estrena una nueva interfaz externa" +
					"<p><p align=\"right\">GrupoDiedral</html>",
			"<html><i>París</i><p>Precio de ida y vuelta desde 138€</html>",
			"<html><i>Boston</i><p>Precio final de ida y vuelta desde 524€</html>",
			"<html><i>Guatemala</i><p>Desde  691€</html>",
			"<html><i>Bogotá</i><p>Ida y vuelta 712€</html>"
	};
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4042992205767985297L;
}
