/****************************************************************************
** Esta función permite al usuario modificar diversos datos de los items almacenados en el inventario de la compañía
**
** fun_modificarinventario.h
*****************************************************************************/

#ifndef FUN_MODIFICARINVENTARIO_H
#define FUN_MODIFICARINVENTARIO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Esta función permite al usuario modificar diversos datos de los items almacenados en el inventario de la compañía.
 * 
 */
class FunModificarInventario : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunModificarInventario() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_MODIFICARINVENTARIO_H
