/****************************************************************************
** Esta función permite al usuario ver el inventario por pantalla
**
** fun_consultarinventario.h
*****************************************************************************/

#include "fun_consultarinventario.h"

// Pantallas que utiliza
#include "FConsultarInventario.h"

QWidget * FunConsultarInventario::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FConsultarInventario(parent);

	return _frame;
}

std::string FunConsultarInventario::getNombreFunc() const {
	return "Consultar inventario";
}

bool FunConsultarInventario::activo() const {
	return _frame != NULL;
}
