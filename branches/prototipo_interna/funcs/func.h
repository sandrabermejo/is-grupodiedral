/****************************************************************************
** Esta clase define una interfaz para todas las funcionalidades que puede
** manejar la aplicación.
**
** func.h
*****************************************************************************/

#ifndef FUNC_H
#define FUNC_H

#include <stdexcept>

/**
 * @brief Clase abstracta general para todos los casos de uso o funcionalidades de la
 * aplicación.
 */
class Func {
public:
	/**
	 * @brief Devuelve el nombre de la función.
	 *
	 * @return El nombre de la función.
	 */
	virtual std::string getNombreFunc() const = 0;

	/**
	 * @brief Destructor virtual para Func.
	 *
	 **/
	virtual ~Func(){};
};

/**
 * @brief Excepción que se prevee podrían lanzar las funciones al fallar su proceso
 * de carga.
 */
class CargaFunc_error : public std::runtime_error {
public:
	/**
	 * @brief Constructor de la excepción.
	 * 
	 * @param func Puntero a la función que reporta el error.
	 * @param what Explicación del error.
	 * 
 	 */
	explicit CargaFunc_error(const Func  * func, const std::string& what) : runtime_error(what), _func(func){};

	/**
	 * @brief Obtiene el mensaje de error.
	 *
	 * @return El mensaje de error.
	 */
	virtual const char * what() const throw();
private:
	const Func * _func;
};

#endif // FUNC_H
