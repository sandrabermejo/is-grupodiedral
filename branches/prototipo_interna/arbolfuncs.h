/**
 * @file arbolfuncs.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase para la organización de las funciones.
 *
 * Esta clase define la organización de funciones y establece un orden lineal
 * para las casos de uso incorporados.
 *
 * Su origen se remonta a el control árbol de Qt.
 */

#ifndef ARBOLFUNCS_H
#define ARBOLFUNCS_H

// Biblioteca estándar C++
#include <vector>

#include "usuario.h"

/**
 * @brief Esta clase estructura la organización de funciones de la aplicación.
 *
 * Es un boceto.
 *
 */
class ArbolFuncs {
public:
	/**
	 * @brief Constructor del árbol de funcionalidades con una información de usuario.
	 *
	 * @param user Información del usuario.
	 */
	ArbolFuncs(const Usuario * user);

	/**
	 * @brief Destructor de todo lo generado por esta clase.
	 *
	 **/
	~ArbolFuncs();

	/**
	 * @brief Obtiene la posición en el árbol de la función indicada.
	 *
	 * @param func Función indicada. 
	 * @return int (posición dentro del árbol organizativo - si no está -1)
	 **/
	int getPosicion(Funcionalidad::IdFunc func) const;

	/**
	 * @brief Obtiene una función desde una posición dada del árbol.
	 *
	 * @param pos Posición en el árbol de la categoría o nodo principal.
	 * @param subpos Posición en la categoría de la función solicitada.
	 * @return Identificador de la función solicitada.
	 **/
	Funcionalidad::IdFunc getFuncFromPos(int pos, int subpos) const;

	/**
	 * @brief Obtiene el nombre de un nodo dado su número de orden.
	 *
	 * @param orden 1 -> el primer nodo, ...
	 * @return Cadena de texto.
	 **/
	 const char * getNombreNodo(size_t orden) const;

	 /**
	  * @brief Obtiene los contenidos de un nodo dado su número de orden.
	  *
	  * @param orden 1 -> el primer nodo, ...
	  * @return Vector de funcionalidades.
	  **/
	 std::vector<Funcionalidad::IdFunc> getContenidoNodo(size_t orden) const;

	/**
	 * @brief Devuelve el tamano del árbol (número de nodos)
	 *
	 * @return size_t
	 **/
	size_t tamano() const;

	/**
	 * @brief Alias para #getFuncFromPos.
	 *
	 * @see #getFuncFromPos
	 **/
	inline Funcionalidad::IdFunc operator()(int pos, int subpos) const {
		return getFuncFromPos(pos, subpos);
	}

private:
	/**
	 * @brief Nodo de la estructura rara que será utilizada.
	 */
	struct NodoAF {

		/**
		 * @brief Crea un nodo asignado las propiedades indicadas.
		 *
		 * @param funcs Array de funciones.
		 * @param nFuncs Número de funciones (longitud del array).
		 * @param nombreNodo Nombre del nodo (@c NULL si es colección de principales)
		 **/
		NodoAF(Funcionalidad::IdFunc * funcs, size_t nFuncs, std::string * nombreNodo) : funcs(funcs), nFuncs(nFuncs), nombreNodo(nombreNodo){};

		/**
		 * @brief Crea un nodo asignado las propiedades indicadas.
		 *
		 * @param funcs Array de funciones.
		 * @param nFuncs Número de funciones (longitud del array).
		 * @param nombreNodo Nombre del nodo.
		 **/
		NodoAF(Funcionalidad::IdFunc * funcs, size_t nFuncs, const char * nombreNodo) : funcs(funcs), nFuncs(nFuncs), nombreNodo(new std::string(nombreNodo)){};

		/**
		 * @brief Otro constructor que asume que nombreNodo es NULL.
		 *
		 * @param funcs Array de funciones.
		 * @param nFuncs Número de funciones.
		 **/
		NodoAF(Funcionalidad::IdFunc * funcs, size_t nFuncs) : funcs(funcs), nFuncs(nFuncs), nombreNodo(NULL){};

		/**
		 * @brief Crea un nodo con valores por defecto.
		 *
		 **/
		NodoAF() : funcs(NULL), nFuncs(0), nombreNodo(NULL) {};

		/**
		 * @brief Destruye el nodo destruyendo a todos sus hijos.
		 *
		 **/
		~NodoAF(){ delete [] funcs; delete nombreNodo; }
		
		/**
		 * Array de funcionalidades para el nodo en cuestión.
		 */
		Funcionalidad::IdFunc * funcs;

		/**
		 * Número de funcionalidades en el nodo en cuestión.
		 */
		size_t nFuncs;
		
		/**
		 * Nombre del nodo si no es hoja (en caso contrario sólo
		 * importará el nombre de la función y debe ser @c NULL).
		 */
		std::string * nombreNodo;
	};

	/**
	 * @brief Lista de nodos y funciones.
	 **/
	NodoAF ** _lista;
	size_t _nNodos;

	/**
	 * @brief Modelo de árbol.
	 **/
	NodoAF ** _modelo;
	size_t _tamModelo;

	/**
	 * @brief Genera el modelo de árbol.
	 *
	 **/
	void generarModelo();
};

#endif // ARBOLFUNCS_H

