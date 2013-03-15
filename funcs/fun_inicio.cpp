/****************************************************************************
** Pseudo-funcionalidad de información al inicio
**
** fun_inicio.cpp
*****************************************************************************/

#include "fun_inicio.h"

// Pantallas que utiliza
#include "FInicio.h"

QWidget * FunInicio::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FInicio(parent);

	return _frame;
}

std::string FunInicio::getNombreFunc() const {
	return "[Inicio]";
}

bool FunInicio::activo() const {
	return _frame != NULL;
}
