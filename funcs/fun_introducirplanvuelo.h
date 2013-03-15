/****************************************************************************
** Esta función permite añadir un nuevo vuelo de la compañía
**
** fun_introducirplanvuelo.h
*****************************************************************************/

#ifndef FUN_INTRODUCIRPLANVUELO_H
#define FUN_INTRODUCIRPLANVUELO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Esta función permite añadir un nuevo vuelo de la compañía.
 * 
 */
class FunIntroducirPlanVuelo : public QFunc {
public:

	/**
	 * Constructor por defecto.
	 */
	FunIntroducirPlanVuelo() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_INTRODUCIRPLANVUELO_H
