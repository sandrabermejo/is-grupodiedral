/****************************************************************************
** Funcionalidad para programar una revisión (mantenimiento)
**
** fun_programarrevision.h
*****************************************************************************/

#ifndef FUN_PROGRAMARREVISION_H
#define FUN_PROGRAMARREVISION_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad-pantalla de inicio.
 * 
 */
class FunProgramarRevision : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunProgramarRevision() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_PROGRAMARREVISION_H
