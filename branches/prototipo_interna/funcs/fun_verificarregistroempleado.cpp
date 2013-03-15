/****************************************************************************
** Funcionalidad para verificar registros de empleados
**
** fun_verificarregistroempleado.h
*****************************************************************************/

#include "fun_verificarregistroempleado.h"

// Pantallas que utiliza
#include "FVerificarRegistroEmpleado.h"

QWidget * FunVerificarRegistroEmpleado::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FVerificarRegistroEmpleado(parent);

	return _frame;
}

std::string FunVerificarRegistroEmpleado::getNombreFunc() const {
	return "Verificar registro empleado";
}

bool FunVerificarRegistroEmpleado::activo() const {
	return _frame != NULL;
}
