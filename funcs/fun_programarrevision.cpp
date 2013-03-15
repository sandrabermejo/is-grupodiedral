/****************************************************************************
** Pseudo-funcionalidad de información al inicio
**
** fun_programarrevision.cpp
*****************************************************************************/

#include "fun_programarrevision.h"

// Pantallas que utiliza
#include "FProgRevisionMaterial.h"

QWidget * FunProgramarRevision::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FProgRevisionMaterial(parent);

	return _frame;
}

std::string FunProgramarRevision::getNombreFunc() const {
	return "Programar revisión";
}

bool FunProgramarRevision::activo() const {
	return _frame != NULL;
}
