/****************************************************************************
** Esta función permite al empleado de administración encargado en programa ofertas incluir una de estas en el sistema de la empresa
**
** fun_programaroferta.cpp
*****************************************************************************/

#include "fun_programaroferta.h"

// Pantallas que utiliza
#include "FProgramarOferta.h"

QWidget * FunProgramarOferta::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FProgramarOferta(parent);

	return _frame;
}

std::string FunProgramarOferta::getNombreFunc() const {
	return "Programar oferta";
}

bool FunProgramarOferta::activo() const {
	return _frame != NULL;
}
