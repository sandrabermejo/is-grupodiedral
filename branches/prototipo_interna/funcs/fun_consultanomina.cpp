/****************************************************************************
** Consulta la nómina de un mes seleccionado.
**
** fun_consultanomina.cpp
*****************************************************************************/

#include "fun_consultanomina.h"

FunConsultaNomina::FunConsultaNomina(QWidget* parent): QFrame(parent) {
	setupUi(this);
	_activo = false;
}

std::string FunConsultaNomina::getNombreFunc() const {
	return "Consulta nómina";
}

QWidget * FunConsultaNomina::getQtWidget(QWidget *){
	_activo = true;
	return this;
}

bool FunConsultaNomina::activo() const {
	return _activo;
}
