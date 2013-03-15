/****************************************************************************
** Esta funcion permite modificar la nómina de un empleado
**
** FConfigNomina.h
*****************************************************************************/

#ifndef FCONFIGNOMINA_H
#define FCONFIGNOMINA_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fconfignomina.h"


/**
 * @brief Esta funcion permite modificar la nómina de un empleado.
 *
 **/
class FConfigNomina : public QFrame, public Ui::FConfignomina {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FConfigNomina(QWidget * parent = NULL);
};

#endif
