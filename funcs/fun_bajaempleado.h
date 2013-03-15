/****************************************************************************
** Esta función permite dar de baja a un empleado del sistema de la empresa
**
** fun_bajaempleado.h
*****************************************************************************/

#ifndef FUN_BAJAEMPLEADO_H
#define FUN_BAJAEMPLEADO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Esta función permite dar de baja a un empleado del sistema de la empresa.
 * 
 */
class FunBajaEmpleado : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunBajaEmpleado() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_BAJAEMPLEADO_H
