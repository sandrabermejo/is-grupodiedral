/**
 * @file usuario.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase identificadora del usuario.
 */

#ifndef USUARIO_H
#define USUARIO_H

// Biblioteca C++
#include <string>

#include "credenciales.h"

/**
 * @brief Clase identificadora de usuario.
 *
 */
class Usuario {
public:
	/**
	 * @brief Contructor de un objeto de usuario a partir de su nombre de usuario.
	 *
	 * @param nombre Nombre de usuario.
	 **/
	Usuario(std::string nombre);

	/**
	 * @brief Solicita acceso en nombre del usuario representado en el objeto.
	 *
	 * @param clave Contraseña del usuario.
	 * @return bool
	 **/
	bool solicitarAcceso(std::string clave);

	/**
	 * @brief Devuelve el nombre del usuario.
	 *
	 * @return string
	 **/
	inline std::string getNombreUsuario() const { return _nombre; };

	/**
	 * @brief Devuelve el nombre de pila.
	 *
	 * @return string
	 **/
	inline std::string getNombrePila() const { return _nombre; };

	/**
	 * @brief Devuelve el apellido.
	 *
	 * @return string
	 **/
	inline std::string getApellidos() const { return _apellidos; };
	
	/**
	 * @brief Devuelve el puesto de trabajo como texto.
	 *
	 * @return :string
	 **/
	inline std::string getPuesto() const { return _puesto; };

	/**
	 * @brief Informa de si el usario puede hacer uso de dada funcionalidad.
	 *
	 * @param func Dada funcionalidad.
	 * @return bool
	 **/
	inline bool puede(Funcionalidad::IdFunc func) const { return _credenciales->puede(func); };

	/**
	 * @brief Comprueba localmente que el usuario ha sido aceptado e identificado por el sistema.
	 *
	 * @return bool
	 **/
	bool esValido() const;

private:
	/**
	 * @brief Nombre de usuario almacenado.
	 */
	std::string _nombre;

	/**
	 * @brief Nombre de pila del usuario.
	 */
	std::string _nombrePila;

	/**
	 * @brief Apellidos del usuario.
	 */
	std::string _apellidos;

	/**
	 * @brief Puesto de trabajo.
	 */
	std::string _puesto;

	/**
	 * @brief Credenciales del usuario.
	 *
	 **/
	Credenciales * _credenciales;
};

#endif // USUARIO_H
