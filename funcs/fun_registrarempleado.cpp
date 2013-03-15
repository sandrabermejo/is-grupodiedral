/**
 * @file fun_registrarempleado.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Funcionalidad para registrar empleados.
 */

#include "fun_registrarempleado.h"
#include "fun_consultarfichaempleado.h"

// Pantallas que utiliza
#include "FRegistrarEmpleado.h"

FunRegistrarEmpleado::FunRegistrarEmpleado(FunConsultarFichaEmpleado * empleados) : _frame(NULL), _empleados(empleados) {
	// Nada
}


QWidget * FunRegistrarEmpleado::getQtWidget(QWidget * parent){
	if (_frame == NULL){
		_frame = new FRegistrarEmpleado(_empleados, parent);
	}

	return _frame;
}

std::string FunRegistrarEmpleado::getNombreFunc() const {
	return "Registrar empleado";
}

bool FunRegistrarEmpleado::activo() const {
	return _frame != NULL;
}
