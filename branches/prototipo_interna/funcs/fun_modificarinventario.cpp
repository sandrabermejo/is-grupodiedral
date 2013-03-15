/****************************************************************************
** Esta función permite al usuario modificar diversos datos de los items almacenados en el inventario de la compañía.
**
** fun_modificarinventario.cpp
*****************************************************************************/

#include "fun_modificarinventario.h"

// Pantallas que utiliza
#include "FModificarItemsInventario.h"

QWidget * FunModificarInventario::getQtWidget(QWidget * parent){
	if (_frame == NULL)
		_frame = new FModificarItemsInventario(parent);

	return _frame;
}

std::string FunModificarInventario::getNombreFunc() const {
	return "Modificar inventario";
}

bool FunModificarInventario::activo() const {
	return _frame != NULL;
}
