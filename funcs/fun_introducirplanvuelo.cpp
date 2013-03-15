/****************************************************************************
** Esta función permite añadir un nuevo vuelo de la compañía
**
** fun_introducirplanvuelo.cpp
*****************************************************************************/

#include "fun_introducirplanvuelo.h"

// Pantallas que utiliza
#include "FIntroducirPlanVuelo.h"

QWidget * FunIntroducirPlanVuelo::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FIntroducirPlanVuelo(parent);

	return _frame;
}

std::string FunIntroducirPlanVuelo::getNombreFunc() const {
	return "Introducir plan de vuelo";
}

bool FunIntroducirPlanVuelo::activo() const {
	return _frame != NULL;
}
