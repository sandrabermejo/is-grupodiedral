/****************************************************************************
** Esta función permite dar de baja a un cliente de nuestro sistema
**
** fun_bajacliente.cpp
*****************************************************************************/

#ifndef FUN_BAJACLIENTE_H
#define FUN_BAJACLIENTE_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Esta función permite dar de baja a un cliente de nuestro sistema.
 * 
 */
class FunBajaCliente : public QFunc {
public:

	/**
	 * Constructor por defecto.
	 */
	FunBajaCliente() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_BAJACLIENTE_H
