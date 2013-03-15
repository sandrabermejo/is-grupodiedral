/****************************************************************************
** Funcionalidad para la definición de la organización laboral
**
** fun_orglaboral.h
*****************************************************************************/

#include "fun_orglaboral.h"

// Pantallas que utiliza
#include "FOrgLaboral.h"

QWidget * FunOrgLaboral::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FOrgLaboral(parent);

	return _frame;
}

std::string FunOrgLaboral::getNombreFunc() const {
	return "Organización laboral";
}

bool FunOrgLaboral::activo() const {
	return _frame != NULL;
}
