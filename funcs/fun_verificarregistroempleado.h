/****************************************************************************
** Funcionalidad para verificar registros de empleados
**
** fun_verificarregistroempleado.cpp
*****************************************************************************/

#ifndef FUN_VERIFICARREGISTROEMPLEADO_H
#define FUN_VERIFICARREGISTROEMPLEADO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad para verificar registros de empleados.
 * 
 */
class FunVerificarRegistroEmpleado : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunVerificarRegistroEmpleado() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

private:
	QFrame * _frame;
};

#endif // FUN_VERIFICARREGISTROEMPLEADO_H
