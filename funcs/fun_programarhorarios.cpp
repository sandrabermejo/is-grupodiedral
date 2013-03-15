/****************************************************************************
** Esta función permite al personal administrativo programar el horario de un empleado
**
** fun_programarhorarios.cpp
*****************************************************************************/

#include "fun_programarhorarios.h"

// Pantallas que utiliza
#include "FProgramarHorarios.h"

QWidget * FunProgramarHorarios::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FProgramarHorarios(parent);

	return _frame;
}

std::string FunProgramarHorarios::getNombreFunc() const {
	return "Programar horarios";
}

bool FunProgramarHorarios::activo() const {
	return _frame != NULL;
}
