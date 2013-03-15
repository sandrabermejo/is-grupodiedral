/****************************************************************************
** Esta función permite al empleado de administración encargado en programa ofertas incluir una de estas en el sistema de la empresa
**
** fun_programaroferta.h
*****************************************************************************/

#ifndef FUN_PROGRAMAROFERTA_H
#define FUN_PROGRAMAROFERTA_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad-pantalla de inicio.
 * 
 */
class FunProgramarOferta : public QFunc {
public:

	/**
	 * Constructor por defecto.
	 */
	FunProgramarOferta() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_PROGRAMAROFERTA_H
