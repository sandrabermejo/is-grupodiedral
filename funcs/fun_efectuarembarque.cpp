/****************************************************************************
** Funcionalidad para controlar el embarque de viajeros
**
** fun_efectuarembarque.cpp
*****************************************************************************/

#include "fun_efectuarembarque.h"

// Pantallas que utiliza
#include "FEfectuarEmbarque.h"

QWidget * FunEfectuarEmbarque::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FEfectuarEmbarque(parent);

	return _frame;
}

std::string FunEfectuarEmbarque::getNombreFunc() const {
	return "Efectuar embarque";
}

bool FunEfectuarEmbarque::activo() const {
	return _frame != NULL;
}
