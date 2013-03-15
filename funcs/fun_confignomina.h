/****************************************************************************
** Esta función permite modificar la nómina de un empleado
**
** fun_confignomina.h
*****************************************************************************/

#ifndef FUN_CONFIGNOMINA_H
#define FUN_CONFIGNOMINA_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Esta función permite modificar la nómina de un empleado.
 * 
 */
class FunConfigNomina : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunConfigNomina() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_CONFIGNOMINA_H
