/****************************************************************************
** Funcionalidad para la definición de la organización laboral
**
** fun_orglaboral.h
*****************************************************************************/

#ifndef FUN_ORGLABORAL_H
#define FUN_ORGLABORAL_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad para la definición de la organización laboral.
 * 
 */
class FunOrgLaboral : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunOrgLaboral() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_ORGLABORAL_H
