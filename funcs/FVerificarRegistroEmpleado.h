/****************************************************************************
** Esta función permite a los empleados del departamento de intevención verificar la cuenta creada para un nuevo usuario de la aplicación de la compañía.
**
** FVerificarRegistroEmpleado.h
*****************************************************************************/

#ifndef FVERIFICARREGISTROEMPLEADO_H
#define FVERIFICARREGISTROEMPLEADO_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fverificarregistroempleado.h"


/**
 * @brief Esta función permite a los empleados del departamento de intevención verificar la cuenta creada para un nuevo usuario de la aplicación de la compañía.
 *
 **/
class FVerificarRegistroEmpleado : public QFrame, public Ui::FVerificarregistroempleado {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FVerificarRegistroEmpleado(QWidget * parent = NULL);
};

#endif
