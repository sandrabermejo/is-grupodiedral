/****************************************************************************
** Esta función permite al personal administrativo programar el horario de un empleado
**
** fun_programarhorarios.h
*****************************************************************************/

#ifndef FUN_PROGRAMARHORARIOS_H
#define FUN_PROGRAMARHORARIOS_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Esta función permite al personal administrativo programar el horario de un empleado.
 * 
 */
class FunProgramarHorarios : public QFunc {
public:

	/**
	 * Constructor por defecto.
	 */
	FunProgramarHorarios() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_PROGRAMARHORARIOS_H
