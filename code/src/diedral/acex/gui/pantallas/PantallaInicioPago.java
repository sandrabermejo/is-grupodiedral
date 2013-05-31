package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import diedral.acex.ventas.Compra;
import diedral.acex.Sesion;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;

public class PantallaInicioPago extends Pantalla {

	public PantallaInicioPago(Compra compra){
		_compra = compra;
		
		setLayout(new BorderLayout());
		
		_texto = new JTextArea("En cumplimiento de lo previsto en la Ley 34/2002, de 11 de julio, de Servicios de la Información y Comercio Electrónico, se indican a continuación los datos de información general de www.ace.es:\n" 
				 +
				"Titular: Grupo diedral, S.L.U. \n" +
				"CIF: BXXXXXXXXA.\n" +
				"Tel: 555 123 123\n" +
				"\n" +
				"Dirección: Av. Santesmases S/N.\n" +
				"\n" +
				"Contacto: formulario\n" +
				"\n" +
				"Datos Registrales: Inscrita en el Registro Mercantil de Madrid al tomo 43.061, folio 198, hoja B-xyz.abc.\n" +
				"\n" +
				"La utilización de este sitio web se sujeta a las condiciones de uso contenidas en el presente documento, así como a la Política de Privacidad de la misma, que rogamos lea Ud. con detenimiento. El acceso al sitio web y el uso de cuanto se contiene en el mismo implica que Ud. consiente y acepta sin reserva de tipo alguno las presentes condiciones." +
				"\n" +
				"Estas condiciones se entienden sin perjuicio de cualesquiera otras particulares que acaso existan para la utilización de algún espacio o servicio incluido en el sitio web, que igualmente deberán ser observadas y que en caso de conflicto con las condiciones de uso que aquí se desarrollan, deberán prevalecer.\n" +
				"\n" +
				"\n" +
				"Los Usuarios de este sitio web (www.ace.es) deben leer cuidadosamente estas Condiciones Generales, a las que se hace referencia por medio de un hipervínculo en cada una de las páginas del mismo. Se aconseja a los usuarios que las descarguen o que las impriman y que guarden una copia de las mismas.\n" +
				"\n" +
				"Las presentes Condiciones Generales son aplicables a todos los pedidos y están vigentes desde el día 1 de julio de 2012. Grupo Diedral se reserva el derecho a modificar en cualquier momento y sin necesidad de previo aviso la presentación, configuración y contenidos del sitio web, así como las presentes condiciones y otras particulares que acaso existieren para determinados espacios, servicios o usos." +
				"\n" +
				"Es por ello que Grupo Diedral aconseja encarecidamente a los Usuarios que lean atentamente estas Condiciones Generales cada vez que visiten el sitio.\n" +
				"\n" +
				"Estas Condiciones Generales son aplicables a todas las ofertas de productos que se realicen por medio del sitio www.ace.es y a todos los acuerdos, de cualquier tipo, que se concluyan entre Grupo Diedral y el Usuario del sitio Web.\n" +
				"\n" +
				"El sitio web www.ace.es no opera exclusivamente en el territorio español comprendido en la Península Ibérica y las Islas Baleares(en adelante el “Territorio”), realizándose vuelos en otros territorios. ");
		_texto.setEditable(false);
		_texto.setLineWrap(true);
		add(new JScrollPane(_texto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		_acepta = new JCheckBox("He leido y acepto las condiciones.");
		_continuar = new JButton("Continuar");
		_continuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_acepta.isSelected())
					_mnj.cambiaA(_fabrica.damePantallaPagoTarjeta(_compra));
				else{
					int opt = JOptionPane.showConfirmDialog(PantallaInicioPago.this, 
							"Para continuar con la compra es necesario aceptar las condiciones finales de pago", 
							"ACE Gestión Externa - Pago",
							JOptionPane.OK_CANCEL_OPTION);
					if(opt != JOptionPane.OK_OPTION)
						_mnj.cierraPantallaActual();
				}
					
			}
		});
		
		JPanel botones = new JPanel(new GridLayout(1, 2));
		botones.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		botones.add(_acepta);
		botones.add(_continuar);
		
		add(botones, BorderLayout.SOUTH);
	}
	
	@Override
	public void estableceContexto (ManejadorPantallas mnj, FabricaPantallas fabrica,
			Sesion sesion){
			_mnj = mnj;
			_fabrica = fabrica;
	}
	

	@Override
	public String dameNombre() {
		return "Inicio de pago";
	}
	
	/**
	 * Compra
	 */
	private Compra _compra;
	
	/**
	 * Texto de condiciones de compra.
	 */
	private JTextArea _texto;
	
	/**
	 * Casilla de aceptación.
	 */
	private JCheckBox _acepta;
	
	/**
	 * Boton continuar.
	 */
	private JButton _continuar;
	
	/**
	 * Manejador de pantallas.
	 */
	private ManejadorPantallas _mnj;
	
	/**
	 * Fabrica de pantallas.
	 */
	private FabricaPantallas _fabrica;

	/**
	 * Something we don't know about...
	 */
	private static final long serialVersionUID = -6535770145727571910L;
}
