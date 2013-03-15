/****************************************************************************
** Funcionalidad para editar la información económica
**
** fun_editarinfoeconomica.cpp
*****************************************************************************/

#include "fun_editarinfoeconomica.h"

// Pantallas que utiliza
#include "FEditarInformacionEconomica.h"

QWidget * FunEditarInfoEconomica::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FEditarInformacionEconomica(parent);

	return _frame;
}

std::string FunEditarInfoEconomica::getNombreFunc() const {
	return "Editar información económica";
}

bool FunEditarInfoEconomica::activo() const {
	return _frame != NULL;
}
