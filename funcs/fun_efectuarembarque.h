/****************************************************************************
** Funcionalidad para controlar el embarque de viajeros
**
** fun_efectuarembarque.h
*****************************************************************************/

#ifndef FUN_EFECTUAREMBARQUE_H
#define FUN_EFECTUAREMBARQUE_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad para controlar el embarque de viajeros.
 * 
 */
class FunEfectuarEmbarque : public QFunc {
public:

	/**
	 * Constructor por defecto.
	 */
	FunEfectuarEmbarque() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_EFECTUAREMBARQUE_H
