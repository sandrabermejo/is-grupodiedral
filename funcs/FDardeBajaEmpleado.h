/****************************************************************************
** Esta función permite dar de baja a un empleado del sistema de la empresa
**
** FDardeBajaEmpleado.h
*****************************************************************************/

#ifndef FDARDEBAJAEMPLEADO_H
#define FDARDEBAJAEMPLEADO_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fdardebajaempleado.h"


/**
 * @brief Esta función permite dar de baja a un empleado del sistema de la empresa
 *
 **/
class FDardeBajaEmpleado : public QFrame, public Ui::FDardebajaempleado {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FDardeBajaEmpleado(QWidget * parent = NULL);
};

#endif
