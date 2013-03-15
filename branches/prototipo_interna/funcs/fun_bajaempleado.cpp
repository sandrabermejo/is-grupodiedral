/****************************************************************************
** Esta función permite dar de baja a un empleado del sistema de la empresa
**
** fun_bajaempleado.cpp
*****************************************************************************/

#include "fun_bajaempleado.h"

// Pantallas que utiliza
#include "FDardeBajaEmpleado.h"

QWidget * FunBajaEmpleado::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FDardeBajaEmpleado(parent);

	return _frame;
}

std::string FunBajaEmpleado::getNombreFunc() const {
	return "Dar de baja empleado";
}

bool FunBajaEmpleado::activo() const {
	return _frame != NULL;
}
