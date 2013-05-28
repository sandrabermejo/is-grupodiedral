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
	public static boolean almacena(Serializable obj, String id) {
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
	 * @param Identificador único el objeto.
	 * 
	 * @return El objeto recurerado. {@code null} si no ha sido posible.
	 */
	public static Object recupera(String id){
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
	
	
	// ATRIBUTOS PRIVADOS

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 8617860719777255822L;
}
