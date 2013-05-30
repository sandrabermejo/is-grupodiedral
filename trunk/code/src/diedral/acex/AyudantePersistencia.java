/*
 * AyudantePersistencia.java - ACE Gestión Externa - Grupo diedral 2013 
 */
package diedral.acex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase como apoyo para manejar la persistencia de los datos basada
 * en serialización.
 * 
 * @see Serializable
 */
public class AyudantePersistencia implements Serializable {
	
	/**
	 * Almacena el objeto dado de acuerdo a su identificador.
	 * 
	 * @param obj Objeto serializable.
	 * @param id Identificar único representativo del objeto.
	 */
	public boolean almacena(Serializable obj, String id) {
		// Comprueba que existe la carpeta "data"
		File dirData = new File("data");
		
		// En caso constrario la crea
		if (!dirData.exists())
			dirData.mkdir();
		
		// Crea un flujo de salida para extraer el objeto serializado
		try {
			
			ObjectOutputStream salida = new ObjectOutputStream(
					new FileOutputStream(dirData.getPath() + "/" + id + ".dat"));
			
			// Imprime el objeto serializado
			salida.writeObject(obj);

			salida.close();
			
		} catch (IOException e) {
			return false;
		}

		return true;
	}
	
	/**
	 * Recupera un objeto almacenado de acuerdo a su identificador.
	 * 
	 * @param id Identificador único el objeto.
	 * 
	 * @return El objeto recuperado. {@code null} si no ha sido posible.
	 */
	public Object recupera(String id){
		Object obj = null;
		
		try {
			
			// Crea un flujo de lectura para leer el objeto
			ObjectInputStream entrada = new ObjectInputStream(
					new FileInputStream("data" + "/" + id + ".dat"));
			
			obj = entrada.readObject();
			
			entrada.close();
			
		} catch(ClassNotFoundException | IOException ioe){
			// No hace nada: se devuelve null
		}
		
		return obj;
	}
	
	/**
	 * Recupera un objeto almacenado de acuerdo a su identificador y
	 * guarda una referencia a él para almacenarlo cuando el ayudante
	 * reciba una notificación a tal efecto.
	 * 
	 * @param id Identificador único el objeto.
	 * 
	 * @return El objeto recurerado. {@code null} si no ha sido posible.
	 */
	public Object recuperayVigila(String id){
		Object obj = recupera(id);
		
		vigila((Serializable) obj, id);
		
		return obj;
	}
	
	/**
	 * Añade el objeto a la lista de objetos que serán guardados
	 * al almacenar todos.
	 * 
	 * @param obj Objeto.
	 * @param id Identificador de objeto.
	 */
	public void vigila(Serializable obj, String id){
		// Lo añade a la lista de vigilados
		if (obj != null)
			_vigilados.put(obj, id);
	}
	
	/**
	 * Almacena todos los objetos vigilados.
	 *
	 */
	public boolean almacenaTodos(){		
		for (Serializable obj : _vigilados.keySet())
			if (!almacena(obj, _vigilados.get(obj)))
				return false;
		
		return true;
	}
	
	
	// CONSTRUCTOR PRIVADO
	
	private AyudantePersistencia() {}
	
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Conjunto de objetos vigilados para ser guardados
	 * cuando corresponda.
	 */
	private Map<Serializable, String> _vigilados = new HashMap<>();

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 8617860719777255822L;
	
	
	// PARTE ESTÁTICA
	
	/**
	 * Genera un identificador textual a partir de un indentificador
	 * de serialización.
	 * 
	 * @param suid Serial UID.
	 */
	public static String generaTID(long suid){
		return String.format("%s%s", (suid < 0 ? "N" : ""),
				new Long(Math.abs(suid)).toString());
	}
	
	/**
	 * Obtiene la instancia del ayudante de persistencia.
	 * 
	 * @return Un {@code AyudantePersistencia} válido.
	 */
	public static AyudantePersistencia dameInstancia(){
		if (_instancia == null)
			_instancia = new AyudantePersistencia();
		return _instancia;
	}
	
	/**
	 * Instancia del ayudante de persistencia
	 */
	private static AyudantePersistencia _instancia;
}