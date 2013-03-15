/****************************************************************************
** Esta funcion permite al personal administrativo a€adir un nuevo empleado a la base de datos de la compa€ia.
**
** FRegistrarEmpleado.h
*****************************************************************************/

#ifndef FREGISTRAREMPLEADO_H
#define FREGISTRAREMPLEADO_H

// Biblioteca Qt
#include <QFrame>
#include <QDialog>

#include "ui_fregistrarempleado.h"

// Declaraciones aplazadas
class FunConsultarFichaEmpleado;

/**
 * @brief Esta funcion permite al personal administrativo añadir un nuevo empleado a la base de datos de la compa€ia.
 *
 **/
class FRegistrarEmpleado : public QFrame, public Ui::FRegistrarempleado {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param empleados Puntero a la función de gestión de empleados.
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FRegistrarEmpleado(FunConsultarFichaEmpleado * empleados, QWidget * parent = NULL);
	
signals:
	/**
	 * @brief Señal que indica que el control ha terminado para quien lo quiera recibir.
	 *
	 * @param code Código de aceptación.
	 * @return void
	 **/
	void heTerminado(QDialog::DialogCode code);

private:
	FunConsultarFichaEmpleado * _empleados;

private slots:
	void clickCancelar(bool);
	void clickRegistrar(bool);
};

#endif
