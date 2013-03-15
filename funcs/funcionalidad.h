/**
 * @file funcionalidad.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase que centraliza el soporte a las funcionalidades de la aplicación.
 */

#ifndef FUNCIONALIDAD_H
#define FUNCIONALIDAD_H

// Biblioteca estándar C++
#include <map>

#include "qfunc.h"

// Alusión a usuario sin definirlo
class Usuario;

/**
 * @brief Clase que maneja las funcionalidades de la aplicación.
 *
 */
class Funcionalidad {
public:

	/**
	 * @brief Constructor con indicador de configuración local.
	 *
	 * @param locale Identificador ISO de la ubicación local.
	 */
	Funcionalidad(const char * locale = NULL);
	
	/**
	 * @brief Enumerados para referirse a las funcionalidades del programa.
	 */
	enum IdFunc {
		INICIO,				// Pseudo-funcionalidad de inicio
		CONSULTAR_PLAN_VUELO,		// Consultar el plan de vuelo
		BAJA_CLIENTE,			// Dar de baja a un cliente
		ORG_LABORAL,			// Establecer organización laboral
		PROGRAMAR_REVISION,		// Programa una revisión
		REGISTRAR_MATERIAL,		// Registra la entrada de material
		CONSULTA_NOMINA,		// Consultar nómina
		EDITAR_EMPLEADO,		// Editar empleado
		EDITAR_INFO_ECONOMICA, 		// Editar información económica
		MODIFICAR_ITEMS_INVENTARIO,	// Modificar items inventario
		PROGRAMAR_HORARIOS,		// Programar horarios
		PROGRAMAR_OFERTA,		// Programar oferta
		REGISTRAR_EMPLEADO,		// Registrar empleado
		VERIFICAR_REGISTRO,		// Verificar empleado
		INTRODUCIR_PLAN_VUELO,		// Introducir plan vuelo
		BAJA_EMPLEADO,			// Baja de empleado
		CONSULTAR_INVENTARIO,		// Consultar inventario
		CONSULTAR_EMPLEADO,		// Consultar ficha empleado
		EFECTUAR_EMBARQUE,		// Efectuar embarque
		CONFIG_NOMINA			// Configura la nómina
	};

	/**
	 * @brief Devuelve un array con todos los identificadores de funcionalidades del programa.
	 * 
	 */
	static std::vector<IdFunc> getFuncIds();

	/**
	 * @brief Devuelve la función correpondiente al identificador dado.
	 *
	 * @param id Identificador de la función requerida.
	 *
	 * @return Puntero a una función de la aplicación (modo Qt).
	 **/
	QFunc * getFunc(IdFunc id);

	/**
	 * @brief Fija el contexto de las funcionalidades.
	 *
	 * @param usuario Usuario que requiere las funcionalidades.
	 * @param parent Componente padre de los controles de la funcionalidades.
	 * @return void
	 **/
	void setContexto(const Usuario * usuario, QWidget * parent);

	/**
	 * @brief Destructor.
	 *
	 **/
	~Funcionalidad();

private:
	/**
	 * Almacen de funcionalidades ya instanciadas
	 */
	std::map<IdFunc, QFunc *> _funcs;

	/**
	 * Padre para aquellas funciones que requieran padre al inicio
	 * (lo cual puede es cuestionable)
	 */
	QWidget * _parent;

	/**
	 * Usuario para aquellas funciones que lo requieran.
	 */
	const Usuario * _usuario;
};

#endif // FUNCIONALIDAD_H
