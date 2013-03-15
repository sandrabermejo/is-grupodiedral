/****************************************************************************
** Esta función permite al usuario ver el inventario por pantalla
**
** fun_consultarinventario.cpp
*****************************************************************************/

#ifndef FUN_CONSULTARINVENTARIO_H
#define FUN_CONSULTARINVENTARIO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Esta función permite al usuario ver el inventario por pantalla.
 * 
 */
class FunConsultarInventario : public QFunc {
public:

	/**
	 * Constructor por defecto.
	 */
	FunConsultarInventario() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

private:
	QFrame * _frame;
};

#endif // FUN_CONSULTARINVENTARIO_H
