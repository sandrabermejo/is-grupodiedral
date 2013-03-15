/****************************************************************************
** Esta función permite modificar la nómina de un empleado
**
** fun_confignomina.cpp
*****************************************************************************/

#include "fun_confignomina.h"

// Pantallas que utiliza
#include "FConfigNomina.h"

QWidget * FunConfigNomina::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FConfigNomina(parent);

	return _frame;
}

std::string FunConfigNomina::getNombreFunc() const {
	return "Configurar nómina";
}

bool FunConfigNomina::activo() const {
	return _frame != NULL;
}
