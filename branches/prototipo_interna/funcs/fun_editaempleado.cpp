/****************************************************************************
** Permite editar la ficha de empleado.
**
** fun_editaempleado.cpp
*****************************************************************************/

#include "fun_editaempleado.h"

// Pantallas que utiliza
#include "FEditaEmpleado.h"

QWidget * FunEditaEmpleado::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FEditaEmpleado(parent);

	return _frame;
}

std::string FunEditaEmpleado::getNombreFunc() const {
	return "Editar empleado";
}

bool FunEditaEmpleado::activo() const {
	return _frame != NULL;
}
