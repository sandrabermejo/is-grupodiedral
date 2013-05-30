/*
 * CreadorDatosMuestra.java - ACE Gestión Externa - Grupo diedral 2013 
 */
package diedral.acex.util;

import java.io.File;
import java.util.GregorianCalendar;

import diedral.acex.Aeropuerto;
import diedral.acex.AyudantePersistencia;
import diedral.acex.GestorUsuarios;
import diedral.acex.GestorVuelos;
import diedral.acex.Usuario;
import diedral.acex.Vuelo;
import diedral.acex.excepciones.UsuarioInvalidoException;

/**
 * Esta herramienta genera datos de muestra con lo que llenar los diferentes
 * registros del sistema para hacer posible las pruebas.
 *
 */
public class CreadorDatosMuestra {
	/**
	 * Método de entrada.
	 * 
	 * @param args Parámetros de la aplicación.
	 */
	public static void main(String[] args) {
		
		// Borra la carpeta "data" si existe
		
		File cData = new File("data");
		
		if (cData.exists() && cData.isDirectory())
			for (File file : cData.listFiles())
				file.delete();
		
		GestorVuelos gVuelos = GestorVuelos.dameInstancia();
		GestorUsuarios gUsuarios = GestorUsuarios.dameInstancia();
		
		// Por ejemplo algunos autores de la generación del 98
		
		try {
			gUsuarios.meteUsuario(new Usuario("Miguel", "de Unamuno", "Jugo", "niebla", "unamuno@ace.es"));
			gUsuarios.meteUsuario(new Usuario("Ramón", "Valle", "Peña", "bradomin", "valleinclan@ace.es"));
			gUsuarios.meteUsuario(new Usuario("Pío", "Baroja", "Nessi", "zalacain", "baroja@ace.es"));
			gUsuarios.meteUsuario(new Usuario("José", "Martínez", "Ruiz", "antonio", "azorin@ace.es"));
		}
		catch (UsuarioInvalidoException e) {
			System.err.println("Hubo un error al insertar usuarios: " + e.getMessage());
		}
		
		
		// Algunos vuelos de ejemplo (cualquier parecido con la realidad es pura coincidencia)
		
		try {
			// Variable temporal de vuelo
			Vuelo vuelo;
			
			// ((1))
			
			vuelo = new Vuelo(1, new Aeropuerto("Madrid-Barajas", "MAD", "Madrid"),
					new Aeropuerto("París-Charles de Gaulle", "CDG", "París"));
			
			vuelo.ponFechaSalida(new GregorianCalendar(2013, 10, 1, 12, 30));
			vuelo.ponFechaLlegada(new GregorianCalendar(2013, 10, 1, 14, 50));
			vuelo.ponNumPasajeros(100);
			
			gVuelos.añadeVuelo(vuelo);
			
			// ((2))
			
			vuelo = new Vuelo(2, new Aeropuerto("Madrid-Barajas", "MAD", "Madrid"),
					new Aeropuerto("Barcelona-El Prat", "BCN", "Barcelona"));
			
			vuelo.ponFechaSalida(new GregorianCalendar(2013, 9, 1, 11, 30));
			vuelo.ponFechaLlegada(new GregorianCalendar(2013, 9, 1, 13, 50));
			vuelo.ponNumPasajeros(20);
			
			gVuelos.añadeVuelo(vuelo);
			
			// ((3))
			
			vuelo = new Vuelo(3, new Aeropuerto("Londres-Heathrow", "LHR", "Londres"),
					new Aeropuerto("Ezeiza-Ministro Pistarini", "EZE", "Buenos Aires"));
			
			vuelo.ponFechaSalida(new GregorianCalendar(2013, 11, 4, 11, 30));
			vuelo.ponFechaLlegada(new GregorianCalendar(2013, 11, 5, 0, 0));
			vuelo.ponNumPasajeros(200);
			
			gVuelos.añadeVuelo(vuelo);
			
			
			// ((3))
			
			vuelo = new Vuelo(4, new Aeropuerto("Nueva York-John F. Kennedy", "JFK", "Nueva York"),
					new Aeropuerto("Lisboa-Portela", "LIS", "Lisboa"));
			
			vuelo.ponFechaSalida(new GregorianCalendar(2013, 8, 4, 11, 30));
			vuelo.ponFechaLlegada(new GregorianCalendar(2013, 8, 5, 3, 0));
			vuelo.ponNumPasajeros(80);
			
			gVuelos.añadeVuelo(vuelo);
		}
		catch (Exception exception) {
			System.err.println("Hubo un error al insertar vuelos.");
		}
		
		// Almacena los datos referidos
		AyudantePersistencia.dameInstancia().almacenaTodos();
		
		
		System.out.println("Datos generados correctamente");
	}
}
