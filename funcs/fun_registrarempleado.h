/**
 * @file fun_registrarempleado.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Funcionalidad para registrar empleados.
 */

#ifndef FUN_REGISTRAREMPLEADO_H
#define FUN_REGISTRAREMPLEADO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

// Declaraciones aplazadas
class FunConsultarFichaEmpleado;

/**
 * @brief Funcionalidad para registrar empleados.
 *
 * @see FunConsultarFichaEmpleado
 * 
 */
class FunRegistrarEmpleado : public QFunc {
public:

	/**
	 * Constructor por defecto.
	 */
	FunRegistrarEmpleado(FunConsultarFichaEmpleado * empleados);

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;

	FunConsultarFichaEmpleado * _empleados;
};

#endif // FUN_REGISTRAREMPLEADO_H
