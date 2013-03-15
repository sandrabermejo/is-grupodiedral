/****************************************************************************
** Funcionalidad para consultar el plan de vuelo
**
** fun_consultarplanvuelo.cpp
*****************************************************************************/

#ifndef FUN_CONSULTARPLANVUELO_H
#define FUN_CONSULTARPLANVUELO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad para la definición de la organización laboral.
 * 
 */
class FunConsultarPlanVuelo : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunConsultarPlanVuelo() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_CONSULTARPLANVUELO_H
