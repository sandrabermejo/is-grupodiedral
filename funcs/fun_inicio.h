/****************************************************************************
** Pseudo-funcionalidad de información al inicio
**
** fun_inicio.h
*****************************************************************************/

#ifndef FUN_INICIO_H
#define FUN_INICIO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad-pantalla de inicio.
 * 
 */
class FunInicio : public QFunc {
public:

	/**
	 * Constructor por defecto.
	 */
	FunInicio() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_INICIO_H
