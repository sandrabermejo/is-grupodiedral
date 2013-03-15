/**
 * @file credenciales.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase de información sobre privilegios/credenciales.
 */

#ifndef CREDENCIALES_H
#define CREDENCIALES_H

// Biblioteca estándar C++
#include <deque>

#include "funcs/funcionalidad.h"

/**
 * @brief Clase que representa un conjunto de credenciales, que por ejemplo posee un usuario o
 * requiere una determinada función.
 */
class Credenciales {
public:
	/**
	 * @brief Constructor por defecto de la clase Credenciales.
	 *
	 * @param lastFunc Última funcionalidad que será pasada como parámetro. Es vital se pase
	 * 	lastFunc como parámetro posteriormente pues en caso contrario el programa abortará.
	 * @param ... Parámetros variables finalizados por lastFunc que indican las funcionalidades
	 * 	que soportan las credenciales.
	 *
	 */
	Credenciales(Funcionalidad::IdFunc lastFunc, ...);

	/**
	 * Devuelve cierto si el paquete de credenciales habilita a su
	 * poseedor para realizar la funcionalidad dada.
	 * 
	 * @param func Funcionalidad sobre la que se cuestiona.
	 *
	 * @return @c true si el poseedor está habilitado para ello.
	 */
	bool puede(Funcionalidad::IdFunc func) const;
private:
	/**
	 * Almacén de las funcionalidades que aporta el paquete de credenciales.
	 *
	 * Tal vez no es muy conveniente pero es un prototipo.
	 */
	std::deque<Funcionalidad::IdFunc> _funcs;
};

#endif // CREDENCIALES_H
