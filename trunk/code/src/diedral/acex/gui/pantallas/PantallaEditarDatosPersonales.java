package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import diedral.acex.Sesion;
import diedral.acex.Usuario;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;
import diedral.acex.scentral.GestorUsuarios;

public class PantallaEditarDatosPersonales extends Pantalla {
	
	public PantallaEditarDatosPersonales(){		
		//Características ventana
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Variables locales auxiliares
		Dimension dim;
		
		// Crea un cuadro de inserción de nombre con su texto
		JPanel panelNombre = new JPanel(new GridLayout(1, 2));
		panelNombre.add(new JLabel("Nombre"));
		panelNombre.add(_textNombre = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			dim = panelNombre.getMaximumSize();
			dim.height = _textNombre.getPreferredSize().height;
			panelNombre.setMaximumSize(dim);
		panel.add(panelNombre);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de primer apellido con su texto
		JPanel panelApellido1 = new JPanel(new GridLayout(1, 2));
		panelApellido1.add(new JLabel("Primer Apellido"));
		panelApellido1.add(_textApellido1 = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelApellido1.setMaximumSize(dim);
			
		panel.add(panelApellido1);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de segundo apellido con su texto
		JPanel panelApellido2 = new JPanel(new GridLayout(1, 2));
		panelApellido2.add(new JLabel("Segundo Apellido"));
		panelApellido2.add(_textApellido2 = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelApellido2.setMaximumSize(dim);
			
		panel.add(panelApellido2);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de correo con su texto
		JPanel panelCorreo = new JPanel(new GridLayout(1, 2));
		panelCorreo.add(new JLabel("Correo"));
		panelCorreo.add(_textCorreo = new JTextField(""));
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelCorreo.setMaximumSize(dim);
			
		panel.add(panelCorreo);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de contraseña con su texto
		JPanel panelContrasenya = new JPanel(new GridLayout(1, 2));
		panelContrasenya.add(new JLabel("Contraseña"));
		_textContrasenya = new JPasswordField("");
		_textContrasenya.setEnabled(false); //la contraseña no se puede modificar aqui
		panelContrasenya.add(_textContrasenya);
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelContrasenya.setMaximumSize(dim);
		
		panel.add(panelContrasenya);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de NIF con su texto
		JPanel panelNIF = new JPanel(new GridLayout(1, 2));
		panelNIF.add(new JLabel("NIF"));
		_textNIF = new JTextField("");
		_textNIF.setEnabled(false); //el DNI no se puede modificar aqui
		panelNIF.add(_textNIF);
		
		// Acota el tamaño del cuadro de texto para que no quede raro
			panelNIF.setMaximumSize(dim);

		panel.add(panelNIF);
		panel.add(Box.createVerticalStrut(INTERESPACIO_VERTICAL));
		
		// Crea un cuadro de inserción de contraseña con su texto
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BorderLayout());
		_botonMofidicarContrasena = new JButton("<html><font color=\"blue\">Modificar contraseña</font></html>");
		_botonGuardar = new JButton("Guardar");
		_botonGuardar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PantallaEditarDatosPersonales.this.introducirDatos();
			}
		});
		/**
		 * Al pulsarse el botón de modificar contraseña, se abre una nueva ventana desde la que puedes restablecerla.
		 * Se requiere de la contraseña actual para modificarla a una nueva. Si se introduce la contraseña actual 
		 * mal tres veces, el sistema se bloquea 15 segundos por lo que el usuario deberá esperar hasta poder volver a 
		 * intentarlo.
		 */
		_botonMofidicarContrasena.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				final JDialog ventana = new JDialog(SwingUtilities.windowForComponent(PantallaEditarDatosPersonales.this),
						"Modificar contraseña");
				
				ventana.setModal(true);
				ventana.setSize(400, 200);
				
				//Hacemos que la ventana salga en el centro de la pantalla
				ventana.setLocationRelativeTo(getRootPane());
				JPanel panel = new JPanel(new GridLayout(4, 3));
				
				panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				
				panel.add(new JLabel("Contraseña antigua:"));
				panel.add(_textContrasenaAntigua = new JPasswordField(""));
				
				panel.add(new JLabel("Contraseña nueva:"));
				panel.add(_textContrasenaNueva = new JPasswordField(""));
				
				panel.add(new JLabel("Repita contraseña nueva:"));
				panel.add(_textContrasenaNuevaRep = new JPasswordField(""));
				
				_botonContrasena = new JButton("Modificar contraseña");
				_etiquetaTiempo = new JLabel();
				
				panel.add(_etiquetaTiempo);
				panel.add(_botonContrasena);
				
				_botonContrasena.addActionListener(new ActionListener(){
				int contador = 0;
				boolean espera = false;
				/**
				 * Este método pone los campos de la pantalla vacíos.
				 */
					private void reseteaCampos(){
						_textContrasenaAntigua.setText("");
						_textContrasenaNueva.setText("");
						_textContrasenaNuevaRep.setText("");
					}
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String contrAntigua = new String(_textContrasenaAntigua.getPassword());
						String contrNueva = new String(_textContrasenaNueva.getPassword());
						String contrNuevarep = new String(_textContrasenaNuevaRep.getPassword());
						if(contrAntigua != null && contrNueva != null && contrNuevarep != null){
							if(_usuario.comprobarContrasena(contrAntigua)){
								if(contrNueva.equals(contrNuevarep)){
									_usuario.meteContrasena(contrNueva);
									ventana.dispose(); //cierra y elimina del sistema la ventana
								} else {
									reseteaCampos();
									JOptionPane.showMessageDialog(ventana, "Las contraseñas no coincide");
								}
							} else {
								contador++;
								if(contador == 3)
									espera = true;
								reseteaCampos();
								JOptionPane.showMessageDialog(ventana, "La contraseña actual no es correcta");
							}
						} else {
							reseteaCampos();
							JOptionPane.showMessageDialog(ventana, "Todos los campos son obligatorios.");
						}
						
						if(espera) {
							contador = 0;
							ventana.setEnabled(false);
							new Thread() {
								@Override
								public void run() {
									int contadorSeg = 15;
									for(int i = contadorSeg; i >= 0; i--){
										SwingUtilities.invokeLater(new Texteable(i));
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {}
									}
									ventana.setEnabled(true);
								}
							}.start();
						espera = false;
						}
					}
				});
				ventana.add(panel);
				ventana.setVisible(true);
			}
			class Texteable implements Runnable {
				int toText;
				public Texteable(int toText) {
					super();
					this.toText = toText;
				}
				@Override
				public void run() {
					if(toText != 0)
						_etiquetaTiempo.setText(" " + toText + " segundos");
					else
						_etiquetaTiempo.setText("");
				}
			}
			
			//Atributos que son los componentes de la ventana
			private JPasswordField _textContrasenaAntigua, _textContrasenaNueva, _textContrasenaNuevaRep;
			private JButton _botonContrasena;
			private JLabel _etiquetaTiempo;
		});
		//añadimos los componentes restantes a la ventana principal de editar datos.
		panelBotones.add(_botonMofidicarContrasena, BorderLayout.WEST);
		panelBotones.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
		panelBotones.add(_botonGuardar, BorderLayout.EAST);
		
		panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, _botonGuardar.getPreferredSize().height));
		panel.add(panelBotones);
		
			
		add(panel, BorderLayout.CENTER); //añadimos el panel al centro.
		

	}
	@Override
	public String dameNombre() {
		return "Editar datos personales";
	}
	/**
	 * Sobreescribe este método en su clase padre Pantalla.
	 * @param manejador
	 * @param fabrica
	 * @param sesion
	 */
	@Override
	public void estableceContexto(ManejadorPantallas manejador, FabricaPantallas fabrica, Sesion sesion) {
		_sesion = sesion;
	}
	/**
	 * Método que lee los datos de la pantalla y realiza el guardado de los datos
	 * del usuario que ha sido modificado.
	 */
	@Override
	public void alCargar(){
		_usuario = _sesion.dameUsuario();
		_textNombre.setText(_usuario.dameNombre());
		_textApellido1.setText(_usuario.dameApellido1());
		_textApellido2.setText(_usuario.dameApellido2());
		_textCorreo.setText(_usuario.dameCorreo());
		_textContrasenya.setText(_usuario.dameContrasena());
	}
	
	public void introducirDatos(){
		String nombre = _textNombre.getText();
		String apellido1 = _textApellido1.getText();
		String apellido2 = _textApellido2.getText();
		String correo = _textCorreo.getText();
		boolean datosValidos = true;
		if(correo != null) //si el correo ha sido modificado
			datosValidos = GestorUsuarios.dameInstancia().validar(correo);
		if(datosValidos){
			//vemos los datos que no ha modificado el usuario
			if(nombre == null)
				nombre = _usuario.dameNombre();
			if(apellido1 == null)
				apellido1 = _usuario.dameApellido1();
			if(apellido2 == null)
				apellido2 = _usuario.dameApellido2();
			if(correo == null)
				correo = _usuario.dameCorreo();
			
			//creamos el nuevo usuario modificado y lo reemplazamos.
			Usuario usuarioModificado = new Usuario(nombre, apellido1, apellido2, _usuario.dameContrasena(), correo);
			GestorUsuarios.dameInstancia().reemplazarUsuario(usuarioModificado, _usuario.dameCorreo());
			
			//pantalla de información éxito.
			JOptionPane pane = new JOptionPane("¡Datos modificados con éxito!");
			JDialog dialog = pane.createDialog("Datos modificados");
			dialog.setLocationRelativeTo(getRootPane()); //centra la pantalla
			dialog.setVisible(true);
			
			_sesion.cargaUsuario(usuarioModificado);
		}
	}
	/**
	 * UID Serial Version
	 */
	private static final long serialVersionUID = 5520092526372803516L;
	/**
	 * Constante que indica un tamaño de Interespacio Vertical entre componentes.
	 */
	private static final int INTERESPACIO_VERTICAL = 10;
	/**
	 * Campo de nombre.
	 */
	private JTextField _textNombre;
	/**
	 * Campo de primer apellido.
	 */
	private JTextField _textApellido1;
	/**
	 * Campo de segundo apellido.
	 */
	private JTextField _textApellido2;
	/**
	 * Campo de correo.
	 */
	private JTextField _textCorreo;
	/**
	 * Campo de NIF. No puede ser editado aquí.
	 */
	private JTextField _textNIF;
	/**
	 * Campo de contraseña. No puede ser editado aquí.
	 */
	private JPasswordField _textContrasenya;
	/**
	 * Botón que al pulsarlo se guardan los datos modificados.
	 */
	private JButton _botonGuardar;
	
	private JButton _botonMofidicarContrasena;
	/**
	 * Usuario que ha iniciado sesión.
	 */
	private Usuario _usuario;
	/**
	 * Sesion iniciada por un usuario que es el que quiere modificar sus datos.
	 */
	private Sesion _sesion;
}
