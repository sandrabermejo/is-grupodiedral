/****************************************************************************
** Permite editar la ficha de empleado.
**
** fun_editaempleado.h
*****************************************************************************/

#ifndef FUN_EDITAEMPLEADO_H
#define FUN_EDITAEMPLEADO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad que permite editar la ficha de empleado.
 * 
 */
class FunEditaEmpleado : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunEditaEmpleado() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_EDITAEMPLEADO_H
