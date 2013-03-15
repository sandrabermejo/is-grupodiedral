/****************************************************************************
** Funcionalidad para registrar entradas de material
**
** fun_registrarmaterial.h
*****************************************************************************/

#include "fun_registrarmaterial.h"

// Pantallas que utiliza
#include "FRegistrarMaterial.h"

QWidget * FunRegistrarMaterial::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FRegistrarMaterial(parent);

	return _frame;
}

std::string FunRegistrarMaterial::getNombreFunc() const {
	return "Registrar material";
}

bool FunRegistrarMaterial::activo() const {
	return _frame != NULL;
}
