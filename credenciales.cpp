/**
 * @file credenciales.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase de información sobre privilegios/credenciales.
 */

// Biblioteca estándar C++ (C)
#include <cstdarg>

#include "credenciales.h"


Credenciales::Credenciales(Funcionalidad::IdFunc lastFunc, ...){
	/*
	 * Prepara la lectura de los parámetros variables.
	 * Se convierten en int y luego hay que reconvertirlos
	 * a Funcionalidad. Con C++11 quedaría mejor.
	 */

	va_list param;
	va_start(param, lastFunc);

	Funcionalidad::IdFunc func = (Funcionalidad::IdFunc) va_arg(param, int);
	_funcs.push_back(func);
	
	// Añade las autorizaciones al array interno
	while (func != lastFunc){
		func = (Funcionalidad::IdFunc) va_arg(param, int);
		_funcs.push_back(func);
	}
};

bool Credenciales::puede(Funcionalidad::IdFunc func) const {
	// Implementación fea para dejar claro que es un prototipo
	bool puede = false;
	
	for(std::size_t i = 0; i < _funcs.size() && !puede; i++)
		if (_funcs[i] == func)
			puede = true;

	return puede;
};
