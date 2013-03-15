/****************************************************************************
** Funcionalidad para consultar el plan de vuelo
**
** fun_consultarplanvuelo.h
*****************************************************************************/

#include "fun_consultarplanvuelo.h"

// Pantallas que utiliza
#include "FBuscaPlan.h"

QWidget * FunConsultarPlanVuelo::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FBuscaPlan(parent);

	return _frame;
}

std::string FunConsultarPlanVuelo::getNombreFunc() const {
	return "Consultar plan de vuelo";
}

bool FunConsultarPlanVuelo::activo() const {
	return _frame != NULL;
}
