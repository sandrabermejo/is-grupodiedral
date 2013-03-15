/****************************************************************************
** Permite editar la ficha de empleado.
**
** FEditaEmpleado.h
*****************************************************************************/

#ifndef FEDITAEMPLEADO_H
#define FEDITAEMPLEADO_H

// Biblioteca Qt
#include <QFrame>

#include "ui_feditaempleado.h"


/**
 * @brief Permite editar la ficha de empleado.
 *
 **/
class FEditaEmpleado : public QFrame, public Ui::FEditaEmpleado {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FEditaEmpleado(QWidget * parent = NULL);
};

#endif
