/****************************************************************************
** Esta función permite dar de baja a un cliente de nuestro sistema
**
** fun_bajacliente.cpp
*****************************************************************************/

#include "fun_bajacliente.h"

// Pantallas que utiliza
#include "FDardeBajaCliente.h"

QWidget * FunBajaCliente::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FDardeBajaCliente(parent);

	return _frame;
}

std::string FunBajaCliente::getNombreFunc() const {
	return "Dar de baja cliente";
}

bool FunBajaCliente::activo() const {
	return _frame != NULL;
}
